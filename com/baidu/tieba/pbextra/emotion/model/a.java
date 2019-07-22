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
    protected int iga;
    protected OutputStream igd;
    protected byte[] ige;
    protected byte[] igf;
    protected int igg;
    protected byte[] igh;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int igb = -1;
    protected int delay = 0;
    protected boolean igc = false;
    protected boolean[] igi = new boolean[256];
    protected int igj = 7;
    protected int igk = -1;
    protected boolean igl = false;
    protected boolean igm = true;
    protected boolean ign = false;
    protected int igo = 10;

    public void yw(int i) {
        if (i >= 0) {
            this.igb = i;
        }
    }

    public boolean C(Bitmap bitmap) {
        if (bitmap == null || !this.igc) {
            return false;
        }
        try {
            if (!this.ign) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.LN = bitmap;
            car();
            caq();
            if (this.igm) {
                cau();
                caw();
                if (this.igb >= 0) {
                    cav();
                }
            }
            cas();
            cat();
            if (!this.igm) {
                caw();
            }
            cax();
            this.igm = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean uE() {
        boolean z;
        if (this.igc) {
            this.igc = false;
            try {
                this.igd.write(59);
                this.igd.flush();
                if (this.igl) {
                    this.igd.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.iga = 0;
            this.igd = null;
            this.LN = null;
            this.ige = null;
            this.igf = null;
            this.igh = null;
            this.igl = false;
            this.igm = true;
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
        this.ign = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.igl = false;
        this.igd = outputStream;
        try {
            Cx("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.igc = z;
        return z;
    }

    protected void caq() {
        int length = this.ige.length;
        int i = length / 3;
        this.igf = new byte[i];
        c cVar = new c(this.ige, length, this.igo);
        this.igh = cVar.caD();
        for (int i2 = 0; i2 < this.igh.length; i2 += 3) {
            byte b = this.igh[i2];
            this.igh[i2] = this.igh[i2 + 2];
            this.igh[i2 + 2] = b;
            this.igi[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Z = cVar.Z(this.ige[i3] & 255, this.ige[i5] & 255, this.ige[i6] & 255);
            this.igi[Z] = true;
            this.igf[i4] = (byte) Z;
        }
        this.ige = null;
        this.igg = 8;
        this.igj = 7;
        if (this.transparent != -1) {
            this.iga = yx(this.transparent);
        }
    }

    protected int yx(int i) {
        int i2;
        int i3 = 0;
        if (this.igh == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.igh.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.igh[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.igh[i9] & 255);
            int i13 = i6 - (this.igh[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.igi[i15] || i14 >= i7) {
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

    protected void car() {
        int width = this.LN.getWidth();
        int height = this.LN.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.LN, 0.0f, 0.0f, new Paint());
            this.LN = createBitmap;
        }
        int[] D = D(this.LN);
        this.ige = new byte[D.length * 3];
        for (int i = 0; i < D.length; i++) {
            int i2 = D[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.ige[i3] = (byte) ((i2 >> 0) & 255);
            this.ige[i4] = (byte) ((i2 >> 8) & 255);
            this.ige[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cas() throws IOException {
        int i;
        int i2;
        this.igd.write(33);
        this.igd.write(249);
        this.igd.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.igk >= 0) {
            i2 = this.igk & 7;
        }
        this.igd.write((i2 << 2) | 0 | 0 | i);
        yy(this.delay);
        this.igd.write(this.iga);
        this.igd.write(0);
    }

    protected void cat() throws IOException {
        this.igd.write(44);
        yy(this.x);
        yy(this.y);
        yy(this.width);
        yy(this.height);
        if (this.igm) {
            this.igd.write(0);
        } else {
            this.igd.write(this.igj | 128);
        }
    }

    protected void cau() throws IOException {
        yy(this.width);
        yy(this.height);
        this.igd.write(this.igj | 240);
        this.igd.write(0);
        this.igd.write(0);
    }

    protected void cav() throws IOException {
        this.igd.write(33);
        this.igd.write(255);
        this.igd.write(11);
        Cx("NETSCAPE2.0");
        this.igd.write(3);
        this.igd.write(1);
        yy(this.igb);
        this.igd.write(0);
    }

    protected void caw() throws IOException {
        this.igd.write(this.igh, 0, this.igh.length);
        int length = 768 - this.igh.length;
        for (int i = 0; i < length; i++) {
            this.igd.write(0);
        }
    }

    protected void cax() throws IOException {
        new b(this.width, this.height, this.igf, this.igg).g(this.igd);
    }

    protected void yy(int i) throws IOException {
        this.igd.write(i & 255);
        this.igd.write((i >> 8) & 255);
    }

    protected void Cx(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.igd.write((byte) str.charAt(i));
        }
    }
}
