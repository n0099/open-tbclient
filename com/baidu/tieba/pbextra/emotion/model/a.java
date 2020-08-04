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
    protected int kLj;
    protected OutputStream kLl;
    protected byte[] kLm;
    protected byte[] kLn;
    protected int kLo;
    protected byte[] kLp;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int kLk = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] kLq = new boolean[256];
    protected int kLr = 7;
    protected int kLs = -1;
    protected boolean kLt = false;
    protected boolean kLu = true;
    protected boolean kLv = false;
    protected int kLw = 10;

    public void CC(int i) {
        if (i >= 0) {
            this.kLk = i;
        }
    }

    public boolean H(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.kLv) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cUQ();
            cUP();
            if (this.kLu) {
                cUT();
                cUV();
                if (this.kLk >= 0) {
                    cUU();
                }
            }
            cUR();
            cUS();
            if (!this.kLu) {
                cUV();
            }
            cUW();
            this.kLu = false;
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
                this.kLl.write(59);
                this.kLl.flush();
                if (this.kLt) {
                    this.kLl.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.kLj = 0;
            this.kLl = null;
            this.image = null;
            this.kLm = null;
            this.kLn = null;
            this.kLp = null;
            this.kLt = false;
            this.kLu = true;
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
        this.kLv = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.kLt = false;
        this.kLl = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void cUP() {
        int length = this.kLm.length;
        int i = length / 3;
        this.kLn = new byte[i];
        c cVar = new c(this.kLm, length, this.kLw);
        this.kLp = cVar.cVc();
        for (int i2 = 0; i2 < this.kLp.length; i2 += 3) {
            byte b = this.kLp[i2];
            this.kLp[i2] = this.kLp[i2 + 2];
            this.kLp[i2 + 2] = b;
            this.kLq[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.kLm[i3] & 255, this.kLm[i5] & 255, this.kLm[i6] & 255);
            this.kLq[U] = true;
            this.kLn[i4] = (byte) U;
        }
        this.kLm = null;
        this.kLo = 8;
        this.kLr = 7;
        if (this.transparent != -1) {
            this.kLj = CD(this.transparent);
        }
    }

    protected int CD(int i) {
        int i2;
        int i3 = 0;
        if (this.kLp == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.kLp.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.kLp[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.kLp[i9] & 255);
            int i13 = i6 - (this.kLp[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.kLq[i15] || i14 >= i7) {
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
        this.kLm = new byte[I.length * 3];
        for (int i = 0; i < I.length; i++) {
            int i2 = I[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.kLm[i3] = (byte) ((i2 >> 0) & 255);
            this.kLm[i4] = (byte) ((i2 >> 8) & 255);
            this.kLm[i4 + 1] = (byte) ((i2 >> 16) & 255);
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
        this.kLl.write(33);
        this.kLl.write(249);
        this.kLl.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.kLs >= 0) {
            i2 = this.kLs & 7;
        }
        this.kLl.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.kLl.write(this.kLj);
        this.kLl.write(0);
    }

    protected void cUS() throws IOException {
        this.kLl.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.kLu) {
            this.kLl.write(0);
        } else {
            this.kLl.write(this.kLr | 128);
        }
    }

    protected void cUT() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.kLl.write(this.kLr | 240);
        this.kLl.write(0);
        this.kLl.write(0);
    }

    protected void cUU() throws IOException {
        this.kLl.write(33);
        this.kLl.write(255);
        this.kLl.write(11);
        writeString("NETSCAPE2.0");
        this.kLl.write(3);
        this.kLl.write(1);
        writeShort(this.kLk);
        this.kLl.write(0);
    }

    protected void cUV() throws IOException {
        this.kLl.write(this.kLp, 0, this.kLp.length);
        int length = 768 - this.kLp.length;
        for (int i = 0; i < length; i++) {
            this.kLl.write(0);
        }
    }

    protected void cUW() throws IOException {
        new b(this.width, this.height, this.kLn, this.kLo).encode(this.kLl);
    }

    protected void writeShort(int i) throws IOException {
        this.kLl.write(i & 255);
        this.kLl.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.kLl.write((byte) str.charAt(i));
        }
    }
}
