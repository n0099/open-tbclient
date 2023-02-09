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
public final class saa {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948146070, "Lcom/baidu/tieba/saa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948146070, "Lcom/baidu/tieba/saa;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(yaa yaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, yaaVar) == null) {
            paa paaVar = yaaVar.c;
            byte[] bArr = yaaVar.d;
            int i = yaaVar.g;
            if (i <= 0) {
                paa.k(paaVar);
                yaaVar.a = 1;
                return;
            }
            int min = Math.min(yaaVar.Q - yaaVar.r, i);
            paa.c(paaVar, bArr, yaaVar.r, min);
            yaaVar.g -= min;
            int i2 = yaaVar.r + min;
            yaaVar.r = i2;
            int i3 = yaaVar.Q;
            if (i2 == i3) {
                yaaVar.b = 5;
                yaaVar.Y = i3;
                yaaVar.X = 0;
                yaaVar.a = 12;
                return;
            }
            paa.k(paaVar);
            yaaVar.a = 1;
        }
    }

    public static void k(yaa yaaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, yaaVar) == null) {
            int i2 = yaaVar.P;
            long j = yaaVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + yaaVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!yaaVar.h && i2 < 16384 && yaaVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = yaaVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = yaaVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = yaaVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = yaaVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(yaaVar.S, i, bArr, 0, i5);
                    yaaVar.r = i5;
                    yaaVar.T = i5;
                }
            }
            yaaVar.d = bArr;
            yaaVar.Q = i2;
        }
    }

    public static boolean u(yaa yaaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, yaaVar)) == null) {
            int i = yaaVar.T;
            if (i != 0) {
                yaaVar.X += i;
                yaaVar.T = 0;
            }
            int min = Math.min(yaaVar.V - yaaVar.W, yaaVar.Y - yaaVar.X);
            if (min != 0) {
                System.arraycopy(yaaVar.d, yaaVar.X, yaaVar.Z, yaaVar.U + yaaVar.W, min);
                yaaVar.W += min;
                yaaVar.X += min;
            }
            if (yaaVar.W >= yaaVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(yaa yaaVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, yaaVar, i) == null) {
            paa paaVar = yaaVar.c;
            int[] iArr = yaaVar.p;
            int i3 = i * 2;
            paa.d(paaVar);
            int i4 = i * 1080;
            int r = r(yaaVar.e, i4, paaVar);
            yaaVar.n[i] = m(yaaVar.f, i4, paaVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = yaaVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(yaa yaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, yaaVar) == null) {
            b(yaaVar, 1);
            yaaVar.F = yaaVar.l.c[yaaVar.p[3]];
        }
    }

    public static void e(yaa yaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, yaaVar) == null) {
            b(yaaVar, 2);
            yaaVar.C = yaaVar.p[5] << 2;
        }
    }

    public static int h(paa paaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, paaVar)) == null) {
            if (paa.i(paaVar, 1) != 0) {
                int i = paa.i(paaVar, 3);
                if (i == 0) {
                    return 1;
                }
                return paa.i(paaVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, paa paaVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, paaVar)) == null) {
            paa.j(paaVar);
            int h = h(paaVar) + 1;
            if (h == 1) {
                aba.a(bArr, 0, i);
                return h;
            }
            if (paa.i(paaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = paa.i(paaVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, paaVar);
            int i3 = 0;
            while (i3 < i) {
                paa.j(paaVar);
                paa.d(paaVar);
                int r = r(iArr, 0, paaVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + paa.i(paaVar, r); i4 != 0; i4--) {
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
            if (paa.i(paaVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(yaa yaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, yaaVar) == null) {
            b(yaaVar, 0);
            int i = yaaVar.p[1];
            int i2 = i << 6;
            yaaVar.B = i2;
            int i3 = yaaVar.A[i2] & 255;
            yaaVar.v = i3;
            yaaVar.w = yaaVar.k.c[i3];
            byte b2 = yaaVar.z[i];
            int[] iArr = raa.b;
            yaaVar.D = iArr[b2];
            yaaVar.E = iArr[b2 + 1];
        }
    }

    public static void g(paa paaVar, yaa yaaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, paaVar, yaaVar) == null) {
            boolean z2 = true;
            if (paa.i(paaVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            yaaVar.h = z;
            yaaVar.g = 0;
            yaaVar.i = false;
            yaaVar.j = false;
            if (z && paa.i(paaVar, 1) != 0) {
                return;
            }
            int i = paa.i(paaVar, 2) + 4;
            if (i == 7) {
                yaaVar.j = true;
                if (paa.i(paaVar, 1) == 0) {
                    int i2 = paa.i(paaVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = paa.i(paaVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        yaaVar.g = (i4 << (i3 * 8)) | yaaVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = paa.i(paaVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    yaaVar.g = (i6 << (i5 * 4)) | yaaVar.g;
                }
            }
            yaaVar.g++;
            if (!yaaVar.h) {
                if (paa.i(paaVar, 1) != 1) {
                    z2 = false;
                }
                yaaVar.i = z2;
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
    public static void i(yaa yaaVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, yaaVar) == null) {
            int i8 = yaaVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    paa paaVar = yaaVar.c;
                    int i9 = yaaVar.Q - 1;
                    byte[] bArr = yaaVar.d;
                    while (true) {
                        int i10 = yaaVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (yaaVar.g >= 0) {
                                            q(yaaVar);
                                            i9 = yaaVar.Q - 1;
                                            bArr = yaaVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(yaaVar);
                                        yaaVar.a = 3;
                                        if (yaaVar.g > 0) {
                                            yaaVar.a = 1;
                                            break;
                                        } else {
                                            paa.j(paaVar);
                                            if (yaaVar.n[1] == 0) {
                                                c(yaaVar);
                                            }
                                            int[] iArr = yaaVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            paa.d(paaVar);
                                            int r = r(yaaVar.l.b, yaaVar.F, paaVar);
                                            int i12 = r >>> 6;
                                            yaaVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                yaaVar.G = -1;
                                            }
                                            int i13 = xaa.g[i12] + ((r >>> 3) & 7);
                                            int i14 = xaa.h[i12] + (r & 7);
                                            yaaVar.y = xaa.c[i13] + paa.i(paaVar, xaa.d[i13]);
                                            yaaVar.M = xaa.e[i14] + paa.i(paaVar, xaa.f[i14]);
                                            yaaVar.x = 0;
                                            yaaVar.a = 6;
                                            if (yaaVar.u) {
                                                int i15 = yaaVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (yaaVar.x < yaaVar.y) {
                                                        paa.j(paaVar);
                                                        if (yaaVar.n[0] == 0) {
                                                            f(yaaVar);
                                                        }
                                                        byte[] bArr2 = yaaVar.A;
                                                        int i18 = yaaVar.B;
                                                        int[] iArr2 = raa.a;
                                                        int i19 = iArr2[yaaVar.D + i16];
                                                        int[] iArr3 = yaaVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        paa.d(paaVar);
                                                        vaa vaaVar = yaaVar.k;
                                                        int r2 = r(vaaVar.b, vaaVar.c[bArr2[i18 + (iArr2[yaaVar.E + i17] | i19)] & 255], paaVar);
                                                        int i20 = yaaVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        yaaVar.x++;
                                                        yaaVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            yaaVar.b = 6;
                                                            yaaVar.Y = yaaVar.Q;
                                                            yaaVar.X = 0;
                                                            yaaVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (yaaVar.x < yaaVar.y) {
                                                        paa.j(paaVar);
                                                        if (yaaVar.n[0] == 0) {
                                                            f(yaaVar);
                                                        }
                                                        int[] iArr4 = yaaVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        paa.d(paaVar);
                                                        bArr[yaaVar.r] = (byte) r(yaaVar.k.b, yaaVar.w, paaVar);
                                                        yaaVar.x++;
                                                        int i22 = yaaVar.r;
                                                        yaaVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            yaaVar.b = 6;
                                                            yaaVar.Y = yaaVar.Q;
                                                            yaaVar.X = 0;
                                                            yaaVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (yaaVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = yaaVar.g - yaaVar.y;
                                                yaaVar.g = i23;
                                                if (i23 <= 0) {
                                                    yaaVar.a = 3;
                                                    break;
                                                } else {
                                                    if (yaaVar.G < 0) {
                                                        paa.j(paaVar);
                                                        if (yaaVar.n[2] == 0) {
                                                            e(yaaVar);
                                                        }
                                                        int[] iArr5 = yaaVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        paa.d(paaVar);
                                                        vaa vaaVar2 = yaaVar.m;
                                                        int[] iArr6 = vaaVar2.b;
                                                        int[] iArr7 = vaaVar2.c;
                                                        byte[] bArr3 = yaaVar.H;
                                                        int i24 = yaaVar.C;
                                                        int i25 = yaaVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], paaVar);
                                                        yaaVar.G = r3;
                                                        int i26 = yaaVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            yaaVar.G = i27;
                                                            int i28 = yaaVar.J & i27;
                                                            int i29 = i27 >>> yaaVar.K;
                                                            yaaVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            yaaVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + paa.i(paaVar, i30)) << yaaVar.K);
                                                        }
                                                    }
                                                    int t = t(yaaVar.G, yaaVar.q, yaaVar.t);
                                                    yaaVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = yaaVar.s;
                                                        int i32 = yaaVar.O;
                                                        if (i31 != i32 && (i6 = yaaVar.r) < i32) {
                                                            yaaVar.s = i6;
                                                        } else {
                                                            yaaVar.s = yaaVar.O;
                                                        }
                                                        yaaVar.N = yaaVar.r;
                                                        int i33 = yaaVar.L;
                                                        if (i33 > yaaVar.s) {
                                                            yaaVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (yaaVar.G > 0) {
                                                                int[] iArr8 = yaaVar.q;
                                                                int i34 = yaaVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                yaaVar.t = i34 + 1;
                                                            }
                                                            if (yaaVar.M <= yaaVar.g) {
                                                                yaaVar.x = 0;
                                                                yaaVar.a = 7;
                                                                int i35 = yaaVar.r;
                                                                i = (i35 - yaaVar.L) & i9;
                                                                i2 = yaaVar.M - yaaVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    yaaVar.x += i2;
                                                                    yaaVar.g -= i2;
                                                                    yaaVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = yaaVar.x;
                                                                        if (i3 >= yaaVar.M) {
                                                                            i4 = yaaVar.r;
                                                                            bArr[i4] = bArr[(i4 - yaaVar.L) & i9];
                                                                            yaaVar.g--;
                                                                            yaaVar.x = i3 + 1;
                                                                            yaaVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    yaaVar.b = 7;
                                                                    yaaVar.Y = yaaVar.Q;
                                                                    yaaVar.X = 0;
                                                                    yaaVar.a = 12;
                                                                    if (yaaVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        yaaVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (yaaVar.a != i5) {
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
                                        if (yaaVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (yaaVar.g > 0) {
                                            paa.j(paaVar);
                                            paa.i(paaVar, 8);
                                            yaaVar.g--;
                                        }
                                        yaaVar.a = 1;
                                        break;
                                    case 5:
                                        a(yaaVar);
                                        break;
                                    case 6:
                                        if (yaaVar.u) {
                                        }
                                        if (yaaVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = yaaVar.r;
                                        i = (i352 - yaaVar.L) & i9;
                                        i2 = yaaVar.M - yaaVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = yaaVar.x;
                                            if (i3 >= yaaVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        yaaVar.b = 7;
                                        yaaVar.Y = yaaVar.Q;
                                        yaaVar.X = 0;
                                        yaaVar.a = 12;
                                        if (yaaVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = yaaVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, yaaVar.N - i36);
                                        yaaVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = yaaVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = taa.a[i37];
                                            int i39 = (yaaVar.L - yaaVar.s) - 1;
                                            int i40 = taa.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < zaa.d.length) {
                                                int b2 = zaa.b(bArr, yaaVar.N, taa.a(), i43, yaaVar.M, zaa.d[i42]);
                                                int i44 = yaaVar.N + b2;
                                                yaaVar.N = i44;
                                                yaaVar.r += b2;
                                                yaaVar.g -= b2;
                                                int i45 = yaaVar.Q;
                                                if (i44 >= i45) {
                                                    yaaVar.b = 8;
                                                    yaaVar.Y = i45;
                                                    yaaVar.X = 0;
                                                    yaaVar.a = 12;
                                                    break;
                                                } else {
                                                    yaaVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + yaaVar.a);
                                }
                            } else if (!u(yaaVar)) {
                                return;
                            } else {
                                int i46 = yaaVar.r;
                                int i47 = yaaVar.O;
                                if (i46 >= i47) {
                                    yaaVar.s = i47;
                                }
                                yaaVar.r &= i9;
                                yaaVar.a = yaaVar.b;
                            }
                        } else if (i10 == 10) {
                            if (yaaVar.g >= 0) {
                                paa.g(paaVar);
                                paa.a(yaaVar.c, true);
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

    public static void s(yaa yaaVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, yaaVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            yaaVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, paa paaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, paaVar)) == null) {
            paa.d(paaVar);
            int r = r(iArr, i, paaVar);
            return xaa.a[r] + paa.i(paaVar, xaa.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, paa paaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), paaVar}) == null) {
            paa.j(paaVar);
            int[] iArr2 = new int[i];
            int i3 = paa.i(paaVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = paa.i(paaVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = paa.i(paaVar, i6) % i;
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
                            if (paa.i(paaVar, 1) == 1) {
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
                    uaa.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                paa.d(paaVar);
                long j = paaVar.f;
                int i11 = paaVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                paaVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, paaVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.aba.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, paa paaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, paaVar) == null) {
            int[] iArr3 = new int[32];
            uaa.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    paa.j(paaVar);
                    paa.d(paaVar);
                    long j = paaVar.f;
                    int i9 = paaVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    paaVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + paa.i(paaVar, i13) + 3;
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

    public static void p(yaa yaaVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, yaaVar) == null) {
            paa paaVar = yaaVar.c;
            for (int i = 0; i < 3; i++) {
                yaaVar.o[i] = h(paaVar) + 1;
                yaaVar.n[i] = 268435456;
                int[] iArr2 = yaaVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, yaaVar.e, i2, paaVar);
                    n(26, yaaVar.f, i2, paaVar);
                    yaaVar.n[i] = m(yaaVar.f, i2, paaVar);
                }
            }
            paa.j(paaVar);
            yaaVar.K = paa.i(paaVar, 2);
            int i3 = paa.i(paaVar, 4);
            int i4 = yaaVar.K;
            int i5 = (i3 << i4) + 16;
            yaaVar.I = i5;
            yaaVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            yaaVar.z = new byte[yaaVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = yaaVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    yaaVar.z[i7] = (byte) (paa.i(paaVar, 2) << 1);
                    i7++;
                }
                paa.j(paaVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            yaaVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, paaVar);
            yaaVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (yaaVar.o[0] << 6)) {
                    break;
                } else if (yaaVar.A[i8] != (i8 >> 6)) {
                    yaaVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = yaaVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            yaaVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, paaVar);
            vaa.b(yaaVar.k, 256, d2);
            vaa.b(yaaVar.l, 704, yaaVar.o[1]);
            vaa.b(yaaVar.m, i6, d3);
            vaa.a(yaaVar.k, paaVar);
            vaa.a(yaaVar.l, paaVar);
            vaa.a(yaaVar.m, paaVar);
            yaaVar.B = 0;
            yaaVar.C = 0;
            int[] iArr4 = raa.b;
            byte[] bArr3 = yaaVar.z;
            yaaVar.D = iArr4[bArr3[0]];
            yaaVar.E = iArr4[bArr3[0] + 1];
            yaaVar.v = 0;
            yaaVar.w = yaaVar.k.c[0];
            yaaVar.F = yaaVar.l.c[0];
            int[] iArr5 = yaaVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(yaa yaaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, yaaVar) == null) {
            paa paaVar = yaaVar.c;
            if (yaaVar.h) {
                yaaVar.b = 10;
                yaaVar.Y = yaaVar.r;
                yaaVar.X = 0;
                yaaVar.a = 12;
                return;
            }
            vaa vaaVar = yaaVar.k;
            vaaVar.b = null;
            vaaVar.c = null;
            vaa vaaVar2 = yaaVar.l;
            vaaVar2.b = null;
            vaaVar2.c = null;
            vaa vaaVar3 = yaaVar.m;
            vaaVar3.b = null;
            vaaVar3.c = null;
            paa.j(paaVar);
            g(paaVar, yaaVar);
            if (yaaVar.g == 0 && !yaaVar.j) {
                return;
            }
            if (!yaaVar.i && !yaaVar.j) {
                yaaVar.a = 2;
            } else {
                paa.g(paaVar);
                if (yaaVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                yaaVar.a = i;
            }
            if (yaaVar.j) {
                return;
            }
            yaaVar.R += yaaVar.g;
            if (yaaVar.Q < yaaVar.P) {
                k(yaaVar);
            }
        }
    }

    public static int r(int[] iArr, int i, paa paaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, paaVar)) == null) {
            long j = paaVar.f;
            int i2 = paaVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                paaVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            paaVar.g = i2 + (iArr[i7] >> 16) + 8;
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
