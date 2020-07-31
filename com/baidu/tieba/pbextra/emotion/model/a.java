package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes16.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected int kLh;
    protected OutputStream kLj;
    protected byte[] kLk;
    protected byte[] kLl;
    protected int kLm;
    protected byte[] kLn;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int kLi = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] kLo = new boolean[256];
    protected int kLp = 7;
    protected int kLq = -1;
    protected boolean kLr = false;
    protected boolean kLs = true;
    protected boolean kLt = false;
    protected int kLu = 10;

    public void CC(int i) {
        if (i >= 0) {
            this.kLi = i;
        }
    }

    public boolean H(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.kLt) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cUQ();
            cUP();
            if (this.kLs) {
                cUT();
                cUV();
                if (this.kLi >= 0) {
                    cUU();
                }
            }
            cUR();
            cUS();
            if (!this.kLs) {
                cUV();
            }
            cUW();
            this.kLs = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cUO() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.kLj.write(59);
                this.kLj.flush();
                if (this.kLr) {
                    this.kLj.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.kLh = 0;
            this.kLj = null;
            this.image = null;
            this.kLk = null;
            this.kLl = null;
            this.kLn = null;
            this.kLr = false;
            this.kLs = true;
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
        this.kLt = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.kLr = false;
        this.kLj = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void cUP() {
        int length = this.kLk.length;
        int i = length / 3;
        this.kLl = new byte[i];
        c cVar = new c(this.kLk, length, this.kLu);
        this.kLn = cVar.cVc();
        for (int i2 = 0; i2 < this.kLn.length; i2 += 3) {
            byte b = this.kLn[i2];
            this.kLn[i2] = this.kLn[i2 + 2];
            this.kLn[i2 + 2] = b;
            this.kLo[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.kLk[i3] & 255, this.kLk[i5] & 255, this.kLk[i6] & 255);
            this.kLo[U] = true;
            this.kLl[i4] = (byte) U;
        }
        this.kLk = null;
        this.kLm = 8;
        this.kLp = 7;
        if (this.transparent != -1) {
            this.kLh = CD(this.transparent);
        }
    }

    protected int CD(int i) {
        int i2;
        int i3 = 0;
        if (this.kLn == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.kLn.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.kLn[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.kLn[i9] & 255);
            int i13 = i6 - (this.kLn[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.kLo[i15] || i14 >= i7) {
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

    protected void cUQ() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] I = I(this.image);
        this.kLk = new byte[I.length * 3];
        for (int i = 0; i < I.length; i++) {
            int i2 = I[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.kLk[i3] = (byte) ((i2 >> 0) & 255);
            this.kLk[i4] = (byte) ((i2 >> 8) & 255);
            this.kLk[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] I(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cUR() throws IOException {
        int i;
        int i2;
        this.kLj.write(33);
        this.kLj.write(249);
        this.kLj.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.kLq >= 0) {
            i2 = this.kLq & 7;
        }
        this.kLj.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.kLj.write(this.kLh);
        this.kLj.write(0);
    }

    protected void cUS() throws IOException {
        this.kLj.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.kLs) {
            this.kLj.write(0);
        } else {
            this.kLj.write(this.kLp | 128);
        }
    }

    protected void cUT() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.kLj.write(this.kLp | 240);
        this.kLj.write(0);
        this.kLj.write(0);
    }

    protected void cUU() throws IOException {
        this.kLj.write(33);
        this.kLj.write(255);
        this.kLj.write(11);
        writeString("NETSCAPE2.0");
        this.kLj.write(3);
        this.kLj.write(1);
        writeShort(this.kLi);
        this.kLj.write(0);
    }

    protected void cUV() throws IOException {
        this.kLj.write(this.kLn, 0, this.kLn.length);
        int length = 768 - this.kLn.length;
        for (int i = 0; i < length; i++) {
            this.kLj.write(0);
        }
    }

    protected void cUW() throws IOException {
        new b(this.width, this.height, this.kLl, this.kLm).encode(this.kLj);
    }

    protected void writeShort(int i) throws IOException {
        this.kLj.write(i & 255);
        this.kLj.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.kLj.write((byte) str.charAt(i));
        }
    }
}
