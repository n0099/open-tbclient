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
    protected Bitmap Is;
    protected int eTt;
    protected byte[] eTv;
    protected byte[] eTw;
    protected int eTx;
    protected byte[] eTy;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eTu = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eTz = new boolean[256];
    protected int eTA = 7;
    protected int eTB = -1;
    protected boolean eTC = false;
    protected boolean eTD = true;
    protected boolean eTE = false;
    protected int eTF = 10;

    public void pw(int i) {
        if (i >= 0) {
            this.eTu = i;
        }
    }

    public boolean n(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eTE) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Is = bitmap;
            aUH();
            aUG();
            if (this.eTD) {
                aUK();
                aUM();
                if (this.eTu >= 0) {
                    aUL();
                }
            }
            aUI();
            aUJ();
            if (!this.eTD) {
                aUM();
            }
            aUN();
            this.eTD = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aUF() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eTC) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eTt = 0;
            this.out = null;
            this.Is = null;
            this.eTv = null;
            this.eTw = null;
            this.eTy = null;
            this.eTC = false;
            this.eTD = true;
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
        this.eTE = true;
    }

    public boolean h(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eTC = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aUG() {
        int length = this.eTv.length;
        int i = length / 3;
        this.eTw = new byte[i];
        c cVar = new c(this.eTv, length, this.eTF);
        this.eTy = cVar.aUT();
        for (int i2 = 0; i2 < this.eTy.length; i2 += 3) {
            byte b = this.eTy[i2];
            this.eTy[i2] = this.eTy[i2 + 2];
            this.eTy[i2 + 2] = b;
            this.eTz[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int L = cVar.L(this.eTv[i3] & 255, this.eTv[i5] & 255, this.eTv[i6] & 255);
            this.eTz[L] = true;
            this.eTw[i4] = (byte) L;
        }
        this.eTv = null;
        this.eTx = 8;
        this.eTA = 7;
        if (this.transparent != -1) {
            this.eTt = px(this.transparent);
        }
    }

    protected int px(int i) {
        int i2;
        int i3 = 0;
        if (this.eTy == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eTy.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eTy[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eTy[i9] & 255);
            int i13 = i6 - (this.eTy[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eTz[i15] || i14 >= i7) {
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

    protected void aUH() {
        int width = this.Is.getWidth();
        int height = this.Is.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Is, 0.0f, 0.0f, new Paint());
            this.Is = createBitmap;
        }
        int[] o = o(this.Is);
        this.eTv = new byte[o.length * 3];
        for (int i = 0; i < o.length; i++) {
            int i2 = o[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eTv[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eTv[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eTv[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] o(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aUI() throws IOException {
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
        if (this.eTB >= 0) {
            i2 = this.eTB & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eTt);
        this.out.write(0);
    }

    protected void aUJ() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eTD) {
            this.out.write(0);
        } else {
            this.out.write(this.eTA | 128);
        }
    }

    protected void aUK() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eTA | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aUL() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eTu);
        this.out.write(0);
    }

    protected void aUM() throws IOException {
        this.out.write(this.eTy, 0, this.eTy.length);
        int length = 768 - this.eTy.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aUN() throws IOException {
        new b(this.width, this.height, this.eTw, this.eTx).encode(this.out);
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
