package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public final class sjb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948154750, "Lcom/baidu/tieba/sjb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948154750, "Lcom/baidu/tieba/sjb;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(yjb yjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, yjbVar) == null) {
            pjb pjbVar = yjbVar.c;
            byte[] bArr = yjbVar.d;
            int i = yjbVar.g;
            if (i <= 0) {
                pjb.k(pjbVar);
                yjbVar.a = 1;
                return;
            }
            int min = Math.min(yjbVar.Q - yjbVar.r, i);
            pjb.c(pjbVar, bArr, yjbVar.r, min);
            yjbVar.g -= min;
            int i2 = yjbVar.r + min;
            yjbVar.r = i2;
            int i3 = yjbVar.Q;
            if (i2 == i3) {
                yjbVar.b = 5;
                yjbVar.Y = i3;
                yjbVar.X = 0;
                yjbVar.a = 12;
                return;
            }
            pjb.k(pjbVar);
            yjbVar.a = 1;
        }
    }

    public static void k(yjb yjbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, yjbVar) == null) {
            int i2 = yjbVar.P;
            long j = yjbVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + yjbVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!yjbVar.h && i2 < 16384 && yjbVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = yjbVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = yjbVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = yjbVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = yjbVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(yjbVar.S, i, bArr, 0, i5);
                    yjbVar.r = i5;
                    yjbVar.f1190T = i5;
                }
            }
            yjbVar.d = bArr;
            yjbVar.Q = i2;
        }
    }

    public static boolean u(yjb yjbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, yjbVar)) == null) {
            int i = yjbVar.f1190T;
            if (i != 0) {
                yjbVar.X += i;
                yjbVar.f1190T = 0;
            }
            int min = Math.min(yjbVar.V - yjbVar.W, yjbVar.Y - yjbVar.X);
            if (min != 0) {
                System.arraycopy(yjbVar.d, yjbVar.X, yjbVar.Z, yjbVar.U + yjbVar.W, min);
                yjbVar.W += min;
                yjbVar.X += min;
            }
            if (yjbVar.W >= yjbVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(yjb yjbVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, yjbVar, i) == null) {
            pjb pjbVar = yjbVar.c;
            int[] iArr = yjbVar.p;
            int i3 = i * 2;
            pjb.d(pjbVar);
            int i4 = i * 1080;
            int r = r(yjbVar.e, i4, pjbVar);
            yjbVar.n[i] = m(yjbVar.f, i4, pjbVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = yjbVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(yjb yjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, yjbVar) == null) {
            b(yjbVar, 1);
            yjbVar.F = yjbVar.l.c[yjbVar.p[3]];
        }
    }

    public static void e(yjb yjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, yjbVar) == null) {
            b(yjbVar, 2);
            yjbVar.C = yjbVar.p[5] << 2;
        }
    }

    public static int h(pjb pjbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pjbVar)) == null) {
            if (pjb.i(pjbVar, 1) != 0) {
                int i = pjb.i(pjbVar, 3);
                if (i == 0) {
                    return 1;
                }
                return pjb.i(pjbVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, pjb pjbVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, pjbVar)) == null) {
            pjb.j(pjbVar);
            int h = h(pjbVar) + 1;
            if (h == 1) {
                akb.a(bArr, 0, i);
                return h;
            }
            if (pjb.i(pjbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = pjb.i(pjbVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, pjbVar);
            int i3 = 0;
            while (i3 < i) {
                pjb.j(pjbVar);
                pjb.d(pjbVar);
                int r = r(iArr, 0, pjbVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + pjb.i(pjbVar, r); i4 != 0; i4--) {
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
            if (pjb.i(pjbVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(yjb yjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, yjbVar) == null) {
            b(yjbVar, 0);
            int i = yjbVar.p[1];
            int i2 = i << 6;
            yjbVar.B = i2;
            int i3 = yjbVar.A[i2] & 255;
            yjbVar.v = i3;
            yjbVar.w = yjbVar.k.c[i3];
            byte b2 = yjbVar.z[i];
            int[] iArr = rjb.b;
            yjbVar.D = iArr[b2];
            yjbVar.E = iArr[b2 + 1];
        }
    }

    public static void g(pjb pjbVar, yjb yjbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pjbVar, yjbVar) == null) {
            boolean z2 = true;
            if (pjb.i(pjbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            yjbVar.h = z;
            yjbVar.g = 0;
            yjbVar.i = false;
            yjbVar.j = false;
            if (z && pjb.i(pjbVar, 1) != 0) {
                return;
            }
            int i = pjb.i(pjbVar, 2) + 4;
            if (i == 7) {
                yjbVar.j = true;
                if (pjb.i(pjbVar, 1) == 0) {
                    int i2 = pjb.i(pjbVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = pjb.i(pjbVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        yjbVar.g = (i4 << (i3 * 8)) | yjbVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = pjb.i(pjbVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    yjbVar.g = (i6 << (i5 * 4)) | yjbVar.g;
                }
            }
            yjbVar.g++;
            if (!yjbVar.h) {
                if (pjb.i(pjbVar, 1) != 1) {
                    z2 = false;
                }
                yjbVar.i = z2;
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
    public static void i(yjb yjbVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, yjbVar) == null) {
            int i8 = yjbVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    pjb pjbVar = yjbVar.c;
                    int i9 = yjbVar.Q - 1;
                    byte[] bArr = yjbVar.d;
                    while (true) {
                        int i10 = yjbVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (yjbVar.g >= 0) {
                                            q(yjbVar);
                                            i9 = yjbVar.Q - 1;
                                            bArr = yjbVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(yjbVar);
                                        yjbVar.a = 3;
                                        if (yjbVar.g > 0) {
                                            yjbVar.a = 1;
                                            break;
                                        } else {
                                            pjb.j(pjbVar);
                                            if (yjbVar.n[1] == 0) {
                                                c(yjbVar);
                                            }
                                            int[] iArr = yjbVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            pjb.d(pjbVar);
                                            int r = r(yjbVar.l.b, yjbVar.F, pjbVar);
                                            int i12 = r >>> 6;
                                            yjbVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                yjbVar.G = -1;
                                            }
                                            int i13 = xjb.g[i12] + ((r >>> 3) & 7);
                                            int i14 = xjb.h[i12] + (r & 7);
                                            yjbVar.y = xjb.c[i13] + pjb.i(pjbVar, xjb.d[i13]);
                                            yjbVar.M = xjb.e[i14] + pjb.i(pjbVar, xjb.f[i14]);
                                            yjbVar.x = 0;
                                            yjbVar.a = 6;
                                            if (yjbVar.u) {
                                                int i15 = yjbVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (yjbVar.x < yjbVar.y) {
                                                        pjb.j(pjbVar);
                                                        if (yjbVar.n[0] == 0) {
                                                            f(yjbVar);
                                                        }
                                                        byte[] bArr2 = yjbVar.A;
                                                        int i18 = yjbVar.B;
                                                        int[] iArr2 = rjb.a;
                                                        int i19 = iArr2[yjbVar.D + i16];
                                                        int[] iArr3 = yjbVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        pjb.d(pjbVar);
                                                        vjb vjbVar = yjbVar.k;
                                                        int r2 = r(vjbVar.b, vjbVar.c[bArr2[i18 + (iArr2[yjbVar.E + i17] | i19)] & 255], pjbVar);
                                                        int i20 = yjbVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        yjbVar.x++;
                                                        yjbVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            yjbVar.b = 6;
                                                            yjbVar.Y = yjbVar.Q;
                                                            yjbVar.X = 0;
                                                            yjbVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (yjbVar.x < yjbVar.y) {
                                                        pjb.j(pjbVar);
                                                        if (yjbVar.n[0] == 0) {
                                                            f(yjbVar);
                                                        }
                                                        int[] iArr4 = yjbVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        pjb.d(pjbVar);
                                                        bArr[yjbVar.r] = (byte) r(yjbVar.k.b, yjbVar.w, pjbVar);
                                                        yjbVar.x++;
                                                        int i22 = yjbVar.r;
                                                        yjbVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            yjbVar.b = 6;
                                                            yjbVar.Y = yjbVar.Q;
                                                            yjbVar.X = 0;
                                                            yjbVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (yjbVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = yjbVar.g - yjbVar.y;
                                                yjbVar.g = i23;
                                                if (i23 <= 0) {
                                                    yjbVar.a = 3;
                                                    break;
                                                } else {
                                                    if (yjbVar.G < 0) {
                                                        pjb.j(pjbVar);
                                                        if (yjbVar.n[2] == 0) {
                                                            e(yjbVar);
                                                        }
                                                        int[] iArr5 = yjbVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        pjb.d(pjbVar);
                                                        vjb vjbVar2 = yjbVar.m;
                                                        int[] iArr6 = vjbVar2.b;
                                                        int[] iArr7 = vjbVar2.c;
                                                        byte[] bArr3 = yjbVar.H;
                                                        int i24 = yjbVar.C;
                                                        int i25 = yjbVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], pjbVar);
                                                        yjbVar.G = r3;
                                                        int i26 = yjbVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            yjbVar.G = i27;
                                                            int i28 = yjbVar.J & i27;
                                                            int i29 = i27 >>> yjbVar.K;
                                                            yjbVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            yjbVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + pjb.i(pjbVar, i30)) << yjbVar.K);
                                                        }
                                                    }
                                                    int t = t(yjbVar.G, yjbVar.q, yjbVar.t);
                                                    yjbVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = yjbVar.s;
                                                        int i32 = yjbVar.O;
                                                        if (i31 != i32 && (i6 = yjbVar.r) < i32) {
                                                            yjbVar.s = i6;
                                                        } else {
                                                            yjbVar.s = yjbVar.O;
                                                        }
                                                        yjbVar.N = yjbVar.r;
                                                        int i33 = yjbVar.L;
                                                        if (i33 > yjbVar.s) {
                                                            yjbVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (yjbVar.G > 0) {
                                                                int[] iArr8 = yjbVar.q;
                                                                int i34 = yjbVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                yjbVar.t = i34 + 1;
                                                            }
                                                            if (yjbVar.M <= yjbVar.g) {
                                                                yjbVar.x = 0;
                                                                yjbVar.a = 7;
                                                                int i35 = yjbVar.r;
                                                                i = (i35 - yjbVar.L) & i9;
                                                                i2 = yjbVar.M - yjbVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    yjbVar.x += i2;
                                                                    yjbVar.g -= i2;
                                                                    yjbVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = yjbVar.x;
                                                                        if (i3 >= yjbVar.M) {
                                                                            i4 = yjbVar.r;
                                                                            bArr[i4] = bArr[(i4 - yjbVar.L) & i9];
                                                                            yjbVar.g--;
                                                                            yjbVar.x = i3 + 1;
                                                                            yjbVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    yjbVar.b = 7;
                                                                    yjbVar.Y = yjbVar.Q;
                                                                    yjbVar.X = 0;
                                                                    yjbVar.a = 12;
                                                                    if (yjbVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        yjbVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (yjbVar.a != i5) {
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
                                        if (yjbVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (yjbVar.g > 0) {
                                            pjb.j(pjbVar);
                                            pjb.i(pjbVar, 8);
                                            yjbVar.g--;
                                        }
                                        yjbVar.a = 1;
                                        break;
                                    case 5:
                                        a(yjbVar);
                                        break;
                                    case 6:
                                        if (yjbVar.u) {
                                        }
                                        if (yjbVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = yjbVar.r;
                                        i = (i352 - yjbVar.L) & i9;
                                        i2 = yjbVar.M - yjbVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = yjbVar.x;
                                            if (i3 >= yjbVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        yjbVar.b = 7;
                                        yjbVar.Y = yjbVar.Q;
                                        yjbVar.X = 0;
                                        yjbVar.a = 12;
                                        if (yjbVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = yjbVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, yjbVar.N - i36);
                                        yjbVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = yjbVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = tjb.a[i37];
                                            int i39 = (yjbVar.L - yjbVar.s) - 1;
                                            int i40 = tjb.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < zjb.d.length) {
                                                int b2 = zjb.b(bArr, yjbVar.N, tjb.a(), i43, yjbVar.M, zjb.d[i42]);
                                                int i44 = yjbVar.N + b2;
                                                yjbVar.N = i44;
                                                yjbVar.r += b2;
                                                yjbVar.g -= b2;
                                                int i45 = yjbVar.Q;
                                                if (i44 >= i45) {
                                                    yjbVar.b = 8;
                                                    yjbVar.Y = i45;
                                                    yjbVar.X = 0;
                                                    yjbVar.a = 12;
                                                    break;
                                                } else {
                                                    yjbVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + yjbVar.a);
                                }
                            } else if (!u(yjbVar)) {
                                return;
                            } else {
                                int i46 = yjbVar.r;
                                int i47 = yjbVar.O;
                                if (i46 >= i47) {
                                    yjbVar.s = i47;
                                }
                                yjbVar.r &= i9;
                                yjbVar.a = yjbVar.b;
                            }
                        } else if (i10 == 10) {
                            if (yjbVar.g >= 0) {
                                pjb.g(pjbVar);
                                pjb.a(yjbVar.c, true);
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

    public static void s(yjb yjbVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, yjbVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            yjbVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, pjb pjbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, pjbVar)) == null) {
            pjb.d(pjbVar);
            int r = r(iArr, i, pjbVar);
            return xjb.a[r] + pjb.i(pjbVar, xjb.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, pjb pjbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), pjbVar}) == null) {
            pjb.j(pjbVar);
            int[] iArr2 = new int[i];
            int i3 = pjb.i(pjbVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = pjb.i(pjbVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = pjb.i(pjbVar, i6) % i;
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
                            if (pjb.i(pjbVar, 1) == 1) {
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
                    ujb.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                pjb.d(pjbVar);
                long j = pjbVar.f;
                int i11 = pjbVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                pjbVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, pjbVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.akb.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, pjb pjbVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, pjbVar) == null) {
            int[] iArr3 = new int[32];
            ujb.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    pjb.j(pjbVar);
                    pjb.d(pjbVar);
                    long j = pjbVar.f;
                    int i9 = pjbVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    pjbVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + pjb.i(pjbVar, i13) + 3;
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

    public static void p(yjb yjbVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, yjbVar) == null) {
            pjb pjbVar = yjbVar.c;
            for (int i = 0; i < 3; i++) {
                yjbVar.o[i] = h(pjbVar) + 1;
                yjbVar.n[i] = 268435456;
                int[] iArr2 = yjbVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, yjbVar.e, i2, pjbVar);
                    n(26, yjbVar.f, i2, pjbVar);
                    yjbVar.n[i] = m(yjbVar.f, i2, pjbVar);
                }
            }
            pjb.j(pjbVar);
            yjbVar.K = pjb.i(pjbVar, 2);
            int i3 = pjb.i(pjbVar, 4);
            int i4 = yjbVar.K;
            int i5 = (i3 << i4) + 16;
            yjbVar.I = i5;
            yjbVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            yjbVar.z = new byte[yjbVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = yjbVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    yjbVar.z[i7] = (byte) (pjb.i(pjbVar, 2) << 1);
                    i7++;
                }
                pjb.j(pjbVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            yjbVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, pjbVar);
            yjbVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (yjbVar.o[0] << 6)) {
                    break;
                } else if (yjbVar.A[i8] != (i8 >> 6)) {
                    yjbVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = yjbVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            yjbVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, pjbVar);
            vjb.b(yjbVar.k, 256, d2);
            vjb.b(yjbVar.l, 704, yjbVar.o[1]);
            vjb.b(yjbVar.m, i6, d3);
            vjb.a(yjbVar.k, pjbVar);
            vjb.a(yjbVar.l, pjbVar);
            vjb.a(yjbVar.m, pjbVar);
            yjbVar.B = 0;
            yjbVar.C = 0;
            int[] iArr4 = rjb.b;
            byte[] bArr3 = yjbVar.z;
            yjbVar.D = iArr4[bArr3[0]];
            yjbVar.E = iArr4[bArr3[0] + 1];
            yjbVar.v = 0;
            yjbVar.w = yjbVar.k.c[0];
            yjbVar.F = yjbVar.l.c[0];
            int[] iArr5 = yjbVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(yjb yjbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, yjbVar) == null) {
            pjb pjbVar = yjbVar.c;
            if (yjbVar.h) {
                yjbVar.b = 10;
                yjbVar.Y = yjbVar.r;
                yjbVar.X = 0;
                yjbVar.a = 12;
                return;
            }
            vjb vjbVar = yjbVar.k;
            vjbVar.b = null;
            vjbVar.c = null;
            vjb vjbVar2 = yjbVar.l;
            vjbVar2.b = null;
            vjbVar2.c = null;
            vjb vjbVar3 = yjbVar.m;
            vjbVar3.b = null;
            vjbVar3.c = null;
            pjb.j(pjbVar);
            g(pjbVar, yjbVar);
            if (yjbVar.g == 0 && !yjbVar.j) {
                return;
            }
            if (!yjbVar.i && !yjbVar.j) {
                yjbVar.a = 2;
            } else {
                pjb.g(pjbVar);
                if (yjbVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                yjbVar.a = i;
            }
            if (yjbVar.j) {
                return;
            }
            yjbVar.R += yjbVar.g;
            if (yjbVar.Q < yjbVar.P) {
                k(yjbVar);
            }
        }
    }

    public static int r(int[] iArr, int i, pjb pjbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, pjbVar)) == null) {
            long j = pjbVar.f;
            int i2 = pjbVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                pjbVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            pjbVar.g = i2 + (iArr[i7] >> 16) + 8;
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
