package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected int kit;
    protected OutputStream kiv;
    protected byte[] kiw;
    protected byte[] kix;
    protected int kiy;
    protected byte[] kiz;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int kiu = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] kiA = new boolean[256];
    protected int kiB = 7;
    protected int kiC = -1;
    protected boolean kiD = false;
    protected boolean kiE = true;
    protected boolean kiF = false;
    protected int kiG = 10;

    public void Ba(int i) {
        if (i >= 0) {
            this.kiu = i;
        }
    }

    public boolean E(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.kiF) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cMI();
            cMH();
            if (this.kiE) {
                cML();
                cMN();
                if (this.kiu >= 0) {
                    cMM();
                }
            }
            cMJ();
            cMK();
            if (!this.kiE) {
                cMN();
            }
            cMO();
            this.kiE = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cMG() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.kiv.write(59);
                this.kiv.flush();
                if (this.kiD) {
                    this.kiv.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.kit = 0;
            this.kiv = null;
            this.image = null;
            this.kiw = null;
            this.kix = null;
            this.kiz = null;
            this.kiD = false;
            this.kiE = true;
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
        this.kiF = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.kiD = false;
        this.kiv = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void cMH() {
        int length = this.kiw.length;
        int i = length / 3;
        this.kix = new byte[i];
        c cVar = new c(this.kiw, length, this.kiG);
        this.kiz = cVar.cMU();
        for (int i2 = 0; i2 < this.kiz.length; i2 += 3) {
            byte b = this.kiz[i2];
            this.kiz[i2] = this.kiz[i2 + 2];
            this.kiz[i2 + 2] = b;
            this.kiA[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int V = cVar.V(this.kiw[i3] & 255, this.kiw[i5] & 255, this.kiw[i6] & 255);
            this.kiA[V] = true;
            this.kix[i4] = (byte) V;
        }
        this.kiw = null;
        this.kiy = 8;
        this.kiB = 7;
        if (this.transparent != -1) {
            this.kit = Bb(this.transparent);
        }
    }

    protected int Bb(int i) {
        int i2;
        int i3 = 0;
        if (this.kiz == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.kiz.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.kiz[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.kiz[i9] & 255);
            int i13 = i6 - (this.kiz[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.kiA[i15] || i14 >= i7) {
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

    protected void cMI() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] F = F(this.image);
        this.kiw = new byte[F.length * 3];
        for (int i = 0; i < F.length; i++) {
            int i2 = F[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.kiw[i3] = (byte) ((i2 >> 0) & 255);
            this.kiw[i4] = (byte) ((i2 >> 8) & 255);
            this.kiw[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] F(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cMJ() throws IOException {
        int i;
        int i2;
        this.kiv.write(33);
        this.kiv.write(249);
        this.kiv.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.kiC >= 0) {
            i2 = this.kiC & 7;
        }
        this.kiv.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.kiv.write(this.kit);
        this.kiv.write(0);
    }

    protected void cMK() throws IOException {
        this.kiv.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.kiE) {
            this.kiv.write(0);
        } else {
            this.kiv.write(this.kiB | 128);
        }
    }

    protected void cML() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.kiv.write(this.kiB | 240);
        this.kiv.write(0);
        this.kiv.write(0);
    }

    protected void cMM() throws IOException {
        this.kiv.write(33);
        this.kiv.write(255);
        this.kiv.write(11);
        writeString("NETSCAPE2.0");
        this.kiv.write(3);
        this.kiv.write(1);
        writeShort(this.kiu);
        this.kiv.write(0);
    }

    protected void cMN() throws IOException {
        this.kiv.write(this.kiz, 0, this.kiz.length);
        int length = 768 - this.kiz.length;
        for (int i = 0; i < length; i++) {
            this.kiv.write(0);
        }
    }

    protected void cMO() throws IOException {
        new b(this.width, this.height, this.kix, this.kiy).encode(this.kiv);
    }

    protected void writeShort(int i) throws IOException {
        this.kiv.write(i & 255);
        this.kiv.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.kiv.write((byte) str.charAt(i));
        }
    }
}
