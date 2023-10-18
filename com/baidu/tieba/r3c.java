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
public final class r3c {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948072135, "Lcom/baidu/tieba/r3c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948072135, "Lcom/baidu/tieba/r3c;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(x3c x3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, x3cVar) == null) {
            o3c o3cVar = x3cVar.c;
            byte[] bArr = x3cVar.d;
            int i = x3cVar.g;
            if (i <= 0) {
                o3c.k(o3cVar);
                x3cVar.a = 1;
                return;
            }
            int min = Math.min(x3cVar.Q - x3cVar.r, i);
            o3c.c(o3cVar, bArr, x3cVar.r, min);
            x3cVar.g -= min;
            int i2 = x3cVar.r + min;
            x3cVar.r = i2;
            int i3 = x3cVar.Q;
            if (i2 == i3) {
                x3cVar.b = 5;
                x3cVar.Y = i3;
                x3cVar.X = 0;
                x3cVar.a = 12;
                return;
            }
            o3c.k(o3cVar);
            x3cVar.a = 1;
        }
    }

    public static void k(x3c x3cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, x3cVar) == null) {
            int i2 = x3cVar.P;
            long j = x3cVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + x3cVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!x3cVar.h && i2 < 16384 && x3cVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = x3cVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = x3cVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = x3cVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = x3cVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(x3cVar.S, i, bArr, 0, i5);
                    x3cVar.r = i5;
                    x3cVar.f1181T = i5;
                }
            }
            x3cVar.d = bArr;
            x3cVar.Q = i2;
        }
    }

    public static boolean u(x3c x3cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, x3cVar)) == null) {
            int i = x3cVar.f1181T;
            if (i != 0) {
                x3cVar.X += i;
                x3cVar.f1181T = 0;
            }
            int min = Math.min(x3cVar.V - x3cVar.W, x3cVar.Y - x3cVar.X);
            if (min != 0) {
                System.arraycopy(x3cVar.d, x3cVar.X, x3cVar.Z, x3cVar.U + x3cVar.W, min);
                x3cVar.W += min;
                x3cVar.X += min;
            }
            if (x3cVar.W >= x3cVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(x3c x3cVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, x3cVar, i) == null) {
            o3c o3cVar = x3cVar.c;
            int[] iArr = x3cVar.p;
            int i3 = i * 2;
            o3c.d(o3cVar);
            int i4 = i * 1080;
            int r = r(x3cVar.e, i4, o3cVar);
            x3cVar.n[i] = m(x3cVar.f, i4, o3cVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = x3cVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(x3c x3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, x3cVar) == null) {
            b(x3cVar, 1);
            x3cVar.F = x3cVar.l.c[x3cVar.p[3]];
        }
    }

    public static void e(x3c x3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, x3cVar) == null) {
            b(x3cVar, 2);
            x3cVar.C = x3cVar.p[5] << 2;
        }
    }

    public static int h(o3c o3cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, o3cVar)) == null) {
            if (o3c.i(o3cVar, 1) != 0) {
                int i = o3c.i(o3cVar, 3);
                if (i == 0) {
                    return 1;
                }
                return o3c.i(o3cVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, o3c o3cVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, o3cVar)) == null) {
            o3c.j(o3cVar);
            int h = h(o3cVar) + 1;
            if (h == 1) {
                z3c.a(bArr, 0, i);
                return h;
            }
            if (o3c.i(o3cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = o3c.i(o3cVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, o3cVar);
            int i3 = 0;
            while (i3 < i) {
                o3c.j(o3cVar);
                o3c.d(o3cVar);
                int r = r(iArr, 0, o3cVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + o3c.i(o3cVar, r); i4 != 0; i4--) {
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
            if (o3c.i(o3cVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(x3c x3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, x3cVar) == null) {
            b(x3cVar, 0);
            int i = x3cVar.p[1];
            int i2 = i << 6;
            x3cVar.B = i2;
            int i3 = x3cVar.A[i2] & 255;
            x3cVar.v = i3;
            x3cVar.w = x3cVar.k.c[i3];
            byte b2 = x3cVar.z[i];
            int[] iArr = q3c.b;
            x3cVar.D = iArr[b2];
            x3cVar.E = iArr[b2 + 1];
        }
    }

    public static void g(o3c o3cVar, x3c x3cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, o3cVar, x3cVar) == null) {
            boolean z2 = true;
            if (o3c.i(o3cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            x3cVar.h = z;
            x3cVar.g = 0;
            x3cVar.i = false;
            x3cVar.j = false;
            if (z && o3c.i(o3cVar, 1) != 0) {
                return;
            }
            int i = o3c.i(o3cVar, 2) + 4;
            if (i == 7) {
                x3cVar.j = true;
                if (o3c.i(o3cVar, 1) == 0) {
                    int i2 = o3c.i(o3cVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = o3c.i(o3cVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        x3cVar.g = (i4 << (i3 * 8)) | x3cVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = o3c.i(o3cVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    x3cVar.g = (i6 << (i5 * 4)) | x3cVar.g;
                }
            }
            x3cVar.g++;
            if (!x3cVar.h) {
                if (o3c.i(o3cVar, 1) != 1) {
                    z2 = false;
                }
                x3cVar.i = z2;
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
    public static void i(x3c x3cVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, x3cVar) == null) {
            int i8 = x3cVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    o3c o3cVar = x3cVar.c;
                    int i9 = x3cVar.Q - 1;
                    byte[] bArr = x3cVar.d;
                    while (true) {
                        int i10 = x3cVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (x3cVar.g >= 0) {
                                            q(x3cVar);
                                            i9 = x3cVar.Q - 1;
                                            bArr = x3cVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(x3cVar);
                                        x3cVar.a = 3;
                                        if (x3cVar.g > 0) {
                                            x3cVar.a = 1;
                                            break;
                                        } else {
                                            o3c.j(o3cVar);
                                            if (x3cVar.n[1] == 0) {
                                                c(x3cVar);
                                            }
                                            int[] iArr = x3cVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            o3c.d(o3cVar);
                                            int r = r(x3cVar.l.b, x3cVar.F, o3cVar);
                                            int i12 = r >>> 6;
                                            x3cVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                x3cVar.G = -1;
                                            }
                                            int i13 = w3c.g[i12] + ((r >>> 3) & 7);
                                            int i14 = w3c.h[i12] + (r & 7);
                                            x3cVar.y = w3c.c[i13] + o3c.i(o3cVar, w3c.d[i13]);
                                            x3cVar.M = w3c.e[i14] + o3c.i(o3cVar, w3c.f[i14]);
                                            x3cVar.x = 0;
                                            x3cVar.a = 6;
                                            if (x3cVar.u) {
                                                int i15 = x3cVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (x3cVar.x < x3cVar.y) {
                                                        o3c.j(o3cVar);
                                                        if (x3cVar.n[0] == 0) {
                                                            f(x3cVar);
                                                        }
                                                        byte[] bArr2 = x3cVar.A;
                                                        int i18 = x3cVar.B;
                                                        int[] iArr2 = q3c.a;
                                                        int i19 = iArr2[x3cVar.D + i16];
                                                        int[] iArr3 = x3cVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        o3c.d(o3cVar);
                                                        u3c u3cVar = x3cVar.k;
                                                        int r2 = r(u3cVar.b, u3cVar.c[bArr2[i18 + (iArr2[x3cVar.E + i17] | i19)] & 255], o3cVar);
                                                        int i20 = x3cVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        x3cVar.x++;
                                                        x3cVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            x3cVar.b = 6;
                                                            x3cVar.Y = x3cVar.Q;
                                                            x3cVar.X = 0;
                                                            x3cVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (x3cVar.x < x3cVar.y) {
                                                        o3c.j(o3cVar);
                                                        if (x3cVar.n[0] == 0) {
                                                            f(x3cVar);
                                                        }
                                                        int[] iArr4 = x3cVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        o3c.d(o3cVar);
                                                        bArr[x3cVar.r] = (byte) r(x3cVar.k.b, x3cVar.w, o3cVar);
                                                        x3cVar.x++;
                                                        int i22 = x3cVar.r;
                                                        x3cVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            x3cVar.b = 6;
                                                            x3cVar.Y = x3cVar.Q;
                                                            x3cVar.X = 0;
                                                            x3cVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (x3cVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = x3cVar.g - x3cVar.y;
                                                x3cVar.g = i23;
                                                if (i23 <= 0) {
                                                    x3cVar.a = 3;
                                                    break;
                                                } else {
                                                    if (x3cVar.G < 0) {
                                                        o3c.j(o3cVar);
                                                        if (x3cVar.n[2] == 0) {
                                                            e(x3cVar);
                                                        }
                                                        int[] iArr5 = x3cVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        o3c.d(o3cVar);
                                                        u3c u3cVar2 = x3cVar.m;
                                                        int[] iArr6 = u3cVar2.b;
                                                        int[] iArr7 = u3cVar2.c;
                                                        byte[] bArr3 = x3cVar.H;
                                                        int i24 = x3cVar.C;
                                                        int i25 = x3cVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], o3cVar);
                                                        x3cVar.G = r3;
                                                        int i26 = x3cVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            x3cVar.G = i27;
                                                            int i28 = x3cVar.J & i27;
                                                            int i29 = i27 >>> x3cVar.K;
                                                            x3cVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            x3cVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + o3c.i(o3cVar, i30)) << x3cVar.K);
                                                        }
                                                    }
                                                    int t = t(x3cVar.G, x3cVar.q, x3cVar.t);
                                                    x3cVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = x3cVar.s;
                                                        int i32 = x3cVar.O;
                                                        if (i31 != i32 && (i6 = x3cVar.r) < i32) {
                                                            x3cVar.s = i6;
                                                        } else {
                                                            x3cVar.s = x3cVar.O;
                                                        }
                                                        x3cVar.N = x3cVar.r;
                                                        int i33 = x3cVar.L;
                                                        if (i33 > x3cVar.s) {
                                                            x3cVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (x3cVar.G > 0) {
                                                                int[] iArr8 = x3cVar.q;
                                                                int i34 = x3cVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                x3cVar.t = i34 + 1;
                                                            }
                                                            if (x3cVar.M <= x3cVar.g) {
                                                                x3cVar.x = 0;
                                                                x3cVar.a = 7;
                                                                int i35 = x3cVar.r;
                                                                i = (i35 - x3cVar.L) & i9;
                                                                i2 = x3cVar.M - x3cVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    x3cVar.x += i2;
                                                                    x3cVar.g -= i2;
                                                                    x3cVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = x3cVar.x;
                                                                        if (i3 >= x3cVar.M) {
                                                                            i4 = x3cVar.r;
                                                                            bArr[i4] = bArr[(i4 - x3cVar.L) & i9];
                                                                            x3cVar.g--;
                                                                            x3cVar.x = i3 + 1;
                                                                            x3cVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    x3cVar.b = 7;
                                                                    x3cVar.Y = x3cVar.Q;
                                                                    x3cVar.X = 0;
                                                                    x3cVar.a = 12;
                                                                    if (x3cVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        x3cVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (x3cVar.a != i5) {
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
                                        if (x3cVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (x3cVar.g > 0) {
                                            o3c.j(o3cVar);
                                            o3c.i(o3cVar, 8);
                                            x3cVar.g--;
                                        }
                                        x3cVar.a = 1;
                                        break;
                                    case 5:
                                        a(x3cVar);
                                        break;
                                    case 6:
                                        if (x3cVar.u) {
                                        }
                                        if (x3cVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = x3cVar.r;
                                        i = (i352 - x3cVar.L) & i9;
                                        i2 = x3cVar.M - x3cVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = x3cVar.x;
                                            if (i3 >= x3cVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        x3cVar.b = 7;
                                        x3cVar.Y = x3cVar.Q;
                                        x3cVar.X = 0;
                                        x3cVar.a = 12;
                                        if (x3cVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = x3cVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, x3cVar.N - i36);
                                        x3cVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = x3cVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = s3c.a[i37];
                                            int i39 = (x3cVar.L - x3cVar.s) - 1;
                                            int i40 = s3c.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < y3c.d.length) {
                                                int b2 = y3c.b(bArr, x3cVar.N, s3c.a(), i43, x3cVar.M, y3c.d[i42]);
                                                int i44 = x3cVar.N + b2;
                                                x3cVar.N = i44;
                                                x3cVar.r += b2;
                                                x3cVar.g -= b2;
                                                int i45 = x3cVar.Q;
                                                if (i44 >= i45) {
                                                    x3cVar.b = 8;
                                                    x3cVar.Y = i45;
                                                    x3cVar.X = 0;
                                                    x3cVar.a = 12;
                                                    break;
                                                } else {
                                                    x3cVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + x3cVar.a);
                                }
                            } else if (!u(x3cVar)) {
                                return;
                            } else {
                                int i46 = x3cVar.r;
                                int i47 = x3cVar.O;
                                if (i46 >= i47) {
                                    x3cVar.s = i47;
                                }
                                x3cVar.r &= i9;
                                x3cVar.a = x3cVar.b;
                            }
                        } else if (i10 == 10) {
                            if (x3cVar.g >= 0) {
                                o3c.g(o3cVar);
                                o3c.a(x3cVar.c, true);
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

    public static void s(x3c x3cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, x3cVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            x3cVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, o3c o3cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, o3cVar)) == null) {
            o3c.d(o3cVar);
            int r = r(iArr, i, o3cVar);
            return w3c.a[r] + o3c.i(o3cVar, w3c.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, o3c o3cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), o3cVar}) == null) {
            o3c.j(o3cVar);
            int[] iArr2 = new int[i];
            int i3 = o3c.i(o3cVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = o3c.i(o3cVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = o3c.i(o3cVar, i6) % i;
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
                            if (o3c.i(o3cVar, 1) == 1) {
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
                    t3c.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                o3c.d(o3cVar);
                long j = o3cVar.f;
                int i11 = o3cVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                o3cVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, o3cVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.z3c.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, o3c o3cVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, o3cVar) == null) {
            int[] iArr3 = new int[32];
            t3c.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    o3c.j(o3cVar);
                    o3c.d(o3cVar);
                    long j = o3cVar.f;
                    int i9 = o3cVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    o3cVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + o3c.i(o3cVar, i13) + 3;
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

    public static void p(x3c x3cVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, x3cVar) == null) {
            o3c o3cVar = x3cVar.c;
            for (int i = 0; i < 3; i++) {
                x3cVar.o[i] = h(o3cVar) + 1;
                x3cVar.n[i] = 268435456;
                int[] iArr2 = x3cVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, x3cVar.e, i2, o3cVar);
                    n(26, x3cVar.f, i2, o3cVar);
                    x3cVar.n[i] = m(x3cVar.f, i2, o3cVar);
                }
            }
            o3c.j(o3cVar);
            x3cVar.K = o3c.i(o3cVar, 2);
            int i3 = o3c.i(o3cVar, 4);
            int i4 = x3cVar.K;
            int i5 = (i3 << i4) + 16;
            x3cVar.I = i5;
            x3cVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            x3cVar.z = new byte[x3cVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = x3cVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    x3cVar.z[i7] = (byte) (o3c.i(o3cVar, 2) << 1);
                    i7++;
                }
                o3c.j(o3cVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            x3cVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, o3cVar);
            x3cVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (x3cVar.o[0] << 6)) {
                    break;
                } else if (x3cVar.A[i8] != (i8 >> 6)) {
                    x3cVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = x3cVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            x3cVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, o3cVar);
            u3c.b(x3cVar.k, 256, d2);
            u3c.b(x3cVar.l, 704, x3cVar.o[1]);
            u3c.b(x3cVar.m, i6, d3);
            u3c.a(x3cVar.k, o3cVar);
            u3c.a(x3cVar.l, o3cVar);
            u3c.a(x3cVar.m, o3cVar);
            x3cVar.B = 0;
            x3cVar.C = 0;
            int[] iArr4 = q3c.b;
            byte[] bArr3 = x3cVar.z;
            x3cVar.D = iArr4[bArr3[0]];
            x3cVar.E = iArr4[bArr3[0] + 1];
            x3cVar.v = 0;
            x3cVar.w = x3cVar.k.c[0];
            x3cVar.F = x3cVar.l.c[0];
            int[] iArr5 = x3cVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(x3c x3cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, x3cVar) == null) {
            o3c o3cVar = x3cVar.c;
            if (x3cVar.h) {
                x3cVar.b = 10;
                x3cVar.Y = x3cVar.r;
                x3cVar.X = 0;
                x3cVar.a = 12;
                return;
            }
            u3c u3cVar = x3cVar.k;
            u3cVar.b = null;
            u3cVar.c = null;
            u3c u3cVar2 = x3cVar.l;
            u3cVar2.b = null;
            u3cVar2.c = null;
            u3c u3cVar3 = x3cVar.m;
            u3cVar3.b = null;
            u3cVar3.c = null;
            o3c.j(o3cVar);
            g(o3cVar, x3cVar);
            if (x3cVar.g == 0 && !x3cVar.j) {
                return;
            }
            if (!x3cVar.i && !x3cVar.j) {
                x3cVar.a = 2;
            } else {
                o3c.g(o3cVar);
                if (x3cVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                x3cVar.a = i;
            }
            if (x3cVar.j) {
                return;
            }
            x3cVar.R += x3cVar.g;
            if (x3cVar.Q < x3cVar.P) {
                k(x3cVar);
            }
        }
    }

    public static int r(int[] iArr, int i, o3c o3cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, o3cVar)) == null) {
            long j = o3cVar.f;
            int i2 = o3cVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                o3cVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            o3cVar.g = i2 + (iArr[i7] >> 16) + 8;
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
