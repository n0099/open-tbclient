package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap MW;
    protected int fXY;
    protected byte[] fYa;
    protected byte[] fYb;
    protected int fYc;
    protected byte[] fYd;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int fXZ = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] fYe = new boolean[256];
    protected int fYf = 7;
    protected int fYg = -1;
    protected boolean fYh = false;
    protected boolean fYi = true;
    protected boolean fYj = false;
    protected int fYk = 10;

    public void rF(int i) {
        if (i >= 0) {
            this.fXZ = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.fYj) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.MW = bitmap;
            bjq();
            bjp();
            if (this.fYi) {
                bjt();
                bjv();
                if (this.fXZ >= 0) {
                    bju();
                }
            }
            bjr();
            bjs();
            if (!this.fYi) {
                bjv();
            }
            bjw();
            this.fYi = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean bjo() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.fYh) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.fXY = 0;
            this.out = null;
            this.MW = null;
            this.fYa = null;
            this.fYb = null;
            this.fYd = null;
            this.fYh = false;
            this.fYi = true;
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
        this.fYj = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.fYh = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bjp() {
        int length = this.fYa.length;
        int i = length / 3;
        this.fYb = new byte[i];
        c cVar = new c(this.fYa, length, this.fYk);
        this.fYd = cVar.bjC();
        for (int i2 = 0; i2 < this.fYd.length; i2 += 3) {
            byte b = this.fYd[i2];
            this.fYd[i2] = this.fYd[i2 + 2];
            this.fYd[i2 + 2] = b;
            this.fYe[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.fYa[i3] & 255, this.fYa[i5] & 255, this.fYa[i6] & 255);
            this.fYe[U] = true;
            this.fYb[i4] = (byte) U;
        }
        this.fYa = null;
        this.fYc = 8;
        this.fYf = 7;
        if (this.transparent != -1) {
            this.fXY = rG(this.transparent);
        }
    }

    protected int rG(int i) {
        int i2;
        int i3 = 0;
        if (this.fYd == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.fYd.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.fYd[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.fYd[i9] & 255);
            int i13 = i6 - (this.fYd[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.fYe[i15] || i14 >= i7) {
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

    protected void bjq() {
        int width = this.MW.getWidth();
        int height = this.MW.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.MW, 0.0f, 0.0f, new Paint());
            this.MW = createBitmap;
        }
        int[] u = u(this.MW);
        this.fYa = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.fYa[i3] = (byte) ((i2 >> 0) & 255);
            this.fYa[i4] = (byte) ((i2 >> 8) & 255);
            this.fYa[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] u(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bjr() throws IOException {
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
        if (this.fYg >= 0) {
            i2 = this.fYg & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.fXY);
        this.out.write(0);
    }

    protected void bjs() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.fYi) {
            this.out.write(0);
        } else {
            this.out.write(this.fYf | 128);
        }
    }

    protected void bjt() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.fYf | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bju() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.fXZ);
        this.out.write(0);
    }

    protected void bjv() throws IOException {
        this.out.write(this.fYd, 0, this.fYd.length);
        int length = 768 - this.fYd.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bjw() throws IOException {
        new b(this.width, this.height, this.fYb, this.fYc).encode(this.out);
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
