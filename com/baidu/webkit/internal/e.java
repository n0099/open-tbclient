package com.baidu.webkit.internal;

import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes11.dex */
public final class e {
    private byte[] a = null;
    private int b = 0;
    private int c = 0;
    private byte[] d;

    /* loaded from: classes11.dex */
    static class a extends GZIPOutputStream {
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public final void a() {
            this.def.setLevel(9);
        }
    }

    public e(String str) {
        this.d = null;
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
        this.b = 0;
        this.c = 0;
        if (this.a == null) {
            this.a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i2 = (i2 + (bArr[i3] & 255) + this.a[i4]) & 255;
            byte b = this.a[i4];
            this.a[i4] = this.a[i2];
            this.a[i2] = b;
            i3 = (i3 + 1) % bArr.length;
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
            this.b = (this.b + 1) & 255;
            this.c = (this.a[this.b] + this.c) & 255;
            byte b = this.a[this.b];
            this.a[this.b] = this.a[this.c];
            this.a[this.c] = b;
            bArr2[i2 + 0] = (byte) (bArr[i2 + 0] ^ this.a[(this.a[this.b] + this.a[this.c]) & 255]);
        }
    }

    public final byte[] a(byte[] bArr) {
        a();
        byte[] bArr2 = new byte[bArr.length];
        a(bArr, bArr.length, bArr2);
        return bArr2;
    }
}
