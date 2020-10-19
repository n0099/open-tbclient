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
    protected int lzo;
    protected OutputStream lzq;
    protected byte[] lzr;
    protected byte[] lzs;
    protected int lzt;
    protected byte[] lzu;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int lzp = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] lzv = new boolean[256];
    protected int lzw = 7;
    protected int lzx = -1;
    protected boolean lzy = false;
    protected boolean lzz = true;
    protected boolean lzA = false;
    protected int lzB = 10;

    public void Gd(int i) {
        if (i >= 0) {
            this.lzp = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.lzA) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dna();
            dmZ();
            if (this.lzz) {
                dnd();
                dnf();
                if (this.lzp >= 0) {
                    dne();
                }
            }
            dnb();
            dnc();
            if (!this.lzz) {
                dnf();
            }
            dng();
            this.lzz = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dmY() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.lzq.write(59);
                this.lzq.flush();
                if (this.lzy) {
                    this.lzq.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.lzo = 0;
            this.lzq = null;
            this.image = null;
            this.lzr = null;
            this.lzs = null;
            this.lzu = null;
            this.lzy = false;
            this.lzz = true;
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
        this.lzA = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.lzy = false;
        this.lzq = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dmZ() {
        int length = this.lzr.length;
        int i = length / 3;
        this.lzs = new byte[i];
        c cVar = new c(this.lzr, length, this.lzB);
        this.lzu = cVar.dnm();
        for (int i2 = 0; i2 < this.lzu.length; i2 += 3) {
            byte b = this.lzu[i2];
            this.lzu[i2] = this.lzu[i2 + 2];
            this.lzu[i2 + 2] = b;
            this.lzv[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int V = cVar.V(this.lzr[i3] & 255, this.lzr[i5] & 255, this.lzr[i6] & 255);
            this.lzv[V] = true;
            this.lzs[i4] = (byte) V;
        }
        this.lzr = null;
        this.lzt = 8;
        this.lzw = 7;
        if (this.transparent != -1) {
            this.lzo = Ge(this.transparent);
        }
    }

    protected int Ge(int i) {
        int i2;
        int i3 = 0;
        if (this.lzu == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.lzu.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.lzu[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.lzu[i9] & 255);
            int i13 = i6 - (this.lzu[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.lzv[i15] || i14 >= i7) {
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

    protected void dna() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.lzr = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.lzr[i3] = (byte) ((i2 >> 0) & 255);
            this.lzr[i4] = (byte) ((i2 >> 8) & 255);
            this.lzr[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dnb() throws IOException {
        int i;
        int i2;
        this.lzq.write(33);
        this.lzq.write(249);
        this.lzq.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.lzx >= 0) {
            i2 = this.lzx & 7;
        }
        this.lzq.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.lzq.write(this.lzo);
        this.lzq.write(0);
    }

    protected void dnc() throws IOException {
        this.lzq.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.lzz) {
            this.lzq.write(0);
        } else {
            this.lzq.write(this.lzw | 128);
        }
    }

    protected void dnd() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.lzq.write(this.lzw | 240);
        this.lzq.write(0);
        this.lzq.write(0);
    }

    protected void dne() throws IOException {
        this.lzq.write(33);
        this.lzq.write(255);
        this.lzq.write(11);
        writeString("NETSCAPE2.0");
        this.lzq.write(3);
        this.lzq.write(1);
        writeShort(this.lzp);
        this.lzq.write(0);
    }

    protected void dnf() throws IOException {
        this.lzq.write(this.lzu, 0, this.lzu.length);
        int length = 768 - this.lzu.length;
        for (int i = 0; i < length; i++) {
            this.lzq.write(0);
        }
    }

    protected void dng() throws IOException {
        new b(this.width, this.height, this.lzs, this.lzt).encode(this.lzq);
    }

    protected void writeShort(int i) throws IOException {
        this.lzq.write(i & 255);
        this.lzq.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.lzq.write((byte) str.charAt(i));
        }
    }
}
