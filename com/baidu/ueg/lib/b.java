package com.baidu.ueg.lib;

import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class b {
    protected final byte gcH = 61;
    private final int gcI;
    private final int gcJ;
    private final int gcK;
    protected final int yl;

    abstract void a(byte[] bArr, int i, int i2, a aVar);

    abstract void b(byte[] bArr, int i, int i2, a aVar);

    protected abstract boolean b(byte b);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        byte[] buffer;
        boolean eof;
        int gcL;
        long gcM;
        int gcN;
        int gcO;
        int gcP;
        int pos;

        a() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.gcO), Boolean.valueOf(this.eof), Integer.valueOf(this.gcL), Long.valueOf(this.gcM), Integer.valueOf(this.gcP), Integer.valueOf(this.pos), Integer.valueOf(this.gcN));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i, int i2, int i3, int i4) {
        this.gcI = i;
        this.gcJ = i2;
        this.yl = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.gcK = i4;
    }

    int a(a aVar) {
        if (aVar.buffer != null) {
            return aVar.pos - aVar.gcN;
        }
        return 0;
    }

    protected int bqI() {
        return 8192;
    }

    private byte[] b(a aVar) {
        if (aVar.buffer == null) {
            aVar.buffer = new byte[bqI()];
            aVar.pos = 0;
            aVar.gcN = 0;
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
        System.arraycopy(aVar.buffer, aVar.gcN, bArr, i, min);
        aVar.gcN += min;
        if (aVar.gcN >= aVar.pos) {
            aVar.buffer = null;
            return min;
        }
        return min;
    }

    public byte[] decode(String str) {
        return decode(d.rD(str));
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
            byte[] bArr2 = new byte[aVar.pos - aVar.gcN];
            c(bArr2, 0, bArr2.length, aVar);
            return bArr2;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean E(byte[] bArr) {
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

    public long F(byte[] bArr) {
        long length = (((bArr.length + this.gcI) - 1) / this.gcI) * this.gcJ;
        if (this.yl > 0) {
            return length + ((((this.yl + length) - 1) / this.yl) * this.gcK);
        }
        return length;
    }
}
