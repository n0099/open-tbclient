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
public final class q5b {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948044235, "Lcom/baidu/tieba/q5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948044235, "Lcom/baidu/tieba/q5b;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(w5b w5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, w5bVar) == null) {
            n5b n5bVar = w5bVar.c;
            byte[] bArr = w5bVar.d;
            int i = w5bVar.g;
            if (i <= 0) {
                n5b.k(n5bVar);
                w5bVar.a = 1;
                return;
            }
            int min = Math.min(w5bVar.Q - w5bVar.r, i);
            n5b.c(n5bVar, bArr, w5bVar.r, min);
            w5bVar.g -= min;
            int i2 = w5bVar.r + min;
            w5bVar.r = i2;
            int i3 = w5bVar.Q;
            if (i2 == i3) {
                w5bVar.b = 5;
                w5bVar.Y = i3;
                w5bVar.X = 0;
                w5bVar.a = 12;
                return;
            }
            n5b.k(n5bVar);
            w5bVar.a = 1;
        }
    }

    public static void k(w5b w5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, w5bVar) == null) {
            int i2 = w5bVar.P;
            long j = w5bVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + w5bVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!w5bVar.h && i2 < 16384 && w5bVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = w5bVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = w5bVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = w5bVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = w5bVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(w5bVar.S, i, bArr, 0, i5);
                    w5bVar.r = i5;
                    w5bVar.T = i5;
                }
            }
            w5bVar.d = bArr;
            w5bVar.Q = i2;
        }
    }

    public static boolean u(w5b w5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, w5bVar)) == null) {
            int i = w5bVar.T;
            if (i != 0) {
                w5bVar.X += i;
                w5bVar.T = 0;
            }
            int min = Math.min(w5bVar.V - w5bVar.W, w5bVar.Y - w5bVar.X);
            if (min != 0) {
                System.arraycopy(w5bVar.d, w5bVar.X, w5bVar.Z, w5bVar.U + w5bVar.W, min);
                w5bVar.W += min;
                w5bVar.X += min;
            }
            if (w5bVar.W >= w5bVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(w5b w5bVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, w5bVar, i) == null) {
            n5b n5bVar = w5bVar.c;
            int[] iArr = w5bVar.p;
            int i3 = i * 2;
            n5b.d(n5bVar);
            int i4 = i * 1080;
            int r = r(w5bVar.e, i4, n5bVar);
            w5bVar.n[i] = m(w5bVar.f, i4, n5bVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = w5bVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(w5b w5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, w5bVar) == null) {
            b(w5bVar, 1);
            w5bVar.F = w5bVar.l.c[w5bVar.p[3]];
        }
    }

    public static void e(w5b w5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, w5bVar) == null) {
            b(w5bVar, 2);
            w5bVar.C = w5bVar.p[5] << 2;
        }
    }

    public static int h(n5b n5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, n5bVar)) == null) {
            if (n5b.i(n5bVar, 1) != 0) {
                int i = n5b.i(n5bVar, 3);
                if (i == 0) {
                    return 1;
                }
                return n5b.i(n5bVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, n5b n5bVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, n5bVar)) == null) {
            n5b.j(n5bVar);
            int h = h(n5bVar) + 1;
            if (h == 1) {
                y5b.a(bArr, 0, i);
                return h;
            }
            if (n5b.i(n5bVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = n5b.i(n5bVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, n5bVar);
            int i3 = 0;
            while (i3 < i) {
                n5b.j(n5bVar);
                n5b.d(n5bVar);
                int r = r(iArr, 0, n5bVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + n5b.i(n5bVar, r); i4 != 0; i4--) {
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
            if (n5b.i(n5bVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(w5b w5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, w5bVar) == null) {
            b(w5bVar, 0);
            int i = w5bVar.p[1];
            int i2 = i << 6;
            w5bVar.B = i2;
            int i3 = w5bVar.A[i2] & 255;
            w5bVar.v = i3;
            w5bVar.w = w5bVar.k.c[i3];
            byte b2 = w5bVar.z[i];
            int[] iArr = p5b.b;
            w5bVar.D = iArr[b2];
            w5bVar.E = iArr[b2 + 1];
        }
    }

    public static void g(n5b n5bVar, w5b w5bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, n5bVar, w5bVar) == null) {
            boolean z2 = true;
            if (n5b.i(n5bVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            w5bVar.h = z;
            w5bVar.g = 0;
            w5bVar.i = false;
            w5bVar.j = false;
            if (z && n5b.i(n5bVar, 1) != 0) {
                return;
            }
            int i = n5b.i(n5bVar, 2) + 4;
            if (i == 7) {
                w5bVar.j = true;
                if (n5b.i(n5bVar, 1) == 0) {
                    int i2 = n5b.i(n5bVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = n5b.i(n5bVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        w5bVar.g = (i4 << (i3 * 8)) | w5bVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = n5b.i(n5bVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    w5bVar.g = (i6 << (i5 * 4)) | w5bVar.g;
                }
            }
            w5bVar.g++;
            if (!w5bVar.h) {
                if (n5b.i(n5bVar, 1) != 1) {
                    z2 = false;
                }
                w5bVar.i = z2;
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
    public static void i(w5b w5bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, w5bVar) == null) {
            int i8 = w5bVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    n5b n5bVar = w5bVar.c;
                    int i9 = w5bVar.Q - 1;
                    byte[] bArr = w5bVar.d;
                    while (true) {
                        int i10 = w5bVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (w5bVar.g >= 0) {
                                            q(w5bVar);
                                            i9 = w5bVar.Q - 1;
                                            bArr = w5bVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(w5bVar);
                                        w5bVar.a = 3;
                                        if (w5bVar.g > 0) {
                                            w5bVar.a = 1;
                                            break;
                                        } else {
                                            n5b.j(n5bVar);
                                            if (w5bVar.n[1] == 0) {
                                                c(w5bVar);
                                            }
                                            int[] iArr = w5bVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            n5b.d(n5bVar);
                                            int r = r(w5bVar.l.b, w5bVar.F, n5bVar);
                                            int i12 = r >>> 6;
                                            w5bVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                w5bVar.G = -1;
                                            }
                                            int i13 = v5b.g[i12] + ((r >>> 3) & 7);
                                            int i14 = v5b.h[i12] + (r & 7);
                                            w5bVar.y = v5b.c[i13] + n5b.i(n5bVar, v5b.d[i13]);
                                            w5bVar.M = v5b.e[i14] + n5b.i(n5bVar, v5b.f[i14]);
                                            w5bVar.x = 0;
                                            w5bVar.a = 6;
                                            if (w5bVar.u) {
                                                int i15 = w5bVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (w5bVar.x < w5bVar.y) {
                                                        n5b.j(n5bVar);
                                                        if (w5bVar.n[0] == 0) {
                                                            f(w5bVar);
                                                        }
                                                        byte[] bArr2 = w5bVar.A;
                                                        int i18 = w5bVar.B;
                                                        int[] iArr2 = p5b.a;
                                                        int i19 = iArr2[w5bVar.D + i16];
                                                        int[] iArr3 = w5bVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        n5b.d(n5bVar);
                                                        t5b t5bVar = w5bVar.k;
                                                        int r2 = r(t5bVar.b, t5bVar.c[bArr2[i18 + (iArr2[w5bVar.E + i17] | i19)] & 255], n5bVar);
                                                        int i20 = w5bVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        w5bVar.x++;
                                                        w5bVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            w5bVar.b = 6;
                                                            w5bVar.Y = w5bVar.Q;
                                                            w5bVar.X = 0;
                                                            w5bVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (w5bVar.x < w5bVar.y) {
                                                        n5b.j(n5bVar);
                                                        if (w5bVar.n[0] == 0) {
                                                            f(w5bVar);
                                                        }
                                                        int[] iArr4 = w5bVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        n5b.d(n5bVar);
                                                        bArr[w5bVar.r] = (byte) r(w5bVar.k.b, w5bVar.w, n5bVar);
                                                        w5bVar.x++;
                                                        int i22 = w5bVar.r;
                                                        w5bVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            w5bVar.b = 6;
                                                            w5bVar.Y = w5bVar.Q;
                                                            w5bVar.X = 0;
                                                            w5bVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (w5bVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = w5bVar.g - w5bVar.y;
                                                w5bVar.g = i23;
                                                if (i23 <= 0) {
                                                    w5bVar.a = 3;
                                                    break;
                                                } else {
                                                    if (w5bVar.G < 0) {
                                                        n5b.j(n5bVar);
                                                        if (w5bVar.n[2] == 0) {
                                                            e(w5bVar);
                                                        }
                                                        int[] iArr5 = w5bVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        n5b.d(n5bVar);
                                                        t5b t5bVar2 = w5bVar.m;
                                                        int[] iArr6 = t5bVar2.b;
                                                        int[] iArr7 = t5bVar2.c;
                                                        byte[] bArr3 = w5bVar.H;
                                                        int i24 = w5bVar.C;
                                                        int i25 = w5bVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], n5bVar);
                                                        w5bVar.G = r3;
                                                        int i26 = w5bVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            w5bVar.G = i27;
                                                            int i28 = w5bVar.J & i27;
                                                            int i29 = i27 >>> w5bVar.K;
                                                            w5bVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            w5bVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + n5b.i(n5bVar, i30)) << w5bVar.K);
                                                        }
                                                    }
                                                    int t = t(w5bVar.G, w5bVar.q, w5bVar.t);
                                                    w5bVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = w5bVar.s;
                                                        int i32 = w5bVar.O;
                                                        if (i31 != i32 && (i6 = w5bVar.r) < i32) {
                                                            w5bVar.s = i6;
                                                        } else {
                                                            w5bVar.s = w5bVar.O;
                                                        }
                                                        w5bVar.N = w5bVar.r;
                                                        int i33 = w5bVar.L;
                                                        if (i33 > w5bVar.s) {
                                                            w5bVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (w5bVar.G > 0) {
                                                                int[] iArr8 = w5bVar.q;
                                                                int i34 = w5bVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                w5bVar.t = i34 + 1;
                                                            }
                                                            if (w5bVar.M <= w5bVar.g) {
                                                                w5bVar.x = 0;
                                                                w5bVar.a = 7;
                                                                int i35 = w5bVar.r;
                                                                i = (i35 - w5bVar.L) & i9;
                                                                i2 = w5bVar.M - w5bVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    w5bVar.x += i2;
                                                                    w5bVar.g -= i2;
                                                                    w5bVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = w5bVar.x;
                                                                        if (i3 >= w5bVar.M) {
                                                                            i4 = w5bVar.r;
                                                                            bArr[i4] = bArr[(i4 - w5bVar.L) & i9];
                                                                            w5bVar.g--;
                                                                            w5bVar.x = i3 + 1;
                                                                            w5bVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    w5bVar.b = 7;
                                                                    w5bVar.Y = w5bVar.Q;
                                                                    w5bVar.X = 0;
                                                                    w5bVar.a = 12;
                                                                    if (w5bVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        w5bVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (w5bVar.a != i5) {
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
                                        if (w5bVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (w5bVar.g > 0) {
                                            n5b.j(n5bVar);
                                            n5b.i(n5bVar, 8);
                                            w5bVar.g--;
                                        }
                                        w5bVar.a = 1;
                                        break;
                                    case 5:
                                        a(w5bVar);
                                        break;
                                    case 6:
                                        if (w5bVar.u) {
                                        }
                                        if (w5bVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = w5bVar.r;
                                        i = (i352 - w5bVar.L) & i9;
                                        i2 = w5bVar.M - w5bVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = w5bVar.x;
                                            if (i3 >= w5bVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        w5bVar.b = 7;
                                        w5bVar.Y = w5bVar.Q;
                                        w5bVar.X = 0;
                                        w5bVar.a = 12;
                                        if (w5bVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = w5bVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, w5bVar.N - i36);
                                        w5bVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = w5bVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = r5b.a[i37];
                                            int i39 = (w5bVar.L - w5bVar.s) - 1;
                                            int i40 = r5b.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < x5b.d.length) {
                                                int b2 = x5b.b(bArr, w5bVar.N, r5b.a(), i43, w5bVar.M, x5b.d[i42]);
                                                int i44 = w5bVar.N + b2;
                                                w5bVar.N = i44;
                                                w5bVar.r += b2;
                                                w5bVar.g -= b2;
                                                int i45 = w5bVar.Q;
                                                if (i44 >= i45) {
                                                    w5bVar.b = 8;
                                                    w5bVar.Y = i45;
                                                    w5bVar.X = 0;
                                                    w5bVar.a = 12;
                                                    break;
                                                } else {
                                                    w5bVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + w5bVar.a);
                                }
                            } else if (!u(w5bVar)) {
                                return;
                            } else {
                                int i46 = w5bVar.r;
                                int i47 = w5bVar.O;
                                if (i46 >= i47) {
                                    w5bVar.s = i47;
                                }
                                w5bVar.r &= i9;
                                w5bVar.a = w5bVar.b;
                            }
                        } else if (i10 == 10) {
                            if (w5bVar.g >= 0) {
                                n5b.g(n5bVar);
                                n5b.a(w5bVar.c, true);
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

    public static void s(w5b w5bVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, w5bVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            w5bVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, n5b n5bVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, n5bVar)) == null) {
            n5b.d(n5bVar);
            int r = r(iArr, i, n5bVar);
            return v5b.a[r] + n5b.i(n5bVar, v5b.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, n5b n5bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), n5bVar}) == null) {
            n5b.j(n5bVar);
            int[] iArr2 = new int[i];
            int i3 = n5b.i(n5bVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = n5b.i(n5bVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = n5b.i(n5bVar, i6) % i;
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
                            if (n5b.i(n5bVar, 1) == 1) {
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
                    s5b.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                n5b.d(n5bVar);
                long j = n5bVar.f;
                int i11 = n5bVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                n5bVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, n5bVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.y5b.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, n5b n5bVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, n5bVar) == null) {
            int[] iArr3 = new int[32];
            s5b.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    n5b.j(n5bVar);
                    n5b.d(n5bVar);
                    long j = n5bVar.f;
                    int i9 = n5bVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    n5bVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + n5b.i(n5bVar, i13) + 3;
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

    public static void p(w5b w5bVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, w5bVar) == null) {
            n5b n5bVar = w5bVar.c;
            for (int i = 0; i < 3; i++) {
                w5bVar.o[i] = h(n5bVar) + 1;
                w5bVar.n[i] = 268435456;
                int[] iArr2 = w5bVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, w5bVar.e, i2, n5bVar);
                    n(26, w5bVar.f, i2, n5bVar);
                    w5bVar.n[i] = m(w5bVar.f, i2, n5bVar);
                }
            }
            n5b.j(n5bVar);
            w5bVar.K = n5b.i(n5bVar, 2);
            int i3 = n5b.i(n5bVar, 4);
            int i4 = w5bVar.K;
            int i5 = (i3 << i4) + 16;
            w5bVar.I = i5;
            w5bVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            w5bVar.z = new byte[w5bVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = w5bVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    w5bVar.z[i7] = (byte) (n5b.i(n5bVar, 2) << 1);
                    i7++;
                }
                n5b.j(n5bVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            w5bVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, n5bVar);
            w5bVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (w5bVar.o[0] << 6)) {
                    break;
                } else if (w5bVar.A[i8] != (i8 >> 6)) {
                    w5bVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = w5bVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            w5bVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, n5bVar);
            t5b.b(w5bVar.k, 256, d2);
            t5b.b(w5bVar.l, 704, w5bVar.o[1]);
            t5b.b(w5bVar.m, i6, d3);
            t5b.a(w5bVar.k, n5bVar);
            t5b.a(w5bVar.l, n5bVar);
            t5b.a(w5bVar.m, n5bVar);
            w5bVar.B = 0;
            w5bVar.C = 0;
            int[] iArr4 = p5b.b;
            byte[] bArr3 = w5bVar.z;
            w5bVar.D = iArr4[bArr3[0]];
            w5bVar.E = iArr4[bArr3[0] + 1];
            w5bVar.v = 0;
            w5bVar.w = w5bVar.k.c[0];
            w5bVar.F = w5bVar.l.c[0];
            int[] iArr5 = w5bVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(w5b w5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, w5bVar) == null) {
            n5b n5bVar = w5bVar.c;
            if (w5bVar.h) {
                w5bVar.b = 10;
                w5bVar.Y = w5bVar.r;
                w5bVar.X = 0;
                w5bVar.a = 12;
                return;
            }
            t5b t5bVar = w5bVar.k;
            t5bVar.b = null;
            t5bVar.c = null;
            t5b t5bVar2 = w5bVar.l;
            t5bVar2.b = null;
            t5bVar2.c = null;
            t5b t5bVar3 = w5bVar.m;
            t5bVar3.b = null;
            t5bVar3.c = null;
            n5b.j(n5bVar);
            g(n5bVar, w5bVar);
            if (w5bVar.g == 0 && !w5bVar.j) {
                return;
            }
            if (!w5bVar.i && !w5bVar.j) {
                w5bVar.a = 2;
            } else {
                n5b.g(n5bVar);
                if (w5bVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                w5bVar.a = i;
            }
            if (w5bVar.j) {
                return;
            }
            w5bVar.R += w5bVar.g;
            if (w5bVar.Q < w5bVar.P) {
                k(w5bVar);
            }
        }
    }

    public static int r(int[] iArr, int i, n5b n5bVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, n5bVar)) == null) {
            long j = n5bVar.f;
            int i2 = n5bVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                n5bVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            n5bVar.g = i2 + (iArr[i7] >> 16) + 8;
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
