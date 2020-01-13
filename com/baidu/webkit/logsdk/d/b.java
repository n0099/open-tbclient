package com.baidu.webkit.logsdk.d;

import android.util.Base64;
/* loaded from: classes10.dex */
public final class b {
    private byte[] a = null;
    private int b = 0;
    private int c = 0;
    private byte[] d;

    private b(String str) {
        this.d = null;
        this.d = str.getBytes();
    }

    private static synchronized b a(String str) {
        b bVar;
        synchronized (b.class) {
            bVar = new b(str);
        }
        return bVar;
    }

    public static String a(String str, String str2) {
        try {
            b a = a(str2);
            byte[] decode = Base64.decode(str.getBytes(), 0);
            byte[] bArr = a.d;
            a.b = 0;
            a.c = 0;
            if (a.a == null) {
                a.a = new byte[256];
            }
            for (int i = 0; i < 256; i++) {
                a.a[i] = (byte) i;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i2 = (i2 + (bArr[i3] & 255) + a.a[i4]) & 255;
                byte b = a.a[i4];
                a.a[i4] = a.a[i2];
                a.a[i2] = b;
                i3 = (i3 + 1) % bArr.length;
            }
            byte[] bArr2 = new byte[decode.length];
            int length = decode.length;
            if (length + 0 > decode.length) {
                throw new RuntimeException("input buffer too short");
            }
            if (length + 0 > bArr2.length) {
                throw new RuntimeException("output buffer too short");
            }
            for (int i5 = 0; i5 < length; i5++) {
                a.b = (a.b + 1) & 255;
                a.c = (a.a[a.b] + a.c) & 255;
                byte b2 = a.a[a.b];
                a.a[a.b] = a.a[a.c];
                a.a[a.c] = b2;
                bArr2[i5 + 0] = (byte) (decode[i5 + 0] ^ a.a[(a.a[a.b] + a.a[a.c]) & 255]);
            }
            return new String(bArr2);
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
            return null;
        }
    }
}
