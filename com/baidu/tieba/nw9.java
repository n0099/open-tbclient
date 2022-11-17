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
public final class nw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017017, "Lcom/baidu/tieba/nw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017017, "Lcom/baidu/tieba/nw9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(tw9 tw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, tw9Var) == null) {
            kw9 kw9Var = tw9Var.c;
            byte[] bArr = tw9Var.d;
            int i = tw9Var.g;
            if (i <= 0) {
                kw9.k(kw9Var);
                tw9Var.a = 1;
                return;
            }
            int min = Math.min(tw9Var.Q - tw9Var.r, i);
            kw9.c(kw9Var, bArr, tw9Var.r, min);
            tw9Var.g -= min;
            int i2 = tw9Var.r + min;
            tw9Var.r = i2;
            int i3 = tw9Var.Q;
            if (i2 == i3) {
                tw9Var.b = 5;
                tw9Var.Y = i3;
                tw9Var.X = 0;
                tw9Var.a = 12;
                return;
            }
            kw9.k(kw9Var);
            tw9Var.a = 1;
        }
    }

    public static void k(tw9 tw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, tw9Var) == null) {
            int i2 = tw9Var.P;
            long j = tw9Var.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + tw9Var.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!tw9Var.h && i2 < 16384 && tw9Var.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = tw9Var.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = tw9Var.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = tw9Var.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = tw9Var.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(tw9Var.S, i, bArr, 0, i5);
                    tw9Var.r = i5;
                    tw9Var.T = i5;
                }
            }
            tw9Var.d = bArr;
            tw9Var.Q = i2;
        }
    }

    public static boolean u(tw9 tw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tw9Var)) == null) {
            int i = tw9Var.T;
            if (i != 0) {
                tw9Var.X += i;
                tw9Var.T = 0;
            }
            int min = Math.min(tw9Var.V - tw9Var.W, tw9Var.Y - tw9Var.X);
            if (min != 0) {
                System.arraycopy(tw9Var.d, tw9Var.X, tw9Var.Z, tw9Var.U + tw9Var.W, min);
                tw9Var.W += min;
                tw9Var.X += min;
            }
            if (tw9Var.W >= tw9Var.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(tw9 tw9Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, tw9Var, i) == null) {
            kw9 kw9Var = tw9Var.c;
            int[] iArr = tw9Var.p;
            int i3 = i * 2;
            kw9.d(kw9Var);
            int i4 = i * 1080;
            int r = r(tw9Var.e, i4, kw9Var);
            tw9Var.n[i] = m(tw9Var.f, i4, kw9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = tw9Var.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(tw9 tw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, tw9Var) == null) {
            b(tw9Var, 1);
            tw9Var.F = tw9Var.l.c[tw9Var.p[3]];
        }
    }

    public static void e(tw9 tw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, tw9Var) == null) {
            b(tw9Var, 2);
            tw9Var.C = tw9Var.p[5] << 2;
        }
    }

    public static int h(kw9 kw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, kw9Var)) == null) {
            if (kw9.i(kw9Var, 1) != 0) {
                int i = kw9.i(kw9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return kw9.i(kw9Var, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, kw9 kw9Var) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, kw9Var)) == null) {
            kw9.j(kw9Var);
            int h = h(kw9Var) + 1;
            if (h == 1) {
                vw9.a(bArr, 0, i);
                return h;
            }
            if (kw9.i(kw9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = kw9.i(kw9Var, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, kw9Var);
            int i3 = 0;
            while (i3 < i) {
                kw9.j(kw9Var);
                kw9.d(kw9Var);
                int r = r(iArr, 0, kw9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + kw9.i(kw9Var, r); i4 != 0; i4--) {
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
            if (kw9.i(kw9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(tw9 tw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, tw9Var) == null) {
            b(tw9Var, 0);
            int i = tw9Var.p[1];
            int i2 = i << 6;
            tw9Var.B = i2;
            int i3 = tw9Var.A[i2] & 255;
            tw9Var.v = i3;
            tw9Var.w = tw9Var.k.c[i3];
            byte b2 = tw9Var.z[i];
            int[] iArr = mw9.b;
            tw9Var.D = iArr[b2];
            tw9Var.E = iArr[b2 + 1];
        }
    }

    public static void g(kw9 kw9Var, tw9 tw9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, kw9Var, tw9Var) == null) {
            boolean z2 = true;
            if (kw9.i(kw9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            tw9Var.h = z;
            tw9Var.g = 0;
            tw9Var.i = false;
            tw9Var.j = false;
            if (z && kw9.i(kw9Var, 1) != 0) {
                return;
            }
            int i = kw9.i(kw9Var, 2) + 4;
            if (i == 7) {
                tw9Var.j = true;
                if (kw9.i(kw9Var, 1) == 0) {
                    int i2 = kw9.i(kw9Var, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = kw9.i(kw9Var, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        tw9Var.g = (i4 << (i3 * 8)) | tw9Var.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = kw9.i(kw9Var, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    tw9Var.g = (i6 << (i5 * 4)) | tw9Var.g;
                }
            }
            tw9Var.g++;
            if (!tw9Var.h) {
                if (kw9.i(kw9Var, 1) != 1) {
                    z2 = false;
                }
                tw9Var.i = z2;
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
    public static void i(tw9 tw9Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, tw9Var) == null) {
            int i8 = tw9Var.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    kw9 kw9Var = tw9Var.c;
                    int i9 = tw9Var.Q - 1;
                    byte[] bArr = tw9Var.d;
                    while (true) {
                        int i10 = tw9Var.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (tw9Var.g >= 0) {
                                            q(tw9Var);
                                            i9 = tw9Var.Q - 1;
                                            bArr = tw9Var.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(tw9Var);
                                        tw9Var.a = 3;
                                        if (tw9Var.g > 0) {
                                            tw9Var.a = 1;
                                            break;
                                        } else {
                                            kw9.j(kw9Var);
                                            if (tw9Var.n[1] == 0) {
                                                c(tw9Var);
                                            }
                                            int[] iArr = tw9Var.n;
                                            iArr[1] = iArr[1] - 1;
                                            kw9.d(kw9Var);
                                            int r = r(tw9Var.l.b, tw9Var.F, kw9Var);
                                            int i12 = r >>> 6;
                                            tw9Var.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                tw9Var.G = -1;
                                            }
                                            int i13 = sw9.g[i12] + ((r >>> 3) & 7);
                                            int i14 = sw9.h[i12] + (r & 7);
                                            tw9Var.y = sw9.c[i13] + kw9.i(kw9Var, sw9.d[i13]);
                                            tw9Var.M = sw9.e[i14] + kw9.i(kw9Var, sw9.f[i14]);
                                            tw9Var.x = 0;
                                            tw9Var.a = 6;
                                            if (tw9Var.u) {
                                                int i15 = tw9Var.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (tw9Var.x < tw9Var.y) {
                                                        kw9.j(kw9Var);
                                                        if (tw9Var.n[0] == 0) {
                                                            f(tw9Var);
                                                        }
                                                        byte[] bArr2 = tw9Var.A;
                                                        int i18 = tw9Var.B;
                                                        int[] iArr2 = mw9.a;
                                                        int i19 = iArr2[tw9Var.D + i16];
                                                        int[] iArr3 = tw9Var.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        kw9.d(kw9Var);
                                                        qw9 qw9Var = tw9Var.k;
                                                        int r2 = r(qw9Var.b, qw9Var.c[bArr2[i18 + (iArr2[tw9Var.E + i17] | i19)] & 255], kw9Var);
                                                        int i20 = tw9Var.r;
                                                        bArr[i20] = (byte) r2;
                                                        tw9Var.x++;
                                                        tw9Var.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            tw9Var.b = 6;
                                                            tw9Var.Y = tw9Var.Q;
                                                            tw9Var.X = 0;
                                                            tw9Var.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (tw9Var.x < tw9Var.y) {
                                                        kw9.j(kw9Var);
                                                        if (tw9Var.n[0] == 0) {
                                                            f(tw9Var);
                                                        }
                                                        int[] iArr4 = tw9Var.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        kw9.d(kw9Var);
                                                        bArr[tw9Var.r] = (byte) r(tw9Var.k.b, tw9Var.w, kw9Var);
                                                        tw9Var.x++;
                                                        int i22 = tw9Var.r;
                                                        tw9Var.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            tw9Var.b = 6;
                                                            tw9Var.Y = tw9Var.Q;
                                                            tw9Var.X = 0;
                                                            tw9Var.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (tw9Var.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = tw9Var.g - tw9Var.y;
                                                tw9Var.g = i23;
                                                if (i23 <= 0) {
                                                    tw9Var.a = 3;
                                                    break;
                                                } else {
                                                    if (tw9Var.G < 0) {
                                                        kw9.j(kw9Var);
                                                        if (tw9Var.n[2] == 0) {
                                                            e(tw9Var);
                                                        }
                                                        int[] iArr5 = tw9Var.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        kw9.d(kw9Var);
                                                        qw9 qw9Var2 = tw9Var.m;
                                                        int[] iArr6 = qw9Var2.b;
                                                        int[] iArr7 = qw9Var2.c;
                                                        byte[] bArr3 = tw9Var.H;
                                                        int i24 = tw9Var.C;
                                                        int i25 = tw9Var.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], kw9Var);
                                                        tw9Var.G = r3;
                                                        int i26 = tw9Var.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            tw9Var.G = i27;
                                                            int i28 = tw9Var.J & i27;
                                                            int i29 = i27 >>> tw9Var.K;
                                                            tw9Var.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            tw9Var.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + kw9.i(kw9Var, i30)) << tw9Var.K);
                                                        }
                                                    }
                                                    int t = t(tw9Var.G, tw9Var.q, tw9Var.t);
                                                    tw9Var.L = t;
                                                    if (t >= 0) {
                                                        int i31 = tw9Var.s;
                                                        int i32 = tw9Var.O;
                                                        if (i31 != i32 && (i6 = tw9Var.r) < i32) {
                                                            tw9Var.s = i6;
                                                        } else {
                                                            tw9Var.s = tw9Var.O;
                                                        }
                                                        tw9Var.N = tw9Var.r;
                                                        int i33 = tw9Var.L;
                                                        if (i33 > tw9Var.s) {
                                                            tw9Var.a = 9;
                                                            break;
                                                        } else {
                                                            if (tw9Var.G > 0) {
                                                                int[] iArr8 = tw9Var.q;
                                                                int i34 = tw9Var.t;
                                                                iArr8[i34 & 3] = i33;
                                                                tw9Var.t = i34 + 1;
                                                            }
                                                            if (tw9Var.M <= tw9Var.g) {
                                                                tw9Var.x = 0;
                                                                tw9Var.a = 7;
                                                                int i35 = tw9Var.r;
                                                                i = (i35 - tw9Var.L) & i9;
                                                                i2 = tw9Var.M - tw9Var.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    tw9Var.x += i2;
                                                                    tw9Var.g -= i2;
                                                                    tw9Var.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = tw9Var.x;
                                                                        if (i3 >= tw9Var.M) {
                                                                            i4 = tw9Var.r;
                                                                            bArr[i4] = bArr[(i4 - tw9Var.L) & i9];
                                                                            tw9Var.g--;
                                                                            tw9Var.x = i3 + 1;
                                                                            tw9Var.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    tw9Var.b = 7;
                                                                    tw9Var.Y = tw9Var.Q;
                                                                    tw9Var.X = 0;
                                                                    tw9Var.a = 12;
                                                                    if (tw9Var.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        tw9Var.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (tw9Var.a != i5) {
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
                                        if (tw9Var.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (tw9Var.g > 0) {
                                            kw9.j(kw9Var);
                                            kw9.i(kw9Var, 8);
                                            tw9Var.g--;
                                        }
                                        tw9Var.a = 1;
                                        break;
                                    case 5:
                                        a(tw9Var);
                                        break;
                                    case 6:
                                        if (tw9Var.u) {
                                        }
                                        if (tw9Var.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = tw9Var.r;
                                        i = (i352 - tw9Var.L) & i9;
                                        i2 = tw9Var.M - tw9Var.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = tw9Var.x;
                                            if (i3 >= tw9Var.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        tw9Var.b = 7;
                                        tw9Var.Y = tw9Var.Q;
                                        tw9Var.X = 0;
                                        tw9Var.a = 12;
                                        if (tw9Var.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = tw9Var.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, tw9Var.N - i36);
                                        tw9Var.a = 3;
                                        break;
                                    case 9:
                                        int i37 = tw9Var.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = ow9.a[i37];
                                            int i39 = (tw9Var.L - tw9Var.s) - 1;
                                            int i40 = ow9.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < uw9.d.length) {
                                                int b2 = uw9.b(bArr, tw9Var.N, ow9.a(), i43, tw9Var.M, uw9.d[i42]);
                                                int i44 = tw9Var.N + b2;
                                                tw9Var.N = i44;
                                                tw9Var.r += b2;
                                                tw9Var.g -= b2;
                                                int i45 = tw9Var.Q;
                                                if (i44 >= i45) {
                                                    tw9Var.b = 8;
                                                    tw9Var.Y = i45;
                                                    tw9Var.X = 0;
                                                    tw9Var.a = 12;
                                                    break;
                                                } else {
                                                    tw9Var.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + tw9Var.a);
                                }
                            } else if (!u(tw9Var)) {
                                return;
                            } else {
                                int i46 = tw9Var.r;
                                int i47 = tw9Var.O;
                                if (i46 >= i47) {
                                    tw9Var.s = i47;
                                }
                                tw9Var.r &= i9;
                                tw9Var.a = tw9Var.b;
                            }
                        } else if (i10 == 10) {
                            if (tw9Var.g >= 0) {
                                kw9.g(kw9Var);
                                kw9.a(tw9Var.c, true);
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

    public static void s(tw9 tw9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, tw9Var, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            tw9Var.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, kw9 kw9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, kw9Var)) == null) {
            kw9.d(kw9Var);
            int r = r(iArr, i, kw9Var);
            return sw9.a[r] + kw9.i(kw9Var, sw9.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, kw9 kw9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), kw9Var}) == null) {
            kw9.j(kw9Var);
            int[] iArr2 = new int[i];
            int i3 = kw9.i(kw9Var, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = kw9.i(kw9Var, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = kw9.i(kw9Var, i6) % i;
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
                            if (kw9.i(kw9Var, 1) == 1) {
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
                    pw9.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                kw9.d(kw9Var);
                long j = kw9Var.f;
                int i11 = kw9Var.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                kw9Var.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, kw9Var);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.vw9.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, kw9 kw9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, kw9Var) == null) {
            int[] iArr3 = new int[32];
            pw9.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    kw9.j(kw9Var);
                    kw9.d(kw9Var);
                    long j = kw9Var.f;
                    int i9 = kw9Var.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    kw9Var.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + kw9.i(kw9Var, i13) + 3;
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

    public static void p(tw9 tw9Var) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, tw9Var) == null) {
            kw9 kw9Var = tw9Var.c;
            for (int i = 0; i < 3; i++) {
                tw9Var.o[i] = h(kw9Var) + 1;
                tw9Var.n[i] = 268435456;
                int[] iArr2 = tw9Var.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, tw9Var.e, i2, kw9Var);
                    n(26, tw9Var.f, i2, kw9Var);
                    tw9Var.n[i] = m(tw9Var.f, i2, kw9Var);
                }
            }
            kw9.j(kw9Var);
            tw9Var.K = kw9.i(kw9Var, 2);
            int i3 = kw9.i(kw9Var, 4);
            int i4 = tw9Var.K;
            int i5 = (i3 << i4) + 16;
            tw9Var.I = i5;
            tw9Var.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            tw9Var.z = new byte[tw9Var.o[0]];
            int i7 = 0;
            while (true) {
                iArr = tw9Var.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    tw9Var.z[i7] = (byte) (kw9.i(kw9Var, 2) << 1);
                    i7++;
                }
                kw9.j(kw9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            tw9Var.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, kw9Var);
            tw9Var.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (tw9Var.o[0] << 6)) {
                    break;
                } else if (tw9Var.A[i8] != (i8 >> 6)) {
                    tw9Var.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = tw9Var.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            tw9Var.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, kw9Var);
            qw9.b(tw9Var.k, 256, d2);
            qw9.b(tw9Var.l, 704, tw9Var.o[1]);
            qw9.b(tw9Var.m, i6, d3);
            qw9.a(tw9Var.k, kw9Var);
            qw9.a(tw9Var.l, kw9Var);
            qw9.a(tw9Var.m, kw9Var);
            tw9Var.B = 0;
            tw9Var.C = 0;
            int[] iArr4 = mw9.b;
            byte[] bArr3 = tw9Var.z;
            tw9Var.D = iArr4[bArr3[0]];
            tw9Var.E = iArr4[bArr3[0] + 1];
            tw9Var.v = 0;
            tw9Var.w = tw9Var.k.c[0];
            tw9Var.F = tw9Var.l.c[0];
            int[] iArr5 = tw9Var.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(tw9 tw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, tw9Var) == null) {
            kw9 kw9Var = tw9Var.c;
            if (tw9Var.h) {
                tw9Var.b = 10;
                tw9Var.Y = tw9Var.r;
                tw9Var.X = 0;
                tw9Var.a = 12;
                return;
            }
            qw9 qw9Var = tw9Var.k;
            qw9Var.b = null;
            qw9Var.c = null;
            qw9 qw9Var2 = tw9Var.l;
            qw9Var2.b = null;
            qw9Var2.c = null;
            qw9 qw9Var3 = tw9Var.m;
            qw9Var3.b = null;
            qw9Var3.c = null;
            kw9.j(kw9Var);
            g(kw9Var, tw9Var);
            if (tw9Var.g == 0 && !tw9Var.j) {
                return;
            }
            if (!tw9Var.i && !tw9Var.j) {
                tw9Var.a = 2;
            } else {
                kw9.g(kw9Var);
                if (tw9Var.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                tw9Var.a = i;
            }
            if (tw9Var.j) {
                return;
            }
            tw9Var.R += tw9Var.g;
            if (tw9Var.Q < tw9Var.P) {
                k(tw9Var);
            }
        }
    }

    public static int r(int[] iArr, int i, kw9 kw9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, kw9Var)) == null) {
            long j = kw9Var.f;
            int i2 = kw9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                kw9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            kw9Var.g = i2 + (iArr[i7] >> 16) + 8;
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
