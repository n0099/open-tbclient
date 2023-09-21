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
public final class u9c {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948167274, "Lcom/baidu/tieba/u9c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948167274, "Lcom/baidu/tieba/u9c;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(aac aacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, aacVar) == null) {
            r9c r9cVar = aacVar.c;
            byte[] bArr = aacVar.d;
            int i = aacVar.g;
            if (i <= 0) {
                r9c.k(r9cVar);
                aacVar.a = 1;
                return;
            }
            int min = Math.min(aacVar.Q - aacVar.r, i);
            r9c.c(r9cVar, bArr, aacVar.r, min);
            aacVar.g -= min;
            int i2 = aacVar.r + min;
            aacVar.r = i2;
            int i3 = aacVar.Q;
            if (i2 == i3) {
                aacVar.b = 5;
                aacVar.Y = i3;
                aacVar.X = 0;
                aacVar.a = 12;
                return;
            }
            r9c.k(r9cVar);
            aacVar.a = 1;
        }
    }

    public static void k(aac aacVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aacVar) == null) {
            int i2 = aacVar.P;
            long j = aacVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + aacVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!aacVar.h && i2 < 16384 && aacVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = aacVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = aacVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = aacVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = aacVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(aacVar.S, i, bArr, 0, i5);
                    aacVar.r = i5;
                    aacVar.f1088T = i5;
                }
            }
            aacVar.d = bArr;
            aacVar.Q = i2;
        }
    }

    public static boolean u(aac aacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, aacVar)) == null) {
            int i = aacVar.f1088T;
            if (i != 0) {
                aacVar.X += i;
                aacVar.f1088T = 0;
            }
            int min = Math.min(aacVar.V - aacVar.W, aacVar.Y - aacVar.X);
            if (min != 0) {
                System.arraycopy(aacVar.d, aacVar.X, aacVar.Z, aacVar.U + aacVar.W, min);
                aacVar.W += min;
                aacVar.X += min;
            }
            if (aacVar.W >= aacVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(aac aacVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, aacVar, i) == null) {
            r9c r9cVar = aacVar.c;
            int[] iArr = aacVar.p;
            int i3 = i * 2;
            r9c.d(r9cVar);
            int i4 = i * 1080;
            int r = r(aacVar.e, i4, r9cVar);
            aacVar.n[i] = m(aacVar.f, i4, r9cVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = aacVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(aac aacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aacVar) == null) {
            b(aacVar, 1);
            aacVar.F = aacVar.l.c[aacVar.p[3]];
        }
    }

    public static void e(aac aacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, aacVar) == null) {
            b(aacVar, 2);
            aacVar.C = aacVar.p[5] << 2;
        }
    }

    public static int h(r9c r9cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, r9cVar)) == null) {
            if (r9c.i(r9cVar, 1) != 0) {
                int i = r9c.i(r9cVar, 3);
                if (i == 0) {
                    return 1;
                }
                return r9c.i(r9cVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, r9c r9cVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, r9cVar)) == null) {
            r9c.j(r9cVar);
            int h = h(r9cVar) + 1;
            if (h == 1) {
                cac.a(bArr, 0, i);
                return h;
            }
            if (r9c.i(r9cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = r9c.i(r9cVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, r9cVar);
            int i3 = 0;
            while (i3 < i) {
                r9c.j(r9cVar);
                r9c.d(r9cVar);
                int r = r(iArr, 0, r9cVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + r9c.i(r9cVar, r); i4 != 0; i4--) {
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
            if (r9c.i(r9cVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(aac aacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, aacVar) == null) {
            b(aacVar, 0);
            int i = aacVar.p[1];
            int i2 = i << 6;
            aacVar.B = i2;
            int i3 = aacVar.A[i2] & 255;
            aacVar.v = i3;
            aacVar.w = aacVar.k.c[i3];
            byte b2 = aacVar.z[i];
            int[] iArr = t9c.b;
            aacVar.D = iArr[b2];
            aacVar.E = iArr[b2 + 1];
        }
    }

    public static void g(r9c r9cVar, aac aacVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, r9cVar, aacVar) == null) {
            boolean z2 = true;
            if (r9c.i(r9cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            aacVar.h = z;
            aacVar.g = 0;
            aacVar.i = false;
            aacVar.j = false;
            if (z && r9c.i(r9cVar, 1) != 0) {
                return;
            }
            int i = r9c.i(r9cVar, 2) + 4;
            if (i == 7) {
                aacVar.j = true;
                if (r9c.i(r9cVar, 1) == 0) {
                    int i2 = r9c.i(r9cVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = r9c.i(r9cVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        aacVar.g = (i4 << (i3 * 8)) | aacVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = r9c.i(r9cVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    aacVar.g = (i6 << (i5 * 4)) | aacVar.g;
                }
            }
            aacVar.g++;
            if (!aacVar.h) {
                if (r9c.i(r9cVar, 1) != 1) {
                    z2 = false;
                }
                aacVar.i = z2;
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
    public static void i(aac aacVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, aacVar) == null) {
            int i8 = aacVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    r9c r9cVar = aacVar.c;
                    int i9 = aacVar.Q - 1;
                    byte[] bArr = aacVar.d;
                    while (true) {
                        int i10 = aacVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (aacVar.g >= 0) {
                                            q(aacVar);
                                            i9 = aacVar.Q - 1;
                                            bArr = aacVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(aacVar);
                                        aacVar.a = 3;
                                        if (aacVar.g > 0) {
                                            aacVar.a = 1;
                                            break;
                                        } else {
                                            r9c.j(r9cVar);
                                            if (aacVar.n[1] == 0) {
                                                c(aacVar);
                                            }
                                            int[] iArr = aacVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            r9c.d(r9cVar);
                                            int r = r(aacVar.l.b, aacVar.F, r9cVar);
                                            int i12 = r >>> 6;
                                            aacVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                aacVar.G = -1;
                                            }
                                            int i13 = z9c.g[i12] + ((r >>> 3) & 7);
                                            int i14 = z9c.h[i12] + (r & 7);
                                            aacVar.y = z9c.c[i13] + r9c.i(r9cVar, z9c.d[i13]);
                                            aacVar.M = z9c.e[i14] + r9c.i(r9cVar, z9c.f[i14]);
                                            aacVar.x = 0;
                                            aacVar.a = 6;
                                            if (aacVar.u) {
                                                int i15 = aacVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (aacVar.x < aacVar.y) {
                                                        r9c.j(r9cVar);
                                                        if (aacVar.n[0] == 0) {
                                                            f(aacVar);
                                                        }
                                                        byte[] bArr2 = aacVar.A;
                                                        int i18 = aacVar.B;
                                                        int[] iArr2 = t9c.a;
                                                        int i19 = iArr2[aacVar.D + i16];
                                                        int[] iArr3 = aacVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        r9c.d(r9cVar);
                                                        x9c x9cVar = aacVar.k;
                                                        int r2 = r(x9cVar.b, x9cVar.c[bArr2[i18 + (iArr2[aacVar.E + i17] | i19)] & 255], r9cVar);
                                                        int i20 = aacVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        aacVar.x++;
                                                        aacVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            aacVar.b = 6;
                                                            aacVar.Y = aacVar.Q;
                                                            aacVar.X = 0;
                                                            aacVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (aacVar.x < aacVar.y) {
                                                        r9c.j(r9cVar);
                                                        if (aacVar.n[0] == 0) {
                                                            f(aacVar);
                                                        }
                                                        int[] iArr4 = aacVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        r9c.d(r9cVar);
                                                        bArr[aacVar.r] = (byte) r(aacVar.k.b, aacVar.w, r9cVar);
                                                        aacVar.x++;
                                                        int i22 = aacVar.r;
                                                        aacVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            aacVar.b = 6;
                                                            aacVar.Y = aacVar.Q;
                                                            aacVar.X = 0;
                                                            aacVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (aacVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = aacVar.g - aacVar.y;
                                                aacVar.g = i23;
                                                if (i23 <= 0) {
                                                    aacVar.a = 3;
                                                    break;
                                                } else {
                                                    if (aacVar.G < 0) {
                                                        r9c.j(r9cVar);
                                                        if (aacVar.n[2] == 0) {
                                                            e(aacVar);
                                                        }
                                                        int[] iArr5 = aacVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        r9c.d(r9cVar);
                                                        x9c x9cVar2 = aacVar.m;
                                                        int[] iArr6 = x9cVar2.b;
                                                        int[] iArr7 = x9cVar2.c;
                                                        byte[] bArr3 = aacVar.H;
                                                        int i24 = aacVar.C;
                                                        int i25 = aacVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], r9cVar);
                                                        aacVar.G = r3;
                                                        int i26 = aacVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            aacVar.G = i27;
                                                            int i28 = aacVar.J & i27;
                                                            int i29 = i27 >>> aacVar.K;
                                                            aacVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            aacVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + r9c.i(r9cVar, i30)) << aacVar.K);
                                                        }
                                                    }
                                                    int t = t(aacVar.G, aacVar.q, aacVar.t);
                                                    aacVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = aacVar.s;
                                                        int i32 = aacVar.O;
                                                        if (i31 != i32 && (i6 = aacVar.r) < i32) {
                                                            aacVar.s = i6;
                                                        } else {
                                                            aacVar.s = aacVar.O;
                                                        }
                                                        aacVar.N = aacVar.r;
                                                        int i33 = aacVar.L;
                                                        if (i33 > aacVar.s) {
                                                            aacVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (aacVar.G > 0) {
                                                                int[] iArr8 = aacVar.q;
                                                                int i34 = aacVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                aacVar.t = i34 + 1;
                                                            }
                                                            if (aacVar.M <= aacVar.g) {
                                                                aacVar.x = 0;
                                                                aacVar.a = 7;
                                                                int i35 = aacVar.r;
                                                                i = (i35 - aacVar.L) & i9;
                                                                i2 = aacVar.M - aacVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    aacVar.x += i2;
                                                                    aacVar.g -= i2;
                                                                    aacVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = aacVar.x;
                                                                        if (i3 >= aacVar.M) {
                                                                            i4 = aacVar.r;
                                                                            bArr[i4] = bArr[(i4 - aacVar.L) & i9];
                                                                            aacVar.g--;
                                                                            aacVar.x = i3 + 1;
                                                                            aacVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    aacVar.b = 7;
                                                                    aacVar.Y = aacVar.Q;
                                                                    aacVar.X = 0;
                                                                    aacVar.a = 12;
                                                                    if (aacVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        aacVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (aacVar.a != i5) {
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
                                        if (aacVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (aacVar.g > 0) {
                                            r9c.j(r9cVar);
                                            r9c.i(r9cVar, 8);
                                            aacVar.g--;
                                        }
                                        aacVar.a = 1;
                                        break;
                                    case 5:
                                        a(aacVar);
                                        break;
                                    case 6:
                                        if (aacVar.u) {
                                        }
                                        if (aacVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = aacVar.r;
                                        i = (i352 - aacVar.L) & i9;
                                        i2 = aacVar.M - aacVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = aacVar.x;
                                            if (i3 >= aacVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        aacVar.b = 7;
                                        aacVar.Y = aacVar.Q;
                                        aacVar.X = 0;
                                        aacVar.a = 12;
                                        if (aacVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = aacVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, aacVar.N - i36);
                                        aacVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = aacVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = v9c.a[i37];
                                            int i39 = (aacVar.L - aacVar.s) - 1;
                                            int i40 = v9c.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < bac.d.length) {
                                                int b2 = bac.b(bArr, aacVar.N, v9c.a(), i43, aacVar.M, bac.d[i42]);
                                                int i44 = aacVar.N + b2;
                                                aacVar.N = i44;
                                                aacVar.r += b2;
                                                aacVar.g -= b2;
                                                int i45 = aacVar.Q;
                                                if (i44 >= i45) {
                                                    aacVar.b = 8;
                                                    aacVar.Y = i45;
                                                    aacVar.X = 0;
                                                    aacVar.a = 12;
                                                    break;
                                                } else {
                                                    aacVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + aacVar.a);
                                }
                            } else if (!u(aacVar)) {
                                return;
                            } else {
                                int i46 = aacVar.r;
                                int i47 = aacVar.O;
                                if (i46 >= i47) {
                                    aacVar.s = i47;
                                }
                                aacVar.r &= i9;
                                aacVar.a = aacVar.b;
                            }
                        } else if (i10 == 10) {
                            if (aacVar.g >= 0) {
                                r9c.g(r9cVar);
                                r9c.a(aacVar.c, true);
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

    public static void s(aac aacVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aacVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            aacVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, r9c r9cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, r9cVar)) == null) {
            r9c.d(r9cVar);
            int r = r(iArr, i, r9cVar);
            return z9c.a[r] + r9c.i(r9cVar, z9c.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, r9c r9cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), r9cVar}) == null) {
            r9c.j(r9cVar);
            int[] iArr2 = new int[i];
            int i3 = r9c.i(r9cVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = r9c.i(r9cVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = r9c.i(r9cVar, i6) % i;
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
                            if (r9c.i(r9cVar, 1) == 1) {
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
                    w9c.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                r9c.d(r9cVar);
                long j = r9cVar.f;
                int i11 = r9cVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                r9cVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, r9cVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.cac.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, r9c r9cVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, r9cVar) == null) {
            int[] iArr3 = new int[32];
            w9c.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    r9c.j(r9cVar);
                    r9c.d(r9cVar);
                    long j = r9cVar.f;
                    int i9 = r9cVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    r9cVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + r9c.i(r9cVar, i13) + 3;
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

    public static void p(aac aacVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, aacVar) == null) {
            r9c r9cVar = aacVar.c;
            for (int i = 0; i < 3; i++) {
                aacVar.o[i] = h(r9cVar) + 1;
                aacVar.n[i] = 268435456;
                int[] iArr2 = aacVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, aacVar.e, i2, r9cVar);
                    n(26, aacVar.f, i2, r9cVar);
                    aacVar.n[i] = m(aacVar.f, i2, r9cVar);
                }
            }
            r9c.j(r9cVar);
            aacVar.K = r9c.i(r9cVar, 2);
            int i3 = r9c.i(r9cVar, 4);
            int i4 = aacVar.K;
            int i5 = (i3 << i4) + 16;
            aacVar.I = i5;
            aacVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            aacVar.z = new byte[aacVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = aacVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    aacVar.z[i7] = (byte) (r9c.i(r9cVar, 2) << 1);
                    i7++;
                }
                r9c.j(r9cVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            aacVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, r9cVar);
            aacVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (aacVar.o[0] << 6)) {
                    break;
                } else if (aacVar.A[i8] != (i8 >> 6)) {
                    aacVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = aacVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            aacVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, r9cVar);
            x9c.b(aacVar.k, 256, d2);
            x9c.b(aacVar.l, 704, aacVar.o[1]);
            x9c.b(aacVar.m, i6, d3);
            x9c.a(aacVar.k, r9cVar);
            x9c.a(aacVar.l, r9cVar);
            x9c.a(aacVar.m, r9cVar);
            aacVar.B = 0;
            aacVar.C = 0;
            int[] iArr4 = t9c.b;
            byte[] bArr3 = aacVar.z;
            aacVar.D = iArr4[bArr3[0]];
            aacVar.E = iArr4[bArr3[0] + 1];
            aacVar.v = 0;
            aacVar.w = aacVar.k.c[0];
            aacVar.F = aacVar.l.c[0];
            int[] iArr5 = aacVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(aac aacVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, aacVar) == null) {
            r9c r9cVar = aacVar.c;
            if (aacVar.h) {
                aacVar.b = 10;
                aacVar.Y = aacVar.r;
                aacVar.X = 0;
                aacVar.a = 12;
                return;
            }
            x9c x9cVar = aacVar.k;
            x9cVar.b = null;
            x9cVar.c = null;
            x9c x9cVar2 = aacVar.l;
            x9cVar2.b = null;
            x9cVar2.c = null;
            x9c x9cVar3 = aacVar.m;
            x9cVar3.b = null;
            x9cVar3.c = null;
            r9c.j(r9cVar);
            g(r9cVar, aacVar);
            if (aacVar.g == 0 && !aacVar.j) {
                return;
            }
            if (!aacVar.i && !aacVar.j) {
                aacVar.a = 2;
            } else {
                r9c.g(r9cVar);
                if (aacVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                aacVar.a = i;
            }
            if (aacVar.j) {
                return;
            }
            aacVar.R += aacVar.g;
            if (aacVar.Q < aacVar.P) {
                k(aacVar);
            }
        }
    }

    public static int r(int[] iArr, int i, r9c r9cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, r9cVar)) == null) {
            long j = r9cVar.f;
            int i2 = r9cVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                r9cVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            r9cVar.g = i2 + (iArr[i7] >> 16) + 8;
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
