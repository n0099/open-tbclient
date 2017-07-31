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
    protected Bitmap Iq;
    protected byte[] eRA;
    protected byte[] eRB;
    protected int eRC;
    protected byte[] eRD;
    protected int eRy;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eRz = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eRE = new boolean[256];
    protected int eRF = 7;
    protected int eRG = -1;
    protected boolean eRH = false;
    protected boolean eRI = true;
    protected boolean eRJ = false;
    protected int eRK = 10;

    public void pm(int i) {
        if (i >= 0) {
            this.eRz = i;
        }
    }

    public boolean n(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eRJ) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Iq = bitmap;
            aUf();
            aUe();
            if (this.eRI) {
                aUi();
                aUk();
                if (this.eRz >= 0) {
                    aUj();
                }
            }
            aUg();
            aUh();
            if (!this.eRI) {
                aUk();
            }
            aUl();
            this.eRI = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aUd() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eRH) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eRy = 0;
            this.out = null;
            this.Iq = null;
            this.eRA = null;
            this.eRB = null;
            this.eRD = null;
            this.eRH = false;
            this.eRI = true;
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
        this.eRJ = true;
    }

    public boolean h(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eRH = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aUe() {
        int length = this.eRA.length;
        int i = length / 3;
        this.eRB = new byte[i];
        c cVar = new c(this.eRA, length, this.eRK);
        this.eRD = cVar.aUr();
        for (int i2 = 0; i2 < this.eRD.length; i2 += 3) {
            byte b = this.eRD[i2];
            this.eRD[i2] = this.eRD[i2 + 2];
            this.eRD[i2 + 2] = b;
            this.eRE[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int L = cVar.L(this.eRA[i3] & 255, this.eRA[i5] & 255, this.eRA[i6] & 255);
            this.eRE[L] = true;
            this.eRB[i4] = (byte) L;
        }
        this.eRA = null;
        this.eRC = 8;
        this.eRF = 7;
        if (this.transparent != -1) {
            this.eRy = pn(this.transparent);
        }
    }

    protected int pn(int i) {
        int i2;
        int i3 = 0;
        if (this.eRD == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eRD.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eRD[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eRD[i9] & 255);
            int i13 = i6 - (this.eRD[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eRE[i15] || i14 >= i7) {
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

    protected void aUf() {
        int width = this.Iq.getWidth();
        int height = this.Iq.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Iq, 0.0f, 0.0f, new Paint());
            this.Iq = createBitmap;
        }
        int[] o = o(this.Iq);
        this.eRA = new byte[o.length * 3];
        for (int i = 0; i < o.length; i++) {
            int i2 = o[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eRA[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eRA[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eRA[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] o(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aUg() throws IOException {
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
        if (this.eRG >= 0) {
            i2 = this.eRG & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eRy);
        this.out.write(0);
    }

    protected void aUh() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eRI) {
            this.out.write(0);
        } else {
            this.out.write(this.eRF | 128);
        }
    }

    protected void aUi() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eRF | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aUj() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eRz);
        this.out.write(0);
    }

    protected void aUk() throws IOException {
        this.out.write(this.eRD, 0, this.eRD.length);
        int length = 768 - this.eRD.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aUl() throws IOException {
        new b(this.width, this.height, this.eRB, this.eRC).encode(this.out);
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
