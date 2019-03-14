package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class a {
    protected Bitmap NR;
    protected int hHU;
    protected byte[] hHW;
    protected byte[] hHX;
    protected int hHY;
    protected byte[] hHZ;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int hHV = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] hIa = new boolean[256];
    protected int hIb = 7;
    protected int hIc = -1;
    protected boolean hId = false;
    protected boolean hIe = true;
    protected boolean hIf = false;
    protected int hIg = 10;

    public void wQ(int i) {
        if (i >= 0) {
            this.hHV = i;
        }
    }

    public boolean B(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.hIf) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.NR = bitmap;
            bPI();
            bPH();
            if (this.hIe) {
                bPL();
                bPN();
                if (this.hHV >= 0) {
                    bPM();
                }
            }
            bPJ();
            bPK();
            if (!this.hIe) {
                bPN();
            }
            bPO();
            this.hIe = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean tu() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.hId) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.hHU = 0;
            this.out = null;
            this.NR = null;
            this.hHW = null;
            this.hHX = null;
            this.hHZ = null;
            this.hId = false;
            this.hIe = true;
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
        this.hIf = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.hId = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bPH() {
        int length = this.hHW.length;
        int i = length / 3;
        this.hHX = new byte[i];
        c cVar = new c(this.hHW, length, this.hIg);
        this.hHZ = cVar.bPU();
        for (int i2 = 0; i2 < this.hHZ.length; i2 += 3) {
            byte b = this.hHZ[i2];
            this.hHZ[i2] = this.hHZ[i2 + 2];
            this.hHZ[i2 + 2] = b;
            this.hIa[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int X = cVar.X(this.hHW[i3] & 255, this.hHW[i5] & 255, this.hHW[i6] & 255);
            this.hIa[X] = true;
            this.hHX[i4] = (byte) X;
        }
        this.hHW = null;
        this.hHY = 8;
        this.hIb = 7;
        if (this.transparent != -1) {
            this.hHU = wR(this.transparent);
        }
    }

    protected int wR(int i) {
        int i2;
        int i3 = 0;
        if (this.hHZ == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.hHZ.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.hHZ[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.hHZ[i9] & 255);
            int i13 = i6 - (this.hHZ[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.hIa[i15] || i14 >= i7) {
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

    protected void bPI() {
        int width = this.NR.getWidth();
        int height = this.NR.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.NR, 0.0f, 0.0f, new Paint());
            this.NR = createBitmap;
        }
        int[] C = C(this.NR);
        this.hHW = new byte[C.length * 3];
        for (int i = 0; i < C.length; i++) {
            int i2 = C[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.hHW[i3] = (byte) ((i2 >> 0) & 255);
            this.hHW[i4] = (byte) ((i2 >> 8) & 255);
            this.hHW[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] C(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bPJ() throws IOException {
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
        if (this.hIc >= 0) {
            i2 = this.hIc & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.hHU);
        this.out.write(0);
    }

    protected void bPK() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.hIe) {
            this.out.write(0);
        } else {
            this.out.write(this.hIb | 128);
        }
    }

    protected void bPL() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.hIb | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bPM() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.hHV);
        this.out.write(0);
    }

    protected void bPN() throws IOException {
        this.out.write(this.hHZ, 0, this.hHZ.length);
        int length = 768 - this.hHZ.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bPO() throws IOException {
        new b(this.width, this.height, this.hHX, this.hHY).encode(this.out);
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
