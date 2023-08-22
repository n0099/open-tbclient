package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes8.dex */
public final class x4c {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948251842, "Lcom/baidu/tieba/x4c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948251842, "Lcom/baidu/tieba/x4c;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(d5c d5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, d5cVar) == null) {
            u4c u4cVar = d5cVar.c;
            byte[] bArr = d5cVar.d;
            int i = d5cVar.g;
            if (i <= 0) {
                u4c.k(u4cVar);
                d5cVar.a = 1;
                return;
            }
            int min = Math.min(d5cVar.Q - d5cVar.r, i);
            u4c.c(u4cVar, bArr, d5cVar.r, min);
            d5cVar.g -= min;
            int i2 = d5cVar.r + min;
            d5cVar.r = i2;
            int i3 = d5cVar.Q;
            if (i2 == i3) {
                d5cVar.b = 5;
                d5cVar.Y = i3;
                d5cVar.X = 0;
                d5cVar.a = 12;
                return;
            }
            u4c.k(u4cVar);
            d5cVar.a = 1;
        }
    }

    public static void k(d5c d5cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, d5cVar) == null) {
            int i2 = d5cVar.P;
            long j = d5cVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + d5cVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!d5cVar.h && i2 < 16384 && d5cVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = d5cVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = d5cVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = d5cVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = d5cVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(d5cVar.S, i, bArr, 0, i5);
                    d5cVar.r = i5;
                    d5cVar.f1099T = i5;
                }
            }
            d5cVar.d = bArr;
            d5cVar.Q = i2;
        }
    }

    public static boolean u(d5c d5cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, d5cVar)) == null) {
            int i = d5cVar.f1099T;
            if (i != 0) {
                d5cVar.X += i;
                d5cVar.f1099T = 0;
            }
            int min = Math.min(d5cVar.V - d5cVar.W, d5cVar.Y - d5cVar.X);
            if (min != 0) {
                System.arraycopy(d5cVar.d, d5cVar.X, d5cVar.Z, d5cVar.U + d5cVar.W, min);
                d5cVar.W += min;
                d5cVar.X += min;
            }
            if (d5cVar.W >= d5cVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(d5c d5cVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, d5cVar, i) == null) {
            u4c u4cVar = d5cVar.c;
            int[] iArr = d5cVar.p;
            int i3 = i * 2;
            u4c.d(u4cVar);
            int i4 = i * 1080;
            int r = r(d5cVar.e, i4, u4cVar);
            d5cVar.n[i] = m(d5cVar.f, i4, u4cVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = d5cVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(d5c d5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, d5cVar) == null) {
            b(d5cVar, 1);
            d5cVar.F = d5cVar.l.c[d5cVar.p[3]];
        }
    }

    public static void e(d5c d5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, d5cVar) == null) {
            b(d5cVar, 2);
            d5cVar.C = d5cVar.p[5] << 2;
        }
    }

    public static int h(u4c u4cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, u4cVar)) == null) {
            if (u4c.i(u4cVar, 1) != 0) {
                int i = u4c.i(u4cVar, 3);
                if (i == 0) {
                    return 1;
                }
                return u4c.i(u4cVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, u4c u4cVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, u4cVar)) == null) {
            u4c.j(u4cVar);
            int h = h(u4cVar) + 1;
            if (h == 1) {
                f5c.a(bArr, 0, i);
                return h;
            }
            if (u4c.i(u4cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = u4c.i(u4cVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, u4cVar);
            int i3 = 0;
            while (i3 < i) {
                u4c.j(u4cVar);
                u4c.d(u4cVar);
                int r = r(iArr, 0, u4cVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + u4c.i(u4cVar, r); i4 != 0; i4--) {
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
            if (u4c.i(u4cVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(d5c d5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, d5cVar) == null) {
            b(d5cVar, 0);
            int i = d5cVar.p[1];
            int i2 = i << 6;
            d5cVar.B = i2;
            int i3 = d5cVar.A[i2] & 255;
            d5cVar.v = i3;
            d5cVar.w = d5cVar.k.c[i3];
            byte b2 = d5cVar.z[i];
            int[] iArr = w4c.b;
            d5cVar.D = iArr[b2];
            d5cVar.E = iArr[b2 + 1];
        }
    }

    public static void g(u4c u4cVar, d5c d5cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, u4cVar, d5cVar) == null) {
            boolean z2 = true;
            if (u4c.i(u4cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            d5cVar.h = z;
            d5cVar.g = 0;
            d5cVar.i = false;
            d5cVar.j = false;
            if (z && u4c.i(u4cVar, 1) != 0) {
                return;
            }
            int i = u4c.i(u4cVar, 2) + 4;
            if (i == 7) {
                d5cVar.j = true;
                if (u4c.i(u4cVar, 1) == 0) {
                    int i2 = u4c.i(u4cVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = u4c.i(u4cVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        d5cVar.g = (i4 << (i3 * 8)) | d5cVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = u4c.i(u4cVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    d5cVar.g = (i6 << (i5 * 4)) | d5cVar.g;
                }
            }
            d5cVar.g++;
            if (!d5cVar.h) {
                if (u4c.i(u4cVar, 1) != 1) {
                    z2 = false;
                }
                d5cVar.i = z2;
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
    public static void i(d5c d5cVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, d5cVar) == null) {
            int i8 = d5cVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    u4c u4cVar = d5cVar.c;
                    int i9 = d5cVar.Q - 1;
                    byte[] bArr = d5cVar.d;
                    while (true) {
                        int i10 = d5cVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (d5cVar.g >= 0) {
                                            q(d5cVar);
                                            i9 = d5cVar.Q - 1;
                                            bArr = d5cVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(d5cVar);
                                        d5cVar.a = 3;
                                        if (d5cVar.g > 0) {
                                            d5cVar.a = 1;
                                            break;
                                        } else {
                                            u4c.j(u4cVar);
                                            if (d5cVar.n[1] == 0) {
                                                c(d5cVar);
                                            }
                                            int[] iArr = d5cVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            u4c.d(u4cVar);
                                            int r = r(d5cVar.l.b, d5cVar.F, u4cVar);
                                            int i12 = r >>> 6;
                                            d5cVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                d5cVar.G = -1;
                                            }
                                            int i13 = c5c.g[i12] + ((r >>> 3) & 7);
                                            int i14 = c5c.h[i12] + (r & 7);
                                            d5cVar.y = c5c.c[i13] + u4c.i(u4cVar, c5c.d[i13]);
                                            d5cVar.M = c5c.e[i14] + u4c.i(u4cVar, c5c.f[i14]);
                                            d5cVar.x = 0;
                                            d5cVar.a = 6;
                                            if (d5cVar.u) {
                                                int i15 = d5cVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (d5cVar.x < d5cVar.y) {
                                                        u4c.j(u4cVar);
                                                        if (d5cVar.n[0] == 0) {
                                                            f(d5cVar);
                                                        }
                                                        byte[] bArr2 = d5cVar.A;
                                                        int i18 = d5cVar.B;
                                                        int[] iArr2 = w4c.a;
                                                        int i19 = iArr2[d5cVar.D + i16];
                                                        int[] iArr3 = d5cVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        u4c.d(u4cVar);
                                                        a5c a5cVar = d5cVar.k;
                                                        int r2 = r(a5cVar.b, a5cVar.c[bArr2[i18 + (iArr2[d5cVar.E + i17] | i19)] & 255], u4cVar);
                                                        int i20 = d5cVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        d5cVar.x++;
                                                        d5cVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            d5cVar.b = 6;
                                                            d5cVar.Y = d5cVar.Q;
                                                            d5cVar.X = 0;
                                                            d5cVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (d5cVar.x < d5cVar.y) {
                                                        u4c.j(u4cVar);
                                                        if (d5cVar.n[0] == 0) {
                                                            f(d5cVar);
                                                        }
                                                        int[] iArr4 = d5cVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        u4c.d(u4cVar);
                                                        bArr[d5cVar.r] = (byte) r(d5cVar.k.b, d5cVar.w, u4cVar);
                                                        d5cVar.x++;
                                                        int i22 = d5cVar.r;
                                                        d5cVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            d5cVar.b = 6;
                                                            d5cVar.Y = d5cVar.Q;
                                                            d5cVar.X = 0;
                                                            d5cVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (d5cVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = d5cVar.g - d5cVar.y;
                                                d5cVar.g = i23;
                                                if (i23 <= 0) {
                                                    d5cVar.a = 3;
                                                    break;
                                                } else {
                                                    if (d5cVar.G < 0) {
                                                        u4c.j(u4cVar);
                                                        if (d5cVar.n[2] == 0) {
                                                            e(d5cVar);
                                                        }
                                                        int[] iArr5 = d5cVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        u4c.d(u4cVar);
                                                        a5c a5cVar2 = d5cVar.m;
                                                        int[] iArr6 = a5cVar2.b;
                                                        int[] iArr7 = a5cVar2.c;
                                                        byte[] bArr3 = d5cVar.H;
                                                        int i24 = d5cVar.C;
                                                        int i25 = d5cVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], u4cVar);
                                                        d5cVar.G = r3;
                                                        int i26 = d5cVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            d5cVar.G = i27;
                                                            int i28 = d5cVar.J & i27;
                                                            int i29 = i27 >>> d5cVar.K;
                                                            d5cVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            d5cVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + u4c.i(u4cVar, i30)) << d5cVar.K);
                                                        }
                                                    }
                                                    int t = t(d5cVar.G, d5cVar.q, d5cVar.t);
                                                    d5cVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = d5cVar.s;
                                                        int i32 = d5cVar.O;
                                                        if (i31 != i32 && (i6 = d5cVar.r) < i32) {
                                                            d5cVar.s = i6;
                                                        } else {
                                                            d5cVar.s = d5cVar.O;
                                                        }
                                                        d5cVar.N = d5cVar.r;
                                                        int i33 = d5cVar.L;
                                                        if (i33 > d5cVar.s) {
                                                            d5cVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (d5cVar.G > 0) {
                                                                int[] iArr8 = d5cVar.q;
                                                                int i34 = d5cVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                d5cVar.t = i34 + 1;
                                                            }
                                                            if (d5cVar.M <= d5cVar.g) {
                                                                d5cVar.x = 0;
                                                                d5cVar.a = 7;
                                                                int i35 = d5cVar.r;
                                                                i = (i35 - d5cVar.L) & i9;
                                                                i2 = d5cVar.M - d5cVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    d5cVar.x += i2;
                                                                    d5cVar.g -= i2;
                                                                    d5cVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = d5cVar.x;
                                                                        if (i3 >= d5cVar.M) {
                                                                            i4 = d5cVar.r;
                                                                            bArr[i4] = bArr[(i4 - d5cVar.L) & i9];
                                                                            d5cVar.g--;
                                                                            d5cVar.x = i3 + 1;
                                                                            d5cVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    d5cVar.b = 7;
                                                                    d5cVar.Y = d5cVar.Q;
                                                                    d5cVar.X = 0;
                                                                    d5cVar.a = 12;
                                                                    if (d5cVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        d5cVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (d5cVar.a != i5) {
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
                                        if (d5cVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (d5cVar.g > 0) {
                                            u4c.j(u4cVar);
                                            u4c.i(u4cVar, 8);
                                            d5cVar.g--;
                                        }
                                        d5cVar.a = 1;
                                        break;
                                    case 5:
                                        a(d5cVar);
                                        break;
                                    case 6:
                                        if (d5cVar.u) {
                                        }
                                        if (d5cVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = d5cVar.r;
                                        i = (i352 - d5cVar.L) & i9;
                                        i2 = d5cVar.M - d5cVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = d5cVar.x;
                                            if (i3 >= d5cVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        d5cVar.b = 7;
                                        d5cVar.Y = d5cVar.Q;
                                        d5cVar.X = 0;
                                        d5cVar.a = 12;
                                        if (d5cVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = d5cVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, d5cVar.N - i36);
                                        d5cVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = d5cVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = y4c.a[i37];
                                            int i39 = (d5cVar.L - d5cVar.s) - 1;
                                            int i40 = y4c.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < e5c.d.length) {
                                                int b2 = e5c.b(bArr, d5cVar.N, y4c.a(), i43, d5cVar.M, e5c.d[i42]);
                                                int i44 = d5cVar.N + b2;
                                                d5cVar.N = i44;
                                                d5cVar.r += b2;
                                                d5cVar.g -= b2;
                                                int i45 = d5cVar.Q;
                                                if (i44 >= i45) {
                                                    d5cVar.b = 8;
                                                    d5cVar.Y = i45;
                                                    d5cVar.X = 0;
                                                    d5cVar.a = 12;
                                                    break;
                                                } else {
                                                    d5cVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + d5cVar.a);
                                }
                            } else if (!u(d5cVar)) {
                                return;
                            } else {
                                int i46 = d5cVar.r;
                                int i47 = d5cVar.O;
                                if (i46 >= i47) {
                                    d5cVar.s = i47;
                                }
                                d5cVar.r &= i9;
                                d5cVar.a = d5cVar.b;
                            }
                        } else if (i10 == 10) {
                            if (d5cVar.g >= 0) {
                                u4c.g(u4cVar);
                                u4c.a(d5cVar.c, true);
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

    public static void s(d5c d5cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, d5cVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            d5cVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, u4c u4cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, u4cVar)) == null) {
            u4c.d(u4cVar);
            int r = r(iArr, i, u4cVar);
            return c5c.a[r] + u4c.i(u4cVar, c5c.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, u4c u4cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), u4cVar}) == null) {
            u4c.j(u4cVar);
            int[] iArr2 = new int[i];
            int i3 = u4c.i(u4cVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = u4c.i(u4cVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = u4c.i(u4cVar, i6) % i;
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
                            if (u4c.i(u4cVar, 1) == 1) {
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
                    z4c.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                u4c.d(u4cVar);
                long j = u4cVar.f;
                int i11 = u4cVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                u4cVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, u4cVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.f5c.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, u4c u4cVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, u4cVar) == null) {
            int[] iArr3 = new int[32];
            z4c.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    u4c.j(u4cVar);
                    u4c.d(u4cVar);
                    long j = u4cVar.f;
                    int i9 = u4cVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    u4cVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + u4c.i(u4cVar, i13) + 3;
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

    public static void p(d5c d5cVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, d5cVar) == null) {
            u4c u4cVar = d5cVar.c;
            for (int i = 0; i < 3; i++) {
                d5cVar.o[i] = h(u4cVar) + 1;
                d5cVar.n[i] = 268435456;
                int[] iArr2 = d5cVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, d5cVar.e, i2, u4cVar);
                    n(26, d5cVar.f, i2, u4cVar);
                    d5cVar.n[i] = m(d5cVar.f, i2, u4cVar);
                }
            }
            u4c.j(u4cVar);
            d5cVar.K = u4c.i(u4cVar, 2);
            int i3 = u4c.i(u4cVar, 4);
            int i4 = d5cVar.K;
            int i5 = (i3 << i4) + 16;
            d5cVar.I = i5;
            d5cVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            d5cVar.z = new byte[d5cVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = d5cVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    d5cVar.z[i7] = (byte) (u4c.i(u4cVar, 2) << 1);
                    i7++;
                }
                u4c.j(u4cVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            d5cVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, u4cVar);
            d5cVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (d5cVar.o[0] << 6)) {
                    break;
                } else if (d5cVar.A[i8] != (i8 >> 6)) {
                    d5cVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = d5cVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            d5cVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, u4cVar);
            a5c.b(d5cVar.k, 256, d2);
            a5c.b(d5cVar.l, 704, d5cVar.o[1]);
            a5c.b(d5cVar.m, i6, d3);
            a5c.a(d5cVar.k, u4cVar);
            a5c.a(d5cVar.l, u4cVar);
            a5c.a(d5cVar.m, u4cVar);
            d5cVar.B = 0;
            d5cVar.C = 0;
            int[] iArr4 = w4c.b;
            byte[] bArr3 = d5cVar.z;
            d5cVar.D = iArr4[bArr3[0]];
            d5cVar.E = iArr4[bArr3[0] + 1];
            d5cVar.v = 0;
            d5cVar.w = d5cVar.k.c[0];
            d5cVar.F = d5cVar.l.c[0];
            int[] iArr5 = d5cVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(d5c d5cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, d5cVar) == null) {
            u4c u4cVar = d5cVar.c;
            if (d5cVar.h) {
                d5cVar.b = 10;
                d5cVar.Y = d5cVar.r;
                d5cVar.X = 0;
                d5cVar.a = 12;
                return;
            }
            a5c a5cVar = d5cVar.k;
            a5cVar.b = null;
            a5cVar.c = null;
            a5c a5cVar2 = d5cVar.l;
            a5cVar2.b = null;
            a5cVar2.c = null;
            a5c a5cVar3 = d5cVar.m;
            a5cVar3.b = null;
            a5cVar3.c = null;
            u4c.j(u4cVar);
            g(u4cVar, d5cVar);
            if (d5cVar.g == 0 && !d5cVar.j) {
                return;
            }
            if (!d5cVar.i && !d5cVar.j) {
                d5cVar.a = 2;
            } else {
                u4c.g(u4cVar);
                if (d5cVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                d5cVar.a = i;
            }
            if (d5cVar.j) {
                return;
            }
            d5cVar.R += d5cVar.g;
            if (d5cVar.Q < d5cVar.P) {
                k(d5cVar);
            }
        }
    }

    public static int r(int[] iArr, int i, u4c u4cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, u4cVar)) == null) {
            long j = u4cVar.f;
            int i2 = u4cVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                u4cVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            u4cVar.g = i2 + (iArr[i7] >> 16) + 8;
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
