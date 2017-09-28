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
    protected Bitmap Gn;
    protected int eMK;
    protected byte[] eMM;
    protected byte[] eMN;
    protected int eMO;
    protected byte[] eMP;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int eML = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] eMQ = new boolean[256];
    protected int eMR = 7;
    protected int eMS = -1;
    protected boolean eMT = false;
    protected boolean eMU = true;
    protected boolean eMV = false;
    protected int eMW = 10;

    public void py(int i) {
        if (i >= 0) {
            this.eML = i;
        }
    }

    public boolean k(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.eMV) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.Gn = bitmap;
            aSm();
            aSl();
            if (this.eMU) {
                aSp();
                aSr();
                if (this.eML >= 0) {
                    aSq();
                }
            }
            aSn();
            aSo();
            if (!this.eMU) {
                aSr();
            }
            aSs();
            this.eMU = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean aSk() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.eMT) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.eMK = 0;
            this.out = null;
            this.Gn = null;
            this.eMM = null;
            this.eMN = null;
            this.eMP = null;
            this.eMT = false;
            this.eMU = true;
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
        this.eMV = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.eMT = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void aSl() {
        int length = this.eMM.length;
        int i = length / 3;
        this.eMN = new byte[i];
        c cVar = new c(this.eMM, length, this.eMW);
        this.eMP = cVar.aSy();
        for (int i2 = 0; i2 < this.eMP.length; i2 += 3) {
            byte b = this.eMP[i2];
            this.eMP[i2] = this.eMP[i2 + 2];
            this.eMP[i2 + 2] = b;
            this.eMQ[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int Q = cVar.Q(this.eMM[i3] & 255, this.eMM[i5] & 255, this.eMM[i6] & 255);
            this.eMQ[Q] = true;
            this.eMN[i4] = (byte) Q;
        }
        this.eMM = null;
        this.eMO = 8;
        this.eMR = 7;
        if (this.transparent != -1) {
            this.eMK = pz(this.transparent);
        }
    }

    protected int pz(int i) {
        int i2;
        int i3 = 0;
        if (this.eMP == null) {
            return -1;
        }
        int i4 = (i >> 16) & MotionEventCompat.ACTION_MASK;
        int i5 = (i >> 8) & MotionEventCompat.ACTION_MASK;
        int i6 = (i >> 0) & MotionEventCompat.ACTION_MASK;
        int i7 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        int length = this.eMP.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.eMP[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.eMP[i9] & 255);
            int i13 = i6 - (this.eMP[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.eMQ[i15] || i14 >= i7) {
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

    protected void aSm() {
        int width = this.Gn.getWidth();
        int height = this.Gn.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.Gn, 0.0f, 0.0f, new Paint());
            this.Gn = createBitmap;
        }
        int[] l = l(this.Gn);
        this.eMM = new byte[l.length * 3];
        for (int i = 0; i < l.length; i++) {
            int i2 = l[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.eMM[i3] = (byte) ((i2 >> 0) & MotionEventCompat.ACTION_MASK);
            this.eMM[i4] = (byte) ((i2 >> 8) & MotionEventCompat.ACTION_MASK);
            this.eMM[i4 + 1] = (byte) ((i2 >> 16) & MotionEventCompat.ACTION_MASK);
        }
    }

    protected int[] l(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void aSn() throws IOException {
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
        if (this.eMS >= 0) {
            i2 = this.eMS & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.eMK);
        this.out.write(0);
    }

    protected void aSo() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.eMU) {
            this.out.write(0);
        } else {
            this.out.write(this.eMR | 128);
        }
    }

    protected void aSp() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.eMR | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void aSq() throws IOException {
        this.out.write(33);
        this.out.write(MotionEventCompat.ACTION_MASK);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.eML);
        this.out.write(0);
    }

    protected void aSr() throws IOException {
        this.out.write(this.eMP, 0, this.eMP.length);
        int length = 768 - this.eMP.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void aSs() throws IOException {
        new b(this.width, this.height, this.eMN, this.eMO).encode(this.out);
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
