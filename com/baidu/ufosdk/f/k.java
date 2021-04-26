package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
@SuppressLint({"InlinedApi"})
/* loaded from: classes5.dex */
public final class k {
    public static String a() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a("W", false));
        stringBuffer.append(a(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, true));
        stringBuffer.append(random.nextInt(1) + 1);
        stringBuffer.append(a("Y", true));
        stringBuffer.append("abe");
        stringBuffer.append(a("y", true));
        stringBuffer.append("1a88");
        return stringBuffer.toString();
    }

    @SuppressLint({"TrulyRandom"})
    public static String a(String str) {
        byte[] bArr;
        try {
            Key d2 = d(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            cipher.init(1, d2, new IvParameterSpec(b().getBytes()));
            bArr = cipher.doFinal(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return new String(Base64.encodeToString(bArr, 0));
    }

    public static String a(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c2 : charArray) {
            stringBuffer.append(Integer.toHexString(c2));
        }
        return z ? stringBuffer.reverse().toString() : stringBuffer.toString();
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < 9; i2++) {
            sb.append(String.valueOf(i2));
        }
        sb.append((CharSequence) sb);
        return sb.toString();
    }

    public static String b(String str) {
        try {
            Key d2 = d(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, d2, new IvParameterSpec(b().getBytes()));
            return new String(cipher.doFinal(Base64.decode(str, 0))).trim();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString(b2 & 255));
            }
            return sb.toString();
        }
        return "";
    }

    public static Key d(String str) {
        try {
            return new SecretKeySpec(str.getBytes(), "AES");
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        }
    }
}
