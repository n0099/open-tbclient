package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap NE;
    protected int grJ;
    protected byte[] grL;
    protected byte[] grM;
    protected int grN;
    protected byte[] grO;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int grK = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] grP = new boolean[256];
    protected int grQ = 7;
    protected int grR = -1;
    protected boolean grS = false;
    protected boolean grT = true;
    protected boolean grU = false;
    protected int grV = 10;

    public void tg(int i) {
        if (i >= 0) {
            this.grK = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.grU) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.NE = bitmap;
            bpk();
            bpj();
            if (this.grT) {
                bpn();
                bpp();
                if (this.grK >= 0) {
                    bpo();
                }
            }
            bpl();
            bpm();
            if (!this.grT) {
                bpp();
            }
            bpq();
            this.grT = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean finish() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.grS) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.grJ = 0;
            this.out = null;
            this.NE = null;
            this.grL = null;
            this.grM = null;
            this.grO = null;
            this.grS = false;
            this.grT = true;
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
        this.grU = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.grS = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bpj() {
        int length = this.grL.length;
        int i = length / 3;
        this.grM = new byte[i];
        c cVar = new c(this.grL, length, this.grV);
        this.grO = cVar.bpw();
        for (int i2 = 0; i2 < this.grO.length; i2 += 3) {
            byte b = this.grO[i2];
            this.grO[i2] = this.grO[i2 + 2];
            this.grO[i2 + 2] = b;
            this.grP[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.grL[i3] & 255, this.grL[i5] & 255, this.grL[i6] & 255);
            this.grP[U] = true;
            this.grM[i4] = (byte) U;
        }
        this.grL = null;
        this.grN = 8;
        this.grQ = 7;
        if (this.transparent != -1) {
            this.grJ = th(this.transparent);
        }
    }

    protected int th(int i) {
        int i2;
        int i3 = 0;
        if (this.grO == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.grO.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.grO[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.grO[i9] & 255);
            int i13 = i6 - (this.grO[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.grP[i15] || i14 >= i7) {
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

    protected void bpk() {
        int width = this.NE.getWidth();
        int height = this.NE.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.NE, 0.0f, 0.0f, new Paint());
            this.NE = createBitmap;
        }
        int[] u = u(this.NE);
        this.grL = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.grL[i3] = (byte) ((i2 >> 0) & 255);
            this.grL[i4] = (byte) ((i2 >> 8) & 255);
            this.grL[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] u(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bpl() throws IOException {
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
        if (this.grR >= 0) {
            i2 = this.grR & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.grJ);
        this.out.write(0);
    }

    protected void bpm() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.grT) {
            this.out.write(0);
        } else {
            this.out.write(this.grQ | 128);
        }
    }

    protected void bpn() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.grQ | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bpo() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.grK);
        this.out.write(0);
    }

    protected void bpp() throws IOException {
        this.out.write(this.grO, 0, this.grO.length);
        int length = 768 - this.grO.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bpq() throws IOException {
        new b(this.width, this.height, this.grM, this.grN).encode(this.out);
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
