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
public final class wz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948288019, "Lcom/baidu/tieba/wz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948288019, "Lcom/baidu/tieba/wz9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(c0a c0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, c0aVar) == null) {
            tz9 tz9Var = c0aVar.c;
            byte[] bArr = c0aVar.d;
            int i = c0aVar.g;
            if (i <= 0) {
                tz9.k(tz9Var);
                c0aVar.a = 1;
                return;
            }
            int min = Math.min(c0aVar.Q - c0aVar.r, i);
            tz9.c(tz9Var, bArr, c0aVar.r, min);
            c0aVar.g -= min;
            int i2 = c0aVar.r + min;
            c0aVar.r = i2;
            int i3 = c0aVar.Q;
            if (i2 == i3) {
                c0aVar.b = 5;
                c0aVar.Y = i3;
                c0aVar.X = 0;
                c0aVar.a = 12;
                return;
            }
            tz9.k(tz9Var);
            c0aVar.a = 1;
        }
    }

    public static void k(c0a c0aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, c0aVar) == null) {
            int i2 = c0aVar.P;
            long j = c0aVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + c0aVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!c0aVar.h && i2 < 16384 && c0aVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = c0aVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = c0aVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = c0aVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = c0aVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(c0aVar.S, i, bArr, 0, i5);
                    c0aVar.r = i5;
                    c0aVar.T = i5;
                }
            }
            c0aVar.d = bArr;
            c0aVar.Q = i2;
        }
    }

    public static boolean u(c0a c0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, c0aVar)) == null) {
            int i = c0aVar.T;
            if (i != 0) {
                c0aVar.X += i;
                c0aVar.T = 0;
            }
            int min = Math.min(c0aVar.V - c0aVar.W, c0aVar.Y - c0aVar.X);
            if (min != 0) {
                System.arraycopy(c0aVar.d, c0aVar.X, c0aVar.Z, c0aVar.U + c0aVar.W, min);
                c0aVar.W += min;
                c0aVar.X += min;
            }
            if (c0aVar.W >= c0aVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(c0a c0aVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, c0aVar, i) == null) {
            tz9 tz9Var = c0aVar.c;
            int[] iArr = c0aVar.p;
            int i3 = i * 2;
            tz9.d(tz9Var);
            int i4 = i * 1080;
            int r = r(c0aVar.e, i4, tz9Var);
            c0aVar.n[i] = m(c0aVar.f, i4, tz9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = c0aVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(c0a c0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, c0aVar) == null) {
            b(c0aVar, 1);
            c0aVar.F = c0aVar.l.c[c0aVar.p[3]];
        }
    }

    public static void e(c0a c0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, c0aVar) == null) {
            b(c0aVar, 2);
            c0aVar.C = c0aVar.p[5] << 2;
        }
    }

    public static int h(tz9 tz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tz9Var)) == null) {
            if (tz9.i(tz9Var, 1) != 0) {
                int i = tz9.i(tz9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return tz9.i(tz9Var, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, tz9 tz9Var) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, tz9Var)) == null) {
            tz9.j(tz9Var);
            int h = h(tz9Var) + 1;
            if (h == 1) {
                e0a.a(bArr, 0, i);
                return h;
            }
            if (tz9.i(tz9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = tz9.i(tz9Var, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, tz9Var);
            int i3 = 0;
            while (i3 < i) {
                tz9.j(tz9Var);
                tz9.d(tz9Var);
                int r = r(iArr, 0, tz9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + tz9.i(tz9Var, r); i4 != 0; i4--) {
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
            if (tz9.i(tz9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(c0a c0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, c0aVar) == null) {
            b(c0aVar, 0);
            int i = c0aVar.p[1];
            int i2 = i << 6;
            c0aVar.B = i2;
            int i3 = c0aVar.A[i2] & 255;
            c0aVar.v = i3;
            c0aVar.w = c0aVar.k.c[i3];
            byte b2 = c0aVar.z[i];
            int[] iArr = vz9.b;
            c0aVar.D = iArr[b2];
            c0aVar.E = iArr[b2 + 1];
        }
    }

    public static void g(tz9 tz9Var, c0a c0aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tz9Var, c0aVar) == null) {
            boolean z2 = true;
            if (tz9.i(tz9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            c0aVar.h = z;
            c0aVar.g = 0;
            c0aVar.i = false;
            c0aVar.j = false;
            if (z && tz9.i(tz9Var, 1) != 0) {
                return;
            }
            int i = tz9.i(tz9Var, 2) + 4;
            if (i == 7) {
                c0aVar.j = true;
                if (tz9.i(tz9Var, 1) == 0) {
                    int i2 = tz9.i(tz9Var, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = tz9.i(tz9Var, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        c0aVar.g = (i4 << (i3 * 8)) | c0aVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = tz9.i(tz9Var, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    c0aVar.g = (i6 << (i5 * 4)) | c0aVar.g;
                }
            }
            c0aVar.g++;
            if (!c0aVar.h) {
                if (tz9.i(tz9Var, 1) != 1) {
                    z2 = false;
                }
                c0aVar.i = z2;
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
    public static void i(c0a c0aVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, c0aVar) == null) {
            int i8 = c0aVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    tz9 tz9Var = c0aVar.c;
                    int i9 = c0aVar.Q - 1;
                    byte[] bArr = c0aVar.d;
                    while (true) {
                        int i10 = c0aVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (c0aVar.g >= 0) {
                                            q(c0aVar);
                                            i9 = c0aVar.Q - 1;
                                            bArr = c0aVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(c0aVar);
                                        c0aVar.a = 3;
                                        if (c0aVar.g > 0) {
                                            c0aVar.a = 1;
                                            break;
                                        } else {
                                            tz9.j(tz9Var);
                                            if (c0aVar.n[1] == 0) {
                                                c(c0aVar);
                                            }
                                            int[] iArr = c0aVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            tz9.d(tz9Var);
                                            int r = r(c0aVar.l.b, c0aVar.F, tz9Var);
                                            int i12 = r >>> 6;
                                            c0aVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                c0aVar.G = -1;
                                            }
                                            int i13 = b0a.g[i12] + ((r >>> 3) & 7);
                                            int i14 = b0a.h[i12] + (r & 7);
                                            c0aVar.y = b0a.c[i13] + tz9.i(tz9Var, b0a.d[i13]);
                                            c0aVar.M = b0a.e[i14] + tz9.i(tz9Var, b0a.f[i14]);
                                            c0aVar.x = 0;
                                            c0aVar.a = 6;
                                            if (c0aVar.u) {
                                                int i15 = c0aVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (c0aVar.x < c0aVar.y) {
                                                        tz9.j(tz9Var);
                                                        if (c0aVar.n[0] == 0) {
                                                            f(c0aVar);
                                                        }
                                                        byte[] bArr2 = c0aVar.A;
                                                        int i18 = c0aVar.B;
                                                        int[] iArr2 = vz9.a;
                                                        int i19 = iArr2[c0aVar.D + i16];
                                                        int[] iArr3 = c0aVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        tz9.d(tz9Var);
                                                        zz9 zz9Var = c0aVar.k;
                                                        int r2 = r(zz9Var.b, zz9Var.c[bArr2[i18 + (iArr2[c0aVar.E + i17] | i19)] & 255], tz9Var);
                                                        int i20 = c0aVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        c0aVar.x++;
                                                        c0aVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            c0aVar.b = 6;
                                                            c0aVar.Y = c0aVar.Q;
                                                            c0aVar.X = 0;
                                                            c0aVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (c0aVar.x < c0aVar.y) {
                                                        tz9.j(tz9Var);
                                                        if (c0aVar.n[0] == 0) {
                                                            f(c0aVar);
                                                        }
                                                        int[] iArr4 = c0aVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        tz9.d(tz9Var);
                                                        bArr[c0aVar.r] = (byte) r(c0aVar.k.b, c0aVar.w, tz9Var);
                                                        c0aVar.x++;
                                                        int i22 = c0aVar.r;
                                                        c0aVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            c0aVar.b = 6;
                                                            c0aVar.Y = c0aVar.Q;
                                                            c0aVar.X = 0;
                                                            c0aVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (c0aVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = c0aVar.g - c0aVar.y;
                                                c0aVar.g = i23;
                                                if (i23 <= 0) {
                                                    c0aVar.a = 3;
                                                    break;
                                                } else {
                                                    if (c0aVar.G < 0) {
                                                        tz9.j(tz9Var);
                                                        if (c0aVar.n[2] == 0) {
                                                            e(c0aVar);
                                                        }
                                                        int[] iArr5 = c0aVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        tz9.d(tz9Var);
                                                        zz9 zz9Var2 = c0aVar.m;
                                                        int[] iArr6 = zz9Var2.b;
                                                        int[] iArr7 = zz9Var2.c;
                                                        byte[] bArr3 = c0aVar.H;
                                                        int i24 = c0aVar.C;
                                                        int i25 = c0aVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], tz9Var);
                                                        c0aVar.G = r3;
                                                        int i26 = c0aVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            c0aVar.G = i27;
                                                            int i28 = c0aVar.J & i27;
                                                            int i29 = i27 >>> c0aVar.K;
                                                            c0aVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            c0aVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + tz9.i(tz9Var, i30)) << c0aVar.K);
                                                        }
                                                    }
                                                    int t = t(c0aVar.G, c0aVar.q, c0aVar.t);
                                                    c0aVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = c0aVar.s;
                                                        int i32 = c0aVar.O;
                                                        if (i31 != i32 && (i6 = c0aVar.r) < i32) {
                                                            c0aVar.s = i6;
                                                        } else {
                                                            c0aVar.s = c0aVar.O;
                                                        }
                                                        c0aVar.N = c0aVar.r;
                                                        int i33 = c0aVar.L;
                                                        if (i33 > c0aVar.s) {
                                                            c0aVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (c0aVar.G > 0) {
                                                                int[] iArr8 = c0aVar.q;
                                                                int i34 = c0aVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                c0aVar.t = i34 + 1;
                                                            }
                                                            if (c0aVar.M <= c0aVar.g) {
                                                                c0aVar.x = 0;
                                                                c0aVar.a = 7;
                                                                int i35 = c0aVar.r;
                                                                i = (i35 - c0aVar.L) & i9;
                                                                i2 = c0aVar.M - c0aVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    c0aVar.x += i2;
                                                                    c0aVar.g -= i2;
                                                                    c0aVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = c0aVar.x;
                                                                        if (i3 >= c0aVar.M) {
                                                                            i4 = c0aVar.r;
                                                                            bArr[i4] = bArr[(i4 - c0aVar.L) & i9];
                                                                            c0aVar.g--;
                                                                            c0aVar.x = i3 + 1;
                                                                            c0aVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    c0aVar.b = 7;
                                                                    c0aVar.Y = c0aVar.Q;
                                                                    c0aVar.X = 0;
                                                                    c0aVar.a = 12;
                                                                    if (c0aVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        c0aVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (c0aVar.a != i5) {
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
                                        if (c0aVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (c0aVar.g > 0) {
                                            tz9.j(tz9Var);
                                            tz9.i(tz9Var, 8);
                                            c0aVar.g--;
                                        }
                                        c0aVar.a = 1;
                                        break;
                                    case 5:
                                        a(c0aVar);
                                        break;
                                    case 6:
                                        if (c0aVar.u) {
                                        }
                                        if (c0aVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = c0aVar.r;
                                        i = (i352 - c0aVar.L) & i9;
                                        i2 = c0aVar.M - c0aVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = c0aVar.x;
                                            if (i3 >= c0aVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        c0aVar.b = 7;
                                        c0aVar.Y = c0aVar.Q;
                                        c0aVar.X = 0;
                                        c0aVar.a = 12;
                                        if (c0aVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = c0aVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, c0aVar.N - i36);
                                        c0aVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = c0aVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = xz9.a[i37];
                                            int i39 = (c0aVar.L - c0aVar.s) - 1;
                                            int i40 = xz9.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < d0a.d.length) {
                                                int b2 = d0a.b(bArr, c0aVar.N, xz9.a(), i43, c0aVar.M, d0a.d[i42]);
                                                int i44 = c0aVar.N + b2;
                                                c0aVar.N = i44;
                                                c0aVar.r += b2;
                                                c0aVar.g -= b2;
                                                int i45 = c0aVar.Q;
                                                if (i44 >= i45) {
                                                    c0aVar.b = 8;
                                                    c0aVar.Y = i45;
                                                    c0aVar.X = 0;
                                                    c0aVar.a = 12;
                                                    break;
                                                } else {
                                                    c0aVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + c0aVar.a);
                                }
                            } else if (!u(c0aVar)) {
                                return;
                            } else {
                                int i46 = c0aVar.r;
                                int i47 = c0aVar.O;
                                if (i46 >= i47) {
                                    c0aVar.s = i47;
                                }
                                c0aVar.r &= i9;
                                c0aVar.a = c0aVar.b;
                            }
                        } else if (i10 == 10) {
                            if (c0aVar.g >= 0) {
                                tz9.g(tz9Var);
                                tz9.a(c0aVar.c, true);
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

    public static void s(c0a c0aVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, c0aVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            c0aVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, tz9 tz9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, tz9Var)) == null) {
            tz9.d(tz9Var);
            int r = r(iArr, i, tz9Var);
            return b0a.a[r] + tz9.i(tz9Var, b0a.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, tz9 tz9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), tz9Var}) == null) {
            tz9.j(tz9Var);
            int[] iArr2 = new int[i];
            int i3 = tz9.i(tz9Var, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = tz9.i(tz9Var, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = tz9.i(tz9Var, i6) % i;
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
                            if (tz9.i(tz9Var, 1) == 1) {
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
                    yz9.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                tz9.d(tz9Var);
                long j = tz9Var.f;
                int i11 = tz9Var.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                tz9Var.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, tz9Var);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.e0a.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, tz9 tz9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, tz9Var) == null) {
            int[] iArr3 = new int[32];
            yz9.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    tz9.j(tz9Var);
                    tz9.d(tz9Var);
                    long j = tz9Var.f;
                    int i9 = tz9Var.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    tz9Var.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + tz9.i(tz9Var, i13) + 3;
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

    public static void p(c0a c0aVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, c0aVar) == null) {
            tz9 tz9Var = c0aVar.c;
            for (int i = 0; i < 3; i++) {
                c0aVar.o[i] = h(tz9Var) + 1;
                c0aVar.n[i] = 268435456;
                int[] iArr2 = c0aVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, c0aVar.e, i2, tz9Var);
                    n(26, c0aVar.f, i2, tz9Var);
                    c0aVar.n[i] = m(c0aVar.f, i2, tz9Var);
                }
            }
            tz9.j(tz9Var);
            c0aVar.K = tz9.i(tz9Var, 2);
            int i3 = tz9.i(tz9Var, 4);
            int i4 = c0aVar.K;
            int i5 = (i3 << i4) + 16;
            c0aVar.I = i5;
            c0aVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            c0aVar.z = new byte[c0aVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = c0aVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    c0aVar.z[i7] = (byte) (tz9.i(tz9Var, 2) << 1);
                    i7++;
                }
                tz9.j(tz9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            c0aVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, tz9Var);
            c0aVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (c0aVar.o[0] << 6)) {
                    break;
                } else if (c0aVar.A[i8] != (i8 >> 6)) {
                    c0aVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = c0aVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            c0aVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, tz9Var);
            zz9.b(c0aVar.k, 256, d2);
            zz9.b(c0aVar.l, 704, c0aVar.o[1]);
            zz9.b(c0aVar.m, i6, d3);
            zz9.a(c0aVar.k, tz9Var);
            zz9.a(c0aVar.l, tz9Var);
            zz9.a(c0aVar.m, tz9Var);
            c0aVar.B = 0;
            c0aVar.C = 0;
            int[] iArr4 = vz9.b;
            byte[] bArr3 = c0aVar.z;
            c0aVar.D = iArr4[bArr3[0]];
            c0aVar.E = iArr4[bArr3[0] + 1];
            c0aVar.v = 0;
            c0aVar.w = c0aVar.k.c[0];
            c0aVar.F = c0aVar.l.c[0];
            int[] iArr5 = c0aVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(c0a c0aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, c0aVar) == null) {
            tz9 tz9Var = c0aVar.c;
            if (c0aVar.h) {
                c0aVar.b = 10;
                c0aVar.Y = c0aVar.r;
                c0aVar.X = 0;
                c0aVar.a = 12;
                return;
            }
            zz9 zz9Var = c0aVar.k;
            zz9Var.b = null;
            zz9Var.c = null;
            zz9 zz9Var2 = c0aVar.l;
            zz9Var2.b = null;
            zz9Var2.c = null;
            zz9 zz9Var3 = c0aVar.m;
            zz9Var3.b = null;
            zz9Var3.c = null;
            tz9.j(tz9Var);
            g(tz9Var, c0aVar);
            if (c0aVar.g == 0 && !c0aVar.j) {
                return;
            }
            if (!c0aVar.i && !c0aVar.j) {
                c0aVar.a = 2;
            } else {
                tz9.g(tz9Var);
                if (c0aVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                c0aVar.a = i;
            }
            if (c0aVar.j) {
                return;
            }
            c0aVar.R += c0aVar.g;
            if (c0aVar.Q < c0aVar.P) {
                k(c0aVar);
            }
        }
    }

    public static int r(int[] iArr, int i, tz9 tz9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, tz9Var)) == null) {
            long j = tz9Var.f;
            int i2 = tz9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                tz9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            tz9Var.g = i2 + (iArr[i7] >> 16) + 8;
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
