package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Nu;
    protected int ggW;
    protected byte[] ggY;
    protected byte[] ggZ;
    protected int gha;
    protected byte[] ghb;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int ggX = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] ghc = new boolean[256];
    protected int ghd = 7;
    protected int ghe = -1;
    protected boolean ghf = false;
    protected boolean ghg = true;
    protected boolean ghh = false;
    protected int ghi = 10;

    public void sv(int i) {
        if (i >= 0) {
            this.ggX = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.ghh) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Nu = bitmap;
            blX();
            blW();
            if (this.ghg) {
                bma();
                bmc();
                if (this.ggX >= 0) {
                    bmb();
                }
            }
            blY();
            blZ();
            if (!this.ghg) {
                bmc();
            }
            bmd();
            this.ghg = false;
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
                if (this.ghf) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.ggW = 0;
            this.out = null;
            this.Nu = null;
            this.ggY = null;
            this.ggZ = null;
            this.ghb = null;
            this.ghf = false;
            this.ghg = true;
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
        this.ghh = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.ghf = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void blW() {
        int length = this.ggY.length;
        int i = length / 3;
        this.ggZ = new byte[i];
        c cVar = new c(this.ggY, length, this.ghi);
        this.ghb = cVar.bmj();
        for (int i2 = 0; i2 < this.ghb.length; i2 += 3) {
            byte b = this.ghb[i2];
            this.ghb[i2] = this.ghb[i2 + 2];
            this.ghb[i2 + 2] = b;
            this.ghc[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.ggY[i3] & 255, this.ggY[i5] & 255, this.ggY[i6] & 255);
            this.ghc[U] = true;
            this.ggZ[i4] = (byte) U;
        }
        this.ggY = null;
        this.gha = 8;
        this.ghd = 7;
        if (this.transparent != -1) {
            this.ggW = sw(this.transparent);
        }
    }

    protected int sw(int i) {
        int i2;
        int i3 = 0;
        if (this.ghb == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.ghb.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.ghb[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.ghb[i9] & 255);
            int i13 = i6 - (this.ghb[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.ghc[i15] || i14 >= i7) {
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

    protected void blX() {
        int width = this.Nu.getWidth();
        int height = this.Nu.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Nu, 0.0f, 0.0f, new Paint());
            this.Nu = createBitmap;
        }
        int[] u = u(this.Nu);
        this.ggY = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.ggY[i3] = (byte) ((i2 >> 0) & 255);
            this.ggY[i4] = (byte) ((i2 >> 8) & 255);
            this.ggY[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] u(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void blY() throws IOException {
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
        if (this.ghe >= 0) {
            i2 = this.ghe & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.ggW);
        this.out.write(0);
    }

    protected void blZ() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.ghg) {
            this.out.write(0);
        } else {
            this.out.write(this.ghd | 128);
        }
    }

    protected void bma() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.ghd | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bmb() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.ggX);
        this.out.write(0);
    }

    protected void bmc() throws IOException {
        this.out.write(this.ghb, 0, this.ghb.length);
        int length = 768 - this.ghb.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bmd() throws IOException {
        new b(this.width, this.height, this.ggZ, this.gha).encode(this.out);
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
