package com.bytedance.pangle.util;

import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes8.dex */
public final class e {
    public static String a = "DES/ECB/NoPadding";
    public static String b = "DESede/ECB/NoPadding";
    public static String c = "AES/ECB/NoPadding";
    public static final char[] d = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(File file) {
        return b(b(file));
    }

    public static String b(String str) {
        File file;
        boolean z = false;
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            file = null;
        } else {
            file = new File(str);
        }
        return a(file);
    }

    public static String a(String str) {
        return b(a(str.getBytes(), "MD5"));
    }

    public static String b(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = d;
            cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    public static String a(byte[] bArr) {
        return b(a(bArr, "MD5"));
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x003c: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x003c */
    public static byte[] b(File file) {
        Closeable closeable;
        FileInputStream fileInputStream;
        Closeable closeable2 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
                    do {
                    } while (digestInputStream.read(new byte[262144]) > 0);
                    byte[] digest = digestInputStream.getMessageDigest().digest();
                    f.a(fileInputStream);
                    return digest;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    f.a(fileInputStream);
                    return null;
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    e.printStackTrace();
                    f.a(fileInputStream);
                    return null;
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                e.printStackTrace();
                f.a(fileInputStream);
                return null;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                fileInputStream = null;
                e.printStackTrace();
                f.a(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                f.a(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }
}
