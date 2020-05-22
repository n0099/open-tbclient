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
    protected int khm;
    protected OutputStream kho;
    protected byte[] khp;
    protected byte[] khq;
    protected int khr;
    protected byte[] khs;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int khn = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] kht = new boolean[256];
    protected int khu = 7;
    protected int khv = -1;
    protected boolean khw = false;
    protected boolean khx = true;
    protected boolean khy = false;
    protected int khz = 10;

    public void AY(int i) {
        if (i >= 0) {
            this.khn = i;
        }
    }

    public boolean E(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.khy) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cMs();
            cMr();
            if (this.khx) {
                cMv();
                cMx();
                if (this.khn >= 0) {
                    cMw();
                }
            }
            cMt();
            cMu();
            if (!this.khx) {
                cMx();
            }
            cMy();
            this.khx = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cMq() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.kho.write(59);
                this.kho.flush();
                if (this.khw) {
                    this.kho.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.khm = 0;
            this.kho = null;
            this.image = null;
            this.khp = null;
            this.khq = null;
            this.khs = null;
            this.khw = false;
            this.khx = true;
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
        this.khy = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.khw = false;
        this.kho = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void cMr() {
        int length = this.khp.length;
        int i = length / 3;
        this.khq = new byte[i];
        c cVar = new c(this.khp, length, this.khz);
        this.khs = cVar.cME();
        for (int i2 = 0; i2 < this.khs.length; i2 += 3) {
            byte b = this.khs[i2];
            this.khs[i2] = this.khs[i2 + 2];
            this.khs[i2 + 2] = b;
            this.kht[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int V = cVar.V(this.khp[i3] & 255, this.khp[i5] & 255, this.khp[i6] & 255);
            this.kht[V] = true;
            this.khq[i4] = (byte) V;
        }
        this.khp = null;
        this.khr = 8;
        this.khu = 7;
        if (this.transparent != -1) {
            this.khm = AZ(this.transparent);
        }
    }

    protected int AZ(int i) {
        int i2;
        int i3 = 0;
        if (this.khs == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.khs.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.khs[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.khs[i9] & 255);
            int i13 = i6 - (this.khs[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.kht[i15] || i14 >= i7) {
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

    protected void cMs() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] F = F(this.image);
        this.khp = new byte[F.length * 3];
        for (int i = 0; i < F.length; i++) {
            int i2 = F[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.khp[i3] = (byte) ((i2 >> 0) & 255);
            this.khp[i4] = (byte) ((i2 >> 8) & 255);
            this.khp[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] F(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cMt() throws IOException {
        int i;
        int i2;
        this.kho.write(33);
        this.kho.write(249);
        this.kho.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.khv >= 0) {
            i2 = this.khv & 7;
        }
        this.kho.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.kho.write(this.khm);
        this.kho.write(0);
    }

    protected void cMu() throws IOException {
        this.kho.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.khx) {
            this.kho.write(0);
        } else {
            this.kho.write(this.khu | 128);
        }
    }

    protected void cMv() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.kho.write(this.khu | 240);
        this.kho.write(0);
        this.kho.write(0);
    }

    protected void cMw() throws IOException {
        this.kho.write(33);
        this.kho.write(255);
        this.kho.write(11);
        writeString("NETSCAPE2.0");
        this.kho.write(3);
        this.kho.write(1);
        writeShort(this.khn);
        this.kho.write(0);
    }

    protected void cMx() throws IOException {
        this.kho.write(this.khs, 0, this.khs.length);
        int length = 768 - this.khs.length;
        for (int i = 0; i < length; i++) {
            this.kho.write(0);
        }
    }

    protected void cMy() throws IOException {
        new b(this.width, this.height, this.khq, this.khr).encode(this.kho);
    }

    protected void writeShort(int i) throws IOException {
        this.kho.write(i & 255);
        this.kho.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.kho.write((byte) str.charAt(i));
        }
    }
}
