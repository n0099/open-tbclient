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
    protected int ijb;
    protected OutputStream ije;
    protected byte[] ijf;
    protected byte[] ijg;
    protected int ijh;
    protected byte[] iji;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int ijc = -1;
    protected int delay = 0;
    protected boolean ijd = false;
    protected boolean[] ijj = new boolean[256];
    protected int ijk = 7;
    protected int ijl = -1;
    protected boolean ijm = false;
    protected boolean ijn = true;
    protected boolean ijo = false;
    protected int ijp = 10;

    public void yB(int i) {
        if (i >= 0) {
            this.ijc = i;
        }
    }

    public boolean C(Bitmap bitmap) {
        if (bitmap == null || !this.ijd) {
            return false;
        }
        try {
            if (!this.ijo) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.LN = bitmap;
            cbx();
            cbw();
            if (this.ijn) {
                cbA();
                cbC();
                if (this.ijc >= 0) {
                    cbB();
                }
            }
            cby();
            cbz();
            if (!this.ijn) {
                cbC();
            }
            cbD();
            this.ijn = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean uI() {
        boolean z;
        if (this.ijd) {
            this.ijd = false;
            try {
                this.ije.write(59);
                this.ije.flush();
                if (this.ijm) {
                    this.ije.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.ijb = 0;
            this.ije = null;
            this.LN = null;
            this.ijf = null;
            this.ijg = null;
            this.iji = null;
            this.ijm = false;
            this.ijn = true;
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
        this.ijo = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.ijm = false;
        this.ije = outputStream;
        try {
            CX("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.ijd = z;
        return z;
    }

    protected void cbw() {
        int length = this.ijf.length;
        int i = length / 3;
        this.ijg = new byte[i];
        c cVar = new c(this.ijf, length, this.ijp);
        this.iji = cVar.cbJ();
        for (int i2 = 0; i2 < this.iji.length; i2 += 3) {
            byte b = this.iji[i2];
            this.iji[i2] = this.iji[i2 + 2];
            this.iji[i2 + 2] = b;
            this.ijj[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int aa = cVar.aa(this.ijf[i3] & 255, this.ijf[i5] & 255, this.ijf[i6] & 255);
            this.ijj[aa] = true;
            this.ijg[i4] = (byte) aa;
        }
        this.ijf = null;
        this.ijh = 8;
        this.ijk = 7;
        if (this.transparent != -1) {
            this.ijb = yC(this.transparent);
        }
    }

    protected int yC(int i) {
        int i2;
        int i3 = 0;
        if (this.iji == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.iji.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.iji[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.iji[i9] & 255);
            int i13 = i6 - (this.iji[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.ijj[i15] || i14 >= i7) {
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

    protected void cbx() {
        int width = this.LN.getWidth();
        int height = this.LN.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.LN, 0.0f, 0.0f, new Paint());
            this.LN = createBitmap;
        }
        int[] D = D(this.LN);
        this.ijf = new byte[D.length * 3];
        for (int i = 0; i < D.length; i++) {
            int i2 = D[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.ijf[i3] = (byte) ((i2 >> 0) & 255);
            this.ijf[i4] = (byte) ((i2 >> 8) & 255);
            this.ijf[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cby() throws IOException {
        int i;
        int i2;
        this.ije.write(33);
        this.ije.write(249);
        this.ije.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.ijl >= 0) {
            i2 = this.ijl & 7;
        }
        this.ije.write((i2 << 2) | 0 | 0 | i);
        yD(this.delay);
        this.ije.write(this.ijb);
        this.ije.write(0);
    }

    protected void cbz() throws IOException {
        this.ije.write(44);
        yD(this.x);
        yD(this.y);
        yD(this.width);
        yD(this.height);
        if (this.ijn) {
            this.ije.write(0);
        } else {
            this.ije.write(this.ijk | 128);
        }
    }

    protected void cbA() throws IOException {
        yD(this.width);
        yD(this.height);
        this.ije.write(this.ijk | 240);
        this.ije.write(0);
        this.ije.write(0);
    }

    protected void cbB() throws IOException {
        this.ije.write(33);
        this.ije.write(255);
        this.ije.write(11);
        CX("NETSCAPE2.0");
        this.ije.write(3);
        this.ije.write(1);
        yD(this.ijc);
        this.ije.write(0);
    }

    protected void cbC() throws IOException {
        this.ije.write(this.iji, 0, this.iji.length);
        int length = 768 - this.iji.length;
        for (int i = 0; i < length; i++) {
            this.ije.write(0);
        }
    }

    protected void cbD() throws IOException {
        new b(this.width, this.height, this.ijg, this.ijh).g(this.ije);
    }

    protected void yD(int i) throws IOException {
        this.ije.write(i & 255);
        this.ije.write((i >> 8) & 255);
    }

    protected void CX(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.ije.write((byte) str.charAt(i));
        }
    }
}
