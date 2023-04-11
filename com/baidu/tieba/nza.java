package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes5.dex */
public final class nza {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948021140, "Lcom/baidu/tieba/nza;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948021140, "Lcom/baidu/tieba/nza;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(tza tzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, tzaVar) == null) {
            kza kzaVar = tzaVar.c;
            byte[] bArr = tzaVar.d;
            int i = tzaVar.g;
            if (i <= 0) {
                kza.k(kzaVar);
                tzaVar.a = 1;
                return;
            }
            int min = Math.min(tzaVar.Q - tzaVar.r, i);
            kza.c(kzaVar, bArr, tzaVar.r, min);
            tzaVar.g -= min;
            int i2 = tzaVar.r + min;
            tzaVar.r = i2;
            int i3 = tzaVar.Q;
            if (i2 == i3) {
                tzaVar.b = 5;
                tzaVar.Y = i3;
                tzaVar.X = 0;
                tzaVar.a = 12;
                return;
            }
            kza.k(kzaVar);
            tzaVar.a = 1;
        }
    }

    public static void k(tza tzaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, tzaVar) == null) {
            int i2 = tzaVar.P;
            long j = tzaVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + tzaVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!tzaVar.h && i2 < 16384 && tzaVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = tzaVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = tzaVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = tzaVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = tzaVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(tzaVar.S, i, bArr, 0, i5);
                    tzaVar.r = i5;
                    tzaVar.T = i5;
                }
            }
            tzaVar.d = bArr;
            tzaVar.Q = i2;
        }
    }

    public static boolean u(tza tzaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tzaVar)) == null) {
            int i = tzaVar.T;
            if (i != 0) {
                tzaVar.X += i;
                tzaVar.T = 0;
            }
            int min = Math.min(tzaVar.V - tzaVar.W, tzaVar.Y - tzaVar.X);
            if (min != 0) {
                System.arraycopy(tzaVar.d, tzaVar.X, tzaVar.Z, tzaVar.U + tzaVar.W, min);
                tzaVar.W += min;
                tzaVar.X += min;
            }
            if (tzaVar.W >= tzaVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(tza tzaVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, tzaVar, i) == null) {
            kza kzaVar = tzaVar.c;
            int[] iArr = tzaVar.p;
            int i3 = i * 2;
            kza.d(kzaVar);
            int i4 = i * 1080;
            int r = r(tzaVar.e, i4, kzaVar);
            tzaVar.n[i] = m(tzaVar.f, i4, kzaVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = tzaVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(tza tzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, tzaVar) == null) {
            b(tzaVar, 1);
            tzaVar.F = tzaVar.l.c[tzaVar.p[3]];
        }
    }

    public static void e(tza tzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, tzaVar) == null) {
            b(tzaVar, 2);
            tzaVar.C = tzaVar.p[5] << 2;
        }
    }

    public static int h(kza kzaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, kzaVar)) == null) {
            if (kza.i(kzaVar, 1) != 0) {
                int i = kza.i(kzaVar, 3);
                if (i == 0) {
                    return 1;
                }
                return kza.i(kzaVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, kza kzaVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, kzaVar)) == null) {
            kza.j(kzaVar);
            int h = h(kzaVar) + 1;
            if (h == 1) {
                vza.a(bArr, 0, i);
                return h;
            }
            if (kza.i(kzaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = kza.i(kzaVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, kzaVar);
            int i3 = 0;
            while (i3 < i) {
                kza.j(kzaVar);
                kza.d(kzaVar);
                int r = r(iArr, 0, kzaVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + kza.i(kzaVar, r); i4 != 0; i4--) {
                        if (i3 < i) {
                            bArr[i3] = 0;
                            i3++;
                        } else {
                            throw new BrotliRuntimeException("Corrupted context map");
                        }
                    }
                    continue;
                } else {
                    bArr[i3] = (byte) (r - i2);
                }
                i3++;
            }
            if (kza.i(kzaVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(tza tzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, tzaVar) == null) {
            b(tzaVar, 0);
            int i = tzaVar.p[1];
            int i2 = i << 6;
            tzaVar.B = i2;
            int i3 = tzaVar.A[i2] & 255;
            tzaVar.v = i3;
            tzaVar.w = tzaVar.k.c[i3];
            byte b2 = tzaVar.z[i];
            int[] iArr = mza.b;
            tzaVar.D = iArr[b2];
            tzaVar.E = iArr[b2 + 1];
        }
    }

    public static void g(kza kzaVar, tza tzaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, kzaVar, tzaVar) == null) {
            boolean z2 = true;
            if (kza.i(kzaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            tzaVar.h = z;
            tzaVar.g = 0;
            tzaVar.i = false;
            tzaVar.j = false;
            if (z && kza.i(kzaVar, 1) != 0) {
                return;
            }
            int i = kza.i(kzaVar, 2) + 4;
            if (i == 7) {
                tzaVar.j = true;
                if (kza.i(kzaVar, 1) == 0) {
                    int i2 = kza.i(kzaVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = kza.i(kzaVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        tzaVar.g = (i4 << (i3 * 8)) | tzaVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = kza.i(kzaVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    tzaVar.g = (i6 << (i5 * 4)) | tzaVar.g;
                }
            }
            tzaVar.g++;
            if (!tzaVar.h) {
                if (kza.i(kzaVar, 1) != 1) {
                    z2 = false;
                }
                tzaVar.i = z2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0310 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142 A[LOOP:2: B:50:0x0142->B:56:0x0178, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(tza tzaVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, tzaVar) == null) {
            int i8 = tzaVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    kza kzaVar = tzaVar.c;
                    int i9 = tzaVar.Q - 1;
                    byte[] bArr = tzaVar.d;
                    while (true) {
                        int i10 = tzaVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (tzaVar.g >= 0) {
                                            q(tzaVar);
                                            i9 = tzaVar.Q - 1;
                                            bArr = tzaVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(tzaVar);
                                        tzaVar.a = 3;
                                        if (tzaVar.g > 0) {
                                            tzaVar.a = 1;
                                            break;
                                        } else {
                                            kza.j(kzaVar);
                                            if (tzaVar.n[1] == 0) {
                                                c(tzaVar);
                                            }
                                            int[] iArr = tzaVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            kza.d(kzaVar);
                                            int r = r(tzaVar.l.b, tzaVar.F, kzaVar);
                                            int i12 = r >>> 6;
                                            tzaVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                tzaVar.G = -1;
                                            }
                                            int i13 = sza.g[i12] + ((r >>> 3) & 7);
                                            int i14 = sza.h[i12] + (r & 7);
                                            tzaVar.y = sza.c[i13] + kza.i(kzaVar, sza.d[i13]);
                                            tzaVar.M = sza.e[i14] + kza.i(kzaVar, sza.f[i14]);
                                            tzaVar.x = 0;
                                            tzaVar.a = 6;
                                            if (tzaVar.u) {
                                                int i15 = tzaVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (tzaVar.x < tzaVar.y) {
                                                        kza.j(kzaVar);
                                                        if (tzaVar.n[0] == 0) {
                                                            f(tzaVar);
                                                        }
                                                        byte[] bArr2 = tzaVar.A;
                                                        int i18 = tzaVar.B;
                                                        int[] iArr2 = mza.a;
                                                        int i19 = iArr2[tzaVar.D + i16];
                                                        int[] iArr3 = tzaVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        kza.d(kzaVar);
                                                        qza qzaVar = tzaVar.k;
                                                        int r2 = r(qzaVar.b, qzaVar.c[bArr2[i18 + (iArr2[tzaVar.E + i17] | i19)] & 255], kzaVar);
                                                        int i20 = tzaVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        tzaVar.x++;
                                                        tzaVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            tzaVar.b = 6;
                                                            tzaVar.Y = tzaVar.Q;
                                                            tzaVar.X = 0;
                                                            tzaVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (tzaVar.x < tzaVar.y) {
                                                        kza.j(kzaVar);
                                                        if (tzaVar.n[0] == 0) {
                                                            f(tzaVar);
                                                        }
                                                        int[] iArr4 = tzaVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        kza.d(kzaVar);
                                                        bArr[tzaVar.r] = (byte) r(tzaVar.k.b, tzaVar.w, kzaVar);
                                                        tzaVar.x++;
                                                        int i22 = tzaVar.r;
                                                        tzaVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            tzaVar.b = 6;
                                                            tzaVar.Y = tzaVar.Q;
                                                            tzaVar.X = 0;
                                                            tzaVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (tzaVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = tzaVar.g - tzaVar.y;
                                                tzaVar.g = i23;
                                                if (i23 <= 0) {
                                                    tzaVar.a = 3;
                                                    break;
                                                } else {
                                                    if (tzaVar.G < 0) {
                                                        kza.j(kzaVar);
                                                        if (tzaVar.n[2] == 0) {
                                                            e(tzaVar);
                                                        }
                                                        int[] iArr5 = tzaVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        kza.d(kzaVar);
                                                        qza qzaVar2 = tzaVar.m;
                                                        int[] iArr6 = qzaVar2.b;
                                                        int[] iArr7 = qzaVar2.c;
                                                        byte[] bArr3 = tzaVar.H;
                                                        int i24 = tzaVar.C;
                                                        int i25 = tzaVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], kzaVar);
                                                        tzaVar.G = r3;
                                                        int i26 = tzaVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            tzaVar.G = i27;
                                                            int i28 = tzaVar.J & i27;
                                                            int i29 = i27 >>> tzaVar.K;
                                                            tzaVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            tzaVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + kza.i(kzaVar, i30)) << tzaVar.K);
                                                        }
                                                    }
                                                    int t = t(tzaVar.G, tzaVar.q, tzaVar.t);
                                                    tzaVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = tzaVar.s;
                                                        int i32 = tzaVar.O;
                                                        if (i31 != i32 && (i6 = tzaVar.r) < i32) {
                                                            tzaVar.s = i6;
                                                        } else {
                                                            tzaVar.s = tzaVar.O;
                                                        }
                                                        tzaVar.N = tzaVar.r;
                                                        int i33 = tzaVar.L;
                                                        if (i33 > tzaVar.s) {
                                                            tzaVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (tzaVar.G > 0) {
                                                                int[] iArr8 = tzaVar.q;
                                                                int i34 = tzaVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                tzaVar.t = i34 + 1;
                                                            }
                                                            if (tzaVar.M <= tzaVar.g) {
                                                                tzaVar.x = 0;
                                                                tzaVar.a = 7;
                                                                int i35 = tzaVar.r;
                                                                i = (i35 - tzaVar.L) & i9;
                                                                i2 = tzaVar.M - tzaVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    tzaVar.x += i2;
                                                                    tzaVar.g -= i2;
                                                                    tzaVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = tzaVar.x;
                                                                        if (i3 >= tzaVar.M) {
                                                                            i4 = tzaVar.r;
                                                                            bArr[i4] = bArr[(i4 - tzaVar.L) & i9];
                                                                            tzaVar.g--;
                                                                            tzaVar.x = i3 + 1;
                                                                            tzaVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    tzaVar.b = 7;
                                                                    tzaVar.Y = tzaVar.Q;
                                                                    tzaVar.X = 0;
                                                                    tzaVar.a = 12;
                                                                    if (tzaVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        tzaVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (tzaVar.a != i5) {
                                                                }
                                                            } else {
                                                                throw new BrotliRuntimeException("Invalid backward reference");
                                                            }
                                                        }
                                                    } else {
                                                        throw new BrotliRuntimeException("Negative distance");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        if (tzaVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (tzaVar.g > 0) {
                                            kza.j(kzaVar);
                                            kza.i(kzaVar, 8);
                                            tzaVar.g--;
                                        }
                                        tzaVar.a = 1;
                                        break;
                                    case 5:
                                        a(tzaVar);
                                        break;
                                    case 6:
                                        if (tzaVar.u) {
                                        }
                                        if (tzaVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = tzaVar.r;
                                        i = (i352 - tzaVar.L) & i9;
                                        i2 = tzaVar.M - tzaVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = tzaVar.x;
                                            if (i3 >= tzaVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        tzaVar.b = 7;
                                        tzaVar.Y = tzaVar.Q;
                                        tzaVar.X = 0;
                                        tzaVar.a = 12;
                                        if (tzaVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = tzaVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, tzaVar.N - i36);
                                        tzaVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = tzaVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = oza.a[i37];
                                            int i39 = (tzaVar.L - tzaVar.s) - 1;
                                            int i40 = oza.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < uza.d.length) {
                                                int b2 = uza.b(bArr, tzaVar.N, oza.a(), i43, tzaVar.M, uza.d[i42]);
                                                int i44 = tzaVar.N + b2;
                                                tzaVar.N = i44;
                                                tzaVar.r += b2;
                                                tzaVar.g -= b2;
                                                int i45 = tzaVar.Q;
                                                if (i44 >= i45) {
                                                    tzaVar.b = 8;
                                                    tzaVar.Y = i45;
                                                    tzaVar.X = 0;
                                                    tzaVar.a = 12;
                                                    break;
                                                } else {
                                                    tzaVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + tzaVar.a);
                                }
                            } else if (!u(tzaVar)) {
                                return;
                            } else {
                                int i46 = tzaVar.r;
                                int i47 = tzaVar.O;
                                if (i46 >= i47) {
                                    tzaVar.s = i47;
                                }
                                tzaVar.r &= i9;
                                tzaVar.a = tzaVar.b;
                            }
                        } else if (i10 == 10) {
                            if (tzaVar.g >= 0) {
                                kza.g(kzaVar);
                                kza.a(tzaVar.c, true);
                                return;
                            }
                            throw new BrotliRuntimeException("Invalid metablock length");
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new IllegalStateException("Can't decompress after close");
                }
            } else {
                throw new IllegalStateException("Can't decompress until initialized");
            }
        }
    }

    public static void j(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, bArr, i) == null) {
            int[] iArr = new int[256];
            for (int i2 = 0; i2 < 256; i2++) {
                iArr[i2] = i2;
            }
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = bArr[i3] & 255;
                bArr[i3] = (byte) iArr[i4];
                if (i4 != 0) {
                    l(iArr, i4);
                }
            }
        }
    }

    public static void l(int[] iArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, iArr, i) == null) {
            int i2 = iArr[i];
            while (i > 0) {
                iArr[i] = iArr[i - 1];
                i--;
            }
            iArr[0] = i2;
        }
    }

    public static void s(tza tzaVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, tzaVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            tzaVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, kza kzaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, kzaVar)) == null) {
            kza.d(kzaVar);
            int r = r(iArr, i, kzaVar);
            return sza.a[r] + kza.i(kzaVar, sza.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, kza kzaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), kzaVar}) == null) {
            kza.j(kzaVar);
            int[] iArr2 = new int[i];
            int i3 = kza.i(kzaVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = kza.i(kzaVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = kza.i(kzaVar, i6) % i;
                    iArr2[iArr3[i7]] = 2;
                }
                iArr2[iArr3[0]] = 1;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (iArr3[0] != iArr3[1] && iArr3[0] != iArr3[2] && iArr3[0] != iArr3[3] && iArr3[1] != iArr3[2] && iArr3[1] != iArr3[3] && iArr3[2] != iArr3[3]) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (kza.i(kzaVar, 1) == 1) {
                                iArr2[iArr3[2]] = 3;
                                iArr2[iArr3[3]] = 3;
                            } else {
                                iArr2[iArr3[0]] = 2;
                            }
                            z3 = z;
                        } else if (iArr3[0] != iArr3[1] && iArr3[0] != iArr3[2] && iArr3[1] != iArr3[2]) {
                            z2 = true;
                        }
                    } else {
                        if (iArr3[0] != iArr3[1]) {
                            z2 = true;
                        }
                        iArr2[iArr3[1]] = 1;
                    }
                }
                if (!z3) {
                    pza.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                kza.d(kzaVar);
                long j = kzaVar.f;
                int i11 = kzaVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                kzaVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, kzaVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.vza.b(r13, r3, r12 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Unused space");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(int[] iArr, int i, int[] iArr2, kza kzaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, kzaVar) == null) {
            int[] iArr3 = new int[32];
            pza.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    kza.j(kzaVar);
                    kza.d(kzaVar);
                    long j = kzaVar.f;
                    int i9 = kzaVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    kzaVar.g = i9 + (iArr3[i10] >> 16);
                    int i11 = iArr3[i10] & 65535;
                    if (i11 < 16) {
                        int i12 = i5 + 1;
                        iArr2[i5] = i11;
                        if (i11 != 0) {
                            i6 -= 32768 >> i11;
                            i5 = i12;
                            i4 = i11;
                        } else {
                            i5 = i12;
                        }
                    } else {
                        int i13 = i11 - 14;
                        if (i11 == 16) {
                            i2 = i4;
                        } else {
                            i2 = 0;
                        }
                        if (i7 != i2) {
                            i7 = i2;
                            i8 = 0;
                        }
                        if (i8 > 0) {
                            i3 = (i8 - 2) << i13;
                        } else {
                            i3 = i8;
                        }
                        int i14 = i3 + kza.i(kzaVar, i13) + 3;
                        int i15 = i14 - i8;
                        if (i5 + i15 <= i) {
                            int i16 = 0;
                            while (i16 < i15) {
                                iArr2[i5] = i7;
                                i16++;
                                i5++;
                            }
                            if (i7 != 0) {
                                i6 -= i15 << (15 - i7);
                            }
                            i8 = i14;
                        } else {
                            throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                        }
                    }
                }
            }
        }
    }

    public static void p(tza tzaVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, tzaVar) == null) {
            kza kzaVar = tzaVar.c;
            for (int i = 0; i < 3; i++) {
                tzaVar.o[i] = h(kzaVar) + 1;
                tzaVar.n[i] = 268435456;
                int[] iArr2 = tzaVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, tzaVar.e, i2, kzaVar);
                    n(26, tzaVar.f, i2, kzaVar);
                    tzaVar.n[i] = m(tzaVar.f, i2, kzaVar);
                }
            }
            kza.j(kzaVar);
            tzaVar.K = kza.i(kzaVar, 2);
            int i3 = kza.i(kzaVar, 4);
            int i4 = tzaVar.K;
            int i5 = (i3 << i4) + 16;
            tzaVar.I = i5;
            tzaVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            tzaVar.z = new byte[tzaVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = tzaVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    tzaVar.z[i7] = (byte) (kza.i(kzaVar, 2) << 1);
                    i7++;
                }
                kza.j(kzaVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            tzaVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, kzaVar);
            tzaVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (tzaVar.o[0] << 6)) {
                    break;
                } else if (tzaVar.A[i8] != (i8 >> 6)) {
                    tzaVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = tzaVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            tzaVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, kzaVar);
            qza.b(tzaVar.k, 256, d2);
            qza.b(tzaVar.l, 704, tzaVar.o[1]);
            qza.b(tzaVar.m, i6, d3);
            qza.a(tzaVar.k, kzaVar);
            qza.a(tzaVar.l, kzaVar);
            qza.a(tzaVar.m, kzaVar);
            tzaVar.B = 0;
            tzaVar.C = 0;
            int[] iArr4 = mza.b;
            byte[] bArr3 = tzaVar.z;
            tzaVar.D = iArr4[bArr3[0]];
            tzaVar.E = iArr4[bArr3[0] + 1];
            tzaVar.v = 0;
            tzaVar.w = tzaVar.k.c[0];
            tzaVar.F = tzaVar.l.c[0];
            int[] iArr5 = tzaVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(tza tzaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, tzaVar) == null) {
            kza kzaVar = tzaVar.c;
            if (tzaVar.h) {
                tzaVar.b = 10;
                tzaVar.Y = tzaVar.r;
                tzaVar.X = 0;
                tzaVar.a = 12;
                return;
            }
            qza qzaVar = tzaVar.k;
            qzaVar.b = null;
            qzaVar.c = null;
            qza qzaVar2 = tzaVar.l;
            qzaVar2.b = null;
            qzaVar2.c = null;
            qza qzaVar3 = tzaVar.m;
            qzaVar3.b = null;
            qzaVar3.c = null;
            kza.j(kzaVar);
            g(kzaVar, tzaVar);
            if (tzaVar.g == 0 && !tzaVar.j) {
                return;
            }
            if (!tzaVar.i && !tzaVar.j) {
                tzaVar.a = 2;
            } else {
                kza.g(kzaVar);
                if (tzaVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                tzaVar.a = i;
            }
            if (tzaVar.j) {
                return;
            }
            tzaVar.R += tzaVar.g;
            if (tzaVar.Q < tzaVar.P) {
                k(tzaVar);
            }
        }
    }

    public static int r(int[] iArr, int i, kza kzaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, kzaVar)) == null) {
            long j = kzaVar.f;
            int i2 = kzaVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                kzaVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            kzaVar.g = i2 + (iArr[i7] >> 16) + 8;
            return iArr[i7] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static int t(int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) {
            if (i < 16) {
                return iArr[(i2 + b[i]) & 3] + c[i];
            }
            return (i - 16) + 1;
        }
        return invokeCommon.intValue;
    }
}
