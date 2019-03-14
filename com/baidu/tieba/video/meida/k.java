package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public class k {
    public void a(int i, int i2, double[] dArr, int[] iArr, double[] dArr2) {
        int i3 = iArr[0];
        if (i > (i3 << 2)) {
            i3 = i >> 2;
            a(i3, iArr, dArr2);
        }
        int i4 = iArr[1];
        if (i > (i4 << 2)) {
            i4 = i >> 2;
            a(i4, iArr, dArr2, i3);
        }
        int i5 = i4;
        if (i2 >= 0) {
            if (i > 4) {
                a(i, dArr, iArr, 2, i3, dArr2);
                c(i, dArr, i5, dArr2, i3);
            } else if (i == 4) {
                a(i, dArr, iArr, 2, i3, dArr2);
            }
            dArr[0] = dArr[0] + dArr[1];
            dArr[1] = dArr[0] - dArr[1];
            return;
        }
        dArr[1] = 0.5d * (dArr[0] - dArr[1]);
        dArr[0] = dArr[0] - dArr[1];
        if (i > 4) {
            d(i, dArr, i5, dArr2, i3);
            b(i, dArr, iArr, 2, i3, dArr2);
        } else if (i == 4) {
            b(i, dArr, iArr, 2, i3, dArr2);
        }
    }

    private void a(int i, int[] iArr, double[] dArr) {
        iArr[0] = i;
        iArr[1] = 1;
        if (i > 2) {
            int i2 = i >> 1;
            double d = 0.7853981633974483d / i2;
            double cos = Math.cos(i2 * d);
            dArr[0] = 1.0d;
            dArr[1] = cos;
            if (i2 >= 4) {
                dArr[2] = 0.5d / Math.cos(2.0d * d);
                dArr[3] = 0.5d / Math.cos(6.0d * d);
            }
            for (int i3 = 4; i3 < i2; i3 += 4) {
                dArr[i3] = Math.cos(i3 * d);
                dArr[i3 + 1] = Math.sin(i3 * d);
                dArr[i3 + 2] = Math.cos(3.0d * d * i3);
                dArr[i3 + 3] = Math.sin(3.0d * d * i3);
            }
            int i4 = i2;
            int i5 = 0;
            while (i4 > 2) {
                int i6 = i5 + i4;
                int i7 = i4 >> 1;
                dArr[i6] = 1.0d;
                dArr[i6 + 1] = cos;
                if (i7 >= 4) {
                    double d2 = dArr[i5 + 4];
                    double d3 = dArr[i5 + 6];
                    dArr[i6 + 2] = 0.5d / d2;
                    dArr[i6 + 3] = 0.5d / d3;
                }
                for (int i8 = 4; i8 < i7; i8 += 4) {
                    double d4 = dArr[(i8 * 2) + i5];
                    double d5 = dArr[(i8 * 2) + i5 + 1];
                    double d6 = dArr[(i8 * 2) + i5 + 2];
                    double d7 = dArr[(i8 * 2) + i5 + 3];
                    dArr[i6 + i8] = d4;
                    dArr[i6 + i8 + 1] = d5;
                    dArr[i6 + i8 + 2] = d6;
                    dArr[i6 + i8 + 3] = d7;
                }
                i5 = i6;
                i4 = i7;
            }
        }
    }

    private void a(int i, int[] iArr, double[] dArr, int i2) {
        iArr[1] = i;
        if (i > 1) {
            int i3 = i >> 1;
            double d = 0.7853981633974483d / i3;
            dArr[i2 + 0] = Math.cos(i3 * d);
            dArr[i2 + i3] = dArr[i2 + 0] * 0.5d;
            for (int i4 = 1; i4 < i3; i4++) {
                dArr[i2 + i4] = Math.cos(i4 * d) * 0.5d;
                dArr[(i2 + i) - i4] = Math.sin(i4 * d) * 0.5d;
            }
        }
    }

    private void a(int i, double[] dArr, int[] iArr, int i2, int i3, double[] dArr2) {
        if (i > 32) {
            int i4 = i >> 2;
            a(i, dArr, dArr2, i3 - i4);
            if (i > 512) {
                a(i4, dArr, 0, i3, dArr2);
                b(i4, dArr, i4, i3, dArr2);
                a(i4, dArr, i4 * 2, i3, dArr2);
                a(i4, dArr, i4 * 3, i3, dArr2);
            } else if (i4 > 32) {
                c(i, dArr, 0, i3, dArr2);
            } else {
                e(i, dArr, 0, i3, dArr2);
            }
            a(i, iArr, i2, dArr);
        } else if (i > 8) {
            if (i == 32) {
                a(dArr, 0, dArr2, i3 - 8);
                b(dArr);
                return;
            }
            c(dArr, 0, dArr2, 0);
            d(dArr);
        } else if (i == 8) {
            f(dArr);
        } else if (i == 4) {
            h(dArr);
        }
    }

    private void b(int i, double[] dArr, int[] iArr, int i2, int i3, double[] dArr2) {
        if (i > 32) {
            int i4 = i >> 2;
            b(i, dArr, dArr2, i3 - i4);
            if (i > 512) {
                a(i4, dArr, 0, i3, dArr2);
                b(i4, dArr, i4, i3, dArr2);
                a(i4, dArr, i4 * 2, i3, dArr2);
                a(i4, dArr, i4 * 3, i3, dArr2);
            } else if (i4 > 32) {
                c(i, dArr, 0, i3, dArr2);
            } else {
                e(i, dArr, 0, i3, dArr2);
            }
            b(i, iArr, i2, dArr);
        } else if (i > 8) {
            if (i == 32) {
                a(dArr, 0, dArr2, i3 - 8);
                c(dArr);
                return;
            }
            c(dArr, 0, dArr2, 0);
            e(dArr);
        } else if (i == 8) {
            g(dArr);
        } else if (i == 4) {
            h(dArr);
        }
    }

    private final void a(int i, int[] iArr, int i2, double[] dArr) {
        int i3;
        iArr[i2 + 0] = 0;
        int i4 = 1;
        while (true) {
            i3 = i4;
            if ((i3 << 3) >= i) {
                break;
            }
            i >>= 1;
            for (int i5 = 0; i5 < i3; i5++) {
                iArr[i2 + i3 + i5] = iArr[i2 + i5] + i;
            }
            i4 = i3 << 1;
        }
        int i6 = i3 * 2;
        if ((i3 << 3) == i) {
            for (int i7 = 0; i7 < i3; i7++) {
                for (int i8 = 0; i8 < i7; i8++) {
                    int i9 = (i8 * 2) + iArr[i2 + i7];
                    int i10 = (i7 * 2) + iArr[i2 + i8];
                    double d = dArr[i9];
                    double d2 = dArr[i9 + 1];
                    double d3 = dArr[i10];
                    double d4 = dArr[i10 + 1];
                    dArr[i9] = d3;
                    dArr[i9 + 1] = d4;
                    dArr[i10] = d;
                    dArr[i10 + 1] = d2;
                    int i11 = i9 + i6;
                    int i12 = i10 + (i6 * 2);
                    double d5 = dArr[i11];
                    double d6 = dArr[i11 + 1];
                    double d7 = dArr[i12];
                    double d8 = dArr[i12 + 1];
                    dArr[i11] = d7;
                    dArr[i11 + 1] = d8;
                    dArr[i12] = d5;
                    dArr[i12 + 1] = d6;
                    int i13 = i11 + i6;
                    int i14 = i12 - i6;
                    double d9 = dArr[i13];
                    double d10 = dArr[i13 + 1];
                    double d11 = dArr[i14];
                    double d12 = dArr[i14 + 1];
                    dArr[i13] = d11;
                    dArr[i13 + 1] = d12;
                    dArr[i14] = d9;
                    dArr[i14 + 1] = d10;
                    int i15 = i13 + i6;
                    int i16 = i14 + (i6 * 2);
                    double d13 = dArr[i15];
                    double d14 = dArr[i15 + 1];
                    double d15 = dArr[i16];
                    double d16 = dArr[i16 + 1];
                    dArr[i15] = d15;
                    dArr[i15 + 1] = d16;
                    dArr[i16] = d13;
                    dArr[i16 + 1] = d14;
                }
                int i17 = (i7 * 2) + i6 + iArr[i2 + i7];
                int i18 = i17 + i6;
                double d17 = dArr[i17];
                double d18 = dArr[i17 + 1];
                double d19 = dArr[i18];
                double d20 = dArr[i18 + 1];
                dArr[i17] = d19;
                dArr[i17 + 1] = d20;
                dArr[i18] = d17;
                dArr[i18 + 1] = d18;
            }
            return;
        }
        for (int i19 = 1; i19 < i3; i19++) {
            for (int i20 = 0; i20 < i19; i20++) {
                int i21 = (i20 * 2) + iArr[i2 + i19];
                int i22 = (i19 * 2) + iArr[i2 + i20];
                double d21 = dArr[i21];
                double d22 = dArr[i21 + 1];
                double d23 = dArr[i22];
                double d24 = dArr[i22 + 1];
                dArr[i21] = d23;
                dArr[i21 + 1] = d24;
                dArr[i22] = d21;
                dArr[i22 + 1] = d22;
                int i23 = i21 + i6;
                int i24 = i22 + i6;
                double d25 = dArr[i23];
                double d26 = dArr[i23 + 1];
                double d27 = dArr[i24];
                double d28 = dArr[i24 + 1];
                dArr[i23] = d27;
                dArr[i23 + 1] = d28;
                dArr[i24] = d25;
                dArr[i24 + 1] = d26;
            }
        }
    }

    private final void b(int i, int[] iArr, int i2, double[] dArr) {
        int i3;
        iArr[i2 + 0] = 0;
        int i4 = 1;
        while (true) {
            i3 = i4;
            if ((i3 << 3) >= i) {
                break;
            }
            i >>= 1;
            for (int i5 = 0; i5 < i3; i5++) {
                iArr[i2 + i3 + i5] = iArr[i2 + i5] + i;
            }
            i4 = i3 << 1;
        }
        int i6 = i3 * 2;
        if ((i3 << 3) == i) {
            for (int i7 = 0; i7 < i3; i7++) {
                for (int i8 = 0; i8 < i7; i8++) {
                    int i9 = (i8 * 2) + iArr[i2 + i7];
                    int i10 = (i7 * 2) + iArr[i2 + i8];
                    double d = dArr[i9];
                    dArr[i9] = dArr[i10];
                    dArr[i9 + 1] = -dArr[i10 + 1];
                    dArr[i10] = d;
                    dArr[i10 + 1] = -dArr[i9 + 1];
                    int i11 = i9 + i6;
                    int i12 = i10 + (i6 * 2);
                    double d2 = dArr[i11];
                    dArr[i11] = dArr[i12];
                    dArr[i11 + 1] = -dArr[i12 + 1];
                    dArr[i12] = d2;
                    dArr[i12 + 1] = -dArr[i11 + 1];
                    int i13 = i11 + i6;
                    int i14 = i12 - i6;
                    double d3 = dArr[i13];
                    dArr[i13] = dArr[i14];
                    dArr[i13 + 1] = -dArr[i14 + 1];
                    dArr[i14] = d3;
                    dArr[i14 + 1] = -dArr[i13 + 1];
                    int i15 = i13 + i6;
                    int i16 = i14 + (i6 * 2);
                    double d4 = dArr[i15];
                    dArr[i15] = dArr[i16];
                    dArr[i15 + 1] = -dArr[i16 + 1];
                    dArr[i16] = d4;
                    dArr[i16 + 1] = -dArr[i15 + 1];
                }
                int i17 = (i7 * 2) + iArr[i2 + i7];
                dArr[i17 + 1] = -dArr[i17 + 1];
                int i18 = i17 + i6;
                int i19 = i18 + i6;
                double d5 = dArr[i18];
                dArr[i18] = dArr[i19];
                dArr[i18 + 1] = -dArr[i19 + 1];
                dArr[i19] = d5;
                dArr[i19 + 1] = -dArr[i18 + 1];
                int i20 = i19 + i6;
                dArr[i20 + 1] = -dArr[i20 + 1];
            }
            return;
        }
        dArr[1] = -dArr[1];
        dArr[i6 + 1] = -dArr[i6 + 1];
        for (int i21 = 1; i21 < i3; i21++) {
            for (int i22 = 0; i22 < i21; i22++) {
                int i23 = (i22 * 2) + iArr[i2 + i21];
                int i24 = (i21 * 2) + iArr[i2 + i22];
                double d6 = dArr[i23];
                dArr[i23] = dArr[i24];
                dArr[i23 + 1] = -dArr[i24 + 1];
                dArr[i24] = d6;
                dArr[i24 + 1] = -dArr[i23 + 1];
                int i25 = i23 + i6;
                int i26 = i24 + i6;
                double d7 = dArr[i25];
                dArr[i25] = dArr[i26];
                dArr[i25 + 1] = -dArr[i26 + 1];
                dArr[i26] = d7;
                dArr[i26 + 1] = -dArr[i25 + 1];
            }
            int i27 = (i21 * 2) + iArr[i2 + i21];
            dArr[i27 + 1] = -dArr[i27 + 1];
            dArr[i27 + i6 + 1] = -dArr[i27 + i6 + 1];
        }
    }

    private void b(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[4];
        double d4 = dArr[5];
        double d5 = dArr[6];
        double d6 = dArr[7];
        double d7 = dArr[8];
        double d8 = dArr[9];
        double d9 = dArr[10];
        double d10 = dArr[11];
        double d11 = dArr[14];
        double d12 = dArr[15];
        double d13 = dArr[16];
        double d14 = dArr[17];
        double d15 = dArr[20];
        double d16 = dArr[21];
        double d17 = dArr[22];
        double d18 = dArr[23];
        double d19 = dArr[24];
        double d20 = dArr[25];
        double d21 = dArr[26];
        double d22 = dArr[27];
        double d23 = dArr[28];
        double d24 = dArr[29];
        dArr[2] = d13;
        dArr[3] = d14;
        dArr[4] = d7;
        dArr[5] = d8;
        dArr[6] = d19;
        dArr[7] = d20;
        dArr[8] = d3;
        dArr[9] = d4;
        dArr[10] = d15;
        dArr[11] = d16;
        dArr[14] = d23;
        dArr[15] = d24;
        dArr[16] = d;
        dArr[17] = d2;
        dArr[20] = d9;
        dArr[21] = d10;
        dArr[22] = d21;
        dArr[23] = d22;
        dArr[24] = d5;
        dArr[25] = d6;
        dArr[26] = d17;
        dArr[27] = d18;
        dArr[28] = d11;
        dArr[29] = d12;
    }

    private void c(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[4];
        double d4 = dArr[5];
        double d5 = dArr[6];
        double d6 = dArr[7];
        double d7 = dArr[8];
        double d8 = dArr[9];
        double d9 = dArr[10];
        double d10 = dArr[11];
        double d11 = dArr[12];
        double d12 = dArr[13];
        double d13 = dArr[14];
        double d14 = dArr[15];
        double d15 = dArr[16];
        double d16 = dArr[17];
        double d17 = dArr[18];
        double d18 = dArr[19];
        double d19 = dArr[20];
        double d20 = dArr[21];
        double d21 = dArr[22];
        double d22 = dArr[23];
        double d23 = dArr[24];
        double d24 = dArr[25];
        double d25 = dArr[26];
        double d26 = dArr[27];
        double d27 = dArr[28];
        double d28 = dArr[29];
        double d29 = dArr[30];
        double d30 = dArr[31];
        dArr[2] = d29;
        dArr[3] = d30;
        dArr[4] = d13;
        dArr[5] = d14;
        dArr[6] = d21;
        dArr[7] = d22;
        dArr[8] = d5;
        dArr[9] = d6;
        dArr[10] = d25;
        dArr[11] = d26;
        dArr[12] = d9;
        dArr[13] = d10;
        dArr[14] = d17;
        dArr[15] = d18;
        dArr[16] = d;
        dArr[17] = d2;
        dArr[18] = d27;
        dArr[19] = d28;
        dArr[20] = d11;
        dArr[21] = d12;
        dArr[22] = d19;
        dArr[23] = d20;
        dArr[24] = d3;
        dArr[25] = d4;
        dArr[26] = d23;
        dArr[27] = d24;
        dArr[28] = d7;
        dArr[29] = d8;
        dArr[30] = d15;
        dArr[31] = d16;
    }

    private void d(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[6];
        double d4 = dArr[7];
        double d5 = dArr[8];
        double d6 = dArr[9];
        double d7 = dArr[12];
        double d8 = dArr[13];
        dArr[2] = d5;
        dArr[3] = d6;
        dArr[6] = d7;
        dArr[7] = d8;
        dArr[8] = d;
        dArr[9] = d2;
        dArr[12] = d3;
        dArr[13] = d4;
    }

    private void e(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[4];
        double d4 = dArr[5];
        double d5 = dArr[6];
        double d6 = dArr[7];
        double d7 = dArr[8];
        double d8 = dArr[9];
        double d9 = dArr[10];
        double d10 = dArr[11];
        double d11 = dArr[12];
        double d12 = dArr[13];
        double d13 = dArr[14];
        double d14 = dArr[15];
        dArr[2] = d13;
        dArr[3] = d14;
        dArr[4] = d5;
        dArr[5] = d6;
        dArr[6] = d9;
        dArr[7] = d10;
        dArr[8] = d;
        dArr[9] = d2;
        dArr[10] = d11;
        dArr[11] = d12;
        dArr[12] = d3;
        dArr[13] = d4;
        dArr[14] = d7;
        dArr[15] = d8;
    }

    private void a(int i, double[] dArr, double[] dArr2, int i2) {
        int i3 = i >> 3;
        int i4 = i3 * 2;
        int i5 = i4 + i4;
        int i6 = i5 + i4;
        double d = dArr[0] + dArr[i5];
        double d2 = dArr[1] + dArr[i5 + 1];
        double d3 = dArr[0] - dArr[i5];
        double d4 = dArr[1] - dArr[i5 + 1];
        double d5 = dArr[i4] + dArr[i6];
        double d6 = dArr[i4 + 1] + dArr[i6 + 1];
        double d7 = dArr[i4] - dArr[i6];
        double d8 = dArr[i4 + 1] - dArr[i6 + 1];
        dArr[0] = d + d5;
        dArr[1] = d2 + d6;
        dArr[i4] = d - d5;
        dArr[i4 + 1] = d2 - d6;
        dArr[i5] = d3 - d8;
        dArr[i5 + 1] = d4 + d7;
        dArr[i6] = d3 + d8;
        dArr[i6 + 1] = d4 - d7;
        double d9 = dArr2[i2 + 1];
        double d10 = dArr2[i2 + 2];
        double d11 = dArr2[i2 + 3];
        double d12 = 1.0d;
        double d13 = 0.0d;
        double d14 = 1.0d;
        double d15 = 0.0d;
        int i7 = 0;
        for (int i8 = 2; i8 < i3 - 2; i8 += 4) {
            i7 += 4;
            double d16 = d10 * (d12 + dArr2[i2 + i7]);
            double d17 = d10 * (d13 + dArr2[i2 + i7 + 1]);
            double d18 = d11 * (d14 + dArr2[i2 + i7 + 2]);
            double d19 = d11 * (d15 - dArr2[(i2 + i7) + 3]);
            d12 = dArr2[i2 + i7];
            d13 = dArr2[i2 + i7 + 1];
            d14 = dArr2[i2 + i7 + 2];
            d15 = -dArr2[i2 + i7 + 3];
            int i9 = i8 + i4;
            int i10 = i9 + i4;
            int i11 = i10 + i4;
            double d20 = dArr[i8] + dArr[i10];
            double d21 = dArr[i8 + 1] + dArr[i10 + 1];
            double d22 = dArr[i8] - dArr[i10];
            double d23 = dArr[i8 + 1] - dArr[i10 + 1];
            double d24 = dArr[i8 + 2] + dArr[i10 + 2];
            double d25 = dArr[i8 + 3] + dArr[i10 + 3];
            double d26 = dArr[i8 + 2] - dArr[i10 + 2];
            double d27 = dArr[i8 + 3] - dArr[i10 + 3];
            double d28 = dArr[i9] + dArr[i11];
            double d29 = dArr[i9 + 1] + dArr[i11 + 1];
            double d30 = dArr[i9] - dArr[i11];
            double d31 = dArr[i9 + 1] - dArr[i11 + 1];
            double d32 = dArr[i9 + 2] + dArr[i11 + 2];
            double d33 = dArr[i9 + 3] + dArr[i11 + 3];
            double d34 = dArr[i9 + 2] - dArr[i11 + 2];
            double d35 = dArr[i9 + 3] - dArr[i11 + 3];
            dArr[i8] = d20 + d28;
            dArr[i8 + 1] = d21 + d29;
            dArr[i8 + 2] = d24 + d32;
            dArr[i8 + 3] = d25 + d33;
            dArr[i9] = d20 - d28;
            dArr[i9 + 1] = d21 - d29;
            dArr[i9 + 2] = d24 - d32;
            dArr[i9 + 3] = d25 - d33;
            double d36 = d22 - d31;
            double d37 = d23 + d30;
            dArr[i10] = (d16 * d36) - (d17 * d37);
            dArr[i10 + 1] = (d36 * d17) + (d37 * d16);
            double d38 = d26 - d35;
            double d39 = d27 + d34;
            dArr[i10 + 2] = (d12 * d38) - (d13 * d39);
            dArr[i10 + 3] = (d38 * d13) + (d39 * d12);
            double d40 = d22 + d31;
            double d41 = d23 - d30;
            dArr[i11] = (d18 * d40) + (d19 * d41);
            dArr[i11 + 1] = (d41 * d18) - (d40 * d19);
            double d42 = d26 + d35;
            double d43 = d27 - d34;
            dArr[i11 + 2] = (d14 * d42) + (d15 * d43);
            dArr[i11 + 3] = (d43 * d14) - (d42 * d15);
            int i12 = i4 - i8;
            int i13 = i12 + i4;
            int i14 = i13 + i4;
            int i15 = i14 + i4;
            double d44 = dArr[i12] + dArr[i14];
            double d45 = dArr[i12 + 1] + dArr[i14 + 1];
            double d46 = dArr[i12] - dArr[i14];
            double d47 = dArr[i12 + 1] - dArr[i14 + 1];
            double d48 = dArr[i12 - 2] + dArr[i14 - 2];
            double d49 = dArr[i12 - 1] + dArr[i14 - 1];
            double d50 = dArr[i12 - 2] - dArr[i14 - 2];
            double d51 = dArr[i12 - 1] - dArr[i14 - 1];
            double d52 = dArr[i13] + dArr[i15];
            double d53 = dArr[i13 + 1] + dArr[i15 + 1];
            double d54 = dArr[i13] - dArr[i15];
            double d55 = dArr[i13 + 1] - dArr[i15 + 1];
            double d56 = dArr[i13 - 2] + dArr[i15 - 2];
            double d57 = dArr[i13 - 1] + dArr[i15 - 1];
            double d58 = dArr[i13 - 2] - dArr[i15 - 2];
            double d59 = dArr[i13 - 1] - dArr[i15 - 1];
            dArr[i12] = d44 + d52;
            dArr[i12 + 1] = d45 + d53;
            dArr[i12 - 2] = d48 + d56;
            dArr[i12 - 1] = d49 + d57;
            dArr[i13] = d44 - d52;
            dArr[i13 + 1] = d45 - d53;
            dArr[i13 - 2] = d48 - d56;
            dArr[i13 - 1] = d49 - d57;
            double d60 = d46 - d55;
            double d61 = d47 + d54;
            dArr[i14] = (d17 * d60) - (d16 * d61);
            dArr[i14 + 1] = (d16 * d60) + (d17 * d61);
            double d62 = d50 - d59;
            double d63 = d51 + d58;
            dArr[i14 - 2] = (d13 * d62) - (d12 * d63);
            dArr[i14 - 1] = (d62 * d12) + (d63 * d13);
            double d64 = d46 + d55;
            double d65 = d47 - d54;
            dArr[i15] = (d19 * d64) + (d18 * d65);
            dArr[i15 + 1] = (d65 * d19) - (d64 * d18);
            double d66 = d50 + d59;
            double d67 = d51 - d58;
            dArr[i15 - 2] = (d15 * d66) + (d14 * d67);
            dArr[i15 - 1] = (d67 * d15) - (d66 * d14);
        }
        double d68 = (d12 + d9) * d10;
        double d69 = (d13 + d9) * d10;
        double d70 = (d14 - d9) * d11;
        double d71 = (d15 - d9) * d11;
        int i16 = i3 + i4;
        int i17 = i16 + i4;
        int i18 = i4 + i17;
        double d72 = dArr[i3 - 2] + dArr[i17 - 2];
        double d73 = dArr[i3 - 1] + dArr[i17 - 1];
        double d74 = dArr[i3 - 2] - dArr[i17 - 2];
        double d75 = dArr[i3 - 1] - dArr[i17 - 1];
        double d76 = dArr[i16 - 2] + dArr[i18 - 2];
        double d77 = dArr[i16 - 1] + dArr[i18 - 1];
        double d78 = dArr[i16 - 2] - dArr[i18 - 2];
        double d79 = dArr[i16 - 1] - dArr[i18 - 1];
        dArr[i3 - 2] = d72 + d76;
        dArr[i3 - 1] = d73 + d77;
        dArr[i16 - 2] = d72 - d76;
        dArr[i16 - 1] = d73 - d77;
        double d80 = d74 - d79;
        double d81 = d75 + d78;
        dArr[i17 - 2] = (d68 * d80) - (d69 * d81);
        dArr[i17 - 1] = (d80 * d69) + (d81 * d68);
        double d82 = d74 + d79;
        double d83 = d75 - d78;
        dArr[i18 - 2] = (d70 * d82) + (d71 * d83);
        dArr[i18 - 1] = (d83 * d70) - (d82 * d71);
        double d84 = dArr[i3] + dArr[i17];
        double d85 = dArr[i3 + 1] + dArr[i17 + 1];
        double d86 = dArr[i3] - dArr[i17];
        double d87 = dArr[i3 + 1] - dArr[i17 + 1];
        double d88 = dArr[i16] + dArr[i18];
        double d89 = dArr[i16 + 1] + dArr[i18 + 1];
        double d90 = dArr[i16] - dArr[i18];
        double d91 = dArr[i16 + 1] - dArr[i18 + 1];
        dArr[i3] = d84 + d88;
        dArr[i3 + 1] = d85 + d89;
        dArr[i16] = d84 - d88;
        dArr[i16 + 1] = d85 - d89;
        double d92 = d86 - d91;
        double d93 = d87 + d90;
        dArr[i17] = (d92 - d93) * d9;
        dArr[i17 + 1] = (d92 + d93) * d9;
        double d94 = d86 + d91;
        double d95 = d87 - d90;
        dArr[i18] = (-d9) * (d94 + d95);
        dArr[i18 + 1] = (-d9) * (d95 - d94);
        double d96 = dArr[i3 + 2] + dArr[i17 + 2];
        double d97 = dArr[i3 + 3] + dArr[i17 + 3];
        double d98 = dArr[i3 + 2] - dArr[i17 + 2];
        double d99 = dArr[i3 + 3] - dArr[i17 + 3];
        double d100 = dArr[i16 + 2] + dArr[i18 + 2];
        double d101 = dArr[i16 + 3] + dArr[i18 + 3];
        double d102 = dArr[i16 + 2] - dArr[i18 + 2];
        double d103 = dArr[i16 + 3] - dArr[i18 + 3];
        dArr[i3 + 2] = d96 + d100;
        dArr[i3 + 3] = d97 + d101;
        dArr[i16 + 2] = d96 - d100;
        dArr[i16 + 3] = d97 - d101;
        double d104 = d98 - d103;
        double d105 = d99 + d102;
        dArr[i17 + 2] = (d69 * d104) - (d68 * d105);
        dArr[i17 + 3] = (d69 * d105) + (d68 * d104);
        double d106 = d98 + d103;
        double d107 = d99 - d102;
        dArr[i18 + 2] = (d71 * d106) + (d70 * d107);
        dArr[i18 + 3] = (d71 * d107) - (d70 * d106);
    }

    private final void b(int i, double[] dArr, double[] dArr2, int i2) {
        int i3 = i >> 3;
        int i4 = i3 * 2;
        int i5 = i4 + i4;
        int i6 = i5 + i4;
        double d = dArr[0] + dArr[i5];
        double d2 = (-dArr[1]) - dArr[i5 + 1];
        double d3 = dArr[0] - dArr[i5];
        double d4 = (-dArr[1]) + dArr[i5 + 1];
        double d5 = dArr[i4] + dArr[i6];
        double d6 = dArr[i4 + 1] + dArr[i6 + 1];
        double d7 = dArr[i4] - dArr[i6];
        double d8 = dArr[i4 + 1] - dArr[i6 + 1];
        dArr[0] = d + d5;
        dArr[1] = d2 - d6;
        dArr[i4] = d - d5;
        dArr[i4 + 1] = d2 + d6;
        dArr[i5] = d3 + d8;
        dArr[i5 + 1] = d4 + d7;
        dArr[i6] = d3 - d8;
        dArr[i6 + 1] = d4 - d7;
        double d9 = dArr2[i2 + 1];
        double d10 = dArr2[i2 + 2];
        double d11 = dArr2[i2 + 3];
        double d12 = 1.0d;
        double d13 = 0.0d;
        double d14 = 1.0d;
        double d15 = 0.0d;
        int i7 = 0;
        for (int i8 = 2; i8 < i3 - 2; i8 += 4) {
            i7 += 4;
            double d16 = d10 * (d12 + dArr2[i2 + i7]);
            double d17 = d10 * (d13 + dArr2[i2 + i7 + 1]);
            double d18 = d11 * (d14 + dArr2[i2 + i7 + 2]);
            double d19 = d11 * (d15 - dArr2[(i2 + i7) + 3]);
            d12 = dArr2[i2 + i7];
            d13 = dArr2[i2 + i7 + 1];
            d14 = dArr2[i2 + i7 + 2];
            d15 = -dArr2[i2 + i7 + 3];
            int i9 = i8 + i4;
            int i10 = i9 + i4;
            int i11 = i10 + i4;
            double d20 = dArr[i8] + dArr[i10];
            double d21 = (-dArr[i8 + 1]) - dArr[i10 + 1];
            double d22 = dArr[i8] - dArr[i10];
            double d23 = (-dArr[i8 + 1]) + dArr[i10 + 1];
            double d24 = dArr[i8 + 2] + dArr[i10 + 2];
            double d25 = (-dArr[i8 + 3]) - dArr[i10 + 3];
            double d26 = dArr[i8 + 2] - dArr[i10 + 2];
            double d27 = (-dArr[i8 + 3]) + dArr[i10 + 3];
            double d28 = dArr[i9] + dArr[i11];
            double d29 = dArr[i9 + 1] + dArr[i11 + 1];
            double d30 = dArr[i9] - dArr[i11];
            double d31 = dArr[i9 + 1] - dArr[i11 + 1];
            double d32 = dArr[i9 + 2] + dArr[i11 + 2];
            double d33 = dArr[i9 + 3] + dArr[i11 + 3];
            double d34 = dArr[i9 + 2] - dArr[i11 + 2];
            double d35 = dArr[i9 + 3] - dArr[i11 + 3];
            dArr[i8] = d20 + d28;
            dArr[i8 + 1] = d21 - d29;
            dArr[i8 + 2] = d24 + d32;
            dArr[i8 + 3] = d25 - d33;
            dArr[i9] = d20 - d28;
            dArr[i9 + 1] = d21 + d29;
            dArr[i9 + 2] = d24 - d32;
            dArr[i9 + 3] = d25 + d33;
            double d36 = d22 + d31;
            double d37 = d23 + d30;
            dArr[i10] = (d16 * d36) - (d17 * d37);
            dArr[i10 + 1] = (d36 * d17) + (d37 * d16);
            double d38 = d26 + d35;
            double d39 = d27 + d34;
            dArr[i10 + 2] = (d12 * d38) - (d13 * d39);
            dArr[i10 + 3] = (d38 * d13) + (d39 * d12);
            double d40 = d22 - d31;
            double d41 = d23 - d30;
            dArr[i11] = (d18 * d40) + (d19 * d41);
            dArr[i11 + 1] = (d41 * d18) - (d40 * d19);
            double d42 = d26 - d35;
            double d43 = d27 - d34;
            dArr[i11 + 2] = (d14 * d42) + (d15 * d43);
            dArr[i11 + 3] = (d43 * d14) - (d42 * d15);
            int i12 = i4 - i8;
            int i13 = i12 + i4;
            int i14 = i13 + i4;
            int i15 = i14 + i4;
            double d44 = dArr[i12] + dArr[i14];
            double d45 = (-dArr[i12 + 1]) - dArr[i14 + 1];
            double d46 = dArr[i12] - dArr[i14];
            double d47 = (-dArr[i12 + 1]) + dArr[i14 + 1];
            double d48 = dArr[i12 - 2] + dArr[i14 - 2];
            double d49 = (-dArr[i12 - 1]) - dArr[i14 - 1];
            double d50 = dArr[i12 - 2] - dArr[i14 - 2];
            double d51 = (-dArr[i12 - 1]) + dArr[i14 - 1];
            double d52 = dArr[i13] + dArr[i15];
            double d53 = dArr[i13 + 1] + dArr[i15 + 1];
            double d54 = dArr[i13] - dArr[i15];
            double d55 = dArr[i13 + 1] - dArr[i15 + 1];
            double d56 = dArr[i13 - 2] + dArr[i15 - 2];
            double d57 = dArr[i13 - 1] + dArr[i15 - 1];
            double d58 = dArr[i13 - 2] - dArr[i15 - 2];
            double d59 = dArr[i13 - 1] - dArr[i15 - 1];
            dArr[i12] = d44 + d52;
            dArr[i12 + 1] = d45 - d53;
            dArr[i12 - 2] = d48 + d56;
            dArr[i12 - 1] = d49 - d57;
            dArr[i13] = d44 - d52;
            dArr[i13 + 1] = d45 + d53;
            dArr[i13 - 2] = d48 - d56;
            dArr[i13 - 1] = d49 + d57;
            double d60 = d46 + d55;
            double d61 = d47 + d54;
            dArr[i14] = (d17 * d60) - (d16 * d61);
            dArr[i14 + 1] = (d16 * d60) + (d17 * d61);
            double d62 = d50 + d59;
            double d63 = d51 + d58;
            dArr[i14 - 2] = (d13 * d62) - (d12 * d63);
            dArr[i14 - 1] = (d62 * d12) + (d63 * d13);
            double d64 = d46 - d55;
            double d65 = d47 - d54;
            dArr[i15] = (d19 * d64) + (d18 * d65);
            dArr[i15 + 1] = (d65 * d19) - (d64 * d18);
            double d66 = d50 - d59;
            double d67 = d51 - d58;
            dArr[i15 - 2] = (d15 * d66) + (d14 * d67);
            dArr[i15 - 1] = (d67 * d15) - (d66 * d14);
        }
        double d68 = (d12 + d9) * d10;
        double d69 = (d13 + d9) * d10;
        double d70 = (d14 - d9) * d11;
        double d71 = (d15 - d9) * d11;
        int i16 = i3 + i4;
        int i17 = i16 + i4;
        int i18 = i4 + i17;
        double d72 = dArr[i3 - 2] + dArr[i17 - 2];
        double d73 = (-dArr[i3 - 1]) - dArr[i17 - 1];
        double d74 = dArr[i3 - 2] - dArr[i17 - 2];
        double d75 = (-dArr[i3 - 1]) + dArr[i17 - 1];
        double d76 = dArr[i16 - 2] + dArr[i18 - 2];
        double d77 = dArr[i16 - 1] + dArr[i18 - 1];
        double d78 = dArr[i16 - 2] - dArr[i18 - 2];
        double d79 = dArr[i16 - 1] - dArr[i18 - 1];
        dArr[i3 - 2] = d72 + d76;
        dArr[i3 - 1] = d73 - d77;
        dArr[i16 - 2] = d72 - d76;
        dArr[i16 - 1] = d73 + d77;
        double d80 = d74 + d79;
        double d81 = d75 + d78;
        dArr[i17 - 2] = (d68 * d80) - (d69 * d81);
        dArr[i17 - 1] = (d80 * d69) + (d81 * d68);
        double d82 = d74 - d79;
        double d83 = d75 - d78;
        dArr[i18 - 2] = (d70 * d82) + (d71 * d83);
        dArr[i18 - 1] = (d83 * d70) - (d82 * d71);
        double d84 = dArr[i3] + dArr[i17];
        double d85 = (-dArr[i3 + 1]) - dArr[i17 + 1];
        double d86 = dArr[i3] - dArr[i17];
        double d87 = (-dArr[i3 + 1]) + dArr[i17 + 1];
        double d88 = dArr[i16] + dArr[i18];
        double d89 = dArr[i16 + 1] + dArr[i18 + 1];
        double d90 = dArr[i16] - dArr[i18];
        double d91 = dArr[i16 + 1] - dArr[i18 + 1];
        dArr[i3] = d84 + d88;
        dArr[i3 + 1] = d85 - d89;
        dArr[i16] = d84 - d88;
        dArr[i16 + 1] = d85 + d89;
        double d92 = d86 + d91;
        double d93 = d87 + d90;
        dArr[i17] = (d92 - d93) * d9;
        dArr[i17 + 1] = (d92 + d93) * d9;
        double d94 = d86 - d91;
        double d95 = d87 - d90;
        dArr[i18] = (-d9) * (d94 + d95);
        dArr[i18 + 1] = (-d9) * (d95 - d94);
        double d96 = dArr[i3 + 2] + dArr[i17 + 2];
        double d97 = (-dArr[i3 + 3]) - dArr[i17 + 3];
        double d98 = dArr[i3 + 2] - dArr[i17 + 2];
        double d99 = (-dArr[i3 + 3]) + dArr[i17 + 3];
        double d100 = dArr[i16 + 2] + dArr[i18 + 2];
        double d101 = dArr[i16 + 3] + dArr[i18 + 3];
        double d102 = dArr[i16 + 2] - dArr[i18 + 2];
        double d103 = dArr[i16 + 3] - dArr[i18 + 3];
        dArr[i3 + 2] = d96 + d100;
        dArr[i3 + 3] = d97 - d101;
        dArr[i16 + 2] = d96 - d100;
        dArr[i16 + 3] = d97 + d101;
        double d104 = d98 + d103;
        double d105 = d99 + d102;
        dArr[i17 + 2] = (d69 * d104) - (d68 * d105);
        dArr[i17 + 3] = (d69 * d105) + (d68 * d104);
        double d106 = d98 - d103;
        double d107 = d99 - d102;
        dArr[i18 + 2] = (d71 * d106) + (d70 * d107);
        dArr[i18 + 3] = (d71 * d107) - (d70 * d106);
    }

    private void a(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        a(i, dArr, i2, dArr2, i3 - (i4 * 2));
        if (i > 512) {
            a(i4, dArr, i2, i3, dArr2);
            b(i4, dArr, i2 + i4, i3, dArr2);
            a(i4, dArr, i2 + (i4 * 2), i3, dArr2);
            a(i4, dArr, i2 + (i4 * 3), i3, dArr2);
            return;
        }
        c(i, dArr, i2, i3, dArr2);
    }

    private void b(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        b(i, dArr, i2, dArr2, i3 - i);
        if (i > 512) {
            a(i4, dArr, i2, i3, dArr2);
            b(i4, dArr, i2 + i4, i3, dArr2);
            a(i4, dArr, i2 + (i4 * 2), i3, dArr2);
            b(i4, dArr, i2 + (i4 * 3), i3, dArr2);
            return;
        }
        d(i, dArr, i2, i3, dArr2);
    }

    private void c(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        while (i4 > 128) {
            for (int i5 = i4; i5 < i; i5 <<= 2) {
                for (int i6 = i5 - i4; i6 < i; i6 = (i5 * 4) + i6) {
                    a(i4, dArr, i2 + i6, dArr2, i3 - (i4 >> 1));
                    b(i4, dArr, i2 + i5 + i6, dArr2, i3 - i4);
                    a(i4, dArr, (i5 * 2) + i2 + i6, dArr2, i3 - (i4 >> 1));
                }
            }
            a(i4, dArr, (i2 + i) - i4, dArr2, i3 - (i4 >> 1));
            i4 >>= 2;
        }
        for (int i7 = i4; i7 < i; i7 <<= 2) {
            for (int i8 = i7 - i4; i8 < i; i8 = (i7 * 4) + i8) {
                a(i4, dArr, i2 + i8, dArr2, i3 - (i4 >> 1));
                e(i4, dArr, i2 + i8, i3, dArr2);
                b(i4, dArr, i2 + i7 + i8, dArr2, i3 - i4);
                f(i4, dArr, i2 + i7 + i8, i3, dArr2);
                a(i4, dArr, (i7 * 2) + i2 + i8, dArr2, i3 - (i4 >> 1));
                e(i4, dArr, (i7 * 2) + i2 + i8, i3, dArr2);
            }
        }
        a(i4, dArr, (i2 + i) - i4, dArr2, i3 - (i4 >> 1));
        e(i4, dArr, (i2 + i) - i4, i3, dArr2);
    }

    private void d(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 1;
        int i5 = i >> 2;
        while (i5 > 128) {
            for (int i6 = i5; i6 < i4; i6 <<= 2) {
                for (int i7 = i6 - i5; i7 < i4; i7 = (i6 * 2) + i7) {
                    a(i5, dArr, i2 + i7, dArr2, i3 - (i5 >> 1));
                    a(i5, dArr, i2 + i4 + i7, dArr2, i3 - (i5 >> 1));
                }
                for (int i8 = (i6 * 2) - i5; i8 < i4; i8 = (i6 * 4) + i8) {
                    b(i5, dArr, i2 + i8, dArr2, i3 - i5);
                    b(i5, dArr, i2 + i4 + i8, dArr2, i3 - i5);
                }
            }
            i5 >>= 2;
        }
        for (int i9 = i5; i9 < i4; i9 <<= 2) {
            for (int i10 = i9 - i5; i10 < i4; i10 = (i9 * 2) + i10) {
                a(i5, dArr, i2 + i10, dArr2, i3 - (i5 >> 1));
                e(i5, dArr, i2 + i10, i3, dArr2);
                a(i5, dArr, i2 + i4 + i10, dArr2, i3 - (i5 >> 1));
                e(i5, dArr, i2 + i4 + i10, i3, dArr2);
            }
            for (int i11 = (i9 * 2) - i5; i11 < i4; i11 = (i9 * 4) + i11) {
                b(i5, dArr, i2 + i11, dArr2, i3 - i5);
                f(i5, dArr, i2 + i11, i3, dArr2);
                b(i5, dArr, i2 + i4 + i11, dArr2, i3 - i5);
                f(i5, dArr, i2 + i4 + i11, i3, dArr2);
            }
        }
    }

    private final void a(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        double d = dArr[i2 + 0] + dArr[i2 + i6];
        double d2 = dArr[i2 + 1] + dArr[i2 + i6 + 1];
        double d3 = dArr[i2 + 0] - dArr[i2 + i6];
        double d4 = dArr[i2 + 1] - dArr[(i2 + i6) + 1];
        double d5 = dArr[i2 + i5] + dArr[i2 + i7];
        double d6 = dArr[i2 + i5 + 1] + dArr[i2 + i7 + 1];
        double d7 = dArr[i2 + i5] - dArr[i2 + i7];
        double d8 = dArr[(i2 + i5) + 1] - dArr[(i2 + i7) + 1];
        dArr[i2 + 0] = d + d5;
        dArr[i2 + 1] = d2 + d6;
        dArr[i2 + i5] = d - d5;
        dArr[i2 + i5 + 1] = d2 - d6;
        dArr[i2 + i6] = d3 - d8;
        dArr[i6 + i2 + 1] = d4 + d7;
        dArr[i2 + i7] = d3 + d8;
        dArr[i2 + i7 + 1] = d4 - d7;
        double d9 = dArr2[i3 + 1];
        int i8 = 0;
        for (int i9 = 2; i9 < i4; i9 += 2) {
            i8 += 4;
            double d10 = dArr2[i3 + i8];
            double d11 = dArr2[i3 + i8 + 1];
            double d12 = dArr2[i3 + i8 + 2];
            double d13 = -dArr2[i3 + i8 + 3];
            int i10 = i9 + i5;
            int i11 = i10 + i5;
            int i12 = i11 + i5;
            double d14 = dArr[i2 + i9] + dArr[i2 + i11];
            double d15 = dArr[i2 + i9 + 1] + dArr[i2 + i11 + 1];
            double d16 = dArr[i2 + i9] - dArr[i2 + i11];
            double d17 = dArr[(i2 + i9) + 1] - dArr[(i2 + i11) + 1];
            double d18 = dArr[i2 + i10] + dArr[i2 + i12];
            double d19 = dArr[i2 + i10 + 1] + dArr[i2 + i12 + 1];
            double d20 = dArr[i2 + i10] - dArr[i2 + i12];
            double d21 = dArr[(i2 + i10) + 1] - dArr[(i2 + i12) + 1];
            dArr[i2 + i9] = d14 + d18;
            dArr[i2 + i9 + 1] = d15 + d19;
            dArr[i2 + i10] = d14 - d18;
            dArr[i10 + i2 + 1] = d15 - d19;
            double d22 = d16 - d21;
            double d23 = d17 + d20;
            dArr[i2 + i11] = (d10 * d22) - (d11 * d23);
            dArr[i2 + i11 + 1] = (d22 * d11) + (d23 * d10);
            double d24 = d16 + d21;
            double d25 = d17 - d20;
            dArr[i2 + i12] = (d12 * d24) + (d13 * d25);
            dArr[i12 + i2 + 1] = (d25 * d12) - (d24 * d13);
            int i13 = i5 - i9;
            int i14 = i13 + i5;
            int i15 = i14 + i5;
            int i16 = i15 + i5;
            double d26 = dArr[i2 + i13] + dArr[i2 + i15];
            double d27 = dArr[i2 + i13 + 1] + dArr[i2 + i15 + 1];
            double d28 = dArr[i2 + i13] - dArr[i2 + i15];
            double d29 = dArr[(i2 + i13) + 1] - dArr[(i2 + i15) + 1];
            double d30 = dArr[i2 + i14] + dArr[i2 + i16];
            double d31 = dArr[i2 + i14 + 1] + dArr[i2 + i16 + 1];
            double d32 = dArr[i2 + i14] - dArr[i2 + i16];
            double d33 = dArr[(i2 + i14) + 1] - dArr[(i2 + i16) + 1];
            dArr[i2 + i13] = d26 + d30;
            dArr[i13 + i2 + 1] = d27 + d31;
            dArr[i2 + i14] = d26 - d30;
            dArr[i2 + i14 + 1] = d27 - d31;
            double d34 = d28 - d33;
            double d35 = d29 + d32;
            dArr[i2 + i15] = (d11 * d34) - (d10 * d35);
            dArr[i15 + i2 + 1] = (d10 * d34) + (d11 * d35);
            double d36 = d28 + d33;
            double d37 = d29 - d32;
            dArr[i2 + i16] = (d13 * d36) + (d12 * d37);
            dArr[i2 + i16 + 1] = (d37 * d13) - (d36 * d12);
        }
        int i17 = i4 + i5;
        int i18 = i17 + i5;
        int i19 = i5 + i18;
        double d38 = dArr[i2 + i4] + dArr[i2 + i18];
        double d39 = dArr[i2 + i4 + 1] + dArr[i2 + i18 + 1];
        double d40 = dArr[i2 + i4] - dArr[i2 + i18];
        double d41 = dArr[(i2 + i4) + 1] - dArr[(i2 + i18) + 1];
        double d42 = dArr[i2 + i17] + dArr[i2 + i19];
        double d43 = dArr[i2 + i17 + 1] + dArr[i2 + i19 + 1];
        double d44 = dArr[i2 + i17] - dArr[i2 + i19];
        double d45 = dArr[(i2 + i17) + 1] - dArr[(i2 + i19) + 1];
        dArr[i2 + i4] = d38 + d42;
        dArr[i4 + i2 + 1] = d39 + d43;
        dArr[i2 + i17] = d38 - d42;
        dArr[i17 + i2 + 1] = d39 - d43;
        double d46 = d40 - d45;
        double d47 = d41 + d44;
        dArr[i2 + i18] = (d46 - d47) * d9;
        dArr[i2 + i18 + 1] = (d46 + d47) * d9;
        double d48 = d40 + d45;
        double d49 = d41 - d44;
        dArr[i2 + i19] = (-d9) * (d48 + d49);
        dArr[i2 + i19 + 1] = (d49 - d48) * (-d9);
    }

    private final void b(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        double d = dArr2[i3 + 1];
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        double d2 = dArr[i2 + 0] - dArr[(i2 + i6) + 1];
        double d3 = dArr[i2 + 1] + dArr[i2 + i6];
        double d4 = dArr[i2 + 0] + dArr[i2 + i6 + 1];
        double d5 = dArr[i2 + 1] - dArr[i2 + i6];
        double d6 = dArr[i2 + i5] - dArr[(i2 + i7) + 1];
        double d7 = dArr[i2 + i5 + 1] + dArr[i2 + i7];
        double d8 = dArr[i2 + i5] + dArr[i2 + i7 + 1];
        double d9 = dArr[(i2 + i5) + 1] - dArr[i2 + i7];
        double d10 = (d6 - d7) * d;
        double d11 = (d6 + d7) * d;
        dArr[i2 + 0] = d2 + d10;
        dArr[i2 + 1] = d3 + d11;
        dArr[i2 + i5] = d2 - d10;
        dArr[i2 + i5 + 1] = d3 - d11;
        double d12 = (d8 - d9) * d;
        double d13 = d * (d9 + d8);
        dArr[i2 + i6] = d4 - d13;
        dArr[i6 + i2 + 1] = d5 + d12;
        dArr[i2 + i7] = d13 + d4;
        dArr[i2 + i7 + 1] = d5 - d12;
        int i8 = 0;
        int i9 = i5 * 2;
        for (int i10 = 2; i10 < i4; i10 += 2) {
            i8 += 4;
            double d14 = dArr2[i3 + i8];
            double d15 = dArr2[i3 + i8 + 1];
            double d16 = dArr2[i3 + i8 + 2];
            double d17 = -dArr2[i3 + i8 + 3];
            i9 -= 4;
            double d18 = dArr2[i3 + i9];
            double d19 = dArr2[i3 + i9 + 1];
            double d20 = dArr2[i3 + i9 + 2];
            double d21 = -dArr2[i3 + i9 + 3];
            int i11 = i10 + i5;
            int i12 = i11 + i5;
            int i13 = i12 + i5;
            double d22 = dArr[i2 + i10] - dArr[(i2 + i12) + 1];
            double d23 = dArr[i2 + i10 + 1] + dArr[i2 + i12];
            double d24 = dArr[i2 + i10] + dArr[i2 + i12 + 1];
            double d25 = dArr[(i2 + i10) + 1] - dArr[i2 + i12];
            double d26 = dArr[i2 + i11] - dArr[(i2 + i13) + 1];
            double d27 = dArr[i2 + i11 + 1] + dArr[i2 + i13];
            double d28 = dArr[i2 + i11] + dArr[i2 + i13 + 1];
            double d29 = dArr[(i2 + i11) + 1] - dArr[i2 + i13];
            double d30 = (d14 * d22) - (d15 * d23);
            double d31 = (d22 * d15) + (d23 * d14);
            double d32 = (d19 * d26) - (d18 * d27);
            double d33 = (d26 * d18) + (d27 * d19);
            dArr[i2 + i10] = d30 + d32;
            dArr[i2 + i10 + 1] = d31 + d33;
            dArr[i2 + i11] = d30 - d32;
            dArr[i11 + i2 + 1] = d31 - d33;
            double d34 = (d16 * d24) + (d17 * d25);
            double d35 = (d16 * d25) - (d24 * d17);
            double d36 = (d21 * d28) + (d20 * d29);
            double d37 = (d21 * d29) - (d20 * d28);
            dArr[i2 + i12] = d34 + d36;
            dArr[i2 + i12 + 1] = d35 + d37;
            dArr[i2 + i13] = d34 - d36;
            dArr[i2 + i13 + 1] = d35 - d37;
            int i14 = i5 - i10;
            int i15 = i14 + i5;
            int i16 = i15 + i5;
            int i17 = i16 + i5;
            double d38 = dArr[i2 + i14] - dArr[(i2 + i16) + 1];
            double d39 = dArr[i2 + i14 + 1] + dArr[i2 + i16];
            double d40 = dArr[i2 + i14] + dArr[i2 + i16 + 1];
            double d41 = dArr[(i2 + i14) + 1] - dArr[i2 + i16];
            double d42 = dArr[i2 + i15] - dArr[(i2 + i17) + 1];
            double d43 = dArr[i2 + i15 + 1] + dArr[i2 + i17];
            double d44 = dArr[i2 + i15] + dArr[i2 + i17 + 1];
            double d45 = dArr[(i2 + i15) + 1] - dArr[i2 + i17];
            double d46 = (d18 * d38) - (d19 * d39);
            double d47 = (d18 * d39) + (d19 * d38);
            double d48 = (d15 * d42) - (d14 * d43);
            double d49 = (d14 * d42) + (d15 * d43);
            dArr[i2 + i14] = d46 + d48;
            dArr[i14 + i2 + 1] = d47 + d49;
            dArr[i2 + i15] = d46 - d48;
            dArr[i2 + i15 + 1] = d47 - d49;
            double d50 = (d20 * d40) + (d21 * d41);
            double d51 = (d20 * d41) - (d21 * d40);
            double d52 = (d17 * d44) + (d16 * d45);
            double d53 = (d17 * d45) - (d16 * d44);
            dArr[i2 + i16] = d50 + d52;
            dArr[i2 + i16 + 1] = d51 + d53;
            dArr[i2 + i17] = d50 - d52;
            dArr[i2 + i17 + 1] = d51 - d53;
        }
        double d54 = dArr2[i3 + i5];
        double d55 = dArr2[i3 + i5 + 1];
        int i18 = i4 + i5;
        int i19 = i18 + i5;
        int i20 = i5 + i19;
        double d56 = dArr[i2 + i4] - dArr[(i2 + i19) + 1];
        double d57 = dArr[i2 + i4 + 1] + dArr[i2 + i19];
        double d58 = dArr[i2 + i4] + dArr[i2 + i19 + 1];
        double d59 = dArr[(i2 + i4) + 1] - dArr[i2 + i19];
        double d60 = dArr[i2 + i18] - dArr[(i2 + i20) + 1];
        double d61 = dArr[i2 + i18 + 1] + dArr[i2 + i20];
        double d62 = dArr[i2 + i18] + dArr[i2 + i20 + 1];
        double d63 = dArr[(i2 + i18) + 1] - dArr[i2 + i20];
        double d64 = (d54 * d56) - (d55 * d57);
        double d65 = (d56 * d55) + (d57 * d54);
        double d66 = (d55 * d60) - (d54 * d61);
        double d67 = (d60 * d54) + (d61 * d55);
        dArr[i2 + i4] = d64 + d66;
        dArr[i4 + i2 + 1] = d65 + d67;
        dArr[i2 + i18] = d64 - d66;
        dArr[i18 + i2 + 1] = d65 - d67;
        double d68 = (d55 * d58) - (d54 * d59);
        double d69 = (d55 * d59) + (d54 * d58);
        double d70 = (d54 * d62) - (d55 * d63);
        double d71 = (d54 * d63) + (d55 * d62);
        dArr[i2 + i19] = d68 - d70;
        dArr[i19 + i2 + 1] = d69 - d71;
        dArr[i2 + i20] = d68 + d70;
        dArr[i2 + i20 + 1] = d71 + d69;
    }

    private void e(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        if (i == 128) {
            a(dArr, i2, dArr2, i3 - 8);
            b(dArr, i2 + 32, dArr2, i3 - 32);
            a(dArr, i2 + 64, dArr2, i3 - 8);
            a(dArr, i2 + 96, dArr2, i3 - 8);
            return;
        }
        c(dArr, i2, dArr2, i3 - 16);
        d(dArr, i2 + 16, dArr2, i3 - 16);
        c(dArr, i2 + 32, dArr2, i3 - 16);
        c(dArr, i2 + 48, dArr2, i3 - 16);
    }

    private void f(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        if (i == 128) {
            a(dArr, i2, dArr2, i3 - 8);
            b(dArr, i2 + 32, dArr2, i3 - 32);
            a(dArr, i2 + 64, dArr2, i3 - 8);
            b(dArr, i2 + 96, dArr2, i3 - 32);
            return;
        }
        c(dArr, i2, dArr2, i3 - 16);
        d(dArr, i2 + 16, dArr2, i3 - 16);
        c(dArr, i2 + 32, dArr2, i3 - 16);
        d(dArr, i2 + 48, dArr2, i3 - 16);
    }

    private void a(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        double d2 = dArr2[i2 + 2] * d;
        double d3 = dArr2[i2 + 2] + d2;
        double d4 = dArr[i + 0] + dArr[i + 16];
        double d5 = dArr[i + 1] + dArr[i + 17];
        double d6 = dArr[i + 0] - dArr[i + 16];
        double d7 = dArr[i + 1] - dArr[i + 17];
        double d8 = dArr[i + 8] + dArr[i + 24];
        double d9 = dArr[i + 9] + dArr[i + 25];
        double d10 = dArr[i + 8] - dArr[i + 24];
        double d11 = dArr[i + 9] - dArr[i + 25];
        double d12 = d4 + d8;
        double d13 = d5 + d9;
        double d14 = d4 - d8;
        double d15 = d5 - d9;
        double d16 = d6 - d11;
        double d17 = d7 + d10;
        double d18 = d6 + d11;
        double d19 = d7 - d10;
        double d20 = dArr[i + 2] + dArr[i + 18];
        double d21 = dArr[i + 3] + dArr[i + 19];
        double d22 = dArr[i + 2] - dArr[i + 18];
        double d23 = dArr[i + 3] - dArr[i + 19];
        double d24 = dArr[i + 10] + dArr[i + 26];
        double d25 = dArr[i + 11] + dArr[i + 27];
        double d26 = dArr[i + 10] - dArr[i + 26];
        double d27 = dArr[i + 11] - dArr[i + 27];
        double d28 = d20 + d24;
        double d29 = d21 + d25;
        double d30 = d20 - d24;
        double d31 = d21 - d25;
        double d32 = d22 - d27;
        double d33 = d23 + d26;
        double d34 = (d3 * d32) - (d2 * d33);
        double d35 = (d32 * d2) + (d33 * d3);
        double d36 = d22 + d27;
        double d37 = d23 - d26;
        double d38 = (d2 * d36) - (d3 * d37);
        double d39 = (d36 * d3) + (d37 * d2);
        double d40 = dArr[i + 4] + dArr[i + 20];
        double d41 = dArr[i + 5] + dArr[i + 21];
        double d42 = dArr[i + 4] - dArr[i + 20];
        double d43 = dArr[i + 5] - dArr[i + 21];
        double d44 = dArr[i + 12] + dArr[i + 28];
        double d45 = dArr[i + 13] + dArr[i + 29];
        double d46 = dArr[i + 12] - dArr[i + 28];
        double d47 = dArr[i + 13] - dArr[i + 29];
        double d48 = d40 + d44;
        double d49 = d41 + d45;
        double d50 = d40 - d44;
        double d51 = d41 - d45;
        double d52 = d42 - d47;
        double d53 = d43 + d46;
        double d54 = (d52 - d53) * d;
        double d55 = (d52 + d53) * d;
        double d56 = d42 + d47;
        double d57 = d43 - d46;
        double d58 = (d56 + d57) * d;
        double d59 = (d57 - d56) * d;
        double d60 = dArr[i + 6] + dArr[i + 22];
        double d61 = dArr[i + 7] + dArr[i + 23];
        double d62 = dArr[i + 6] - dArr[i + 22];
        double d63 = dArr[i + 7] - dArr[i + 23];
        double d64 = dArr[i + 14] + dArr[i + 30];
        double d65 = dArr[i + 15] + dArr[i + 31];
        double d66 = dArr[i + 14] - dArr[i + 30];
        double d67 = dArr[i + 15] - dArr[i + 31];
        double d68 = d60 + d64;
        double d69 = d61 + d65;
        double d70 = d60 - d64;
        double d71 = d61 - d65;
        double d72 = d62 - d67;
        double d73 = d63 + d66;
        double d74 = (d2 * d72) - (d3 * d73);
        double d75 = (d72 * d3) + (d73 * d2);
        double d76 = d62 + d67;
        double d77 = d63 - d66;
        double d78 = (d3 * d76) - (d2 * d77);
        double d79 = (d2 * d76) + (d3 * d77);
        double d80 = d18 - d58;
        double d81 = d19 - d59;
        double d82 = d18 + d58;
        double d83 = d19 + d59;
        double d84 = d38 - d78;
        double d85 = d39 - d79;
        double d86 = d38 + d78;
        double d87 = d79 + d39;
        dArr[i + 24] = d80 + d84;
        dArr[i + 25] = d81 + d85;
        dArr[i + 26] = d80 - d84;
        dArr[i + 27] = d81 - d85;
        dArr[i + 28] = d82 - d87;
        dArr[i + 29] = d83 + d86;
        dArr[i + 30] = d87 + d82;
        dArr[i + 31] = d83 - d86;
        double d88 = d16 + d54;
        double d89 = d17 + d55;
        double d90 = d16 - d54;
        double d91 = d17 - d55;
        double d92 = d34 + d74;
        double d93 = d35 + d75;
        double d94 = d34 - d74;
        double d95 = d35 - d75;
        dArr[i + 16] = d88 + d92;
        dArr[i + 17] = d89 + d93;
        dArr[i + 18] = d88 - d92;
        dArr[i + 19] = d89 - d93;
        dArr[i + 20] = d90 - d95;
        dArr[i + 21] = d91 + d94;
        dArr[i + 22] = d90 + d95;
        dArr[i + 23] = d91 - d94;
        double d96 = d30 - d71;
        double d97 = d31 + d70;
        double d98 = (d96 - d97) * d;
        double d99 = (d96 + d97) * d;
        double d100 = d30 + d71;
        double d101 = d31 - d70;
        double d102 = (d100 - d101) * d;
        double d103 = d * (d100 + d101);
        double d104 = d14 - d51;
        double d105 = d15 + d50;
        double d106 = d14 + d51;
        double d107 = d15 - d50;
        dArr[i + 8] = d104 + d98;
        dArr[i + 9] = d105 + d99;
        dArr[i + 10] = d104 - d98;
        dArr[i + 11] = d105 - d99;
        dArr[i + 12] = d106 - d103;
        dArr[i + 13] = d107 + d102;
        dArr[i + 14] = d103 + d106;
        dArr[i + 15] = d107 - d102;
        double d108 = d12 + d48;
        double d109 = d13 + d49;
        double d110 = d12 - d48;
        double d111 = d13 - d49;
        double d112 = d28 + d68;
        double d113 = d29 + d69;
        double d114 = d28 - d68;
        double d115 = d29 - d69;
        dArr[i + 0] = d108 + d112;
        dArr[i + 1] = d109 + d113;
        dArr[i + 2] = d108 - d112;
        dArr[i + 3] = d109 - d113;
        dArr[i + 4] = d110 - d115;
        dArr[i + 5] = d111 + d114;
        dArr[i + 6] = d110 + d115;
        dArr[i + 7] = d111 - d114;
    }

    private void b(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        double d2 = dArr2[i2 + 4];
        double d3 = dArr2[i2 + 5];
        double d4 = dArr2[i2 + 6];
        double d5 = dArr2[i2 + 7];
        double d6 = dArr2[i2 + 8];
        double d7 = dArr2[i2 + 9];
        double d8 = dArr[i + 0] - dArr[i + 17];
        double d9 = dArr[i + 1] + dArr[i + 16];
        double d10 = dArr[i + 8] - dArr[i + 25];
        double d11 = dArr[i + 9] + dArr[i + 24];
        double d12 = (d10 - d11) * d;
        double d13 = (d10 + d11) * d;
        double d14 = d8 + d12;
        double d15 = d9 + d13;
        double d16 = d8 - d12;
        double d17 = d9 - d13;
        double d18 = dArr[i + 0] + dArr[i + 17];
        double d19 = dArr[i + 1] - dArr[i + 16];
        double d20 = dArr[i + 8] + dArr[i + 25];
        double d21 = dArr[i + 9] - dArr[i + 24];
        double d22 = (d20 - d21) * d;
        double d23 = (d20 + d21) * d;
        double d24 = d18 - d23;
        double d25 = d19 + d22;
        double d26 = d18 + d23;
        double d27 = d19 - d22;
        double d28 = dArr[i + 2] - dArr[i + 19];
        double d29 = dArr[i + 3] + dArr[i + 18];
        double d30 = (d2 * d28) - (d3 * d29);
        double d31 = (d28 * d3) + (d29 * d2);
        double d32 = dArr[i + 10] - dArr[i + 27];
        double d33 = dArr[i + 11] + dArr[i + 26];
        double d34 = (d5 * d32) - (d4 * d33);
        double d35 = (d32 * d4) + (d33 * d5);
        double d36 = d30 + d34;
        double d37 = d31 + d35;
        double d38 = d30 - d34;
        double d39 = d31 - d35;
        double d40 = dArr[i + 2] + dArr[i + 19];
        double d41 = dArr[i + 3] - dArr[i + 18];
        double d42 = (d4 * d40) - (d5 * d41);
        double d43 = (d40 * d5) + (d41 * d4);
        double d44 = dArr[i + 10] + dArr[i + 27];
        double d45 = dArr[i + 11] - dArr[i + 26];
        double d46 = (d2 * d44) + (d3 * d45);
        double d47 = (d45 * d2) - (d44 * d3);
        double d48 = d42 - d46;
        double d49 = d43 - d47;
        double d50 = d42 + d46;
        double d51 = d43 + d47;
        double d52 = dArr[i + 4] - dArr[i + 21];
        double d53 = dArr[i + 5] + dArr[i + 20];
        double d54 = (d6 * d52) - (d7 * d53);
        double d55 = (d52 * d7) + (d53 * d6);
        double d56 = dArr[i + 12] - dArr[i + 29];
        double d57 = dArr[i + 13] + dArr[i + 28];
        double d58 = (d7 * d56) - (d6 * d57);
        double d59 = (d56 * d6) + (d57 * d7);
        double d60 = d54 + d58;
        double d61 = d55 + d59;
        double d62 = d54 - d58;
        double d63 = d55 - d59;
        double d64 = dArr[i + 4] + dArr[i + 21];
        double d65 = dArr[i + 5] - dArr[i + 20];
        double d66 = (d7 * d64) - (d6 * d65);
        double d67 = (d64 * d6) + (d65 * d7);
        double d68 = dArr[i + 12] + dArr[i + 29];
        double d69 = dArr[i + 13] - dArr[i + 28];
        double d70 = (d6 * d68) - (d7 * d69);
        double d71 = (d6 * d69) + (d7 * d68);
        double d72 = d66 - d70;
        double d73 = d67 - d71;
        double d74 = d66 + d70;
        double d75 = d71 + d67;
        double d76 = dArr[i + 6] - dArr[i + 23];
        double d77 = dArr[i + 7] + dArr[i + 22];
        double d78 = (d4 * d76) - (d5 * d77);
        double d79 = (d76 * d5) + (d77 * d4);
        double d80 = dArr[i + 14] - dArr[i + 31];
        double d81 = dArr[i + 15] + dArr[i + 30];
        double d82 = (d3 * d80) - (d2 * d81);
        double d83 = (d80 * d2) + (d81 * d3);
        double d84 = d78 + d82;
        double d85 = d79 + d83;
        double d86 = d78 - d82;
        double d87 = d79 - d83;
        double d88 = dArr[i + 6] + dArr[i + 23];
        double d89 = dArr[i + 7] - dArr[i + 22];
        double d90 = (d3 * d88) + (d2 * d89);
        double d91 = (d3 * d89) - (d2 * d88);
        double d92 = dArr[i + 14] + dArr[i + 31];
        double d93 = dArr[i + 15] - dArr[i + 30];
        double d94 = (d5 * d92) - (d4 * d93);
        double d95 = (d92 * d4) + (d5 * d93);
        double d96 = d90 + d94;
        double d97 = d91 + d95;
        double d98 = d90 - d94;
        double d99 = d91 - d95;
        double d100 = d14 + d60;
        double d101 = d15 + d61;
        double d102 = d36 + d84;
        double d103 = d37 + d85;
        dArr[i + 0] = d100 + d102;
        dArr[i + 1] = d101 + d103;
        dArr[i + 2] = d100 - d102;
        dArr[i + 3] = d101 - d103;
        double d104 = d14 - d60;
        double d105 = d15 - d61;
        double d106 = d36 - d84;
        double d107 = d37 - d85;
        dArr[i + 4] = d104 - d107;
        dArr[i + 5] = d105 + d106;
        dArr[i + 6] = d104 + d107;
        dArr[i + 7] = d105 - d106;
        double d108 = d16 - d63;
        double d109 = d17 + d62;
        double d110 = d38 - d87;
        double d111 = d39 + d86;
        double d112 = (d110 - d111) * d;
        double d113 = (d110 + d111) * d;
        dArr[i + 8] = d108 + d112;
        dArr[i + 9] = d109 + d113;
        dArr[i + 10] = d108 - d112;
        dArr[i + 11] = d109 - d113;
        double d114 = d16 + d63;
        double d115 = d17 - d62;
        double d116 = d38 + d87;
        double d117 = d39 - d86;
        double d118 = (d116 - d117) * d;
        double d119 = (d116 + d117) * d;
        dArr[i + 12] = d114 - d119;
        dArr[i + 13] = d115 + d118;
        dArr[i + 14] = d114 + d119;
        dArr[i + 15] = d115 - d118;
        double d120 = d24 + d72;
        double d121 = d25 + d73;
        double d122 = d48 - d96;
        double d123 = d49 - d97;
        dArr[i + 16] = d120 + d122;
        dArr[i + 17] = d121 + d123;
        dArr[i + 18] = d120 - d122;
        dArr[i + 19] = d121 - d123;
        double d124 = d24 - d72;
        double d125 = d25 - d73;
        double d126 = d96 + d48;
        double d127 = d97 + d49;
        dArr[i + 20] = d124 - d127;
        dArr[i + 21] = d125 + d126;
        dArr[i + 22] = d124 + d127;
        dArr[i + 23] = d125 - d126;
        double d128 = d26 - d75;
        double d129 = d27 + d74;
        double d130 = d50 + d99;
        double d131 = d51 - d98;
        double d132 = (d130 - d131) * d;
        double d133 = (d130 + d131) * d;
        dArr[i + 24] = d128 + d132;
        dArr[i + 25] = d129 + d133;
        dArr[i + 26] = d128 - d132;
        dArr[i + 27] = d129 - d133;
        double d134 = d26 + d75;
        double d135 = d27 - d74;
        double d136 = d50 - d99;
        double d137 = d51 + d98;
        double d138 = (d136 - d137) * d;
        double d139 = d * (d136 + d137);
        dArr[i + 28] = d134 - d139;
        dArr[i + 29] = d135 + d138;
        dArr[i + 30] = d139 + d134;
        dArr[i + 31] = d135 - d138;
    }

    private void c(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        double d2 = dArr[i + 0] + dArr[i + 8];
        double d3 = dArr[i + 1] + dArr[i + 9];
        double d4 = dArr[i + 0] - dArr[i + 8];
        double d5 = dArr[i + 1] - dArr[i + 9];
        double d6 = dArr[i + 4] + dArr[i + 12];
        double d7 = dArr[i + 5] + dArr[i + 13];
        double d8 = dArr[i + 4] - dArr[i + 12];
        double d9 = dArr[i + 5] - dArr[i + 13];
        double d10 = d2 + d6;
        double d11 = d3 + d7;
        double d12 = d2 - d6;
        double d13 = d3 - d7;
        double d14 = d4 - d9;
        double d15 = d5 + d8;
        double d16 = d4 + d9;
        double d17 = d5 - d8;
        double d18 = dArr[i + 2] + dArr[i + 10];
        double d19 = dArr[i + 3] + dArr[i + 11];
        double d20 = dArr[i + 2] - dArr[i + 10];
        double d21 = dArr[i + 3] - dArr[i + 11];
        double d22 = dArr[i + 6] + dArr[i + 14];
        double d23 = dArr[i + 7] + dArr[i + 15];
        double d24 = dArr[i + 6] - dArr[i + 14];
        double d25 = dArr[i + 7] - dArr[i + 15];
        double d26 = d18 + d22;
        double d27 = d19 + d23;
        double d28 = d18 - d22;
        double d29 = d19 - d23;
        double d30 = d20 - d25;
        double d31 = d21 + d24;
        double d32 = d20 + d25;
        double d33 = d21 - d24;
        double d34 = (d30 - d31) * d;
        double d35 = (d30 + d31) * d;
        double d36 = (d32 - d33) * d;
        double d37 = d * (d32 + d33);
        dArr[i + 8] = d14 + d34;
        dArr[i + 9] = d15 + d35;
        dArr[i + 10] = d14 - d34;
        dArr[i + 11] = d15 - d35;
        dArr[i + 12] = d16 - d37;
        dArr[i + 13] = d17 + d36;
        dArr[i + 14] = d37 + d16;
        dArr[i + 15] = d17 - d36;
        dArr[i + 0] = d10 + d26;
        dArr[i + 1] = d11 + d27;
        dArr[i + 2] = d10 - d26;
        dArr[i + 3] = d11 - d27;
        dArr[i + 4] = d12 - d29;
        dArr[i + 5] = d13 + d28;
        dArr[i + 6] = d12 + d29;
        dArr[i + 7] = d13 - d28;
    }

    private void d(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        double d2 = dArr2[i2 + 4];
        double d3 = dArr2[i2 + 5];
        double d4 = dArr[i + 0] - dArr[i + 9];
        double d5 = dArr[i + 1] + dArr[i + 8];
        double d6 = dArr[i + 0] + dArr[i + 9];
        double d7 = dArr[i + 1] - dArr[i + 8];
        double d8 = dArr[i + 4] - dArr[i + 13];
        double d9 = dArr[i + 5] + dArr[i + 12];
        double d10 = (d8 - d9) * d;
        double d11 = (d8 + d9) * d;
        double d12 = dArr[i + 4] + dArr[i + 13];
        double d13 = dArr[i + 5] - dArr[i + 12];
        double d14 = (d12 - d13) * d;
        double d15 = d * (d12 + d13);
        double d16 = dArr[i + 2] - dArr[i + 11];
        double d17 = dArr[i + 3] + dArr[i + 10];
        double d18 = (d2 * d16) - (d3 * d17);
        double d19 = (d16 * d3) + (d17 * d2);
        double d20 = dArr[i + 2] + dArr[i + 11];
        double d21 = dArr[i + 3] - dArr[i + 10];
        double d22 = (d3 * d20) - (d2 * d21);
        double d23 = (d20 * d2) + (d21 * d3);
        double d24 = dArr[i + 6] - dArr[i + 15];
        double d25 = dArr[i + 7] + dArr[i + 14];
        double d26 = (d3 * d24) - (d2 * d25);
        double d27 = (d24 * d2) + (d25 * d3);
        double d28 = dArr[i + 6] + dArr[i + 15];
        double d29 = dArr[i + 7] - dArr[i + 14];
        double d30 = (d2 * d28) - (d3 * d29);
        double d31 = (d2 * d29) + (d3 * d28);
        double d32 = d4 + d10;
        double d33 = d5 + d11;
        double d34 = d18 + d26;
        double d35 = d19 + d27;
        dArr[i + 0] = d32 + d34;
        dArr[i + 1] = d33 + d35;
        dArr[i + 2] = d32 - d34;
        dArr[i + 3] = d33 - d35;
        double d36 = d4 - d10;
        double d37 = d5 - d11;
        double d38 = d18 - d26;
        double d39 = d19 - d27;
        dArr[i + 4] = d36 - d39;
        dArr[i + 5] = d37 + d38;
        dArr[i + 6] = d36 + d39;
        dArr[i + 7] = d37 - d38;
        double d40 = d6 - d15;
        double d41 = d7 + d14;
        double d42 = d22 - d30;
        double d43 = d23 - d31;
        dArr[i + 8] = d40 + d42;
        dArr[i + 9] = d41 + d43;
        dArr[i + 10] = d40 - d42;
        dArr[i + 11] = d41 - d43;
        double d44 = d15 + d6;
        double d45 = d7 - d14;
        double d46 = d22 + d30;
        double d47 = d31 + d23;
        dArr[i + 12] = d44 - d47;
        dArr[i + 13] = d45 + d46;
        dArr[i + 14] = d44 + d47;
        dArr[i + 15] = d45 - d46;
    }

    private void f(double[] dArr) {
        double d = dArr[0] + dArr[4];
        double d2 = dArr[1] + dArr[5];
        double d3 = dArr[0] - dArr[4];
        double d4 = dArr[1] - dArr[5];
        double d5 = dArr[2] + dArr[6];
        double d6 = dArr[3] + dArr[7];
        double d7 = dArr[2] - dArr[6];
        double d8 = dArr[3] - dArr[7];
        dArr[0] = d + d5;
        dArr[1] = d2 + d6;
        dArr[4] = d - d5;
        dArr[5] = d2 - d6;
        dArr[2] = d3 - d8;
        dArr[3] = d4 + d7;
        dArr[6] = d3 + d8;
        dArr[7] = d4 - d7;
    }

    private void g(double[] dArr) {
        double d = dArr[0] + dArr[4];
        double d2 = dArr[1] + dArr[5];
        double d3 = dArr[0] - dArr[4];
        double d4 = dArr[1] - dArr[5];
        double d5 = dArr[2] + dArr[6];
        double d6 = dArr[3] + dArr[7];
        double d7 = dArr[2] - dArr[6];
        double d8 = dArr[3] - dArr[7];
        dArr[0] = d + d5;
        dArr[1] = d2 + d6;
        dArr[4] = d - d5;
        dArr[5] = d2 - d6;
        dArr[2] = d3 + d8;
        dArr[3] = d4 - d7;
        dArr[6] = d3 - d8;
        dArr[7] = d4 + d7;
    }

    private void h(double[] dArr) {
        double d = dArr[0] - dArr[2];
        double d2 = dArr[1] - dArr[3];
        dArr[0] = dArr[0] + dArr[2];
        dArr[1] = dArr[1] + dArr[3];
        dArr[2] = d;
        dArr[3] = d2;
    }

    private void c(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = (i2 * 2) / i4;
        int i6 = 0;
        for (int i7 = 2; i7 < i4; i7 += 2) {
            int i8 = i - i7;
            i6 += i5;
            double d = 0.5d - dArr2[(i3 + i2) - i6];
            double d2 = dArr2[i3 + i6];
            double d3 = dArr[i7] - dArr[i8];
            double d4 = dArr[i7 + 1] + dArr[i8 + 1];
            double d5 = (d * d3) - (d2 * d4);
            double d6 = (d * d4) + (d2 * d3);
            dArr[i7] = dArr[i7] - d5;
            int i9 = i7 + 1;
            dArr[i9] = dArr[i9] - d6;
            dArr[i8] = dArr[i8] + d5;
            int i10 = i8 + 1;
            dArr[i10] = dArr[i10] - d6;
        }
    }

    private void d(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = (i2 * 2) / i4;
        int i6 = 0;
        for (int i7 = 2; i7 < i4; i7 += 2) {
            int i8 = i - i7;
            i6 += i5;
            double d = 0.5d - dArr2[(i3 + i2) - i6];
            double d2 = dArr2[i3 + i6];
            double d3 = dArr[i7] - dArr[i8];
            double d4 = dArr[i7 + 1] + dArr[i8 + 1];
            double d5 = (d * d3) + (d2 * d4);
            double d6 = (d * d4) - (d2 * d3);
            dArr[i7] = dArr[i7] - d5;
            int i9 = i7 + 1;
            dArr[i9] = dArr[i9] - d6;
            dArr[i8] = dArr[i8] + d5;
            int i10 = i8 + 1;
            dArr[i10] = dArr[i10] - d6;
        }
    }
}
