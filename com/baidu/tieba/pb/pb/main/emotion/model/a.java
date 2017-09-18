package com.baidu.tieba.pb.pb.main.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class a {
    protected Bitmap Gm;
    protected int eSO;
    protected byte[] eSQ;
    protected byte[] eSR;
    protected int eSS;
    protected byte[] eST;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eSP = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eSU = new boolean[256];
    protected int eSV = 7;
    protected int eSW = -1;
    protected boolean eSX = false;
    protected boolean eSY = true;
    protected boolean eSZ = false;
    protected int eTa = 10;

    public void pC(int i) {
        if (i >= 0) {
            this.eSP = i;
        }
    }

    public boolean i(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eSZ) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Gm = bitmap;
            aUd();
            aUc();
            if (this.eSY) {
                aUg();
                aUi();
                if (this.eSP >= 0) {
                    aUh();
                }
            }
            aUe();
            aUf();
            if (!this.eSY) {
                aUi();
            }
            aUj();
            this.eSY = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aUb() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eSX) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eSO = 0;
            this.out = null;
            this.Gm = null;
            this.eSQ = null;
            this.eSR = null;
            this.eST = null;
            this.eSX = false;
            this.eSY = true;
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
        this.eSZ = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eSX = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aUc() {
        int length = this.eSQ.length;
        int i = length / 3;
        this.eSR = new byte[i];
        c cVar = new c(this.eSQ, length, this.eTa);
        this.eST = cVar.aUp();
        for (int i2 = 0; i2 < this.eST.length; i2 += 3) {
            byte b = this.eST[i2];
            this.eST[i2] = this.eST[i2 + 2];
            this.eST[i2 + 2] = b;
            this.eSU[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int L = cVar.L(this.eSQ[i3] & 255, this.eSQ[i5] & 255, this.eSQ[i6] & 255);
            this.eSU[L] = true;
            this.eSR[i4] = (byte) L;
        }
        this.eSQ = null;
        this.eSS = 8;
        this.eSV = 7;
        if (this.transparent != -1) {
            this.eSO = pD(this.transparent);
        }
    }

    protected int pD(int i) {
        int i2;
        int i3 = 0;
        if (this.eST == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eST.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eST[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eST[i9] & 255);
            int i13 = i6 - (this.eST[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eSU[i15] || i14 >= i7) {
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

    protected void aUd() {
        int width = this.Gm.getWidth();
        int height = this.Gm.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Gm, 0.0f, 0.0f, new Paint());
            this.Gm = createBitmap;
        }
        int[] j = j(this.Gm);
        this.eSQ = new byte[j.length * 3];
        for (int i = 0; i < j.length; i++) {
            int i2 = j[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eSQ[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eSQ[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eSQ[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] j(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aUe() throws IOException {
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
        if (this.eSW >= 0) {
            i2 = this.eSW & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eSO);
        this.out.write(0);
    }

    protected void aUf() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eSY) {
            this.out.write(0);
        } else {
            this.out.write(this.eSV | 128);
        }
    }

    protected void aUg() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eSV | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aUh() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eSP);
        this.out.write(0);
    }

    protected void aUi() throws IOException {
        this.out.write(this.eST, 0, this.eST.length);
        int length = 768 - this.eST.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aUj() throws IOException {
        new b(this.width, this.height, this.eSR, this.eSS).encode(this.out);
    }

    protected void writeShort(int i) throws IOException {
        this.out.write(i & MotionEventCompat.ACTION_MASK);
        this.out.write((i >> 8) & MotionEventCompat.ACTION_MASK);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.out.write((byte) str.charAt(i));
        }
    }
}
