package com.baidu.ueg.lib;

import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class d {
    private static byte[] a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] ry(String str) {
        return a(str, c.UTF_8);
    }

    private static String a(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String H(byte[] bArr) {
        return a(bArr, c.UTF_8);
    }
}
