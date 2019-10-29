package com.baidu.tieba.pbextra.emotion.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class a {
    protected int height;
    protected int ihL;
    protected OutputStream ihO;
    protected byte[] ihP;
    protected byte[] ihQ;
    protected int ihR;
    protected byte[] ihS;
    protected Bitmap image;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int ihM = -1;
    protected int delay = 0;
    protected boolean ihN = false;
    protected boolean[] ihT = new boolean[256];
    protected int ihU = 7;
    protected int ihV = -1;
    protected boolean ihW = false;
    protected boolean ihX = true;
    protected boolean ihY = false;
    protected int ihZ = 10;

    public void xh(int i) {
        if (i >= 0) {
            this.ihM = i;
        }
    }

    public boolean A(Bitmap bitmap) {
        if (bitmap == null || !this.ihN) {
            return false;
        }
        try {
            if (!this.ihY) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            bYz();
            bYy();
            if (this.ihX) {
                bYC();
                bYE();
                if (this.ihM >= 0) {
                    bYD();
                }
            }
            bYA();
            bYB();
            if (!this.ihX) {
                bYE();
            }
            bYF();
            this.ihX = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean zC() {
        boolean z;
        if (this.ihN) {
            this.ihN = false;
            try {
                this.ihO.write(59);
                this.ihO.flush();
                if (this.ihW) {
                    this.ihO.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.ihL = 0;
            this.ihO = null;
            this.image = null;
            this.ihP = null;
            this.ihQ = null;
            this.ihS = null;
            this.ihW = false;
            this.ihX = true;
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
        this.ihY = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.ihW = false;
        this.ihO = outputStream;
        try {
            Bq("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.ihN = z;
        return z;
    }

    protected void bYy() {
        int length = this.ihP.length;
        int i = length / 3;
        this.ihQ = new byte[i];
        c cVar = new c(this.ihP, length, this.ihZ);
        this.ihS = cVar.bYL();
        for (int i2 = 0; i2 < this.ihS.length; i2 += 3) {
            byte b = this.ihS[i2];
            this.ihS[i2] = this.ihS[i2 + 2];
            this.ihS[i2 + 2] = b;
            this.ihT[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int R = cVar.R(this.ihP[i3] & 255, this.ihP[i5] & 255, this.ihP[i6] & 255);
            this.ihT[R] = true;
            this.ihQ[i4] = (byte) R;
        }
        this.ihP = null;
        this.ihR = 8;
        this.ihU = 7;
        if (this.transparent != -1) {
            this.ihL = xi(this.transparent);
        }
    }

    protected int xi(int i) {
        int i2;
        int i3 = 0;
        if (this.ihS == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.ihS.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.ihS[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.ihS[i9] & 255);
            int i13 = i6 - (this.ihS[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.ihT[i15] || i14 >= i7) {
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

    protected void bYz() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] B = B(this.image);
        this.ihP = new byte[B.length * 3];
        for (int i = 0; i < B.length; i++) {
            int i2 = B[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.ihP[i3] = (byte) ((i2 >> 0) & 255);
            this.ihP[i4] = (byte) ((i2 >> 8) & 255);
            this.ihP[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] B(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void bYA() throws IOException {
        int i;
        int i2;
        this.ihO.write(33);
        this.ihO.write(249);
        this.ihO.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.ihV >= 0) {
            i2 = this.ihV & 7;
        }
        this.ihO.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.ihO.write(this.ihL);
        this.ihO.write(0);
    }

    protected void bYB() throws IOException {
        this.ihO.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.ihX) {
            this.ihO.write(0);
        } else {
            this.ihO.write(this.ihU | 128);
        }
    }

    protected void bYC() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.ihO.write(this.ihU | 240);
        this.ihO.write(0);
        this.ihO.write(0);
    }

    protected void bYD() throws IOException {
        this.ihO.write(33);
        this.ihO.write(255);
        this.ihO.write(11);
        Bq("NETSCAPE2.0");
        this.ihO.write(3);
        this.ihO.write(1);
        writeShort(this.ihM);
        this.ihO.write(0);
    }

    protected void bYE() throws IOException {
        this.ihO.write(this.ihS, 0, this.ihS.length);
        int length = 768 - this.ihS.length;
        for (int i = 0; i < length; i++) {
            this.ihO.write(0);
        }
    }

    protected void bYF() throws IOException {
        new b(this.width, this.height, this.ihQ, this.ihR).d(this.ihO);
    }

    protected void writeShort(int i) throws IOException {
        this.ihO.write(i & 255);
        this.ihO.write((i >> 8) & 255);
    }

    protected void Bq(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.ihO.write((byte) str.charAt(i));
        }
    }
}
