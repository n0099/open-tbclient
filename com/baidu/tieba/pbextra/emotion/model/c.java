package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.down.manage.DownloadConstants;
/* loaded from: classes2.dex */
class c {
    protected int mhD;
    protected byte[] mhE;
    protected int mhF;
    protected int mhG;
    protected int[] mhI = new int[256];
    protected int[] mhJ = new int[256];
    protected int[] mhK = new int[256];
    protected int[] mhL = new int[32];
    protected int[][] mhH = new int[256];

    public c(byte[] bArr, int i, int i2) {
        this.mhE = bArr;
        this.mhF = i;
        this.mhG = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.mhH[i3] = new int[4];
            int[] iArr = this.mhH[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.mhK[i3] = 256;
            this.mhJ[i3] = 0;
        }
    }

    public byte[] dtK() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[this.mhH[i][3]] = i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = iArr[i3];
            int i5 = i2 + 1;
            bArr[i2] = (byte) this.mhH[i4][0];
            int i6 = i5 + 1;
            bArr[i5] = (byte) this.mhH[i4][1];
            i2 = i6 + 1;
            bArr[i6] = (byte) this.mhH[i4][2];
        }
        return bArr;
    }

    public void dtL() {
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < 256) {
            int[] iArr = this.mhH[i4];
            int i5 = iArr[1];
            int i6 = i4;
            for (int i7 = i4 + 1; i7 < 256; i7++) {
                int[] iArr2 = this.mhH[i7];
                if (iArr2[1] < i5) {
                    i5 = iArr2[1];
                    i6 = i7;
                }
            }
            int[] iArr3 = this.mhH[i6];
            if (i4 != i6) {
                int i8 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i8;
                int i9 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i9;
                int i10 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i10;
                int i11 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i11;
            }
            if (i5 != i3) {
                this.mhI[i3] = (i2 + i4) >> 1;
                for (int i12 = i3 + 1; i12 < i5; i12++) {
                    this.mhI[i12] = i4;
                }
                i = i4;
            } else {
                i = i2;
                i5 = i3;
            }
            i4++;
            i2 = i;
            i3 = i5;
        }
        this.mhI[i3] = (i2 + 255) >> 1;
        for (int i13 = i3 + 1; i13 < 256; i13++) {
            this.mhI[i13] = 255;
        }
    }

    public void dtM() {
        int i;
        if (this.mhF < 1509) {
            this.mhG = 1;
        }
        this.mhD = ((this.mhG - 1) / 3) + 30;
        byte[] bArr = this.mhE;
        int i2 = this.mhF;
        int i3 = this.mhF / (this.mhG * 3);
        int i4 = i3 / 100;
        for (int i5 = 0; i5 < 32; i5++) {
            this.mhL[i5] = (((1024 - (i5 * i5)) * 256) / 1024) * 1024;
        }
        if (this.mhF < 1509) {
            i = 3;
        } else if (this.mhF % DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR != 0) {
            i = 1497;
        } else if (this.mhF % 491 != 0) {
            i = 1473;
        } else if (this.mhF % 487 != 0) {
            i = 1461;
        } else {
            i = 1509;
        }
        int i6 = 0;
        int i7 = 1024;
        int i8 = 32;
        int i9 = 2048;
        int i10 = 0;
        while (i10 < i3) {
            int i11 = (bArr[i6 + 0] & 255) << 4;
            int i12 = (bArr[i6 + 1] & 255) << 4;
            int i13 = (bArr[i6 + 2] & 255) << 4;
            int aa = aa(i11, i12, i13);
            h(i7, aa, i11, i12, i13);
            if (i8 != 0) {
                g(i8, aa, i11, i12, i13);
            }
            int i14 = i6 + i;
            int i15 = i14 >= i2 ? i14 - this.mhF : i14;
            int i16 = i10 + 1;
            int i17 = i4 == 0 ? 1 : i4;
            if (i16 % i17 == 0) {
                int i18 = i7 - (i7 / this.mhD);
                int i19 = i9 - (i9 / 30);
                int i20 = i19 >> 6;
                int i21 = i20 <= 1 ? 0 : i20;
                for (int i22 = 0; i22 < i21; i22++) {
                    this.mhL[i22] = ((((i21 * i21) - (i22 * i22)) * 256) / (i21 * i21)) * i18;
                }
                i6 = i15;
                i4 = i17;
                i7 = i18;
                i8 = i21;
                i9 = i19;
                i10 = i16;
            } else {
                i6 = i15;
                i4 = i17;
                i10 = i16;
            }
        }
    }

    public int Z(int i, int i2, int i3) {
        int i4;
        int i5 = 1000;
        int i6 = this.mhI[i2];
        int i7 = -1;
        int i8 = i6 - 1;
        while (true) {
            int i9 = i6;
            if (i9 < 256 || i8 >= 0) {
                if (i9 < 256) {
                    int[] iArr = this.mhH[i9];
                    int i10 = iArr[1] - i2;
                    if (i10 >= i5) {
                        i4 = i7;
                        i6 = 256;
                    } else {
                        i6 = i9 + 1;
                        if (i10 < 0) {
                            i10 = -i10;
                        }
                        int i11 = iArr[0] - i;
                        if (i11 < 0) {
                            i11 = -i11;
                        }
                        int i12 = i11 + i10;
                        if (i12 < i5) {
                            int i13 = iArr[2] - i3;
                            if (i13 < 0) {
                                i13 = -i13;
                            }
                            int i14 = i12 + i13;
                            if (i14 < i5) {
                                i4 = iArr[3];
                                i5 = i14;
                            }
                        }
                        i4 = i7;
                    }
                } else {
                    i4 = i7;
                    i6 = i9;
                }
                if (i8 >= 0) {
                    int[] iArr2 = this.mhH[i8];
                    int i15 = i2 - iArr2[1];
                    if (i15 >= i5) {
                        i7 = i4;
                        i8 = -1;
                    } else {
                        i8--;
                        if (i15 < 0) {
                            i15 = -i15;
                        }
                        int i16 = iArr2[0] - i;
                        if (i16 < 0) {
                            i16 = -i16;
                        }
                        int i17 = i16 + i15;
                        if (i17 < i5) {
                            int i18 = iArr2[2] - i3;
                            if (i18 < 0) {
                                i18 = -i18;
                            }
                            int i19 = i18 + i17;
                            if (i19 < i5) {
                                i7 = iArr2[3];
                                i5 = i19;
                            }
                        }
                    }
                }
                i7 = i4;
            } else {
                return i7;
            }
        }
    }

    public byte[] dtN() {
        dtM();
        dtO();
        dtL();
        return dtK();
    }

    public void dtO() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.mhH[i];
            iArr[0] = iArr[0] >> 4;
            int[] iArr2 = this.mhH[i];
            iArr2[1] = iArr2[1] >> 4;
            int[] iArr3 = this.mhH[i];
            iArr3[2] = iArr3[2] >> 4;
            this.mhH[i][3] = i;
        }
    }

    protected void g(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i2 - i;
        int i8 = i7 < -1 ? -1 : i7;
        int i9 = i2 + i;
        if (i9 > 256) {
            i9 = 256;
        }
        int i10 = i2 + 1;
        int i11 = 1;
        int i12 = i2 - 1;
        while (true) {
            if (i10 < i9 || i12 > i8) {
                int i13 = i11 + 1;
                int i14 = this.mhL[i11];
                if (i10 < i9) {
                    i6 = i10 + 1;
                    int[] iArr = this.mhH[i10];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i3) * i14) / 262144);
                        iArr[1] = iArr[1] - (((iArr[1] - i4) * i14) / 262144);
                        iArr[2] = iArr[2] - (((iArr[2] - i5) * i14) / 262144);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                } else {
                    i6 = i10;
                }
                if (i12 > i8) {
                    int i15 = i12 - 1;
                    int[] iArr2 = this.mhH[i12];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i14) / 262144);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i14) / 262144);
                        iArr2[2] = iArr2[2] - ((i14 * (iArr2[2] - i5)) / 262144);
                        i11 = i13;
                        i12 = i15;
                        i10 = i6;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        i11 = i13;
                        i12 = i15;
                        i10 = i6;
                    }
                } else {
                    i11 = i13;
                    i10 = i6;
                }
            } else {
                return;
            }
        }
    }

    protected void h(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.mhH[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / 1024);
    }

    protected int aa(int i, int i2, int i3) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        while (i9 < 256) {
            int[] iArr = this.mhH[i9];
            int i10 = iArr[0] - i;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = iArr[1] - i2;
            if (i11 < 0) {
                i11 = -i11;
            }
            int i12 = i11 + i10;
            int i13 = iArr[2] - i3;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i12 + i13;
            if (i14 < i6) {
                i4 = i14;
                i8 = i9;
            } else {
                i4 = i6;
            }
            int i15 = i14 - (this.mhJ[i9] >> 12);
            if (i15 < i5) {
                i7 = i9;
            } else {
                i15 = i5;
            }
            int i16 = this.mhK[i9] >> 10;
            int[] iArr2 = this.mhK;
            iArr2[i9] = iArr2[i9] - i16;
            int[] iArr3 = this.mhJ;
            iArr3[i9] = (i16 << 10) + iArr3[i9];
            i9++;
            i5 = i15;
            i6 = i4;
        }
        int[] iArr4 = this.mhK;
        iArr4[i8] = iArr4[i8] + 64;
        int[] iArr5 = this.mhJ;
        iArr5[i8] = iArr5[i8] - 65536;
        return i7;
    }
}
