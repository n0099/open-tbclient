package com.baidu.webkit.logsdk.d;

import android.util.Base64;
import android.util.Log;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f26689a;

    /* renamed from: b  reason: collision with root package name */
    public int f26690b;

    /* renamed from: c  reason: collision with root package name */
    public int f26691c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f26692d;

    public b(String str) {
        this.f26692d = str.getBytes();
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            b bVar = new b(str2);
            byte[] decode = Base64.decode(str.getBytes(), 0);
            byte[] bArr = bVar.f26692d;
            bVar.f26690b = 0;
            bVar.f26691c = 0;
            if (bVar.f26689a == null) {
                bVar.f26689a = new byte[256];
            }
            for (int i2 = 0; i2 < 256; i2++) {
                bVar.f26689a[i2] = (byte) i2;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                i4 = ((bArr[i3] & 255) + bVar.f26689a[i5] + i4) & 255;
                byte b2 = bVar.f26689a[i5];
                byte[] bArr2 = bVar.f26689a;
                bArr2[i5] = bArr2[i4];
                bVar.f26689a[i4] = b2;
                i3 = (i3 + 1) % bArr.length;
            }
            int length = decode.length;
            byte[] bArr3 = new byte[length];
            int length2 = decode.length;
            int i6 = length2 + 0;
            if (i6 > decode.length) {
                str3 = "input buffer too short, buffer length=" + decode.length + ", input length=" + i6;
            } else if (i6 <= length) {
                for (int i7 = 0; i7 < length2; i7++) {
                    int i8 = (bVar.f26690b + 1) & 255;
                    bVar.f26690b = i8;
                    int i9 = (bVar.f26689a[i8] + bVar.f26691c) & 255;
                    bVar.f26691c = i9;
                    byte b3 = bVar.f26689a[i8];
                    bVar.f26689a[i8] = bVar.f26689a[i9];
                    bVar.f26689a[i9] = b3;
                    int i10 = i7 + 0;
                    bArr3[i10] = (byte) (bVar.f26689a[(bVar.f26689a[i8] + bVar.f26689a[i9]) & 255] ^ decode[i10]);
                }
                return new String(bArr3);
            } else {
                str3 = "output buffer too short, buffer length=" + decode.length + ", output length=" + i6;
            }
            Log.e("BdLogRC4Utils", str3);
            return new String(bArr3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
