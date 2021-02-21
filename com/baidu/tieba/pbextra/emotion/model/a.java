package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.yy.videoplayer.decoder.VideoConstant;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected byte[] mqd;
    protected byte[] mqe;
    protected int mqf;
    protected byte[] mqg;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mqc = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] mqh = new boolean[256];
    protected int mqi = 7;
    protected int dispose = -1;
    protected boolean mqj = false;
    protected boolean mqk = true;
    protected boolean mql = false;
    protected int mqm = 10;

    public void GD(int i) {
        if (i >= 0) {
            this.mqc = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mql) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dvR();
            dvQ();
            if (this.mqk) {
                dvU();
                dvW();
                if (this.mqc >= 0) {
                    dvV();
                }
            }
            dvS();
            dvT();
            if (!this.mqk) {
                dvW();
            }
            dvX();
            this.mqk = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dvP() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.mqj) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.mqd = null;
            this.mqe = null;
            this.mqg = null;
            this.mqj = false;
            this.mqk = true;
            return z;
        }
        return false;
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        if (this.width < 1) {
            this.width = VideoConstant.THUMBNAIL_WIDTH;
        }
        if (this.height < 1) {
            this.height = 240;
        }
        this.mql = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.mqj = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dvQ() {
        int length = this.mqd.length;
        int i = length / 3;
        this.mqe = new byte[i];
        c cVar = new c(this.mqd, length, this.mqm);
        this.mqg = cVar.dwd();
        for (int i2 = 0; i2 < this.mqg.length; i2 += 3) {
            byte b2 = this.mqg[i2];
            this.mqg[i2] = this.mqg[i2 + 2];
            this.mqg[i2 + 2] = b2;
            this.mqh[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int X = cVar.X(this.mqd[i3] & 255, this.mqd[i5] & 255, this.mqd[i6] & 255);
            this.mqh[X] = true;
            this.mqe[i4] = (byte) X;
        }
        this.mqd = null;
        this.mqf = 8;
        this.mqi = 7;
        if (this.transparent != -1) {
            this.transIndex = GE(this.transparent);
        }
    }

    protected int GE(int i) {
        if (this.mqg == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 0) & 255;
        int i5 = 16777216;
        int length = this.mqg.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int i9 = i2 - (this.mqg[i6] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (this.mqg[i8] & 255);
            int i12 = i4 - (this.mqg[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (!this.mqh[i14] || i13 >= i5) {
                i13 = i5;
                i14 = i7;
            }
            i6 = i10 + 1;
            i5 = i13;
            i7 = i14;
        }
        return i7;
    }

    protected void dvR() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.mqd = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.mqd[i3] = (byte) ((i2 >> 0) & 255);
            this.mqd[i4] = (byte) ((i2 >> 8) & 255);
            this.mqd[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dvS() throws IOException {
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
        if (this.dispose >= 0) {
            i2 = this.dispose & 7;
        }
        this.out.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    protected void dvT() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.mqk) {
            this.out.write(0);
        } else {
            this.out.write(this.mqi | 128);
        }
    }

    protected void dvU() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.mqi | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void dvV() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.mqc);
        this.out.write(0);
    }

    protected void dvW() throws IOException {
        this.out.write(this.mqg, 0, this.mqg.length);
        int length = 768 - this.mqg.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void dvX() throws IOException {
        new b(this.width, this.height, this.mqe, this.mqf).encode(this.out);
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
