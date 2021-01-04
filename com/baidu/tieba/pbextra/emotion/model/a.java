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
    protected byte[] mls;
    protected byte[] mlt;
    protected int mlu;
    protected byte[] mlv;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mlr = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] mlw = new boolean[256];
    protected int mlx = 7;
    protected int dispose = -1;
    protected boolean mly = false;
    protected boolean mlz = true;
    protected boolean mlA = false;
    protected int mlB = 10;

    public void HR(int i) {
        if (i >= 0) {
            this.mlr = i;
        }
    }

    public boolean H(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mlA) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dxs();
            dxr();
            if (this.mlz) {
                dxv();
                dxx();
                if (this.mlr >= 0) {
                    dxw();
                }
            }
            dxt();
            dxu();
            if (!this.mlz) {
                dxx();
            }
            dxy();
            this.mlz = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dxq() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.mly) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.mls = null;
            this.mlt = null;
            this.mlv = null;
            this.mly = false;
            this.mlz = true;
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
        this.mlA = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.mly = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dxr() {
        int length = this.mls.length;
        int i = length / 3;
        this.mlt = new byte[i];
        c cVar = new c(this.mls, length, this.mlB);
        this.mlv = cVar.dxE();
        for (int i2 = 0; i2 < this.mlv.length; i2 += 3) {
            byte b2 = this.mlv[i2];
            this.mlv[i2] = this.mlv[i2 + 2];
            this.mlv[i2 + 2] = b2;
            this.mlw[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Z = cVar.Z(this.mls[i3] & 255, this.mls[i5] & 255, this.mls[i6] & 255);
            this.mlw[Z] = true;
            this.mlt[i4] = (byte) Z;
        }
        this.mls = null;
        this.mlu = 8;
        this.mlx = 7;
        if (this.transparent != -1) {
            this.transIndex = HS(this.transparent);
        }
    }

    protected int HS(int i) {
        if (this.mlv == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 0) & 255;
        int i5 = 16777216;
        int length = this.mlv.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int i9 = i2 - (this.mlv[i6] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (this.mlv[i8] & 255);
            int i12 = i4 - (this.mlv[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (!this.mlw[i14] || i13 >= i5) {
                i13 = i5;
                i14 = i7;
            }
            i6 = i10 + 1;
            i5 = i13;
            i7 = i14;
        }
        return i7;
    }

    protected void dxs() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] I = I(this.image);
        this.mls = new byte[I.length * 3];
        for (int i = 0; i < I.length; i++) {
            int i2 = I[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.mls[i3] = (byte) ((i2 >> 0) & 255);
            this.mls[i4] = (byte) ((i2 >> 8) & 255);
            this.mls[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] I(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dxt() throws IOException {
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

    protected void dxu() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.mlz) {
            this.out.write(0);
        } else {
            this.out.write(this.mlx | 128);
        }
    }

    protected void dxv() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.mlx | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void dxw() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.mlr);
        this.out.write(0);
    }

    protected void dxx() throws IOException {
        this.out.write(this.mlv, 0, this.mlv.length);
        int length = 768 - this.mlv.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void dxy() throws IOException {
        new b(this.width, this.height, this.mlt, this.mlu).encode(this.out);
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
