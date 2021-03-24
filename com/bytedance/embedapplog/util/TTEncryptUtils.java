package com.bytedance.embedapplog.util;

import d.c.b.r0;
/* loaded from: classes5.dex */
public class TTEncryptUtils {
    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e2) {
            r0.b(e2);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static native byte[] ttEncrypt(byte[] bArr, int i);
}
