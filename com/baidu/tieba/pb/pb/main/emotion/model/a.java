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
    protected Bitmap GR;
    protected int eQl;
    protected byte[] eQn;
    protected byte[] eQo;
    protected int eQp;
    protected byte[] eQq;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eQm = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eQr = new boolean[256];
    protected int eQs = 7;
    protected int eQt = -1;
    protected boolean eQu = false;
    protected boolean eQv = true;
    protected boolean eQw = false;
    protected int eQx = 10;

    public void pn(int i) {
        if (i >= 0) {
            this.eQm = i;
        }
    }

    public boolean m(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eQw) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.GR = bitmap;
            aTU();
            aTT();
            if (this.eQv) {
                aTX();
                aTZ();
                if (this.eQm >= 0) {
                    aTY();
                }
            }
            aTV();
            aTW();
            if (!this.eQv) {
                aTZ();
            }
            aUa();
            this.eQv = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aTS() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eQu) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eQl = 0;
            this.out = null;
            this.GR = null;
            this.eQn = null;
            this.eQo = null;
            this.eQq = null;
            this.eQu = false;
            this.eQv = true;
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
        this.eQw = true;
    }

    public boolean g(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eQu = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aTT() {
        int length = this.eQn.length;
        int i = length / 3;
        this.eQo = new byte[i];
        c cVar = new c(this.eQn, length, this.eQx);
        this.eQq = cVar.aUg();
        for (int i2 = 0; i2 < this.eQq.length; i2 += 3) {
            byte b = this.eQq[i2];
            this.eQq[i2] = this.eQq[i2 + 2];
            this.eQq[i2 + 2] = b;
            this.eQr[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int L = cVar.L(this.eQn[i3] & 255, this.eQn[i5] & 255, this.eQn[i6] & 255);
            this.eQr[L] = true;
            this.eQo[i4] = (byte) L;
        }
        this.eQn = null;
        this.eQp = 8;
        this.eQs = 7;
        if (this.transparent != -1) {
            this.eQl = po(this.transparent);
        }
    }

    protected int po(int i) {
        int i2;
        int i3 = 0;
        if (this.eQq == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eQq.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eQq[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eQq[i9] & 255);
            int i13 = i6 - (this.eQq[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eQr[i15] || i14 >= i7) {
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

    protected void aTU() {
        int width = this.GR.getWidth();
        int height = this.GR.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.GR, 0.0f, 0.0f, new Paint());
            this.GR = createBitmap;
        }
        int[] n = n(this.GR);
        this.eQn = new byte[n.length * 3];
        for (int i = 0; i < n.length; i++) {
            int i2 = n[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eQn[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eQn[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eQn[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] n(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aTV() throws IOException {
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
        if (this.eQt >= 0) {
            i2 = this.eQt & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eQl);
        this.out.write(0);
    }

    protected void aTW() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eQv) {
            this.out.write(0);
        } else {
            this.out.write(this.eQs | 128);
        }
    }

    protected void aTX() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eQs | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aTY() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eQm);
        this.out.write(0);
    }

    protected void aTZ() throws IOException {
        this.out.write(this.eQq, 0, this.eQq.length);
        int length = 768 - this.eQq.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aUa() throws IOException {
        new b(this.width, this.height, this.eQo, this.eQp).encode(this.out);
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
