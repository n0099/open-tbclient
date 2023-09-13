package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
/* loaded from: classes9.dex */
public class zsa {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] q;
    public static final int[] r;
    public static final int[] s;
    public static final double[][] t;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteOrder a;
    public ata b;
    public double c;
    public double d;
    public int e;
    public double[][] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public double[] k;
    public int l;
    public boolean m;
    public int n;
    public long o;
    public long p;

    public final int a(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)})) == null) {
            return (int) (d >= 0.0d ? d + 0.5d : d - 0.5d);
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0437 A[LOOP:4: B:101:0x0433->B:103:0x0437, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0444 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x08e9 A[LOOP:14: B:268:0x08e7->B:269:0x08e9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x090b A[LOOP:15: B:271:0x0909->B:272:0x090b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x091c  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0925  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double d(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        InterceptResult invokeCommon;
        int i8;
        int i9;
        double d2;
        double d3;
        double d4;
        int i10;
        int i11;
        int[] iArr;
        int i12;
        double[] dArr;
        int i13;
        int i14;
        int[] iArr2;
        int i15;
        double[][] dArr2;
        int i16;
        int i17;
        int[] iArr3;
        int i18;
        zsa zsaVar;
        int i19;
        double[][] dArr3;
        int i20;
        ByteBuffer byteBuffer;
        double d5;
        int i21;
        int i22;
        ByteBuffer byteBuffer2;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        double[] dArr4;
        int i29;
        double d6;
        ByteBuffer byteBuffer3;
        zsa zsaVar2;
        ByteBuffer byteBuffer4;
        int i30;
        int i31;
        int a;
        char c;
        int i32;
        int i33;
        ByteBuffer byteBuffer5;
        int a2;
        char c2;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        double[] dArr5;
        int i40;
        double d7;
        ByteBuffer byteBuffer6;
        int i41;
        int a3;
        char c3;
        double[] dArr6;
        int i42;
        int i43;
        int i44;
        int i45;
        int i46;
        int i47;
        int i48;
        int i49;
        int i50;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{inputStream, outputStream, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Double.valueOf(d), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i7)})) == null) {
            int i51 = i5;
            double[] dArr7 = {0.0d};
            int i52 = this.e;
            double d8 = this.c;
            int e = e(i4, i51);
            int i53 = i51 / e;
            if (i53 == 1) {
                i8 = 1;
            } else if (i53 % 2 == 0) {
                i8 = 2;
            } else if (i53 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i53)));
            } else {
                i8 = 3;
            }
            int i54 = i4 * i8;
            double d9 = d8 <= 21.0d ? 0.9222d : (d8 - 7.95d) / 14.36d;
            int i55 = 1;
            while (true) {
                int i56 = i52 * i55;
                if (i56 % 2 == 0) {
                    i56--;
                }
                i9 = i56;
                d2 = i54;
                double d10 = (d2 * d9) / (i9 - 1);
                d3 = i51;
                d4 = (d3 - d10) / 2.0d;
                i10 = i8;
                if (d10 < this.d) {
                    break;
                }
                i55 *= 2;
                i51 = i5;
                d8 = d8;
                i8 = i10;
            }
            double b = b(d8);
            double a4 = vsa.a(b);
            int i57 = 1;
            while (i57 < i9) {
                i57 *= 2;
            }
            int i58 = i57 * 2;
            double[] dArr8 = new double[i58];
            int i59 = i9 / 2;
            int i60 = -i59;
            while (i60 <= i59) {
                int i61 = i60 + i59;
                int i62 = i59;
                int i63 = i60;
                int i64 = i9;
                double[] dArr9 = dArr8;
                int i65 = i9;
                int i66 = i58;
                dArr9[i61] = ((((o(i60, i64, b, a4) * g(i63, d4, d2)) * d2) / i4) / i66) * 2.0d;
                i60 = i63 + 1;
                i10 = i10;
                i58 = i66;
                dArr7 = dArr7;
                dArr8 = dArr9;
                i59 = i62;
                i9 = i65;
                i54 = i54;
            }
            int i67 = i60;
            double[] dArr10 = dArr8;
            double[] dArr11 = dArr7;
            int i68 = i54;
            int i69 = i9;
            int i70 = i58;
            int i71 = i10;
            int[] iArr4 = new int[(int) (Math.sqrt(i70) + 2.0d)];
            iArr4[0] = 0;
            int i72 = i70 / 2;
            double[] dArr12 = new double[i72];
            this.b.B(i70, 1, dArr10, iArr4, dArr12);
            if (i71 == 1) {
                int i73 = (i4 / e) * i51;
                int[] iArr5 = {i4 / i51};
                double[][] dArr13 = (double[][]) Array.newInstance(double.class, 1, 1);
                dArr13[0][0] = 1.0d;
                dArr = dArr12;
                iArr3 = new int[]{0};
                iArr = iArr4;
                i13 = i72;
                i12 = i70;
                i17 = 1;
                i15 = 1;
                dArr2 = dArr13;
                iArr2 = iArr5;
                i16 = i73;
                i18 = i67;
                i14 = 1;
            } else {
                double d11 = this.c;
                int i74 = (i4 / e) * i51;
                int i75 = i4 / 2;
                double[] dArr14 = dArr12;
                iArr = iArr4;
                int i76 = i72;
                i12 = i70;
                double d12 = (((i68 / 2) - i75) / 2.0d) + i75;
                double d13 = i74;
                int i77 = (int) (((d13 / ((i11 * 2) / 2.0d)) * (d11 > 21.0d ? (d11 - 7.95d) / 14.36d : 0.9222d)) + 1.0d);
                if (i77 % 2 == 0) {
                    i77++;
                }
                int i78 = i77;
                double b2 = b(d11);
                double a5 = vsa.a(b2);
                int i79 = i74 / i68;
                int i80 = (i78 / i79) + 1;
                int[] iArr6 = new int[i79];
                for (int i81 = 0; i81 < i79; i81++) {
                    iArr6[i81] = i79 - (((i74 / i51) * i81) % i79);
                    if (iArr6[i81] == i79) {
                        iArr6[i81] = 0;
                    }
                }
                int[] iArr7 = new int[i79];
                int i82 = 0;
                while (i82 < i79) {
                    iArr7[i82] = (((i74 / i51) - iArr6[i82]) / i79) + 1;
                    int i83 = i82 + 1;
                    if (iArr6[i83 == i79 ? 0 : i83] == 0) {
                        iArr7[i82] = iArr7[i82] - 1;
                    }
                    i82 = i83;
                }
                double[][] dArr15 = (double[][]) Array.newInstance(double.class, i79, i80);
                int i84 = i78 / 2;
                int i85 = -i84;
                while (i85 <= i84) {
                    int i86 = i85 + i84;
                    int i87 = i85;
                    double d14 = d13;
                    dArr15[i86 % i79][i86 / i79] = ((o(i85, i78, b2, a5) * g(i87, d12, d14)) * d14) / d2;
                    i85 = i87 + 1;
                    iArr7 = iArr7;
                    i84 = i84;
                    i74 = i74;
                    i79 = i79;
                    dArr14 = dArr14;
                    iArr6 = iArr6;
                    d13 = d14;
                    i76 = i76;
                }
                int i88 = i85;
                int[] iArr8 = iArr6;
                dArr = dArr14;
                i13 = i76;
                int i89 = i74;
                int i90 = i79;
                i14 = i78;
                iArr2 = iArr7;
                i15 = i80;
                dArr2 = dArr15;
                i16 = i89;
                i17 = i90;
                iArr3 = iArr8;
                i18 = i88;
            }
            k();
            double[][] dArr16 = (double[][]) Array.newInstance(double.class, i, i12);
            int i91 = i15 + 1;
            int i92 = i91 + i13;
            int i93 = i18;
            double[][] dArr17 = (double[][]) Array.newInstance(double.class, i, i92);
            int i94 = ((i13 / i71) + i71 + 1) * i;
            int i95 = i2;
            ByteBuffer allocate = ByteBuffer.allocate(i94 * i95);
            int i96 = i15;
            double[][] dArr18 = dArr2;
            int i97 = i91;
            int i98 = i17;
            double d15 = i4;
            double d16 = d15;
            double d17 = ((i13 * d3) / d15) + 1.0d;
            int i99 = i3 * i;
            int[] iArr9 = iArr2;
            double d18 = i99;
            int[] iArr10 = iArr3;
            int i100 = i13;
            ByteBuffer allocate2 = ByteBuffer.allocate((int) (d17 * d18));
            double[] dArr19 = new double[i94];
            double d19 = d18;
            double[] dArr20 = new double[(int) (i * d17)];
            int i101 = i99;
            int i102 = (int) (((i69 / 2.0d) / (d2 / d3)) + ((i14 / 2.0d) / (i16 / d3)));
            int i103 = i93;
            ByteBuffer byteBuffer7 = allocate;
            int i104 = 0;
            int i105 = 0;
            int i106 = 0;
            int i107 = 0;
            int i108 = 0;
            boolean z2 = true;
            int i109 = i6;
            int i110 = 0;
            while (true) {
                int i111 = (((i100 + 0) - 1) / i71) + 1;
                int i112 = i103;
                if (i111 + i104 > i109) {
                    i111 = i109 - i104;
                }
                byteBuffer7.position(0);
                int i113 = i95 * i;
                int i114 = i109;
                byteBuffer7.limit(i113 * i111);
                byte[] bArr = new byte[byteBuffer7.limit()];
                int i115 = i102;
                int read = inputStream.read(bArr);
                int i116 = i105;
                int i117 = read < 0 ? 0 : read;
                int i118 = i117 < byteBuffer7.limit() ? ((i117 / i95) * i) + i104 : i114;
                byteBuffer7.limit(i117);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.position(i117);
                wrap.flip();
                int i119 = i117 / i113;
                if (i95 == 1) {
                    zsaVar = this;
                    i19 = i106;
                    dArr3 = dArr17;
                    i20 = i16;
                    byteBuffer = allocate2;
                    d5 = d19;
                    i21 = i71;
                    i22 = 0;
                    while (i22 < i119 * i) {
                        dArr19[(i * 0) + i22] = ((wrap.get(i22) & 255) - 128) * 0.007874015748031496d;
                        i22++;
                        wrap = wrap;
                    }
                } else if (i95 != 2) {
                    if (i95 == 3) {
                        zsaVar = this;
                        i20 = i16;
                        byteBuffer = allocate2;
                        d5 = d19;
                        i22 = 0;
                        while (i22 < i119 * i) {
                            int i120 = i22 * 3;
                            dArr19[(i * 0) + i22] = (((wrap.get(i120 + 1) & 255) << 8) | ((wrap.get(i120) & 255) << 0) | ((wrap.get(i120 + 2) & 255) << 16)) * 1.1920930376163766E-7d;
                            i22++;
                            i71 = i71;
                            i106 = i106;
                        }
                        i19 = i106;
                        i21 = i71;
                        byteBuffer2 = wrap;
                    } else if (i95 != 4) {
                        zsaVar = this;
                        byteBuffer2 = wrap;
                        i19 = i106;
                        dArr3 = dArr17;
                        i20 = i16;
                        byteBuffer = allocate2;
                        d5 = d19;
                        i22 = i112;
                        i21 = i71;
                        while (i22 < i * i111) {
                            dArr19[i22] = 0.0d;
                            i22++;
                        }
                        int i121 = i104 + i119;
                        boolean z3 = inputStream.available() >= 0 || i121 >= i118;
                        int i122 = i108;
                        int i123 = i116;
                        i23 = 0;
                        while (i23 < i) {
                            int i124 = i100;
                            int i125 = 0;
                            int i126 = 0;
                            while (i125 < i124) {
                                dArr16[i23][i125] = dArr19[(i126 * i) + i23];
                                int i127 = i125 + 1;
                                while (true) {
                                    i50 = i125 + i21;
                                    if (i127 < i50) {
                                        dArr16[i23][i127] = 0.0d;
                                        i127++;
                                    }
                                }
                                i126++;
                                i125 = i50;
                            }
                            int i128 = i12;
                            for (int i129 = i124; i129 < i128; i129++) {
                                dArr16[i23][i129] = 0.0d;
                            }
                            zsaVar.b.B(i128, 1, dArr16[i23], iArr, dArr);
                            dArr16[i23][0] = dArr10[0] * dArr16[i23][0];
                            dArr16[i23][1] = dArr10[1] * dArr16[i23][1];
                            for (int i130 = 1; i130 < i124; i130++) {
                                int i131 = i130 * 2;
                                int i132 = i131 + 1;
                                dArr16[i23][i131] = (dArr10[i131] * dArr16[i23][i131]) - (dArr10[i132] * dArr16[i23][i132]);
                                dArr16[i23][i132] = (dArr10[i132] * dArr16[i23][i131]) + (dArr10[i131] * dArr16[i23][i132]);
                            }
                            zsaVar.b.B(i128, -1, dArr16[i23], iArr, dArr);
                            int i133 = 0;
                            while (i133 < i124) {
                                double[] dArr21 = dArr3[i23];
                                int i134 = i97 + i133;
                                dArr21[i134] = dArr21[i134] + dArr16[i23][i133];
                                i133++;
                            }
                            int i135 = i20 / i68;
                            int i136 = i107 / i135;
                            if (i107 % i135 != 0) {
                                i136++;
                            }
                            int length = (dArr3[0].length * i23) + i136;
                            int i137 = i133;
                            int i138 = i116;
                            int i139 = 0;
                            for (char c4 = 0; length - (dArr3[c4].length * i23) < i124 + 1; c4 = 0) {
                                int i140 = iArr10[i138];
                                int i141 = iArr9[i138] + length;
                                i138++;
                                int i142 = i128;
                                int i143 = i98;
                                if (i138 == i143) {
                                    i138 = 0;
                                }
                                i98 = i143;
                                double d20 = 0.0d;
                                int i144 = i96;
                                int i145 = 0;
                                while (i145 < i144) {
                                    d20 += dArr18[i140][i145] * dArr3[length / dArr3[0].length][length % dArr3[0].length];
                                    length++;
                                    i145++;
                                    i140 = i140;
                                    i138 = i138;
                                }
                                dArr20[0 + (i139 * i) + i23] = d20;
                                i139++;
                                i137 = i145;
                                i96 = i144;
                                length = i141;
                                i128 = i142;
                            }
                            i12 = i128;
                            i23++;
                            zsaVar = this;
                            i123 = i138;
                            i100 = i124;
                            i122 = i139;
                            i22 = i137;
                        }
                        int i146 = i96;
                        int i147 = i100;
                        int i148 = i107 + ((i20 / i5) * i122);
                        byteBuffer.clear();
                        if (z) {
                            i22 = 0;
                            while (i22 < i122 * i) {
                                double d21 = dArr20[i22] > 0.0d ? dArr20[i22] : -dArr20[i22];
                                if (dArr11[0] >= d21) {
                                    d21 = dArr11[0];
                                }
                                dArr11[0] = d21;
                                byteBuffer.asDoubleBuffer().put(i22, dArr20[i22]);
                                i22++;
                            }
                        } else {
                            if (i3 == 1) {
                                i24 = i101;
                                i25 = i147;
                                i26 = i146;
                                i27 = i123;
                                i28 = i21;
                                dArr4 = dArr19;
                                i29 = i98;
                                d6 = d16;
                                byteBuffer3 = byteBuffer;
                                zsaVar2 = this;
                                int i149 = i97;
                                byteBuffer4 = byteBuffer2;
                                i30 = i149;
                                double d22 = d * 127.0d;
                                i31 = 0;
                                int i150 = 0;
                                while (i31 < i122 * i) {
                                    if (i7 != 0) {
                                        a = c(dArr20[i31] * d22, dArr11, i7, i150);
                                    } else {
                                        a = zsaVar2.a(dArr20[i31] * d22);
                                        if (a < -128) {
                                            double d23 = a / (-128.0d);
                                            c = 0;
                                            if (dArr11[0] >= d23) {
                                                d23 = dArr11[0];
                                            }
                                            dArr11[0] = d23;
                                            a = -128;
                                        } else {
                                            c = 0;
                                        }
                                        if (127 < a) {
                                            double d24 = a / 127.0d;
                                            if (dArr11[c] >= d24) {
                                                d24 = dArr11[c];
                                            }
                                            dArr11[c] = d24;
                                            a = 127;
                                        }
                                    }
                                    byteBuffer3.put(i31, (byte) (a + 128));
                                    int i151 = i150 + 1;
                                    i150 = i151 == i ? 0 : i151;
                                    i31++;
                                }
                            } else if (i3 == 2) {
                                i24 = i101;
                                i25 = i147;
                                i26 = i146;
                                i27 = i123;
                                i28 = i21;
                                dArr4 = dArr19;
                                i29 = i98;
                                d6 = d16;
                                ByteBuffer byteBuffer8 = byteBuffer;
                                zsaVar2 = this;
                                int i152 = i97;
                                byteBuffer4 = byteBuffer2;
                                i30 = i152;
                                double d25 = d * 32767.0d;
                                int i153 = 0;
                                int i154 = 0;
                                while (i153 < i122 * i) {
                                    if (i7 != 0) {
                                        i33 = i153;
                                        byteBuffer5 = byteBuffer8;
                                        a2 = c(dArr20[i153] * d25, dArr11, i7, i154);
                                    } else {
                                        i33 = i153;
                                        byteBuffer5 = byteBuffer8;
                                        a2 = zsaVar2.a(dArr20[i33] * d25);
                                        if (a2 < -32768) {
                                            double d26 = a2 / (-32768.0d);
                                            c2 = 0;
                                            if (dArr11[0] >= d26) {
                                                d26 = dArr11[0];
                                            }
                                            dArr11[0] = d26;
                                            a2 = -32768;
                                        } else {
                                            c2 = 0;
                                        }
                                        if (32767 < a2) {
                                            double d27 = a2 / 32767.0d;
                                            if (dArr11[c2] >= d27) {
                                                d27 = dArr11[c2];
                                            }
                                            dArr11[c2] = d27;
                                            a2 = 32767;
                                        }
                                    }
                                    byteBuffer5.order(zsaVar2.a).asShortBuffer().put(i33, (short) a2);
                                    int i155 = i154 + 1;
                                    i154 = i155 == i ? 0 : i155;
                                    i153 = i33 + 1;
                                    byteBuffer8 = byteBuffer5;
                                }
                                i31 = i153;
                                byteBuffer3 = byteBuffer8;
                            } else if (i3 == 3) {
                                double d28 = d * 8388607.0d;
                                int i156 = 0;
                                int i157 = 0;
                                while (i156 < i122 * i) {
                                    if (i7 != 0) {
                                        i35 = i156;
                                        i38 = i123;
                                        i39 = i21;
                                        dArr5 = dArr19;
                                        d7 = d16;
                                        int i158 = i97;
                                        byteBuffer6 = byteBuffer2;
                                        i41 = i158;
                                        i34 = i101;
                                        i36 = i147;
                                        i40 = i98;
                                        i37 = i146;
                                        a3 = c(dArr20[i156] * d28, dArr11, i7, i157);
                                    } else {
                                        i34 = i101;
                                        i35 = i156;
                                        i36 = i147;
                                        i37 = i146;
                                        i38 = i123;
                                        i39 = i21;
                                        dArr5 = dArr19;
                                        i40 = i98;
                                        d7 = d16;
                                        int i159 = i97;
                                        byteBuffer6 = byteBuffer2;
                                        i41 = i159;
                                        a3 = a(dArr20[i35] * d28);
                                        if (a3 < -8388608) {
                                            double d29 = a3 / (-8388608.0d);
                                            c3 = 0;
                                            if (dArr11[0] >= d29) {
                                                d29 = dArr11[0];
                                            }
                                            dArr11[0] = d29;
                                            a3 = -8388608;
                                        } else {
                                            c3 = 0;
                                        }
                                        if (8388607 < a3) {
                                            double d30 = a3 / 8388607.0d;
                                            if (dArr11[c3] >= d30) {
                                                d30 = dArr11[c3];
                                            }
                                            dArr11[c3] = d30;
                                            a3 = 8388607;
                                        }
                                    }
                                    int i160 = i35 * 3;
                                    ByteBuffer byteBuffer9 = byteBuffer;
                                    byteBuffer9.put(i160, (byte) (a3 & 255));
                                    int i161 = a3 >> 8;
                                    byteBuffer9.put(i160 + 1, (byte) (i161 & 255));
                                    byteBuffer9.put(i160 + 2, (byte) ((i161 >> 8) & 255));
                                    int i162 = i157 + 1;
                                    i157 = i162 == i ? 0 : i162;
                                    i156 = i35 + 1;
                                    byteBuffer = byteBuffer9;
                                    i123 = i38;
                                    d16 = d7;
                                    dArr19 = dArr5;
                                    i21 = i39;
                                    i101 = i34;
                                    i98 = i40;
                                    i146 = i37;
                                    i147 = i36;
                                    ByteBuffer byteBuffer10 = byteBuffer6;
                                    i97 = i41;
                                    byteBuffer2 = byteBuffer10;
                                }
                                i24 = i101;
                                i25 = i147;
                                i26 = i146;
                                i27 = i123;
                                i28 = i21;
                                dArr4 = dArr19;
                                i29 = i98;
                                d6 = d16;
                                zsaVar2 = this;
                                int i163 = i97;
                                byteBuffer4 = byteBuffer2;
                                i30 = i163;
                                i32 = i156;
                                byteBuffer3 = byteBuffer;
                                if (z2) {
                                    dArr6 = dArr20;
                                    i42 = i118;
                                    i43 = i19;
                                    if (i122 < i115) {
                                        i102 = i115 - i122;
                                    } else if (z3) {
                                        double d31 = (i121 * d3) / d6;
                                        if (d31 + 2.0d > (i43 + i122) - i115) {
                                            byteBuffer3.position(i24 * i115);
                                            int i164 = i122 - i115;
                                            byteBuffer3.limit(i24 * i164);
                                            zsaVar2.p(outputStream, byteBuffer3);
                                            i43 += i164;
                                            i102 = i115;
                                        } else {
                                            byteBuffer3.position(i24 * i115);
                                            byteBuffer3.limit((int) (d5 * ((((Math.floor(d31) + 2.0d) + i43) + i122) - i115)));
                                            zsaVar2.p(outputStream, byteBuffer3);
                                            break;
                                        }
                                    } else {
                                        byteBuffer3.position(i24 * i115);
                                        byteBuffer3.limit(i24 * i122);
                                        zsaVar2.p(outputStream, byteBuffer3);
                                        i43 += i122 - i115;
                                        i102 = i115;
                                        z2 = false;
                                    }
                                } else {
                                    if (z3) {
                                        double d32 = (i121 * d3) / d6;
                                        i49 = i19 + i122;
                                        dArr6 = dArr20;
                                        i42 = i118;
                                        if (d32 + 2.0d > i49) {
                                            byteBuffer3.position(0);
                                            byteBuffer3.limit(i24 * i122);
                                            zsaVar2.p(outputStream, byteBuffer3);
                                        } else {
                                            byteBuffer3.position(0);
                                            int floor = (int) (d5 * ((Math.floor(d32) + 2.0d) - i19));
                                            if (floor > 0) {
                                                byteBuffer3.limit(floor);
                                                zsaVar2.p(outputStream, byteBuffer3);
                                            }
                                        }
                                    } else {
                                        dArr6 = dArr20;
                                        i42 = i118;
                                        byteBuffer3.position(0);
                                        byteBuffer3.limit(i24 * i122);
                                        zsaVar2.p(outputStream, byteBuffer3);
                                        i49 = i19 + i122;
                                    }
                                    i43 = i49;
                                    i102 = i115;
                                }
                                int i165 = i20 / i68;
                                i44 = (i148 - 1) / i165;
                                i45 = i25;
                                if (i44 > i45) {
                                    i44 = i45;
                                }
                                i46 = 0;
                                while (i46 < i) {
                                    System.arraycopy(dArr3[i46], i44, dArr3[i46], 0, i92 - i44);
                                    i46++;
                                    i32 = i32;
                                    i43 = i43;
                                }
                                int i166 = i32;
                                int i167 = i43;
                                i107 = i148 - (i44 * i165);
                                for (i47 = 0; i47 < i; i47++) {
                                    System.arraycopy(dArr16[i47], i45, dArr3[i47], i30, i45);
                                }
                                int i168 = i110 + 1;
                                if ((i110 & 7) == 7) {
                                    i48 = i42;
                                    zsaVar2.l(i121 / i48);
                                } else {
                                    i48 = i42;
                                }
                                i103 = i166;
                                i109 = i48;
                                i110 = i168;
                                i104 = i121;
                                i100 = i45;
                                dArr20 = dArr6;
                                allocate2 = byteBuffer3;
                                i106 = i167;
                                i105 = i27;
                                byteBuffer7 = byteBuffer4;
                                d16 = d6;
                                dArr19 = dArr4;
                                i71 = i28;
                                i101 = i24;
                                i98 = i29;
                                i96 = i26;
                                d19 = d5;
                                dArr17 = dArr3;
                                i108 = i122;
                                i97 = i30;
                                i16 = i20;
                                i95 = i2;
                            }
                            i32 = i31;
                            if (z2) {
                            }
                            int i1652 = i20 / i68;
                            i44 = (i148 - 1) / i1652;
                            i45 = i25;
                            if (i44 > i45) {
                            }
                            i46 = 0;
                            while (i46 < i) {
                            }
                            int i1662 = i32;
                            int i1672 = i43;
                            i107 = i148 - (i44 * i1652);
                            while (i47 < i) {
                            }
                            int i1682 = i110 + 1;
                            if ((i110 & 7) == 7) {
                            }
                            i103 = i1662;
                            i109 = i48;
                            i110 = i1682;
                            i104 = i121;
                            i100 = i45;
                            dArr20 = dArr6;
                            allocate2 = byteBuffer3;
                            i106 = i1672;
                            i105 = i27;
                            byteBuffer7 = byteBuffer4;
                            d16 = d6;
                            dArr19 = dArr4;
                            i71 = i28;
                            i101 = i24;
                            i98 = i29;
                            i96 = i26;
                            d19 = d5;
                            dArr17 = dArr3;
                            i108 = i122;
                            i97 = i30;
                            i16 = i20;
                            i95 = i2;
                        }
                        i24 = i101;
                        i32 = i22;
                        i25 = i147;
                        i26 = i146;
                        i27 = i123;
                        i28 = i21;
                        dArr4 = dArr19;
                        i29 = i98;
                        d6 = d16;
                        byteBuffer3 = byteBuffer;
                        zsaVar2 = this;
                        int i169 = i97;
                        byteBuffer4 = byteBuffer2;
                        i30 = i169;
                        if (z2) {
                        }
                        int i16522 = i20 / i68;
                        i44 = (i148 - 1) / i16522;
                        i45 = i25;
                        if (i44 > i45) {
                        }
                        i46 = 0;
                        while (i46 < i) {
                        }
                        int i16622 = i32;
                        int i16722 = i43;
                        i107 = i148 - (i44 * i16522);
                        while (i47 < i) {
                        }
                        int i16822 = i110 + 1;
                        if ((i110 & 7) == 7) {
                        }
                        i103 = i16622;
                        i109 = i48;
                        i110 = i16822;
                        i104 = i121;
                        i100 = i45;
                        dArr20 = dArr6;
                        allocate2 = byteBuffer3;
                        i106 = i16722;
                        i105 = i27;
                        byteBuffer7 = byteBuffer4;
                        d16 = d6;
                        dArr19 = dArr4;
                        i71 = i28;
                        i101 = i24;
                        i98 = i29;
                        i96 = i26;
                        d19 = d5;
                        dArr17 = dArr3;
                        i108 = i122;
                        i97 = i30;
                        i16 = i20;
                        i95 = i2;
                    } else {
                        i22 = 0;
                        while (i22 < i119 * i) {
                            dArr19[(i * 0) + i22] = wrap.order(this.a).getInt(i22) * 4.656612875245797E-10d;
                            i22++;
                            d19 = d19;
                            i16 = i16;
                            allocate2 = allocate2;
                        }
                        zsaVar = this;
                        i20 = i16;
                        byteBuffer = allocate2;
                        d5 = d19;
                        byteBuffer2 = wrap;
                        i19 = i106;
                        i21 = i71;
                    }
                    dArr3 = dArr17;
                    while (i22 < i * i111) {
                    }
                    int i1212 = i104 + i119;
                    if (inputStream.available() >= 0) {
                    }
                    int i1222 = i108;
                    int i1232 = i116;
                    i23 = 0;
                    while (i23 < i) {
                    }
                    int i1462 = i96;
                    int i1472 = i100;
                    int i1482 = i107 + ((i20 / i5) * i1222);
                    byteBuffer.clear();
                    if (z) {
                    }
                    i24 = i101;
                    i32 = i22;
                    i25 = i1472;
                    i26 = i1462;
                    i27 = i1232;
                    i28 = i21;
                    dArr4 = dArr19;
                    i29 = i98;
                    d6 = d16;
                    byteBuffer3 = byteBuffer;
                    zsaVar2 = this;
                    int i1692 = i97;
                    byteBuffer4 = byteBuffer2;
                    i30 = i1692;
                    if (z2) {
                    }
                    int i165222 = i20 / i68;
                    i44 = (i1482 - 1) / i165222;
                    i45 = i25;
                    if (i44 > i45) {
                    }
                    i46 = 0;
                    while (i46 < i) {
                    }
                    int i166222 = i32;
                    int i167222 = i43;
                    i107 = i1482 - (i44 * i165222);
                    while (i47 < i) {
                    }
                    int i168222 = i110 + 1;
                    if ((i110 & 7) == 7) {
                    }
                    i103 = i166222;
                    i109 = i48;
                    i110 = i168222;
                    i104 = i1212;
                    i100 = i45;
                    dArr20 = dArr6;
                    allocate2 = byteBuffer3;
                    i106 = i167222;
                    i105 = i27;
                    byteBuffer7 = byteBuffer4;
                    d16 = d6;
                    dArr19 = dArr4;
                    i71 = i28;
                    i101 = i24;
                    i98 = i29;
                    i96 = i26;
                    d19 = d5;
                    dArr17 = dArr3;
                    i108 = i1222;
                    i97 = i30;
                    i16 = i20;
                    i95 = i2;
                } else {
                    zsaVar = this;
                    i19 = i106;
                    i20 = i16;
                    byteBuffer = allocate2;
                    d5 = d19;
                    i21 = i71;
                    i22 = 0;
                    while (i22 < i119 * i) {
                        dArr19[(i * 0) + i22] = wrap.order(zsaVar.a).asShortBuffer().get(i22) * 3.051850947599719E-5d;
                        i22++;
                        dArr17 = dArr17;
                    }
                    dArr3 = dArr17;
                }
                byteBuffer2 = wrap;
                while (i22 < i * i111) {
                }
                int i12122 = i104 + i119;
                if (inputStream.available() >= 0) {
                }
                int i12222 = i108;
                int i12322 = i116;
                i23 = 0;
                while (i23 < i) {
                }
                int i14622 = i96;
                int i14722 = i100;
                int i14822 = i107 + ((i20 / i5) * i12222);
                byteBuffer.clear();
                if (z) {
                }
                i24 = i101;
                i32 = i22;
                i25 = i14722;
                i26 = i14622;
                i27 = i12322;
                i28 = i21;
                dArr4 = dArr19;
                i29 = i98;
                d6 = d16;
                byteBuffer3 = byteBuffer;
                zsaVar2 = this;
                int i16922 = i97;
                byteBuffer4 = byteBuffer2;
                i30 = i16922;
                if (z2) {
                }
                int i1652222 = i20 / i68;
                i44 = (i14822 - 1) / i1652222;
                i45 = i25;
                if (i44 > i45) {
                }
                i46 = 0;
                while (i46 < i) {
                }
                int i1662222 = i32;
                int i1672222 = i43;
                i107 = i14822 - (i44 * i1652222);
                while (i47 < i) {
                }
                int i1682222 = i110 + 1;
                if ((i110 & 7) == 7) {
                }
                i103 = i1662222;
                i109 = i48;
                i110 = i1682222;
                i104 = i12122;
                i100 = i45;
                dArr20 = dArr6;
                allocate2 = byteBuffer3;
                i106 = i1672222;
                i105 = i27;
                byteBuffer7 = byteBuffer4;
                d16 = d6;
                dArr19 = dArr4;
                i71 = i28;
                i101 = i24;
                i98 = i29;
                i96 = i26;
                d19 = d5;
                dArr17 = dArr3;
                i108 = i12222;
                i97 = i30;
                i16 = i20;
                i95 = i2;
            }
            zsaVar2.l(1.0d);
            return dArr11[0];
        }
        return invokeCommon.doubleValue;
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:247:0x0854  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x095c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double n(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        InterceptResult invokeCommon;
        int i8;
        int i9;
        double d2;
        double d3;
        int i10;
        double d4;
        int i11;
        int i12;
        ByteBuffer byteBuffer;
        int i13;
        ByteBuffer byteBuffer2;
        int i14;
        double[] dArr;
        double[] dArr2;
        double d5;
        int i15;
        int i16;
        int i17;
        ByteBuffer byteBuffer3;
        int i18;
        int i19;
        int a;
        char c;
        int i20;
        int i21;
        int i22;
        ByteBuffer byteBuffer4;
        int a2;
        char c2;
        int i23;
        double[] dArr3;
        double[] dArr4;
        double d6;
        int i24;
        int i25;
        int i26;
        int i27;
        int a3;
        char c3;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{inputStream, outputStream, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Double.valueOf(d), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i7)})) == null) {
            zsa zsaVar = this;
            Class<double> cls = double.class;
            double[] dArr5 = {0.0d};
            int i36 = zsaVar.e;
            double d7 = zsaVar.c;
            int e = i4 / zsaVar.e(i4, i5);
            int i37 = e * i5;
            int i38 = i37 / i5;
            if (i38 == 1) {
                i8 = 1;
            } else if (i38 % 2 == 0) {
                i8 = 2;
            } else if (i38 % 3 != 0) {
                throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i38)));
            } else {
                i8 = 3;
            }
            int i39 = i5 * i8;
            int i40 = i4 / 2;
            double d8 = (i9 * 2) / 2.0d;
            double d9 = i40;
            int i41 = i36;
            double d10 = d9 + (((i39 / 2) - i40) / 2.0d);
            if (d7 <= 21.0d) {
                d3 = d9;
                d2 = 0.9222d;
            } else {
                d2 = (d7 - 7.95d) / 14.36d;
                d3 = d9;
            }
            double d11 = i37;
            int i42 = (int) (((d11 / d8) * d2) + 1.0d);
            if (i42 % 2 == 0) {
                i42++;
            }
            int i43 = i42;
            double b = zsaVar.b(d7);
            double a4 = vsa.a(b);
            int i44 = i37 / i4;
            int i45 = (i43 / i44) + 1;
            int i46 = i44 * i8;
            int[] iArr = new int[i46];
            for (int i47 = 0; i47 < i46; i47++) {
                iArr[i47] = i44 - (((i37 / i39) * i47) % i44);
                if (iArr[i47] == i44) {
                    iArr[i47] = 0;
                }
            }
            int[] iArr2 = new int[i46];
            int i48 = 0;
            while (i48 < i46) {
                int i49 = i46;
                double[] dArr6 = dArr5;
                iArr2[i48] = iArr[i48] < i37 / i39 ? i : 0;
                if (iArr[i48] == i44) {
                    iArr[i48] = 0;
                }
                i48++;
                i46 = i49;
                dArr5 = dArr6;
            }
            int i50 = i46;
            double[] dArr7 = dArr5;
            double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) cls, i44, i45);
            int i51 = i43 / 2;
            int i52 = -i51;
            while (i52 <= i51) {
                int i53 = i52 + i51;
                int i54 = i50;
                int i55 = i52;
                dArr8[i53 % i44][i53 / i44] = ((o(i52, i43, b, a4) * g(i55, d10, d11)) * d11) / i4;
                i52 = i55 + 1;
                zsaVar = this;
                i39 = i39;
                i45 = i45;
                iArr2 = iArr2;
                i43 = i43;
                i51 = i51;
                i37 = i37;
                iArr = iArr;
                i50 = i54;
                i41 = i41;
            }
            int[] iArr3 = iArr;
            int i56 = i45;
            int i57 = i37;
            int i58 = i39;
            int i59 = i51;
            int[] iArr4 = iArr2;
            zsa zsaVar2 = zsaVar;
            int i60 = i41;
            int i61 = i50;
            double d12 = zsaVar2.c;
            double d13 = d12 > 21.0d ? (d12 - 7.95d) / 14.36d : 0.9222d;
            int i62 = 1;
            while (true) {
                int i63 = i60 * i62;
                if (i63 % 2 == 0) {
                    i63--;
                }
                i10 = i63;
                d4 = i58;
                if ((d4 * d13) / (i10 - 1) < zsaVar2.d) {
                    break;
                }
                i62 *= 2;
                zsaVar2 = zsaVar2;
                i61 = i61;
                cls = cls;
            }
            double b2 = zsaVar2.b(d12);
            double a5 = vsa.a(b2);
            int i64 = 1;
            while (i64 < i10) {
                i64 *= 2;
            }
            int i65 = i64 * 2;
            double[] dArr9 = new double[i65];
            int i66 = i10 / 2;
            int i67 = -i66;
            while (i67 <= i66) {
                double d14 = d4;
                double[] dArr10 = dArr9;
                int i68 = i67;
                double d15 = b2;
                double d16 = b2;
                zsa zsaVar3 = zsaVar2;
                int i69 = i65;
                double o = o(i67, i10, d15, a5);
                d4 = d14;
                dArr10[i67 + i66] = ((o * g(i68, d3, d4)) / i69) * 2.0d;
                i67 = i68 + 1;
                zsaVar2 = zsaVar3;
                i65 = i69;
                i66 = i66;
                b2 = d16;
                dArr9 = dArr10;
            }
            int i70 = i67;
            double[] dArr11 = dArr9;
            double d17 = d4;
            zsa zsaVar4 = zsaVar2;
            int i71 = i65;
            int[] iArr5 = new int[(int) (Math.sqrt(i71) + 2.0d)];
            iArr5[0] = 0;
            int i72 = i71 / 2;
            double[] dArr12 = new double[i72];
            zsaVar4.b.B(i71, 1, dArr11, iArr5, dArr12);
            k();
            int i73 = (i72 / i8) + 1;
            int[] iArr6 = {r4, i73};
            int i74 = i;
            double[][] dArr13 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            double[][] dArr14 = (double[][]) Array.newInstance((Class<?>) cls, i74, i71);
            int i75 = (i72 + i56 + 2) * i74;
            int i76 = i2;
            ByteBuffer allocate = ByteBuffer.allocate(i75 * i76);
            int i77 = i73 * i74;
            ByteBuffer allocate2 = ByteBuffer.allocate(i77 * i3);
            double[] dArr15 = new double[i75];
            double[] dArr16 = new double[i77];
            int i78 = i56;
            int i79 = (int) ((i10 / 2.0d) / (i58 / i5));
            int i80 = (i59 / i44) + 1;
            ByteBuffer byteBuffer5 = allocate;
            int i81 = 0;
            int i82 = 0;
            int i83 = 0;
            int i84 = 0;
            int i85 = 0;
            int i86 = 0;
            boolean z2 = true;
            int i87 = i6;
            int i88 = 0;
            while (true) {
                double[] dArr17 = dArr16;
                double[] dArr18 = dArr15;
                double d18 = i4;
                double d19 = d18;
                int ceil = (int) (((Math.ceil((i72 * d18) / d17) + 1.0d) + i78) - i80);
                int i89 = ceil + i81 > i87 ? i87 - i81 : ceil;
                byteBuffer5.position(0);
                int i90 = i76 * i74;
                byteBuffer5.limit(i89 * i90);
                byte[] bArr = new byte[byteBuffer5.limit()];
                int read = inputStream.read(bArr);
                int i91 = i87;
                int i92 = read < 0 ? 0 : read;
                int i93 = i92 < byteBuffer5.limit() ? ((i92 / i76) * i74) + i81 : i91;
                byteBuffer5.limit(i92);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.position(i92);
                wrap.flip();
                int i94 = i92 / i90;
                if (i76 != 1) {
                    if (i76 == 2) {
                        i12 = i71;
                        byteBuffer = allocate2;
                        i13 = 0;
                        while (i13 < i94 * i74) {
                            dArr18[(i74 * i80) + i13] = wrap.order(zsaVar4.a).asShortBuffer().get(i13) * 3.051850947599719E-5d;
                            i13++;
                            zsaVar4 = this;
                            i72 = i72;
                        }
                    } else if (i76 == 3) {
                        byteBuffer = allocate2;
                        i13 = 0;
                        while (i13 < i94 * i74) {
                            int i95 = i13 * 3;
                            dArr18[(i74 * i80) + i13] = ((wrap.get(i95 + 1) << 8) | (wrap.get(i95) << 0) | (wrap.get(i95 + 2) << 16)) * 1.1920930376163766E-7d;
                            i13++;
                            i71 = i71;
                        }
                        i12 = i71;
                    } else if (i76 != 4) {
                        i11 = i72;
                        i12 = i71;
                        i13 = i70;
                        byteBuffer = allocate2;
                    } else {
                        i13 = 0;
                        while (i13 < i94 * i74) {
                            dArr18[(i74 * i80) + i13] = wrap.order(zsaVar4.a).asIntBuffer().get(i13) * 4.656612875245797E-10d;
                            i13++;
                            allocate2 = allocate2;
                        }
                        byteBuffer = allocate2;
                        i11 = i72;
                        i12 = i71;
                    }
                    i11 = i72;
                } else {
                    i11 = i72;
                    i12 = i71;
                    byteBuffer = allocate2;
                    i13 = 0;
                    while (i13 < i94 * i74) {
                        dArr18[(i74 * i80) + i13] = (wrap.get(i13) - 128.0d) * 0.007874015748031496d;
                        i13++;
                    }
                }
                while (i13 < i74 * ceil) {
                    dArr18[(i74 * i80) + i13] = 0.0d;
                    i13++;
                }
                int i96 = i80 + ceil;
                i81 += i94;
                boolean z3 = i81 >= i93;
                int i97 = ((((i82 - 1) * i4) + i57) / i57) * i74;
                int i98 = i83;
                int i99 = i84;
                int i100 = i85;
                int i101 = 0;
                while (i101 < i74) {
                    int i102 = i97 + i101;
                    if (i78 == 7) {
                        i33 = i61;
                        i34 = i11;
                        i35 = i84;
                        for (int i103 = 0; i103 < i34; i103++) {
                            int i104 = iArr3[i35];
                            dArr14[i101][i103] = (dArr8[i104][0] * dArr18[i102 + (i74 * 0)]) + (dArr8[i104][1] * dArr18[i102 + (i74 * 1)]) + (dArr8[i104][2] * dArr18[i102 + (i74 * 2)]) + (dArr8[i104][3] * dArr18[i102 + (i74 * 3)]) + (dArr8[i104][4] * dArr18[i102 + (i74 * 4)]) + (dArr8[i104][5] * dArr18[i102 + (i74 * 5)]) + (dArr8[i104][6] * dArr18[i102 + (i74 * 6)]);
                            i102 += iArr4[i35];
                            i35++;
                            if (i35 == i33) {
                                i35 = 0;
                            }
                        }
                    } else if (i78 != 9) {
                        i35 = i84;
                        i34 = i11;
                        int i105 = 0;
                        while (i105 < i34) {
                            int i106 = iArr3[i35];
                            int i107 = i102;
                            double d20 = 0.0d;
                            for (int i108 = 0; i108 < i78; i108++) {
                                d20 += dArr8[i106][i108] * dArr18[i107];
                                i107 += i74;
                            }
                            dArr14[i101][i105] = d20;
                            i102 += iArr4[i35];
                            i35++;
                            int i109 = i61;
                            if (i35 == i109) {
                                i35 = 0;
                            }
                            i105++;
                            i61 = i109;
                        }
                        i33 = i61;
                    } else {
                        i33 = i61;
                        i34 = i11;
                        i35 = i84;
                        for (int i110 = 0; i110 < i34; i110++) {
                            int i111 = iArr3[i35];
                            dArr14[i101][i110] = (dArr8[i111][0] * dArr18[i102 + (i74 * 0)]) + (dArr8[i111][1] * dArr18[i102 + (i74 * 1)]) + (dArr8[i111][2] * dArr18[i102 + (i74 * 2)]) + (dArr8[i111][3] * dArr18[i102 + (i74 * 3)]) + (dArr8[i111][4] * dArr18[i102 + (i74 * 4)]) + (dArr8[i111][5] * dArr18[i102 + (i74 * 5)]) + (dArr8[i111][6] * dArr18[i102 + (i74 * 6)]) + (dArr8[i111][7] * dArr18[i102 + (i74 * 7)]) + (dArr8[i111][8] * dArr18[i102 + (i74 * 8)]);
                            i102 += iArr4[i35];
                            i35++;
                            if (i35 == i33) {
                                i35 = 0;
                            }
                        }
                    }
                    int i112 = i12;
                    for (int i113 = i34; i113 < i112; i113++) {
                        dArr14[i101][i113] = 0.0d;
                    }
                    this.b.B(i112, 1, dArr14[i101], iArr5, dArr12);
                    dArr14[i101][0] = dArr11[0] * dArr14[i101][0];
                    dArr14[i101][1] = dArr11[1] * dArr14[i101][1];
                    for (int i114 = 1; i114 < i34; i114++) {
                        int i115 = i114 * 2;
                        int i116 = i115 + 1;
                        dArr14[i101][i115] = (dArr11[i115] * dArr14[i101][i115]) - (dArr11[i116] * dArr14[i101][i116]);
                        dArr14[i101][i116] = (dArr11[i116] * dArr14[i101][i115]) + (dArr11[i115] * dArr14[i101][i116]);
                    }
                    this.b.B(i112, -1, dArr14[i101], iArr5, dArr12);
                    int i117 = i97;
                    int i118 = i85;
                    int i119 = 0;
                    while (i118 < i34) {
                        dArr17[i101 + (i119 * i74)] = dArr13[i101][i119] + dArr14[i101][i118];
                        i118 += i8;
                        i119++;
                    }
                    int i120 = i118 - i34;
                    int i121 = 0;
                    while (i118 < i112) {
                        dArr13[i101][i121] = dArr14[i101][i118];
                        i118 += i8;
                        i121++;
                    }
                    i101++;
                    i13 = i118;
                    i12 = i112;
                    i11 = i34;
                    i99 = i35;
                    i61 = i33;
                    i98 = i119;
                    i97 = i117;
                    i100 = i120;
                }
                int i122 = i61;
                int i123 = i12;
                int i124 = i11;
                int i125 = i82 + ((i124 * e) / i8);
                byteBuffer.clear();
                if (z) {
                    int i126 = 0;
                    while (i126 < i98 * i74) {
                        double d21 = dArr17[i126] > 0.0d ? dArr17[i126] : -dArr17[i126];
                        if (dArr7[0] >= d21) {
                            d21 = dArr7[0];
                        }
                        dArr7[0] = d21;
                        byteBuffer.asDoubleBuffer().put(i126, dArr17[i126]);
                        i126++;
                        wrap = wrap;
                    }
                    byteBuffer2 = wrap;
                    i14 = i99;
                    dArr = dArr18;
                    dArr2 = dArr17;
                    d5 = d19;
                    i15 = i74;
                    i16 = i100;
                    i17 = i78;
                    byteBuffer3 = byteBuffer;
                    i19 = i126;
                } else {
                    byteBuffer2 = wrap;
                    if (i3 == 1) {
                        i14 = i99;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d5 = d19;
                        i15 = i74;
                        i16 = i100;
                        i17 = i78;
                        byteBuffer3 = byteBuffer;
                        i18 = i123;
                        double d22 = d * 127.0d;
                        i19 = 0;
                        int i127 = 0;
                        while (i19 < i98 * i15) {
                            if (i7 != 0) {
                                a = c(dArr2[i19] * d22, dArr7, i7, i127);
                            } else {
                                a = a(dArr2[i19] * d22);
                                if (a < -128) {
                                    double d23 = a / (-128.0d);
                                    c = 0;
                                    if (dArr7[0] >= d23) {
                                        d23 = dArr7[0];
                                    }
                                    dArr7[0] = d23;
                                    a = -128;
                                } else {
                                    c = 0;
                                }
                                if (127 < a) {
                                    double d24 = a / 127.0d;
                                    if (dArr7[c] >= d24) {
                                        d24 = dArr7[c];
                                    }
                                    dArr7[c] = d24;
                                    a = 127;
                                }
                            }
                            byteBuffer3.put(i19, (byte) (a + 128));
                            int i128 = i127 + 1;
                            i127 = i128 == i15 ? 0 : i128;
                            i19++;
                        }
                    } else if (i3 == 2) {
                        i14 = i99;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d5 = d19;
                        i15 = i74;
                        i16 = i100;
                        int i129 = i123;
                        ByteBuffer byteBuffer6 = byteBuffer;
                        double d25 = d * 32767.0d;
                        int i130 = 0;
                        int i131 = 0;
                        while (i130 < i98 * i15) {
                            if (i7 != 0) {
                                i20 = i129;
                                i22 = i130;
                                i21 = i78;
                                byteBuffer4 = byteBuffer6;
                                a2 = c(dArr2[i130] * d25, dArr7, i7, i131);
                            } else {
                                i20 = i129;
                                i21 = i78;
                                i22 = i130;
                                byteBuffer4 = byteBuffer6;
                                a2 = a(dArr2[i22] * d25);
                                if (a2 < -32768) {
                                    double d26 = a2 / (-32768.0d);
                                    c2 = 0;
                                    if (dArr7[0] >= d26) {
                                        d26 = dArr7[0];
                                    }
                                    dArr7[0] = d26;
                                    a2 = -32768;
                                } else {
                                    c2 = 0;
                                }
                                if (32767 < a2) {
                                    double d27 = a2 / 32767.0d;
                                    if (dArr7[c2] >= d27) {
                                        d27 = dArr7[c2];
                                    }
                                    dArr7[c2] = d27;
                                    a2 = 32767;
                                }
                            }
                            byteBuffer4.order(this.a).asShortBuffer().put(i22, (short) a2);
                            int i132 = i131 + 1;
                            i131 = i132 == i15 ? 0 : i132;
                            i130 = i22 + 1;
                            byteBuffer6 = byteBuffer4;
                            i129 = i20;
                            i78 = i21;
                        }
                        i18 = i129;
                        i17 = i78;
                        i19 = i130;
                        byteBuffer3 = byteBuffer6;
                    } else if (i3 != 3) {
                        i14 = i99;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d5 = d19;
                        i15 = i74;
                        i16 = i100;
                        i17 = i78;
                        byteBuffer3 = byteBuffer;
                        i19 = i13;
                    } else {
                        double d28 = d * 8388607.0d;
                        int i133 = 0;
                        int i134 = 0;
                        while (i133 < i98 * i74) {
                            if (i7 != 0) {
                                i23 = i99;
                                dArr4 = dArr17;
                                d6 = d19;
                                i26 = i100;
                                dArr3 = dArr18;
                                i24 = i133;
                                i25 = i74;
                                i27 = i123;
                                a3 = c(dArr17[i133] * d28, dArr7, i7, i134);
                            } else {
                                i23 = i99;
                                dArr3 = dArr18;
                                dArr4 = dArr17;
                                d6 = d19;
                                i24 = i133;
                                i25 = i74;
                                i26 = i100;
                                i27 = i123;
                                a3 = a(dArr4[i24] * d28);
                                if (a3 < -8388608) {
                                    double d29 = a3 / (-8388608.0d);
                                    c3 = 0;
                                    if (dArr7[0] >= d29) {
                                        d29 = dArr7[0];
                                    }
                                    dArr7[0] = d29;
                                    a3 = -8388608;
                                } else {
                                    c3 = 0;
                                }
                                if (8388607 < a3) {
                                    double d30 = a3 / 8388607.0d;
                                    if (dArr7[c3] >= d30) {
                                        d30 = dArr7[c3];
                                    }
                                    dArr7[c3] = d30;
                                    a3 = 8388607;
                                }
                            }
                            int i135 = i24 * 3;
                            ByteBuffer byteBuffer7 = byteBuffer;
                            byteBuffer7.put(i135, (byte) (a3 & 255));
                            int i136 = a3 >> 8;
                            byteBuffer7.put(i135 + 1, (byte) (i136 & 255));
                            byteBuffer7.put(i135 + 2, (byte) ((i136 >> 8) & 255));
                            int i137 = i134 + 1;
                            i134 = i137 == i25 ? 0 : i137;
                            i133 = i24 + 1;
                            byteBuffer = byteBuffer7;
                            i74 = i25;
                            i123 = i27;
                            i99 = i23;
                            i100 = i26;
                            dArr18 = dArr3;
                            d19 = d6;
                            dArr17 = dArr4;
                        }
                        i14 = i99;
                        dArr = dArr18;
                        dArr2 = dArr17;
                        d5 = d19;
                        i15 = i74;
                        i16 = i100;
                        i19 = i133;
                        i17 = i78;
                        byteBuffer3 = byteBuffer;
                    }
                    if (z2) {
                        if (z3) {
                            double d31 = (i81 * i5) / d5;
                            int i138 = i88 + i98;
                            i28 = i93;
                            if (d31 + 2.0d > i138) {
                                byteBuffer3.position(0);
                                byteBuffer3.limit(i3 * i15 * i98);
                                p(outputStream, byteBuffer3);
                                i31 = i138;
                            } else {
                                byteBuffer3.position(0);
                                int floor = (int) (i3 * i15 * ((Math.floor(d31) + 2.0d) - i88));
                                if (floor > 0) {
                                    byteBuffer3.limit(floor);
                                    p(outputStream, byteBuffer3);
                                }
                            }
                        } else {
                            i28 = i93;
                            byteBuffer3.position(0);
                            byteBuffer3.limit(i3 * i15 * i98);
                            p(outputStream, byteBuffer3);
                            i31 = i88 + i98;
                        }
                        i29 = i19;
                        i30 = i96;
                    } else {
                        int i139 = i88;
                        i28 = i93;
                        int i140 = i79;
                        if (i98 < i140) {
                            i79 = i140 - i98;
                            i31 = i139;
                            i29 = i19;
                            i30 = i96;
                        } else if (z3) {
                            double d32 = (i81 * i5) / d5;
                            i29 = i19;
                            i30 = i96;
                            if (d32 + 2.0d > (i139 + i98) - i140) {
                                int i141 = i3 * i15;
                                byteBuffer3.position(i141 * i140);
                                byteBuffer3.limit(i141 * i98);
                                p(outputStream, byteBuffer3);
                                i31 = (i98 - i140) + i139;
                                i79 = i140;
                            } else {
                                int i142 = i3 * i15;
                                byteBuffer3.position(i140 * i142);
                                byteBuffer3.limit((int) (i142 * ((Math.floor(d32) + 2.0d) - i139)));
                                p(outputStream, byteBuffer3);
                                break;
                            }
                        } else {
                            i29 = i19;
                            i30 = i96;
                            int i143 = i3 * i15;
                            byteBuffer3.position(i143 * i140);
                            byteBuffer3.limit(i143 * i98);
                            p(outputStream, byteBuffer3);
                            i31 = (i98 - i140) + i139;
                            i79 = i140;
                            z2 = false;
                            int i144 = (i125 - 1) / i44;
                            i80 = i30 - i144;
                            double[] dArr19 = dArr;
                            System.arraycopy(dArr19, i15 * i144, dArr19, 0, i15 * i80);
                            i82 = i125 - (i144 * i44);
                            int i145 = i86 + 1;
                            if ((i86 & 7) == 7) {
                                i32 = i28;
                                l(i81 / i32);
                            } else {
                                i32 = i28;
                            }
                            i88 = i31;
                            i86 = i145;
                            dArr15 = dArr19;
                            i74 = i15;
                            i87 = i32;
                            zsaVar4 = this;
                            byteBuffer5 = byteBuffer2;
                            i61 = i122;
                            i72 = i124;
                            i71 = i18;
                            dArr16 = dArr2;
                            i84 = i14;
                            i85 = i16;
                            i76 = i2;
                            i83 = i98;
                            i70 = i29;
                            allocate2 = byteBuffer3;
                            i78 = i17;
                        }
                    }
                    int i1442 = (i125 - 1) / i44;
                    i80 = i30 - i1442;
                    double[] dArr192 = dArr;
                    System.arraycopy(dArr192, i15 * i1442, dArr192, 0, i15 * i80);
                    i82 = i125 - (i1442 * i44);
                    int i1452 = i86 + 1;
                    if ((i86 & 7) == 7) {
                    }
                    i88 = i31;
                    i86 = i1452;
                    dArr15 = dArr192;
                    i74 = i15;
                    i87 = i32;
                    zsaVar4 = this;
                    byteBuffer5 = byteBuffer2;
                    i61 = i122;
                    i72 = i124;
                    i71 = i18;
                    dArr16 = dArr2;
                    i84 = i14;
                    i85 = i16;
                    i76 = i2;
                    i83 = i98;
                    i70 = i29;
                    allocate2 = byteBuffer3;
                    i78 = i17;
                }
                i18 = i123;
                if (z2) {
                }
                int i14422 = (i125 - 1) / i44;
                i80 = i30 - i14422;
                double[] dArr1922 = dArr;
                System.arraycopy(dArr1922, i15 * i14422, dArr1922, 0, i15 * i80);
                i82 = i125 - (i14422 * i44);
                int i14522 = i86 + 1;
                if ((i86 & 7) == 7) {
                }
                i88 = i31;
                i86 = i14522;
                dArr15 = dArr1922;
                i74 = i15;
                i87 = i32;
                zsaVar4 = this;
                byteBuffer5 = byteBuffer2;
                i61 = i122;
                i72 = i124;
                i71 = i18;
                dArr16 = dArr2;
                i84 = i14;
                i85 = i16;
                i76 = i2;
                i83 = i98;
                i70 = i29;
                allocate2 = byteBuffer3;
                i78 = i17;
            }
            l(1.0d);
            return dArr7[0];
        }
        return invokeCommon.doubleValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948371905, "Lcom/baidu/tieba/zsa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948371905, "Lcom/baidu/tieba/zsa;");
                return;
            }
        }
        q = new int[]{0, OpusReader.SAMPLE_RATE, 44100, 37800, 32000, 22050, OpusReader.SAMPLE_RATE, 44100};
        r = new int[]{1, 16, 20, 16, 16, 15, 16, 15};
        s = new int[]{8, 18, 27, 8, 8, 8, 10, 9};
        t = new double[][]{new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zsa(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, int i6, double d, int i7, boolean z) throws Exception {
        int i8;
        int i9;
        int i10;
        double[] dArr;
        double d2;
        int i11;
        String str;
        int i12;
        double[] dArr2;
        int i13;
        int i14;
        zsa zsaVar;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {inputStream, outputStream, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Double.valueOf(d), Integer.valueOf(i7), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i21 = newInitContext.flag;
            if ((i21 & 1) != 0) {
                int i22 = i21 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ByteOrder.LITTLE_ENDIAN;
        this.b = new ata();
        this.c = 150.0d;
        this.d = 200.0d;
        this.e = 1;
        this.m = false;
        double[] dArr3 = {0.0d};
        if (i7 >= 0 && i7 <= 4) {
            this.m = z;
            if (!z) {
                System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
            }
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
            }
            int i23 = i4;
            if (i23 == -1) {
                if (i3 != 1) {
                    i23 = i3;
                } else {
                    i23 = 2;
                }
                if (i23 == 4) {
                    i8 = i2;
                    i23 = 3;
                    i8 = i8 == -1 ? i : i8;
                    if (i7 != -1) {
                        if (i23 < i3) {
                            if (i23 == 1) {
                                i9 = 4;
                            } else {
                                i9 = 3;
                            }
                        } else {
                            i9 = 1;
                        }
                    } else {
                        i9 = i7;
                    }
                    String str2 = "\n";
                    if (this.m) {
                        String[] strArr = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
                        String[] strArr2 = {"rectangular", "triangular", "gaussian"};
                        dArr = dArr3;
                        System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i), Integer.valueOf(i8));
                        System.err.printf("attenuation : %gdB\n", Double.valueOf(d));
                        System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i3 * 8), Integer.valueOf(i23 * 8));
                        System.err.printf("nchannels : %d\n", Integer.valueOf(i5));
                        i10 = i23;
                        System.err.printf("length : %d bytes, %g secs\n", Integer.valueOf(i6), Double.valueOf(((i6 / i3) / i5) / i));
                        if (i9 == 0) {
                            i20 = 0;
                            System.err.printf("dither type : none\n", new Object[0]);
                        } else {
                            i20 = 0;
                            System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr[i9], strArr2[0], Double.valueOf(0.18d));
                        }
                        str2 = "\n";
                        System.err.printf(str2, new Object[i20]);
                    } else {
                        i10 = i23;
                        dArr = dArr3;
                    }
                    if (i9 == 0) {
                        int i24 = i10;
                        if (i24 == 1) {
                            i17 = -128;
                            i15 = 127;
                            i16 = 2;
                        } else {
                            i15 = 0;
                            i16 = 2;
                            i17 = 0;
                        }
                        if (i24 == i16) {
                            i17 = -32768;
                            i15 = 32767;
                        }
                        if (i24 == 3) {
                            i17 = -8388608;
                            i15 = 8388607;
                        }
                        if (i24 == 4) {
                            i19 = Integer.MIN_VALUE;
                            i18 = Integer.MAX_VALUE;
                        } else {
                            i18 = i15;
                            i19 = i17;
                        }
                        str = str2;
                        i12 = i24;
                        dArr2 = dArr;
                        d2 = d;
                        i11 = i8;
                        h(i8, i5, i19, i18, i9, 0, 0.18d);
                    } else {
                        d2 = d;
                        i11 = i8;
                        str = str2;
                        i12 = i10;
                        dArr2 = dArr;
                    }
                    if (i >= i11) {
                        int i25 = i11;
                        i13 = i5;
                        dArr2[0] = n(inputStream, outputStream, i5, i3, i12, i, i25, Math.pow(10.0d, (-d2) / 20.0d), (i6 / i3) / i13, false, i9);
                    } else {
                        int i26 = i11;
                        i13 = i5;
                        if (i > i26) {
                            dArr2[0] = d(inputStream, outputStream, i5, i3, i12, i, i26, Math.pow(10.0d, (-d2) / 20.0d), (i6 / i3) / i13, false, i9);
                        } else {
                            i14 = 0;
                            dArr2[0] = i(inputStream, outputStream, i5, i3, i12, Math.pow(10.0d, (-d2) / 20.0d), (i6 / i3) / i13, false, i9);
                            zsaVar = this;
                            if (!zsaVar.m) {
                                System.err.printf(str, new Object[i14]);
                            }
                            if (i9 != 0) {
                                zsaVar.j(i13);
                            }
                            if (dArr2[i14] > 1.0d && !zsaVar.m) {
                                PrintStream printStream = System.err;
                                Object[] objArr2 = new Object[1];
                                objArr2[i14] = Double.valueOf(Math.log10(dArr2[i14]) * 20.0d);
                                printStream.printf("clipping detected : %gdB\n", objArr2);
                                return;
                            }
                            return;
                        }
                    }
                    zsaVar = this;
                    i14 = 0;
                    if (!zsaVar.m) {
                    }
                    if (i9 != 0) {
                    }
                    if (dArr2[i14] > 1.0d) {
                        return;
                    }
                    return;
                }
            }
            i8 = i2;
            if (i8 == -1) {
            }
            if (i7 != -1) {
            }
            String str22 = "\n";
            if (this.m) {
            }
            if (i9 == 0) {
            }
            if (i >= i11) {
            }
            zsaVar = this;
            i14 = 0;
            if (!zsaVar.m) {
            }
            if (i9 != 0) {
            }
            if (dArr2[i14] > 1.0d) {
            }
        } else {
            throw new IllegalArgumentException("unrecognized dither type : " + i7);
        }
    }

    public final double b(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)})) == null) {
            if (d <= 21.0d) {
                return 0.0d;
            }
            if (d <= 50.0d) {
                double d2 = d - 21.0d;
                return (Math.pow(d2, 0.4d) * 0.5842d) + (d2 * 0.07886d);
            }
            return (d - 8.7d) * 0.1102d;
        }
        return invokeCommon.doubleValue;
    }

    public int c(double d, double[] dArr, int i, int i2) {
        InterceptResult invokeCommon;
        int i3;
        double a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), dArr, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i == 1) {
                double[] dArr2 = this.k;
                int i4 = this.l;
                this.l = i4 + 1;
                double d2 = d + dArr2[i4 & 65535];
                int i5 = this.i;
                if (d2 < i5) {
                    double d3 = d2 / i5;
                    if (dArr[0] >= d3) {
                        d3 = dArr[0];
                    }
                    dArr[0] = d3;
                    d2 = this.i;
                }
                int i6 = this.j;
                if (d2 > i6) {
                    double d4 = d2 / i6;
                    if (dArr[0] >= d4) {
                        d4 = dArr[0];
                    }
                    dArr[0] = d4;
                    d2 = this.j;
                }
                return a(d2);
            }
            double d5 = 0.0d;
            int i7 = 0;
            while (true) {
                i3 = this.h;
                if (i7 >= i3) {
                    break;
                }
                d5 += t[this.g][i7] * this.f[i2][i7];
                i7++;
            }
            double d6 = d + d5;
            double[] dArr3 = this.k;
            int i8 = this.l;
            this.l = i8 + 1;
            double d7 = dArr3[65535 & i8] + d6;
            for (int i9 = i3 - 2; i9 >= 0; i9--) {
                double[][] dArr4 = this.f;
                dArr4[i2][i9 + 1] = dArr4[i2][i9];
            }
            int i10 = this.i;
            if (d7 < i10) {
                double d8 = d7 / i10;
                if (dArr[0] >= d8) {
                    d8 = dArr[0];
                }
                dArr[0] = d8;
                a = this.i;
                double[][] dArr5 = this.f;
                dArr5[i2][0] = a - d6;
                if (dArr5[i2][0] > 1.0d) {
                    dArr5[i2][0] = 1.0d;
                }
                double[][] dArr6 = this.f;
                if (dArr6[i2][0] < -1.0d) {
                    dArr6[i2][0] = -1.0d;
                }
            } else {
                int i11 = this.j;
                if (d7 > i11) {
                    double d9 = d7 / i11;
                    if (dArr[0] >= d9) {
                        d9 = dArr[0];
                    }
                    dArr[0] = d9;
                    a = this.j;
                    double[][] dArr7 = this.f;
                    dArr7[i2][0] = a - d6;
                    if (dArr7[i2][0] > 1.0d) {
                        dArr7[i2][0] = 1.0d;
                    }
                    double[][] dArr8 = this.f;
                    if (dArr8[i2][0] < -1.0d) {
                        dArr8[i2][0] = -1.0d;
                    }
                } else {
                    a = a(d7);
                    this.f[i2][0] = a - d6;
                }
            }
            return (int) a;
        }
        return invokeCommon.intValue;
    }

    public final int e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(1048580, this, i, i2)) != null) {
            return invokeII.intValue;
        }
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i != 0) {
                i2 = i4 % i;
            } else {
                return i4;
            }
        }
    }

    public void p(OutputStream outputStream, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, outputStream, byteBuffer) == null) {
            try {
                outputStream.write(f(byteBuffer));
            } catch (IOException unused) {
            }
        }
    }

    public byte[] f(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteBuffer)) == null) {
            int limit = byteBuffer.limit() - byteBuffer.position();
            byte[] bArr = new byte[limit];
            byteBuffer.get(bArr, 0, limit);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final double m(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Double.valueOf(d)})) == null) {
            if (d == 0.0d) {
                return 1.0d;
            }
            return Math.sin(d) / d;
        }
        return invokeCommon.doubleValue;
    }

    public final double g(int i, double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)})) == null) {
            double d3 = 1.0d / d2;
            return d * 2.0d * d3 * m(i * 6.283185307179586d * d * d3);
        }
        return invokeCommon.doubleValue;
    }

    public int h(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Double.valueOf(d)})) == null) {
            int[] iArr = new int[97];
            int i7 = 1;
            while (i7 < 6 && i != q[i7]) {
                i7++;
            }
            if ((i5 == 3 || i5 == 4) && i7 == 6) {
                System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i));
            }
            i7 = (i5 == 2 || i7 == 6) ? 0 : 0;
            if (i5 == 4 && (i7 == 1 || i7 == 2)) {
                i7 += 5;
            }
            this.g = i7;
            this.f = new double[i2];
            this.h = r[i7];
            for (int i8 = 0; i8 < i2; i8++) {
                this.f[i8] = new double[this.h];
            }
            this.i = i3;
            this.j = i4;
            this.k = new double[65536];
            Random random = new Random(System.currentTimeMillis());
            for (int i9 = 0; i9 < 97; i9++) {
                iArr[i9] = random.nextInt();
            }
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        boolean z = false;
                        double d2 = 0.0d;
                        double d3 = 0.0d;
                        for (int i10 = 0; i10 < 65536; i10++) {
                            if (!z) {
                                int nextInt = random.nextInt() % 97;
                                double d4 = iArr[nextInt] / 2.147483647E9d;
                                iArr[nextInt] = random.nextInt();
                                if (d4 == 1.0d) {
                                    d4 = 0.0d;
                                }
                                d2 = Math.sqrt(Math.log(1.0d - d4) * (-2.0d));
                                int nextInt2 = random.nextInt() % 97;
                                iArr[nextInt2] = random.nextInt();
                                d3 = 6.283185307179586d * (iArr[nextInt2] / 2.147483647E9d);
                                this.k[i10] = d * d2 * Math.cos(d3);
                                z = true;
                            } else {
                                this.k[i10] = d * d2 * Math.sin(d3);
                                z = false;
                            }
                        }
                    }
                } else {
                    for (int i11 = 0; i11 < 65536; i11++) {
                        int nextInt3 = random.nextInt() % 97;
                        int i12 = iArr[nextInt3];
                        iArr[nextInt3] = random.nextInt();
                        int nextInt4 = random.nextInt() % 97;
                        int i13 = iArr[nextInt4];
                        iArr[nextInt4] = random.nextInt();
                        this.k[i11] = d * ((i12 / 2.147483647E9d) - (i13 / 2.147483647E9d));
                    }
                }
            } else {
                for (int i14 = 0; i14 < 65536; i14++) {
                    int nextInt5 = random.nextInt() % 97;
                    int i15 = iArr[nextInt5];
                    iArr[nextInt5] = random.nextInt();
                    this.k[i14] = ((i15 / 2.147483647E9d) - 0.5d) * d;
                }
            }
            this.l = 0;
            if (i5 == 0 || i5 == 1) {
                return 1;
            }
            return s[this.g];
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0260 A[EDGE_INSN: B:75:0x0260->B:68:0x0260 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double i(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, double d, int i4, boolean z, int i5) throws IOException {
        InterceptResult invokeCommon;
        ByteBuffer byteBuffer;
        double[] dArr;
        int i6;
        int i7;
        ByteBuffer wrap;
        double d2;
        ByteBuffer byteBuffer2;
        double d3;
        int i8;
        double d4;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        int a;
        int a2;
        int i9;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{inputStream, outputStream, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)})) == null) {
            int i10 = 1;
            int i11 = 0;
            double[] dArr2 = {0.0d};
            k();
            if (z) {
                byteBuffer = ByteBuffer.allocate(8);
            } else {
                byteBuffer = null;
            }
            ByteBuffer byteBuffer5 = byteBuffer;
            int i12 = 4;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            int i13 = 0;
            int i14 = 0;
            while (true) {
                int i15 = i4 * i;
                if (i13 < i15) {
                    if (i2 != i10) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != i12) {
                                    byteBuffer2 = allocate;
                                    i6 = i15;
                                    i7 = i13;
                                    dArr = dArr2;
                                    d3 = 0.0d;
                                } else {
                                    allocate.position(i11);
                                    allocate.limit(i12);
                                    byte[] bArr = new byte[allocate.limit()];
                                    inputStream.read(bArr);
                                    wrap = ByteBuffer.wrap(bArr);
                                    wrap.position(wrap.limit());
                                    wrap.flip();
                                    dArr = dArr2;
                                    d2 = wrap.order(this.a).asIntBuffer().get(i11) * 4.656612875245797E-10d;
                                    i6 = i15;
                                    i7 = i13;
                                }
                            } else {
                                dArr = dArr2;
                                allocate.position(i11);
                                allocate.limit(3);
                                byte[] bArr2 = new byte[allocate.limit()];
                                inputStream.read(bArr2);
                                ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
                                wrap2.position(wrap2.limit());
                                wrap2.flip();
                                i6 = i15;
                                d3 = 1.1920930376163766E-7d * (((wrap2.get(1) & 255) << 8) | ((wrap2.get(i11) & 255) << i11) | ((wrap2.get(2) & 255) << 16));
                                byteBuffer2 = wrap2;
                                i7 = i13;
                            }
                            if (inputStream.available() != 0) {
                                break;
                            }
                            double d5 = d3 * d;
                            if (!z) {
                                if (i3 != 1) {
                                    if (i3 != 2) {
                                        if (i3 != 3) {
                                            i8 = i6;
                                            byteBuffer4 = byteBuffer5;
                                        } else {
                                            double d6 = d5 * 8388607.0d;
                                            if (i5 != 0) {
                                                i8 = i6;
                                                i9 = 3;
                                                byteBuffer4 = byteBuffer5;
                                                a3 = c(d6, dArr, i5, i14);
                                            } else {
                                                i8 = i6;
                                                byteBuffer4 = byteBuffer5;
                                                i9 = 3;
                                                a3 = a(d6);
                                            }
                                            byteBuffer2.position(0);
                                            byteBuffer2.limit(i9);
                                            byteBuffer2.put(0, (byte) (a3 & 255));
                                            int i16 = a3 >> 8;
                                            byteBuffer2.put(1, (byte) (i16 & 255));
                                            byteBuffer2.put(2, (byte) ((i16 >> 8) & 255));
                                            byteBuffer2.flip();
                                            p(outputStream, byteBuffer2);
                                        }
                                    } else {
                                        i8 = i6;
                                        byteBuffer4 = byteBuffer5;
                                        double d7 = d5 * 32767.0d;
                                        if (i5 != 0) {
                                            a2 = c(d7, dArr, i5, i14);
                                        } else {
                                            a2 = a(d7);
                                        }
                                        byteBuffer2.position(0);
                                        byteBuffer2.limit(2);
                                        byteBuffer2.asShortBuffer().put(0, (short) a2);
                                        byteBuffer2.flip();
                                        p(outputStream, byteBuffer2);
                                    }
                                } else {
                                    i8 = i6;
                                    byteBuffer4 = byteBuffer5;
                                    double d8 = d5 * 127.0d;
                                    if (i5 != 0) {
                                        a = c(d8, dArr, i5, i14);
                                    } else {
                                        a = a(d8);
                                    }
                                    byteBuffer2.position(0);
                                    byteBuffer2.limit(1);
                                    byteBuffer2.put(0, (byte) (a + 128));
                                    byteBuffer2.flip();
                                    p(outputStream, byteBuffer2);
                                }
                                byteBuffer3 = byteBuffer4;
                            } else {
                                i8 = i6;
                                ByteBuffer byteBuffer6 = byteBuffer5;
                                if (d5 > 0.0d) {
                                    d4 = d5;
                                } else {
                                    d4 = -d5;
                                }
                                if (dArr[0] >= d4) {
                                    d4 = dArr[0];
                                }
                                dArr[0] = d4;
                                byteBuffer3 = byteBuffer6;
                                byteBuffer3.position(0);
                                byteBuffer3.putDouble(d5);
                                byteBuffer3.flip();
                                p(outputStream, byteBuffer3);
                            }
                            int i17 = i14 + 1;
                            if (i17 == i) {
                                i14 = 0;
                            } else {
                                i14 = i17;
                            }
                            int i18 = i7 + 1;
                            if ((262143 & i18) == 0) {
                                l(i18 / i8);
                            }
                            byteBuffer5 = byteBuffer3;
                            dArr2 = dArr;
                            i12 = 4;
                            i11 = 0;
                            i13 = i18;
                            allocate = byteBuffer2;
                            i10 = 1;
                        } else {
                            i6 = i15;
                            dArr = dArr2;
                            allocate.position(0);
                            allocate.limit(2);
                            byte[] bArr3 = new byte[allocate.limit()];
                            inputStream.read(bArr3);
                            wrap = ByteBuffer.wrap(bArr3);
                            wrap.position(wrap.limit());
                            wrap.flip();
                            i7 = i13;
                            d2 = 3.051850947599719E-5d * wrap.order(this.a).asShortBuffer().get(0);
                        }
                    } else {
                        i6 = i15;
                        i7 = i13;
                        dArr = dArr2;
                        allocate.position(0);
                        allocate.limit(1);
                        byte[] bArr4 = new byte[allocate.limit()];
                        inputStream.read(bArr4);
                        wrap = ByteBuffer.wrap(bArr4);
                        wrap.position(wrap.limit());
                        wrap.flip();
                        d2 = (wrap.get(0) - 128) * 0.007874015748031496d;
                    }
                    double d9 = d2;
                    byteBuffer2 = wrap;
                    d3 = d9;
                    if (inputStream.available() != 0) {
                    }
                } else {
                    dArr = dArr2;
                    break;
                }
            }
            l(1.0d);
            return dArr[0];
        }
        return invokeCommon.doubleValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o = System.currentTimeMillis();
            this.p = 0L;
            this.n = -1;
        }
    }

    public final void l(double d) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d)}) != null) || this.m) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        if (d == 0.0d) {
            i = 0;
        } else {
            i = (int) ((currentTimeMillis * (1.0d - d)) / d);
        }
        int i2 = (int) (d * 100.0d);
        if (i2 != this.n || currentTimeMillis != this.p) {
            System.err.printf(" %3d%% processed", Integer.valueOf(i2));
            this.n = i2;
        }
        if (currentTimeMillis != this.p) {
            System.err.printf(", ETA =%4dmsec", Integer.valueOf(i));
            this.p = currentTimeMillis;
        }
        System.err.printf("\r", new Object[0]);
        System.err.flush();
    }

    public final double o(double d, int i, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            double d4 = 4.0d * d * d;
            double d5 = i - 1.0d;
            return vsa.a(d2 * Math.sqrt(1.0d - (d4 / (d5 * d5)))) / d3;
        }
        return invokeCommon.doubleValue;
    }
}
