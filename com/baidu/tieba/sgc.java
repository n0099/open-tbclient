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
public final class sgc {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151898, "Lcom/baidu/tieba/sgc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151898, "Lcom/baidu/tieba/sgc;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(ygc ygcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ygcVar) == null) {
            pgc pgcVar = ygcVar.c;
            byte[] bArr = ygcVar.d;
            int i = ygcVar.g;
            if (i <= 0) {
                pgc.k(pgcVar);
                ygcVar.a = 1;
                return;
            }
            int min = Math.min(ygcVar.Q - ygcVar.r, i);
            pgc.c(pgcVar, bArr, ygcVar.r, min);
            ygcVar.g -= min;
            int i2 = ygcVar.r + min;
            ygcVar.r = i2;
            int i3 = ygcVar.Q;
            if (i2 == i3) {
                ygcVar.b = 5;
                ygcVar.Y = i3;
                ygcVar.X = 0;
                ygcVar.a = 12;
                return;
            }
            pgc.k(pgcVar);
            ygcVar.a = 1;
        }
    }

    public static void k(ygc ygcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, ygcVar) == null) {
            int i2 = ygcVar.P;
            long j = ygcVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + ygcVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!ygcVar.h && i2 < 16384 && ygcVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = ygcVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = ygcVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = ygcVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = ygcVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(ygcVar.S, i, bArr, 0, i5);
                    ygcVar.r = i5;
                    ygcVar.f1184T = i5;
                }
            }
            ygcVar.d = bArr;
            ygcVar.Q = i2;
        }
    }

    public static boolean u(ygc ygcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, ygcVar)) == null) {
            int i = ygcVar.f1184T;
            if (i != 0) {
                ygcVar.X += i;
                ygcVar.f1184T = 0;
            }
            int min = Math.min(ygcVar.V - ygcVar.W, ygcVar.Y - ygcVar.X);
            if (min != 0) {
                System.arraycopy(ygcVar.d, ygcVar.X, ygcVar.Z, ygcVar.U + ygcVar.W, min);
                ygcVar.W += min;
                ygcVar.X += min;
            }
            if (ygcVar.W >= ygcVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(ygc ygcVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, ygcVar, i) == null) {
            pgc pgcVar = ygcVar.c;
            int[] iArr = ygcVar.p;
            int i3 = i * 2;
            pgc.d(pgcVar);
            int i4 = i * 1080;
            int r = r(ygcVar.e, i4, pgcVar);
            ygcVar.n[i] = m(ygcVar.f, i4, pgcVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = ygcVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(ygc ygcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ygcVar) == null) {
            b(ygcVar, 1);
            ygcVar.F = ygcVar.l.c[ygcVar.p[3]];
        }
    }

    public static void e(ygc ygcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ygcVar) == null) {
            b(ygcVar, 2);
            ygcVar.C = ygcVar.p[5] << 2;
        }
    }

    public static int h(pgc pgcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pgcVar)) == null) {
            if (pgc.i(pgcVar, 1) != 0) {
                int i = pgc.i(pgcVar, 3);
                if (i == 0) {
                    return 1;
                }
                return pgc.i(pgcVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, pgc pgcVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, pgcVar)) == null) {
            pgc.j(pgcVar);
            int h = h(pgcVar) + 1;
            if (h == 1) {
                ahc.a(bArr, 0, i);
                return h;
            }
            if (pgc.i(pgcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = pgc.i(pgcVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, pgcVar);
            int i3 = 0;
            while (i3 < i) {
                pgc.j(pgcVar);
                pgc.d(pgcVar);
                int r = r(iArr, 0, pgcVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + pgc.i(pgcVar, r); i4 != 0; i4--) {
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
            if (pgc.i(pgcVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(ygc ygcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, ygcVar) == null) {
            b(ygcVar, 0);
            int i = ygcVar.p[1];
            int i2 = i << 6;
            ygcVar.B = i2;
            int i3 = ygcVar.A[i2] & 255;
            ygcVar.v = i3;
            ygcVar.w = ygcVar.k.c[i3];
            byte b2 = ygcVar.z[i];
            int[] iArr = rgc.b;
            ygcVar.D = iArr[b2];
            ygcVar.E = iArr[b2 + 1];
        }
    }

    public static void g(pgc pgcVar, ygc ygcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pgcVar, ygcVar) == null) {
            boolean z2 = true;
            if (pgc.i(pgcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            ygcVar.h = z;
            ygcVar.g = 0;
            ygcVar.i = false;
            ygcVar.j = false;
            if (z && pgc.i(pgcVar, 1) != 0) {
                return;
            }
            int i = pgc.i(pgcVar, 2) + 4;
            if (i == 7) {
                ygcVar.j = true;
                if (pgc.i(pgcVar, 1) == 0) {
                    int i2 = pgc.i(pgcVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = pgc.i(pgcVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        ygcVar.g = (i4 << (i3 * 8)) | ygcVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = pgc.i(pgcVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    ygcVar.g = (i6 << (i5 * 4)) | ygcVar.g;
                }
            }
            ygcVar.g++;
            if (!ygcVar.h) {
                if (pgc.i(pgcVar, 1) != 1) {
                    z2 = false;
                }
                ygcVar.i = z2;
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
    public static void i(ygc ygcVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ygcVar) == null) {
            int i8 = ygcVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    pgc pgcVar = ygcVar.c;
                    int i9 = ygcVar.Q - 1;
                    byte[] bArr = ygcVar.d;
                    while (true) {
                        int i10 = ygcVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (ygcVar.g >= 0) {
                                            q(ygcVar);
                                            i9 = ygcVar.Q - 1;
                                            bArr = ygcVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(ygcVar);
                                        ygcVar.a = 3;
                                        if (ygcVar.g > 0) {
                                            ygcVar.a = 1;
                                            break;
                                        } else {
                                            pgc.j(pgcVar);
                                            if (ygcVar.n[1] == 0) {
                                                c(ygcVar);
                                            }
                                            int[] iArr = ygcVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            pgc.d(pgcVar);
                                            int r = r(ygcVar.l.b, ygcVar.F, pgcVar);
                                            int i12 = r >>> 6;
                                            ygcVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                ygcVar.G = -1;
                                            }
                                            int i13 = xgc.g[i12] + ((r >>> 3) & 7);
                                            int i14 = xgc.h[i12] + (r & 7);
                                            ygcVar.y = xgc.c[i13] + pgc.i(pgcVar, xgc.d[i13]);
                                            ygcVar.M = xgc.e[i14] + pgc.i(pgcVar, xgc.f[i14]);
                                            ygcVar.x = 0;
                                            ygcVar.a = 6;
                                            if (ygcVar.u) {
                                                int i15 = ygcVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (ygcVar.x < ygcVar.y) {
                                                        pgc.j(pgcVar);
                                                        if (ygcVar.n[0] == 0) {
                                                            f(ygcVar);
                                                        }
                                                        byte[] bArr2 = ygcVar.A;
                                                        int i18 = ygcVar.B;
                                                        int[] iArr2 = rgc.a;
                                                        int i19 = iArr2[ygcVar.D + i16];
                                                        int[] iArr3 = ygcVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        pgc.d(pgcVar);
                                                        vgc vgcVar = ygcVar.k;
                                                        int r2 = r(vgcVar.b, vgcVar.c[bArr2[i18 + (iArr2[ygcVar.E + i17] | i19)] & 255], pgcVar);
                                                        int i20 = ygcVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        ygcVar.x++;
                                                        ygcVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            ygcVar.b = 6;
                                                            ygcVar.Y = ygcVar.Q;
                                                            ygcVar.X = 0;
                                                            ygcVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (ygcVar.x < ygcVar.y) {
                                                        pgc.j(pgcVar);
                                                        if (ygcVar.n[0] == 0) {
                                                            f(ygcVar);
                                                        }
                                                        int[] iArr4 = ygcVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        pgc.d(pgcVar);
                                                        bArr[ygcVar.r] = (byte) r(ygcVar.k.b, ygcVar.w, pgcVar);
                                                        ygcVar.x++;
                                                        int i22 = ygcVar.r;
                                                        ygcVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            ygcVar.b = 6;
                                                            ygcVar.Y = ygcVar.Q;
                                                            ygcVar.X = 0;
                                                            ygcVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (ygcVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = ygcVar.g - ygcVar.y;
                                                ygcVar.g = i23;
                                                if (i23 <= 0) {
                                                    ygcVar.a = 3;
                                                    break;
                                                } else {
                                                    if (ygcVar.G < 0) {
                                                        pgc.j(pgcVar);
                                                        if (ygcVar.n[2] == 0) {
                                                            e(ygcVar);
                                                        }
                                                        int[] iArr5 = ygcVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        pgc.d(pgcVar);
                                                        vgc vgcVar2 = ygcVar.m;
                                                        int[] iArr6 = vgcVar2.b;
                                                        int[] iArr7 = vgcVar2.c;
                                                        byte[] bArr3 = ygcVar.H;
                                                        int i24 = ygcVar.C;
                                                        int i25 = ygcVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], pgcVar);
                                                        ygcVar.G = r3;
                                                        int i26 = ygcVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            ygcVar.G = i27;
                                                            int i28 = ygcVar.J & i27;
                                                            int i29 = i27 >>> ygcVar.K;
                                                            ygcVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            ygcVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + pgc.i(pgcVar, i30)) << ygcVar.K);
                                                        }
                                                    }
                                                    int t = t(ygcVar.G, ygcVar.q, ygcVar.t);
                                                    ygcVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = ygcVar.s;
                                                        int i32 = ygcVar.O;
                                                        if (i31 != i32 && (i6 = ygcVar.r) < i32) {
                                                            ygcVar.s = i6;
                                                        } else {
                                                            ygcVar.s = ygcVar.O;
                                                        }
                                                        ygcVar.N = ygcVar.r;
                                                        int i33 = ygcVar.L;
                                                        if (i33 > ygcVar.s) {
                                                            ygcVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (ygcVar.G > 0) {
                                                                int[] iArr8 = ygcVar.q;
                                                                int i34 = ygcVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                ygcVar.t = i34 + 1;
                                                            }
                                                            if (ygcVar.M <= ygcVar.g) {
                                                                ygcVar.x = 0;
                                                                ygcVar.a = 7;
                                                                int i35 = ygcVar.r;
                                                                i = (i35 - ygcVar.L) & i9;
                                                                i2 = ygcVar.M - ygcVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    ygcVar.x += i2;
                                                                    ygcVar.g -= i2;
                                                                    ygcVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = ygcVar.x;
                                                                        if (i3 >= ygcVar.M) {
                                                                            i4 = ygcVar.r;
                                                                            bArr[i4] = bArr[(i4 - ygcVar.L) & i9];
                                                                            ygcVar.g--;
                                                                            ygcVar.x = i3 + 1;
                                                                            ygcVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    ygcVar.b = 7;
                                                                    ygcVar.Y = ygcVar.Q;
                                                                    ygcVar.X = 0;
                                                                    ygcVar.a = 12;
                                                                    if (ygcVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        ygcVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (ygcVar.a != i5) {
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
                                        if (ygcVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (ygcVar.g > 0) {
                                            pgc.j(pgcVar);
                                            pgc.i(pgcVar, 8);
                                            ygcVar.g--;
                                        }
                                        ygcVar.a = 1;
                                        break;
                                    case 5:
                                        a(ygcVar);
                                        break;
                                    case 6:
                                        if (ygcVar.u) {
                                        }
                                        if (ygcVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = ygcVar.r;
                                        i = (i352 - ygcVar.L) & i9;
                                        i2 = ygcVar.M - ygcVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = ygcVar.x;
                                            if (i3 >= ygcVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        ygcVar.b = 7;
                                        ygcVar.Y = ygcVar.Q;
                                        ygcVar.X = 0;
                                        ygcVar.a = 12;
                                        if (ygcVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = ygcVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, ygcVar.N - i36);
                                        ygcVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = ygcVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = tgc.a[i37];
                                            int i39 = (ygcVar.L - ygcVar.s) - 1;
                                            int i40 = tgc.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < zgc.d.length) {
                                                int b2 = zgc.b(bArr, ygcVar.N, tgc.a(), i43, ygcVar.M, zgc.d[i42]);
                                                int i44 = ygcVar.N + b2;
                                                ygcVar.N = i44;
                                                ygcVar.r += b2;
                                                ygcVar.g -= b2;
                                                int i45 = ygcVar.Q;
                                                if (i44 >= i45) {
                                                    ygcVar.b = 8;
                                                    ygcVar.Y = i45;
                                                    ygcVar.X = 0;
                                                    ygcVar.a = 12;
                                                    break;
                                                } else {
                                                    ygcVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + ygcVar.a);
                                }
                            } else if (!u(ygcVar)) {
                                return;
                            } else {
                                int i46 = ygcVar.r;
                                int i47 = ygcVar.O;
                                if (i46 >= i47) {
                                    ygcVar.s = i47;
                                }
                                ygcVar.r &= i9;
                                ygcVar.a = ygcVar.b;
                            }
                        } else if (i10 == 10) {
                            if (ygcVar.g >= 0) {
                                pgc.g(pgcVar);
                                pgc.a(ygcVar.c, true);
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

    public static void s(ygc ygcVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, ygcVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            ygcVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, pgc pgcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, pgcVar)) == null) {
            pgc.d(pgcVar);
            int r = r(iArr, i, pgcVar);
            return xgc.a[r] + pgc.i(pgcVar, xgc.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, pgc pgcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), pgcVar}) == null) {
            pgc.j(pgcVar);
            int[] iArr2 = new int[i];
            int i3 = pgc.i(pgcVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = pgc.i(pgcVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = pgc.i(pgcVar, i6) % i;
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
                            if (pgc.i(pgcVar, 1) == 1) {
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
                    ugc.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                pgc.d(pgcVar);
                long j = pgcVar.f;
                int i11 = pgcVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                pgcVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, pgcVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.ahc.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, pgc pgcVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, pgcVar) == null) {
            int[] iArr3 = new int[32];
            ugc.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    pgc.j(pgcVar);
                    pgc.d(pgcVar);
                    long j = pgcVar.f;
                    int i9 = pgcVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    pgcVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + pgc.i(pgcVar, i13) + 3;
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

    public static void p(ygc ygcVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ygcVar) == null) {
            pgc pgcVar = ygcVar.c;
            for (int i = 0; i < 3; i++) {
                ygcVar.o[i] = h(pgcVar) + 1;
                ygcVar.n[i] = 268435456;
                int[] iArr2 = ygcVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, ygcVar.e, i2, pgcVar);
                    n(26, ygcVar.f, i2, pgcVar);
                    ygcVar.n[i] = m(ygcVar.f, i2, pgcVar);
                }
            }
            pgc.j(pgcVar);
            ygcVar.K = pgc.i(pgcVar, 2);
            int i3 = pgc.i(pgcVar, 4);
            int i4 = ygcVar.K;
            int i5 = (i3 << i4) + 16;
            ygcVar.I = i5;
            ygcVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            ygcVar.z = new byte[ygcVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = ygcVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    ygcVar.z[i7] = (byte) (pgc.i(pgcVar, 2) << 1);
                    i7++;
                }
                pgc.j(pgcVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            ygcVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, pgcVar);
            ygcVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (ygcVar.o[0] << 6)) {
                    break;
                } else if (ygcVar.A[i8] != (i8 >> 6)) {
                    ygcVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = ygcVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            ygcVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, pgcVar);
            vgc.b(ygcVar.k, 256, d2);
            vgc.b(ygcVar.l, 704, ygcVar.o[1]);
            vgc.b(ygcVar.m, i6, d3);
            vgc.a(ygcVar.k, pgcVar);
            vgc.a(ygcVar.l, pgcVar);
            vgc.a(ygcVar.m, pgcVar);
            ygcVar.B = 0;
            ygcVar.C = 0;
            int[] iArr4 = rgc.b;
            byte[] bArr3 = ygcVar.z;
            ygcVar.D = iArr4[bArr3[0]];
            ygcVar.E = iArr4[bArr3[0] + 1];
            ygcVar.v = 0;
            ygcVar.w = ygcVar.k.c[0];
            ygcVar.F = ygcVar.l.c[0];
            int[] iArr5 = ygcVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(ygc ygcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, ygcVar) == null) {
            pgc pgcVar = ygcVar.c;
            if (ygcVar.h) {
                ygcVar.b = 10;
                ygcVar.Y = ygcVar.r;
                ygcVar.X = 0;
                ygcVar.a = 12;
                return;
            }
            vgc vgcVar = ygcVar.k;
            vgcVar.b = null;
            vgcVar.c = null;
            vgc vgcVar2 = ygcVar.l;
            vgcVar2.b = null;
            vgcVar2.c = null;
            vgc vgcVar3 = ygcVar.m;
            vgcVar3.b = null;
            vgcVar3.c = null;
            pgc.j(pgcVar);
            g(pgcVar, ygcVar);
            if (ygcVar.g == 0 && !ygcVar.j) {
                return;
            }
            if (!ygcVar.i && !ygcVar.j) {
                ygcVar.a = 2;
            } else {
                pgc.g(pgcVar);
                if (ygcVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                ygcVar.a = i;
            }
            if (ygcVar.j) {
                return;
            }
            ygcVar.R += ygcVar.g;
            if (ygcVar.Q < ygcVar.P) {
                k(ygcVar);
            }
        }
    }

    public static int r(int[] iArr, int i, pgc pgcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, pgcVar)) == null) {
            long j = pgcVar.f;
            int i2 = pgcVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                pgcVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            pgcVar.g = i2 + (iArr[i7] >> 16) + 8;
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
