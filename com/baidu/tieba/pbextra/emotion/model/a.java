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
    protected byte[] jfm;
    protected byte[] jfn;
    protected int jfo;
    protected byte[] jfp;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int repeat = -1;
    protected int delay = 0;
    protected boolean jfl = false;
    protected boolean[] jfq = new boolean[256];
    protected int jfr = 7;
    protected int dispose = -1;
    protected boolean jfs = false;
    protected boolean jft = true;
    protected boolean jfu = false;
    protected int jfv = 10;

    public void zM(int i) {
        if (i >= 0) {
            this.repeat = i;
        }
    }

    public boolean A(Bitmap bitmap) {
        if (bitmap == null || !this.jfl) {
            return false;
        }
        try {
            if (!this.jfu) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cuO();
            cuN();
            if (this.jft) {
                cuR();
                cuT();
                if (this.repeat >= 0) {
                    cuS();
                }
            }
            cuP();
            cuQ();
            if (!this.jft) {
                cuT();
            }
            cuU();
            this.jft = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cuM() {
        boolean z;
        if (this.jfl) {
            this.jfl = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.jfs) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.jfm = null;
            this.jfn = null;
            this.jfp = null;
            this.jfs = false;
            this.jft = true;
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
        this.jfu = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.jfs = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.jfl = z;
        return z;
    }

    protected void cuN() {
        int length = this.jfm.length;
        int i = length / 3;
        this.jfn = new byte[i];
        c cVar = new c(this.jfm, length, this.jfv);
        this.jfp = cVar.cva();
        for (int i2 = 0; i2 < this.jfp.length; i2 += 3) {
            byte b = this.jfp[i2];
            this.jfp[i2] = this.jfp[i2 + 2];
            this.jfp[i2 + 2] = b;
            this.jfq[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int S = cVar.S(this.jfm[i3] & 255, this.jfm[i5] & 255, this.jfm[i6] & 255);
            this.jfq[S] = true;
            this.jfn[i4] = (byte) S;
        }
        this.jfm = null;
        this.jfo = 8;
        this.jfr = 7;
        if (this.transparent != -1) {
            this.transIndex = zN(this.transparent);
        }
    }

    protected int zN(int i) {
        int i2;
        int i3 = 0;
        if (this.jfp == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.jfp.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.jfp[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.jfp[i9] & 255);
            int i13 = i6 - (this.jfp[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.jfq[i15] || i14 >= i7) {
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

    protected void cuO() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] B = B(this.image);
        this.jfm = new byte[B.length * 3];
        for (int i = 0; i < B.length; i++) {
            int i2 = B[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.jfm[i3] = (byte) ((i2 >> 0) & 255);
            this.jfm[i4] = (byte) ((i2 >> 8) & 255);
            this.jfm[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] B(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cuP() throws IOException {
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

    protected void cuQ() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.jft) {
            this.out.write(0);
        } else {
            this.out.write(this.jfr | 128);
        }
    }

    protected void cuR() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.jfr | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void cuS() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    protected void cuT() throws IOException {
        this.out.write(this.jfp, 0, this.jfp.length);
        int length = 768 - this.jfp.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void cuU() throws IOException {
        new b(this.width, this.height, this.jfn, this.jfo).encode(this.out);
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
