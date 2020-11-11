package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes22.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected int lRH;
    protected OutputStream lRJ;
    protected byte[] lRK;
    protected byte[] lRL;
    protected int lRM;
    protected byte[] lRN;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int lRI = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] lRO = new boolean[256];
    protected int lRP = 7;
    protected int lRQ = -1;
    protected boolean lRR = false;
    protected boolean lRS = true;
    protected boolean lRT = false;
    protected int lRU = 10;

    public void GJ(int i) {
        if (i >= 0) {
            this.lRI = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.lRT) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dsK();
            dsJ();
            if (this.lRS) {
                dsN();
                dsP();
                if (this.lRI >= 0) {
                    dsO();
                }
            }
            dsL();
            dsM();
            if (!this.lRS) {
                dsP();
            }
            dsQ();
            this.lRS = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dsI() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.lRJ.write(59);
                this.lRJ.flush();
                if (this.lRR) {
                    this.lRJ.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.lRH = 0;
            this.lRJ = null;
            this.image = null;
            this.lRK = null;
            this.lRL = null;
            this.lRN = null;
            this.lRR = false;
            this.lRS = true;
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
        this.lRT = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.lRR = false;
        this.lRJ = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dsJ() {
        int length = this.lRK.length;
        int i = length / 3;
        this.lRL = new byte[i];
        c cVar = new c(this.lRK, length, this.lRU);
        this.lRN = cVar.dsW();
        for (int i2 = 0; i2 < this.lRN.length; i2 += 3) {
            byte b = this.lRN[i2];
            this.lRN[i2] = this.lRN[i2 + 2];
            this.lRN[i2 + 2] = b;
            this.lRO[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int W = cVar.W(this.lRK[i3] & 255, this.lRK[i5] & 255, this.lRK[i6] & 255);
            this.lRO[W] = true;
            this.lRL[i4] = (byte) W;
        }
        this.lRK = null;
        this.lRM = 8;
        this.lRP = 7;
        if (this.transparent != -1) {
            this.lRH = GK(this.transparent);
        }
    }

    protected int GK(int i) {
        int i2;
        int i3 = 0;
        if (this.lRN == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.lRN.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.lRN[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.lRN[i9] & 255);
            int i13 = i6 - (this.lRN[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.lRO[i15] || i14 >= i7) {
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

    protected void dsK() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.lRK = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.lRK[i3] = (byte) ((i2 >> 0) & 255);
            this.lRK[i4] = (byte) ((i2 >> 8) & 255);
            this.lRK[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dsL() throws IOException {
        int i;
        int i2;
        this.lRJ.write(33);
        this.lRJ.write(249);
        this.lRJ.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.lRQ >= 0) {
            i2 = this.lRQ & 7;
        }
        this.lRJ.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.lRJ.write(this.lRH);
        this.lRJ.write(0);
    }

    protected void dsM() throws IOException {
        this.lRJ.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.lRS) {
            this.lRJ.write(0);
        } else {
            this.lRJ.write(this.lRP | 128);
        }
    }

    protected void dsN() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.lRJ.write(this.lRP | 240);
        this.lRJ.write(0);
        this.lRJ.write(0);
    }

    protected void dsO() throws IOException {
        this.lRJ.write(33);
        this.lRJ.write(255);
        this.lRJ.write(11);
        writeString("NETSCAPE2.0");
        this.lRJ.write(3);
        this.lRJ.write(1);
        writeShort(this.lRI);
        this.lRJ.write(0);
    }

    protected void dsP() throws IOException {
        this.lRJ.write(this.lRN, 0, this.lRN.length);
        int length = 768 - this.lRN.length;
        for (int i = 0; i < length; i++) {
            this.lRJ.write(0);
        }
    }

    protected void dsQ() throws IOException {
        new b(this.width, this.height, this.lRL, this.lRM).encode(this.lRJ);
    }

    protected void writeShort(int i) throws IOException {
        this.lRJ.write(i & 255);
        this.lRJ.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.lRJ.write((byte) str.charAt(i));
        }
    }
}
