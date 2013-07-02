package com.baidu.zeus.security;

import android.os.Environment;
import android.os.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
/* loaded from: classes.dex */
public class SystemKeyStore {
    private static final String KEY_FILE_EXTENSION = ".sks";
    private static final String SYSTEM_KEYSTORE_DIRECTORY = "misc/systemkeys";
    private static SystemKeyStore mInstance = new SystemKeyStore();

    private SystemKeyStore() {
    }

    public static SystemKeyStore getInstance() {
        return mInstance;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public String generateNewKeyHexString(int i, String str, String str2) {
        return toHexString(generateNewKey(i, str, str2));
    }

    public byte[] generateNewKey(int i, String str, String str2) {
        File keyFile = getKeyFile(str2);
        if (keyFile.exists()) {
            throw new IllegalArgumentException();
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance(str);
        keyGenerator.init(i, SecureRandom.getInstance("SHA1PRNG"));
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        try {
            if (!keyFile.createNewFile()) {
                throw new IllegalArgumentException();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(keyFile);
            fileOutputStream.write(encoded);
            fileOutputStream.flush();
            fileOutputStream.close();
            FileUtils.setPermissions(keyFile.getName(), 384, -1, -1);
            return encoded;
        } catch (IOException e) {
            return null;
        }
    }

    private File getKeyFile(String str) {
        return new File(new File(Environment.getDataDirectory(), SYSTEM_KEYSTORE_DIRECTORY), str + KEY_FILE_EXTENSION);
    }

    public String retrieveKeyHexString(String str) {
        return toHexString(retrieveKey(str));
    }

    public byte[] retrieveKey(String str) {
        File keyFile = getKeyFile(str);
        if (!keyFile.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(keyFile);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public void deleteKey(String str) {
        File keyFile = getKeyFile(str);
        if (!keyFile.exists()) {
            throw new IllegalArgumentException();
        }
        keyFile.delete();
    }
}
