package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes9.dex */
public final class z4c {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311424, "Lcom/baidu/tieba/z4c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311424, "Lcom/baidu/tieba/z4c;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(f5c f5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, f5cVar) == null) {
            w4c w4cVar = f5cVar.c;
            byte[] bArr = f5cVar.d;
            int i = f5cVar.g;
            if (i <= 0) {
                w4c.k(w4cVar);
                f5cVar.a = 1;
                return;
            }
            int min = Math.min(f5cVar.Q - f5cVar.r, i);
            w4c.c(w4cVar, bArr, f5cVar.r, min);
            f5cVar.g -= min;
            int i2 = f5cVar.r + min;
            f5cVar.r = i2;
            int i3 = f5cVar.Q;
            if (i2 == i3) {
                f5cVar.b = 5;
                f5cVar.Y = i3;
                f5cVar.X = 0;
                f5cVar.a = 12;
                return;
            }
            w4c.k(w4cVar);
            f5cVar.a = 1;
        }
    }

    public static void k(f5c f5cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, f5cVar) == null) {
            int i2 = f5cVar.P;
            long j = f5cVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + f5cVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!f5cVar.h && i2 < 16384 && f5cVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = f5cVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = f5cVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = f5cVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = f5cVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(f5cVar.S, i, bArr, 0, i5);
                    f5cVar.r = i5;
                    f5cVar.f1103T = i5;
                }
            }
            f5cVar.d = bArr;
            f5cVar.Q = i2;
        }
    }

    public static boolean u(f5c f5cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, f5cVar)) == null) {
            int i = f5cVar.f1103T;
            if (i != 0) {
                f5cVar.X += i;
                f5cVar.f1103T = 0;
            }
            int min = Math.min(f5cVar.V - f5cVar.W, f5cVar.Y - f5cVar.X);
            if (min != 0) {
                System.arraycopy(f5cVar.d, f5cVar.X, f5cVar.Z, f5cVar.U + f5cVar.W, min);
                f5cVar.W += min;
                f5cVar.X += min;
            }
            if (f5cVar.W >= f5cVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(f5c f5cVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, f5cVar, i) == null) {
            w4c w4cVar = f5cVar.c;
            int[] iArr = f5cVar.p;
            int i3 = i * 2;
            w4c.d(w4cVar);
            int i4 = i * 1080;
            int r = r(f5cVar.e, i4, w4cVar);
            f5cVar.n[i] = m(f5cVar.f, i4, w4cVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = f5cVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(f5c f5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, f5cVar) == null) {
            b(f5cVar, 1);
            f5cVar.F = f5cVar.l.c[f5cVar.p[3]];
        }
    }

    public static void e(f5c f5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, f5cVar) == null) {
            b(f5cVar, 2);
            f5cVar.C = f5cVar.p[5] << 2;
        }
    }

    public static int h(w4c w4cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, w4cVar)) == null) {
            if (w4c.i(w4cVar, 1) != 0) {
                int i = w4c.i(w4cVar, 3);
                if (i == 0) {
                    return 1;
                }
                return w4c.i(w4cVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, w4c w4cVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, w4cVar)) == null) {
            w4c.j(w4cVar);
            int h = h(w4cVar) + 1;
            if (h == 1) {
                h5c.a(bArr, 0, i);
                return h;
            }
            if (w4c.i(w4cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = w4c.i(w4cVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, w4cVar);
            int i3 = 0;
            while (i3 < i) {
                w4c.j(w4cVar);
                w4c.d(w4cVar);
                int r = r(iArr, 0, w4cVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + w4c.i(w4cVar, r); i4 != 0; i4--) {
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
            if (w4c.i(w4cVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(f5c f5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, f5cVar) == null) {
            b(f5cVar, 0);
            int i = f5cVar.p[1];
            int i2 = i << 6;
            f5cVar.B = i2;
            int i3 = f5cVar.A[i2] & 255;
            f5cVar.v = i3;
            f5cVar.w = f5cVar.k.c[i3];
            byte b2 = f5cVar.z[i];
            int[] iArr = y4c.b;
            f5cVar.D = iArr[b2];
            f5cVar.E = iArr[b2 + 1];
        }
    }

    public static void g(w4c w4cVar, f5c f5cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, w4cVar, f5cVar) == null) {
            boolean z2 = true;
            if (w4c.i(w4cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            f5cVar.h = z;
            f5cVar.g = 0;
            f5cVar.i = false;
            f5cVar.j = false;
            if (z && w4c.i(w4cVar, 1) != 0) {
                return;
            }
            int i = w4c.i(w4cVar, 2) + 4;
            if (i == 7) {
                f5cVar.j = true;
                if (w4c.i(w4cVar, 1) == 0) {
                    int i2 = w4c.i(w4cVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = w4c.i(w4cVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        f5cVar.g = (i4 << (i3 * 8)) | f5cVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = w4c.i(w4cVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    f5cVar.g = (i6 << (i5 * 4)) | f5cVar.g;
                }
            }
            f5cVar.g++;
            if (!f5cVar.h) {
                if (w4c.i(w4cVar, 1) != 1) {
                    z2 = false;
                }
                f5cVar.i = z2;
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
    public static void i(f5c f5cVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, f5cVar) == null) {
            int i8 = f5cVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    w4c w4cVar = f5cVar.c;
                    int i9 = f5cVar.Q - 1;
                    byte[] bArr = f5cVar.d;
                    while (true) {
                        int i10 = f5cVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (f5cVar.g >= 0) {
                                            q(f5cVar);
                                            i9 = f5cVar.Q - 1;
                                            bArr = f5cVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(f5cVar);
                                        f5cVar.a = 3;
                                        if (f5cVar.g > 0) {
                                            f5cVar.a = 1;
                                            break;
                                        } else {
                                            w4c.j(w4cVar);
                                            if (f5cVar.n[1] == 0) {
                                                c(f5cVar);
                                            }
                                            int[] iArr = f5cVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            w4c.d(w4cVar);
                                            int r = r(f5cVar.l.b, f5cVar.F, w4cVar);
                                            int i12 = r >>> 6;
                                            f5cVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                f5cVar.G = -1;
                                            }
                                            int i13 = e5c.g[i12] + ((r >>> 3) & 7);
                                            int i14 = e5c.h[i12] + (r & 7);
                                            f5cVar.y = e5c.c[i13] + w4c.i(w4cVar, e5c.d[i13]);
                                            f5cVar.M = e5c.e[i14] + w4c.i(w4cVar, e5c.f[i14]);
                                            f5cVar.x = 0;
                                            f5cVar.a = 6;
                                            if (f5cVar.u) {
                                                int i15 = f5cVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (f5cVar.x < f5cVar.y) {
                                                        w4c.j(w4cVar);
                                                        if (f5cVar.n[0] == 0) {
                                                            f(f5cVar);
                                                        }
                                                        byte[] bArr2 = f5cVar.A;
                                                        int i18 = f5cVar.B;
                                                        int[] iArr2 = y4c.a;
                                                        int i19 = iArr2[f5cVar.D + i16];
                                                        int[] iArr3 = f5cVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        w4c.d(w4cVar);
                                                        c5c c5cVar = f5cVar.k;
                                                        int r2 = r(c5cVar.b, c5cVar.c[bArr2[i18 + (iArr2[f5cVar.E + i17] | i19)] & 255], w4cVar);
                                                        int i20 = f5cVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        f5cVar.x++;
                                                        f5cVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            f5cVar.b = 6;
                                                            f5cVar.Y = f5cVar.Q;
                                                            f5cVar.X = 0;
                                                            f5cVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (f5cVar.x < f5cVar.y) {
                                                        w4c.j(w4cVar);
                                                        if (f5cVar.n[0] == 0) {
                                                            f(f5cVar);
                                                        }
                                                        int[] iArr4 = f5cVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        w4c.d(w4cVar);
                                                        bArr[f5cVar.r] = (byte) r(f5cVar.k.b, f5cVar.w, w4cVar);
                                                        f5cVar.x++;
                                                        int i22 = f5cVar.r;
                                                        f5cVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            f5cVar.b = 6;
                                                            f5cVar.Y = f5cVar.Q;
                                                            f5cVar.X = 0;
                                                            f5cVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (f5cVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = f5cVar.g - f5cVar.y;
                                                f5cVar.g = i23;
                                                if (i23 <= 0) {
                                                    f5cVar.a = 3;
                                                    break;
                                                } else {
                                                    if (f5cVar.G < 0) {
                                                        w4c.j(w4cVar);
                                                        if (f5cVar.n[2] == 0) {
                                                            e(f5cVar);
                                                        }
                                                        int[] iArr5 = f5cVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        w4c.d(w4cVar);
                                                        c5c c5cVar2 = f5cVar.m;
                                                        int[] iArr6 = c5cVar2.b;
                                                        int[] iArr7 = c5cVar2.c;
                                                        byte[] bArr3 = f5cVar.H;
                                                        int i24 = f5cVar.C;
                                                        int i25 = f5cVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], w4cVar);
                                                        f5cVar.G = r3;
                                                        int i26 = f5cVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            f5cVar.G = i27;
                                                            int i28 = f5cVar.J & i27;
                                                            int i29 = i27 >>> f5cVar.K;
                                                            f5cVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            f5cVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + w4c.i(w4cVar, i30)) << f5cVar.K);
                                                        }
                                                    }
                                                    int t = t(f5cVar.G, f5cVar.q, f5cVar.t);
                                                    f5cVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = f5cVar.s;
                                                        int i32 = f5cVar.O;
                                                        if (i31 != i32 && (i6 = f5cVar.r) < i32) {
                                                            f5cVar.s = i6;
                                                        } else {
                                                            f5cVar.s = f5cVar.O;
                                                        }
                                                        f5cVar.N = f5cVar.r;
                                                        int i33 = f5cVar.L;
                                                        if (i33 > f5cVar.s) {
                                                            f5cVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (f5cVar.G > 0) {
                                                                int[] iArr8 = f5cVar.q;
                                                                int i34 = f5cVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                f5cVar.t = i34 + 1;
                                                            }
                                                            if (f5cVar.M <= f5cVar.g) {
                                                                f5cVar.x = 0;
                                                                f5cVar.a = 7;
                                                                int i35 = f5cVar.r;
                                                                i = (i35 - f5cVar.L) & i9;
                                                                i2 = f5cVar.M - f5cVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    f5cVar.x += i2;
                                                                    f5cVar.g -= i2;
                                                                    f5cVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = f5cVar.x;
                                                                        if (i3 >= f5cVar.M) {
                                                                            i4 = f5cVar.r;
                                                                            bArr[i4] = bArr[(i4 - f5cVar.L) & i9];
                                                                            f5cVar.g--;
                                                                            f5cVar.x = i3 + 1;
                                                                            f5cVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    f5cVar.b = 7;
                                                                    f5cVar.Y = f5cVar.Q;
                                                                    f5cVar.X = 0;
                                                                    f5cVar.a = 12;
                                                                    if (f5cVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        f5cVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (f5cVar.a != i5) {
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
                                        if (f5cVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (f5cVar.g > 0) {
                                            w4c.j(w4cVar);
                                            w4c.i(w4cVar, 8);
                                            f5cVar.g--;
                                        }
                                        f5cVar.a = 1;
                                        break;
                                    case 5:
                                        a(f5cVar);
                                        break;
                                    case 6:
                                        if (f5cVar.u) {
                                        }
                                        if (f5cVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = f5cVar.r;
                                        i = (i352 - f5cVar.L) & i9;
                                        i2 = f5cVar.M - f5cVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = f5cVar.x;
                                            if (i3 >= f5cVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        f5cVar.b = 7;
                                        f5cVar.Y = f5cVar.Q;
                                        f5cVar.X = 0;
                                        f5cVar.a = 12;
                                        if (f5cVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = f5cVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, f5cVar.N - i36);
                                        f5cVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = f5cVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = a5c.a[i37];
                                            int i39 = (f5cVar.L - f5cVar.s) - 1;
                                            int i40 = a5c.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < g5c.d.length) {
                                                int b2 = g5c.b(bArr, f5cVar.N, a5c.a(), i43, f5cVar.M, g5c.d[i42]);
                                                int i44 = f5cVar.N + b2;
                                                f5cVar.N = i44;
                                                f5cVar.r += b2;
                                                f5cVar.g -= b2;
                                                int i45 = f5cVar.Q;
                                                if (i44 >= i45) {
                                                    f5cVar.b = 8;
                                                    f5cVar.Y = i45;
                                                    f5cVar.X = 0;
                                                    f5cVar.a = 12;
                                                    break;
                                                } else {
                                                    f5cVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + f5cVar.a);
                                }
                            } else if (!u(f5cVar)) {
                                return;
                            } else {
                                int i46 = f5cVar.r;
                                int i47 = f5cVar.O;
                                if (i46 >= i47) {
                                    f5cVar.s = i47;
                                }
                                f5cVar.r &= i9;
                                f5cVar.a = f5cVar.b;
                            }
                        } else if (i10 == 10) {
                            if (f5cVar.g >= 0) {
                                w4c.g(w4cVar);
                                w4c.a(f5cVar.c, true);
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

    public static void s(f5c f5cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, f5cVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            f5cVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, w4c w4cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, w4cVar)) == null) {
            w4c.d(w4cVar);
            int r = r(iArr, i, w4cVar);
            return e5c.a[r] + w4c.i(w4cVar, e5c.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, w4c w4cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), w4cVar}) == null) {
            w4c.j(w4cVar);
            int[] iArr2 = new int[i];
            int i3 = w4c.i(w4cVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = w4c.i(w4cVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = w4c.i(w4cVar, i6) % i;
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
                            if (w4c.i(w4cVar, 1) == 1) {
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
                    b5c.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                w4c.d(w4cVar);
                long j = w4cVar.f;
                int i11 = w4cVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                w4cVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, w4cVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        com.baidu.tieba.h5c.b(r13, r3, r12 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0093, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Unused space");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(int[] iArr, int i, int[] iArr2, w4c w4cVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, w4cVar) == null) {
            int[] iArr3 = new int[32];
            b5c.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    w4c.j(w4cVar);
                    w4c.d(w4cVar);
                    long j = w4cVar.f;
                    int i9 = w4cVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    w4cVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + w4c.i(w4cVar, i13) + 3;
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

    public static void p(f5c f5cVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, f5cVar) == null) {
            w4c w4cVar = f5cVar.c;
            for (int i = 0; i < 3; i++) {
                f5cVar.o[i] = h(w4cVar) + 1;
                f5cVar.n[i] = 268435456;
                int[] iArr2 = f5cVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, f5cVar.e, i2, w4cVar);
                    n(26, f5cVar.f, i2, w4cVar);
                    f5cVar.n[i] = m(f5cVar.f, i2, w4cVar);
                }
            }
            w4c.j(w4cVar);
            f5cVar.K = w4c.i(w4cVar, 2);
            int i3 = w4c.i(w4cVar, 4);
            int i4 = f5cVar.K;
            int i5 = (i3 << i4) + 16;
            f5cVar.I = i5;
            f5cVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            f5cVar.z = new byte[f5cVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = f5cVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    f5cVar.z[i7] = (byte) (w4c.i(w4cVar, 2) << 1);
                    i7++;
                }
                w4c.j(w4cVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            f5cVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, w4cVar);
            f5cVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (f5cVar.o[0] << 6)) {
                    break;
                } else if (f5cVar.A[i8] != (i8 >> 6)) {
                    f5cVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = f5cVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            f5cVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, w4cVar);
            c5c.b(f5cVar.k, 256, d2);
            c5c.b(f5cVar.l, 704, f5cVar.o[1]);
            c5c.b(f5cVar.m, i6, d3);
            c5c.a(f5cVar.k, w4cVar);
            c5c.a(f5cVar.l, w4cVar);
            c5c.a(f5cVar.m, w4cVar);
            f5cVar.B = 0;
            f5cVar.C = 0;
            int[] iArr4 = y4c.b;
            byte[] bArr3 = f5cVar.z;
            f5cVar.D = iArr4[bArr3[0]];
            f5cVar.E = iArr4[bArr3[0] + 1];
            f5cVar.v = 0;
            f5cVar.w = f5cVar.k.c[0];
            f5cVar.F = f5cVar.l.c[0];
            int[] iArr5 = f5cVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(f5c f5cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, f5cVar) == null) {
            w4c w4cVar = f5cVar.c;
            if (f5cVar.h) {
                f5cVar.b = 10;
                f5cVar.Y = f5cVar.r;
                f5cVar.X = 0;
                f5cVar.a = 12;
                return;
            }
            c5c c5cVar = f5cVar.k;
            c5cVar.b = null;
            c5cVar.c = null;
            c5c c5cVar2 = f5cVar.l;
            c5cVar2.b = null;
            c5cVar2.c = null;
            c5c c5cVar3 = f5cVar.m;
            c5cVar3.b = null;
            c5cVar3.c = null;
            w4c.j(w4cVar);
            g(w4cVar, f5cVar);
            if (f5cVar.g == 0 && !f5cVar.j) {
                return;
            }
            if (!f5cVar.i && !f5cVar.j) {
                f5cVar.a = 2;
            } else {
                w4c.g(w4cVar);
                if (f5cVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                f5cVar.a = i;
            }
            if (f5cVar.j) {
                return;
            }
            f5cVar.R += f5cVar.g;
            if (f5cVar.Q < f5cVar.P) {
                k(f5cVar);
            }
        }
    }

    public static int r(int[] iArr, int i, w4c w4cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, w4cVar)) == null) {
            long j = w4cVar.f;
            int i2 = w4cVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                w4cVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            w4cVar.g = i2 + (iArr[i7] >> 16) + 8;
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
