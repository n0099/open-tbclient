package com.baidu.webkit.internal;

import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes9.dex */
public class RC4 implements INoProGuard {
    public static final String LOGTAG = "RC4";
    public static final int STATE_LENGTH = 256;
    public byte[] engineState;
    public byte[] workingKey;
    public int x;
    public int y;

    /* loaded from: classes9.dex */
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

    private void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        StringBuilder sb;
        String str;
        int i4 = i + i2;
        if (i4 > bArr.length) {
            sb = new StringBuilder("input buffer too short, buffer length=");
            sb.append(bArr.length);
            str = ", input length=";
        } else if (i3 + i2 <= bArr2.length) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = (this.x + 1) & 255;
                this.x = i6;
                byte[] bArr3 = this.engineState;
                int i7 = (bArr3[i6] + this.y) & 255;
                this.y = i7;
                byte b = bArr3[i6];
                bArr3[i6] = bArr3[i7];
                bArr3[i7] = b;
                bArr2[i5 + i3] = (byte) (bArr3[(bArr3[i6] + bArr3[i7]) & 255] ^ bArr[i5 + i]);
            }
            return;
        } else {
            sb = new StringBuilder("output buffer too short, buffer length=");
            sb.append(bArr.length);
            str = ", output length=";
        }
        sb.append(str);
        sb.append(i4);
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
        for (int i = 0; i < 256; i++) {
            this.engineState[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.engineState;
            i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
            byte b = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
            i2 = (i2 + 1) % bArr.length;
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
