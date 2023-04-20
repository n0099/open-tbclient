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
public final class vza {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948259468, "Lcom/baidu/tieba/vza;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948259468, "Lcom/baidu/tieba/vza;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(b0b b0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, b0bVar) == null) {
            sza szaVar = b0bVar.c;
            byte[] bArr = b0bVar.d;
            int i = b0bVar.g;
            if (i <= 0) {
                sza.k(szaVar);
                b0bVar.a = 1;
                return;
            }
            int min = Math.min(b0bVar.Q - b0bVar.r, i);
            sza.c(szaVar, bArr, b0bVar.r, min);
            b0bVar.g -= min;
            int i2 = b0bVar.r + min;
            b0bVar.r = i2;
            int i3 = b0bVar.Q;
            if (i2 == i3) {
                b0bVar.b = 5;
                b0bVar.Y = i3;
                b0bVar.X = 0;
                b0bVar.a = 12;
                return;
            }
            sza.k(szaVar);
            b0bVar.a = 1;
        }
    }

    public static void k(b0b b0bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, b0bVar) == null) {
            int i2 = b0bVar.P;
            long j = b0bVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + b0bVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!b0bVar.h && i2 < 16384 && b0bVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = b0bVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = b0bVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = b0bVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = b0bVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(b0bVar.S, i, bArr, 0, i5);
                    b0bVar.r = i5;
                    b0bVar.T = i5;
                }
            }
            b0bVar.d = bArr;
            b0bVar.Q = i2;
        }
    }

    public static boolean u(b0b b0bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, b0bVar)) == null) {
            int i = b0bVar.T;
            if (i != 0) {
                b0bVar.X += i;
                b0bVar.T = 0;
            }
            int min = Math.min(b0bVar.V - b0bVar.W, b0bVar.Y - b0bVar.X);
            if (min != 0) {
                System.arraycopy(b0bVar.d, b0bVar.X, b0bVar.Z, b0bVar.U + b0bVar.W, min);
                b0bVar.W += min;
                b0bVar.X += min;
            }
            if (b0bVar.W >= b0bVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(b0b b0bVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, b0bVar, i) == null) {
            sza szaVar = b0bVar.c;
            int[] iArr = b0bVar.p;
            int i3 = i * 2;
            sza.d(szaVar);
            int i4 = i * 1080;
            int r = r(b0bVar.e, i4, szaVar);
            b0bVar.n[i] = m(b0bVar.f, i4, szaVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = b0bVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(b0b b0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, b0bVar) == null) {
            b(b0bVar, 1);
            b0bVar.F = b0bVar.l.c[b0bVar.p[3]];
        }
    }

    public static void e(b0b b0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, b0bVar) == null) {
            b(b0bVar, 2);
            b0bVar.C = b0bVar.p[5] << 2;
        }
    }

    public static int h(sza szaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, szaVar)) == null) {
            if (sza.i(szaVar, 1) != 0) {
                int i = sza.i(szaVar, 3);
                if (i == 0) {
                    return 1;
                }
                return sza.i(szaVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, sza szaVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, szaVar)) == null) {
            sza.j(szaVar);
            int h = h(szaVar) + 1;
            if (h == 1) {
                d0b.a(bArr, 0, i);
                return h;
            }
            if (sza.i(szaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = sza.i(szaVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, szaVar);
            int i3 = 0;
            while (i3 < i) {
                sza.j(szaVar);
                sza.d(szaVar);
                int r = r(iArr, 0, szaVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + sza.i(szaVar, r); i4 != 0; i4--) {
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
            if (sza.i(szaVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(b0b b0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, b0bVar) == null) {
            b(b0bVar, 0);
            int i = b0bVar.p[1];
            int i2 = i << 6;
            b0bVar.B = i2;
            int i3 = b0bVar.A[i2] & 255;
            b0bVar.v = i3;
            b0bVar.w = b0bVar.k.c[i3];
            byte b2 = b0bVar.z[i];
            int[] iArr = uza.b;
            b0bVar.D = iArr[b2];
            b0bVar.E = iArr[b2 + 1];
        }
    }

    public static void g(sza szaVar, b0b b0bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, szaVar, b0bVar) == null) {
            boolean z2 = true;
            if (sza.i(szaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            b0bVar.h = z;
            b0bVar.g = 0;
            b0bVar.i = false;
            b0bVar.j = false;
            if (z && sza.i(szaVar, 1) != 0) {
                return;
            }
            int i = sza.i(szaVar, 2) + 4;
            if (i == 7) {
                b0bVar.j = true;
                if (sza.i(szaVar, 1) == 0) {
                    int i2 = sza.i(szaVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = sza.i(szaVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        b0bVar.g = (i4 << (i3 * 8)) | b0bVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = sza.i(szaVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    b0bVar.g = (i6 << (i5 * 4)) | b0bVar.g;
                }
            }
            b0bVar.g++;
            if (!b0bVar.h) {
                if (sza.i(szaVar, 1) != 1) {
                    z2 = false;
                }
                b0bVar.i = z2;
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
    public static void i(b0b b0bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, b0bVar) == null) {
            int i8 = b0bVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    sza szaVar = b0bVar.c;
                    int i9 = b0bVar.Q - 1;
                    byte[] bArr = b0bVar.d;
                    while (true) {
                        int i10 = b0bVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (b0bVar.g >= 0) {
                                            q(b0bVar);
                                            i9 = b0bVar.Q - 1;
                                            bArr = b0bVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(b0bVar);
                                        b0bVar.a = 3;
                                        if (b0bVar.g > 0) {
                                            b0bVar.a = 1;
                                            break;
                                        } else {
                                            sza.j(szaVar);
                                            if (b0bVar.n[1] == 0) {
                                                c(b0bVar);
                                            }
                                            int[] iArr = b0bVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            sza.d(szaVar);
                                            int r = r(b0bVar.l.b, b0bVar.F, szaVar);
                                            int i12 = r >>> 6;
                                            b0bVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                b0bVar.G = -1;
                                            }
                                            int i13 = a0b.g[i12] + ((r >>> 3) & 7);
                                            int i14 = a0b.h[i12] + (r & 7);
                                            b0bVar.y = a0b.c[i13] + sza.i(szaVar, a0b.d[i13]);
                                            b0bVar.M = a0b.e[i14] + sza.i(szaVar, a0b.f[i14]);
                                            b0bVar.x = 0;
                                            b0bVar.a = 6;
                                            if (b0bVar.u) {
                                                int i15 = b0bVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (b0bVar.x < b0bVar.y) {
                                                        sza.j(szaVar);
                                                        if (b0bVar.n[0] == 0) {
                                                            f(b0bVar);
                                                        }
                                                        byte[] bArr2 = b0bVar.A;
                                                        int i18 = b0bVar.B;
                                                        int[] iArr2 = uza.a;
                                                        int i19 = iArr2[b0bVar.D + i16];
                                                        int[] iArr3 = b0bVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        sza.d(szaVar);
                                                        yza yzaVar = b0bVar.k;
                                                        int r2 = r(yzaVar.b, yzaVar.c[bArr2[i18 + (iArr2[b0bVar.E + i17] | i19)] & 255], szaVar);
                                                        int i20 = b0bVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        b0bVar.x++;
                                                        b0bVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            b0bVar.b = 6;
                                                            b0bVar.Y = b0bVar.Q;
                                                            b0bVar.X = 0;
                                                            b0bVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (b0bVar.x < b0bVar.y) {
                                                        sza.j(szaVar);
                                                        if (b0bVar.n[0] == 0) {
                                                            f(b0bVar);
                                                        }
                                                        int[] iArr4 = b0bVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        sza.d(szaVar);
                                                        bArr[b0bVar.r] = (byte) r(b0bVar.k.b, b0bVar.w, szaVar);
                                                        b0bVar.x++;
                                                        int i22 = b0bVar.r;
                                                        b0bVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            b0bVar.b = 6;
                                                            b0bVar.Y = b0bVar.Q;
                                                            b0bVar.X = 0;
                                                            b0bVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (b0bVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = b0bVar.g - b0bVar.y;
                                                b0bVar.g = i23;
                                                if (i23 <= 0) {
                                                    b0bVar.a = 3;
                                                    break;
                                                } else {
                                                    if (b0bVar.G < 0) {
                                                        sza.j(szaVar);
                                                        if (b0bVar.n[2] == 0) {
                                                            e(b0bVar);
                                                        }
                                                        int[] iArr5 = b0bVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        sza.d(szaVar);
                                                        yza yzaVar2 = b0bVar.m;
                                                        int[] iArr6 = yzaVar2.b;
                                                        int[] iArr7 = yzaVar2.c;
                                                        byte[] bArr3 = b0bVar.H;
                                                        int i24 = b0bVar.C;
                                                        int i25 = b0bVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], szaVar);
                                                        b0bVar.G = r3;
                                                        int i26 = b0bVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            b0bVar.G = i27;
                                                            int i28 = b0bVar.J & i27;
                                                            int i29 = i27 >>> b0bVar.K;
                                                            b0bVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            b0bVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + sza.i(szaVar, i30)) << b0bVar.K);
                                                        }
                                                    }
                                                    int t = t(b0bVar.G, b0bVar.q, b0bVar.t);
                                                    b0bVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = b0bVar.s;
                                                        int i32 = b0bVar.O;
                                                        if (i31 != i32 && (i6 = b0bVar.r) < i32) {
                                                            b0bVar.s = i6;
                                                        } else {
                                                            b0bVar.s = b0bVar.O;
                                                        }
                                                        b0bVar.N = b0bVar.r;
                                                        int i33 = b0bVar.L;
                                                        if (i33 > b0bVar.s) {
                                                            b0bVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (b0bVar.G > 0) {
                                                                int[] iArr8 = b0bVar.q;
                                                                int i34 = b0bVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                b0bVar.t = i34 + 1;
                                                            }
                                                            if (b0bVar.M <= b0bVar.g) {
                                                                b0bVar.x = 0;
                                                                b0bVar.a = 7;
                                                                int i35 = b0bVar.r;
                                                                i = (i35 - b0bVar.L) & i9;
                                                                i2 = b0bVar.M - b0bVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    b0bVar.x += i2;
                                                                    b0bVar.g -= i2;
                                                                    b0bVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = b0bVar.x;
                                                                        if (i3 >= b0bVar.M) {
                                                                            i4 = b0bVar.r;
                                                                            bArr[i4] = bArr[(i4 - b0bVar.L) & i9];
                                                                            b0bVar.g--;
                                                                            b0bVar.x = i3 + 1;
                                                                            b0bVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    b0bVar.b = 7;
                                                                    b0bVar.Y = b0bVar.Q;
                                                                    b0bVar.X = 0;
                                                                    b0bVar.a = 12;
                                                                    if (b0bVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        b0bVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (b0bVar.a != i5) {
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
                                        if (b0bVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (b0bVar.g > 0) {
                                            sza.j(szaVar);
                                            sza.i(szaVar, 8);
                                            b0bVar.g--;
                                        }
                                        b0bVar.a = 1;
                                        break;
                                    case 5:
                                        a(b0bVar);
                                        break;
                                    case 6:
                                        if (b0bVar.u) {
                                        }
                                        if (b0bVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = b0bVar.r;
                                        i = (i352 - b0bVar.L) & i9;
                                        i2 = b0bVar.M - b0bVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = b0bVar.x;
                                            if (i3 >= b0bVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        b0bVar.b = 7;
                                        b0bVar.Y = b0bVar.Q;
                                        b0bVar.X = 0;
                                        b0bVar.a = 12;
                                        if (b0bVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = b0bVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, b0bVar.N - i36);
                                        b0bVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = b0bVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = wza.a[i37];
                                            int i39 = (b0bVar.L - b0bVar.s) - 1;
                                            int i40 = wza.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < c0b.d.length) {
                                                int b2 = c0b.b(bArr, b0bVar.N, wza.a(), i43, b0bVar.M, c0b.d[i42]);
                                                int i44 = b0bVar.N + b2;
                                                b0bVar.N = i44;
                                                b0bVar.r += b2;
                                                b0bVar.g -= b2;
                                                int i45 = b0bVar.Q;
                                                if (i44 >= i45) {
                                                    b0bVar.b = 8;
                                                    b0bVar.Y = i45;
                                                    b0bVar.X = 0;
                                                    b0bVar.a = 12;
                                                    break;
                                                } else {
                                                    b0bVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + b0bVar.a);
                                }
                            } else if (!u(b0bVar)) {
                                return;
                            } else {
                                int i46 = b0bVar.r;
                                int i47 = b0bVar.O;
                                if (i46 >= i47) {
                                    b0bVar.s = i47;
                                }
                                b0bVar.r &= i9;
                                b0bVar.a = b0bVar.b;
                            }
                        } else if (i10 == 10) {
                            if (b0bVar.g >= 0) {
                                sza.g(szaVar);
                                sza.a(b0bVar.c, true);
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

    public static void s(b0b b0bVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, b0bVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            b0bVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, sza szaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, szaVar)) == null) {
            sza.d(szaVar);
            int r = r(iArr, i, szaVar);
            return a0b.a[r] + sza.i(szaVar, a0b.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, sza szaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), szaVar}) == null) {
            sza.j(szaVar);
            int[] iArr2 = new int[i];
            int i3 = sza.i(szaVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = sza.i(szaVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = sza.i(szaVar, i6) % i;
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
                            if (sza.i(szaVar, 1) == 1) {
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
                    xza.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                sza.d(szaVar);
                long j = szaVar.f;
                int i11 = szaVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                szaVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, szaVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.d0b.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, sza szaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, szaVar) == null) {
            int[] iArr3 = new int[32];
            xza.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    sza.j(szaVar);
                    sza.d(szaVar);
                    long j = szaVar.f;
                    int i9 = szaVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    szaVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + sza.i(szaVar, i13) + 3;
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

    public static void p(b0b b0bVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, b0bVar) == null) {
            sza szaVar = b0bVar.c;
            for (int i = 0; i < 3; i++) {
                b0bVar.o[i] = h(szaVar) + 1;
                b0bVar.n[i] = 268435456;
                int[] iArr2 = b0bVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, b0bVar.e, i2, szaVar);
                    n(26, b0bVar.f, i2, szaVar);
                    b0bVar.n[i] = m(b0bVar.f, i2, szaVar);
                }
            }
            sza.j(szaVar);
            b0bVar.K = sza.i(szaVar, 2);
            int i3 = sza.i(szaVar, 4);
            int i4 = b0bVar.K;
            int i5 = (i3 << i4) + 16;
            b0bVar.I = i5;
            b0bVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            b0bVar.z = new byte[b0bVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = b0bVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    b0bVar.z[i7] = (byte) (sza.i(szaVar, 2) << 1);
                    i7++;
                }
                sza.j(szaVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            b0bVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, szaVar);
            b0bVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (b0bVar.o[0] << 6)) {
                    break;
                } else if (b0bVar.A[i8] != (i8 >> 6)) {
                    b0bVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = b0bVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            b0bVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, szaVar);
            yza.b(b0bVar.k, 256, d2);
            yza.b(b0bVar.l, 704, b0bVar.o[1]);
            yza.b(b0bVar.m, i6, d3);
            yza.a(b0bVar.k, szaVar);
            yza.a(b0bVar.l, szaVar);
            yza.a(b0bVar.m, szaVar);
            b0bVar.B = 0;
            b0bVar.C = 0;
            int[] iArr4 = uza.b;
            byte[] bArr3 = b0bVar.z;
            b0bVar.D = iArr4[bArr3[0]];
            b0bVar.E = iArr4[bArr3[0] + 1];
            b0bVar.v = 0;
            b0bVar.w = b0bVar.k.c[0];
            b0bVar.F = b0bVar.l.c[0];
            int[] iArr5 = b0bVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(b0b b0bVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, b0bVar) == null) {
            sza szaVar = b0bVar.c;
            if (b0bVar.h) {
                b0bVar.b = 10;
                b0bVar.Y = b0bVar.r;
                b0bVar.X = 0;
                b0bVar.a = 12;
                return;
            }
            yza yzaVar = b0bVar.k;
            yzaVar.b = null;
            yzaVar.c = null;
            yza yzaVar2 = b0bVar.l;
            yzaVar2.b = null;
            yzaVar2.c = null;
            yza yzaVar3 = b0bVar.m;
            yzaVar3.b = null;
            yzaVar3.c = null;
            sza.j(szaVar);
            g(szaVar, b0bVar);
            if (b0bVar.g == 0 && !b0bVar.j) {
                return;
            }
            if (!b0bVar.i && !b0bVar.j) {
                b0bVar.a = 2;
            } else {
                sza.g(szaVar);
                if (b0bVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                b0bVar.a = i;
            }
            if (b0bVar.j) {
                return;
            }
            b0bVar.R += b0bVar.g;
            if (b0bVar.Q < b0bVar.P) {
                k(b0bVar);
            }
        }
    }

    public static int r(int[] iArr, int i, sza szaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, szaVar)) == null) {
            long j = szaVar.f;
            int i2 = szaVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                szaVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            szaVar.g = i2 + (iArr[i7] >> 16) + 8;
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
