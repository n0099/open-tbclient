package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Ky;
    protected int fQQ;
    protected byte[] fQS;
    protected byte[] fQT;
    protected int fQU;
    protected byte[] fQV;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int fQR = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] fQW = new boolean[256];
    protected int fQX = 7;
    protected int fQY = -1;
    protected boolean fQZ = false;
    protected boolean fRa = true;
    protected boolean fRb = false;
    protected int fRc = 10;

    public void ri(int i) {
        if (i >= 0) {
            this.fQR = i;
        }
    }

    public boolean s(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.fRb) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Ky = bitmap;
            bgU();
            bgT();
            if (this.fRa) {
                bgX();
                bgZ();
                if (this.fQR >= 0) {
                    bgY();
                }
            }
            bgV();
            bgW();
            if (!this.fRa) {
                bgZ();
            }
            bha();
            this.fRa = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean bgS() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.fQZ) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.fQQ = 0;
            this.out = null;
            this.Ky = null;
            this.fQS = null;
            this.fQT = null;
            this.fQV = null;
            this.fQZ = false;
            this.fRa = true;
            return z;
        }
        return false;
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        if (this.width < 1) {
            this.width = 320;
        }
        if (this.height < 1) {
            this.height = 240;
        }
        this.fRb = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.fQZ = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bgT() {
        int length = this.fQS.length;
        int i = length / 3;
        this.fQT = new byte[i];
        c cVar = new c(this.fQS, length, this.fRc);
        this.fQV = cVar.bhg();
        for (int i2 = 0; i2 < this.fQV.length; i2 += 3) {
            byte b = this.fQV[i2];
            this.fQV[i2] = this.fQV[i2 + 2];
            this.fQV[i2 + 2] = b;
            this.fQW[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int P = cVar.P(this.fQS[i3] & 255, this.fQS[i5] & 255, this.fQS[i6] & 255);
            this.fQW[P] = true;
            this.fQT[i4] = (byte) P;
        }
        this.fQS = null;
        this.fQU = 8;
        this.fQX = 7;
        if (this.transparent != -1) {
            this.fQQ = rj(this.transparent);
        }
    }

    protected int rj(int i) {
        int i2;
        int i3 = 0;
        if (this.fQV == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.fQV.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.fQV[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.fQV[i9] & 255);
            int i13 = i6 - (this.fQV[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.fQW[i15] || i14 >= i7) {
                i14 = i7;
                i2 = i8;
            } else {
                i2 = i15;
            }
            i8 = i2;
            i7 = i14;
            i3 = i11 + 1;
        }
        return i8;
    }

    protected void bgU() {
        int width = this.Ky.getWidth();
        int height = this.Ky.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Ky, 0.0f, 0.0f, new Paint());
            this.Ky = createBitmap;
        }
        int[] t = t(this.Ky);
        this.fQS = new byte[t.length * 3];
        for (int i = 0; i < t.length; i++) {
            int i2 = t[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.fQS[i3] = (byte) ((i2 >> 0) & 255);
            this.fQS[i4] = (byte) ((i2 >> 8) & 255);
            this.fQS[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] t(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bgV() throws IOException {
        int i;
        int i2;
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.fQY >= 0) {
            i2 = this.fQY & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.fQQ);
        this.out.write(0);
    }

    protected void bgW() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.fRa) {
            this.out.write(0);
        } else {
            this.out.write(this.fQX | 128);
        }
    }

    protected void bgX() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.fQX | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bgY() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.fQR);
        this.out.write(0);
    }

    protected void bgZ() throws IOException {
        this.out.write(this.fQV, 0, this.fQV.length);
        int length = 768 - this.fQV.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bha() throws IOException {
        new b(this.width, this.height, this.fQT, this.fQU).encode(this.out);
    }

    protected void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.out.write((byte) str.charAt(i));
        }
    }
}
