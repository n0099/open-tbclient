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
    protected byte[] mpO;
    protected byte[] mpP;
    protected int mpQ;
    protected byte[] mpR;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mpN = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] mpS = new boolean[256];
    protected int mpT = 7;
    protected int dispose = -1;
    protected boolean mpU = false;
    protected boolean mpV = true;
    protected boolean mpW = false;
    protected int mpX = 10;

    public void GD(int i) {
        if (i >= 0) {
            this.mpN = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mpW) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dvK();
            dvJ();
            if (this.mpV) {
                dvN();
                dvP();
                if (this.mpN >= 0) {
                    dvO();
                }
            }
            dvL();
            dvM();
            if (!this.mpV) {
                dvP();
            }
            dvQ();
            this.mpV = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dvI() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.mpU) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.mpO = null;
            this.mpP = null;
            this.mpR = null;
            this.mpU = false;
            this.mpV = true;
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
        this.mpW = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.mpU = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dvJ() {
        int length = this.mpO.length;
        int i = length / 3;
        this.mpP = new byte[i];
        c cVar = new c(this.mpO, length, this.mpX);
        this.mpR = cVar.dvW();
        for (int i2 = 0; i2 < this.mpR.length; i2 += 3) {
            byte b2 = this.mpR[i2];
            this.mpR[i2] = this.mpR[i2 + 2];
            this.mpR[i2 + 2] = b2;
            this.mpS[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int X = cVar.X(this.mpO[i3] & 255, this.mpO[i5] & 255, this.mpO[i6] & 255);
            this.mpS[X] = true;
            this.mpP[i4] = (byte) X;
        }
        this.mpO = null;
        this.mpQ = 8;
        this.mpT = 7;
        if (this.transparent != -1) {
            this.transIndex = GE(this.transparent);
        }
    }

    protected int GE(int i) {
        if (this.mpR == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 0) & 255;
        int i5 = 16777216;
        int length = this.mpR.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int i9 = i2 - (this.mpR[i6] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (this.mpR[i8] & 255);
            int i12 = i4 - (this.mpR[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (!this.mpS[i14] || i13 >= i5) {
                i13 = i5;
                i14 = i7;
            }
            i6 = i10 + 1;
            i5 = i13;
            i7 = i14;
        }
        return i7;
    }

    protected void dvK() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.mpO = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.mpO[i3] = (byte) ((i2 >> 0) & 255);
            this.mpO[i4] = (byte) ((i2 >> 8) & 255);
            this.mpO[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dvL() throws IOException {
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

    protected void dvM() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.mpV) {
            this.out.write(0);
        } else {
            this.out.write(this.mpT | 128);
        }
    }

    protected void dvN() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.mpT | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void dvO() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.mpN);
        this.out.write(0);
    }

    protected void dvP() throws IOException {
        this.out.write(this.mpR, 0, this.mpR.length);
        int length = 768 - this.mpR.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void dvQ() throws IOException {
        new b(this.width, this.height, this.mpP, this.mpQ).encode(this.out);
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
