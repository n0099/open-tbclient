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
    protected int mge;
    protected OutputStream mgg;
    protected byte[] mgh;
    protected byte[] mgi;
    protected int mgj;
    protected byte[] mgk;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mgf = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] mgl = new boolean[256];
    protected int mgm = 7;
    protected int mgn = -1;
    protected boolean mgo = false;
    protected boolean mgp = true;
    protected boolean mgq = false;
    protected int mgr = 10;

    public void HY(int i) {
        if (i >= 0) {
            this.mgf = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mgq) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dxD();
            dxC();
            if (this.mgp) {
                dxG();
                dxI();
                if (this.mgf >= 0) {
                    dxH();
                }
            }
            dxE();
            dxF();
            if (!this.mgp) {
                dxI();
            }
            dxJ();
            this.mgp = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dxB() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.mgg.write(59);
                this.mgg.flush();
                if (this.mgo) {
                    this.mgg.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.mge = 0;
            this.mgg = null;
            this.image = null;
            this.mgh = null;
            this.mgi = null;
            this.mgk = null;
            this.mgo = false;
            this.mgp = true;
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
        this.mgq = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.mgo = false;
        this.mgg = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dxC() {
        int length = this.mgh.length;
        int i = length / 3;
        this.mgi = new byte[i];
        c cVar = new c(this.mgh, length, this.mgr);
        this.mgk = cVar.dxP();
        for (int i2 = 0; i2 < this.mgk.length; i2 += 3) {
            byte b = this.mgk[i2];
            this.mgk[i2] = this.mgk[i2 + 2];
            this.mgk[i2 + 2] = b;
            this.mgl[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int X = cVar.X(this.mgh[i3] & 255, this.mgh[i5] & 255, this.mgh[i6] & 255);
            this.mgl[X] = true;
            this.mgi[i4] = (byte) X;
        }
        this.mgh = null;
        this.mgj = 8;
        this.mgm = 7;
        if (this.transparent != -1) {
            this.mge = HZ(this.transparent);
        }
    }

    protected int HZ(int i) {
        int i2;
        int i3 = 0;
        if (this.mgk == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.mgk.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.mgk[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.mgk[i9] & 255);
            int i13 = i6 - (this.mgk[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.mgl[i15] || i14 >= i7) {
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

    protected void dxD() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.mgh = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.mgh[i3] = (byte) ((i2 >> 0) & 255);
            this.mgh[i4] = (byte) ((i2 >> 8) & 255);
            this.mgh[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dxE() throws IOException {
        int i;
        int i2;
        this.mgg.write(33);
        this.mgg.write(249);
        this.mgg.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.mgn >= 0) {
            i2 = this.mgn & 7;
        }
        this.mgg.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.mgg.write(this.mge);
        this.mgg.write(0);
    }

    protected void dxF() throws IOException {
        this.mgg.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.mgp) {
            this.mgg.write(0);
        } else {
            this.mgg.write(this.mgm | 128);
        }
    }

    protected void dxG() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.mgg.write(this.mgm | 240);
        this.mgg.write(0);
        this.mgg.write(0);
    }

    protected void dxH() throws IOException {
        this.mgg.write(33);
        this.mgg.write(255);
        this.mgg.write(11);
        writeString("NETSCAPE2.0");
        this.mgg.write(3);
        this.mgg.write(1);
        writeShort(this.mgf);
        this.mgg.write(0);
    }

    protected void dxI() throws IOException {
        this.mgg.write(this.mgk, 0, this.mgk.length);
        int length = 768 - this.mgk.length;
        for (int i = 0; i < length; i++) {
            this.mgg.write(0);
        }
    }

    protected void dxJ() throws IOException {
        new b(this.width, this.height, this.mgi, this.mgj).encode(this.mgg);
    }

    protected void writeShort(int i) throws IOException {
        this.mgg.write(i & 255);
        this.mgg.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.mgg.write((byte) str.charAt(i));
        }
    }
}
