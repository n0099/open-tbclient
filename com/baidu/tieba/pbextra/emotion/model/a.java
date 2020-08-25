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
    protected int laY;
    protected OutputStream lba;
    protected byte[] lbb;
    protected byte[] lbc;
    protected int lbd;
    protected byte[] lbe;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int laZ = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] lbf = new boolean[256];
    protected int lbg = 7;
    protected int lbh = -1;
    protected boolean lbi = false;
    protected boolean lbj = true;
    protected boolean lbk = false;
    protected int lbl = 10;

    public void EW(int i) {
        if (i >= 0) {
            this.laZ = i;
        }
    }

    public boolean H(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.lbk) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dfN();
            dfM();
            if (this.lbj) {
                dfQ();
                dfS();
                if (this.laZ >= 0) {
                    dfR();
                }
            }
            dfO();
            dfP();
            if (!this.lbj) {
                dfS();
            }
            dfT();
            this.lbj = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dfL() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.lba.write(59);
                this.lba.flush();
                if (this.lbi) {
                    this.lba.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.laY = 0;
            this.lba = null;
            this.image = null;
            this.lbb = null;
            this.lbc = null;
            this.lbe = null;
            this.lbi = false;
            this.lbj = true;
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
        this.lbk = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.lbi = false;
        this.lba = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dfM() {
        int length = this.lbb.length;
        int i = length / 3;
        this.lbc = new byte[i];
        c cVar = new c(this.lbb, length, this.lbl);
        this.lbe = cVar.dfZ();
        for (int i2 = 0; i2 < this.lbe.length; i2 += 3) {
            byte b = this.lbe[i2];
            this.lbe[i2] = this.lbe[i2 + 2];
            this.lbe[i2 + 2] = b;
            this.lbf[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int T = cVar.T(this.lbb[i3] & 255, this.lbb[i5] & 255, this.lbb[i6] & 255);
            this.lbf[T] = true;
            this.lbc[i4] = (byte) T;
        }
        this.lbb = null;
        this.lbd = 8;
        this.lbg = 7;
        if (this.transparent != -1) {
            this.laY = EX(this.transparent);
        }
    }

    protected int EX(int i) {
        int i2;
        int i3 = 0;
        if (this.lbe == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.lbe.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.lbe[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.lbe[i9] & 255);
            int i13 = i6 - (this.lbe[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.lbf[i15] || i14 >= i7) {
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

    protected void dfN() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] I = I(this.image);
        this.lbb = new byte[I.length * 3];
        for (int i = 0; i < I.length; i++) {
            int i2 = I[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.lbb[i3] = (byte) ((i2 >> 0) & 255);
            this.lbb[i4] = (byte) ((i2 >> 8) & 255);
            this.lbb[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] I(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dfO() throws IOException {
        int i;
        int i2;
        this.lba.write(33);
        this.lba.write(SapiAccountManager.VERSION_CODE);
        this.lba.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.lbh >= 0) {
            i2 = this.lbh & 7;
        }
        this.lba.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.lba.write(this.laY);
        this.lba.write(0);
    }

    protected void dfP() throws IOException {
        this.lba.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.lbj) {
            this.lba.write(0);
        } else {
            this.lba.write(this.lbg | 128);
        }
    }

    protected void dfQ() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.lba.write(this.lbg | 240);
        this.lba.write(0);
        this.lba.write(0);
    }

    protected void dfR() throws IOException {
        this.lba.write(33);
        this.lba.write(255);
        this.lba.write(11);
        writeString("NETSCAPE2.0");
        this.lba.write(3);
        this.lba.write(1);
        writeShort(this.laZ);
        this.lba.write(0);
    }

    protected void dfS() throws IOException {
        this.lba.write(this.lbe, 0, this.lbe.length);
        int length = 768 - this.lbe.length;
        for (int i = 0; i < length; i++) {
            this.lba.write(0);
        }
    }

    protected void dfT() throws IOException {
        new b(this.width, this.height, this.lbc, this.lbd).encode(this.lba);
    }

    protected void writeShort(int i) throws IOException {
        this.lba.write(i & 255);
        this.lba.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.lba.write((byte) str.charAt(i));
        }
    }
}
