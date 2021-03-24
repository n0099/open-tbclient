package com.bytedance.frameworks.encryptor;
/* loaded from: classes5.dex */
public class EncryptorUtil {
    static {
        try {
            System.loadLibrary("Encryptor");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return ttEncrypt(bArr, i);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static native byte[] ttEncrypt(byte[] bArr, int i);
}
