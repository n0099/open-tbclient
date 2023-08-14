package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes6.dex */
public final class iyb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947871255, "Lcom/baidu/tieba/iyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947871255, "Lcom/baidu/tieba/iyb;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(oyb oybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, oybVar) == null) {
            fyb fybVar = oybVar.c;
            byte[] bArr = oybVar.d;
            int i = oybVar.g;
            if (i <= 0) {
                fyb.k(fybVar);
                oybVar.a = 1;
                return;
            }
            int min = Math.min(oybVar.Q - oybVar.r, i);
            fyb.c(fybVar, bArr, oybVar.r, min);
            oybVar.g -= min;
            int i2 = oybVar.r + min;
            oybVar.r = i2;
            int i3 = oybVar.Q;
            if (i2 == i3) {
                oybVar.b = 5;
                oybVar.Y = i3;
                oybVar.X = 0;
                oybVar.a = 12;
                return;
            }
            fyb.k(fybVar);
            oybVar.a = 1;
        }
    }

    public static void k(oyb oybVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, oybVar) == null) {
            int i2 = oybVar.P;
            long j = oybVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + oybVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!oybVar.h && i2 < 16384 && oybVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = oybVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = oybVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = oybVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = oybVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(oybVar.S, i, bArr, 0, i5);
                    oybVar.r = i5;
                    oybVar.f1141T = i5;
                }
            }
            oybVar.d = bArr;
            oybVar.Q = i2;
        }
    }

    public static boolean u(oyb oybVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, oybVar)) == null) {
            int i = oybVar.f1141T;
            if (i != 0) {
                oybVar.X += i;
                oybVar.f1141T = 0;
            }
            int min = Math.min(oybVar.V - oybVar.W, oybVar.Y - oybVar.X);
            if (min != 0) {
                System.arraycopy(oybVar.d, oybVar.X, oybVar.Z, oybVar.U + oybVar.W, min);
                oybVar.W += min;
                oybVar.X += min;
            }
            if (oybVar.W >= oybVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(oyb oybVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, oybVar, i) == null) {
            fyb fybVar = oybVar.c;
            int[] iArr = oybVar.p;
            int i3 = i * 2;
            fyb.d(fybVar);
            int i4 = i * 1080;
            int r = r(oybVar.e, i4, fybVar);
            oybVar.n[i] = m(oybVar.f, i4, fybVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = oybVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(oyb oybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, oybVar) == null) {
            b(oybVar, 1);
            oybVar.F = oybVar.l.c[oybVar.p[3]];
        }
    }

    public static void e(oyb oybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, oybVar) == null) {
            b(oybVar, 2);
            oybVar.C = oybVar.p[5] << 2;
        }
    }

    public static int h(fyb fybVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fybVar)) == null) {
            if (fyb.i(fybVar, 1) != 0) {
                int i = fyb.i(fybVar, 3);
                if (i == 0) {
                    return 1;
                }
                return fyb.i(fybVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, fyb fybVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, fybVar)) == null) {
            fyb.j(fybVar);
            int h = h(fybVar) + 1;
            if (h == 1) {
                qyb.a(bArr, 0, i);
                return h;
            }
            if (fyb.i(fybVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = fyb.i(fybVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, fybVar);
            int i3 = 0;
            while (i3 < i) {
                fyb.j(fybVar);
                fyb.d(fybVar);
                int r = r(iArr, 0, fybVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + fyb.i(fybVar, r); i4 != 0; i4--) {
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
            if (fyb.i(fybVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(oyb oybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, oybVar) == null) {
            b(oybVar, 0);
            int i = oybVar.p[1];
            int i2 = i << 6;
            oybVar.B = i2;
            int i3 = oybVar.A[i2] & 255;
            oybVar.v = i3;
            oybVar.w = oybVar.k.c[i3];
            byte b2 = oybVar.z[i];
            int[] iArr = hyb.b;
            oybVar.D = iArr[b2];
            oybVar.E = iArr[b2 + 1];
        }
    }

    public static void g(fyb fybVar, oyb oybVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, fybVar, oybVar) == null) {
            boolean z2 = true;
            if (fyb.i(fybVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            oybVar.h = z;
            oybVar.g = 0;
            oybVar.i = false;
            oybVar.j = false;
            if (z && fyb.i(fybVar, 1) != 0) {
                return;
            }
            int i = fyb.i(fybVar, 2) + 4;
            if (i == 7) {
                oybVar.j = true;
                if (fyb.i(fybVar, 1) == 0) {
                    int i2 = fyb.i(fybVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = fyb.i(fybVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        oybVar.g = (i4 << (i3 * 8)) | oybVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = fyb.i(fybVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    oybVar.g = (i6 << (i5 * 4)) | oybVar.g;
                }
            }
            oybVar.g++;
            if (!oybVar.h) {
                if (fyb.i(fybVar, 1) != 1) {
                    z2 = false;
                }
                oybVar.i = z2;
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
    public static void i(oyb oybVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, oybVar) == null) {
            int i8 = oybVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    fyb fybVar = oybVar.c;
                    int i9 = oybVar.Q - 1;
                    byte[] bArr = oybVar.d;
                    while (true) {
                        int i10 = oybVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (oybVar.g >= 0) {
                                            q(oybVar);
                                            i9 = oybVar.Q - 1;
                                            bArr = oybVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(oybVar);
                                        oybVar.a = 3;
                                        if (oybVar.g > 0) {
                                            oybVar.a = 1;
                                            break;
                                        } else {
                                            fyb.j(fybVar);
                                            if (oybVar.n[1] == 0) {
                                                c(oybVar);
                                            }
                                            int[] iArr = oybVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            fyb.d(fybVar);
                                            int r = r(oybVar.l.b, oybVar.F, fybVar);
                                            int i12 = r >>> 6;
                                            oybVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                oybVar.G = -1;
                                            }
                                            int i13 = nyb.g[i12] + ((r >>> 3) & 7);
                                            int i14 = nyb.h[i12] + (r & 7);
                                            oybVar.y = nyb.c[i13] + fyb.i(fybVar, nyb.d[i13]);
                                            oybVar.M = nyb.e[i14] + fyb.i(fybVar, nyb.f[i14]);
                                            oybVar.x = 0;
                                            oybVar.a = 6;
                                            if (oybVar.u) {
                                                int i15 = oybVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (oybVar.x < oybVar.y) {
                                                        fyb.j(fybVar);
                                                        if (oybVar.n[0] == 0) {
                                                            f(oybVar);
                                                        }
                                                        byte[] bArr2 = oybVar.A;
                                                        int i18 = oybVar.B;
                                                        int[] iArr2 = hyb.a;
                                                        int i19 = iArr2[oybVar.D + i16];
                                                        int[] iArr3 = oybVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        fyb.d(fybVar);
                                                        lyb lybVar = oybVar.k;
                                                        int r2 = r(lybVar.b, lybVar.c[bArr2[i18 + (iArr2[oybVar.E + i17] | i19)] & 255], fybVar);
                                                        int i20 = oybVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        oybVar.x++;
                                                        oybVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            oybVar.b = 6;
                                                            oybVar.Y = oybVar.Q;
                                                            oybVar.X = 0;
                                                            oybVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (oybVar.x < oybVar.y) {
                                                        fyb.j(fybVar);
                                                        if (oybVar.n[0] == 0) {
                                                            f(oybVar);
                                                        }
                                                        int[] iArr4 = oybVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        fyb.d(fybVar);
                                                        bArr[oybVar.r] = (byte) r(oybVar.k.b, oybVar.w, fybVar);
                                                        oybVar.x++;
                                                        int i22 = oybVar.r;
                                                        oybVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            oybVar.b = 6;
                                                            oybVar.Y = oybVar.Q;
                                                            oybVar.X = 0;
                                                            oybVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (oybVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = oybVar.g - oybVar.y;
                                                oybVar.g = i23;
                                                if (i23 <= 0) {
                                                    oybVar.a = 3;
                                                    break;
                                                } else {
                                                    if (oybVar.G < 0) {
                                                        fyb.j(fybVar);
                                                        if (oybVar.n[2] == 0) {
                                                            e(oybVar);
                                                        }
                                                        int[] iArr5 = oybVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        fyb.d(fybVar);
                                                        lyb lybVar2 = oybVar.m;
                                                        int[] iArr6 = lybVar2.b;
                                                        int[] iArr7 = lybVar2.c;
                                                        byte[] bArr3 = oybVar.H;
                                                        int i24 = oybVar.C;
                                                        int i25 = oybVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], fybVar);
                                                        oybVar.G = r3;
                                                        int i26 = oybVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            oybVar.G = i27;
                                                            int i28 = oybVar.J & i27;
                                                            int i29 = i27 >>> oybVar.K;
                                                            oybVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            oybVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + fyb.i(fybVar, i30)) << oybVar.K);
                                                        }
                                                    }
                                                    int t = t(oybVar.G, oybVar.q, oybVar.t);
                                                    oybVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = oybVar.s;
                                                        int i32 = oybVar.O;
                                                        if (i31 != i32 && (i6 = oybVar.r) < i32) {
                                                            oybVar.s = i6;
                                                        } else {
                                                            oybVar.s = oybVar.O;
                                                        }
                                                        oybVar.N = oybVar.r;
                                                        int i33 = oybVar.L;
                                                        if (i33 > oybVar.s) {
                                                            oybVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (oybVar.G > 0) {
                                                                int[] iArr8 = oybVar.q;
                                                                int i34 = oybVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                oybVar.t = i34 + 1;
                                                            }
                                                            if (oybVar.M <= oybVar.g) {
                                                                oybVar.x = 0;
                                                                oybVar.a = 7;
                                                                int i35 = oybVar.r;
                                                                i = (i35 - oybVar.L) & i9;
                                                                i2 = oybVar.M - oybVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    oybVar.x += i2;
                                                                    oybVar.g -= i2;
                                                                    oybVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = oybVar.x;
                                                                        if (i3 >= oybVar.M) {
                                                                            i4 = oybVar.r;
                                                                            bArr[i4] = bArr[(i4 - oybVar.L) & i9];
                                                                            oybVar.g--;
                                                                            oybVar.x = i3 + 1;
                                                                            oybVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    oybVar.b = 7;
                                                                    oybVar.Y = oybVar.Q;
                                                                    oybVar.X = 0;
                                                                    oybVar.a = 12;
                                                                    if (oybVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        oybVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (oybVar.a != i5) {
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
                                        if (oybVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (oybVar.g > 0) {
                                            fyb.j(fybVar);
                                            fyb.i(fybVar, 8);
                                            oybVar.g--;
                                        }
                                        oybVar.a = 1;
                                        break;
                                    case 5:
                                        a(oybVar);
                                        break;
                                    case 6:
                                        if (oybVar.u) {
                                        }
                                        if (oybVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = oybVar.r;
                                        i = (i352 - oybVar.L) & i9;
                                        i2 = oybVar.M - oybVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = oybVar.x;
                                            if (i3 >= oybVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        oybVar.b = 7;
                                        oybVar.Y = oybVar.Q;
                                        oybVar.X = 0;
                                        oybVar.a = 12;
                                        if (oybVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = oybVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, oybVar.N - i36);
                                        oybVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = oybVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = jyb.a[i37];
                                            int i39 = (oybVar.L - oybVar.s) - 1;
                                            int i40 = jyb.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < pyb.d.length) {
                                                int b2 = pyb.b(bArr, oybVar.N, jyb.a(), i43, oybVar.M, pyb.d[i42]);
                                                int i44 = oybVar.N + b2;
                                                oybVar.N = i44;
                                                oybVar.r += b2;
                                                oybVar.g -= b2;
                                                int i45 = oybVar.Q;
                                                if (i44 >= i45) {
                                                    oybVar.b = 8;
                                                    oybVar.Y = i45;
                                                    oybVar.X = 0;
                                                    oybVar.a = 12;
                                                    break;
                                                } else {
                                                    oybVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + oybVar.a);
                                }
                            } else if (!u(oybVar)) {
                                return;
                            } else {
                                int i46 = oybVar.r;
                                int i47 = oybVar.O;
                                if (i46 >= i47) {
                                    oybVar.s = i47;
                                }
                                oybVar.r &= i9;
                                oybVar.a = oybVar.b;
                            }
                        } else if (i10 == 10) {
                            if (oybVar.g >= 0) {
                                fyb.g(fybVar);
                                fyb.a(oybVar.c, true);
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

    public static void s(oyb oybVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, oybVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            oybVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, fyb fybVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, fybVar)) == null) {
            fyb.d(fybVar);
            int r = r(iArr, i, fybVar);
            return nyb.a[r] + fyb.i(fybVar, nyb.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, fyb fybVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), fybVar}) == null) {
            fyb.j(fybVar);
            int[] iArr2 = new int[i];
            int i3 = fyb.i(fybVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = fyb.i(fybVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = fyb.i(fybVar, i6) % i;
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
                            if (fyb.i(fybVar, 1) == 1) {
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
                    kyb.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                fyb.d(fybVar);
                long j = fybVar.f;
                int i11 = fybVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                fybVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, fybVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.qyb.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, fyb fybVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, fybVar) == null) {
            int[] iArr3 = new int[32];
            kyb.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    fyb.j(fybVar);
                    fyb.d(fybVar);
                    long j = fybVar.f;
                    int i9 = fybVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    fybVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + fyb.i(fybVar, i13) + 3;
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

    public static void p(oyb oybVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, oybVar) == null) {
            fyb fybVar = oybVar.c;
            for (int i = 0; i < 3; i++) {
                oybVar.o[i] = h(fybVar) + 1;
                oybVar.n[i] = 268435456;
                int[] iArr2 = oybVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, oybVar.e, i2, fybVar);
                    n(26, oybVar.f, i2, fybVar);
                    oybVar.n[i] = m(oybVar.f, i2, fybVar);
                }
            }
            fyb.j(fybVar);
            oybVar.K = fyb.i(fybVar, 2);
            int i3 = fyb.i(fybVar, 4);
            int i4 = oybVar.K;
            int i5 = (i3 << i4) + 16;
            oybVar.I = i5;
            oybVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            oybVar.z = new byte[oybVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = oybVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    oybVar.z[i7] = (byte) (fyb.i(fybVar, 2) << 1);
                    i7++;
                }
                fyb.j(fybVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            oybVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, fybVar);
            oybVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (oybVar.o[0] << 6)) {
                    break;
                } else if (oybVar.A[i8] != (i8 >> 6)) {
                    oybVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = oybVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            oybVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, fybVar);
            lyb.b(oybVar.k, 256, d2);
            lyb.b(oybVar.l, 704, oybVar.o[1]);
            lyb.b(oybVar.m, i6, d3);
            lyb.a(oybVar.k, fybVar);
            lyb.a(oybVar.l, fybVar);
            lyb.a(oybVar.m, fybVar);
            oybVar.B = 0;
            oybVar.C = 0;
            int[] iArr4 = hyb.b;
            byte[] bArr3 = oybVar.z;
            oybVar.D = iArr4[bArr3[0]];
            oybVar.E = iArr4[bArr3[0] + 1];
            oybVar.v = 0;
            oybVar.w = oybVar.k.c[0];
            oybVar.F = oybVar.l.c[0];
            int[] iArr5 = oybVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(oyb oybVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, oybVar) == null) {
            fyb fybVar = oybVar.c;
            if (oybVar.h) {
                oybVar.b = 10;
                oybVar.Y = oybVar.r;
                oybVar.X = 0;
                oybVar.a = 12;
                return;
            }
            lyb lybVar = oybVar.k;
            lybVar.b = null;
            lybVar.c = null;
            lyb lybVar2 = oybVar.l;
            lybVar2.b = null;
            lybVar2.c = null;
            lyb lybVar3 = oybVar.m;
            lybVar3.b = null;
            lybVar3.c = null;
            fyb.j(fybVar);
            g(fybVar, oybVar);
            if (oybVar.g == 0 && !oybVar.j) {
                return;
            }
            if (!oybVar.i && !oybVar.j) {
                oybVar.a = 2;
            } else {
                fyb.g(fybVar);
                if (oybVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                oybVar.a = i;
            }
            if (oybVar.j) {
                return;
            }
            oybVar.R += oybVar.g;
            if (oybVar.Q < oybVar.P) {
                k(oybVar);
            }
        }
    }

    public static int r(int[] iArr, int i, fyb fybVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, fybVar)) == null) {
            long j = fybVar.f;
            int i2 = fybVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                fybVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            fybVar.g = i2 + (iArr[i7] >> 16) + 8;
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
