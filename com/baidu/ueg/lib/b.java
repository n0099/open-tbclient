package com.baidu.ueg.lib;

import java.util.Arrays;
/* loaded from: classes6.dex */
public abstract class b {
    protected final int FC;
    protected final byte idP = 61;
    private final int idQ;
    private final int idR;
    private final int idS;

    abstract void a(byte[] bArr, int i, int i2, a aVar);

    abstract void b(byte[] bArr, int i, int i2, a aVar);

    protected abstract boolean b(byte b);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        byte[] buffer;
        boolean eof;
        int idT;
        long idU;
        int idV;
        int idW;
        int modulus;
        int pos;

        a() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.idW), Boolean.valueOf(this.eof), Integer.valueOf(this.idT), Long.valueOf(this.idU), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.idV));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i, int i2, int i3, int i4) {
        this.idQ = i;
        this.idR = i2;
        this.FC = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.idS = i4;
    }

    int a(a aVar) {
        if (aVar.buffer != null) {
            return aVar.pos - aVar.idV;
        }
        return 0;
    }

    protected int bSi() {
        return 8192;
    }

    private byte[] b(a aVar) {
        if (aVar.buffer == null) {
            aVar.buffer = new byte[bSi()];
            aVar.pos = 0;
            aVar.idV = 0;
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
        System.arraycopy(aVar.buffer, aVar.idV, bArr, i, min);
        aVar.idV += min;
        if (aVar.idV >= aVar.pos) {
            aVar.buffer = null;
            return min;
        }
        return min;
    }

    public byte[] decode(String str) {
        return decode(d.yM(str));
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
            byte[] bArr2 = new byte[aVar.pos - aVar.idV];
            c(bArr2, 0, bArr2.length, aVar);
            return bArr2;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean P(byte[] bArr) {
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

    public long Q(byte[] bArr) {
        long length = (((bArr.length + this.idQ) - 1) / this.idQ) * this.idR;
        if (this.FC > 0) {
            return length + ((((this.FC + length) - 1) / this.FC) * this.idS);
        }
        return length;
    }
}
