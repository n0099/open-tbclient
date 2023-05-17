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
public final class p5b {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948014444, "Lcom/baidu/tieba/p5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948014444, "Lcom/baidu/tieba/p5b;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(v5b v5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, v5bVar) == null) {
            m5b m5bVar = v5bVar.c;
            byte[] bArr = v5bVar.d;
            int i = v5bVar.g;
            if (i <= 0) {
                m5b.k(m5bVar);
                v5bVar.a = 1;
                return;
            }
            int min = Math.min(v5bVar.Q - v5bVar.r, i);
            m5b.c(m5bVar, bArr, v5bVar.r, min);
            v5bVar.g -= min;
            int i2 = v5bVar.r + min;
            v5bVar.r = i2;
            int i3 = v5bVar.Q;
            if (i2 == i3) {
                v5bVar.b = 5;
                v5bVar.Y = i3;
                v5bVar.X = 0;
                v5bVar.a = 12;
                return;
            }
            m5b.k(m5bVar);
            v5bVar.a = 1;
        }
    }

    public static void k(v5b v5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, v5bVar) == null) {
            int i2 = v5bVar.P;
            long j = v5bVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + v5bVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!v5bVar.h && i2 < 16384 && v5bVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = v5bVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = v5bVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = v5bVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = v5bVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(v5bVar.S, i, bArr, 0, i5);
                    v5bVar.r = i5;
                    v5bVar.T = i5;
                }
            }
            v5bVar.d = bArr;
            v5bVar.Q = i2;
        }
    }

    public static boolean u(v5b v5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, v5bVar)) == null) {
            int i = v5bVar.T;
            if (i != 0) {
                v5bVar.X += i;
                v5bVar.T = 0;
            }
            int min = Math.min(v5bVar.V - v5bVar.W, v5bVar.Y - v5bVar.X);
            if (min != 0) {
                System.arraycopy(v5bVar.d, v5bVar.X, v5bVar.Z, v5bVar.U + v5bVar.W, min);
                v5bVar.W += min;
                v5bVar.X += min;
            }
            if (v5bVar.W >= v5bVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(v5b v5bVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, v5bVar, i) == null) {
            m5b m5bVar = v5bVar.c;
            int[] iArr = v5bVar.p;
            int i3 = i * 2;
            m5b.d(m5bVar);
            int i4 = i * 1080;
            int r = r(v5bVar.e, i4, m5bVar);
            v5bVar.n[i] = m(v5bVar.f, i4, m5bVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = v5bVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(v5b v5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, v5bVar) == null) {
            b(v5bVar, 1);
            v5bVar.F = v5bVar.l.c[v5bVar.p[3]];
        }
    }

    public static void e(v5b v5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, v5bVar) == null) {
            b(v5bVar, 2);
            v5bVar.C = v5bVar.p[5] << 2;
        }
    }

    public static int h(m5b m5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, m5bVar)) == null) {
            if (m5b.i(m5bVar, 1) != 0) {
                int i = m5b.i(m5bVar, 3);
                if (i == 0) {
                    return 1;
                }
                return m5b.i(m5bVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, m5b m5bVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, m5bVar)) == null) {
            m5b.j(m5bVar);
            int h = h(m5bVar) + 1;
            if (h == 1) {
                x5b.a(bArr, 0, i);
                return h;
            }
            if (m5b.i(m5bVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = m5b.i(m5bVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, m5bVar);
            int i3 = 0;
            while (i3 < i) {
                m5b.j(m5bVar);
                m5b.d(m5bVar);
                int r = r(iArr, 0, m5bVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + m5b.i(m5bVar, r); i4 != 0; i4--) {
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
            if (m5b.i(m5bVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(v5b v5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, v5bVar) == null) {
            b(v5bVar, 0);
            int i = v5bVar.p[1];
            int i2 = i << 6;
            v5bVar.B = i2;
            int i3 = v5bVar.A[i2] & 255;
            v5bVar.v = i3;
            v5bVar.w = v5bVar.k.c[i3];
            byte b2 = v5bVar.z[i];
            int[] iArr = o5b.b;
            v5bVar.D = iArr[b2];
            v5bVar.E = iArr[b2 + 1];
        }
    }

    public static void g(m5b m5bVar, v5b v5bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, m5bVar, v5bVar) == null) {
            boolean z2 = true;
            if (m5b.i(m5bVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            v5bVar.h = z;
            v5bVar.g = 0;
            v5bVar.i = false;
            v5bVar.j = false;
            if (z && m5b.i(m5bVar, 1) != 0) {
                return;
            }
            int i = m5b.i(m5bVar, 2) + 4;
            if (i == 7) {
                v5bVar.j = true;
                if (m5b.i(m5bVar, 1) == 0) {
                    int i2 = m5b.i(m5bVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = m5b.i(m5bVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        v5bVar.g = (i4 << (i3 * 8)) | v5bVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = m5b.i(m5bVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    v5bVar.g = (i6 << (i5 * 4)) | v5bVar.g;
                }
            }
            v5bVar.g++;
            if (!v5bVar.h) {
                if (m5b.i(m5bVar, 1) != 1) {
                    z2 = false;
                }
                v5bVar.i = z2;
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
    public static void i(v5b v5bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, v5bVar) == null) {
            int i8 = v5bVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    m5b m5bVar = v5bVar.c;
                    int i9 = v5bVar.Q - 1;
                    byte[] bArr = v5bVar.d;
                    while (true) {
                        int i10 = v5bVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (v5bVar.g >= 0) {
                                            q(v5bVar);
                                            i9 = v5bVar.Q - 1;
                                            bArr = v5bVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(v5bVar);
                                        v5bVar.a = 3;
                                        if (v5bVar.g > 0) {
                                            v5bVar.a = 1;
                                            break;
                                        } else {
                                            m5b.j(m5bVar);
                                            if (v5bVar.n[1] == 0) {
                                                c(v5bVar);
                                            }
                                            int[] iArr = v5bVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            m5b.d(m5bVar);
                                            int r = r(v5bVar.l.b, v5bVar.F, m5bVar);
                                            int i12 = r >>> 6;
                                            v5bVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                v5bVar.G = -1;
                                            }
                                            int i13 = u5b.g[i12] + ((r >>> 3) & 7);
                                            int i14 = u5b.h[i12] + (r & 7);
                                            v5bVar.y = u5b.c[i13] + m5b.i(m5bVar, u5b.d[i13]);
                                            v5bVar.M = u5b.e[i14] + m5b.i(m5bVar, u5b.f[i14]);
                                            v5bVar.x = 0;
                                            v5bVar.a = 6;
                                            if (v5bVar.u) {
                                                int i15 = v5bVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (v5bVar.x < v5bVar.y) {
                                                        m5b.j(m5bVar);
                                                        if (v5bVar.n[0] == 0) {
                                                            f(v5bVar);
                                                        }
                                                        byte[] bArr2 = v5bVar.A;
                                                        int i18 = v5bVar.B;
                                                        int[] iArr2 = o5b.a;
                                                        int i19 = iArr2[v5bVar.D + i16];
                                                        int[] iArr3 = v5bVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        m5b.d(m5bVar);
                                                        s5b s5bVar = v5bVar.k;
                                                        int r2 = r(s5bVar.b, s5bVar.c[bArr2[i18 + (iArr2[v5bVar.E + i17] | i19)] & 255], m5bVar);
                                                        int i20 = v5bVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        v5bVar.x++;
                                                        v5bVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            v5bVar.b = 6;
                                                            v5bVar.Y = v5bVar.Q;
                                                            v5bVar.X = 0;
                                                            v5bVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (v5bVar.x < v5bVar.y) {
                                                        m5b.j(m5bVar);
                                                        if (v5bVar.n[0] == 0) {
                                                            f(v5bVar);
                                                        }
                                                        int[] iArr4 = v5bVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        m5b.d(m5bVar);
                                                        bArr[v5bVar.r] = (byte) r(v5bVar.k.b, v5bVar.w, m5bVar);
                                                        v5bVar.x++;
                                                        int i22 = v5bVar.r;
                                                        v5bVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            v5bVar.b = 6;
                                                            v5bVar.Y = v5bVar.Q;
                                                            v5bVar.X = 0;
                                                            v5bVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (v5bVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = v5bVar.g - v5bVar.y;
                                                v5bVar.g = i23;
                                                if (i23 <= 0) {
                                                    v5bVar.a = 3;
                                                    break;
                                                } else {
                                                    if (v5bVar.G < 0) {
                                                        m5b.j(m5bVar);
                                                        if (v5bVar.n[2] == 0) {
                                                            e(v5bVar);
                                                        }
                                                        int[] iArr5 = v5bVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        m5b.d(m5bVar);
                                                        s5b s5bVar2 = v5bVar.m;
                                                        int[] iArr6 = s5bVar2.b;
                                                        int[] iArr7 = s5bVar2.c;
                                                        byte[] bArr3 = v5bVar.H;
                                                        int i24 = v5bVar.C;
                                                        int i25 = v5bVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], m5bVar);
                                                        v5bVar.G = r3;
                                                        int i26 = v5bVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            v5bVar.G = i27;
                                                            int i28 = v5bVar.J & i27;
                                                            int i29 = i27 >>> v5bVar.K;
                                                            v5bVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            v5bVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + m5b.i(m5bVar, i30)) << v5bVar.K);
                                                        }
                                                    }
                                                    int t = t(v5bVar.G, v5bVar.q, v5bVar.t);
                                                    v5bVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = v5bVar.s;
                                                        int i32 = v5bVar.O;
                                                        if (i31 != i32 && (i6 = v5bVar.r) < i32) {
                                                            v5bVar.s = i6;
                                                        } else {
                                                            v5bVar.s = v5bVar.O;
                                                        }
                                                        v5bVar.N = v5bVar.r;
                                                        int i33 = v5bVar.L;
                                                        if (i33 > v5bVar.s) {
                                                            v5bVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (v5bVar.G > 0) {
                                                                int[] iArr8 = v5bVar.q;
                                                                int i34 = v5bVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                v5bVar.t = i34 + 1;
                                                            }
                                                            if (v5bVar.M <= v5bVar.g) {
                                                                v5bVar.x = 0;
                                                                v5bVar.a = 7;
                                                                int i35 = v5bVar.r;
                                                                i = (i35 - v5bVar.L) & i9;
                                                                i2 = v5bVar.M - v5bVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    v5bVar.x += i2;
                                                                    v5bVar.g -= i2;
                                                                    v5bVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = v5bVar.x;
                                                                        if (i3 >= v5bVar.M) {
                                                                            i4 = v5bVar.r;
                                                                            bArr[i4] = bArr[(i4 - v5bVar.L) & i9];
                                                                            v5bVar.g--;
                                                                            v5bVar.x = i3 + 1;
                                                                            v5bVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    v5bVar.b = 7;
                                                                    v5bVar.Y = v5bVar.Q;
                                                                    v5bVar.X = 0;
                                                                    v5bVar.a = 12;
                                                                    if (v5bVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        v5bVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (v5bVar.a != i5) {
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
                                        if (v5bVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (v5bVar.g > 0) {
                                            m5b.j(m5bVar);
                                            m5b.i(m5bVar, 8);
                                            v5bVar.g--;
                                        }
                                        v5bVar.a = 1;
                                        break;
                                    case 5:
                                        a(v5bVar);
                                        break;
                                    case 6:
                                        if (v5bVar.u) {
                                        }
                                        if (v5bVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = v5bVar.r;
                                        i = (i352 - v5bVar.L) & i9;
                                        i2 = v5bVar.M - v5bVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = v5bVar.x;
                                            if (i3 >= v5bVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        v5bVar.b = 7;
                                        v5bVar.Y = v5bVar.Q;
                                        v5bVar.X = 0;
                                        v5bVar.a = 12;
                                        if (v5bVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = v5bVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, v5bVar.N - i36);
                                        v5bVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = v5bVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = q5b.a[i37];
                                            int i39 = (v5bVar.L - v5bVar.s) - 1;
                                            int i40 = q5b.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < w5b.d.length) {
                                                int b2 = w5b.b(bArr, v5bVar.N, q5b.a(), i43, v5bVar.M, w5b.d[i42]);
                                                int i44 = v5bVar.N + b2;
                                                v5bVar.N = i44;
                                                v5bVar.r += b2;
                                                v5bVar.g -= b2;
                                                int i45 = v5bVar.Q;
                                                if (i44 >= i45) {
                                                    v5bVar.b = 8;
                                                    v5bVar.Y = i45;
                                                    v5bVar.X = 0;
                                                    v5bVar.a = 12;
                                                    break;
                                                } else {
                                                    v5bVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + v5bVar.a);
                                }
                            } else if (!u(v5bVar)) {
                                return;
                            } else {
                                int i46 = v5bVar.r;
                                int i47 = v5bVar.O;
                                if (i46 >= i47) {
                                    v5bVar.s = i47;
                                }
                                v5bVar.r &= i9;
                                v5bVar.a = v5bVar.b;
                            }
                        } else if (i10 == 10) {
                            if (v5bVar.g >= 0) {
                                m5b.g(m5bVar);
                                m5b.a(v5bVar.c, true);
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

    public static void s(v5b v5bVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, v5bVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            v5bVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, m5b m5bVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, m5bVar)) == null) {
            m5b.d(m5bVar);
            int r = r(iArr, i, m5bVar);
            return u5b.a[r] + m5b.i(m5bVar, u5b.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, m5b m5bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), m5bVar}) == null) {
            m5b.j(m5bVar);
            int[] iArr2 = new int[i];
            int i3 = m5b.i(m5bVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = m5b.i(m5bVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = m5b.i(m5bVar, i6) % i;
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
                            if (m5b.i(m5bVar, 1) == 1) {
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
                    r5b.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                m5b.d(m5bVar);
                long j = m5bVar.f;
                int i11 = m5bVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                m5bVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, m5bVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.x5b.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, m5b m5bVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, m5bVar) == null) {
            int[] iArr3 = new int[32];
            r5b.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    m5b.j(m5bVar);
                    m5b.d(m5bVar);
                    long j = m5bVar.f;
                    int i9 = m5bVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    m5bVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + m5b.i(m5bVar, i13) + 3;
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

    public static void p(v5b v5bVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, v5bVar) == null) {
            m5b m5bVar = v5bVar.c;
            for (int i = 0; i < 3; i++) {
                v5bVar.o[i] = h(m5bVar) + 1;
                v5bVar.n[i] = 268435456;
                int[] iArr2 = v5bVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, v5bVar.e, i2, m5bVar);
                    n(26, v5bVar.f, i2, m5bVar);
                    v5bVar.n[i] = m(v5bVar.f, i2, m5bVar);
                }
            }
            m5b.j(m5bVar);
            v5bVar.K = m5b.i(m5bVar, 2);
            int i3 = m5b.i(m5bVar, 4);
            int i4 = v5bVar.K;
            int i5 = (i3 << i4) + 16;
            v5bVar.I = i5;
            v5bVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            v5bVar.z = new byte[v5bVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = v5bVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    v5bVar.z[i7] = (byte) (m5b.i(m5bVar, 2) << 1);
                    i7++;
                }
                m5b.j(m5bVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            v5bVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, m5bVar);
            v5bVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (v5bVar.o[0] << 6)) {
                    break;
                } else if (v5bVar.A[i8] != (i8 >> 6)) {
                    v5bVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = v5bVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            v5bVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, m5bVar);
            s5b.b(v5bVar.k, 256, d2);
            s5b.b(v5bVar.l, 704, v5bVar.o[1]);
            s5b.b(v5bVar.m, i6, d3);
            s5b.a(v5bVar.k, m5bVar);
            s5b.a(v5bVar.l, m5bVar);
            s5b.a(v5bVar.m, m5bVar);
            v5bVar.B = 0;
            v5bVar.C = 0;
            int[] iArr4 = o5b.b;
            byte[] bArr3 = v5bVar.z;
            v5bVar.D = iArr4[bArr3[0]];
            v5bVar.E = iArr4[bArr3[0] + 1];
            v5bVar.v = 0;
            v5bVar.w = v5bVar.k.c[0];
            v5bVar.F = v5bVar.l.c[0];
            int[] iArr5 = v5bVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(v5b v5bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, v5bVar) == null) {
            m5b m5bVar = v5bVar.c;
            if (v5bVar.h) {
                v5bVar.b = 10;
                v5bVar.Y = v5bVar.r;
                v5bVar.X = 0;
                v5bVar.a = 12;
                return;
            }
            s5b s5bVar = v5bVar.k;
            s5bVar.b = null;
            s5bVar.c = null;
            s5b s5bVar2 = v5bVar.l;
            s5bVar2.b = null;
            s5bVar2.c = null;
            s5b s5bVar3 = v5bVar.m;
            s5bVar3.b = null;
            s5bVar3.c = null;
            m5b.j(m5bVar);
            g(m5bVar, v5bVar);
            if (v5bVar.g == 0 && !v5bVar.j) {
                return;
            }
            if (!v5bVar.i && !v5bVar.j) {
                v5bVar.a = 2;
            } else {
                m5b.g(m5bVar);
                if (v5bVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                v5bVar.a = i;
            }
            if (v5bVar.j) {
                return;
            }
            v5bVar.R += v5bVar.g;
            if (v5bVar.Q < v5bVar.P) {
                k(v5bVar);
            }
        }
    }

    public static int r(int[] iArr, int i, m5b m5bVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, m5bVar)) == null) {
            long j = m5bVar.f;
            int i2 = m5bVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                m5bVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            m5bVar.g = i2 + (iArr[i7] >> 16) + 8;
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
