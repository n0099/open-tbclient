package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.au;
/* loaded from: classes6.dex */
public class TTEncryptUtils {
    private static native byte[] ttEncrypt(byte[] bArr, int i);

    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            au.a(e);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable th) {
            return null;
        }
    }
}
