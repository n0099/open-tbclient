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
public final class wpa {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948279649, "Lcom/baidu/tieba/wpa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948279649, "Lcom/baidu/tieba/wpa;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(cqa cqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cqaVar) == null) {
            tpa tpaVar = cqaVar.c;
            byte[] bArr = cqaVar.d;
            int i = cqaVar.g;
            if (i <= 0) {
                tpa.k(tpaVar);
                cqaVar.a = 1;
                return;
            }
            int min = Math.min(cqaVar.Q - cqaVar.r, i);
            tpa.c(tpaVar, bArr, cqaVar.r, min);
            cqaVar.g -= min;
            int i2 = cqaVar.r + min;
            cqaVar.r = i2;
            int i3 = cqaVar.Q;
            if (i2 == i3) {
                cqaVar.b = 5;
                cqaVar.Y = i3;
                cqaVar.X = 0;
                cqaVar.a = 12;
                return;
            }
            tpa.k(tpaVar);
            cqaVar.a = 1;
        }
    }

    public static void k(cqa cqaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, cqaVar) == null) {
            int i2 = cqaVar.P;
            long j = cqaVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + cqaVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!cqaVar.h && i2 < 16384 && cqaVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = cqaVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = cqaVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = cqaVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = cqaVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(cqaVar.S, i, bArr, 0, i5);
                    cqaVar.r = i5;
                    cqaVar.T = i5;
                }
            }
            cqaVar.d = bArr;
            cqaVar.Q = i2;
        }
    }

    public static boolean u(cqa cqaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, cqaVar)) == null) {
            int i = cqaVar.T;
            if (i != 0) {
                cqaVar.X += i;
                cqaVar.T = 0;
            }
            int min = Math.min(cqaVar.V - cqaVar.W, cqaVar.Y - cqaVar.X);
            if (min != 0) {
                System.arraycopy(cqaVar.d, cqaVar.X, cqaVar.Z, cqaVar.U + cqaVar.W, min);
                cqaVar.W += min;
                cqaVar.X += min;
            }
            if (cqaVar.W >= cqaVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(cqa cqaVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, cqaVar, i) == null) {
            tpa tpaVar = cqaVar.c;
            int[] iArr = cqaVar.p;
            int i3 = i * 2;
            tpa.d(tpaVar);
            int i4 = i * 1080;
            int r = r(cqaVar.e, i4, tpaVar);
            cqaVar.n[i] = m(cqaVar.f, i4, tpaVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = cqaVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(cqa cqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cqaVar) == null) {
            b(cqaVar, 1);
            cqaVar.F = cqaVar.l.c[cqaVar.p[3]];
        }
    }

    public static void e(cqa cqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cqaVar) == null) {
            b(cqaVar, 2);
            cqaVar.C = cqaVar.p[5] << 2;
        }
    }

    public static int h(tpa tpaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tpaVar)) == null) {
            if (tpa.i(tpaVar, 1) != 0) {
                int i = tpa.i(tpaVar, 3);
                if (i == 0) {
                    return 1;
                }
                return tpa.i(tpaVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, tpa tpaVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, tpaVar)) == null) {
            tpa.j(tpaVar);
            int h = h(tpaVar) + 1;
            if (h == 1) {
                eqa.a(bArr, 0, i);
                return h;
            }
            if (tpa.i(tpaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = tpa.i(tpaVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, tpaVar);
            int i3 = 0;
            while (i3 < i) {
                tpa.j(tpaVar);
                tpa.d(tpaVar);
                int r = r(iArr, 0, tpaVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + tpa.i(tpaVar, r); i4 != 0; i4--) {
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
            if (tpa.i(tpaVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(cqa cqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, cqaVar) == null) {
            b(cqaVar, 0);
            int i = cqaVar.p[1];
            int i2 = i << 6;
            cqaVar.B = i2;
            int i3 = cqaVar.A[i2] & 255;
            cqaVar.v = i3;
            cqaVar.w = cqaVar.k.c[i3];
            byte b2 = cqaVar.z[i];
            int[] iArr = vpa.b;
            cqaVar.D = iArr[b2];
            cqaVar.E = iArr[b2 + 1];
        }
    }

    public static void g(tpa tpaVar, cqa cqaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tpaVar, cqaVar) == null) {
            boolean z2 = true;
            if (tpa.i(tpaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            cqaVar.h = z;
            cqaVar.g = 0;
            cqaVar.i = false;
            cqaVar.j = false;
            if (z && tpa.i(tpaVar, 1) != 0) {
                return;
            }
            int i = tpa.i(tpaVar, 2) + 4;
            if (i == 7) {
                cqaVar.j = true;
                if (tpa.i(tpaVar, 1) == 0) {
                    int i2 = tpa.i(tpaVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = tpa.i(tpaVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        cqaVar.g = (i4 << (i3 * 8)) | cqaVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = tpa.i(tpaVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    cqaVar.g = (i6 << (i5 * 4)) | cqaVar.g;
                }
            }
            cqaVar.g++;
            if (!cqaVar.h) {
                if (tpa.i(tpaVar, 1) != 1) {
                    z2 = false;
                }
                cqaVar.i = z2;
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
    public static void i(cqa cqaVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, cqaVar) == null) {
            int i8 = cqaVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    tpa tpaVar = cqaVar.c;
                    int i9 = cqaVar.Q - 1;
                    byte[] bArr = cqaVar.d;
                    while (true) {
                        int i10 = cqaVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (cqaVar.g >= 0) {
                                            q(cqaVar);
                                            i9 = cqaVar.Q - 1;
                                            bArr = cqaVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(cqaVar);
                                        cqaVar.a = 3;
                                        if (cqaVar.g > 0) {
                                            cqaVar.a = 1;
                                            break;
                                        } else {
                                            tpa.j(tpaVar);
                                            if (cqaVar.n[1] == 0) {
                                                c(cqaVar);
                                            }
                                            int[] iArr = cqaVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            tpa.d(tpaVar);
                                            int r = r(cqaVar.l.b, cqaVar.F, tpaVar);
                                            int i12 = r >>> 6;
                                            cqaVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                cqaVar.G = -1;
                                            }
                                            int i13 = bqa.g[i12] + ((r >>> 3) & 7);
                                            int i14 = bqa.h[i12] + (r & 7);
                                            cqaVar.y = bqa.c[i13] + tpa.i(tpaVar, bqa.d[i13]);
                                            cqaVar.M = bqa.e[i14] + tpa.i(tpaVar, bqa.f[i14]);
                                            cqaVar.x = 0;
                                            cqaVar.a = 6;
                                            if (cqaVar.u) {
                                                int i15 = cqaVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (cqaVar.x < cqaVar.y) {
                                                        tpa.j(tpaVar);
                                                        if (cqaVar.n[0] == 0) {
                                                            f(cqaVar);
                                                        }
                                                        byte[] bArr2 = cqaVar.A;
                                                        int i18 = cqaVar.B;
                                                        int[] iArr2 = vpa.a;
                                                        int i19 = iArr2[cqaVar.D + i16];
                                                        int[] iArr3 = cqaVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        tpa.d(tpaVar);
                                                        zpa zpaVar = cqaVar.k;
                                                        int r2 = r(zpaVar.b, zpaVar.c[bArr2[i18 + (iArr2[cqaVar.E + i17] | i19)] & 255], tpaVar);
                                                        int i20 = cqaVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        cqaVar.x++;
                                                        cqaVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            cqaVar.b = 6;
                                                            cqaVar.Y = cqaVar.Q;
                                                            cqaVar.X = 0;
                                                            cqaVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (cqaVar.x < cqaVar.y) {
                                                        tpa.j(tpaVar);
                                                        if (cqaVar.n[0] == 0) {
                                                            f(cqaVar);
                                                        }
                                                        int[] iArr4 = cqaVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        tpa.d(tpaVar);
                                                        bArr[cqaVar.r] = (byte) r(cqaVar.k.b, cqaVar.w, tpaVar);
                                                        cqaVar.x++;
                                                        int i22 = cqaVar.r;
                                                        cqaVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            cqaVar.b = 6;
                                                            cqaVar.Y = cqaVar.Q;
                                                            cqaVar.X = 0;
                                                            cqaVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (cqaVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = cqaVar.g - cqaVar.y;
                                                cqaVar.g = i23;
                                                if (i23 <= 0) {
                                                    cqaVar.a = 3;
                                                    break;
                                                } else {
                                                    if (cqaVar.G < 0) {
                                                        tpa.j(tpaVar);
                                                        if (cqaVar.n[2] == 0) {
                                                            e(cqaVar);
                                                        }
                                                        int[] iArr5 = cqaVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        tpa.d(tpaVar);
                                                        zpa zpaVar2 = cqaVar.m;
                                                        int[] iArr6 = zpaVar2.b;
                                                        int[] iArr7 = zpaVar2.c;
                                                        byte[] bArr3 = cqaVar.H;
                                                        int i24 = cqaVar.C;
                                                        int i25 = cqaVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], tpaVar);
                                                        cqaVar.G = r3;
                                                        int i26 = cqaVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            cqaVar.G = i27;
                                                            int i28 = cqaVar.J & i27;
                                                            int i29 = i27 >>> cqaVar.K;
                                                            cqaVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            cqaVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + tpa.i(tpaVar, i30)) << cqaVar.K);
                                                        }
                                                    }
                                                    int t = t(cqaVar.G, cqaVar.q, cqaVar.t);
                                                    cqaVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = cqaVar.s;
                                                        int i32 = cqaVar.O;
                                                        if (i31 != i32 && (i6 = cqaVar.r) < i32) {
                                                            cqaVar.s = i6;
                                                        } else {
                                                            cqaVar.s = cqaVar.O;
                                                        }
                                                        cqaVar.N = cqaVar.r;
                                                        int i33 = cqaVar.L;
                                                        if (i33 > cqaVar.s) {
                                                            cqaVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (cqaVar.G > 0) {
                                                                int[] iArr8 = cqaVar.q;
                                                                int i34 = cqaVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                cqaVar.t = i34 + 1;
                                                            }
                                                            if (cqaVar.M <= cqaVar.g) {
                                                                cqaVar.x = 0;
                                                                cqaVar.a = 7;
                                                                int i35 = cqaVar.r;
                                                                i = (i35 - cqaVar.L) & i9;
                                                                i2 = cqaVar.M - cqaVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    cqaVar.x += i2;
                                                                    cqaVar.g -= i2;
                                                                    cqaVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = cqaVar.x;
                                                                        if (i3 >= cqaVar.M) {
                                                                            i4 = cqaVar.r;
                                                                            bArr[i4] = bArr[(i4 - cqaVar.L) & i9];
                                                                            cqaVar.g--;
                                                                            cqaVar.x = i3 + 1;
                                                                            cqaVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    cqaVar.b = 7;
                                                                    cqaVar.Y = cqaVar.Q;
                                                                    cqaVar.X = 0;
                                                                    cqaVar.a = 12;
                                                                    if (cqaVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        cqaVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (cqaVar.a != i5) {
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
                                        if (cqaVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (cqaVar.g > 0) {
                                            tpa.j(tpaVar);
                                            tpa.i(tpaVar, 8);
                                            cqaVar.g--;
                                        }
                                        cqaVar.a = 1;
                                        break;
                                    case 5:
                                        a(cqaVar);
                                        break;
                                    case 6:
                                        if (cqaVar.u) {
                                        }
                                        if (cqaVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = cqaVar.r;
                                        i = (i352 - cqaVar.L) & i9;
                                        i2 = cqaVar.M - cqaVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = cqaVar.x;
                                            if (i3 >= cqaVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        cqaVar.b = 7;
                                        cqaVar.Y = cqaVar.Q;
                                        cqaVar.X = 0;
                                        cqaVar.a = 12;
                                        if (cqaVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = cqaVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, cqaVar.N - i36);
                                        cqaVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = cqaVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = xpa.a[i37];
                                            int i39 = (cqaVar.L - cqaVar.s) - 1;
                                            int i40 = xpa.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < dqa.d.length) {
                                                int b2 = dqa.b(bArr, cqaVar.N, xpa.a(), i43, cqaVar.M, dqa.d[i42]);
                                                int i44 = cqaVar.N + b2;
                                                cqaVar.N = i44;
                                                cqaVar.r += b2;
                                                cqaVar.g -= b2;
                                                int i45 = cqaVar.Q;
                                                if (i44 >= i45) {
                                                    cqaVar.b = 8;
                                                    cqaVar.Y = i45;
                                                    cqaVar.X = 0;
                                                    cqaVar.a = 12;
                                                    break;
                                                } else {
                                                    cqaVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + cqaVar.a);
                                }
                            } else if (!u(cqaVar)) {
                                return;
                            } else {
                                int i46 = cqaVar.r;
                                int i47 = cqaVar.O;
                                if (i46 >= i47) {
                                    cqaVar.s = i47;
                                }
                                cqaVar.r &= i9;
                                cqaVar.a = cqaVar.b;
                            }
                        } else if (i10 == 10) {
                            if (cqaVar.g >= 0) {
                                tpa.g(tpaVar);
                                tpa.a(cqaVar.c, true);
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

    public static void s(cqa cqaVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, cqaVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            cqaVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, tpa tpaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, tpaVar)) == null) {
            tpa.d(tpaVar);
            int r = r(iArr, i, tpaVar);
            return bqa.a[r] + tpa.i(tpaVar, bqa.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, tpa tpaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), tpaVar}) == null) {
            tpa.j(tpaVar);
            int[] iArr2 = new int[i];
            int i3 = tpa.i(tpaVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = tpa.i(tpaVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = tpa.i(tpaVar, i6) % i;
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
                            if (tpa.i(tpaVar, 1) == 1) {
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
                    ypa.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                tpa.d(tpaVar);
                long j = tpaVar.f;
                int i11 = tpaVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                tpaVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, tpaVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.eqa.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, tpa tpaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, tpaVar) == null) {
            int[] iArr3 = new int[32];
            ypa.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    tpa.j(tpaVar);
                    tpa.d(tpaVar);
                    long j = tpaVar.f;
                    int i9 = tpaVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    tpaVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + tpa.i(tpaVar, i13) + 3;
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

    public static void p(cqa cqaVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, cqaVar) == null) {
            tpa tpaVar = cqaVar.c;
            for (int i = 0; i < 3; i++) {
                cqaVar.o[i] = h(tpaVar) + 1;
                cqaVar.n[i] = 268435456;
                int[] iArr2 = cqaVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, cqaVar.e, i2, tpaVar);
                    n(26, cqaVar.f, i2, tpaVar);
                    cqaVar.n[i] = m(cqaVar.f, i2, tpaVar);
                }
            }
            tpa.j(tpaVar);
            cqaVar.K = tpa.i(tpaVar, 2);
            int i3 = tpa.i(tpaVar, 4);
            int i4 = cqaVar.K;
            int i5 = (i3 << i4) + 16;
            cqaVar.I = i5;
            cqaVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            cqaVar.z = new byte[cqaVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = cqaVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    cqaVar.z[i7] = (byte) (tpa.i(tpaVar, 2) << 1);
                    i7++;
                }
                tpa.j(tpaVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            cqaVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, tpaVar);
            cqaVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (cqaVar.o[0] << 6)) {
                    break;
                } else if (cqaVar.A[i8] != (i8 >> 6)) {
                    cqaVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = cqaVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            cqaVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, tpaVar);
            zpa.b(cqaVar.k, 256, d2);
            zpa.b(cqaVar.l, 704, cqaVar.o[1]);
            zpa.b(cqaVar.m, i6, d3);
            zpa.a(cqaVar.k, tpaVar);
            zpa.a(cqaVar.l, tpaVar);
            zpa.a(cqaVar.m, tpaVar);
            cqaVar.B = 0;
            cqaVar.C = 0;
            int[] iArr4 = vpa.b;
            byte[] bArr3 = cqaVar.z;
            cqaVar.D = iArr4[bArr3[0]];
            cqaVar.E = iArr4[bArr3[0] + 1];
            cqaVar.v = 0;
            cqaVar.w = cqaVar.k.c[0];
            cqaVar.F = cqaVar.l.c[0];
            int[] iArr5 = cqaVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(cqa cqaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, cqaVar) == null) {
            tpa tpaVar = cqaVar.c;
            if (cqaVar.h) {
                cqaVar.b = 10;
                cqaVar.Y = cqaVar.r;
                cqaVar.X = 0;
                cqaVar.a = 12;
                return;
            }
            zpa zpaVar = cqaVar.k;
            zpaVar.b = null;
            zpaVar.c = null;
            zpa zpaVar2 = cqaVar.l;
            zpaVar2.b = null;
            zpaVar2.c = null;
            zpa zpaVar3 = cqaVar.m;
            zpaVar3.b = null;
            zpaVar3.c = null;
            tpa.j(tpaVar);
            g(tpaVar, cqaVar);
            if (cqaVar.g == 0 && !cqaVar.j) {
                return;
            }
            if (!cqaVar.i && !cqaVar.j) {
                cqaVar.a = 2;
            } else {
                tpa.g(tpaVar);
                if (cqaVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                cqaVar.a = i;
            }
            if (cqaVar.j) {
                return;
            }
            cqaVar.R += cqaVar.g;
            if (cqaVar.Q < cqaVar.P) {
                k(cqaVar);
            }
        }
    }

    public static int r(int[] iArr, int i, tpa tpaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, tpaVar)) == null) {
            long j = tpaVar.f;
            int i2 = tpaVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                tpaVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            tpaVar.g = i2 + (iArr[i7] >> 16) + 8;
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
