package com.baidu.ueg.lib;

import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class b {
    protected final byte ffq = 61;
    private final int ffr;
    private final int ffs;
    private final int fft;
    protected final int oy;

    abstract void a(byte[] bArr, int i, int i2, a aVar);

    abstract void b(byte[] bArr, int i, int i2, a aVar);

    protected abstract boolean b(byte b);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        byte[] buffer;
        boolean eof;
        int ffu;
        long ffv;
        int ffw;
        int ffx;
        int ffy;
        int pos;

        a() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.ffx), Boolean.valueOf(this.eof), Integer.valueOf(this.ffu), Long.valueOf(this.ffv), Integer.valueOf(this.ffy), Integer.valueOf(this.pos), Integer.valueOf(this.ffw));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i, int i2, int i3, int i4) {
        this.ffr = i;
        this.ffs = i2;
        this.oy = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.fft = i4;
    }

    int a(a aVar) {
        if (aVar.buffer != null) {
            return aVar.pos - aVar.ffw;
        }
        return 0;
    }

    protected int bek() {
        return 8192;
    }

    private byte[] b(a aVar) {
        if (aVar.buffer == null) {
            aVar.buffer = new byte[bek()];
            aVar.pos = 0;
            aVar.ffw = 0;
        } else {
            byte[] bArr = new byte[aVar.buffer.length * 2];
            System.arraycopy(aVar.buffer, 0, bArr, 0, aVar.buffer.length);
            aVar.buffer = bArr;
        }
        return aVar.buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(int i, a aVar) {
        return (aVar.buffer == null || aVar.buffer.length < aVar.pos + i) ? b(aVar) : aVar.buffer;
    }

    int c(byte[] bArr, int i, int i2, a aVar) {
        if (aVar.buffer == null) {
            return aVar.eof ? -1 : 0;
        }
        int min = Math.min(a(aVar), i2);
        System.arraycopy(aVar.buffer, aVar.ffw, bArr, i, min);
        aVar.ffw += min;
        if (aVar.ffw >= aVar.pos) {
            aVar.buffer = null;
            return min;
        }
        return min;
    }

    public byte[] decode(String str) {
        return decode(d.pv(str));
    }

    public byte[] decode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            a aVar = new a();
            b(bArr, 0, bArr.length, aVar);
            b(bArr, 0, -1, aVar);
            byte[] bArr2 = new byte[aVar.pos];
            c(bArr2, 0, bArr2.length, aVar);
            return bArr2;
        }
        return bArr;
    }

    public byte[] encode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            a aVar = new a();
            a(bArr, 0, bArr.length, aVar);
            a(bArr, 0, -1, aVar);
            byte[] bArr2 = new byte[aVar.pos - aVar.ffw];
            c(bArr2, 0, bArr2.length, aVar);
            return bArr2;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || b(b)) {
                return true;
            }
        }
        return false;
    }

    public long G(byte[] bArr) {
        long length = (((bArr.length + this.ffr) - 1) / this.ffr) * this.ffs;
        if (this.oy > 0) {
            return length + ((((this.oy + length) - 1) / this.oy) * this.fft);
        }
        return length;
    }
}
