package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.baidu.sapi2.SapiAccountManager;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes21.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected int ljW;
    protected OutputStream ljY;
    protected byte[] ljZ;
    protected byte[] lka;
    protected int lkb;
    protected byte[] lkc;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int ljX = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] lkd = new boolean[256];
    protected int lke = 7;
    protected int lkf = -1;
    protected boolean lkg = false;
    protected boolean lkh = true;
    protected boolean lki = false;
    protected int lkj = 10;

    public void Fx(int i) {
        if (i >= 0) {
            this.ljX = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.lki) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            djr();
            djq();
            if (this.lkh) {
                dju();
                djw();
                if (this.ljX >= 0) {
                    djv();
                }
            }
            djs();
            djt();
            if (!this.lkh) {
                djw();
            }
            djx();
            this.lkh = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean djp() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.ljY.write(59);
                this.ljY.flush();
                if (this.lkg) {
                    this.ljY.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.ljW = 0;
            this.ljY = null;
            this.image = null;
            this.ljZ = null;
            this.lka = null;
            this.lkc = null;
            this.lkg = false;
            this.lkh = true;
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
        this.lki = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.lkg = false;
        this.ljY = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void djq() {
        int length = this.ljZ.length;
        int i = length / 3;
        this.lka = new byte[i];
        c cVar = new c(this.ljZ, length, this.lkj);
        this.lkc = cVar.djD();
        for (int i2 = 0; i2 < this.lkc.length; i2 += 3) {
            byte b = this.lkc[i2];
            this.lkc[i2] = this.lkc[i2 + 2];
            this.lkc[i2 + 2] = b;
            this.lkd[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int V = cVar.V(this.ljZ[i3] & 255, this.ljZ[i5] & 255, this.ljZ[i6] & 255);
            this.lkd[V] = true;
            this.lka[i4] = (byte) V;
        }
        this.ljZ = null;
        this.lkb = 8;
        this.lke = 7;
        if (this.transparent != -1) {
            this.ljW = Fy(this.transparent);
        }
    }

    protected int Fy(int i) {
        int i2;
        int i3 = 0;
        if (this.lkc == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.lkc.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.lkc[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.lkc[i9] & 255);
            int i13 = i6 - (this.lkc[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.lkd[i15] || i14 >= i7) {
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

    protected void djr() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.ljZ = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.ljZ[i3] = (byte) ((i2 >> 0) & 255);
            this.ljZ[i4] = (byte) ((i2 >> 8) & 255);
            this.ljZ[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void djs() throws IOException {
        int i;
        int i2;
        this.ljY.write(33);
        this.ljY.write(SapiAccountManager.VERSION_CODE);
        this.ljY.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.lkf >= 0) {
            i2 = this.lkf & 7;
        }
        this.ljY.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.ljY.write(this.ljW);
        this.ljY.write(0);
    }

    protected void djt() throws IOException {
        this.ljY.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.lkh) {
            this.ljY.write(0);
        } else {
            this.ljY.write(this.lke | 128);
        }
    }

    protected void dju() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.ljY.write(this.lke | 240);
        this.ljY.write(0);
        this.ljY.write(0);
    }

    protected void djv() throws IOException {
        this.ljY.write(33);
        this.ljY.write(255);
        this.ljY.write(11);
        writeString("NETSCAPE2.0");
        this.ljY.write(3);
        this.ljY.write(1);
        writeShort(this.ljX);
        this.ljY.write(0);
    }

    protected void djw() throws IOException {
        this.ljY.write(this.lkc, 0, this.lkc.length);
        int length = 768 - this.lkc.length;
        for (int i = 0; i < length; i++) {
            this.ljY.write(0);
        }
    }

    protected void djx() throws IOException {
        new b(this.width, this.height, this.lka, this.lkb).encode(this.ljY);
    }

    protected void writeShort(int i) throws IOException {
        this.ljY.write(i & 255);
        this.ljY.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.ljY.write((byte) str.charAt(i));
        }
    }
}
