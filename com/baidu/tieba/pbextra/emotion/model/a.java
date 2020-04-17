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
    protected int jPq;
    protected OutputStream jPs;
    protected byte[] jPt;
    protected byte[] jPu;
    protected int jPv;
    protected byte[] jPw;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int jPr = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] jPx = new boolean[256];
    protected int jPy = 7;
    protected int jPz = -1;
    protected boolean jPA = false;
    protected boolean jPB = true;
    protected boolean jPC = false;
    protected int jPD = 10;

    public void An(int i) {
        if (i >= 0) {
            this.jPr = i;
        }
    }

    public boolean C(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.jPC) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            cFv();
            cFu();
            if (this.jPB) {
                cFy();
                cFA();
                if (this.jPr >= 0) {
                    cFz();
                }
            }
            cFw();
            cFx();
            if (!this.jPB) {
                cFA();
            }
            cFB();
            this.jPB = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cFt() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.jPs.write(59);
                this.jPs.flush();
                if (this.jPA) {
                    this.jPs.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.jPq = 0;
            this.jPs = null;
            this.image = null;
            this.jPt = null;
            this.jPu = null;
            this.jPw = null;
            this.jPA = false;
            this.jPB = true;
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
        this.jPC = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.jPA = false;
        this.jPs = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void cFu() {
        int length = this.jPt.length;
        int i = length / 3;
        this.jPu = new byte[i];
        c cVar = new c(this.jPt, length, this.jPD);
        this.jPw = cVar.cFH();
        for (int i2 = 0; i2 < this.jPw.length; i2 += 3) {
            byte b = this.jPw[i2];
            this.jPw[i2] = this.jPw[i2 + 2];
            this.jPw[i2 + 2] = b;
            this.jPx[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int V = cVar.V(this.jPt[i3] & 255, this.jPt[i5] & 255, this.jPt[i6] & 255);
            this.jPx[V] = true;
            this.jPu[i4] = (byte) V;
        }
        this.jPt = null;
        this.jPv = 8;
        this.jPy = 7;
        if (this.transparent != -1) {
            this.jPq = Ao(this.transparent);
        }
    }

    protected int Ao(int i) {
        int i2;
        int i3 = 0;
        if (this.jPw == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.jPw.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.jPw[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.jPw[i9] & 255);
            int i13 = i6 - (this.jPw[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.jPx[i15] || i14 >= i7) {
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

    protected void cFv() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] D = D(this.image);
        this.jPt = new byte[D.length * 3];
        for (int i = 0; i < D.length; i++) {
            int i2 = D[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.jPt[i3] = (byte) ((i2 >> 0) & 255);
            this.jPt[i4] = (byte) ((i2 >> 8) & 255);
            this.jPt[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cFw() throws IOException {
        int i;
        int i2;
        this.jPs.write(33);
        this.jPs.write(249);
        this.jPs.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.jPz >= 0) {
            i2 = this.jPz & 7;
        }
        this.jPs.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.jPs.write(this.jPq);
        this.jPs.write(0);
    }

    protected void cFx() throws IOException {
        this.jPs.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.jPB) {
            this.jPs.write(0);
        } else {
            this.jPs.write(this.jPy | 128);
        }
    }

    protected void cFy() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.jPs.write(this.jPy | 240);
        this.jPs.write(0);
        this.jPs.write(0);
    }

    protected void cFz() throws IOException {
        this.jPs.write(33);
        this.jPs.write(255);
        this.jPs.write(11);
        writeString("NETSCAPE2.0");
        this.jPs.write(3);
        this.jPs.write(1);
        writeShort(this.jPr);
        this.jPs.write(0);
    }

    protected void cFA() throws IOException {
        this.jPs.write(this.jPw, 0, this.jPw.length);
        int length = 768 - this.jPw.length;
        for (int i = 0; i < length; i++) {
            this.jPs.write(0);
        }
    }

    protected void cFB() throws IOException {
        new b(this.width, this.height, this.jPu, this.jPv).encode(this.jPs);
    }

    protected void writeShort(int i) throws IOException {
        this.jPs.write(i & 255);
        this.jPs.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.jPs.write((byte) str.charAt(i));
        }
    }
}
