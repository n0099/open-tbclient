package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class SHA1Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 20;
    private static final int Y1 = 1518500249;
    private static final int Y2 = 1859775393;
    private static final int Y3 = -1894007588;
    private static final int Y4 = -899497514;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int[] X;
    private int xOff;

    public SHA1Digest() {
        this.X = new int[80];
        reset();
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.X = new int[80];
        this.H1 = sHA1Digest.H1;
        this.H2 = sHA1Digest.H2;
        this.H3 = sHA1Digest.H3;
        this.H4 = sHA1Digest.H4;
        this.H5 = sHA1Digest.H5;
        System.arraycopy(sHA1Digest.X, 0, this.X, 0, sHA1Digest.X.length);
        this.xOff = sHA1Digest.xOff;
    }

    @Override // com.baidu.zeus.bouncycastle.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // com.baidu.zeus.bouncycastle.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // com.baidu.zeus.bouncycastle.GeneralDigest
    protected void processWord(byte[] bArr, int i) {
        int[] iArr = this.X;
        int i2 = this.xOff;
        this.xOff = i2 + 1;
        iArr[i2] = ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
        if (this.xOff == 16) {
            processBlock();
        }
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i;
    }

    @Override // com.baidu.zeus.bouncycastle.GeneralDigest
    protected void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        this.X[14] = (int) (j >>> 32);
        this.X[15] = (int) ((-1) & j);
    }

    @Override // com.baidu.zeus.bouncycastle.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.H1, bArr, i);
        unpackWord(this.H2, bArr, i + 4);
        unpackWord(this.H3, bArr, i + 8);
        unpackWord(this.H4, bArr, i + 12);
        unpackWord(this.H5, bArr, i + 16);
        reset();
        return 20;
    }

    @Override // com.baidu.zeus.bouncycastle.GeneralDigest, com.baidu.zeus.bouncycastle.Digest
    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        for (int i = 0; i != this.X.length; i++) {
            this.X[i] = 0;
        }
    }

    private int f(int i, int i2, int i3) {
        return (i & i2) | ((i ^ (-1)) & i3);
    }

    private int h(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int g(int i, int i2, int i3) {
        return (i & i2) | (i & i3) | (i2 & i3);
    }

    @Override // com.baidu.zeus.bouncycastle.GeneralDigest
    protected void processBlock() {
        for (int i = 16; i < 80; i++) {
            int i2 = ((this.X[i - 3] ^ this.X[i - 8]) ^ this.X[i - 14]) ^ this.X[i - 16];
            this.X[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.H1;
        int i4 = this.H2;
        int i5 = this.H3;
        int i6 = this.H4;
        int i7 = this.H5;
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = i8 + 1;
            int f = this.X[i8] + ((i3 << 5) | (i3 >>> 27)) + f(i4, i5, i6) + Y1 + i7;
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int f2 = i6 + ((f << 5) | (f >>> 27)) + f(i3, i11, i5) + this.X[i10] + Y1;
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int f3 = i5 + ((f2 << 5) | (f2 >>> 27)) + f(f, i13, i11) + this.X[i12] + Y1;
            i7 = (f << 30) | (f >>> 2);
            int i15 = i14 + 1;
            i4 = i11 + ((f3 << 5) | (f3 >>> 27)) + f(f2, i7, i13) + this.X[i14] + Y1;
            i6 = (f2 >>> 2) | (f2 << 30);
            i8 = i15 + 1;
            i3 = i13 + f(f3, i6, i7) + ((i4 << 5) | (i4 >>> 27)) + this.X[i15] + Y1;
            i5 = (f3 >>> 2) | (f3 << 30);
        }
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = i8 + 1;
            int h = this.X[i8] + ((i3 << 5) | (i3 >>> 27)) + h(i4, i5, i6) + Y2 + i7;
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int h2 = i6 + ((h << 5) | (h >>> 27)) + h(i3, i18, i5) + this.X[i17] + Y2;
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int h3 = i5 + ((h2 << 5) | (h2 >>> 27)) + h(h, i20, i18) + this.X[i19] + Y2;
            i7 = (h << 30) | (h >>> 2);
            int i22 = i21 + 1;
            i4 = i18 + ((h3 << 5) | (h3 >>> 27)) + h(h2, i7, i20) + this.X[i21] + Y2;
            i6 = (h2 >>> 2) | (h2 << 30);
            i8 = i22 + 1;
            i3 = i20 + h(h3, i6, i7) + ((i4 << 5) | (i4 >>> 27)) + this.X[i22] + Y2;
            i5 = (h3 >>> 2) | (h3 << 30);
        }
        for (int i23 = 0; i23 < 4; i23++) {
            int i24 = i8 + 1;
            int g = this.X[i8] + ((i3 << 5) | (i3 >>> 27)) + g(i4, i5, i6) + Y3 + i7;
            int i25 = (i4 >>> 2) | (i4 << 30);
            int i26 = i24 + 1;
            int g2 = i6 + ((g << 5) | (g >>> 27)) + g(i3, i25, i5) + this.X[i24] + Y3;
            int i27 = (i3 >>> 2) | (i3 << 30);
            int i28 = i26 + 1;
            int g3 = i5 + ((g2 << 5) | (g2 >>> 27)) + g(g, i27, i25) + this.X[i26] + Y3;
            i7 = (g << 30) | (g >>> 2);
            int i29 = i28 + 1;
            i4 = i25 + ((g3 << 5) | (g3 >>> 27)) + g(g2, i7, i27) + this.X[i28] + Y3;
            i6 = (g2 >>> 2) | (g2 << 30);
            i8 = i29 + 1;
            i3 = i27 + g(g3, i6, i7) + ((i4 << 5) | (i4 >>> 27)) + this.X[i29] + Y3;
            i5 = (g3 >>> 2) | (g3 << 30);
        }
        for (int i30 = 0; i30 <= 3; i30++) {
            int i31 = i8 + 1;
            int h4 = this.X[i8] + ((i3 << 5) | (i3 >>> 27)) + h(i4, i5, i6) + Y4 + i7;
            int i32 = (i4 >>> 2) | (i4 << 30);
            int i33 = i31 + 1;
            int h5 = i6 + ((h4 << 5) | (h4 >>> 27)) + h(i3, i32, i5) + this.X[i31] + Y4;
            int i34 = (i3 >>> 2) | (i3 << 30);
            int i35 = i33 + 1;
            int h6 = i5 + ((h5 << 5) | (h5 >>> 27)) + h(h4, i34, i32) + this.X[i33] + Y4;
            i7 = (h4 << 30) | (h4 >>> 2);
            int i36 = i35 + 1;
            i4 = i32 + ((h6 << 5) | (h6 >>> 27)) + h(h5, i7, i34) + this.X[i35] + Y4;
            i6 = (h5 >>> 2) | (h5 << 30);
            i8 = i36 + 1;
            i3 = i34 + h(h6, i6, i7) + ((i4 << 5) | (i4 >>> 27)) + this.X[i36] + Y4;
            i5 = (h6 >>> 2) | (h6 << 30);
        }
        this.H1 += i3;
        this.H2 += i4;
        this.H3 += i5;
        this.H4 += i6;
        this.H5 += i7;
        this.xOff = 0;
        for (int i37 = 0; i37 < 16; i37++) {
            this.X[i37] = 0;
        }
    }
}
