package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    protected Bitmap atQ;
    protected int gfs;
    protected byte[] gfu;
    protected byte[] gfv;
    protected int gfw;
    protected byte[] gfx;
    protected int height;
    protected OutputStream out;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int gft = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] gfy = new boolean[256];
    protected int gfz = 7;
    protected int gfA = -1;
    protected boolean gfB = false;
    protected boolean gfC = true;
    protected boolean gfD = false;
    protected int gfE = 10;

    public void tv(int i) {
        if (i >= 0) {
            this.gft = i;
        }
    }

    public boolean q(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.gfD) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.atQ = bitmap;
            bhU();
            bhT();
            if (this.gfC) {
                bhX();
                bhZ();
                if (this.gft >= 0) {
                    bhY();
                }
            }
            bhV();
            bhW();
            if (!this.gfC) {
                bhZ();
            }
            bia();
            this.gfC = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean bhS() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.gfB) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.gfs = 0;
            this.out = null;
            this.atQ = null;
            this.gfu = null;
            this.gfv = null;
            this.gfx = null;
            this.gfB = false;
            this.gfC = true;
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
        this.gfD = true;
    }

    public boolean d(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.gfB = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void bhT() {
        int length = this.gfu.length;
        int i = length / 3;
        this.gfv = new byte[i];
        c cVar = new c(this.gfu, length, this.gfE);
        this.gfx = cVar.big();
        for (int i2 = 0; i2 < this.gfx.length; i2 += 3) {
            byte b = this.gfx[i2];
            this.gfx[i2] = this.gfx[i2 + 2];
            this.gfx[i2 + 2] = b;
            this.gfy[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int ac = cVar.ac(this.gfu[i3] & 255, this.gfu[i5] & 255, this.gfu[i6] & 255);
            this.gfy[ac] = true;
            this.gfv[i4] = (byte) ac;
        }
        this.gfu = null;
        this.gfw = 8;
        this.gfz = 7;
        if (this.transparent != -1) {
            this.gfs = tw(this.transparent);
        }
    }

    protected int tw(int i) {
        int i2;
        int i3 = 0;
        if (this.gfx == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.gfx.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.gfx[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.gfx[i9] & 255);
            int i13 = i6 - (this.gfx[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.gfy[i15] || i14 >= i7) {
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

    protected void bhU() {
        int width = this.atQ.getWidth();
        int height = this.atQ.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.atQ, 0.0f, 0.0f, new Paint());
            this.atQ = createBitmap;
        }
        int[] r = r(this.atQ);
        this.gfu = new byte[r.length * 3];
        for (int i = 0; i < r.length; i++) {
            int i2 = r[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.gfu[i3] = (byte) ((i2 >> 0) & 255);
            this.gfu[i4] = (byte) ((i2 >> 8) & 255);
            this.gfu[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] r(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bhV() throws IOException {
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
        if (this.gfA >= 0) {
            i2 = this.gfA & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.gfs);
        this.out.write(0);
    }

    protected void bhW() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.gfC) {
            this.out.write(0);
        } else {
            this.out.write(this.gfz | 128);
        }
    }

    protected void bhX() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.gfz | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void bhY() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.gft);
        this.out.write(0);
    }

    protected void bhZ() throws IOException {
        this.out.write(this.gfx, 0, this.gfx.length);
        int length = 768 - this.gfx.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void bia() throws IOException {
        new b(this.width, this.height, this.gfv, this.gfw).encode(this.out);
    }

    protected void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.out.write((byte) str.charAt(i));
        }
    }
}
