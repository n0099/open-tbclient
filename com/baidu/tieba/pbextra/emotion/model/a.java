package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Eu;
    protected int fAe;
    protected byte[] fAg;
    protected byte[] fAh;
    protected int fAi;
    protected byte[] fAj;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int fAf = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] fAk = new boolean[256];
    protected int fAl = 7;
    protected int fAm = -1;
    protected boolean fAn = false;
    protected boolean fAo = true;
    protected boolean fAp = false;
    protected int fAq = 10;

    public void qR(int i) {
        if (i >= 0) {
            this.fAf = i;
        }
    }

    public boolean u(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.fAp) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Eu = bitmap;
            bcV();
            bcU();
            if (this.fAo) {
                bcY();
                bda();
                if (this.fAf >= 0) {
                    bcZ();
                }
            }
            bcW();
            bcX();
            if (!this.fAo) {
                bda();
            }
            bdb();
            this.fAo = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean bcT() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.fAn) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.fAe = 0;
            this.out = null;
            this.Eu = null;
            this.fAg = null;
            this.fAh = null;
            this.fAj = null;
            this.fAn = false;
            this.fAo = true;
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
        this.fAp = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.fAn = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bcU() {
        int length = this.fAg.length;
        int i = length / 3;
        this.fAh = new byte[i];
        c cVar = new c(this.fAg, length, this.fAq);
        this.fAj = cVar.bdh();
        for (int i2 = 0; i2 < this.fAj.length; i2 += 3) {
            byte b = this.fAj[i2];
            this.fAj[i2] = this.fAj[i2 + 2];
            this.fAj[i2 + 2] = b;
            this.fAk[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Q = cVar.Q(this.fAg[i3] & 255, this.fAg[i5] & 255, this.fAg[i6] & 255);
            this.fAk[Q] = true;
            this.fAh[i4] = (byte) Q;
        }
        this.fAg = null;
        this.fAi = 8;
        this.fAl = 7;
        if (this.transparent != -1) {
            this.fAe = qS(this.transparent);
        }
    }

    protected int qS(int i) {
        int i2;
        int i3 = 0;
        if (this.fAj == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.fAj.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.fAj[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.fAj[i9] & 255);
            int i13 = i6 - (this.fAj[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.fAk[i15] || i14 >= i7) {
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

    protected void bcV() {
        int width = this.Eu.getWidth();
        int height = this.Eu.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Eu, 0.0f, 0.0f, new Paint());
            this.Eu = createBitmap;
        }
        int[] v = v(this.Eu);
        this.fAg = new byte[v.length * 3];
        for (int i = 0; i < v.length; i++) {
            int i2 = v[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.fAg[i3] = (byte) ((i2 >> 0) & 255);
            this.fAg[i4] = (byte) ((i2 >> 8) & 255);
            this.fAg[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] v(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bcW() throws IOException {
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
        if (this.fAm >= 0) {
            i2 = this.fAm & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.fAe);
        this.out.write(0);
    }

    protected void bcX() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.fAo) {
            this.out.write(0);
        } else {
            this.out.write(this.fAl | 128);
        }
    }

    protected void bcY() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.fAl | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bcZ() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.fAf);
        this.out.write(0);
    }

    protected void bda() throws IOException {
        this.out.write(this.fAj, 0, this.fAj.length);
        int length = 768 - this.fAj.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bdb() throws IOException {
        new b(this.width, this.height, this.fAh, this.fAi).encode(this.out);
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
