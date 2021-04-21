package com.baidu.webkit.logsdk.d;

import android.util.Base64;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f26705a;

    /* renamed from: b  reason: collision with root package name */
    public int f26706b;

    /* renamed from: c  reason: collision with root package name */
    public int f26707c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f26708d;

    public b(String str) {
        this.f26708d = str.getBytes();
    }

    public static String a(String str, String str2) {
        try {
            b bVar = new b(str2);
            byte[] decode = Base64.decode(str.getBytes(), 0);
            byte[] bArr = bVar.f26708d;
            bVar.f26706b = 0;
            bVar.f26707c = 0;
            if (bVar.f26705a == null) {
                bVar.f26705a = new byte[256];
            }
            for (int i = 0; i < 256; i++) {
                bVar.f26705a[i] = (byte) i;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i3 = ((bArr[i2] & 255) + bVar.f26705a[i4] + i3) & 255;
                byte b2 = bVar.f26705a[i4];
                bVar.f26705a[i4] = bVar.f26705a[i3];
                bVar.f26705a[i3] = b2;
                i2 = (i2 + 1) % bArr.length;
            }
            int length = decode.length;
            byte[] bArr2 = new byte[length];
            int length2 = decode.length;
            int i5 = length2 + 0;
            if (i5 <= decode.length) {
                if (i5 <= length) {
                    for (int i6 = 0; i6 < length2; i6++) {
                        int i7 = (bVar.f26706b + 1) & 255;
                        bVar.f26706b = i7;
                        int i8 = (bVar.f26705a[i7] + bVar.f26707c) & 255;
                        bVar.f26707c = i8;
                        byte b3 = bVar.f26705a[i7];
                        bVar.f26705a[i7] = bVar.f26705a[i8];
                        bVar.f26705a[i8] = b3;
                        int i9 = i6 + 0;
                        bArr2[i9] = (byte) (bVar.f26705a[(bVar.f26705a[i7] + bVar.f26705a[i8]) & 255] ^ decode[i9]);
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
