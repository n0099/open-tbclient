package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class a {
    protected Bitmap Ly;
    protected int hZK;
    protected byte[] hZM;
    protected byte[] hZN;
    protected int hZO;
    protected byte[] hZP;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int hZL = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] hZQ = new boolean[256];
    protected int hZR = 7;
    protected int hZS = -1;
    protected boolean hZT = false;
    protected boolean hZU = true;
    protected boolean hZV = false;
    protected int hZW = 10;

    public void xS(int i) {
        if (i >= 0) {
            this.hZL = i;
        }
    }

    public boolean C(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.hZV) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Ly = bitmap;
            bXC();
            bXB();
            if (this.hZU) {
                bXF();
                bXH();
                if (this.hZL >= 0) {
                    bXG();
                }
            }
            bXD();
            bXE();
            if (!this.hZU) {
                bXH();
            }
            bXI();
            this.hZU = false;
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
                if (this.hZT) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.hZK = 0;
            this.out = null;
            this.Ly = null;
            this.hZM = null;
            this.hZN = null;
            this.hZP = null;
            this.hZT = false;
            this.hZU = true;
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
        this.hZV = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.hZT = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bXB() {
        int length = this.hZM.length;
        int i = length / 3;
        this.hZN = new byte[i];
        c cVar = new c(this.hZM, length, this.hZW);
        this.hZP = cVar.bXO();
        for (int i2 = 0; i2 < this.hZP.length; i2 += 3) {
            byte b = this.hZP[i2];
            this.hZP[i2] = this.hZP[i2 + 2];
            this.hZP[i2 + 2] = b;
            this.hZQ[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Y = cVar.Y(this.hZM[i3] & 255, this.hZM[i5] & 255, this.hZM[i6] & 255);
            this.hZQ[Y] = true;
            this.hZN[i4] = (byte) Y;
        }
        this.hZM = null;
        this.hZO = 8;
        this.hZR = 7;
        if (this.transparent != -1) {
            this.hZK = xT(this.transparent);
        }
    }

    protected int xT(int i) {
        int i2;
        int i3 = 0;
        if (this.hZP == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.hZP.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.hZP[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.hZP[i9] & 255);
            int i13 = i6 - (this.hZP[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.hZQ[i15] || i14 >= i7) {
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

    protected void bXC() {
        int width = this.Ly.getWidth();
        int height = this.Ly.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Ly, 0.0f, 0.0f, new Paint());
            this.Ly = createBitmap;
        }
        int[] D = D(this.Ly);
        this.hZM = new byte[D.length * 3];
        for (int i = 0; i < D.length; i++) {
            int i2 = D[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.hZM[i3] = (byte) ((i2 >> 0) & 255);
            this.hZM[i4] = (byte) ((i2 >> 8) & 255);
            this.hZM[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bXD() throws IOException {
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
        if (this.hZS >= 0) {
            i2 = this.hZS & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.hZK);
        this.out.write(0);
    }

    protected void bXE() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.hZU) {
            this.out.write(0);
        } else {
            this.out.write(this.hZR | 128);
        }
    }

    protected void bXF() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.hZR | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bXG() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.hZL);
        this.out.write(0);
    }

    protected void bXH() throws IOException {
        this.out.write(this.hZP, 0, this.hZP.length);
        int length = 768 - this.hZP.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bXI() throws IOException {
        new b(this.width, this.height, this.hZN, this.hZO).encode(this.out);
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
