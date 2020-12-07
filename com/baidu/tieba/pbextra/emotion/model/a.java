package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes22.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected int mgc;
    protected OutputStream mge;
    protected byte[] mgf;
    protected byte[] mgg;
    protected int mgh;
    protected byte[] mgi;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mgd = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] mgj = new boolean[256];
    protected int mgk = 7;
    protected int mgl = -1;
    protected boolean mgm = false;
    protected boolean mgn = true;
    protected boolean mgo = false;
    protected int mgp = 10;

    public void HY(int i) {
        if (i >= 0) {
            this.mgd = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mgo) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dxC();
            dxB();
            if (this.mgn) {
                dxF();
                dxH();
                if (this.mgd >= 0) {
                    dxG();
                }
            }
            dxD();
            dxE();
            if (!this.mgn) {
                dxH();
            }
            dxI();
            this.mgn = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dxA() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.mge.write(59);
                this.mge.flush();
                if (this.mgm) {
                    this.mge.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.mgc = 0;
            this.mge = null;
            this.image = null;
            this.mgf = null;
            this.mgg = null;
            this.mgi = null;
            this.mgm = false;
            this.mgn = true;
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
        this.mgo = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.mgm = false;
        this.mge = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dxB() {
        int length = this.mgf.length;
        int i = length / 3;
        this.mgg = new byte[i];
        c cVar = new c(this.mgf, length, this.mgp);
        this.mgi = cVar.dxO();
        for (int i2 = 0; i2 < this.mgi.length; i2 += 3) {
            byte b = this.mgi[i2];
            this.mgi[i2] = this.mgi[i2 + 2];
            this.mgi[i2 + 2] = b;
            this.mgj[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int X = cVar.X(this.mgf[i3] & 255, this.mgf[i5] & 255, this.mgf[i6] & 255);
            this.mgj[X] = true;
            this.mgg[i4] = (byte) X;
        }
        this.mgf = null;
        this.mgh = 8;
        this.mgk = 7;
        if (this.transparent != -1) {
            this.mgc = HZ(this.transparent);
        }
    }

    protected int HZ(int i) {
        int i2;
        int i3 = 0;
        if (this.mgi == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.mgi.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.mgi[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.mgi[i9] & 255);
            int i13 = i6 - (this.mgi[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.mgj[i15] || i14 >= i7) {
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

    protected void dxC() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.mgf = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.mgf[i3] = (byte) ((i2 >> 0) & 255);
            this.mgf[i4] = (byte) ((i2 >> 8) & 255);
            this.mgf[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dxD() throws IOException {
        int i;
        int i2;
        this.mge.write(33);
        this.mge.write(249);
        this.mge.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.mgl >= 0) {
            i2 = this.mgl & 7;
        }
        this.mge.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.mge.write(this.mgc);
        this.mge.write(0);
    }

    protected void dxE() throws IOException {
        this.mge.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.mgn) {
            this.mge.write(0);
        } else {
            this.mge.write(this.mgk | 128);
        }
    }

    protected void dxF() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.mge.write(this.mgk | 240);
        this.mge.write(0);
        this.mge.write(0);
    }

    protected void dxG() throws IOException {
        this.mge.write(33);
        this.mge.write(255);
        this.mge.write(11);
        writeString("NETSCAPE2.0");
        this.mge.write(3);
        this.mge.write(1);
        writeShort(this.mgd);
        this.mge.write(0);
    }

    protected void dxH() throws IOException {
        this.mge.write(this.mgi, 0, this.mgi.length);
        int length = 768 - this.mgi.length;
        for (int i = 0; i < length; i++) {
            this.mge.write(0);
        }
    }

    protected void dxI() throws IOException {
        new b(this.width, this.height, this.mgg, this.mgh).encode(this.mge);
    }

    protected void writeShort(int i) throws IOException {
        this.mge.write(i & 255);
        this.mge.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.mge.write((byte) str.charAt(i));
        }
    }
}
