package com.baidu.webkit.internal;

import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes2.dex */
public final class a {
    private byte[] a = null;
    private int b = 0;
    private int c = 0;
    private byte[] d;

    /* renamed from: com.baidu.webkit.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0309a extends GZIPOutputStream {
        public C0309a(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public final void a() {
            this.def.setLevel(9);
        }
    }

    public a(String str) {
        this.d = null;
        this.d = str.getBytes();
    }

    public static byte[] b(byte[] bArr) {
        if (WebKitFactory.getCurEngine() != 1) {
            return null;
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
        C0309a c0309a = new C0309a(byteArrayOutputStream);
        c0309a.a();
        c0309a.write(bArr);
        c0309a.close();
        Log.w("rc4", "kernelGzipCompress " + byteArrayOutputStream.toByteArray().length);
        return byteArrayOutputStream.toByteArray();
    }

    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = this.d;
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
            i2 = (i2 + (bArr2[i3] & 255) + this.a[i4]) & 255;
            byte b = this.a[i4];
            this.a[i4] = this.a[i2];
            this.a[i2] = b;
            i3 = (i3 + 1) % bArr2.length;
        }
        byte[] bArr3 = new byte[bArr.length];
        int length = bArr.length;
        if (length + 0 > bArr.length) {
            throw new RuntimeException("input buffer too short");
        }
        if (length + 0 > bArr3.length) {
            throw new RuntimeException("output buffer too short");
        }
        for (int i5 = 0; i5 < length; i5++) {
            this.b = (this.b + 1) & 255;
            this.c = (this.a[this.b] + this.c) & 255;
            byte b2 = this.a[this.b];
            this.a[this.b] = this.a[this.c];
            this.a[this.c] = b2;
            bArr3[i5 + 0] = (byte) (bArr[i5 + 0] ^ this.a[(this.a[this.b] + this.a[this.c]) & 255]);
        }
        return bArr3;
    }
}
