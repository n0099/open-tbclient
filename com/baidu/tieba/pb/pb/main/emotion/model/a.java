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
    protected Bitmap Go;
    protected int eMA;
    protected byte[] eMB;
    protected int eMw;
    protected byte[] eMy;
    protected byte[] eMz;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eMx = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eMC = new boolean[256];
    protected int eMD = 7;
    protected int eME = -1;
    protected boolean eMF = false;
    protected boolean eMG = true;
    protected boolean eMH = false;
    protected int eMI = 10;

    public void px(int i) {
        if (i >= 0) {
            this.eMx = i;
        }
    }

    public boolean k(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eMH) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Go = bitmap;
            aSh();
            aSg();
            if (this.eMG) {
                aSk();
                aSm();
                if (this.eMx >= 0) {
                    aSl();
                }
            }
            aSi();
            aSj();
            if (!this.eMG) {
                aSm();
            }
            aSn();
            this.eMG = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aSf() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eMF) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eMw = 0;
            this.out = null;
            this.Go = null;
            this.eMy = null;
            this.eMz = null;
            this.eMB = null;
            this.eMF = false;
            this.eMG = true;
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
        this.eMH = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eMF = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aSg() {
        int length = this.eMy.length;
        int i = length / 3;
        this.eMz = new byte[i];
        c cVar = new c(this.eMy, length, this.eMI);
        this.eMB = cVar.aSt();
        for (int i2 = 0; i2 < this.eMB.length; i2 += 3) {
            byte b = this.eMB[i2];
            this.eMB[i2] = this.eMB[i2 + 2];
            this.eMB[i2 + 2] = b;
            this.eMC[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Q = cVar.Q(this.eMy[i3] & 255, this.eMy[i5] & 255, this.eMy[i6] & 255);
            this.eMC[Q] = true;
            this.eMz[i4] = (byte) Q;
        }
        this.eMy = null;
        this.eMA = 8;
        this.eMD = 7;
        if (this.transparent != -1) {
            this.eMw = py(this.transparent);
        }
    }

    protected int py(int i) {
        int i2;
        int i3 = 0;
        if (this.eMB == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eMB.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eMB[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eMB[i9] & 255);
            int i13 = i6 - (this.eMB[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eMC[i15] || i14 >= i7) {
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

    protected void aSh() {
        int width = this.Go.getWidth();
        int height = this.Go.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Go, 0.0f, 0.0f, new Paint());
            this.Go = createBitmap;
        }
        int[] l = l(this.Go);
        this.eMy = new byte[l.length * 3];
        for (int i = 0; i < l.length; i++) {
            int i2 = l[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eMy[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eMy[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eMy[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] l(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aSi() throws IOException {
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
        if (this.eME >= 0) {
            i2 = this.eME & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eMw);
        this.out.write(0);
    }

    protected void aSj() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eMG) {
            this.out.write(0);
        } else {
            this.out.write(this.eMD | 128);
        }
    }

    protected void aSk() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eMD | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aSl() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eMx);
        this.out.write(0);
    }

    protected void aSm() throws IOException {
        this.out.write(this.eMB, 0, this.eMB.length);
        int length = 768 - this.eMB.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aSn() throws IOException {
        new b(this.width, this.height, this.eMz, this.eMA).encode(this.out);
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
