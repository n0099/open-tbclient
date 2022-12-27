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
public final class xz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948317810, "Lcom/baidu/tieba/xz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948317810, "Lcom/baidu/tieba/xz9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(d0a d0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, d0aVar) == null) {
            uz9 uz9Var = d0aVar.c;
            byte[] bArr = d0aVar.d;
            int i = d0aVar.g;
            if (i <= 0) {
                uz9.k(uz9Var);
                d0aVar.a = 1;
                return;
            }
            int min = Math.min(d0aVar.Q - d0aVar.r, i);
            uz9.c(uz9Var, bArr, d0aVar.r, min);
            d0aVar.g -= min;
            int i2 = d0aVar.r + min;
            d0aVar.r = i2;
            int i3 = d0aVar.Q;
            if (i2 == i3) {
                d0aVar.b = 5;
                d0aVar.Y = i3;
                d0aVar.X = 0;
                d0aVar.a = 12;
                return;
            }
            uz9.k(uz9Var);
            d0aVar.a = 1;
        }
    }

    public static void k(d0a d0aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, d0aVar) == null) {
            int i2 = d0aVar.P;
            long j = d0aVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + d0aVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!d0aVar.h && i2 < 16384 && d0aVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = d0aVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = d0aVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = d0aVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = d0aVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(d0aVar.S, i, bArr, 0, i5);
                    d0aVar.r = i5;
                    d0aVar.T = i5;
                }
            }
            d0aVar.d = bArr;
            d0aVar.Q = i2;
        }
    }

    public static boolean u(d0a d0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, d0aVar)) == null) {
            int i = d0aVar.T;
            if (i != 0) {
                d0aVar.X += i;
                d0aVar.T = 0;
            }
            int min = Math.min(d0aVar.V - d0aVar.W, d0aVar.Y - d0aVar.X);
            if (min != 0) {
                System.arraycopy(d0aVar.d, d0aVar.X, d0aVar.Z, d0aVar.U + d0aVar.W, min);
                d0aVar.W += min;
                d0aVar.X += min;
            }
            if (d0aVar.W >= d0aVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(d0a d0aVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, d0aVar, i) == null) {
            uz9 uz9Var = d0aVar.c;
            int[] iArr = d0aVar.p;
            int i3 = i * 2;
            uz9.d(uz9Var);
            int i4 = i * 1080;
            int r = r(d0aVar.e, i4, uz9Var);
            d0aVar.n[i] = m(d0aVar.f, i4, uz9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = d0aVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(d0a d0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, d0aVar) == null) {
            b(d0aVar, 1);
            d0aVar.F = d0aVar.l.c[d0aVar.p[3]];
        }
    }

    public static void e(d0a d0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, d0aVar) == null) {
            b(d0aVar, 2);
            d0aVar.C = d0aVar.p[5] << 2;
        }
    }

    public static int h(uz9 uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uz9Var)) == null) {
            if (uz9.i(uz9Var, 1) != 0) {
                int i = uz9.i(uz9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return uz9.i(uz9Var, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, uz9 uz9Var) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, uz9Var)) == null) {
            uz9.j(uz9Var);
            int h = h(uz9Var) + 1;
            if (h == 1) {
                f0a.a(bArr, 0, i);
                return h;
            }
            if (uz9.i(uz9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = uz9.i(uz9Var, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, uz9Var);
            int i3 = 0;
            while (i3 < i) {
                uz9.j(uz9Var);
                uz9.d(uz9Var);
                int r = r(iArr, 0, uz9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + uz9.i(uz9Var, r); i4 != 0; i4--) {
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
            if (uz9.i(uz9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(d0a d0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, d0aVar) == null) {
            b(d0aVar, 0);
            int i = d0aVar.p[1];
            int i2 = i << 6;
            d0aVar.B = i2;
            int i3 = d0aVar.A[i2] & 255;
            d0aVar.v = i3;
            d0aVar.w = d0aVar.k.c[i3];
            byte b2 = d0aVar.z[i];
            int[] iArr = wz9.b;
            d0aVar.D = iArr[b2];
            d0aVar.E = iArr[b2 + 1];
        }
    }

    public static void g(uz9 uz9Var, d0a d0aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, uz9Var, d0aVar) == null) {
            boolean z2 = true;
            if (uz9.i(uz9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            d0aVar.h = z;
            d0aVar.g = 0;
            d0aVar.i = false;
            d0aVar.j = false;
            if (z && uz9.i(uz9Var, 1) != 0) {
                return;
            }
            int i = uz9.i(uz9Var, 2) + 4;
            if (i == 7) {
                d0aVar.j = true;
                if (uz9.i(uz9Var, 1) == 0) {
                    int i2 = uz9.i(uz9Var, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = uz9.i(uz9Var, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        d0aVar.g = (i4 << (i3 * 8)) | d0aVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = uz9.i(uz9Var, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    d0aVar.g = (i6 << (i5 * 4)) | d0aVar.g;
                }
            }
            d0aVar.g++;
            if (!d0aVar.h) {
                if (uz9.i(uz9Var, 1) != 1) {
                    z2 = false;
                }
                d0aVar.i = z2;
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
    public static void i(d0a d0aVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, d0aVar) == null) {
            int i8 = d0aVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    uz9 uz9Var = d0aVar.c;
                    int i9 = d0aVar.Q - 1;
                    byte[] bArr = d0aVar.d;
                    while (true) {
                        int i10 = d0aVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (d0aVar.g >= 0) {
                                            q(d0aVar);
                                            i9 = d0aVar.Q - 1;
                                            bArr = d0aVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(d0aVar);
                                        d0aVar.a = 3;
                                        if (d0aVar.g > 0) {
                                            d0aVar.a = 1;
                                            break;
                                        } else {
                                            uz9.j(uz9Var);
                                            if (d0aVar.n[1] == 0) {
                                                c(d0aVar);
                                            }
                                            int[] iArr = d0aVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            uz9.d(uz9Var);
                                            int r = r(d0aVar.l.b, d0aVar.F, uz9Var);
                                            int i12 = r >>> 6;
                                            d0aVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                d0aVar.G = -1;
                                            }
                                            int i13 = c0a.g[i12] + ((r >>> 3) & 7);
                                            int i14 = c0a.h[i12] + (r & 7);
                                            d0aVar.y = c0a.c[i13] + uz9.i(uz9Var, c0a.d[i13]);
                                            d0aVar.M = c0a.e[i14] + uz9.i(uz9Var, c0a.f[i14]);
                                            d0aVar.x = 0;
                                            d0aVar.a = 6;
                                            if (d0aVar.u) {
                                                int i15 = d0aVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (d0aVar.x < d0aVar.y) {
                                                        uz9.j(uz9Var);
                                                        if (d0aVar.n[0] == 0) {
                                                            f(d0aVar);
                                                        }
                                                        byte[] bArr2 = d0aVar.A;
                                                        int i18 = d0aVar.B;
                                                        int[] iArr2 = wz9.a;
                                                        int i19 = iArr2[d0aVar.D + i16];
                                                        int[] iArr3 = d0aVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        uz9.d(uz9Var);
                                                        a0a a0aVar = d0aVar.k;
                                                        int r2 = r(a0aVar.b, a0aVar.c[bArr2[i18 + (iArr2[d0aVar.E + i17] | i19)] & 255], uz9Var);
                                                        int i20 = d0aVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        d0aVar.x++;
                                                        d0aVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            d0aVar.b = 6;
                                                            d0aVar.Y = d0aVar.Q;
                                                            d0aVar.X = 0;
                                                            d0aVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (d0aVar.x < d0aVar.y) {
                                                        uz9.j(uz9Var);
                                                        if (d0aVar.n[0] == 0) {
                                                            f(d0aVar);
                                                        }
                                                        int[] iArr4 = d0aVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        uz9.d(uz9Var);
                                                        bArr[d0aVar.r] = (byte) r(d0aVar.k.b, d0aVar.w, uz9Var);
                                                        d0aVar.x++;
                                                        int i22 = d0aVar.r;
                                                        d0aVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            d0aVar.b = 6;
                                                            d0aVar.Y = d0aVar.Q;
                                                            d0aVar.X = 0;
                                                            d0aVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (d0aVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = d0aVar.g - d0aVar.y;
                                                d0aVar.g = i23;
                                                if (i23 <= 0) {
                                                    d0aVar.a = 3;
                                                    break;
                                                } else {
                                                    if (d0aVar.G < 0) {
                                                        uz9.j(uz9Var);
                                                        if (d0aVar.n[2] == 0) {
                                                            e(d0aVar);
                                                        }
                                                        int[] iArr5 = d0aVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        uz9.d(uz9Var);
                                                        a0a a0aVar2 = d0aVar.m;
                                                        int[] iArr6 = a0aVar2.b;
                                                        int[] iArr7 = a0aVar2.c;
                                                        byte[] bArr3 = d0aVar.H;
                                                        int i24 = d0aVar.C;
                                                        int i25 = d0aVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], uz9Var);
                                                        d0aVar.G = r3;
                                                        int i26 = d0aVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            d0aVar.G = i27;
                                                            int i28 = d0aVar.J & i27;
                                                            int i29 = i27 >>> d0aVar.K;
                                                            d0aVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            d0aVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + uz9.i(uz9Var, i30)) << d0aVar.K);
                                                        }
                                                    }
                                                    int t = t(d0aVar.G, d0aVar.q, d0aVar.t);
                                                    d0aVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = d0aVar.s;
                                                        int i32 = d0aVar.O;
                                                        if (i31 != i32 && (i6 = d0aVar.r) < i32) {
                                                            d0aVar.s = i6;
                                                        } else {
                                                            d0aVar.s = d0aVar.O;
                                                        }
                                                        d0aVar.N = d0aVar.r;
                                                        int i33 = d0aVar.L;
                                                        if (i33 > d0aVar.s) {
                                                            d0aVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (d0aVar.G > 0) {
                                                                int[] iArr8 = d0aVar.q;
                                                                int i34 = d0aVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                d0aVar.t = i34 + 1;
                                                            }
                                                            if (d0aVar.M <= d0aVar.g) {
                                                                d0aVar.x = 0;
                                                                d0aVar.a = 7;
                                                                int i35 = d0aVar.r;
                                                                i = (i35 - d0aVar.L) & i9;
                                                                i2 = d0aVar.M - d0aVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    d0aVar.x += i2;
                                                                    d0aVar.g -= i2;
                                                                    d0aVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = d0aVar.x;
                                                                        if (i3 >= d0aVar.M) {
                                                                            i4 = d0aVar.r;
                                                                            bArr[i4] = bArr[(i4 - d0aVar.L) & i9];
                                                                            d0aVar.g--;
                                                                            d0aVar.x = i3 + 1;
                                                                            d0aVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    d0aVar.b = 7;
                                                                    d0aVar.Y = d0aVar.Q;
                                                                    d0aVar.X = 0;
                                                                    d0aVar.a = 12;
                                                                    if (d0aVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        d0aVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (d0aVar.a != i5) {
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
                                        if (d0aVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (d0aVar.g > 0) {
                                            uz9.j(uz9Var);
                                            uz9.i(uz9Var, 8);
                                            d0aVar.g--;
                                        }
                                        d0aVar.a = 1;
                                        break;
                                    case 5:
                                        a(d0aVar);
                                        break;
                                    case 6:
                                        if (d0aVar.u) {
                                        }
                                        if (d0aVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = d0aVar.r;
                                        i = (i352 - d0aVar.L) & i9;
                                        i2 = d0aVar.M - d0aVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = d0aVar.x;
                                            if (i3 >= d0aVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        d0aVar.b = 7;
                                        d0aVar.Y = d0aVar.Q;
                                        d0aVar.X = 0;
                                        d0aVar.a = 12;
                                        if (d0aVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = d0aVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, d0aVar.N - i36);
                                        d0aVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = d0aVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = yz9.a[i37];
                                            int i39 = (d0aVar.L - d0aVar.s) - 1;
                                            int i40 = yz9.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < e0a.d.length) {
                                                int b2 = e0a.b(bArr, d0aVar.N, yz9.a(), i43, d0aVar.M, e0a.d[i42]);
                                                int i44 = d0aVar.N + b2;
                                                d0aVar.N = i44;
                                                d0aVar.r += b2;
                                                d0aVar.g -= b2;
                                                int i45 = d0aVar.Q;
                                                if (i44 >= i45) {
                                                    d0aVar.b = 8;
                                                    d0aVar.Y = i45;
                                                    d0aVar.X = 0;
                                                    d0aVar.a = 12;
                                                    break;
                                                } else {
                                                    d0aVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + d0aVar.a);
                                }
                            } else if (!u(d0aVar)) {
                                return;
                            } else {
                                int i46 = d0aVar.r;
                                int i47 = d0aVar.O;
                                if (i46 >= i47) {
                                    d0aVar.s = i47;
                                }
                                d0aVar.r &= i9;
                                d0aVar.a = d0aVar.b;
                            }
                        } else if (i10 == 10) {
                            if (d0aVar.g >= 0) {
                                uz9.g(uz9Var);
                                uz9.a(d0aVar.c, true);
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

    public static void s(d0a d0aVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, d0aVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            d0aVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, uz9 uz9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, uz9Var)) == null) {
            uz9.d(uz9Var);
            int r = r(iArr, i, uz9Var);
            return c0a.a[r] + uz9.i(uz9Var, c0a.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, uz9 uz9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), uz9Var}) == null) {
            uz9.j(uz9Var);
            int[] iArr2 = new int[i];
            int i3 = uz9.i(uz9Var, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = uz9.i(uz9Var, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = uz9.i(uz9Var, i6) % i;
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
                            if (uz9.i(uz9Var, 1) == 1) {
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
                    zz9.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                uz9.d(uz9Var);
                long j = uz9Var.f;
                int i11 = uz9Var.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                uz9Var.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, uz9Var);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.f0a.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, uz9 uz9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, uz9Var) == null) {
            int[] iArr3 = new int[32];
            zz9.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    uz9.j(uz9Var);
                    uz9.d(uz9Var);
                    long j = uz9Var.f;
                    int i9 = uz9Var.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    uz9Var.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + uz9.i(uz9Var, i13) + 3;
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

    public static void p(d0a d0aVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, d0aVar) == null) {
            uz9 uz9Var = d0aVar.c;
            for (int i = 0; i < 3; i++) {
                d0aVar.o[i] = h(uz9Var) + 1;
                d0aVar.n[i] = 268435456;
                int[] iArr2 = d0aVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, d0aVar.e, i2, uz9Var);
                    n(26, d0aVar.f, i2, uz9Var);
                    d0aVar.n[i] = m(d0aVar.f, i2, uz9Var);
                }
            }
            uz9.j(uz9Var);
            d0aVar.K = uz9.i(uz9Var, 2);
            int i3 = uz9.i(uz9Var, 4);
            int i4 = d0aVar.K;
            int i5 = (i3 << i4) + 16;
            d0aVar.I = i5;
            d0aVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            d0aVar.z = new byte[d0aVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = d0aVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    d0aVar.z[i7] = (byte) (uz9.i(uz9Var, 2) << 1);
                    i7++;
                }
                uz9.j(uz9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            d0aVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, uz9Var);
            d0aVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (d0aVar.o[0] << 6)) {
                    break;
                } else if (d0aVar.A[i8] != (i8 >> 6)) {
                    d0aVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = d0aVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            d0aVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, uz9Var);
            a0a.b(d0aVar.k, 256, d2);
            a0a.b(d0aVar.l, 704, d0aVar.o[1]);
            a0a.b(d0aVar.m, i6, d3);
            a0a.a(d0aVar.k, uz9Var);
            a0a.a(d0aVar.l, uz9Var);
            a0a.a(d0aVar.m, uz9Var);
            d0aVar.B = 0;
            d0aVar.C = 0;
            int[] iArr4 = wz9.b;
            byte[] bArr3 = d0aVar.z;
            d0aVar.D = iArr4[bArr3[0]];
            d0aVar.E = iArr4[bArr3[0] + 1];
            d0aVar.v = 0;
            d0aVar.w = d0aVar.k.c[0];
            d0aVar.F = d0aVar.l.c[0];
            int[] iArr5 = d0aVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(d0a d0aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, d0aVar) == null) {
            uz9 uz9Var = d0aVar.c;
            if (d0aVar.h) {
                d0aVar.b = 10;
                d0aVar.Y = d0aVar.r;
                d0aVar.X = 0;
                d0aVar.a = 12;
                return;
            }
            a0a a0aVar = d0aVar.k;
            a0aVar.b = null;
            a0aVar.c = null;
            a0a a0aVar2 = d0aVar.l;
            a0aVar2.b = null;
            a0aVar2.c = null;
            a0a a0aVar3 = d0aVar.m;
            a0aVar3.b = null;
            a0aVar3.c = null;
            uz9.j(uz9Var);
            g(uz9Var, d0aVar);
            if (d0aVar.g == 0 && !d0aVar.j) {
                return;
            }
            if (!d0aVar.i && !d0aVar.j) {
                d0aVar.a = 2;
            } else {
                uz9.g(uz9Var);
                if (d0aVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                d0aVar.a = i;
            }
            if (d0aVar.j) {
                return;
            }
            d0aVar.R += d0aVar.g;
            if (d0aVar.Q < d0aVar.P) {
                k(d0aVar);
            }
        }
    }

    public static int r(int[] iArr, int i, uz9 uz9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, uz9Var)) == null) {
            long j = uz9Var.f;
            int i2 = uz9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                uz9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            uz9Var.g = i2 + (iArr[i7] >> 16) + 8;
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
