package com.baidu.webkit.internal;

import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes5.dex */
public class RC4 implements INoProGuard {
    public static final String LOGTAG = "RC4";
    public static final int STATE_LENGTH = 256;
    public byte[] engineState;
    public byte[] workingKey;
    public int x;
    public int y;

    /* loaded from: classes5.dex */
    public static class a extends GZIPOutputStream {
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public final void a() {
            ((GZIPOutputStream) this).def.setLevel(9);
        }
    }

    public RC4(String str) {
        this.workingKey = str.getBytes();
    }

    public static byte[] kernelEncrypt(byte[] bArr) {
        if (WebKitFactory.getCurEngine() != 1) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        Log.w(LOGTAG, "kernelEncrypt " + bArr.length);
        WebSettingsGlobalBlink.kernelEncrypt(bArr, bArr.length, bArr2);
        return bArr2;
    }

    public static byte[] kernelGzipCompress(byte[] bArr) throws IOException {
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

    private void processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        StringBuilder sb;
        String str;
        int i5 = i2 + i3;
        if (i5 > bArr.length) {
            sb = new StringBuilder("input buffer too short, buffer length=");
            sb.append(bArr.length);
            str = ", input length=";
        } else if (i4 + i3 <= bArr2.length) {
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = (this.x + 1) & 255;
                this.x = i7;
                byte[] bArr3 = this.engineState;
                int i8 = (bArr3[i7] + this.y) & 255;
                this.y = i8;
                byte b2 = bArr3[i7];
                bArr3[i7] = bArr3[i8];
                bArr3[i8] = b2;
                bArr2[i6 + i4] = (byte) (bArr3[(bArr3[i7] + bArr3[i8]) & 255] ^ bArr[i6 + i2]);
            }
            return;
        } else {
            sb = new StringBuilder("output buffer too short, buffer length=");
            sb.append(bArr.length);
            str = ", output length=";
        }
        sb.append(str);
        sb.append(i5);
        Log.e(LOGTAG, sb.toString());
    }

    private void reset() {
        setKey(this.workingKey);
    }

    private void setKey(byte[] bArr) {
        this.x = 0;
        this.y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            this.engineState[i2] = (byte) i2;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            byte[] bArr2 = this.engineState;
            i4 = ((bArr[i3] & 255) + bArr2[i5] + i4) & 255;
            byte b2 = bArr2[i5];
            bArr2[i5] = bArr2[i4];
            bArr2[i4] = b2;
            i3 = (i3 + 1) % bArr.length;
        }
    }

    public byte[] decrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    public byte[] encrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }
}
