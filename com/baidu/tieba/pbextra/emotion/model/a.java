package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes21.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected int lRX;
    protected OutputStream lRZ;
    protected byte[] lSa;
    protected byte[] lSb;
    protected int lSc;
    protected byte[] lSd;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int lRY = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] lSe = new boolean[256];
    protected int lSf = 7;
    protected int lSg = -1;
    protected boolean lSh = false;
    protected boolean lSi = true;
    protected boolean lSj = false;
    protected int lSk = 10;

    public void Hh(int i) {
        if (i >= 0) {
            this.lRY = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.lSj) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dsk();
            dsj();
            if (this.lSi) {
                dsn();
                dsp();
                if (this.lRY >= 0) {
                    dso();
                }
            }
            dsl();
            dsm();
            if (!this.lSi) {
                dsp();
            }
            dsq();
            this.lSi = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dsi() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.lRZ.write(59);
                this.lRZ.flush();
                if (this.lSh) {
                    this.lRZ.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.lRX = 0;
            this.lRZ = null;
            this.image = null;
            this.lSa = null;
            this.lSb = null;
            this.lSd = null;
            this.lSh = false;
            this.lSi = true;
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
        this.lSj = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.lSh = false;
        this.lRZ = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dsj() {
        int length = this.lSa.length;
        int i = length / 3;
        this.lSb = new byte[i];
        c cVar = new c(this.lSa, length, this.lSk);
        this.lSd = cVar.dsw();
        for (int i2 = 0; i2 < this.lSd.length; i2 += 3) {
            byte b = this.lSd[i2];
            this.lSd[i2] = this.lSd[i2 + 2];
            this.lSd[i2 + 2] = b;
            this.lSe[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Y = cVar.Y(this.lSa[i3] & 255, this.lSa[i5] & 255, this.lSa[i6] & 255);
            this.lSe[Y] = true;
            this.lSb[i4] = (byte) Y;
        }
        this.lSa = null;
        this.lSc = 8;
        this.lSf = 7;
        if (this.transparent != -1) {
            this.lRX = Hi(this.transparent);
        }
    }

    protected int Hi(int i) {
        int i2;
        int i3 = 0;
        if (this.lSd == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.lSd.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.lSd[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.lSd[i9] & 255);
            int i13 = i6 - (this.lSd[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.lSe[i15] || i14 >= i7) {
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

    protected void dsk() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.lSa = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.lSa[i3] = (byte) ((i2 >> 0) & 255);
            this.lSa[i4] = (byte) ((i2 >> 8) & 255);
            this.lSa[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dsl() throws IOException {
        int i;
        int i2;
        this.lRZ.write(33);
        this.lRZ.write(249);
        this.lRZ.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.lSg >= 0) {
            i2 = this.lSg & 7;
        }
        this.lRZ.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.lRZ.write(this.lRX);
        this.lRZ.write(0);
    }

    protected void dsm() throws IOException {
        this.lRZ.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.lSi) {
            this.lRZ.write(0);
        } else {
            this.lRZ.write(this.lSf | 128);
        }
    }

    protected void dsn() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.lRZ.write(this.lSf | 240);
        this.lRZ.write(0);
        this.lRZ.write(0);
    }

    protected void dso() throws IOException {
        this.lRZ.write(33);
        this.lRZ.write(255);
        this.lRZ.write(11);
        writeString("NETSCAPE2.0");
        this.lRZ.write(3);
        this.lRZ.write(1);
        writeShort(this.lRY);
        this.lRZ.write(0);
    }

    protected void dsp() throws IOException {
        this.lRZ.write(this.lSd, 0, this.lSd.length);
        int length = 768 - this.lSd.length;
        for (int i = 0; i < length; i++) {
            this.lRZ.write(0);
        }
    }

    protected void dsq() throws IOException {
        new b(this.width, this.height, this.lSb, this.lSc).encode(this.lRZ);
    }

    protected void writeShort(int i) throws IOException {
        this.lRZ.write(i & 255);
        this.lRZ.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.lRZ.write((byte) str.charAt(i));
        }
    }
}
