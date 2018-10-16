package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Nr;
    protected byte[] gfB;
    protected byte[] gfC;
    protected int gfD;
    protected byte[] gfE;
    protected int gfz;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int gfA = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] gfF = new boolean[256];
    protected int gfG = 7;
    protected int gfH = -1;
    protected boolean gfI = false;
    protected boolean gfJ = true;
    protected boolean gfK = false;
    protected int gfL = 10;

    public void sc(int i) {
        if (i >= 0) {
            this.gfA = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.gfK) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Nr = bitmap;
            bmB();
            bmA();
            if (this.gfJ) {
                bmE();
                bmG();
                if (this.gfA >= 0) {
                    bmF();
                }
            }
            bmC();
            bmD();
            if (!this.gfJ) {
                bmG();
            }
            bmH();
            this.gfJ = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean finish() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.gfI) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.gfz = 0;
            this.out = null;
            this.Nr = null;
            this.gfB = null;
            this.gfC = null;
            this.gfE = null;
            this.gfI = false;
            this.gfJ = true;
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
        this.gfK = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.gfI = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bmA() {
        int length = this.gfB.length;
        int i = length / 3;
        this.gfC = new byte[i];
        c cVar = new c(this.gfB, length, this.gfL);
        this.gfE = cVar.bmN();
        for (int i2 = 0; i2 < this.gfE.length; i2 += 3) {
            byte b = this.gfE[i2];
            this.gfE[i2] = this.gfE[i2 + 2];
            this.gfE[i2 + 2] = b;
            this.gfF[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.gfB[i3] & 255, this.gfB[i5] & 255, this.gfB[i6] & 255);
            this.gfF[U] = true;
            this.gfC[i4] = (byte) U;
        }
        this.gfB = null;
        this.gfD = 8;
        this.gfG = 7;
        if (this.transparent != -1) {
            this.gfz = sd(this.transparent);
        }
    }

    protected int sd(int i) {
        int i2;
        int i3 = 0;
        if (this.gfE == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.gfE.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.gfE[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.gfE[i9] & 255);
            int i13 = i6 - (this.gfE[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.gfF[i15] || i14 >= i7) {
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

    protected void bmB() {
        int width = this.Nr.getWidth();
        int height = this.Nr.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Nr, 0.0f, 0.0f, new Paint());
            this.Nr = createBitmap;
        }
        int[] u = u(this.Nr);
        this.gfB = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.gfB[i3] = (byte) ((i2 >> 0) & 255);
            this.gfB[i4] = (byte) ((i2 >> 8) & 255);
            this.gfB[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] u(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bmC() throws IOException {
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
        if (this.gfH >= 0) {
            i2 = this.gfH & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.gfz);
        this.out.write(0);
    }

    protected void bmD() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.gfJ) {
            this.out.write(0);
        } else {
            this.out.write(this.gfG | 128);
        }
    }

    protected void bmE() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.gfG | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bmF() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.gfA);
        this.out.write(0);
    }

    protected void bmG() throws IOException {
        this.out.write(this.gfE, 0, this.gfE.length);
        int length = 768 - this.gfE.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bmH() throws IOException {
        new b(this.width, this.height, this.gfC, this.gfD).encode(this.out);
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
