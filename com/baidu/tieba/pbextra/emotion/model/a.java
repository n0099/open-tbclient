package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap atR;
    protected int gfI;
    protected byte[] gfK;
    protected byte[] gfL;
    protected int gfM;
    protected byte[] gfN;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int gfJ = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] gfO = new boolean[256];
    protected int gfP = 7;
    protected int gfQ = -1;
    protected boolean gfR = false;
    protected boolean gfS = true;
    protected boolean gfT = false;
    protected int gfU = 10;

    public void tv(int i) {
        if (i >= 0) {
            this.gfJ = i;
        }
    }

    public boolean q(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.gfT) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.atR = bitmap;
            bhV();
            bhU();
            if (this.gfS) {
                bhY();
                bia();
                if (this.gfJ >= 0) {
                    bhZ();
                }
            }
            bhW();
            bhX();
            if (!this.gfS) {
                bia();
            }
            bib();
            this.gfS = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean bhT() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.gfR) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.gfI = 0;
            this.out = null;
            this.atR = null;
            this.gfK = null;
            this.gfL = null;
            this.gfN = null;
            this.gfR = false;
            this.gfS = true;
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
        this.gfT = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.gfR = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bhU() {
        int length = this.gfK.length;
        int i = length / 3;
        this.gfL = new byte[i];
        c cVar = new c(this.gfK, length, this.gfU);
        this.gfN = cVar.bih();
        for (int i2 = 0; i2 < this.gfN.length; i2 += 3) {
            byte b = this.gfN[i2];
            this.gfN[i2] = this.gfN[i2 + 2];
            this.gfN[i2 + 2] = b;
            this.gfO[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int ac = cVar.ac(this.gfK[i3] & 255, this.gfK[i5] & 255, this.gfK[i6] & 255);
            this.gfO[ac] = true;
            this.gfL[i4] = (byte) ac;
        }
        this.gfK = null;
        this.gfM = 8;
        this.gfP = 7;
        if (this.transparent != -1) {
            this.gfI = tw(this.transparent);
        }
    }

    protected int tw(int i) {
        int i2;
        int i3 = 0;
        if (this.gfN == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.gfN.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.gfN[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.gfN[i9] & 255);
            int i13 = i6 - (this.gfN[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.gfO[i15] || i14 >= i7) {
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

    protected void bhV() {
        int width = this.atR.getWidth();
        int height = this.atR.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.atR, 0.0f, 0.0f, new Paint());
            this.atR = createBitmap;
        }
        int[] r = r(this.atR);
        this.gfK = new byte[r.length * 3];
        for (int i = 0; i < r.length; i++) {
            int i2 = r[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.gfK[i3] = (byte) ((i2 >> 0) & 255);
            this.gfK[i4] = (byte) ((i2 >> 8) & 255);
            this.gfK[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] r(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bhW() throws IOException {
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
        if (this.gfQ >= 0) {
            i2 = this.gfQ & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.gfI);
        this.out.write(0);
    }

    protected void bhX() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.gfS) {
            this.out.write(0);
        } else {
            this.out.write(this.gfP | 128);
        }
    }

    protected void bhY() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.gfP | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bhZ() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.gfJ);
        this.out.write(0);
    }

    protected void bia() throws IOException {
        this.out.write(this.gfN, 0, this.gfN.length);
        int length = 768 - this.gfN.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bib() throws IOException {
        new b(this.width, this.height, this.gfL, this.gfM).encode(this.out);
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
