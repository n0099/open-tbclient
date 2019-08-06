package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class a {
    protected Bitmap LN;
    protected int height;
    protected int ihc;
    protected OutputStream ihf;
    protected byte[] ihg;
    protected byte[] ihh;
    protected int ihi;
    protected byte[] ihj;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int ihd = -1;
    protected int delay = 0;
    protected boolean ihe = false;
    protected boolean[] ihk = new boolean[256];
    protected int ihl = 7;
    protected int ihm = -1;
    protected boolean ihn = false;
    protected boolean iho = true;
    protected boolean ihp = false;
    protected int ihq = 10;

    public void yy(int i) {
        if (i >= 0) {
            this.ihd = i;
        }
    }

    public boolean C(Bitmap bitmap) {
        if (bitmap == null || !this.ihe) {
            return false;
        }
        try {
            if (!this.ihp) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.LN = bitmap;
            caJ();
            caI();
            if (this.iho) {
                caM();
                caO();
                if (this.ihd >= 0) {
                    caN();
                }
            }
            caK();
            caL();
            if (!this.iho) {
                caO();
            }
            caP();
            this.iho = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean uE() {
        boolean z;
        if (this.ihe) {
            this.ihe = false;
            try {
                this.ihf.write(59);
                this.ihf.flush();
                if (this.ihn) {
                    this.ihf.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.ihc = 0;
            this.ihf = null;
            this.LN = null;
            this.ihg = null;
            this.ihh = null;
            this.ihj = null;
            this.ihn = false;
            this.iho = true;
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
        this.ihp = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.ihn = false;
        this.ihf = outputStream;
        try {
            Cy("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.ihe = z;
        return z;
    }

    protected void caI() {
        int length = this.ihg.length;
        int i = length / 3;
        this.ihh = new byte[i];
        c cVar = new c(this.ihg, length, this.ihq);
        this.ihj = cVar.caV();
        for (int i2 = 0; i2 < this.ihj.length; i2 += 3) {
            byte b = this.ihj[i2];
            this.ihj[i2] = this.ihj[i2 + 2];
            this.ihj[i2 + 2] = b;
            this.ihk[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Z = cVar.Z(this.ihg[i3] & 255, this.ihg[i5] & 255, this.ihg[i6] & 255);
            this.ihk[Z] = true;
            this.ihh[i4] = (byte) Z;
        }
        this.ihg = null;
        this.ihi = 8;
        this.ihl = 7;
        if (this.transparent != -1) {
            this.ihc = yz(this.transparent);
        }
    }

    protected int yz(int i) {
        int i2;
        int i3 = 0;
        if (this.ihj == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.ihj.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.ihj[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.ihj[i9] & 255);
            int i13 = i6 - (this.ihj[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.ihk[i15] || i14 >= i7) {
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

    protected void caJ() {
        int width = this.LN.getWidth();
        int height = this.LN.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.LN, 0.0f, 0.0f, new Paint());
            this.LN = createBitmap;
        }
        int[] D = D(this.LN);
        this.ihg = new byte[D.length * 3];
        for (int i = 0; i < D.length; i++) {
            int i2 = D[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.ihg[i3] = (byte) ((i2 >> 0) & 255);
            this.ihg[i4] = (byte) ((i2 >> 8) & 255);
            this.ihg[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void caK() throws IOException {
        int i;
        int i2;
        this.ihf.write(33);
        this.ihf.write(249);
        this.ihf.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.ihm >= 0) {
            i2 = this.ihm & 7;
        }
        this.ihf.write((i2 << 2) | 0 | 0 | i);
        yA(this.delay);
        this.ihf.write(this.ihc);
        this.ihf.write(0);
    }

    protected void caL() throws IOException {
        this.ihf.write(44);
        yA(this.x);
        yA(this.y);
        yA(this.width);
        yA(this.height);
        if (this.iho) {
            this.ihf.write(0);
        } else {
            this.ihf.write(this.ihl | 128);
        }
    }

    protected void caM() throws IOException {
        yA(this.width);
        yA(this.height);
        this.ihf.write(this.ihl | 240);
        this.ihf.write(0);
        this.ihf.write(0);
    }

    protected void caN() throws IOException {
        this.ihf.write(33);
        this.ihf.write(255);
        this.ihf.write(11);
        Cy("NETSCAPE2.0");
        this.ihf.write(3);
        this.ihf.write(1);
        yA(this.ihd);
        this.ihf.write(0);
    }

    protected void caO() throws IOException {
        this.ihf.write(this.ihj, 0, this.ihj.length);
        int length = 768 - this.ihj.length;
        for (int i = 0; i < length; i++) {
            this.ihf.write(0);
        }
    }

    protected void caP() throws IOException {
        new b(this.width, this.height, this.ihh, this.ihi).g(this.ihf);
    }

    protected void yA(int i) throws IOException {
        this.ihf.write(i & 255);
        this.ihf.write((i >> 8) & 255);
    }

    protected void Cy(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.ihf.write((byte) str.charAt(i));
        }
    }
}
