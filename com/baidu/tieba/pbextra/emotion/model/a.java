package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected byte[] jPA;
    protected int jPu;
    protected OutputStream jPw;
    protected byte[] jPx;
    protected byte[] jPy;
    protected int jPz;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int jPv = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] jPB = new boolean[256];
    protected int jPC = 7;
    protected int jPD = -1;
    protected boolean jPE = false;
    protected boolean jPF = true;
    protected boolean jPG = false;
    protected int jPH = 10;

    public void An(int i) {
        if (i >= 0) {
            this.jPv = i;
        }
    }

    public boolean C(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.jPG) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cFs();
            cFr();
            if (this.jPF) {
                cFv();
                cFx();
                if (this.jPv >= 0) {
                    cFw();
                }
            }
            cFt();
            cFu();
            if (!this.jPF) {
                cFx();
            }
            cFy();
            this.jPF = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cFq() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.jPw.write(59);
                this.jPw.flush();
                if (this.jPE) {
                    this.jPw.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.jPu = 0;
            this.jPw = null;
            this.image = null;
            this.jPx = null;
            this.jPy = null;
            this.jPA = null;
            this.jPE = false;
            this.jPF = true;
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
        this.jPG = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.jPE = false;
        this.jPw = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void cFr() {
        int length = this.jPx.length;
        int i = length / 3;
        this.jPy = new byte[i];
        c cVar = new c(this.jPx, length, this.jPH);
        this.jPA = cVar.cFE();
        for (int i2 = 0; i2 < this.jPA.length; i2 += 3) {
            byte b = this.jPA[i2];
            this.jPA[i2] = this.jPA[i2 + 2];
            this.jPA[i2 + 2] = b;
            this.jPB[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int V = cVar.V(this.jPx[i3] & 255, this.jPx[i5] & 255, this.jPx[i6] & 255);
            this.jPB[V] = true;
            this.jPy[i4] = (byte) V;
        }
        this.jPx = null;
        this.jPz = 8;
        this.jPC = 7;
        if (this.transparent != -1) {
            this.jPu = Ao(this.transparent);
        }
    }

    protected int Ao(int i) {
        int i2;
        int i3 = 0;
        if (this.jPA == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.jPA.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.jPA[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.jPA[i9] & 255);
            int i13 = i6 - (this.jPA[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.jPB[i15] || i14 >= i7) {
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

    protected void cFs() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] D = D(this.image);
        this.jPx = new byte[D.length * 3];
        for (int i = 0; i < D.length; i++) {
            int i2 = D[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.jPx[i3] = (byte) ((i2 >> 0) & 255);
            this.jPx[i4] = (byte) ((i2 >> 8) & 255);
            this.jPx[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cFt() throws IOException {
        int i;
        int i2;
        this.jPw.write(33);
        this.jPw.write(249);
        this.jPw.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.jPD >= 0) {
            i2 = this.jPD & 7;
        }
        this.jPw.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.jPw.write(this.jPu);
        this.jPw.write(0);
    }

    protected void cFu() throws IOException {
        this.jPw.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.jPF) {
            this.jPw.write(0);
        } else {
            this.jPw.write(this.jPC | 128);
        }
    }

    protected void cFv() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.jPw.write(this.jPC | 240);
        this.jPw.write(0);
        this.jPw.write(0);
    }

    protected void cFw() throws IOException {
        this.jPw.write(33);
        this.jPw.write(255);
        this.jPw.write(11);
        writeString("NETSCAPE2.0");
        this.jPw.write(3);
        this.jPw.write(1);
        writeShort(this.jPv);
        this.jPw.write(0);
    }

    protected void cFx() throws IOException {
        this.jPw.write(this.jPA, 0, this.jPA.length);
        int length = 768 - this.jPA.length;
        for (int i = 0; i < length; i++) {
            this.jPw.write(0);
        }
    }

    protected void cFy() throws IOException {
        new b(this.width, this.height, this.jPy, this.jPz).encode(this.jPw);
    }

    protected void writeShort(int i) throws IOException {
        this.jPw.write(i & 255);
        this.jPw.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.jPw.write((byte) str.charAt(i));
        }
    }
}
