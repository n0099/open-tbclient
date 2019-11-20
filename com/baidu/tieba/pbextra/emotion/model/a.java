package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class a {
    protected int height;
    protected int igU;
    protected OutputStream igX;
    protected byte[] igY;
    protected byte[] igZ;
    protected int iha;
    protected byte[] ihb;
    protected Bitmap image;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int igV = -1;
    protected int delay = 0;
    protected boolean igW = false;
    protected boolean[] ihc = new boolean[256];
    protected int ihd = 7;
    protected int ihe = -1;
    protected boolean ihf = false;
    protected boolean ihg = true;
    protected boolean ihh = false;
    protected int ihi = 10;

    public void xg(int i) {
        if (i >= 0) {
            this.igV = i;
        }
    }

    public boolean A(Bitmap bitmap) {
        if (bitmap == null || !this.igW) {
            return false;
        }
        try {
            if (!this.ihh) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            bYx();
            bYw();
            if (this.ihg) {
                bYA();
                bYC();
                if (this.igV >= 0) {
                    bYB();
                }
            }
            bYy();
            bYz();
            if (!this.ihg) {
                bYC();
            }
            bYD();
            this.ihg = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean zD() {
        boolean z;
        if (this.igW) {
            this.igW = false;
            try {
                this.igX.write(59);
                this.igX.flush();
                if (this.ihf) {
                    this.igX.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.igU = 0;
            this.igX = null;
            this.image = null;
            this.igY = null;
            this.igZ = null;
            this.ihb = null;
            this.ihf = false;
            this.ihg = true;
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
        this.ihh = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.ihf = false;
        this.igX = outputStream;
        try {
            Bq("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.igW = z;
        return z;
    }

    protected void bYw() {
        int length = this.igY.length;
        int i = length / 3;
        this.igZ = new byte[i];
        c cVar = new c(this.igY, length, this.ihi);
        this.ihb = cVar.bYJ();
        for (int i2 = 0; i2 < this.ihb.length; i2 += 3) {
            byte b = this.ihb[i2];
            this.ihb[i2] = this.ihb[i2 + 2];
            this.ihb[i2 + 2] = b;
            this.ihc[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int R = cVar.R(this.igY[i3] & 255, this.igY[i5] & 255, this.igY[i6] & 255);
            this.ihc[R] = true;
            this.igZ[i4] = (byte) R;
        }
        this.igY = null;
        this.iha = 8;
        this.ihd = 7;
        if (this.transparent != -1) {
            this.igU = xh(this.transparent);
        }
    }

    protected int xh(int i) {
        int i2;
        int i3 = 0;
        if (this.ihb == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.ihb.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.ihb[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.ihb[i9] & 255);
            int i13 = i6 - (this.ihb[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.ihc[i15] || i14 >= i7) {
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

    protected void bYx() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] B = B(this.image);
        this.igY = new byte[B.length * 3];
        for (int i = 0; i < B.length; i++) {
            int i2 = B[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.igY[i3] = (byte) ((i2 >> 0) & 255);
            this.igY[i4] = (byte) ((i2 >> 8) & 255);
            this.igY[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] B(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bYy() throws IOException {
        int i;
        int i2;
        this.igX.write(33);
        this.igX.write(249);
        this.igX.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.ihe >= 0) {
            i2 = this.ihe & 7;
        }
        this.igX.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.igX.write(this.igU);
        this.igX.write(0);
    }

    protected void bYz() throws IOException {
        this.igX.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.ihg) {
            this.igX.write(0);
        } else {
            this.igX.write(this.ihd | 128);
        }
    }

    protected void bYA() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.igX.write(this.ihd | 240);
        this.igX.write(0);
        this.igX.write(0);
    }

    protected void bYB() throws IOException {
        this.igX.write(33);
        this.igX.write(255);
        this.igX.write(11);
        Bq("NETSCAPE2.0");
        this.igX.write(3);
        this.igX.write(1);
        writeShort(this.igV);
        this.igX.write(0);
    }

    protected void bYC() throws IOException {
        this.igX.write(this.ihb, 0, this.ihb.length);
        int length = 768 - this.ihb.length;
        for (int i = 0; i < length; i++) {
            this.igX.write(0);
        }
    }

    protected void bYD() throws IOException {
        new b(this.width, this.height, this.igZ, this.iha).d(this.igX);
    }

    protected void writeShort(int i) throws IOException {
        this.igX.write(i & 255);
        this.igX.write((i >> 8) & 255);
    }

    protected void Bq(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.igX.write((byte) str.charAt(i));
        }
    }
}
