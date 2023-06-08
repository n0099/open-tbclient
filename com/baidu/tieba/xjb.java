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
public final class xjb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948303705, "Lcom/baidu/tieba/xjb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948303705, "Lcom/baidu/tieba/xjb;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(dkb dkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dkbVar) == null) {
            ujb ujbVar = dkbVar.c;
            byte[] bArr = dkbVar.d;
            int i = dkbVar.g;
            if (i <= 0) {
                ujb.k(ujbVar);
                dkbVar.a = 1;
                return;
            }
            int min = Math.min(dkbVar.Q - dkbVar.r, i);
            ujb.c(ujbVar, bArr, dkbVar.r, min);
            dkbVar.g -= min;
            int i2 = dkbVar.r + min;
            dkbVar.r = i2;
            int i3 = dkbVar.Q;
            if (i2 == i3) {
                dkbVar.b = 5;
                dkbVar.Y = i3;
                dkbVar.X = 0;
                dkbVar.a = 12;
                return;
            }
            ujb.k(ujbVar);
            dkbVar.a = 1;
        }
    }

    public static void k(dkb dkbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, dkbVar) == null) {
            int i2 = dkbVar.P;
            long j = dkbVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + dkbVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!dkbVar.h && i2 < 16384 && dkbVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = dkbVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = dkbVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = dkbVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = dkbVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(dkbVar.S, i, bArr, 0, i5);
                    dkbVar.r = i5;
                    dkbVar.f1095T = i5;
                }
            }
            dkbVar.d = bArr;
            dkbVar.Q = i2;
        }
    }

    public static boolean u(dkb dkbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, dkbVar)) == null) {
            int i = dkbVar.f1095T;
            if (i != 0) {
                dkbVar.X += i;
                dkbVar.f1095T = 0;
            }
            int min = Math.min(dkbVar.V - dkbVar.W, dkbVar.Y - dkbVar.X);
            if (min != 0) {
                System.arraycopy(dkbVar.d, dkbVar.X, dkbVar.Z, dkbVar.U + dkbVar.W, min);
                dkbVar.W += min;
                dkbVar.X += min;
            }
            if (dkbVar.W >= dkbVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(dkb dkbVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, dkbVar, i) == null) {
            ujb ujbVar = dkbVar.c;
            int[] iArr = dkbVar.p;
            int i3 = i * 2;
            ujb.d(ujbVar);
            int i4 = i * 1080;
            int r = r(dkbVar.e, i4, ujbVar);
            dkbVar.n[i] = m(dkbVar.f, i4, ujbVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = dkbVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(dkb dkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dkbVar) == null) {
            b(dkbVar, 1);
            dkbVar.F = dkbVar.l.c[dkbVar.p[3]];
        }
    }

    public static void e(dkb dkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, dkbVar) == null) {
            b(dkbVar, 2);
            dkbVar.C = dkbVar.p[5] << 2;
        }
    }

    public static int h(ujb ujbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ujbVar)) == null) {
            if (ujb.i(ujbVar, 1) != 0) {
                int i = ujb.i(ujbVar, 3);
                if (i == 0) {
                    return 1;
                }
                return ujb.i(ujbVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, ujb ujbVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, ujbVar)) == null) {
            ujb.j(ujbVar);
            int h = h(ujbVar) + 1;
            if (h == 1) {
                fkb.a(bArr, 0, i);
                return h;
            }
            if (ujb.i(ujbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = ujb.i(ujbVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, ujbVar);
            int i3 = 0;
            while (i3 < i) {
                ujb.j(ujbVar);
                ujb.d(ujbVar);
                int r = r(iArr, 0, ujbVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + ujb.i(ujbVar, r); i4 != 0; i4--) {
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
            if (ujb.i(ujbVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(dkb dkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, dkbVar) == null) {
            b(dkbVar, 0);
            int i = dkbVar.p[1];
            int i2 = i << 6;
            dkbVar.B = i2;
            int i3 = dkbVar.A[i2] & 255;
            dkbVar.v = i3;
            dkbVar.w = dkbVar.k.c[i3];
            byte b2 = dkbVar.z[i];
            int[] iArr = wjb.b;
            dkbVar.D = iArr[b2];
            dkbVar.E = iArr[b2 + 1];
        }
    }

    public static void g(ujb ujbVar, dkb dkbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ujbVar, dkbVar) == null) {
            boolean z2 = true;
            if (ujb.i(ujbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            dkbVar.h = z;
            dkbVar.g = 0;
            dkbVar.i = false;
            dkbVar.j = false;
            if (z && ujb.i(ujbVar, 1) != 0) {
                return;
            }
            int i = ujb.i(ujbVar, 2) + 4;
            if (i == 7) {
                dkbVar.j = true;
                if (ujb.i(ujbVar, 1) == 0) {
                    int i2 = ujb.i(ujbVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = ujb.i(ujbVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        dkbVar.g = (i4 << (i3 * 8)) | dkbVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = ujb.i(ujbVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    dkbVar.g = (i6 << (i5 * 4)) | dkbVar.g;
                }
            }
            dkbVar.g++;
            if (!dkbVar.h) {
                if (ujb.i(ujbVar, 1) != 1) {
                    z2 = false;
                }
                dkbVar.i = z2;
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
    public static void i(dkb dkbVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, dkbVar) == null) {
            int i8 = dkbVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    ujb ujbVar = dkbVar.c;
                    int i9 = dkbVar.Q - 1;
                    byte[] bArr = dkbVar.d;
                    while (true) {
                        int i10 = dkbVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (dkbVar.g >= 0) {
                                            q(dkbVar);
                                            i9 = dkbVar.Q - 1;
                                            bArr = dkbVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(dkbVar);
                                        dkbVar.a = 3;
                                        if (dkbVar.g > 0) {
                                            dkbVar.a = 1;
                                            break;
                                        } else {
                                            ujb.j(ujbVar);
                                            if (dkbVar.n[1] == 0) {
                                                c(dkbVar);
                                            }
                                            int[] iArr = dkbVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            ujb.d(ujbVar);
                                            int r = r(dkbVar.l.b, dkbVar.F, ujbVar);
                                            int i12 = r >>> 6;
                                            dkbVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                dkbVar.G = -1;
                                            }
                                            int i13 = ckb.g[i12] + ((r >>> 3) & 7);
                                            int i14 = ckb.h[i12] + (r & 7);
                                            dkbVar.y = ckb.c[i13] + ujb.i(ujbVar, ckb.d[i13]);
                                            dkbVar.M = ckb.e[i14] + ujb.i(ujbVar, ckb.f[i14]);
                                            dkbVar.x = 0;
                                            dkbVar.a = 6;
                                            if (dkbVar.u) {
                                                int i15 = dkbVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (dkbVar.x < dkbVar.y) {
                                                        ujb.j(ujbVar);
                                                        if (dkbVar.n[0] == 0) {
                                                            f(dkbVar);
                                                        }
                                                        byte[] bArr2 = dkbVar.A;
                                                        int i18 = dkbVar.B;
                                                        int[] iArr2 = wjb.a;
                                                        int i19 = iArr2[dkbVar.D + i16];
                                                        int[] iArr3 = dkbVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        ujb.d(ujbVar);
                                                        akb akbVar = dkbVar.k;
                                                        int r2 = r(akbVar.b, akbVar.c[bArr2[i18 + (iArr2[dkbVar.E + i17] | i19)] & 255], ujbVar);
                                                        int i20 = dkbVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        dkbVar.x++;
                                                        dkbVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            dkbVar.b = 6;
                                                            dkbVar.Y = dkbVar.Q;
                                                            dkbVar.X = 0;
                                                            dkbVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (dkbVar.x < dkbVar.y) {
                                                        ujb.j(ujbVar);
                                                        if (dkbVar.n[0] == 0) {
                                                            f(dkbVar);
                                                        }
                                                        int[] iArr4 = dkbVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        ujb.d(ujbVar);
                                                        bArr[dkbVar.r] = (byte) r(dkbVar.k.b, dkbVar.w, ujbVar);
                                                        dkbVar.x++;
                                                        int i22 = dkbVar.r;
                                                        dkbVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            dkbVar.b = 6;
                                                            dkbVar.Y = dkbVar.Q;
                                                            dkbVar.X = 0;
                                                            dkbVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (dkbVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = dkbVar.g - dkbVar.y;
                                                dkbVar.g = i23;
                                                if (i23 <= 0) {
                                                    dkbVar.a = 3;
                                                    break;
                                                } else {
                                                    if (dkbVar.G < 0) {
                                                        ujb.j(ujbVar);
                                                        if (dkbVar.n[2] == 0) {
                                                            e(dkbVar);
                                                        }
                                                        int[] iArr5 = dkbVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        ujb.d(ujbVar);
                                                        akb akbVar2 = dkbVar.m;
                                                        int[] iArr6 = akbVar2.b;
                                                        int[] iArr7 = akbVar2.c;
                                                        byte[] bArr3 = dkbVar.H;
                                                        int i24 = dkbVar.C;
                                                        int i25 = dkbVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], ujbVar);
                                                        dkbVar.G = r3;
                                                        int i26 = dkbVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            dkbVar.G = i27;
                                                            int i28 = dkbVar.J & i27;
                                                            int i29 = i27 >>> dkbVar.K;
                                                            dkbVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            dkbVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + ujb.i(ujbVar, i30)) << dkbVar.K);
                                                        }
                                                    }
                                                    int t = t(dkbVar.G, dkbVar.q, dkbVar.t);
                                                    dkbVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = dkbVar.s;
                                                        int i32 = dkbVar.O;
                                                        if (i31 != i32 && (i6 = dkbVar.r) < i32) {
                                                            dkbVar.s = i6;
                                                        } else {
                                                            dkbVar.s = dkbVar.O;
                                                        }
                                                        dkbVar.N = dkbVar.r;
                                                        int i33 = dkbVar.L;
                                                        if (i33 > dkbVar.s) {
                                                            dkbVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (dkbVar.G > 0) {
                                                                int[] iArr8 = dkbVar.q;
                                                                int i34 = dkbVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                dkbVar.t = i34 + 1;
                                                            }
                                                            if (dkbVar.M <= dkbVar.g) {
                                                                dkbVar.x = 0;
                                                                dkbVar.a = 7;
                                                                int i35 = dkbVar.r;
                                                                i = (i35 - dkbVar.L) & i9;
                                                                i2 = dkbVar.M - dkbVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    dkbVar.x += i2;
                                                                    dkbVar.g -= i2;
                                                                    dkbVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = dkbVar.x;
                                                                        if (i3 >= dkbVar.M) {
                                                                            i4 = dkbVar.r;
                                                                            bArr[i4] = bArr[(i4 - dkbVar.L) & i9];
                                                                            dkbVar.g--;
                                                                            dkbVar.x = i3 + 1;
                                                                            dkbVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    dkbVar.b = 7;
                                                                    dkbVar.Y = dkbVar.Q;
                                                                    dkbVar.X = 0;
                                                                    dkbVar.a = 12;
                                                                    if (dkbVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        dkbVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (dkbVar.a != i5) {
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
                                        if (dkbVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (dkbVar.g > 0) {
                                            ujb.j(ujbVar);
                                            ujb.i(ujbVar, 8);
                                            dkbVar.g--;
                                        }
                                        dkbVar.a = 1;
                                        break;
                                    case 5:
                                        a(dkbVar);
                                        break;
                                    case 6:
                                        if (dkbVar.u) {
                                        }
                                        if (dkbVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = dkbVar.r;
                                        i = (i352 - dkbVar.L) & i9;
                                        i2 = dkbVar.M - dkbVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = dkbVar.x;
                                            if (i3 >= dkbVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        dkbVar.b = 7;
                                        dkbVar.Y = dkbVar.Q;
                                        dkbVar.X = 0;
                                        dkbVar.a = 12;
                                        if (dkbVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = dkbVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, dkbVar.N - i36);
                                        dkbVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = dkbVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = yjb.a[i37];
                                            int i39 = (dkbVar.L - dkbVar.s) - 1;
                                            int i40 = yjb.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < ekb.d.length) {
                                                int b2 = ekb.b(bArr, dkbVar.N, yjb.a(), i43, dkbVar.M, ekb.d[i42]);
                                                int i44 = dkbVar.N + b2;
                                                dkbVar.N = i44;
                                                dkbVar.r += b2;
                                                dkbVar.g -= b2;
                                                int i45 = dkbVar.Q;
                                                if (i44 >= i45) {
                                                    dkbVar.b = 8;
                                                    dkbVar.Y = i45;
                                                    dkbVar.X = 0;
                                                    dkbVar.a = 12;
                                                    break;
                                                } else {
                                                    dkbVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + dkbVar.a);
                                }
                            } else if (!u(dkbVar)) {
                                return;
                            } else {
                                int i46 = dkbVar.r;
                                int i47 = dkbVar.O;
                                if (i46 >= i47) {
                                    dkbVar.s = i47;
                                }
                                dkbVar.r &= i9;
                                dkbVar.a = dkbVar.b;
                            }
                        } else if (i10 == 10) {
                            if (dkbVar.g >= 0) {
                                ujb.g(ujbVar);
                                ujb.a(dkbVar.c, true);
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

    public static void s(dkb dkbVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, dkbVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            dkbVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, ujb ujbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, ujbVar)) == null) {
            ujb.d(ujbVar);
            int r = r(iArr, i, ujbVar);
            return ckb.a[r] + ujb.i(ujbVar, ckb.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, ujb ujbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), ujbVar}) == null) {
            ujb.j(ujbVar);
            int[] iArr2 = new int[i];
            int i3 = ujb.i(ujbVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = ujb.i(ujbVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = ujb.i(ujbVar, i6) % i;
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
                            if (ujb.i(ujbVar, 1) == 1) {
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
                    zjb.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                ujb.d(ujbVar);
                long j = ujbVar.f;
                int i11 = ujbVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                ujbVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, ujbVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.fkb.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, ujb ujbVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, ujbVar) == null) {
            int[] iArr3 = new int[32];
            zjb.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    ujb.j(ujbVar);
                    ujb.d(ujbVar);
                    long j = ujbVar.f;
                    int i9 = ujbVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    ujbVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + ujb.i(ujbVar, i13) + 3;
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

    public static void p(dkb dkbVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, dkbVar) == null) {
            ujb ujbVar = dkbVar.c;
            for (int i = 0; i < 3; i++) {
                dkbVar.o[i] = h(ujbVar) + 1;
                dkbVar.n[i] = 268435456;
                int[] iArr2 = dkbVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, dkbVar.e, i2, ujbVar);
                    n(26, dkbVar.f, i2, ujbVar);
                    dkbVar.n[i] = m(dkbVar.f, i2, ujbVar);
                }
            }
            ujb.j(ujbVar);
            dkbVar.K = ujb.i(ujbVar, 2);
            int i3 = ujb.i(ujbVar, 4);
            int i4 = dkbVar.K;
            int i5 = (i3 << i4) + 16;
            dkbVar.I = i5;
            dkbVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            dkbVar.z = new byte[dkbVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = dkbVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    dkbVar.z[i7] = (byte) (ujb.i(ujbVar, 2) << 1);
                    i7++;
                }
                ujb.j(ujbVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            dkbVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, ujbVar);
            dkbVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (dkbVar.o[0] << 6)) {
                    break;
                } else if (dkbVar.A[i8] != (i8 >> 6)) {
                    dkbVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = dkbVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            dkbVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, ujbVar);
            akb.b(dkbVar.k, 256, d2);
            akb.b(dkbVar.l, 704, dkbVar.o[1]);
            akb.b(dkbVar.m, i6, d3);
            akb.a(dkbVar.k, ujbVar);
            akb.a(dkbVar.l, ujbVar);
            akb.a(dkbVar.m, ujbVar);
            dkbVar.B = 0;
            dkbVar.C = 0;
            int[] iArr4 = wjb.b;
            byte[] bArr3 = dkbVar.z;
            dkbVar.D = iArr4[bArr3[0]];
            dkbVar.E = iArr4[bArr3[0] + 1];
            dkbVar.v = 0;
            dkbVar.w = dkbVar.k.c[0];
            dkbVar.F = dkbVar.l.c[0];
            int[] iArr5 = dkbVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(dkb dkbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, dkbVar) == null) {
            ujb ujbVar = dkbVar.c;
            if (dkbVar.h) {
                dkbVar.b = 10;
                dkbVar.Y = dkbVar.r;
                dkbVar.X = 0;
                dkbVar.a = 12;
                return;
            }
            akb akbVar = dkbVar.k;
            akbVar.b = null;
            akbVar.c = null;
            akb akbVar2 = dkbVar.l;
            akbVar2.b = null;
            akbVar2.c = null;
            akb akbVar3 = dkbVar.m;
            akbVar3.b = null;
            akbVar3.c = null;
            ujb.j(ujbVar);
            g(ujbVar, dkbVar);
            if (dkbVar.g == 0 && !dkbVar.j) {
                return;
            }
            if (!dkbVar.i && !dkbVar.j) {
                dkbVar.a = 2;
            } else {
                ujb.g(ujbVar);
                if (dkbVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                dkbVar.a = i;
            }
            if (dkbVar.j) {
                return;
            }
            dkbVar.R += dkbVar.g;
            if (dkbVar.Q < dkbVar.P) {
                k(dkbVar);
            }
        }
    }

    public static int r(int[] iArr, int i, ujb ujbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, ujbVar)) == null) {
            long j = ujbVar.f;
            int i2 = ujbVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                ujbVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            ujbVar.g = i2 + (iArr[i7] >> 16) + 8;
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
