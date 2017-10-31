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
    protected int eVq;
    protected byte[] eVs;
    protected byte[] eVt;
    protected int eVu;
    protected byte[] eVv;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eVr = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eVw = new boolean[256];
    protected int eVx = 7;
    protected int eVy = -1;
    protected boolean eVz = false;
    protected boolean eVA = true;
    protected boolean eVB = false;
    protected int eVC = 10;

    public void pR(int i) {
        if (i >= 0) {
            this.eVr = i;
        }
    }

    public boolean k(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eVB) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.FZ = bitmap;
            aVv();
            aVu();
            if (this.eVA) {
                aVy();
                aVA();
                if (this.eVr >= 0) {
                    aVz();
                }
            }
            aVw();
            aVx();
            if (!this.eVA) {
                aVA();
            }
            aVB();
            this.eVA = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aVt() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eVz) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eVq = 0;
            this.out = null;
            this.FZ = null;
            this.eVs = null;
            this.eVt = null;
            this.eVv = null;
            this.eVz = false;
            this.eVA = true;
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
        this.eVB = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eVz = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aVu() {
        int length = this.eVs.length;
        int i = length / 3;
        this.eVt = new byte[i];
        c cVar = new c(this.eVs, length, this.eVC);
        this.eVv = cVar.aVH();
        for (int i2 = 0; i2 < this.eVv.length; i2 += 3) {
            byte b = this.eVv[i2];
            this.eVv[i2] = this.eVv[i2 + 2];
            this.eVv[i2 + 2] = b;
            this.eVw[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int T = cVar.T(this.eVs[i3] & 255, this.eVs[i5] & 255, this.eVs[i6] & 255);
            this.eVw[T] = true;
            this.eVt[i4] = (byte) T;
        }
        this.eVs = null;
        this.eVu = 8;
        this.eVx = 7;
        if (this.transparent != -1) {
            this.eVq = pS(this.transparent);
        }
    }

    protected int pS(int i) {
        int i2;
        int i3 = 0;
        if (this.eVv == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eVv.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eVv[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eVv[i9] & 255);
            int i13 = i6 - (this.eVv[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eVw[i15] || i14 >= i7) {
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

    protected void aVv() {
        int width = this.FZ.getWidth();
        int height = this.FZ.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.FZ, 0.0f, 0.0f, new Paint());
            this.FZ = createBitmap;
        }
        int[] l = l(this.FZ);
        this.eVs = new byte[l.length * 3];
        for (int i = 0; i < l.length; i++) {
            int i2 = l[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eVs[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eVs[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eVs[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] l(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aVw() throws IOException {
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
        if (this.eVy >= 0) {
            i2 = this.eVy & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eVq);
        this.out.write(0);
    }

    protected void aVx() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eVA) {
            this.out.write(0);
        } else {
            this.out.write(this.eVx | 128);
        }
    }

    protected void aVy() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eVx | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aVz() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eVr);
        this.out.write(0);
    }

    protected void aVA() throws IOException {
        this.out.write(this.eVv, 0, this.eVv.length);
        int length = 768 - this.eVv.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aVB() throws IOException {
        new b(this.width, this.height, this.eVt, this.eVu).encode(this.out);
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
