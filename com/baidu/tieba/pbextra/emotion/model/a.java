package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Ky;
    protected int fQI;
    protected byte[] fQK;
    protected byte[] fQL;
    protected int fQM;
    protected byte[] fQN;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int fQJ = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] fQO = new boolean[256];
    protected int fQP = 7;
    protected int fQQ = -1;
    protected boolean fQR = false;
    protected boolean fQS = true;
    protected boolean fQT = false;
    protected int fQU = 10;

    public void ri(int i) {
        if (i >= 0) {
            this.fQJ = i;
        }
    }

    public boolean s(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.fQT) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Ky = bitmap;
            bgP();
            bgO();
            if (this.fQS) {
                bgS();
                bgU();
                if (this.fQJ >= 0) {
                    bgT();
                }
            }
            bgQ();
            bgR();
            if (!this.fQS) {
                bgU();
            }
            bgV();
            this.fQS = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean bgN() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.fQR) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.fQI = 0;
            this.out = null;
            this.Ky = null;
            this.fQK = null;
            this.fQL = null;
            this.fQN = null;
            this.fQR = false;
            this.fQS = true;
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
        this.fQT = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.fQR = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bgO() {
        int length = this.fQK.length;
        int i = length / 3;
        this.fQL = new byte[i];
        c cVar = new c(this.fQK, length, this.fQU);
        this.fQN = cVar.bhb();
        for (int i2 = 0; i2 < this.fQN.length; i2 += 3) {
            byte b = this.fQN[i2];
            this.fQN[i2] = this.fQN[i2 + 2];
            this.fQN[i2 + 2] = b;
            this.fQO[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int P = cVar.P(this.fQK[i3] & 255, this.fQK[i5] & 255, this.fQK[i6] & 255);
            this.fQO[P] = true;
            this.fQL[i4] = (byte) P;
        }
        this.fQK = null;
        this.fQM = 8;
        this.fQP = 7;
        if (this.transparent != -1) {
            this.fQI = rj(this.transparent);
        }
    }

    protected int rj(int i) {
        int i2;
        int i3 = 0;
        if (this.fQN == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.fQN.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.fQN[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.fQN[i9] & 255);
            int i13 = i6 - (this.fQN[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.fQO[i15] || i14 >= i7) {
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

    protected void bgP() {
        int width = this.Ky.getWidth();
        int height = this.Ky.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Ky, 0.0f, 0.0f, new Paint());
            this.Ky = createBitmap;
        }
        int[] t = t(this.Ky);
        this.fQK = new byte[t.length * 3];
        for (int i = 0; i < t.length; i++) {
            int i2 = t[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.fQK[i3] = (byte) ((i2 >> 0) & 255);
            this.fQK[i4] = (byte) ((i2 >> 8) & 255);
            this.fQK[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] t(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bgQ() throws IOException {
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
        if (this.fQQ >= 0) {
            i2 = this.fQQ & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.fQI);
        this.out.write(0);
    }

    protected void bgR() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.fQS) {
            this.out.write(0);
        } else {
            this.out.write(this.fQP | 128);
        }
    }

    protected void bgS() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.fQP | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bgT() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.fQJ);
        this.out.write(0);
    }

    protected void bgU() throws IOException {
        this.out.write(this.fQN, 0, this.fQN.length);
        int length = 768 - this.fQN.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bgV() throws IOException {
        new b(this.width, this.height, this.fQL, this.fQM).encode(this.out);
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
