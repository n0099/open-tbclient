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
    protected byte[] msf;
    protected byte[] msh;
    protected int msi;
    protected byte[] msj;
    protected OutputStream out;
    protected int transIndex;
    protected int width;
    protected int x = 0;
    protected int y = 0;
    protected int transparent = -1;
    protected int mse = -1;
    protected int delay = 0;
    protected boolean started = false;
    protected boolean[] msk = new boolean[256];
    protected int msl = 7;
    protected int dispose = -1;
    protected boolean msm = false;
    protected boolean msn = true;
    protected boolean mso = false;
    protected int msp = 10;

    public void GG(int i) {
        if (i >= 0) {
            this.mse = i;
        }
    }

    public boolean G(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.mso) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            dwa();
            dvZ();
            if (this.msn) {
                dwd();
                dwf();
                if (this.mse >= 0) {
                    dwe();
                }
            }
            dwb();
            dwc();
            if (!this.msn) {
                dwf();
            }
            dwg();
            this.msn = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean dvY() {
        boolean z;
        if (this.started) {
            this.started = false;
            try {
                this.out.write(59);
                this.out.flush();
                if (this.msm) {
                    this.out.close();
                }
                z = true;
            } catch (IOException e) {
                z = false;
            }
            this.transIndex = 0;
            this.out = null;
            this.image = null;
            this.msf = null;
            this.msh = null;
            this.msj = null;
            this.msm = false;
            this.msn = true;
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
        this.mso = true;
    }

    public boolean b(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.msm = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.started = z;
        return z;
    }

    protected void dvZ() {
        int length = this.msf.length;
        int i = length / 3;
        this.msh = new byte[i];
        c cVar = new c(this.msf, length, this.msp);
        this.msj = cVar.dwm();
        for (int i2 = 0; i2 < this.msj.length; i2 += 3) {
            byte b = this.msj[i2];
            this.msj[i2] = this.msj[i2 + 2];
            this.msj[i2 + 2] = b;
            this.msk[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int X = cVar.X(this.msf[i3] & 255, this.msf[i5] & 255, this.msf[i6] & 255);
            this.msk[X] = true;
            this.msh[i4] = (byte) X;
        }
        this.msf = null;
        this.msi = 8;
        this.msl = 7;
        if (this.transparent != -1) {
            this.transIndex = GH(this.transparent);
        }
    }

    protected int GH(int i) {
        if (this.msj == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 0) & 255;
        int i5 = 16777216;
        int length = this.msj.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int i9 = i2 - (this.msj[i6] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (this.msj[i8] & 255);
            int i12 = i4 - (this.msj[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (!this.msk[i14] || i13 >= i5) {
                i13 = i5;
                i14 = i7;
            }
            i6 = i10 + 1;
            i5 = i13;
            i7 = i14;
        }
        return i7;
    }

    protected void dwa() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.image, 0.0f, 0.0f, new Paint());
            this.image = createBitmap;
        }
        int[] H = H(this.image);
        this.msf = new byte[H.length * 3];
        for (int i = 0; i < H.length; i++) {
            int i2 = H[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.msf[i3] = (byte) ((i2 >> 0) & 255);
            this.msf[i4] = (byte) ((i2 >> 8) & 255);
            this.msf[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    protected int[] H(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    protected void dwb() throws IOException {
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

    protected void dwc() throws IOException {
        this.out.write(44);
        writeShort(this.x);
        writeShort(this.y);
        writeShort(this.width);
        writeShort(this.height);
        if (this.msn) {
            this.out.write(0);
        } else {
            this.out.write(this.msl | 128);
        }
    }

    protected void dwd() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.msl | 240);
        this.out.write(0);
        this.out.write(0);
    }

    protected void dwe() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.mse);
        this.out.write(0);
    }

    protected void dwf() throws IOException {
        this.out.write(this.msj, 0, this.msj.length);
        int length = 768 - this.msj.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    protected void dwg() throws IOException {
        new b(this.width, this.height, this.msh, this.msi).encode(this.out);
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
