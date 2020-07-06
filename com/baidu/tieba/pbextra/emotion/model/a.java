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
    protected int kCf;
    protected OutputStream kCh;
    protected byte[] kCi;
    protected byte[] kCj;
    protected int kCk;
    protected byte[] kCl;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int kCg = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] kCm = new boolean[256];
    protected int kCn = 7;
    protected int kCo = -1;
    protected boolean kCp = false;
    protected boolean kCq = true;
    protected boolean kCr = false;
    protected int kCs = 10;

    public void Cc(int i) {
        if (i >= 0) {
            this.kCg = i;
        }
    }

    public boolean E(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.kCr) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cRa();
            cQZ();
            if (this.kCq) {
                cRd();
                cRf();
                if (this.kCg >= 0) {
                    cRe();
                }
            }
            cRb();
            cRc();
            if (!this.kCq) {
                cRf();
            }
            cRg();
            this.kCq = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cQY() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.kCh.write(59);
                this.kCh.flush();
                if (this.kCp) {
                    this.kCh.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.kCf = 0;
            this.kCh = null;
            this.image = null;
            this.kCi = null;
            this.kCj = null;
            this.kCl = null;
            this.kCp = false;
            this.kCq = true;
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
        this.kCr = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.kCp = false;
        this.kCh = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void cQZ() {
        int length = this.kCi.length;
        int i = length / 3;
        this.kCj = new byte[i];
        c cVar = new c(this.kCi, length, this.kCs);
        this.kCl = cVar.cRm();
        for (int i2 = 0; i2 < this.kCl.length; i2 += 3) {
            byte b = this.kCl[i2];
            this.kCl[i2] = this.kCl[i2 + 2];
            this.kCl[i2 + 2] = b;
            this.kCm[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int V = cVar.V(this.kCi[i3] & 255, this.kCi[i5] & 255, this.kCi[i6] & 255);
            this.kCm[V] = true;
            this.kCj[i4] = (byte) V;
        }
        this.kCi = null;
        this.kCk = 8;
        this.kCn = 7;
        if (this.transparent != -1) {
            this.kCf = Cd(this.transparent);
        }
    }

    protected int Cd(int i) {
        int i2;
        int i3 = 0;
        if (this.kCl == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.kCl.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.kCl[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.kCl[i9] & 255);
            int i13 = i6 - (this.kCl[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.kCm[i15] || i14 >= i7) {
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

    protected void cRa() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] F = F(this.image);
        this.kCi = new byte[F.length * 3];
        for (int i = 0; i < F.length; i++) {
            int i2 = F[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.kCi[i3] = (byte) ((i2 >> 0) & 255);
            this.kCi[i4] = (byte) ((i2 >> 8) & 255);
            this.kCi[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] F(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cRb() throws IOException {
        int i;
        int i2;
        this.kCh.write(33);
        this.kCh.write(249);
        this.kCh.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.kCo >= 0) {
            i2 = this.kCo & 7;
        }
        this.kCh.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.kCh.write(this.kCf);
        this.kCh.write(0);
    }

    protected void cRc() throws IOException {
        this.kCh.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.kCq) {
            this.kCh.write(0);
        } else {
            this.kCh.write(this.kCn | 128);
        }
    }

    protected void cRd() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.kCh.write(this.kCn | 240);
        this.kCh.write(0);
        this.kCh.write(0);
    }

    protected void cRe() throws IOException {
        this.kCh.write(33);
        this.kCh.write(255);
        this.kCh.write(11);
        writeString("NETSCAPE2.0");
        this.kCh.write(3);
        this.kCh.write(1);
        writeShort(this.kCg);
        this.kCh.write(0);
    }

    protected void cRf() throws IOException {
        this.kCh.write(this.kCl, 0, this.kCl.length);
        int length = 768 - this.kCl.length;
        for (int i = 0; i < length; i++) {
            this.kCh.write(0);
        }
    }

    protected void cRg() throws IOException {
        new b(this.width, this.height, this.kCj, this.kCk).encode(this.kCh);
    }

    protected void writeShort(int i) throws IOException {
        this.kCh.write(i & 255);
        this.kCh.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.kCh.write((byte) str.charAt(i));
        }
    }
}
