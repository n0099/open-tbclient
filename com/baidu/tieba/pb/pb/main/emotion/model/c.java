package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
/* loaded from: classes.dex */
class c {
    protected int eRh;
    protected byte[] eRi;
    protected int eRj;
    protected int eRk;
    protected int[] eRm = new int[256];
    protected int[] eRn = new int[256];
    protected int[] eRo = new int[256];
    protected int[] eRp = new int[32];
    protected int[][] eRl = new int[256];

    public c(byte[] bArr, int i, int i2) {
        this.eRi = bArr;
        this.eRj = i;
        this.eRk = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.eRl[i3] = new int[4];
            int[] iArr = this.eRl[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.eRo[i3] = 256;
            this.eRn[i3] = 0;
        }
    }

    public byte[] aUd() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[this.eRl[i][3]] = i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = iArr[i3];
            int i5 = i2 + 1;
            bArr[i2] = (byte) this.eRl[i4][0];
            int i6 = i5 + 1;
            bArr[i5] = (byte) this.eRl[i4][1];
            i2 = i6 + 1;
            bArr[i6] = (byte) this.eRl[i4][2];
        }
        return bArr;
    }

    public void aUe() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i5 < 256) {
            int[] iArr = this.eRl[i5];
            int i6 = iArr[1];
            int i7 = i5;
            for (int i8 = i5 + 1; i8 < 256; i8++) {
                int[] iArr2 = this.eRl[i8];
                if (iArr2[1] < i6) {
                    i6 = iArr2[1];
                    i7 = i8;
                }
            }
            int[] iArr3 = this.eRl[i7];
            if (i5 != i7) {
                int i9 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i9;
                int i10 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i10;
                int i11 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i11;
                int i12 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i12;
            }
            if (i6 != i4) {
                this.eRm[i4] = (i3 + i5) >> 1;
                for (int i13 = i4 + 1; i13 < i6; i13++) {
                    this.eRm[i13] = i5;
                }
                i2 = i6;
                i = i5;
            } else {
                i = i3;
                i2 = i4;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        this.eRm[i4] = (i3 + MotionEventCompat.ACTION_MASK) >> 1;
        for (int i14 = i4 + 1; i14 < 256; i14++) {
            this.eRm[i14] = 255;
        }
    }

    public void aUf() {
        int i;
        if (this.eRj < 1509) {
            this.eRk = 1;
        }
        this.eRh = ((this.eRk - 1) / 3) + 30;
        byte[] bArr = this.eRi;
        int i2 = this.eRj;
        int i3 = this.eRj / (this.eRk * 3);
        int i4 = i3 / 100;
        for (int i5 = 0; i5 < 32; i5++) {
            this.eRp[i5] = (((1024 - (i5 * i5)) * 256) / 1024) * 1024;
        }
        if (this.eRj < 1509) {
            i = 3;
        } else if (this.eRj % 499 != 0) {
            i = 1497;
        } else if (this.eRj % 491 != 0) {
            i = 1473;
        } else if (this.eRj % 487 != 0) {
            i = 1461;
        } else {
            i = 1509;
        }
        int i6 = 0;
        int i7 = 32;
        int i8 = 2048;
        int i9 = 0;
        int i10 = 1024;
        while (i9 < i3) {
            int i11 = (bArr[i6 + 0] & 255) << 4;
            int i12 = (bArr[i6 + 1] & 255) << 4;
            int i13 = (bArr[i6 + 2] & 255) << 4;
            int M = M(i11, i12, i13);
            h(i10, M, i11, i12, i13);
            if (i7 != 0) {
                g(i7, M, i11, i12, i13);
            }
            int i14 = i6 + i;
            int i15 = i14 >= i2 ? i14 - this.eRj : i14;
            int i16 = i9 + 1;
            int i17 = i4 == 0 ? 1 : i4;
            if (i16 % i17 == 0) {
                int i18 = i10 - (i10 / this.eRh);
                int i19 = i8 - (i8 / 30);
                int i20 = i19 >> 6;
                if (i20 <= 1) {
                    i20 = 0;
                }
                for (int i21 = 0; i21 < i20; i21++) {
                    this.eRp[i21] = ((((i20 * i20) - (i21 * i21)) * 256) / (i20 * i20)) * i18;
                }
                i6 = i15;
                i4 = i17;
                i7 = i20;
                i8 = i19;
                i9 = i16;
                i10 = i18;
            } else {
                i6 = i15;
                i4 = i17;
                i9 = i16;
            }
        }
    }

    public int L(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = this.eRm[i2];
        int i8 = -1;
        int i9 = 1000;
        int i10 = i7 - 1;
        int i11 = i7;
        while (true) {
            if (i11 < 256 || i10 >= 0) {
                if (i11 < 256) {
                    int[] iArr = this.eRl[i11];
                    int i12 = iArr[1] - i2;
                    if (i12 >= i9) {
                        i5 = i9;
                        i4 = 256;
                        i6 = i8;
                    } else {
                        i4 = i11 + 1;
                        if (i12 < 0) {
                            i12 = -i12;
                        }
                        int i13 = iArr[0] - i;
                        if (i13 < 0) {
                            i13 = -i13;
                        }
                        int i14 = i13 + i12;
                        if (i14 < i9) {
                            int i15 = iArr[2] - i3;
                            if (i15 < 0) {
                                i15 = -i15;
                            }
                            i5 = i14 + i15;
                            if (i5 < i9) {
                                i6 = iArr[3];
                            }
                        }
                        i5 = i9;
                        i6 = i8;
                    }
                } else {
                    i4 = i11;
                    i5 = i9;
                    i6 = i8;
                }
                if (i10 >= 0) {
                    int[] iArr2 = this.eRl[i10];
                    int i16 = i2 - iArr2[1];
                    if (i16 >= i5) {
                        i8 = i6;
                        i10 = -1;
                        i9 = i5;
                        i11 = i4;
                    } else {
                        i10--;
                        if (i16 < 0) {
                            i16 = -i16;
                        }
                        int i17 = iArr2[0] - i;
                        if (i17 < 0) {
                            i17 = -i17;
                        }
                        int i18 = i17 + i16;
                        if (i18 < i5) {
                            int i19 = iArr2[2] - i3;
                            if (i19 < 0) {
                                i19 = -i19;
                            }
                            int i20 = i19 + i18;
                            if (i20 < i5) {
                                i8 = iArr2[3];
                                i11 = i4;
                                i9 = i20;
                            }
                        }
                    }
                }
                i8 = i6;
                i9 = i5;
                i11 = i4;
            } else {
                return i8;
            }
        }
    }

    public byte[] aUg() {
        aUf();
        aUh();
        aUe();
        return aUd();
    }

    public void aUh() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.eRl[i];
            iArr[0] = iArr[0] >> 4;
            int[] iArr2 = this.eRl[i];
            iArr2[1] = iArr2[1] >> 4;
            int[] iArr3 = this.eRl[i];
            iArr3[2] = iArr3[2] >> 4;
            this.eRl[i][3] = i;
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
        int i10 = 1;
        int i11 = i2 - 1;
        int i12 = i2 + 1;
        while (true) {
            if (i12 < i9 || i11 > i8) {
                int i13 = i10 + 1;
                int i14 = this.eRp[i10];
                if (i12 < i9) {
                    i6 = i12 + 1;
                    int[] iArr = this.eRl[i12];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i3) * i14) / AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
                        iArr[1] = iArr[1] - (((iArr[1] - i4) * i14) / AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
                        iArr[2] = iArr[2] - (((iArr[2] - i5) * i14) / AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
                    } catch (Exception e) {
                    }
                } else {
                    i6 = i12;
                }
                if (i11 > i8) {
                    int i15 = i11 - 1;
                    int[] iArr2 = this.eRl[i11];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i14) / AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i14) / AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
                        iArr2[2] = iArr2[2] - ((i14 * (iArr2[2] - i5)) / AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
                        i11 = i15;
                        i12 = i6;
                        i10 = i13;
                    } catch (Exception e2) {
                        i11 = i15;
                        i12 = i6;
                        i10 = i13;
                    }
                } else {
                    i12 = i6;
                    i10 = i13;
                }
            } else {
                return;
            }
        }
    }

    protected void h(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.eRl[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / 1024);
    }

    protected int M(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = Integer.MAX_VALUE;
        int i8 = -1;
        int i9 = Integer.MAX_VALUE;
        int i10 = -1;
        int i11 = 0;
        while (i11 < 256) {
            int[] iArr = this.eRl[i11];
            int i12 = iArr[0] - i;
            if (i12 < 0) {
                i12 = -i12;
            }
            int i13 = iArr[1] - i2;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i13 + i12;
            int i15 = iArr[2] - i3;
            if (i15 < 0) {
                i15 = -i15;
            }
            int i16 = i14 + i15;
            if (i16 < i9) {
                i4 = i16;
                i5 = i11;
            } else {
                i4 = i9;
                i5 = i10;
            }
            int i17 = i16 - (this.eRn[i11] >> 12);
            if (i17 < i7) {
                i6 = i11;
            } else {
                i17 = i7;
                i6 = i8;
            }
            int i18 = this.eRo[i11] >> 10;
            int[] iArr2 = this.eRo;
            iArr2[i11] = iArr2[i11] - i18;
            int[] iArr3 = this.eRn;
            iArr3[i11] = (i18 << 10) + iArr3[i11];
            i11++;
            i7 = i17;
            i8 = i6;
            i10 = i5;
            i9 = i4;
        }
        int[] iArr4 = this.eRo;
        iArr4[i10] = iArr4[i10] + 64;
        int[] iArr5 = this.eRn;
        iArr5[i10] = iArr5[i10] - 65536;
        return i8;
    }
}
