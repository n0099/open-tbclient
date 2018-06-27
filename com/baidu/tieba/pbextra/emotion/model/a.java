package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap KC;
    protected int fQF;
    protected byte[] fQH;
    protected byte[] fQI;
    protected int fQJ;
    protected byte[] fQK;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int fQG = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] fQL = new boolean[256];
    protected int fQM = 7;
    protected int fQN = -1;
    protected boolean fQO = false;
    protected boolean fQP = true;
    protected boolean fQQ = false;
    protected int fQR = 10;

    public void rl(int i) {
        if (i >= 0) {
            this.fQG = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.fQQ) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.KC = bitmap;
            biB();
            biA();
            if (this.fQP) {
                biE();
                biG();
                if (this.fQG >= 0) {
                    biF();
                }
            }
            biC();
            biD();
            if (!this.fQP) {
                biG();
            }
            biH();
            this.fQP = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean biz() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.fQO) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.fQF = 0;
            this.out = null;
            this.KC = null;
            this.fQH = null;
            this.fQI = null;
            this.fQK = null;
            this.fQO = false;
            this.fQP = true;
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
        this.fQQ = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.fQO = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void biA() {
        int length = this.fQH.length;
        int i = length / 3;
        this.fQI = new byte[i];
        c cVar = new c(this.fQH, length, this.fQR);
        this.fQK = cVar.biN();
        for (int i2 = 0; i2 < this.fQK.length; i2 += 3) {
            byte b = this.fQK[i2];
            this.fQK[i2] = this.fQK[i2 + 2];
            this.fQK[i2 + 2] = b;
            this.fQL[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Q = cVar.Q(this.fQH[i3] & 255, this.fQH[i5] & 255, this.fQH[i6] & 255);
            this.fQL[Q] = true;
            this.fQI[i4] = (byte) Q;
        }
        this.fQH = null;
        this.fQJ = 8;
        this.fQM = 7;
        if (this.transparent != -1) {
            this.fQF = rm(this.transparent);
        }
    }

    protected int rm(int i) {
        int i2;
        int i3 = 0;
        if (this.fQK == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.fQK.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.fQK[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.fQK[i9] & 255);
            int i13 = i6 - (this.fQK[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.fQL[i15] || i14 >= i7) {
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

    protected void biB() {
        int width = this.KC.getWidth();
        int height = this.KC.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.KC, 0.0f, 0.0f, new Paint());
            this.KC = createBitmap;
        }
        int[] u = u(this.KC);
        this.fQH = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.fQH[i3] = (byte) ((i2 >> 0) & 255);
            this.fQH[i4] = (byte) ((i2 >> 8) & 255);
            this.fQH[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] u(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void biC() throws IOException {
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
        if (this.fQN >= 0) {
            i2 = this.fQN & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.fQF);
        this.out.write(0);
    }

    protected void biD() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.fQP) {
            this.out.write(0);
        } else {
            this.out.write(this.fQM | 128);
        }
    }

    protected void biE() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.fQM | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void biF() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.fQG);
        this.out.write(0);
    }

    protected void biG() throws IOException {
        this.out.write(this.fQK, 0, this.fQK.length);
        int length = 768 - this.fQK.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void biH() throws IOException {
        new b(this.width, this.height, this.fQI, this.fQJ).encode(this.out);
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
