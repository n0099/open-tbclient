package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected byte[] jcD;
    protected byte[] jcE;
    protected int jcF;
    protected byte[] jcG;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int repeat = -1;
    protected int delay = 0;
    protected boolean jcC = false;
    protected boolean[] jcH = new boolean[256];
    protected int jcI = 7;
    protected int dispose = -1;
    protected boolean jcJ = false;
    protected boolean jcK = true;
    protected boolean jcL = false;
    protected int jcM = 10;

    public void zx(int i) {
        if (i >= 0) {
            this.repeat = i;
        }
    }

    public boolean A(Bitmap bitmap) {
        if (bitmap == null || !this.jcC) {
            return false;
        }
        try {
            if (!this.jcL) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            csZ();
            csY();
            if (this.jcK) {
                ctc();
                cte();
                if (this.repeat >= 0) {
                    ctd();
                }
            }
            cta();
            ctb();
            if (!this.jcK) {
                cte();
            }
            ctf();
            this.jcK = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean csX() {
        boolean z;
        if (this.jcC) {
            this.jcC = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.jcJ) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.jcD = null;
            this.jcE = null;
            this.jcG = null;
            this.jcJ = false;
            this.jcK = true;
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
        this.jcL = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.jcJ = false;
        this.out = outputStream;
        try {
            Gl("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.jcC = z;
        return z;
    }

    protected void csY() {
        int length = this.jcD.length;
        int i = length / 3;
        this.jcE = new byte[i];
        c cVar = new c(this.jcD, length, this.jcM);
        this.jcG = cVar.ctl();
        for (int i2 = 0; i2 < this.jcG.length; i2 += 3) {
            byte b = this.jcG[i2];
            this.jcG[i2] = this.jcG[i2 + 2];
            this.jcG[i2 + 2] = b;
            this.jcH[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int R = cVar.R(this.jcD[i3] & 255, this.jcD[i5] & 255, this.jcD[i6] & 255);
            this.jcH[R] = true;
            this.jcE[i4] = (byte) R;
        }
        this.jcD = null;
        this.jcF = 8;
        this.jcI = 7;
        if (this.transparent != -1) {
            this.transIndex = zy(this.transparent);
        }
    }

    protected int zy(int i) {
        int i2;
        int i3 = 0;
        if (this.jcG == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.jcG.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.jcG[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.jcG[i9] & 255);
            int i13 = i6 - (this.jcG[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.jcH[i15] || i14 >= i7) {
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

    protected void csZ() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] B = B(this.image);
        this.jcD = new byte[B.length * 3];
        for (int i = 0; i < B.length; i++) {
            int i2 = B[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.jcD[i3] = (byte) ((i2 >> 0) & 255);
            this.jcD[i4] = (byte) ((i2 >> 8) & 255);
            this.jcD[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] B(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void cta() throws IOException {
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

    protected void ctb() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.jcK) {
            this.out.write(0);
        } else {
            this.out.write(this.jcI | 128);
        }
    }

    protected void ctc() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.jcI | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void ctd() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        Gl("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    protected void cte() throws IOException {
        this.out.write(this.jcG, 0, this.jcG.length);
        int length = 768 - this.jcG.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void ctf() throws IOException {
        new b(this.width, this.height, this.jcE, this.jcF).encode(this.out);
    }

    protected void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    protected void Gl(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.out.write((byte) str.charAt(i));
        }
    }
}
