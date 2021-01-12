package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected byte[] mgL;
    protected byte[] mgM;
    protected int mgN;
    protected byte[] mgO;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mgK = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] mgP = new boolean[256];
    protected int mgQ = 7;
    protected int dispose = -1;
    protected boolean mgR = false;
    protected boolean mgS = true;
    protected boolean mgT = false;
    protected int mgU = 10;

    public void Gl(int i) {
        if (i >= 0) {
            this.mgK = i;
        }
    }

    public boolean H(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mgT) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dtB();
            dtA();
            if (this.mgS) {
                dtE();
                dtG();
                if (this.mgK >= 0) {
                    dtF();
                }
            }
            dtC();
            dtD();
            if (!this.mgS) {
                dtG();
            }
            dtH();
            this.mgS = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dtz() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.mgR) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.mgL = null;
            this.mgM = null;
            this.mgO = null;
            this.mgR = false;
            this.mgS = true;
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
        this.mgT = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.mgR = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dtA() {
        int length = this.mgL.length;
        int i = length / 3;
        this.mgM = new byte[i];
        c cVar = new c(this.mgL, length, this.mgU);
        this.mgO = cVar.dtN();
        for (int i2 = 0; i2 < this.mgO.length; i2 += 3) {
            byte b2 = this.mgO[i2];
            this.mgO[i2] = this.mgO[i2 + 2];
            this.mgO[i2 + 2] = b2;
            this.mgP[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Z = cVar.Z(this.mgL[i3] & 255, this.mgL[i5] & 255, this.mgL[i6] & 255);
            this.mgP[Z] = true;
            this.mgM[i4] = (byte) Z;
        }
        this.mgL = null;
        this.mgN = 8;
        this.mgQ = 7;
        if (this.transparent != -1) {
            this.transIndex = Gm(this.transparent);
        }
    }

    protected int Gm(int i) {
        if (this.mgO == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 0) & 255;
        int i5 = 16777216;
        int length = this.mgO.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int i9 = i2 - (this.mgO[i6] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (this.mgO[i8] & 255);
            int i12 = i4 - (this.mgO[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (!this.mgP[i14] || i13 >= i5) {
                i13 = i5;
                i14 = i7;
            }
            i6 = i10 + 1;
            i5 = i13;
            i7 = i14;
        }
        return i7;
    }

    protected void dtB() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] I = I(this.image);
        this.mgL = new byte[I.length * 3];
        for (int i = 0; i < I.length; i++) {
            int i2 = I[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.mgL[i3] = (byte) ((i2 >> 0) & 255);
            this.mgL[i4] = (byte) ((i2 >> 8) & 255);
            this.mgL[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] I(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dtC() throws IOException {
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

    protected void dtD() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.mgS) {
            this.out.write(0);
        } else {
            this.out.write(this.mgQ | 128);
        }
    }

    protected void dtE() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.mgQ | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void dtF() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.mgK);
        this.out.write(0);
    }

    protected void dtG() throws IOException {
        this.out.write(this.mgO, 0, this.mgO.length);
        int length = 768 - this.mgO.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void dtH() throws IOException {
        new b(this.width, this.height, this.mgM, this.mgN).encode(this.out);
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
