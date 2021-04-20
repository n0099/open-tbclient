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
    public byte[] f26597a;

    /* renamed from: b  reason: collision with root package name */
    public int f26598b;

    /* renamed from: c  reason: collision with root package name */
    public int f26599c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f26600d;

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
        this.f26600d = str.getBytes();
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
        byte[] bArr = this.f26600d;
        this.f26598b = 0;
        this.f26599c = 0;
        if (this.f26597a == null) {
            this.f26597a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.f26597a[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.f26597a;
            i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
            byte b2 = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
            i2 = (i2 + 1) % bArr.length;
        }
    }

    public final void a(byte[] bArr, int i, byte[] bArr2) {
        int i2 = i + 0;
        if (i2 > bArr.length) {
            throw new RuntimeException("input buffer too short");
        }
        if (i2 > bArr2.length) {
            throw new RuntimeException("output buffer too short");
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = (this.f26598b + 1) & 255;
            this.f26598b = i4;
            byte[] bArr3 = this.f26597a;
            int i5 = (bArr3[i4] + this.f26599c) & 255;
            this.f26599c = i5;
            byte b2 = bArr3[i4];
            bArr3[i4] = bArr3[i5];
            bArr3[i5] = b2;
            int i6 = i3 + 0;
            bArr2[i6] = (byte) (bArr3[(bArr3[i4] + bArr3[i5]) & 255] ^ bArr[i6]);
        }
    }

    public final byte[] a(byte[] bArr) {
        a();
        byte[] bArr2 = new byte[bArr.length];
        a(bArr, bArr.length, bArr2);
        return bArr2;
    }
}
