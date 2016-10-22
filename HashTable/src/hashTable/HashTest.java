package hashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

/**
 * 
 * @author Jinghao Li 104526143
 *
 */
public class HashTest {
	public static void main(String arg[]) {
		int num = 4000000;
		HashTest hashTest = new HashTest();
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
		long startTime = System.currentTimeMillis();
		hashTest.insert(hashtable, num);
		//System.out.println((System.currentTimeMillis() - startTime) / (float) num);
		long startTime1 = System.currentTimeMillis();
		hashTest.search(hashtable, num);
		System.out.println((System.currentTimeMillis() - startTime1) / (float) num);
	}

	// create a random string
	public static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public void insert(Hashtable<String, Integer> hTable, int num) {

		for (int i = 0; i < num; i++) {
			hTable.put(HashTest.getSaltString(), i);
		}
	}

	public void search(Hashtable<String, Integer> hTable, int num) {
		for (int i = 0; i < num; i++) {
			String s = HashTest.getSaltString();
			if (hTable.containsKey(s)) {
				hTable.remove(s);
			}
		}

	}

}
