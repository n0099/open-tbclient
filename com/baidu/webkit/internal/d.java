package com.baidu.webkit.internal;

import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f27412a;

    /* renamed from: b  reason: collision with root package name */
    public int f27413b;

    /* renamed from: c  reason: collision with root package name */
    public int f27414c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f27415d;

    /* loaded from: classes5.dex */
    public static class a extends GZIPOutputStream {
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public final void a() {
            ((GZIPOutputStream) this).def.setLevel(9);
        }
    }

    public d(String str) {
        this.f27415d = str.getBytes();
    }

    public static byte[] b(byte[] bArr) {
        if (WebKitFactory.getCurEngine() != 1) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        Log.w("RC4", "kernelEncrypt " + bArr.length);
        WebSettingsGlobalBlink.kernelEncrypt(bArr, bArr.length, bArr2);
        return bArr2;
    }

    public static byte[] c(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = new a(byteArrayOutputStream);
        aVar.a();
        aVar.write(bArr);
        aVar.close();
        Log.w("rc4", "kernelGzipCompress " + byteArrayOutputStream.toByteArray().length);
        return byteArrayOutputStream.toByteArray();
    }

    public final void a() {
        byte[] bArr = this.f27415d;
        this.f27413b = 0;
        this.f27414c = 0;
        if (this.f27412a == null) {
            this.f27412a = new byte[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            this.f27412a[i2] = (byte) i2;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            byte[] bArr2 = this.f27412a;
            i4 = ((bArr[i3] & 255) + bArr2[i5] + i4) & 255;
            byte b2 = bArr2[i5];
            bArr2[i5] = bArr2[i4];
            bArr2[i4] = b2;
            i3 = (i3 + 1) % bArr.length;
        }
    }

    public final void a(byte[] bArr, int i2, byte[] bArr2) {
        int i3 = i2 + 0;
        if (i3 > bArr.length) {
            throw new RuntimeException("input buffer too short");
        }
        if (i3 > bArr2.length) {
            throw new RuntimeException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (this.f27413b + 1) & 255;
            this.f27413b = i5;
            byte[] bArr3 = this.f27412a;
            int i6 = (bArr3[i5] + this.f27414c) & 255;
            this.f27414c = i6;
            byte b2 = bArr3[i5];
            bArr3[i5] = bArr3[i6];
            bArr3[i6] = b2;
            int i7 = i4 + 0;
            bArr2[i7] = (byte) (bArr3[(bArr3[i5] + bArr3[i6]) & 255] ^ bArr[i7]);
        }
    }

    public final byte[] a(byte[] bArr) {
        a();
        byte[] bArr2 = new byte[bArr.length];
        a(bArr, bArr.length, bArr2);
        return bArr2;
    }
}
