package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Kz;
    protected int fMC;
    protected byte[] fME;
    protected byte[] fMF;
    protected int fMG;
    protected byte[] fMH;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int fMD = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] fMI = new boolean[256];
    protected int fMJ = 7;
    protected int fMK = -1;
    protected boolean fML = false;
    protected boolean fMM = true;
    protected boolean fMN = false;
    protected int fMO = 10;

    public void rc(int i) {
        if (i >= 0) {
            this.fMD = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.fMN) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Kz = bitmap;
            bhV();
            bhU();
            if (this.fMM) {
                bhY();
                bia();
                if (this.fMD >= 0) {
                    bhZ();
                }
            }
            bhW();
            bhX();
            if (!this.fMM) {
                bia();
            }
            bib();
            this.fMM = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean bhT() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.fML) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.fMC = 0;
            this.out = null;
            this.Kz = null;
            this.fME = null;
            this.fMF = null;
            this.fMH = null;
            this.fML = false;
            this.fMM = true;
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
        this.fMN = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.fML = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bhU() {
        int length = this.fME.length;
        int i = length / 3;
        this.fMF = new byte[i];
        c cVar = new c(this.fME, length, this.fMO);
        this.fMH = cVar.bih();
        for (int i2 = 0; i2 < this.fMH.length; i2 += 3) {
            byte b = this.fMH[i2];
            this.fMH[i2] = this.fMH[i2 + 2];
            this.fMH[i2 + 2] = b;
            this.fMI[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Q = cVar.Q(this.fME[i3] & 255, this.fME[i5] & 255, this.fME[i6] & 255);
            this.fMI[Q] = true;
            this.fMF[i4] = (byte) Q;
        }
        this.fME = null;
        this.fMG = 8;
        this.fMJ = 7;
        if (this.transparent != -1) {
            this.fMC = rd(this.transparent);
        }
    }

    protected int rd(int i) {
        int i2;
        int i3 = 0;
        if (this.fMH == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.fMH.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.fMH[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.fMH[i9] & 255);
            int i13 = i6 - (this.fMH[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.fMI[i15] || i14 >= i7) {
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

    protected void bhV() {
        int width = this.Kz.getWidth();
        int height = this.Kz.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Kz, 0.0f, 0.0f, new Paint());
            this.Kz = createBitmap;
        }
        int[] u = u(this.Kz);
        this.fME = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.fME[i3] = (byte) ((i2 >> 0) & 255);
            this.fME[i4] = (byte) ((i2 >> 8) & 255);
            this.fME[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] u(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bhW() throws IOException {
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
        if (this.fMK >= 0) {
            i2 = this.fMK & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.fMC);
        this.out.write(0);
    }

    protected void bhX() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.fMM) {
            this.out.write(0);
        } else {
            this.out.write(this.fMJ | 128);
        }
    }

    protected void bhY() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.fMJ | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bhZ() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.fMD);
        this.out.write(0);
    }

    protected void bia() throws IOException {
        this.out.write(this.fMH, 0, this.fMH.length);
        int length = 768 - this.fMH.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bib() throws IOException {
        new b(this.width, this.height, this.fMF, this.fMG).encode(this.out);
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
