package com.baidu.ueg.lib;

import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public class d {
    private static byte[] getBytes(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytes(str, c.UTF_8);
    }

    private static String newString(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String newStringUtf8(byte[] bArr) {
        return newString(bArr, c.UTF_8);
    }
}
