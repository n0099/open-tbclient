package com.baidu.webkit.logsdk.d;

import android.util.Base64;
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f5711a;

    /* renamed from: b  reason: collision with root package name */
    private int f5712b;
    private int c;
    private byte[] d;

    private b(String str) {
        this.d = str.getBytes();
    }

    public static String a(String str, String str2) {
        try {
            b bVar = new b(str2);
            byte[] decode = Base64.decode(str.getBytes(), 0);
            byte[] bArr = bVar.d;
            bVar.f5712b = 0;
            bVar.c = 0;
            if (bVar.f5711a == null) {
                bVar.f5711a = new byte[256];
            }
            for (int i = 0; i < 256; i++) {
                bVar.f5711a[i] = (byte) i;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i2 = (i2 + (bArr[i3] & 255) + bVar.f5711a[i4]) & 255;
                byte b2 = bVar.f5711a[i4];
                bVar.f5711a[i4] = bVar.f5711a[i2];
                bVar.f5711a[i2] = b2;
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
                bVar.f5712b = (bVar.f5712b + 1) & 255;
                bVar.c = (bVar.f5711a[bVar.f5712b] + bVar.c) & 255;
                byte b3 = bVar.f5711a[bVar.f5712b];
                bVar.f5711a[bVar.f5712b] = bVar.f5711a[bVar.c];
                bVar.f5711a[bVar.c] = b3;
                bArr2[i5 + 0] = (byte) (decode[i5 + 0] ^ bVar.f5711a[(bVar.f5711a[bVar.f5712b] + bVar.f5711a[bVar.c]) & 255]);
            }
            return new String(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
