package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Nr;
    protected int gfA;
    protected byte[] gfC;
    protected byte[] gfD;
    protected int gfE;
    protected byte[] gfF;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int gfB = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] gfG = new boolean[256];
    protected int gfH = 7;
    protected int gfI = -1;
    protected boolean gfJ = false;
    protected boolean gfK = true;
    protected boolean gfL = false;
    protected int gfM = 10;

    public void sc(int i) {
        if (i >= 0) {
            this.gfB = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.gfL) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Nr = bitmap;
            bmB();
            bmA();
            if (this.gfK) {
                bmE();
                bmG();
                if (this.gfB >= 0) {
                    bmF();
                }
            }
            bmC();
            bmD();
            if (!this.gfK) {
                bmG();
            }
            bmH();
            this.gfK = false;
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
                if (this.gfJ) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.gfA = 0;
            this.out = null;
            this.Nr = null;
            this.gfC = null;
            this.gfD = null;
            this.gfF = null;
            this.gfJ = false;
            this.gfK = true;
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
        this.gfL = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.gfJ = false;
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
        int length = this.gfC.length;
        int i = length / 3;
        this.gfD = new byte[i];
        c cVar = new c(this.gfC, length, this.gfM);
        this.gfF = cVar.bmN();
        for (int i2 = 0; i2 < this.gfF.length; i2 += 3) {
            byte b = this.gfF[i2];
            this.gfF[i2] = this.gfF[i2 + 2];
            this.gfF[i2 + 2] = b;
            this.gfG[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.gfC[i3] & 255, this.gfC[i5] & 255, this.gfC[i6] & 255);
            this.gfG[U] = true;
            this.gfD[i4] = (byte) U;
        }
        this.gfC = null;
        this.gfE = 8;
        this.gfH = 7;
        if (this.transparent != -1) {
            this.gfA = sd(this.transparent);
        }
    }

    protected int sd(int i) {
        int i2;
        int i3 = 0;
        if (this.gfF == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.gfF.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.gfF[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.gfF[i9] & 255);
            int i13 = i6 - (this.gfF[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.gfG[i15] || i14 >= i7) {
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
        this.gfC = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.gfC[i3] = (byte) ((i2 >> 0) & 255);
            this.gfC[i4] = (byte) ((i2 >> 8) & 255);
            this.gfC[i4 + 1] = (byte) ((i2 >> 16) & 255);
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
        if (this.gfI >= 0) {
            i2 = this.gfI & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.gfA);
        this.out.write(0);
    }

    protected void bmD() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.gfK) {
            this.out.write(0);
        } else {
            this.out.write(this.gfH | 128);
        }
    }

    protected void bmE() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.gfH | 240);
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
        writeShort(this.gfB);
        this.out.write(0);
    }

    protected void bmG() throws IOException {
        this.out.write(this.gfF, 0, this.gfF.length);
        int length = 768 - this.gfF.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bmH() throws IOException {
        new b(this.width, this.height, this.gfD, this.gfE).encode(this.out);
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
