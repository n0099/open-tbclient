package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap atZ;
    protected int gfD;
    protected byte[] gfF;
    protected byte[] gfG;
    protected int gfH;
    protected byte[] gfI;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int gfE = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] gfJ = new boolean[256];
    protected int gfK = 7;
    protected int gfL = -1;
    protected boolean gfM = false;
    protected boolean gfN = true;
    protected boolean gfO = false;
    protected int gfP = 10;

    public void tu(int i) {
        if (i >= 0) {
            this.gfE = i;
        }
    }

    public boolean q(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.gfO) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.atZ = bitmap;
            bhV();
            bhU();
            if (this.gfN) {
                bhY();
                bia();
                if (this.gfE >= 0) {
                    bhZ();
                }
            }
            bhW();
            bhX();
            if (!this.gfN) {
                bia();
            }
            bib();
            this.gfN = false;
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
                if (this.gfM) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.gfD = 0;
            this.out = null;
            this.atZ = null;
            this.gfF = null;
            this.gfG = null;
            this.gfI = null;
            this.gfM = false;
            this.gfN = true;
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
        this.gfO = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.gfM = false;
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
        int length = this.gfF.length;
        int i = length / 3;
        this.gfG = new byte[i];
        c cVar = new c(this.gfF, length, this.gfP);
        this.gfI = cVar.bih();
        for (int i2 = 0; i2 < this.gfI.length; i2 += 3) {
            byte b = this.gfI[i2];
            this.gfI[i2] = this.gfI[i2 + 2];
            this.gfI[i2 + 2] = b;
            this.gfJ[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int ac = cVar.ac(this.gfF[i3] & 255, this.gfF[i5] & 255, this.gfF[i6] & 255);
            this.gfJ[ac] = true;
            this.gfG[i4] = (byte) ac;
        }
        this.gfF = null;
        this.gfH = 8;
        this.gfK = 7;
        if (this.transparent != -1) {
            this.gfD = tv(this.transparent);
        }
    }

    protected int tv(int i) {
        int i2;
        int i3 = 0;
        if (this.gfI == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.gfI.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.gfI[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.gfI[i9] & 255);
            int i13 = i6 - (this.gfI[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.gfJ[i15] || i14 >= i7) {
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
        int width = this.atZ.getWidth();
        int height = this.atZ.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.atZ, 0.0f, 0.0f, new Paint());
            this.atZ = createBitmap;
        }
        int[] r = r(this.atZ);
        this.gfF = new byte[r.length * 3];
        for (int i = 0; i < r.length; i++) {
            int i2 = r[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.gfF[i3] = (byte) ((i2 >> 0) & 255);
            this.gfF[i4] = (byte) ((i2 >> 8) & 255);
            this.gfF[i4 + 1] = (byte) ((i2 >> 16) & 255);
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
        if (this.gfL >= 0) {
            i2 = this.gfL & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.gfD);
        this.out.write(0);
    }

    protected void bhX() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.gfN) {
            this.out.write(0);
        } else {
            this.out.write(this.gfK | 128);
        }
    }

    protected void bhY() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.gfK | 240);
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
        writeShort(this.gfE);
        this.out.write(0);
    }

    protected void bia() throws IOException {
        this.out.write(this.gfI, 0, this.gfI.length);
        int length = 768 - this.gfI.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bib() throws IOException {
        new b(this.width, this.height, this.gfG, this.gfH).encode(this.out);
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
