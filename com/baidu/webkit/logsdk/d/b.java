package com.baidu.webkit.logsdk.d;

import android.util.Base64;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f27515a;

    /* renamed from: b  reason: collision with root package name */
    public int f27516b;

    /* renamed from: c  reason: collision with root package name */
    public int f27517c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f27518d;

    public b(String str) {
        this.f27518d = str.getBytes();
    }

    public static String a(String str, String str2) {
        try {
            b bVar = new b(str2);
            byte[] decode = Base64.decode(str.getBytes(), 0);
            byte[] bArr = bVar.f27518d;
            bVar.f27516b = 0;
            bVar.f27517c = 0;
            if (bVar.f27515a == null) {
                bVar.f27515a = new byte[256];
            }
            for (int i2 = 0; i2 < 256; i2++) {
                bVar.f27515a[i2] = (byte) i2;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                i4 = ((bArr[i3] & 255) + bVar.f27515a[i5] + i4) & 255;
                byte b2 = bVar.f27515a[i5];
                bVar.f27515a[i5] = bVar.f27515a[i4];
                bVar.f27515a[i4] = b2;
                i3 = (i3 + 1) % bArr.length;
            }
            int length = decode.length;
            byte[] bArr2 = new byte[length];
            int length2 = decode.length;
            int i6 = length2 + 0;
            if (i6 <= decode.length) {
                if (i6 <= length) {
                    for (int i7 = 0; i7 < length2; i7++) {
                        int i8 = (bVar.f27516b + 1) & 255;
                        bVar.f27516b = i8;
                        int i9 = (bVar.f27515a[i8] + bVar.f27517c) & 255;
                        bVar.f27517c = i9;
                        byte b3 = bVar.f27515a[i8];
                        bVar.f27515a[i8] = bVar.f27515a[i9];
                        bVar.f27515a[i9] = b3;
                        int i10 = i7 + 0;
                        bArr2[i10] = (byte) (bVar.f27515a[(bVar.f27515a[i8] + bVar.f27515a[i9]) & 255] ^ decode[i10]);
                    }
                    return new String(bArr2);
                }
                throw new RuntimeException("output buffer too short");
            }
            throw new RuntimeException("input buffer too short");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
