package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.baidu.sapi2.SapiAccountManager;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes16.dex */
public class a {
    protected int height;
    protected Bitmap image;
    protected int lbf;
    protected OutputStream lbh;
    protected byte[] lbi;
    protected byte[] lbj;
    protected int lbk;
    protected byte[] lbl;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int lbg = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] lbm = new boolean[256];
    protected int lbn = 7;
    protected int lbo = -1;
    protected boolean lbp = false;
    protected boolean lbq = true;
    protected boolean lbr = false;
    protected int lbs = 10;

    public void EW(int i) {
        if (i >= 0) {
            this.lbg = i;
        }
    }

    public boolean H(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.lbr) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dfO();
            dfN();
            if (this.lbq) {
                dfR();
                dfT();
                if (this.lbg >= 0) {
                    dfS();
                }
            }
            dfP();
            dfQ();
            if (!this.lbq) {
                dfT();
            }
            dfU();
            this.lbq = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dfM() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.lbh.write(59);
                this.lbh.flush();
                if (this.lbp) {
                    this.lbh.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.lbf = 0;
            this.lbh = null;
            this.image = null;
            this.lbi = null;
            this.lbj = null;
            this.lbl = null;
            this.lbp = false;
            this.lbq = true;
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
        this.lbr = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.lbp = false;
        this.lbh = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dfN() {
        int length = this.lbi.length;
        int i = length / 3;
        this.lbj = new byte[i];
        c cVar = new c(this.lbi, length, this.lbs);
        this.lbl = cVar.dga();
        for (int i2 = 0; i2 < this.lbl.length; i2 += 3) {
            byte b = this.lbl[i2];
            this.lbl[i2] = this.lbl[i2 + 2];
            this.lbl[i2 + 2] = b;
            this.lbm[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int T = cVar.T(this.lbi[i3] & 255, this.lbi[i5] & 255, this.lbi[i6] & 255);
            this.lbm[T] = true;
            this.lbj[i4] = (byte) T;
        }
        this.lbi = null;
        this.lbk = 8;
        this.lbn = 7;
        if (this.transparent != -1) {
            this.lbf = EX(this.transparent);
        }
    }

    protected int EX(int i) {
        int i2;
        int i3 = 0;
        if (this.lbl == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.lbl.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.lbl[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.lbl[i9] & 255);
            int i13 = i6 - (this.lbl[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.lbm[i15] || i14 >= i7) {
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

    protected void dfO() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] I = I(this.image);
        this.lbi = new byte[I.length * 3];
        for (int i = 0; i < I.length; i++) {
            int i2 = I[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.lbi[i3] = (byte) ((i2 >> 0) & 255);
            this.lbi[i4] = (byte) ((i2 >> 8) & 255);
            this.lbi[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] I(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dfP() throws IOException {
        int i;
        int i2;
        this.lbh.write(33);
        this.lbh.write(SapiAccountManager.VERSION_CODE);
        this.lbh.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.lbo >= 0) {
            i2 = this.lbo & 7;
        }
        this.lbh.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.lbh.write(this.lbf);
        this.lbh.write(0);
    }

    protected void dfQ() throws IOException {
        this.lbh.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.lbq) {
            this.lbh.write(0);
        } else {
            this.lbh.write(this.lbn | 128);
        }
    }

    protected void dfR() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.lbh.write(this.lbn | 240);
        this.lbh.write(0);
        this.lbh.write(0);
    }

    protected void dfS() throws IOException {
        this.lbh.write(33);
        this.lbh.write(255);
        this.lbh.write(11);
        writeString("NETSCAPE2.0");
        this.lbh.write(3);
        this.lbh.write(1);
        writeShort(this.lbg);
        this.lbh.write(0);
    }

    protected void dfT() throws IOException {
        this.lbh.write(this.lbl, 0, this.lbl.length);
        int length = 768 - this.lbl.length;
        for (int i = 0; i < length; i++) {
            this.lbh.write(0);
        }
    }

    protected void dfU() throws IOException {
        new b(this.width, this.height, this.lbj, this.lbk).encode(this.lbh);
    }

    protected void writeShort(int i) throws IOException {
        this.lbh.write(i & 255);
        this.lbh.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.lbh.write((byte) str.charAt(i));
        }
    }
}
