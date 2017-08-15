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
    protected int eTr;
    protected byte[] eTt;
    protected byte[] eTu;
    protected int eTv;
    protected byte[] eTw;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eTs = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eTx = new boolean[256];
    protected int eTy = 7;
    protected int eTz = -1;
    protected boolean eTA = false;
    protected boolean eTB = true;
    protected boolean eTC = false;
    protected int eTD = 10;

    public void pw(int i) {
        if (i >= 0) {
            this.eTs = i;
        }
    }

    public boolean n(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eTC) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Is = bitmap;
            aUM();
            aUL();
            if (this.eTB) {
                aUP();
                aUR();
                if (this.eTs >= 0) {
                    aUQ();
                }
            }
            aUN();
            aUO();
            if (!this.eTB) {
                aUR();
            }
            aUS();
            this.eTB = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aUK() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eTA) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eTr = 0;
            this.out = null;
            this.Is = null;
            this.eTt = null;
            this.eTu = null;
            this.eTw = null;
            this.eTA = false;
            this.eTB = true;
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
        this.eTC = true;
    }

    public boolean h(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eTA = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aUL() {
        int length = this.eTt.length;
        int i = length / 3;
        this.eTu = new byte[i];
        c cVar = new c(this.eTt, length, this.eTD);
        this.eTw = cVar.aUY();
        for (int i2 = 0; i2 < this.eTw.length; i2 += 3) {
            byte b = this.eTw[i2];
            this.eTw[i2] = this.eTw[i2 + 2];
            this.eTw[i2 + 2] = b;
            this.eTx[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int L = cVar.L(this.eTt[i3] & 255, this.eTt[i5] & 255, this.eTt[i6] & 255);
            this.eTx[L] = true;
            this.eTu[i4] = (byte) L;
        }
        this.eTt = null;
        this.eTv = 8;
        this.eTy = 7;
        if (this.transparent != -1) {
            this.eTr = px(this.transparent);
        }
    }

    protected int px(int i) {
        int i2;
        int i3 = 0;
        if (this.eTw == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eTw.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eTw[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eTw[i9] & 255);
            int i13 = i6 - (this.eTw[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eTx[i15] || i14 >= i7) {
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

    protected void aUM() {
        int width = this.Is.getWidth();
        int height = this.Is.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Is, 0.0f, 0.0f, new Paint());
            this.Is = createBitmap;
        }
        int[] o = o(this.Is);
        this.eTt = new byte[o.length * 3];
        for (int i = 0; i < o.length; i++) {
            int i2 = o[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eTt[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eTt[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eTt[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] o(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aUN() throws IOException {
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
        if (this.eTz >= 0) {
            i2 = this.eTz & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eTr);
        this.out.write(0);
    }

    protected void aUO() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eTB) {
            this.out.write(0);
        } else {
            this.out.write(this.eTy | 128);
        }
    }

    protected void aUP() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eTy | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aUQ() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eTs);
        this.out.write(0);
    }

    protected void aUR() throws IOException {
        this.out.write(this.eTw, 0, this.eTw.length);
        int length = 768 - this.eTw.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aUS() throws IOException {
        new b(this.width, this.height, this.eTu, this.eTv).encode(this.out);
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
