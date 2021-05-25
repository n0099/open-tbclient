package com.bytedance.frameworks.encryptor;
/* loaded from: classes6.dex */
public class EncryptorUtil {
    static {
        try {
            System.loadLibrary("Encryptor");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr != null && i2 > 0) {
            try {
                if (bArr.length == i2) {
                    return ttEncrypt(bArr, i2);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static native byte[] ttEncrypt(byte[] bArr, int i2);
}
