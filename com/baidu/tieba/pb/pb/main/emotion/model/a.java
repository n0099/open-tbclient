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
    protected int eRU;
    protected byte[] eRW;
    protected byte[] eRX;
    protected int eRY;
    protected byte[] eRZ;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eRV = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eSa = new boolean[256];
    protected int eSb = 7;
    protected int eSc = -1;
    protected boolean eSd = false;
    protected boolean eSe = true;
    protected boolean eSf = false;
    protected int eSg = 10;

    public void pA(int i) {
        if (i >= 0) {
            this.eRV = i;
        }
    }

    public boolean i(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eSf) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Gm = bitmap;
            aTS();
            aTR();
            if (this.eSe) {
                aTV();
                aTX();
                if (this.eRV >= 0) {
                    aTW();
                }
            }
            aTT();
            aTU();
            if (!this.eSe) {
                aTX();
            }
            aTY();
            this.eSe = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aTQ() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eSd) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eRU = 0;
            this.out = null;
            this.Gm = null;
            this.eRW = null;
            this.eRX = null;
            this.eRZ = null;
            this.eSd = false;
            this.eSe = true;
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
        this.eSf = true;
    }

    public boolean e(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eSd = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aTR() {
        int length = this.eRW.length;
        int i = length / 3;
        this.eRX = new byte[i];
        c cVar = new c(this.eRW, length, this.eSg);
        this.eRZ = cVar.aUe();
        for (int i2 = 0; i2 < this.eRZ.length; i2 += 3) {
            byte b = this.eRZ[i2];
            this.eRZ[i2] = this.eRZ[i2 + 2];
            this.eRZ[i2 + 2] = b;
            this.eSa[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int L = cVar.L(this.eRW[i3] & 255, this.eRW[i5] & 255, this.eRW[i6] & 255);
            this.eSa[L] = true;
            this.eRX[i4] = (byte) L;
        }
        this.eRW = null;
        this.eRY = 8;
        this.eSb = 7;
        if (this.transparent != -1) {
            this.eRU = pB(this.transparent);
        }
    }

    protected int pB(int i) {
        int i2;
        int i3 = 0;
        if (this.eRZ == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eRZ.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eRZ[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eRZ[i9] & 255);
            int i13 = i6 - (this.eRZ[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eSa[i15] || i14 >= i7) {
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

    protected void aTS() {
        int width = this.Gm.getWidth();
        int height = this.Gm.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Gm, 0.0f, 0.0f, new Paint());
            this.Gm = createBitmap;
        }
        int[] j = j(this.Gm);
        this.eRW = new byte[j.length * 3];
        for (int i = 0; i < j.length; i++) {
            int i2 = j[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eRW[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eRW[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eRW[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] j(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aTT() throws IOException {
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
        if (this.eSc >= 0) {
            i2 = this.eSc & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eRU);
        this.out.write(0);
    }

    protected void aTU() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eSe) {
            this.out.write(0);
        } else {
            this.out.write(this.eSb | 128);
        }
    }

    protected void aTV() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eSb | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aTW() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eRV);
        this.out.write(0);
    }

    protected void aTX() throws IOException {
        this.out.write(this.eRZ, 0, this.eRZ.length);
        int length = 768 - this.eRZ.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aTY() throws IOException {
        new b(this.width, this.height, this.eRX, this.eRY).encode(this.out);
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
