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
    protected int lLL;
    protected OutputStream lLN;
    protected byte[] lLO;
    protected byte[] lLP;
    protected int lLQ;
    protected byte[] lLR;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int lLM = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] lLS = new boolean[256];
    protected int lLT = 7;
    protected int lLU = -1;
    protected boolean lLV = false;
    protected boolean lLW = true;
    protected boolean lLX = false;
    protected int lLY = 10;

    public void Gw(int i) {
        if (i >= 0) {
            this.lLM = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.lLX) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dqi();
            dqh();
            if (this.lLW) {
                dql();
                dqn();
                if (this.lLM >= 0) {
                    dqm();
                }
            }
            dqj();
            dqk();
            if (!this.lLW) {
                dqn();
            }
            dqo();
            this.lLW = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dqg() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.lLN.write(59);
                this.lLN.flush();
                if (this.lLV) {
                    this.lLN.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.lLL = 0;
            this.lLN = null;
            this.image = null;
            this.lLO = null;
            this.lLP = null;
            this.lLR = null;
            this.lLV = false;
            this.lLW = true;
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
        this.lLX = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.lLV = false;
        this.lLN = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dqh() {
        int length = this.lLO.length;
        int i = length / 3;
        this.lLP = new byte[i];
        c cVar = new c(this.lLO, length, this.lLY);
        this.lLR = cVar.dqu();
        for (int i2 = 0; i2 < this.lLR.length; i2 += 3) {
            byte b = this.lLR[i2];
            this.lLR[i2] = this.lLR[i2 + 2];
            this.lLR[i2 + 2] = b;
            this.lLS[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int W = cVar.W(this.lLO[i3] & 255, this.lLO[i5] & 255, this.lLO[i6] & 255);
            this.lLS[W] = true;
            this.lLP[i4] = (byte) W;
        }
        this.lLO = null;
        this.lLQ = 8;
        this.lLT = 7;
        if (this.transparent != -1) {
            this.lLL = Gx(this.transparent);
        }
    }

    protected int Gx(int i) {
        int i2;
        int i3 = 0;
        if (this.lLR == null) {
            return -1;
        }
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = (i >> 0) & 255;
        int i7 = 16777216;
        int length = this.lLR.length;
        int i8 = 0;
        while (i3 < length) {
            int i9 = i3 + 1;
            int i10 = i4 - (this.lLR[i3] & 255);
            int i11 = i9 + 1;
            int i12 = i5 - (this.lLR[i9] & 255);
            int i13 = i6 - (this.lLR[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (!this.lLS[i15] || i14 >= i7) {
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

    protected void dqi() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.lLO = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.lLO[i3] = (byte) ((i2 >> 0) & 255);
            this.lLO[i4] = (byte) ((i2 >> 8) & 255);
            this.lLO[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dqj() throws IOException {
        int i;
        int i2;
        this.lLN.write(33);
        this.lLN.write(249);
        this.lLN.write(4);
        if (this.transparent == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.lLU >= 0) {
            i2 = this.lLU & 7;
        }
        this.lLN.write((i2 << 2) | 0 | 0 | i);
        writeShort(this.delay);
        this.lLN.write(this.lLL);
        this.lLN.write(0);
    }

    protected void dqk() throws IOException {
        this.lLN.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.lLW) {
            this.lLN.write(0);
        } else {
            this.lLN.write(this.lLT | 128);
        }
    }

    protected void dql() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.lLN.write(this.lLT | 240);
        this.lLN.write(0);
        this.lLN.write(0);
    }

    protected void dqm() throws IOException {
        this.lLN.write(33);
        this.lLN.write(255);
        this.lLN.write(11);
        writeString("NETSCAPE2.0");
        this.lLN.write(3);
        this.lLN.write(1);
        writeShort(this.lLM);
        this.lLN.write(0);
    }

    protected void dqn() throws IOException {
        this.lLN.write(this.lLR, 0, this.lLR.length);
        int length = 768 - this.lLR.length;
        for (int i = 0; i < length; i++) {
            this.lLN.write(0);
        }
    }

    protected void dqo() throws IOException {
        new b(this.width, this.height, this.lLP, this.lLQ).encode(this.lLN);
    }

    protected void writeShort(int i) throws IOException {
        this.lLN.write(i & 255);
        this.lLN.write((i >> 8) & 255);
    }

    protected void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.lLN.write((byte) str.charAt(i));
        }
    }
}
