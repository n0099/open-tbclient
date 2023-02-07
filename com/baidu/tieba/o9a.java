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
public final class o9a {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947988466, "Lcom/baidu/tieba/o9a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947988466, "Lcom/baidu/tieba/o9a;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(u9a u9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, u9aVar) == null) {
            l9a l9aVar = u9aVar.c;
            byte[] bArr = u9aVar.d;
            int i = u9aVar.g;
            if (i <= 0) {
                l9a.k(l9aVar);
                u9aVar.a = 1;
                return;
            }
            int min = Math.min(u9aVar.Q - u9aVar.r, i);
            l9a.c(l9aVar, bArr, u9aVar.r, min);
            u9aVar.g -= min;
            int i2 = u9aVar.r + min;
            u9aVar.r = i2;
            int i3 = u9aVar.Q;
            if (i2 == i3) {
                u9aVar.b = 5;
                u9aVar.Y = i3;
                u9aVar.X = 0;
                u9aVar.a = 12;
                return;
            }
            l9a.k(l9aVar);
            u9aVar.a = 1;
        }
    }

    public static void k(u9a u9aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, u9aVar) == null) {
            int i2 = u9aVar.P;
            long j = u9aVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + u9aVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!u9aVar.h && i2 < 16384 && u9aVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = u9aVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = u9aVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = u9aVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = u9aVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(u9aVar.S, i, bArr, 0, i5);
                    u9aVar.r = i5;
                    u9aVar.T = i5;
                }
            }
            u9aVar.d = bArr;
            u9aVar.Q = i2;
        }
    }

    public static boolean u(u9a u9aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, u9aVar)) == null) {
            int i = u9aVar.T;
            if (i != 0) {
                u9aVar.X += i;
                u9aVar.T = 0;
            }
            int min = Math.min(u9aVar.V - u9aVar.W, u9aVar.Y - u9aVar.X);
            if (min != 0) {
                System.arraycopy(u9aVar.d, u9aVar.X, u9aVar.Z, u9aVar.U + u9aVar.W, min);
                u9aVar.W += min;
                u9aVar.X += min;
            }
            if (u9aVar.W >= u9aVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(u9a u9aVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, u9aVar, i) == null) {
            l9a l9aVar = u9aVar.c;
            int[] iArr = u9aVar.p;
            int i3 = i * 2;
            l9a.d(l9aVar);
            int i4 = i * 1080;
            int r = r(u9aVar.e, i4, l9aVar);
            u9aVar.n[i] = m(u9aVar.f, i4, l9aVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = u9aVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(u9a u9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, u9aVar) == null) {
            b(u9aVar, 1);
            u9aVar.F = u9aVar.l.c[u9aVar.p[3]];
        }
    }

    public static void e(u9a u9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, u9aVar) == null) {
            b(u9aVar, 2);
            u9aVar.C = u9aVar.p[5] << 2;
        }
    }

    public static int h(l9a l9aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, l9aVar)) == null) {
            if (l9a.i(l9aVar, 1) != 0) {
                int i = l9a.i(l9aVar, 3);
                if (i == 0) {
                    return 1;
                }
                return l9a.i(l9aVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, l9a l9aVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, l9aVar)) == null) {
            l9a.j(l9aVar);
            int h = h(l9aVar) + 1;
            if (h == 1) {
                w9a.a(bArr, 0, i);
                return h;
            }
            if (l9a.i(l9aVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = l9a.i(l9aVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, l9aVar);
            int i3 = 0;
            while (i3 < i) {
                l9a.j(l9aVar);
                l9a.d(l9aVar);
                int r = r(iArr, 0, l9aVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + l9a.i(l9aVar, r); i4 != 0; i4--) {
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
            if (l9a.i(l9aVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(u9a u9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, u9aVar) == null) {
            b(u9aVar, 0);
            int i = u9aVar.p[1];
            int i2 = i << 6;
            u9aVar.B = i2;
            int i3 = u9aVar.A[i2] & 255;
            u9aVar.v = i3;
            u9aVar.w = u9aVar.k.c[i3];
            byte b2 = u9aVar.z[i];
            int[] iArr = n9a.b;
            u9aVar.D = iArr[b2];
            u9aVar.E = iArr[b2 + 1];
        }
    }

    public static void g(l9a l9aVar, u9a u9aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, l9aVar, u9aVar) == null) {
            boolean z2 = true;
            if (l9a.i(l9aVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            u9aVar.h = z;
            u9aVar.g = 0;
            u9aVar.i = false;
            u9aVar.j = false;
            if (z && l9a.i(l9aVar, 1) != 0) {
                return;
            }
            int i = l9a.i(l9aVar, 2) + 4;
            if (i == 7) {
                u9aVar.j = true;
                if (l9a.i(l9aVar, 1) == 0) {
                    int i2 = l9a.i(l9aVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = l9a.i(l9aVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        u9aVar.g = (i4 << (i3 * 8)) | u9aVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = l9a.i(l9aVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    u9aVar.g = (i6 << (i5 * 4)) | u9aVar.g;
                }
            }
            u9aVar.g++;
            if (!u9aVar.h) {
                if (l9a.i(l9aVar, 1) != 1) {
                    z2 = false;
                }
                u9aVar.i = z2;
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
    public static void i(u9a u9aVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, u9aVar) == null) {
            int i8 = u9aVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    l9a l9aVar = u9aVar.c;
                    int i9 = u9aVar.Q - 1;
                    byte[] bArr = u9aVar.d;
                    while (true) {
                        int i10 = u9aVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (u9aVar.g >= 0) {
                                            q(u9aVar);
                                            i9 = u9aVar.Q - 1;
                                            bArr = u9aVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(u9aVar);
                                        u9aVar.a = 3;
                                        if (u9aVar.g > 0) {
                                            u9aVar.a = 1;
                                            break;
                                        } else {
                                            l9a.j(l9aVar);
                                            if (u9aVar.n[1] == 0) {
                                                c(u9aVar);
                                            }
                                            int[] iArr = u9aVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            l9a.d(l9aVar);
                                            int r = r(u9aVar.l.b, u9aVar.F, l9aVar);
                                            int i12 = r >>> 6;
                                            u9aVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                u9aVar.G = -1;
                                            }
                                            int i13 = t9a.g[i12] + ((r >>> 3) & 7);
                                            int i14 = t9a.h[i12] + (r & 7);
                                            u9aVar.y = t9a.c[i13] + l9a.i(l9aVar, t9a.d[i13]);
                                            u9aVar.M = t9a.e[i14] + l9a.i(l9aVar, t9a.f[i14]);
                                            u9aVar.x = 0;
                                            u9aVar.a = 6;
                                            if (u9aVar.u) {
                                                int i15 = u9aVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (u9aVar.x < u9aVar.y) {
                                                        l9a.j(l9aVar);
                                                        if (u9aVar.n[0] == 0) {
                                                            f(u9aVar);
                                                        }
                                                        byte[] bArr2 = u9aVar.A;
                                                        int i18 = u9aVar.B;
                                                        int[] iArr2 = n9a.a;
                                                        int i19 = iArr2[u9aVar.D + i16];
                                                        int[] iArr3 = u9aVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        l9a.d(l9aVar);
                                                        r9a r9aVar = u9aVar.k;
                                                        int r2 = r(r9aVar.b, r9aVar.c[bArr2[i18 + (iArr2[u9aVar.E + i17] | i19)] & 255], l9aVar);
                                                        int i20 = u9aVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        u9aVar.x++;
                                                        u9aVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            u9aVar.b = 6;
                                                            u9aVar.Y = u9aVar.Q;
                                                            u9aVar.X = 0;
                                                            u9aVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (u9aVar.x < u9aVar.y) {
                                                        l9a.j(l9aVar);
                                                        if (u9aVar.n[0] == 0) {
                                                            f(u9aVar);
                                                        }
                                                        int[] iArr4 = u9aVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        l9a.d(l9aVar);
                                                        bArr[u9aVar.r] = (byte) r(u9aVar.k.b, u9aVar.w, l9aVar);
                                                        u9aVar.x++;
                                                        int i22 = u9aVar.r;
                                                        u9aVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            u9aVar.b = 6;
                                                            u9aVar.Y = u9aVar.Q;
                                                            u9aVar.X = 0;
                                                            u9aVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (u9aVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = u9aVar.g - u9aVar.y;
                                                u9aVar.g = i23;
                                                if (i23 <= 0) {
                                                    u9aVar.a = 3;
                                                    break;
                                                } else {
                                                    if (u9aVar.G < 0) {
                                                        l9a.j(l9aVar);
                                                        if (u9aVar.n[2] == 0) {
                                                            e(u9aVar);
                                                        }
                                                        int[] iArr5 = u9aVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        l9a.d(l9aVar);
                                                        r9a r9aVar2 = u9aVar.m;
                                                        int[] iArr6 = r9aVar2.b;
                                                        int[] iArr7 = r9aVar2.c;
                                                        byte[] bArr3 = u9aVar.H;
                                                        int i24 = u9aVar.C;
                                                        int i25 = u9aVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], l9aVar);
                                                        u9aVar.G = r3;
                                                        int i26 = u9aVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            u9aVar.G = i27;
                                                            int i28 = u9aVar.J & i27;
                                                            int i29 = i27 >>> u9aVar.K;
                                                            u9aVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            u9aVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + l9a.i(l9aVar, i30)) << u9aVar.K);
                                                        }
                                                    }
                                                    int t = t(u9aVar.G, u9aVar.q, u9aVar.t);
                                                    u9aVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = u9aVar.s;
                                                        int i32 = u9aVar.O;
                                                        if (i31 != i32 && (i6 = u9aVar.r) < i32) {
                                                            u9aVar.s = i6;
                                                        } else {
                                                            u9aVar.s = u9aVar.O;
                                                        }
                                                        u9aVar.N = u9aVar.r;
                                                        int i33 = u9aVar.L;
                                                        if (i33 > u9aVar.s) {
                                                            u9aVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (u9aVar.G > 0) {
                                                                int[] iArr8 = u9aVar.q;
                                                                int i34 = u9aVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                u9aVar.t = i34 + 1;
                                                            }
                                                            if (u9aVar.M <= u9aVar.g) {
                                                                u9aVar.x = 0;
                                                                u9aVar.a = 7;
                                                                int i35 = u9aVar.r;
                                                                i = (i35 - u9aVar.L) & i9;
                                                                i2 = u9aVar.M - u9aVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    u9aVar.x += i2;
                                                                    u9aVar.g -= i2;
                                                                    u9aVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = u9aVar.x;
                                                                        if (i3 >= u9aVar.M) {
                                                                            i4 = u9aVar.r;
                                                                            bArr[i4] = bArr[(i4 - u9aVar.L) & i9];
                                                                            u9aVar.g--;
                                                                            u9aVar.x = i3 + 1;
                                                                            u9aVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    u9aVar.b = 7;
                                                                    u9aVar.Y = u9aVar.Q;
                                                                    u9aVar.X = 0;
                                                                    u9aVar.a = 12;
                                                                    if (u9aVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        u9aVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (u9aVar.a != i5) {
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
                                        if (u9aVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (u9aVar.g > 0) {
                                            l9a.j(l9aVar);
                                            l9a.i(l9aVar, 8);
                                            u9aVar.g--;
                                        }
                                        u9aVar.a = 1;
                                        break;
                                    case 5:
                                        a(u9aVar);
                                        break;
                                    case 6:
                                        if (u9aVar.u) {
                                        }
                                        if (u9aVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = u9aVar.r;
                                        i = (i352 - u9aVar.L) & i9;
                                        i2 = u9aVar.M - u9aVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = u9aVar.x;
                                            if (i3 >= u9aVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        u9aVar.b = 7;
                                        u9aVar.Y = u9aVar.Q;
                                        u9aVar.X = 0;
                                        u9aVar.a = 12;
                                        if (u9aVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = u9aVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, u9aVar.N - i36);
                                        u9aVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = u9aVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = p9a.a[i37];
                                            int i39 = (u9aVar.L - u9aVar.s) - 1;
                                            int i40 = p9a.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < v9a.d.length) {
                                                int b2 = v9a.b(bArr, u9aVar.N, p9a.a(), i43, u9aVar.M, v9a.d[i42]);
                                                int i44 = u9aVar.N + b2;
                                                u9aVar.N = i44;
                                                u9aVar.r += b2;
                                                u9aVar.g -= b2;
                                                int i45 = u9aVar.Q;
                                                if (i44 >= i45) {
                                                    u9aVar.b = 8;
                                                    u9aVar.Y = i45;
                                                    u9aVar.X = 0;
                                                    u9aVar.a = 12;
                                                    break;
                                                } else {
                                                    u9aVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + u9aVar.a);
                                }
                            } else if (!u(u9aVar)) {
                                return;
                            } else {
                                int i46 = u9aVar.r;
                                int i47 = u9aVar.O;
                                if (i46 >= i47) {
                                    u9aVar.s = i47;
                                }
                                u9aVar.r &= i9;
                                u9aVar.a = u9aVar.b;
                            }
                        } else if (i10 == 10) {
                            if (u9aVar.g >= 0) {
                                l9a.g(l9aVar);
                                l9a.a(u9aVar.c, true);
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

    public static void s(u9a u9aVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, u9aVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            u9aVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, l9a l9aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, l9aVar)) == null) {
            l9a.d(l9aVar);
            int r = r(iArr, i, l9aVar);
            return t9a.a[r] + l9a.i(l9aVar, t9a.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, l9a l9aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), l9aVar}) == null) {
            l9a.j(l9aVar);
            int[] iArr2 = new int[i];
            int i3 = l9a.i(l9aVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = l9a.i(l9aVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = l9a.i(l9aVar, i6) % i;
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
                            if (l9a.i(l9aVar, 1) == 1) {
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
                    q9a.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                l9a.d(l9aVar);
                long j = l9aVar.f;
                int i11 = l9aVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                l9aVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, l9aVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.w9a.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, l9a l9aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, l9aVar) == null) {
            int[] iArr3 = new int[32];
            q9a.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    l9a.j(l9aVar);
                    l9a.d(l9aVar);
                    long j = l9aVar.f;
                    int i9 = l9aVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    l9aVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + l9a.i(l9aVar, i13) + 3;
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

    public static void p(u9a u9aVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, u9aVar) == null) {
            l9a l9aVar = u9aVar.c;
            for (int i = 0; i < 3; i++) {
                u9aVar.o[i] = h(l9aVar) + 1;
                u9aVar.n[i] = 268435456;
                int[] iArr2 = u9aVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, u9aVar.e, i2, l9aVar);
                    n(26, u9aVar.f, i2, l9aVar);
                    u9aVar.n[i] = m(u9aVar.f, i2, l9aVar);
                }
            }
            l9a.j(l9aVar);
            u9aVar.K = l9a.i(l9aVar, 2);
            int i3 = l9a.i(l9aVar, 4);
            int i4 = u9aVar.K;
            int i5 = (i3 << i4) + 16;
            u9aVar.I = i5;
            u9aVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            u9aVar.z = new byte[u9aVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = u9aVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    u9aVar.z[i7] = (byte) (l9a.i(l9aVar, 2) << 1);
                    i7++;
                }
                l9a.j(l9aVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            u9aVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, l9aVar);
            u9aVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (u9aVar.o[0] << 6)) {
                    break;
                } else if (u9aVar.A[i8] != (i8 >> 6)) {
                    u9aVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = u9aVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            u9aVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, l9aVar);
            r9a.b(u9aVar.k, 256, d2);
            r9a.b(u9aVar.l, 704, u9aVar.o[1]);
            r9a.b(u9aVar.m, i6, d3);
            r9a.a(u9aVar.k, l9aVar);
            r9a.a(u9aVar.l, l9aVar);
            r9a.a(u9aVar.m, l9aVar);
            u9aVar.B = 0;
            u9aVar.C = 0;
            int[] iArr4 = n9a.b;
            byte[] bArr3 = u9aVar.z;
            u9aVar.D = iArr4[bArr3[0]];
            u9aVar.E = iArr4[bArr3[0] + 1];
            u9aVar.v = 0;
            u9aVar.w = u9aVar.k.c[0];
            u9aVar.F = u9aVar.l.c[0];
            int[] iArr5 = u9aVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(u9a u9aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, u9aVar) == null) {
            l9a l9aVar = u9aVar.c;
            if (u9aVar.h) {
                u9aVar.b = 10;
                u9aVar.Y = u9aVar.r;
                u9aVar.X = 0;
                u9aVar.a = 12;
                return;
            }
            r9a r9aVar = u9aVar.k;
            r9aVar.b = null;
            r9aVar.c = null;
            r9a r9aVar2 = u9aVar.l;
            r9aVar2.b = null;
            r9aVar2.c = null;
            r9a r9aVar3 = u9aVar.m;
            r9aVar3.b = null;
            r9aVar3.c = null;
            l9a.j(l9aVar);
            g(l9aVar, u9aVar);
            if (u9aVar.g == 0 && !u9aVar.j) {
                return;
            }
            if (!u9aVar.i && !u9aVar.j) {
                u9aVar.a = 2;
            } else {
                l9a.g(l9aVar);
                if (u9aVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                u9aVar.a = i;
            }
            if (u9aVar.j) {
                return;
            }
            u9aVar.R += u9aVar.g;
            if (u9aVar.Q < u9aVar.P) {
                k(u9aVar);
            }
        }
    }

    public static int r(int[] iArr, int i, l9a l9aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, l9aVar)) == null) {
            long j = l9aVar.f;
            int i2 = l9aVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                l9aVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            l9aVar.g = i2 + (iArr[i7] >> 16) + 8;
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
