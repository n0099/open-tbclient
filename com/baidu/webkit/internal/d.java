package com.baidu.webkit.internal;

import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f5665a;

    /* renamed from: b  reason: collision with root package name */
    private int f5666b;
    private int c;
    private byte[] d;

    /* loaded from: classes14.dex */
    static class a extends GZIPOutputStream {
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public final void a() {
            this.def.setLevel(9);
        }
    }

    public d(String str) {
        this.d = str.getBytes();
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
        byte[] bArr = this.d;
        this.f5666b = 0;
        this.c = 0;
        if (this.f5665a == null) {
            this.f5665a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.f5665a[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 256) {
            int i5 = ((bArr[i4] & 255) + this.f5665a[i2] + i3) & 255;
            byte b2 = this.f5665a[i2];
            this.f5665a[i2] = this.f5665a[i5];
            this.f5665a[i5] = b2;
            i4 = (i4 + 1) % bArr.length;
            i2++;
            i3 = i5;
        }
    }

    public final void a(byte[] bArr, int i, byte[] bArr2) {
        if (i + 0 > bArr.length) {
            throw new RuntimeException("input buffer too short");
        }
        if (i + 0 > bArr2.length) {
            throw new RuntimeException("output buffer too short");
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.f5666b = (this.f5666b + 1) & 255;
            this.c = (this.f5665a[this.f5666b] + this.c) & 255;
            byte b2 = this.f5665a[this.f5666b];
            this.f5665a[this.f5666b] = this.f5665a[this.c];
            this.f5665a[this.c] = b2;
            bArr2[i2 + 0] = (byte) (bArr[i2 + 0] ^ this.f5665a[(this.f5665a[this.f5666b] + this.f5665a[this.c]) & 255]);
        }
    }

    public final byte[] a(byte[] bArr) {
        a();
        byte[] bArr2 = new byte[bArr.length];
        a(bArr, bArr.length, bArr2);
        return bArr2;
    }
}
