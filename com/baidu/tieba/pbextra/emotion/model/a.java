package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class a {
    protected Bitmap NR;
    protected int hHG;
    protected byte[] hHI;
    protected byte[] hHJ;
    protected int hHK;
    protected byte[] hHL;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int hHH = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] hHM = new boolean[256];
    protected int hHN = 7;
    protected int hHO = -1;
    protected boolean hHP = false;
    protected boolean hHQ = true;
    protected boolean hHR = false;
    protected int hHS = 10;

    public void wM(int i) {
        if (i >= 0) {
            this.hHH = i;
        }
    }

    public boolean B(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.hHR) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.NR = bitmap;
            bPF();
            bPE();
            if (this.hHQ) {
                bPI();
                bPK();
                if (this.hHH >= 0) {
                    bPJ();
                }
            }
            bPG();
            bPH();
            if (!this.hHQ) {
                bPK();
            }
            bPL();
            this.hHQ = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean tt() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.hHP) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.hHG = 0;
            this.out = null;
            this.NR = null;
            this.hHI = null;
            this.hHJ = null;
            this.hHL = null;
            this.hHP = false;
            this.hHQ = true;
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
        this.hHR = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.hHP = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bPE() {
        int length = this.hHI.length;
        int i = length / 3;
        this.hHJ = new byte[i];
        c cVar = new c(this.hHI, length, this.hHS);
        this.hHL = cVar.bPR();
        for (int i2 = 0; i2 < this.hHL.length; i2 += 3) {
            byte b = this.hHL[i2];
            this.hHL[i2] = this.hHL[i2 + 2];
            this.hHL[i2 + 2] = b;
            this.hHM[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int X = cVar.X(this.hHI[i3] & 255, this.hHI[i5] & 255, this.hHI[i6] & 255);
            this.hHM[X] = true;
            this.hHJ[i4] = (byte) X;
        }
        this.hHI = null;
        this.hHK = 8;
        this.hHN = 7;
        if (this.transparent != -1) {
            this.hHG = wN(this.transparent);
        }
    }

    protected int wN(int i) {
        int i2;
        int i3 = 0;
        if (this.hHL == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.hHL.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.hHL[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.hHL[i9] & 255);
            int i13 = i6 - (this.hHL[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.hHM[i15] || i14 >= i7) {
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

    protected void bPF() {
        int width = this.NR.getWidth();
        int height = this.NR.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.NR, 0.0f, 0.0f, new Paint());
            this.NR = createBitmap;
        }
        int[] C = C(this.NR);
        this.hHI = new byte[C.length * 3];
        for (int i = 0; i < C.length; i++) {
            int i2 = C[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.hHI[i3] = (byte) ((i2 >> 0) & 255);
            this.hHI[i4] = (byte) ((i2 >> 8) & 255);
            this.hHI[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] C(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bPG() throws IOException {
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
        if (this.hHO >= 0) {
            i2 = this.hHO & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.hHG);
        this.out.write(0);
    }

    protected void bPH() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.hHQ) {
            this.out.write(0);
        } else {
            this.out.write(this.hHN | 128);
        }
    }

    protected void bPI() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.hHN | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bPJ() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.hHH);
        this.out.write(0);
    }

    protected void bPK() throws IOException {
        this.out.write(this.hHL, 0, this.hHL.length);
        int length = 768 - this.hHL.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bPL() throws IOException {
        new b(this.width, this.height, this.hHJ, this.hHK).encode(this.out);
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
