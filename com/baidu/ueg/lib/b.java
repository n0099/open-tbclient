package com.baidu.ueg.lib;
/* loaded from: classes.dex */
public abstract class b {
    protected final byte cyX = 61;
    private final int cyY;
    private final int cyZ;
    private final int cza;
    protected final int yb;

    abstract void a(byte[] bArr, int i, int i2, c cVar);

    abstract void b(byte[] bArr, int i, int i2, c cVar);

    protected abstract boolean b(byte b);

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i, int i2, int i3, int i4) {
        this.cyY = i;
        this.cyZ = i2;
        this.yb = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.cza = i4;
    }

    int a(c cVar) {
        if (cVar.buffer != null) {
            return cVar.pos - cVar.czd;
        }
        return 0;
    }

    protected int arv() {
        return 8192;
    }

    private byte[] b(c cVar) {
        if (cVar.buffer == null) {
            cVar.buffer = new byte[arv()];
            cVar.pos = 0;
            cVar.czd = 0;
        } else {
            byte[] bArr = new byte[cVar.buffer.length * 2];
            System.arraycopy(cVar.buffer, 0, bArr, 0, cVar.buffer.length);
            cVar.buffer = bArr;
        }
        return cVar.buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(int i, c cVar) {
        return (cVar.buffer == null || cVar.buffer.length < cVar.pos + i) ? b(cVar) : cVar.buffer;
    }

    int c(byte[] bArr, int i, int i2, c cVar) {
        if (cVar.buffer == null) {
            return cVar.eof ? -1 : 0;
        }
        int min = Math.min(a(cVar), i2);
        System.arraycopy(cVar.buffer, cVar.czd, bArr, i, min);
        cVar.czd += min;
        if (cVar.czd >= cVar.pos) {
            cVar.buffer = null;
            return min;
        }
        return min;
    }

    public byte[] decode(String str) {
        return decode(e.jk(str));
    }

    public byte[] decode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            c cVar = new c();
            b(bArr, 0, bArr.length, cVar);
            b(bArr, 0, -1, cVar);
            byte[] bArr2 = new byte[cVar.pos];
            c(bArr2, 0, bArr2.length, cVar);
            return bArr2;
        }
        return bArr;
    }

    public byte[] encode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            c cVar = new c();
            a(bArr, 0, bArr.length, cVar);
            a(bArr, 0, -1, cVar);
            byte[] bArr2 = new byte[cVar.pos - cVar.czd];
            c(bArr2, 0, bArr2.length, cVar);
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
        long length = (((bArr.length + this.cyY) - 1) / this.cyY) * this.cyZ;
        if (this.yb > 0) {
            return length + ((((this.yb + length) - 1) / this.yb) * this.cza);
        }
        return length;
    }
}
