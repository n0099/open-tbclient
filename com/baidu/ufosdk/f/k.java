package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.support.media.ExifInterface;
import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
@SuppressLint({"InlinedApi"})
/* loaded from: classes21.dex */
public final class k {
    private static String a() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(ExifInterface.LONGITUDE_WEST, false));
        stringBuffer.append(a("9", true));
        stringBuffer.append(random.nextInt(1) + 1);
        stringBuffer.append(a("Y", true));
        stringBuffer.append("abe");
        stringBuffer.append(a("y", true));
        stringBuffer.append("1a88");
        return stringBuffer.toString();
    }

    @SuppressLint({"TrulyRandom"})
    public static String a(String str) {
        byte[] bArr = null;
        try {
            Key d = d(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            cipher.init(1, d, new IvParameterSpec(b().getBytes()));
            bArr = cipher.doFinal(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeToString(bArr, 0));
    }

    private static String a(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : charArray) {
            stringBuffer.append(Integer.toHexString(c));
        }
        return z ? stringBuffer.reverse().toString() : stringBuffer.toString();
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 9; i++) {
            sb.append(String.valueOf(i));
        }
        sb.append((CharSequence) sb);
        return sb.toString();
    }

    public static String b(String str) {
        try {
            Key d = d(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, d, new IvParameterSpec(b().getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0))).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString(b & 255));
            }
            return sb.toString();
        }
        return "";
    }

    private static Key d(String str) {
        try {
            return new SecretKeySpec(str.getBytes(), com.baidu.sapi2.utils.e.q);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
