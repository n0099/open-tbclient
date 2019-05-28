package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class a {
    protected Bitmap Lz;
    protected int hZJ;
    protected byte[] hZL;
    protected byte[] hZM;
    protected int hZN;
    protected byte[] hZO;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int hZK = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] hZP = new boolean[256];
    protected int hZQ = 7;
    protected int hZR = -1;
    protected boolean hZS = false;
    protected boolean hZT = true;
    protected boolean hZU = false;
    protected int hZV = 10;

    public void xS(int i) {
        if (i >= 0) {
            this.hZK = i;
        }
    }

    public boolean C(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.hZU) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Lz = bitmap;
            bXB();
            bXA();
            if (this.hZT) {
                bXE();
                bXG();
                if (this.hZK >= 0) {
                    bXF();
                }
            }
            bXC();
            bXD();
            if (!this.hZT) {
                bXG();
            }
            bXH();
            this.hZT = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean ue() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.hZS) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.hZJ = 0;
            this.out = null;
            this.Lz = null;
            this.hZL = null;
            this.hZM = null;
            this.hZO = null;
            this.hZS = false;
            this.hZT = true;
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
        this.hZU = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.hZS = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bXA() {
        int length = this.hZL.length;
        int i = length / 3;
        this.hZM = new byte[i];
        c cVar = new c(this.hZL, length, this.hZV);
        this.hZO = cVar.bXN();
        for (int i2 = 0; i2 < this.hZO.length; i2 += 3) {
            byte b = this.hZO[i2];
            this.hZO[i2] = this.hZO[i2 + 2];
            this.hZO[i2 + 2] = b;
            this.hZP[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Y = cVar.Y(this.hZL[i3] & 255, this.hZL[i5] & 255, this.hZL[i6] & 255);
            this.hZP[Y] = true;
            this.hZM[i4] = (byte) Y;
        }
        this.hZL = null;
        this.hZN = 8;
        this.hZQ = 7;
        if (this.transparent != -1) {
            this.hZJ = xT(this.transparent);
        }
    }

    protected int xT(int i) {
        int i2;
        int i3 = 0;
        if (this.hZO == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.hZO.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.hZO[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.hZO[i9] & 255);
            int i13 = i6 - (this.hZO[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.hZP[i15] || i14 >= i7) {
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

    protected void bXB() {
        int width = this.Lz.getWidth();
        int height = this.Lz.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Lz, 0.0f, 0.0f, new Paint());
            this.Lz = createBitmap;
        }
        int[] D = D(this.Lz);
        this.hZL = new byte[D.length * 3];
        for (int i = 0; i < D.length; i++) {
            int i2 = D[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.hZL[i3] = (byte) ((i2 >> 0) & 255);
            this.hZL[i4] = (byte) ((i2 >> 8) & 255);
            this.hZL[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bXC() throws IOException {
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
        if (this.hZR >= 0) {
            i2 = this.hZR & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.hZJ);
        this.out.write(0);
    }

    protected void bXD() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.hZT) {
            this.out.write(0);
        } else {
            this.out.write(this.hZQ | 128);
        }
    }

    protected void bXE() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.hZQ | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bXF() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.hZK);
        this.out.write(0);
    }

    protected void bXG() throws IOException {
        this.out.write(this.hZO, 0, this.hZO.length);
        int length = 768 - this.hZO.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bXH() throws IOException {
        new b(this.width, this.height, this.hZM, this.hZN).encode(this.out);
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
