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
public final class r3b {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948072104, "Lcom/baidu/tieba/r3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948072104, "Lcom/baidu/tieba/r3b;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(x3b x3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, x3bVar) == null) {
            o3b o3bVar = x3bVar.c;
            byte[] bArr = x3bVar.d;
            int i = x3bVar.g;
            if (i <= 0) {
                o3b.k(o3bVar);
                x3bVar.a = 1;
                return;
            }
            int min = Math.min(x3bVar.Q - x3bVar.r, i);
            o3b.c(o3bVar, bArr, x3bVar.r, min);
            x3bVar.g -= min;
            int i2 = x3bVar.r + min;
            x3bVar.r = i2;
            int i3 = x3bVar.Q;
            if (i2 == i3) {
                x3bVar.b = 5;
                x3bVar.Y = i3;
                x3bVar.X = 0;
                x3bVar.a = 12;
                return;
            }
            o3b.k(o3bVar);
            x3bVar.a = 1;
        }
    }

    public static void k(x3b x3bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, x3bVar) == null) {
            int i2 = x3bVar.P;
            long j = x3bVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + x3bVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!x3bVar.h && i2 < 16384 && x3bVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = x3bVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = x3bVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = x3bVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = x3bVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(x3bVar.S, i, bArr, 0, i5);
                    x3bVar.r = i5;
                    x3bVar.T = i5;
                }
            }
            x3bVar.d = bArr;
            x3bVar.Q = i2;
        }
    }

    public static boolean u(x3b x3bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, x3bVar)) == null) {
            int i = x3bVar.T;
            if (i != 0) {
                x3bVar.X += i;
                x3bVar.T = 0;
            }
            int min = Math.min(x3bVar.V - x3bVar.W, x3bVar.Y - x3bVar.X);
            if (min != 0) {
                System.arraycopy(x3bVar.d, x3bVar.X, x3bVar.Z, x3bVar.U + x3bVar.W, min);
                x3bVar.W += min;
                x3bVar.X += min;
            }
            if (x3bVar.W >= x3bVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(x3b x3bVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, x3bVar, i) == null) {
            o3b o3bVar = x3bVar.c;
            int[] iArr = x3bVar.p;
            int i3 = i * 2;
            o3b.d(o3bVar);
            int i4 = i * 1080;
            int r = r(x3bVar.e, i4, o3bVar);
            x3bVar.n[i] = m(x3bVar.f, i4, o3bVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = x3bVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(x3b x3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, x3bVar) == null) {
            b(x3bVar, 1);
            x3bVar.F = x3bVar.l.c[x3bVar.p[3]];
        }
    }

    public static void e(x3b x3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, x3bVar) == null) {
            b(x3bVar, 2);
            x3bVar.C = x3bVar.p[5] << 2;
        }
    }

    public static int h(o3b o3bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, o3bVar)) == null) {
            if (o3b.i(o3bVar, 1) != 0) {
                int i = o3b.i(o3bVar, 3);
                if (i == 0) {
                    return 1;
                }
                return o3b.i(o3bVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, o3b o3bVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, o3bVar)) == null) {
            o3b.j(o3bVar);
            int h = h(o3bVar) + 1;
            if (h == 1) {
                z3b.a(bArr, 0, i);
                return h;
            }
            if (o3b.i(o3bVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = o3b.i(o3bVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, o3bVar);
            int i3 = 0;
            while (i3 < i) {
                o3b.j(o3bVar);
                o3b.d(o3bVar);
                int r = r(iArr, 0, o3bVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + o3b.i(o3bVar, r); i4 != 0; i4--) {
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
            if (o3b.i(o3bVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(x3b x3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, x3bVar) == null) {
            b(x3bVar, 0);
            int i = x3bVar.p[1];
            int i2 = i << 6;
            x3bVar.B = i2;
            int i3 = x3bVar.A[i2] & 255;
            x3bVar.v = i3;
            x3bVar.w = x3bVar.k.c[i3];
            byte b2 = x3bVar.z[i];
            int[] iArr = q3b.b;
            x3bVar.D = iArr[b2];
            x3bVar.E = iArr[b2 + 1];
        }
    }

    public static void g(o3b o3bVar, x3b x3bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, o3bVar, x3bVar) == null) {
            boolean z2 = true;
            if (o3b.i(o3bVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            x3bVar.h = z;
            x3bVar.g = 0;
            x3bVar.i = false;
            x3bVar.j = false;
            if (z && o3b.i(o3bVar, 1) != 0) {
                return;
            }
            int i = o3b.i(o3bVar, 2) + 4;
            if (i == 7) {
                x3bVar.j = true;
                if (o3b.i(o3bVar, 1) == 0) {
                    int i2 = o3b.i(o3bVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = o3b.i(o3bVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        x3bVar.g = (i4 << (i3 * 8)) | x3bVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = o3b.i(o3bVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    x3bVar.g = (i6 << (i5 * 4)) | x3bVar.g;
                }
            }
            x3bVar.g++;
            if (!x3bVar.h) {
                if (o3b.i(o3bVar, 1) != 1) {
                    z2 = false;
                }
                x3bVar.i = z2;
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
    public static void i(x3b x3bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, x3bVar) == null) {
            int i8 = x3bVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    o3b o3bVar = x3bVar.c;
                    int i9 = x3bVar.Q - 1;
                    byte[] bArr = x3bVar.d;
                    while (true) {
                        int i10 = x3bVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (x3bVar.g >= 0) {
                                            q(x3bVar);
                                            i9 = x3bVar.Q - 1;
                                            bArr = x3bVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(x3bVar);
                                        x3bVar.a = 3;
                                        if (x3bVar.g > 0) {
                                            x3bVar.a = 1;
                                            break;
                                        } else {
                                            o3b.j(o3bVar);
                                            if (x3bVar.n[1] == 0) {
                                                c(x3bVar);
                                            }
                                            int[] iArr = x3bVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            o3b.d(o3bVar);
                                            int r = r(x3bVar.l.b, x3bVar.F, o3bVar);
                                            int i12 = r >>> 6;
                                            x3bVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                x3bVar.G = -1;
                                            }
                                            int i13 = w3b.g[i12] + ((r >>> 3) & 7);
                                            int i14 = w3b.h[i12] + (r & 7);
                                            x3bVar.y = w3b.c[i13] + o3b.i(o3bVar, w3b.d[i13]);
                                            x3bVar.M = w3b.e[i14] + o3b.i(o3bVar, w3b.f[i14]);
                                            x3bVar.x = 0;
                                            x3bVar.a = 6;
                                            if (x3bVar.u) {
                                                int i15 = x3bVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (x3bVar.x < x3bVar.y) {
                                                        o3b.j(o3bVar);
                                                        if (x3bVar.n[0] == 0) {
                                                            f(x3bVar);
                                                        }
                                                        byte[] bArr2 = x3bVar.A;
                                                        int i18 = x3bVar.B;
                                                        int[] iArr2 = q3b.a;
                                                        int i19 = iArr2[x3bVar.D + i16];
                                                        int[] iArr3 = x3bVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        o3b.d(o3bVar);
                                                        u3b u3bVar = x3bVar.k;
                                                        int r2 = r(u3bVar.b, u3bVar.c[bArr2[i18 + (iArr2[x3bVar.E + i17] | i19)] & 255], o3bVar);
                                                        int i20 = x3bVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        x3bVar.x++;
                                                        x3bVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            x3bVar.b = 6;
                                                            x3bVar.Y = x3bVar.Q;
                                                            x3bVar.X = 0;
                                                            x3bVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (x3bVar.x < x3bVar.y) {
                                                        o3b.j(o3bVar);
                                                        if (x3bVar.n[0] == 0) {
                                                            f(x3bVar);
                                                        }
                                                        int[] iArr4 = x3bVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        o3b.d(o3bVar);
                                                        bArr[x3bVar.r] = (byte) r(x3bVar.k.b, x3bVar.w, o3bVar);
                                                        x3bVar.x++;
                                                        int i22 = x3bVar.r;
                                                        x3bVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            x3bVar.b = 6;
                                                            x3bVar.Y = x3bVar.Q;
                                                            x3bVar.X = 0;
                                                            x3bVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (x3bVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = x3bVar.g - x3bVar.y;
                                                x3bVar.g = i23;
                                                if (i23 <= 0) {
                                                    x3bVar.a = 3;
                                                    break;
                                                } else {
                                                    if (x3bVar.G < 0) {
                                                        o3b.j(o3bVar);
                                                        if (x3bVar.n[2] == 0) {
                                                            e(x3bVar);
                                                        }
                                                        int[] iArr5 = x3bVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        o3b.d(o3bVar);
                                                        u3b u3bVar2 = x3bVar.m;
                                                        int[] iArr6 = u3bVar2.b;
                                                        int[] iArr7 = u3bVar2.c;
                                                        byte[] bArr3 = x3bVar.H;
                                                        int i24 = x3bVar.C;
                                                        int i25 = x3bVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], o3bVar);
                                                        x3bVar.G = r3;
                                                        int i26 = x3bVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            x3bVar.G = i27;
                                                            int i28 = x3bVar.J & i27;
                                                            int i29 = i27 >>> x3bVar.K;
                                                            x3bVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            x3bVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + o3b.i(o3bVar, i30)) << x3bVar.K);
                                                        }
                                                    }
                                                    int t = t(x3bVar.G, x3bVar.q, x3bVar.t);
                                                    x3bVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = x3bVar.s;
                                                        int i32 = x3bVar.O;
                                                        if (i31 != i32 && (i6 = x3bVar.r) < i32) {
                                                            x3bVar.s = i6;
                                                        } else {
                                                            x3bVar.s = x3bVar.O;
                                                        }
                                                        x3bVar.N = x3bVar.r;
                                                        int i33 = x3bVar.L;
                                                        if (i33 > x3bVar.s) {
                                                            x3bVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (x3bVar.G > 0) {
                                                                int[] iArr8 = x3bVar.q;
                                                                int i34 = x3bVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                x3bVar.t = i34 + 1;
                                                            }
                                                            if (x3bVar.M <= x3bVar.g) {
                                                                x3bVar.x = 0;
                                                                x3bVar.a = 7;
                                                                int i35 = x3bVar.r;
                                                                i = (i35 - x3bVar.L) & i9;
                                                                i2 = x3bVar.M - x3bVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    x3bVar.x += i2;
                                                                    x3bVar.g -= i2;
                                                                    x3bVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = x3bVar.x;
                                                                        if (i3 >= x3bVar.M) {
                                                                            i4 = x3bVar.r;
                                                                            bArr[i4] = bArr[(i4 - x3bVar.L) & i9];
                                                                            x3bVar.g--;
                                                                            x3bVar.x = i3 + 1;
                                                                            x3bVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    x3bVar.b = 7;
                                                                    x3bVar.Y = x3bVar.Q;
                                                                    x3bVar.X = 0;
                                                                    x3bVar.a = 12;
                                                                    if (x3bVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        x3bVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (x3bVar.a != i5) {
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
                                        if (x3bVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (x3bVar.g > 0) {
                                            o3b.j(o3bVar);
                                            o3b.i(o3bVar, 8);
                                            x3bVar.g--;
                                        }
                                        x3bVar.a = 1;
                                        break;
                                    case 5:
                                        a(x3bVar);
                                        break;
                                    case 6:
                                        if (x3bVar.u) {
                                        }
                                        if (x3bVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = x3bVar.r;
                                        i = (i352 - x3bVar.L) & i9;
                                        i2 = x3bVar.M - x3bVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = x3bVar.x;
                                            if (i3 >= x3bVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        x3bVar.b = 7;
                                        x3bVar.Y = x3bVar.Q;
                                        x3bVar.X = 0;
                                        x3bVar.a = 12;
                                        if (x3bVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = x3bVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, x3bVar.N - i36);
                                        x3bVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = x3bVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = s3b.a[i37];
                                            int i39 = (x3bVar.L - x3bVar.s) - 1;
                                            int i40 = s3b.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < y3b.d.length) {
                                                int b2 = y3b.b(bArr, x3bVar.N, s3b.a(), i43, x3bVar.M, y3b.d[i42]);
                                                int i44 = x3bVar.N + b2;
                                                x3bVar.N = i44;
                                                x3bVar.r += b2;
                                                x3bVar.g -= b2;
                                                int i45 = x3bVar.Q;
                                                if (i44 >= i45) {
                                                    x3bVar.b = 8;
                                                    x3bVar.Y = i45;
                                                    x3bVar.X = 0;
                                                    x3bVar.a = 12;
                                                    break;
                                                } else {
                                                    x3bVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + x3bVar.a);
                                }
                            } else if (!u(x3bVar)) {
                                return;
                            } else {
                                int i46 = x3bVar.r;
                                int i47 = x3bVar.O;
                                if (i46 >= i47) {
                                    x3bVar.s = i47;
                                }
                                x3bVar.r &= i9;
                                x3bVar.a = x3bVar.b;
                            }
                        } else if (i10 == 10) {
                            if (x3bVar.g >= 0) {
                                o3b.g(o3bVar);
                                o3b.a(x3bVar.c, true);
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

    public static void s(x3b x3bVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, x3bVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            x3bVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, o3b o3bVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, o3bVar)) == null) {
            o3b.d(o3bVar);
            int r = r(iArr, i, o3bVar);
            return w3b.a[r] + o3b.i(o3bVar, w3b.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, o3b o3bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), o3bVar}) == null) {
            o3b.j(o3bVar);
            int[] iArr2 = new int[i];
            int i3 = o3b.i(o3bVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = o3b.i(o3bVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = o3b.i(o3bVar, i6) % i;
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
                            if (o3b.i(o3bVar, 1) == 1) {
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
                    t3b.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                o3b.d(o3bVar);
                long j = o3bVar.f;
                int i11 = o3bVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                o3bVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, o3bVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.z3b.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, o3b o3bVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, o3bVar) == null) {
            int[] iArr3 = new int[32];
            t3b.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    o3b.j(o3bVar);
                    o3b.d(o3bVar);
                    long j = o3bVar.f;
                    int i9 = o3bVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    o3bVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + o3b.i(o3bVar, i13) + 3;
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

    public static void p(x3b x3bVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, x3bVar) == null) {
            o3b o3bVar = x3bVar.c;
            for (int i = 0; i < 3; i++) {
                x3bVar.o[i] = h(o3bVar) + 1;
                x3bVar.n[i] = 268435456;
                int[] iArr2 = x3bVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, x3bVar.e, i2, o3bVar);
                    n(26, x3bVar.f, i2, o3bVar);
                    x3bVar.n[i] = m(x3bVar.f, i2, o3bVar);
                }
            }
            o3b.j(o3bVar);
            x3bVar.K = o3b.i(o3bVar, 2);
            int i3 = o3b.i(o3bVar, 4);
            int i4 = x3bVar.K;
            int i5 = (i3 << i4) + 16;
            x3bVar.I = i5;
            x3bVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            x3bVar.z = new byte[x3bVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = x3bVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    x3bVar.z[i7] = (byte) (o3b.i(o3bVar, 2) << 1);
                    i7++;
                }
                o3b.j(o3bVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            x3bVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, o3bVar);
            x3bVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (x3bVar.o[0] << 6)) {
                    break;
                } else if (x3bVar.A[i8] != (i8 >> 6)) {
                    x3bVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = x3bVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            x3bVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, o3bVar);
            u3b.b(x3bVar.k, 256, d2);
            u3b.b(x3bVar.l, 704, x3bVar.o[1]);
            u3b.b(x3bVar.m, i6, d3);
            u3b.a(x3bVar.k, o3bVar);
            u3b.a(x3bVar.l, o3bVar);
            u3b.a(x3bVar.m, o3bVar);
            x3bVar.B = 0;
            x3bVar.C = 0;
            int[] iArr4 = q3b.b;
            byte[] bArr3 = x3bVar.z;
            x3bVar.D = iArr4[bArr3[0]];
            x3bVar.E = iArr4[bArr3[0] + 1];
            x3bVar.v = 0;
            x3bVar.w = x3bVar.k.c[0];
            x3bVar.F = x3bVar.l.c[0];
            int[] iArr5 = x3bVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(x3b x3bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, x3bVar) == null) {
            o3b o3bVar = x3bVar.c;
            if (x3bVar.h) {
                x3bVar.b = 10;
                x3bVar.Y = x3bVar.r;
                x3bVar.X = 0;
                x3bVar.a = 12;
                return;
            }
            u3b u3bVar = x3bVar.k;
            u3bVar.b = null;
            u3bVar.c = null;
            u3b u3bVar2 = x3bVar.l;
            u3bVar2.b = null;
            u3bVar2.c = null;
            u3b u3bVar3 = x3bVar.m;
            u3bVar3.b = null;
            u3bVar3.c = null;
            o3b.j(o3bVar);
            g(o3bVar, x3bVar);
            if (x3bVar.g == 0 && !x3bVar.j) {
                return;
            }
            if (!x3bVar.i && !x3bVar.j) {
                x3bVar.a = 2;
            } else {
                o3b.g(o3bVar);
                if (x3bVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                x3bVar.a = i;
            }
            if (x3bVar.j) {
                return;
            }
            x3bVar.R += x3bVar.g;
            if (x3bVar.Q < x3bVar.P) {
                k(x3bVar);
            }
        }
    }

    public static int r(int[] iArr, int i, o3b o3bVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, o3bVar)) == null) {
            long j = o3bVar.f;
            int i2 = o3bVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                o3bVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            o3bVar.g = i2 + (iArr[i7] >> 16) + 8;
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
