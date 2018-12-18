package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap Nu;
    protected int gnN;
    protected byte[] gnP;
    protected byte[] gnQ;
    protected int gnR;
    protected byte[] gnS;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int gnO = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] gnT = new boolean[256];
    protected int gnU = 7;
    protected int gnV = -1;
    protected boolean gnW = false;
    protected boolean gnX = true;
    protected boolean gnY = false;
    protected int gnZ = 10;

    public void sP(int i) {
        if (i >= 0) {
            this.gnO = i;
        }
    }

    public boolean t(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.gnY) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Nu = bitmap;
            bnP();
            bnO();
            if (this.gnX) {
                bnS();
                bnU();
                if (this.gnO >= 0) {
                    bnT();
                }
            }
            bnQ();
            bnR();
            if (!this.gnX) {
                bnU();
            }
            bnV();
            this.gnX = false;
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
                if (this.gnW) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.gnN = 0;
            this.out = null;
            this.Nu = null;
            this.gnP = null;
            this.gnQ = null;
            this.gnS = null;
            this.gnW = false;
            this.gnX = true;
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
        this.gnY = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.gnW = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bnO() {
        int length = this.gnP.length;
        int i = length / 3;
        this.gnQ = new byte[i];
        c cVar = new c(this.gnP, length, this.gnZ);
        this.gnS = cVar.bob();
        for (int i2 = 0; i2 < this.gnS.length; i2 += 3) {
            byte b = this.gnS[i2];
            this.gnS[i2] = this.gnS[i2 + 2];
            this.gnS[i2 + 2] = b;
            this.gnT[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int U = cVar.U(this.gnP[i3] & 255, this.gnP[i5] & 255, this.gnP[i6] & 255);
            this.gnT[U] = true;
            this.gnQ[i4] = (byte) U;
        }
        this.gnP = null;
        this.gnR = 8;
        this.gnU = 7;
        if (this.transparent != -1) {
            this.gnN = sQ(this.transparent);
        }
    }

    protected int sQ(int i) {
        int i2;
        int i3 = 0;
        if (this.gnS == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.gnS.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.gnS[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.gnS[i9] & 255);
            int i13 = i6 - (this.gnS[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.gnT[i15] || i14 >= i7) {
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

    protected void bnP() {
        int width = this.Nu.getWidth();
        int height = this.Nu.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Nu, 0.0f, 0.0f, new Paint());
            this.Nu = createBitmap;
        }
        int[] u = u(this.Nu);
        this.gnP = new byte[u.length * 3];
        for (int i = 0; i < u.length; i++) {
            int i2 = u[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.gnP[i3] = (byte) ((i2 >> 0) & 255);
            this.gnP[i4] = (byte) ((i2 >> 8) & 255);
            this.gnP[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] u(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bnQ() throws IOException {
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
        if (this.gnV >= 0) {
            i2 = this.gnV & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.gnN);
        this.out.write(0);
    }

    protected void bnR() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.gnX) {
            this.out.write(0);
        } else {
            this.out.write(this.gnU | 128);
        }
    }

    protected void bnS() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.gnU | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bnT() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.gnO);
        this.out.write(0);
    }

    protected void bnU() throws IOException {
        this.out.write(this.gnS, 0, this.gnS.length);
        int length = 768 - this.gnS.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bnV() throws IOException {
        new b(this.width, this.height, this.gnQ, this.gnR).encode(this.out);
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
