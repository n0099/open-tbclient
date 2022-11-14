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
public final class mw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987226, "Lcom/baidu/tieba/mw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987226, "Lcom/baidu/tieba/mw9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(sw9 sw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, sw9Var) == null) {
            jw9 jw9Var = sw9Var.c;
            byte[] bArr = sw9Var.d;
            int i = sw9Var.g;
            if (i <= 0) {
                jw9.k(jw9Var);
                sw9Var.a = 1;
                return;
            }
            int min = Math.min(sw9Var.Q - sw9Var.r, i);
            jw9.c(jw9Var, bArr, sw9Var.r, min);
            sw9Var.g -= min;
            int i2 = sw9Var.r + min;
            sw9Var.r = i2;
            int i3 = sw9Var.Q;
            if (i2 == i3) {
                sw9Var.b = 5;
                sw9Var.Y = i3;
                sw9Var.X = 0;
                sw9Var.a = 12;
                return;
            }
            jw9.k(jw9Var);
            sw9Var.a = 1;
        }
    }

    public static void k(sw9 sw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, sw9Var) == null) {
            int i2 = sw9Var.P;
            long j = sw9Var.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + sw9Var.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!sw9Var.h && i2 < 16384 && sw9Var.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = sw9Var.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = sw9Var.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = sw9Var.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = sw9Var.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(sw9Var.S, i, bArr, 0, i5);
                    sw9Var.r = i5;
                    sw9Var.T = i5;
                }
            }
            sw9Var.d = bArr;
            sw9Var.Q = i2;
        }
    }

    public static boolean u(sw9 sw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, sw9Var)) == null) {
            int i = sw9Var.T;
            if (i != 0) {
                sw9Var.X += i;
                sw9Var.T = 0;
            }
            int min = Math.min(sw9Var.V - sw9Var.W, sw9Var.Y - sw9Var.X);
            if (min != 0) {
                System.arraycopy(sw9Var.d, sw9Var.X, sw9Var.Z, sw9Var.U + sw9Var.W, min);
                sw9Var.W += min;
                sw9Var.X += min;
            }
            if (sw9Var.W >= sw9Var.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(sw9 sw9Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, sw9Var, i) == null) {
            jw9 jw9Var = sw9Var.c;
            int[] iArr = sw9Var.p;
            int i3 = i * 2;
            jw9.d(jw9Var);
            int i4 = i * 1080;
            int r = r(sw9Var.e, i4, jw9Var);
            sw9Var.n[i] = m(sw9Var.f, i4, jw9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = sw9Var.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(sw9 sw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, sw9Var) == null) {
            b(sw9Var, 1);
            sw9Var.F = sw9Var.l.c[sw9Var.p[3]];
        }
    }

    public static void e(sw9 sw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, sw9Var) == null) {
            b(sw9Var, 2);
            sw9Var.C = sw9Var.p[5] << 2;
        }
    }

    public static int h(jw9 jw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jw9Var)) == null) {
            if (jw9.i(jw9Var, 1) != 0) {
                int i = jw9.i(jw9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return jw9.i(jw9Var, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, jw9 jw9Var) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, jw9Var)) == null) {
            jw9.j(jw9Var);
            int h = h(jw9Var) + 1;
            if (h == 1) {
                uw9.a(bArr, 0, i);
                return h;
            }
            if (jw9.i(jw9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = jw9.i(jw9Var, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, jw9Var);
            int i3 = 0;
            while (i3 < i) {
                jw9.j(jw9Var);
                jw9.d(jw9Var);
                int r = r(iArr, 0, jw9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + jw9.i(jw9Var, r); i4 != 0; i4--) {
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
            if (jw9.i(jw9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(sw9 sw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, sw9Var) == null) {
            b(sw9Var, 0);
            int i = sw9Var.p[1];
            int i2 = i << 6;
            sw9Var.B = i2;
            int i3 = sw9Var.A[i2] & 255;
            sw9Var.v = i3;
            sw9Var.w = sw9Var.k.c[i3];
            byte b2 = sw9Var.z[i];
            int[] iArr = lw9.b;
            sw9Var.D = iArr[b2];
            sw9Var.E = iArr[b2 + 1];
        }
    }

    public static void g(jw9 jw9Var, sw9 sw9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, jw9Var, sw9Var) == null) {
            boolean z2 = true;
            if (jw9.i(jw9Var, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            sw9Var.h = z;
            sw9Var.g = 0;
            sw9Var.i = false;
            sw9Var.j = false;
            if (z && jw9.i(jw9Var, 1) != 0) {
                return;
            }
            int i = jw9.i(jw9Var, 2) + 4;
            if (i == 7) {
                sw9Var.j = true;
                if (jw9.i(jw9Var, 1) == 0) {
                    int i2 = jw9.i(jw9Var, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = jw9.i(jw9Var, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        sw9Var.g = (i4 << (i3 * 8)) | sw9Var.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = jw9.i(jw9Var, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    sw9Var.g = (i6 << (i5 * 4)) | sw9Var.g;
                }
            }
            sw9Var.g++;
            if (!sw9Var.h) {
                if (jw9.i(jw9Var, 1) != 1) {
                    z2 = false;
                }
                sw9Var.i = z2;
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
    public static void i(sw9 sw9Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, sw9Var) == null) {
            int i8 = sw9Var.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    jw9 jw9Var = sw9Var.c;
                    int i9 = sw9Var.Q - 1;
                    byte[] bArr = sw9Var.d;
                    while (true) {
                        int i10 = sw9Var.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (sw9Var.g >= 0) {
                                            q(sw9Var);
                                            i9 = sw9Var.Q - 1;
                                            bArr = sw9Var.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(sw9Var);
                                        sw9Var.a = 3;
                                        if (sw9Var.g > 0) {
                                            sw9Var.a = 1;
                                            break;
                                        } else {
                                            jw9.j(jw9Var);
                                            if (sw9Var.n[1] == 0) {
                                                c(sw9Var);
                                            }
                                            int[] iArr = sw9Var.n;
                                            iArr[1] = iArr[1] - 1;
                                            jw9.d(jw9Var);
                                            int r = r(sw9Var.l.b, sw9Var.F, jw9Var);
                                            int i12 = r >>> 6;
                                            sw9Var.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                sw9Var.G = -1;
                                            }
                                            int i13 = rw9.g[i12] + ((r >>> 3) & 7);
                                            int i14 = rw9.h[i12] + (r & 7);
                                            sw9Var.y = rw9.c[i13] + jw9.i(jw9Var, rw9.d[i13]);
                                            sw9Var.M = rw9.e[i14] + jw9.i(jw9Var, rw9.f[i14]);
                                            sw9Var.x = 0;
                                            sw9Var.a = 6;
                                            if (sw9Var.u) {
                                                int i15 = sw9Var.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (sw9Var.x < sw9Var.y) {
                                                        jw9.j(jw9Var);
                                                        if (sw9Var.n[0] == 0) {
                                                            f(sw9Var);
                                                        }
                                                        byte[] bArr2 = sw9Var.A;
                                                        int i18 = sw9Var.B;
                                                        int[] iArr2 = lw9.a;
                                                        int i19 = iArr2[sw9Var.D + i16];
                                                        int[] iArr3 = sw9Var.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        jw9.d(jw9Var);
                                                        pw9 pw9Var = sw9Var.k;
                                                        int r2 = r(pw9Var.b, pw9Var.c[bArr2[i18 + (iArr2[sw9Var.E + i17] | i19)] & 255], jw9Var);
                                                        int i20 = sw9Var.r;
                                                        bArr[i20] = (byte) r2;
                                                        sw9Var.x++;
                                                        sw9Var.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            sw9Var.b = 6;
                                                            sw9Var.Y = sw9Var.Q;
                                                            sw9Var.X = 0;
                                                            sw9Var.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (sw9Var.x < sw9Var.y) {
                                                        jw9.j(jw9Var);
                                                        if (sw9Var.n[0] == 0) {
                                                            f(sw9Var);
                                                        }
                                                        int[] iArr4 = sw9Var.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        jw9.d(jw9Var);
                                                        bArr[sw9Var.r] = (byte) r(sw9Var.k.b, sw9Var.w, jw9Var);
                                                        sw9Var.x++;
                                                        int i22 = sw9Var.r;
                                                        sw9Var.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            sw9Var.b = 6;
                                                            sw9Var.Y = sw9Var.Q;
                                                            sw9Var.X = 0;
                                                            sw9Var.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (sw9Var.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = sw9Var.g - sw9Var.y;
                                                sw9Var.g = i23;
                                                if (i23 <= 0) {
                                                    sw9Var.a = 3;
                                                    break;
                                                } else {
                                                    if (sw9Var.G < 0) {
                                                        jw9.j(jw9Var);
                                                        if (sw9Var.n[2] == 0) {
                                                            e(sw9Var);
                                                        }
                                                        int[] iArr5 = sw9Var.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        jw9.d(jw9Var);
                                                        pw9 pw9Var2 = sw9Var.m;
                                                        int[] iArr6 = pw9Var2.b;
                                                        int[] iArr7 = pw9Var2.c;
                                                        byte[] bArr3 = sw9Var.H;
                                                        int i24 = sw9Var.C;
                                                        int i25 = sw9Var.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], jw9Var);
                                                        sw9Var.G = r3;
                                                        int i26 = sw9Var.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            sw9Var.G = i27;
                                                            int i28 = sw9Var.J & i27;
                                                            int i29 = i27 >>> sw9Var.K;
                                                            sw9Var.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            sw9Var.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + jw9.i(jw9Var, i30)) << sw9Var.K);
                                                        }
                                                    }
                                                    int t = t(sw9Var.G, sw9Var.q, sw9Var.t);
                                                    sw9Var.L = t;
                                                    if (t >= 0) {
                                                        int i31 = sw9Var.s;
                                                        int i32 = sw9Var.O;
                                                        if (i31 != i32 && (i6 = sw9Var.r) < i32) {
                                                            sw9Var.s = i6;
                                                        } else {
                                                            sw9Var.s = sw9Var.O;
                                                        }
                                                        sw9Var.N = sw9Var.r;
                                                        int i33 = sw9Var.L;
                                                        if (i33 > sw9Var.s) {
                                                            sw9Var.a = 9;
                                                            break;
                                                        } else {
                                                            if (sw9Var.G > 0) {
                                                                int[] iArr8 = sw9Var.q;
                                                                int i34 = sw9Var.t;
                                                                iArr8[i34 & 3] = i33;
                                                                sw9Var.t = i34 + 1;
                                                            }
                                                            if (sw9Var.M <= sw9Var.g) {
                                                                sw9Var.x = 0;
                                                                sw9Var.a = 7;
                                                                int i35 = sw9Var.r;
                                                                i = (i35 - sw9Var.L) & i9;
                                                                i2 = sw9Var.M - sw9Var.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    sw9Var.x += i2;
                                                                    sw9Var.g -= i2;
                                                                    sw9Var.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = sw9Var.x;
                                                                        if (i3 >= sw9Var.M) {
                                                                            i4 = sw9Var.r;
                                                                            bArr[i4] = bArr[(i4 - sw9Var.L) & i9];
                                                                            sw9Var.g--;
                                                                            sw9Var.x = i3 + 1;
                                                                            sw9Var.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    sw9Var.b = 7;
                                                                    sw9Var.Y = sw9Var.Q;
                                                                    sw9Var.X = 0;
                                                                    sw9Var.a = 12;
                                                                    if (sw9Var.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        sw9Var.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (sw9Var.a != i5) {
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
                                        if (sw9Var.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (sw9Var.g > 0) {
                                            jw9.j(jw9Var);
                                            jw9.i(jw9Var, 8);
                                            sw9Var.g--;
                                        }
                                        sw9Var.a = 1;
                                        break;
                                    case 5:
                                        a(sw9Var);
                                        break;
                                    case 6:
                                        if (sw9Var.u) {
                                        }
                                        if (sw9Var.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = sw9Var.r;
                                        i = (i352 - sw9Var.L) & i9;
                                        i2 = sw9Var.M - sw9Var.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = sw9Var.x;
                                            if (i3 >= sw9Var.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        sw9Var.b = 7;
                                        sw9Var.Y = sw9Var.Q;
                                        sw9Var.X = 0;
                                        sw9Var.a = 12;
                                        if (sw9Var.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = sw9Var.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, sw9Var.N - i36);
                                        sw9Var.a = 3;
                                        break;
                                    case 9:
                                        int i37 = sw9Var.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = nw9.a[i37];
                                            int i39 = (sw9Var.L - sw9Var.s) - 1;
                                            int i40 = nw9.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < tw9.d.length) {
                                                int b2 = tw9.b(bArr, sw9Var.N, nw9.a(), i43, sw9Var.M, tw9.d[i42]);
                                                int i44 = sw9Var.N + b2;
                                                sw9Var.N = i44;
                                                sw9Var.r += b2;
                                                sw9Var.g -= b2;
                                                int i45 = sw9Var.Q;
                                                if (i44 >= i45) {
                                                    sw9Var.b = 8;
                                                    sw9Var.Y = i45;
                                                    sw9Var.X = 0;
                                                    sw9Var.a = 12;
                                                    break;
                                                } else {
                                                    sw9Var.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + sw9Var.a);
                                }
                            } else if (!u(sw9Var)) {
                                return;
                            } else {
                                int i46 = sw9Var.r;
                                int i47 = sw9Var.O;
                                if (i46 >= i47) {
                                    sw9Var.s = i47;
                                }
                                sw9Var.r &= i9;
                                sw9Var.a = sw9Var.b;
                            }
                        } else if (i10 == 10) {
                            if (sw9Var.g >= 0) {
                                jw9.g(jw9Var);
                                jw9.a(sw9Var.c, true);
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

    public static void s(sw9 sw9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, sw9Var, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            sw9Var.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, jw9 jw9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, jw9Var)) == null) {
            jw9.d(jw9Var);
            int r = r(iArr, i, jw9Var);
            return rw9.a[r] + jw9.i(jw9Var, rw9.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, jw9 jw9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), jw9Var}) == null) {
            jw9.j(jw9Var);
            int[] iArr2 = new int[i];
            int i3 = jw9.i(jw9Var, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = jw9.i(jw9Var, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = jw9.i(jw9Var, i6) % i;
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
                            if (jw9.i(jw9Var, 1) == 1) {
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
                    ow9.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                jw9.d(jw9Var);
                long j = jw9Var.f;
                int i11 = jw9Var.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                jw9Var.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, jw9Var);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.uw9.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, jw9 jw9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, jw9Var) == null) {
            int[] iArr3 = new int[32];
            ow9.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    jw9.j(jw9Var);
                    jw9.d(jw9Var);
                    long j = jw9Var.f;
                    int i9 = jw9Var.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    jw9Var.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + jw9.i(jw9Var, i13) + 3;
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

    public static void p(sw9 sw9Var) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, sw9Var) == null) {
            jw9 jw9Var = sw9Var.c;
            for (int i = 0; i < 3; i++) {
                sw9Var.o[i] = h(jw9Var) + 1;
                sw9Var.n[i] = 268435456;
                int[] iArr2 = sw9Var.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, sw9Var.e, i2, jw9Var);
                    n(26, sw9Var.f, i2, jw9Var);
                    sw9Var.n[i] = m(sw9Var.f, i2, jw9Var);
                }
            }
            jw9.j(jw9Var);
            sw9Var.K = jw9.i(jw9Var, 2);
            int i3 = jw9.i(jw9Var, 4);
            int i4 = sw9Var.K;
            int i5 = (i3 << i4) + 16;
            sw9Var.I = i5;
            sw9Var.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            sw9Var.z = new byte[sw9Var.o[0]];
            int i7 = 0;
            while (true) {
                iArr = sw9Var.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    sw9Var.z[i7] = (byte) (jw9.i(jw9Var, 2) << 1);
                    i7++;
                }
                jw9.j(jw9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            sw9Var.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, jw9Var);
            sw9Var.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (sw9Var.o[0] << 6)) {
                    break;
                } else if (sw9Var.A[i8] != (i8 >> 6)) {
                    sw9Var.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = sw9Var.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            sw9Var.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, jw9Var);
            pw9.b(sw9Var.k, 256, d2);
            pw9.b(sw9Var.l, 704, sw9Var.o[1]);
            pw9.b(sw9Var.m, i6, d3);
            pw9.a(sw9Var.k, jw9Var);
            pw9.a(sw9Var.l, jw9Var);
            pw9.a(sw9Var.m, jw9Var);
            sw9Var.B = 0;
            sw9Var.C = 0;
            int[] iArr4 = lw9.b;
            byte[] bArr3 = sw9Var.z;
            sw9Var.D = iArr4[bArr3[0]];
            sw9Var.E = iArr4[bArr3[0] + 1];
            sw9Var.v = 0;
            sw9Var.w = sw9Var.k.c[0];
            sw9Var.F = sw9Var.l.c[0];
            int[] iArr5 = sw9Var.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(sw9 sw9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, sw9Var) == null) {
            jw9 jw9Var = sw9Var.c;
            if (sw9Var.h) {
                sw9Var.b = 10;
                sw9Var.Y = sw9Var.r;
                sw9Var.X = 0;
                sw9Var.a = 12;
                return;
            }
            pw9 pw9Var = sw9Var.k;
            pw9Var.b = null;
            pw9Var.c = null;
            pw9 pw9Var2 = sw9Var.l;
            pw9Var2.b = null;
            pw9Var2.c = null;
            pw9 pw9Var3 = sw9Var.m;
            pw9Var3.b = null;
            pw9Var3.c = null;
            jw9.j(jw9Var);
            g(jw9Var, sw9Var);
            if (sw9Var.g == 0 && !sw9Var.j) {
                return;
            }
            if (!sw9Var.i && !sw9Var.j) {
                sw9Var.a = 2;
            } else {
                jw9.g(jw9Var);
                if (sw9Var.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                sw9Var.a = i;
            }
            if (sw9Var.j) {
                return;
            }
            sw9Var.R += sw9Var.g;
            if (sw9Var.Q < sw9Var.P) {
                k(sw9Var);
            }
        }
    }

    public static int r(int[] iArr, int i, jw9 jw9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, jw9Var)) == null) {
            long j = jw9Var.f;
            int i2 = jw9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                jw9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            jw9Var.g = i2 + (iArr[i7] >> 16) + 8;
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
