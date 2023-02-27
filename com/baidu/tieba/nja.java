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
public final class nja {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948005764, "Lcom/baidu/tieba/nja;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948005764, "Lcom/baidu/tieba/nja;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(tja tjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, tjaVar) == null) {
            kja kjaVar = tjaVar.c;
            byte[] bArr = tjaVar.d;
            int i = tjaVar.g;
            if (i <= 0) {
                kja.k(kjaVar);
                tjaVar.a = 1;
                return;
            }
            int min = Math.min(tjaVar.Q - tjaVar.r, i);
            kja.c(kjaVar, bArr, tjaVar.r, min);
            tjaVar.g -= min;
            int i2 = tjaVar.r + min;
            tjaVar.r = i2;
            int i3 = tjaVar.Q;
            if (i2 == i3) {
                tjaVar.b = 5;
                tjaVar.Y = i3;
                tjaVar.X = 0;
                tjaVar.a = 12;
                return;
            }
            kja.k(kjaVar);
            tjaVar.a = 1;
        }
    }

    public static void k(tja tjaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, tjaVar) == null) {
            int i2 = tjaVar.P;
            long j = tjaVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + tjaVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!tjaVar.h && i2 < 16384 && tjaVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = tjaVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = tjaVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = tjaVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = tjaVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(tjaVar.S, i, bArr, 0, i5);
                    tjaVar.r = i5;
                    tjaVar.T = i5;
                }
            }
            tjaVar.d = bArr;
            tjaVar.Q = i2;
        }
    }

    public static boolean u(tja tjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tjaVar)) == null) {
            int i = tjaVar.T;
            if (i != 0) {
                tjaVar.X += i;
                tjaVar.T = 0;
            }
            int min = Math.min(tjaVar.V - tjaVar.W, tjaVar.Y - tjaVar.X);
            if (min != 0) {
                System.arraycopy(tjaVar.d, tjaVar.X, tjaVar.Z, tjaVar.U + tjaVar.W, min);
                tjaVar.W += min;
                tjaVar.X += min;
            }
            if (tjaVar.W >= tjaVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(tja tjaVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, tjaVar, i) == null) {
            kja kjaVar = tjaVar.c;
            int[] iArr = tjaVar.p;
            int i3 = i * 2;
            kja.d(kjaVar);
            int i4 = i * 1080;
            int r = r(tjaVar.e, i4, kjaVar);
            tjaVar.n[i] = m(tjaVar.f, i4, kjaVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = tjaVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(tja tjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, tjaVar) == null) {
            b(tjaVar, 1);
            tjaVar.F = tjaVar.l.c[tjaVar.p[3]];
        }
    }

    public static void e(tja tjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, tjaVar) == null) {
            b(tjaVar, 2);
            tjaVar.C = tjaVar.p[5] << 2;
        }
    }

    public static int h(kja kjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, kjaVar)) == null) {
            if (kja.i(kjaVar, 1) != 0) {
                int i = kja.i(kjaVar, 3);
                if (i == 0) {
                    return 1;
                }
                return kja.i(kjaVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, kja kjaVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, kjaVar)) == null) {
            kja.j(kjaVar);
            int h = h(kjaVar) + 1;
            if (h == 1) {
                vja.a(bArr, 0, i);
                return h;
            }
            if (kja.i(kjaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = kja.i(kjaVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, kjaVar);
            int i3 = 0;
            while (i3 < i) {
                kja.j(kjaVar);
                kja.d(kjaVar);
                int r = r(iArr, 0, kjaVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + kja.i(kjaVar, r); i4 != 0; i4--) {
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
            if (kja.i(kjaVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(tja tjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, tjaVar) == null) {
            b(tjaVar, 0);
            int i = tjaVar.p[1];
            int i2 = i << 6;
            tjaVar.B = i2;
            int i3 = tjaVar.A[i2] & 255;
            tjaVar.v = i3;
            tjaVar.w = tjaVar.k.c[i3];
            byte b2 = tjaVar.z[i];
            int[] iArr = mja.b;
            tjaVar.D = iArr[b2];
            tjaVar.E = iArr[b2 + 1];
        }
    }

    public static void g(kja kjaVar, tja tjaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, kjaVar, tjaVar) == null) {
            boolean z2 = true;
            if (kja.i(kjaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            tjaVar.h = z;
            tjaVar.g = 0;
            tjaVar.i = false;
            tjaVar.j = false;
            if (z && kja.i(kjaVar, 1) != 0) {
                return;
            }
            int i = kja.i(kjaVar, 2) + 4;
            if (i == 7) {
                tjaVar.j = true;
                if (kja.i(kjaVar, 1) == 0) {
                    int i2 = kja.i(kjaVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = kja.i(kjaVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        tjaVar.g = (i4 << (i3 * 8)) | tjaVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = kja.i(kjaVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    tjaVar.g = (i6 << (i5 * 4)) | tjaVar.g;
                }
            }
            tjaVar.g++;
            if (!tjaVar.h) {
                if (kja.i(kjaVar, 1) != 1) {
                    z2 = false;
                }
                tjaVar.i = z2;
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
    public static void i(tja tjaVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, tjaVar) == null) {
            int i8 = tjaVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    kja kjaVar = tjaVar.c;
                    int i9 = tjaVar.Q - 1;
                    byte[] bArr = tjaVar.d;
                    while (true) {
                        int i10 = tjaVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (tjaVar.g >= 0) {
                                            q(tjaVar);
                                            i9 = tjaVar.Q - 1;
                                            bArr = tjaVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(tjaVar);
                                        tjaVar.a = 3;
                                        if (tjaVar.g > 0) {
                                            tjaVar.a = 1;
                                            break;
                                        } else {
                                            kja.j(kjaVar);
                                            if (tjaVar.n[1] == 0) {
                                                c(tjaVar);
                                            }
                                            int[] iArr = tjaVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            kja.d(kjaVar);
                                            int r = r(tjaVar.l.b, tjaVar.F, kjaVar);
                                            int i12 = r >>> 6;
                                            tjaVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                tjaVar.G = -1;
                                            }
                                            int i13 = sja.g[i12] + ((r >>> 3) & 7);
                                            int i14 = sja.h[i12] + (r & 7);
                                            tjaVar.y = sja.c[i13] + kja.i(kjaVar, sja.d[i13]);
                                            tjaVar.M = sja.e[i14] + kja.i(kjaVar, sja.f[i14]);
                                            tjaVar.x = 0;
                                            tjaVar.a = 6;
                                            if (tjaVar.u) {
                                                int i15 = tjaVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (tjaVar.x < tjaVar.y) {
                                                        kja.j(kjaVar);
                                                        if (tjaVar.n[0] == 0) {
                                                            f(tjaVar);
                                                        }
                                                        byte[] bArr2 = tjaVar.A;
                                                        int i18 = tjaVar.B;
                                                        int[] iArr2 = mja.a;
                                                        int i19 = iArr2[tjaVar.D + i16];
                                                        int[] iArr3 = tjaVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        kja.d(kjaVar);
                                                        qja qjaVar = tjaVar.k;
                                                        int r2 = r(qjaVar.b, qjaVar.c[bArr2[i18 + (iArr2[tjaVar.E + i17] | i19)] & 255], kjaVar);
                                                        int i20 = tjaVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        tjaVar.x++;
                                                        tjaVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            tjaVar.b = 6;
                                                            tjaVar.Y = tjaVar.Q;
                                                            tjaVar.X = 0;
                                                            tjaVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (tjaVar.x < tjaVar.y) {
                                                        kja.j(kjaVar);
                                                        if (tjaVar.n[0] == 0) {
                                                            f(tjaVar);
                                                        }
                                                        int[] iArr4 = tjaVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        kja.d(kjaVar);
                                                        bArr[tjaVar.r] = (byte) r(tjaVar.k.b, tjaVar.w, kjaVar);
                                                        tjaVar.x++;
                                                        int i22 = tjaVar.r;
                                                        tjaVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            tjaVar.b = 6;
                                                            tjaVar.Y = tjaVar.Q;
                                                            tjaVar.X = 0;
                                                            tjaVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (tjaVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = tjaVar.g - tjaVar.y;
                                                tjaVar.g = i23;
                                                if (i23 <= 0) {
                                                    tjaVar.a = 3;
                                                    break;
                                                } else {
                                                    if (tjaVar.G < 0) {
                                                        kja.j(kjaVar);
                                                        if (tjaVar.n[2] == 0) {
                                                            e(tjaVar);
                                                        }
                                                        int[] iArr5 = tjaVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        kja.d(kjaVar);
                                                        qja qjaVar2 = tjaVar.m;
                                                        int[] iArr6 = qjaVar2.b;
                                                        int[] iArr7 = qjaVar2.c;
                                                        byte[] bArr3 = tjaVar.H;
                                                        int i24 = tjaVar.C;
                                                        int i25 = tjaVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], kjaVar);
                                                        tjaVar.G = r3;
                                                        int i26 = tjaVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            tjaVar.G = i27;
                                                            int i28 = tjaVar.J & i27;
                                                            int i29 = i27 >>> tjaVar.K;
                                                            tjaVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            tjaVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + kja.i(kjaVar, i30)) << tjaVar.K);
                                                        }
                                                    }
                                                    int t = t(tjaVar.G, tjaVar.q, tjaVar.t);
                                                    tjaVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = tjaVar.s;
                                                        int i32 = tjaVar.O;
                                                        if (i31 != i32 && (i6 = tjaVar.r) < i32) {
                                                            tjaVar.s = i6;
                                                        } else {
                                                            tjaVar.s = tjaVar.O;
                                                        }
                                                        tjaVar.N = tjaVar.r;
                                                        int i33 = tjaVar.L;
                                                        if (i33 > tjaVar.s) {
                                                            tjaVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (tjaVar.G > 0) {
                                                                int[] iArr8 = tjaVar.q;
                                                                int i34 = tjaVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                tjaVar.t = i34 + 1;
                                                            }
                                                            if (tjaVar.M <= tjaVar.g) {
                                                                tjaVar.x = 0;
                                                                tjaVar.a = 7;
                                                                int i35 = tjaVar.r;
                                                                i = (i35 - tjaVar.L) & i9;
                                                                i2 = tjaVar.M - tjaVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    tjaVar.x += i2;
                                                                    tjaVar.g -= i2;
                                                                    tjaVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = tjaVar.x;
                                                                        if (i3 >= tjaVar.M) {
                                                                            i4 = tjaVar.r;
                                                                            bArr[i4] = bArr[(i4 - tjaVar.L) & i9];
                                                                            tjaVar.g--;
                                                                            tjaVar.x = i3 + 1;
                                                                            tjaVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    tjaVar.b = 7;
                                                                    tjaVar.Y = tjaVar.Q;
                                                                    tjaVar.X = 0;
                                                                    tjaVar.a = 12;
                                                                    if (tjaVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        tjaVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (tjaVar.a != i5) {
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
                                        if (tjaVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (tjaVar.g > 0) {
                                            kja.j(kjaVar);
                                            kja.i(kjaVar, 8);
                                            tjaVar.g--;
                                        }
                                        tjaVar.a = 1;
                                        break;
                                    case 5:
                                        a(tjaVar);
                                        break;
                                    case 6:
                                        if (tjaVar.u) {
                                        }
                                        if (tjaVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = tjaVar.r;
                                        i = (i352 - tjaVar.L) & i9;
                                        i2 = tjaVar.M - tjaVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = tjaVar.x;
                                            if (i3 >= tjaVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        tjaVar.b = 7;
                                        tjaVar.Y = tjaVar.Q;
                                        tjaVar.X = 0;
                                        tjaVar.a = 12;
                                        if (tjaVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = tjaVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, tjaVar.N - i36);
                                        tjaVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = tjaVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = oja.a[i37];
                                            int i39 = (tjaVar.L - tjaVar.s) - 1;
                                            int i40 = oja.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < uja.d.length) {
                                                int b2 = uja.b(bArr, tjaVar.N, oja.a(), i43, tjaVar.M, uja.d[i42]);
                                                int i44 = tjaVar.N + b2;
                                                tjaVar.N = i44;
                                                tjaVar.r += b2;
                                                tjaVar.g -= b2;
                                                int i45 = tjaVar.Q;
                                                if (i44 >= i45) {
                                                    tjaVar.b = 8;
                                                    tjaVar.Y = i45;
                                                    tjaVar.X = 0;
                                                    tjaVar.a = 12;
                                                    break;
                                                } else {
                                                    tjaVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + tjaVar.a);
                                }
                            } else if (!u(tjaVar)) {
                                return;
                            } else {
                                int i46 = tjaVar.r;
                                int i47 = tjaVar.O;
                                if (i46 >= i47) {
                                    tjaVar.s = i47;
                                }
                                tjaVar.r &= i9;
                                tjaVar.a = tjaVar.b;
                            }
                        } else if (i10 == 10) {
                            if (tjaVar.g >= 0) {
                                kja.g(kjaVar);
                                kja.a(tjaVar.c, true);
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

    public static void s(tja tjaVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, tjaVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            tjaVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, kja kjaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, kjaVar)) == null) {
            kja.d(kjaVar);
            int r = r(iArr, i, kjaVar);
            return sja.a[r] + kja.i(kjaVar, sja.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, kja kjaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), kjaVar}) == null) {
            kja.j(kjaVar);
            int[] iArr2 = new int[i];
            int i3 = kja.i(kjaVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = kja.i(kjaVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = kja.i(kjaVar, i6) % i;
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
                            if (kja.i(kjaVar, 1) == 1) {
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
                    pja.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                kja.d(kjaVar);
                long j = kjaVar.f;
                int i11 = kjaVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                kjaVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, kjaVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.vja.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, kja kjaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, kjaVar) == null) {
            int[] iArr3 = new int[32];
            pja.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    kja.j(kjaVar);
                    kja.d(kjaVar);
                    long j = kjaVar.f;
                    int i9 = kjaVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    kjaVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + kja.i(kjaVar, i13) + 3;
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

    public static void p(tja tjaVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, tjaVar) == null) {
            kja kjaVar = tjaVar.c;
            for (int i = 0; i < 3; i++) {
                tjaVar.o[i] = h(kjaVar) + 1;
                tjaVar.n[i] = 268435456;
                int[] iArr2 = tjaVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, tjaVar.e, i2, kjaVar);
                    n(26, tjaVar.f, i2, kjaVar);
                    tjaVar.n[i] = m(tjaVar.f, i2, kjaVar);
                }
            }
            kja.j(kjaVar);
            tjaVar.K = kja.i(kjaVar, 2);
            int i3 = kja.i(kjaVar, 4);
            int i4 = tjaVar.K;
            int i5 = (i3 << i4) + 16;
            tjaVar.I = i5;
            tjaVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            tjaVar.z = new byte[tjaVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = tjaVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    tjaVar.z[i7] = (byte) (kja.i(kjaVar, 2) << 1);
                    i7++;
                }
                kja.j(kjaVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            tjaVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, kjaVar);
            tjaVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (tjaVar.o[0] << 6)) {
                    break;
                } else if (tjaVar.A[i8] != (i8 >> 6)) {
                    tjaVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = tjaVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            tjaVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, kjaVar);
            qja.b(tjaVar.k, 256, d2);
            qja.b(tjaVar.l, 704, tjaVar.o[1]);
            qja.b(tjaVar.m, i6, d3);
            qja.a(tjaVar.k, kjaVar);
            qja.a(tjaVar.l, kjaVar);
            qja.a(tjaVar.m, kjaVar);
            tjaVar.B = 0;
            tjaVar.C = 0;
            int[] iArr4 = mja.b;
            byte[] bArr3 = tjaVar.z;
            tjaVar.D = iArr4[bArr3[0]];
            tjaVar.E = iArr4[bArr3[0] + 1];
            tjaVar.v = 0;
            tjaVar.w = tjaVar.k.c[0];
            tjaVar.F = tjaVar.l.c[0];
            int[] iArr5 = tjaVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(tja tjaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, tjaVar) == null) {
            kja kjaVar = tjaVar.c;
            if (tjaVar.h) {
                tjaVar.b = 10;
                tjaVar.Y = tjaVar.r;
                tjaVar.X = 0;
                tjaVar.a = 12;
                return;
            }
            qja qjaVar = tjaVar.k;
            qjaVar.b = null;
            qjaVar.c = null;
            qja qjaVar2 = tjaVar.l;
            qjaVar2.b = null;
            qjaVar2.c = null;
            qja qjaVar3 = tjaVar.m;
            qjaVar3.b = null;
            qjaVar3.c = null;
            kja.j(kjaVar);
            g(kjaVar, tjaVar);
            if (tjaVar.g == 0 && !tjaVar.j) {
                return;
            }
            if (!tjaVar.i && !tjaVar.j) {
                tjaVar.a = 2;
            } else {
                kja.g(kjaVar);
                if (tjaVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                tjaVar.a = i;
            }
            if (tjaVar.j) {
                return;
            }
            tjaVar.R += tjaVar.g;
            if (tjaVar.Q < tjaVar.P) {
                k(tjaVar);
            }
        }
    }

    public static int r(int[] iArr, int i, kja kjaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, kjaVar)) == null) {
            long j = kjaVar.f;
            int i2 = kjaVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                kjaVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            kjaVar.g = i2 + (iArr[i7] >> 16) + 8;
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
