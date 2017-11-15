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
    protected Bitmap FZ;
    protected int eVL;
    protected byte[] eVN;
    protected byte[] eVO;
    protected int eVP;
    protected byte[] eVQ;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eVM = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eVR = new boolean[256];
    protected int eVS = 7;
    protected int eVT = -1;
    protected boolean eVU = false;
    protected boolean eVV = true;
    protected boolean eVW = false;
    protected int eVX = 10;

    public void pS(int i) {
        if (i >= 0) {
            this.eVM = i;
        }
    }

    public boolean k(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eVW) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.FZ = bitmap;
            aVD();
            aVC();
            if (this.eVV) {
                aVG();
                aVI();
                if (this.eVM >= 0) {
                    aVH();
                }
            }
            aVE();
            aVF();
            if (!this.eVV) {
                aVI();
            }
            aVJ();
            this.eVV = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aVB() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eVU) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eVL = 0;
            this.out = null;
            this.FZ = null;
            this.eVN = null;
            this.eVO = null;
            this.eVQ = null;
            this.eVU = false;
            this.eVV = true;
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
        this.eVW = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eVU = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aVC() {
        int length = this.eVN.length;
        int i = length / 3;
        this.eVO = new byte[i];
        c cVar = new c(this.eVN, length, this.eVX);
        this.eVQ = cVar.aVP();
        for (int i2 = 0; i2 < this.eVQ.length; i2 += 3) {
            byte b = this.eVQ[i2];
            this.eVQ[i2] = this.eVQ[i2 + 2];
            this.eVQ[i2 + 2] = b;
            this.eVR[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int T = cVar.T(this.eVN[i3] & 255, this.eVN[i5] & 255, this.eVN[i6] & 255);
            this.eVR[T] = true;
            this.eVO[i4] = (byte) T;
        }
        this.eVN = null;
        this.eVP = 8;
        this.eVS = 7;
        if (this.transparent != -1) {
            this.eVL = pT(this.transparent);
        }
    }

    protected int pT(int i) {
        int i2;
        int i3 = 0;
        if (this.eVQ == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eVQ.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eVQ[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eVQ[i9] & 255);
            int i13 = i6 - (this.eVQ[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eVR[i15] || i14 >= i7) {
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

    protected void aVD() {
        int width = this.FZ.getWidth();
        int height = this.FZ.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.FZ, 0.0f, 0.0f, new Paint());
            this.FZ = createBitmap;
        }
        int[] l = l(this.FZ);
        this.eVN = new byte[l.length * 3];
        for (int i = 0; i < l.length; i++) {
            int i2 = l[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eVN[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eVN[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eVN[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] l(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aVE() throws IOException {
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
        if (this.eVT >= 0) {
            i2 = this.eVT & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eVL);
        this.out.write(0);
    }

    protected void aVF() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eVV) {
            this.out.write(0);
        } else {
            this.out.write(this.eVS | 128);
        }
    }

    protected void aVG() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eVS | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aVH() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eVM);
        this.out.write(0);
    }

    protected void aVI() throws IOException {
        this.out.write(this.eVQ, 0, this.eVQ.length);
        int length = 768 - this.eVQ.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aVJ() throws IOException {
        new b(this.width, this.height, this.eVO, this.eVP).encode(this.out);
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
