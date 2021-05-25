package com.bytedance.embedapplog.util;

import d.b.b.r0;
/* loaded from: classes6.dex */
public class TTEncryptUtils {
    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e2) {
            r0.b(e2);
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        try {
            return ttEncrypt(bArr, i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static native byte[] ttEncrypt(byte[] bArr, int i2);
}
