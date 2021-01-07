package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected byte[] mlr;
    protected byte[] mls;
    protected int mlt;
    protected byte[] mlu;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mlq = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] mlv = new boolean[256];
    protected int mlw = 7;
    protected int dispose = -1;
    protected boolean mlx = false;
    protected boolean mly = true;
    protected boolean mlz = false;
    protected int mlA = 10;

    public void HR(int i) {
        if (i >= 0) {
            this.mlq = i;
        }
    }

    public boolean H(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mlz) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dxt();
            dxs();
            if (this.mly) {
                dxw();
                dxy();
                if (this.mlq >= 0) {
                    dxx();
                }
            }
            dxu();
            dxv();
            if (!this.mly) {
                dxy();
            }
            dxz();
            this.mly = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dxr() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.mlx) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.mlr = null;
            this.mls = null;
            this.mlu = null;
            this.mlx = false;
            this.mly = true;
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
        this.mlz = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.mlx = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dxs() {
        int length = this.mlr.length;
        int i = length / 3;
        this.mls = new byte[i];
        c cVar = new c(this.mlr, length, this.mlA);
        this.mlu = cVar.dxF();
        for (int i2 = 0; i2 < this.mlu.length; i2 += 3) {
            byte b2 = this.mlu[i2];
            this.mlu[i2] = this.mlu[i2 + 2];
            this.mlu[i2 + 2] = b2;
            this.mlv[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Z = cVar.Z(this.mlr[i3] & 255, this.mlr[i5] & 255, this.mlr[i6] & 255);
            this.mlv[Z] = true;
            this.mls[i4] = (byte) Z;
        }
        this.mlr = null;
        this.mlt = 8;
        this.mlw = 7;
        if (this.transparent != -1) {
            this.transIndex = HS(this.transparent);
        }
    }

    protected int HS(int i) {
        if (this.mlu == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 0) & 255;
        int i5 = 16777216;
        int length = this.mlu.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int i9 = i2 - (this.mlu[i6] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (this.mlu[i8] & 255);
            int i12 = i4 - (this.mlu[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (!this.mlv[i14] || i13 >= i5) {
                i13 = i5;
                i14 = i7;
            }
            i6 = i10 + 1;
            i5 = i13;
            i7 = i14;
        }
        return i7;
    }

    protected void dxt() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] I = I(this.image);
        this.mlr = new byte[I.length * 3];
        for (int i = 0; i < I.length; i++) {
            int i2 = I[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.mlr[i3] = (byte) ((i2 >> 0) & 255);
            this.mlr[i4] = (byte) ((i2 >> 8) & 255);
            this.mlr[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] I(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dxu() throws IOException {
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
        if (this.dispose >= 0) {
            i2 = this.dispose & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    protected void dxv() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.mly) {
            this.out.write(0);
        } else {
            this.out.write(this.mlw | 128);
        }
    }

    protected void dxw() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.mlw | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void dxx() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.mlq);
        this.out.write(0);
    }

    protected void dxy() throws IOException {
        this.out.write(this.mlu, 0, this.mlu.length);
        int length = 768 - this.mlu.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void dxz() throws IOException {
        new b(this.width, this.height, this.mls, this.mlt).encode(this.out);
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
