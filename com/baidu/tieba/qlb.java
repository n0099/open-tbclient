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
public final class qlb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948097090, "Lcom/baidu/tieba/qlb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948097090, "Lcom/baidu/tieba/qlb;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(wlb wlbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, wlbVar) == null) {
            nlb nlbVar = wlbVar.c;
            byte[] bArr = wlbVar.d;
            int i = wlbVar.g;
            if (i <= 0) {
                nlb.k(nlbVar);
                wlbVar.a = 1;
                return;
            }
            int min = Math.min(wlbVar.Q - wlbVar.r, i);
            nlb.c(nlbVar, bArr, wlbVar.r, min);
            wlbVar.g -= min;
            int i2 = wlbVar.r + min;
            wlbVar.r = i2;
            int i3 = wlbVar.Q;
            if (i2 == i3) {
                wlbVar.b = 5;
                wlbVar.Y = i3;
                wlbVar.X = 0;
                wlbVar.a = 12;
                return;
            }
            nlb.k(nlbVar);
            wlbVar.a = 1;
        }
    }

    public static void k(wlb wlbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, wlbVar) == null) {
            int i2 = wlbVar.P;
            long j = wlbVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + wlbVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!wlbVar.h && i2 < 16384 && wlbVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = wlbVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = wlbVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = wlbVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = wlbVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(wlbVar.S, i, bArr, 0, i5);
                    wlbVar.r = i5;
                    wlbVar.f1186T = i5;
                }
            }
            wlbVar.d = bArr;
            wlbVar.Q = i2;
        }
    }

    public static boolean u(wlb wlbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, wlbVar)) == null) {
            int i = wlbVar.f1186T;
            if (i != 0) {
                wlbVar.X += i;
                wlbVar.f1186T = 0;
            }
            int min = Math.min(wlbVar.V - wlbVar.W, wlbVar.Y - wlbVar.X);
            if (min != 0) {
                System.arraycopy(wlbVar.d, wlbVar.X, wlbVar.Z, wlbVar.U + wlbVar.W, min);
                wlbVar.W += min;
                wlbVar.X += min;
            }
            if (wlbVar.W >= wlbVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(wlb wlbVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, wlbVar, i) == null) {
            nlb nlbVar = wlbVar.c;
            int[] iArr = wlbVar.p;
            int i3 = i * 2;
            nlb.d(nlbVar);
            int i4 = i * 1080;
            int r = r(wlbVar.e, i4, nlbVar);
            wlbVar.n[i] = m(wlbVar.f, i4, nlbVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = wlbVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(wlb wlbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, wlbVar) == null) {
            b(wlbVar, 1);
            wlbVar.F = wlbVar.l.c[wlbVar.p[3]];
        }
    }

    public static void e(wlb wlbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, wlbVar) == null) {
            b(wlbVar, 2);
            wlbVar.C = wlbVar.p[5] << 2;
        }
    }

    public static int h(nlb nlbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, nlbVar)) == null) {
            if (nlb.i(nlbVar, 1) != 0) {
                int i = nlb.i(nlbVar, 3);
                if (i == 0) {
                    return 1;
                }
                return nlb.i(nlbVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, nlb nlbVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, nlbVar)) == null) {
            nlb.j(nlbVar);
            int h = h(nlbVar) + 1;
            if (h == 1) {
                ylb.a(bArr, 0, i);
                return h;
            }
            if (nlb.i(nlbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = nlb.i(nlbVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, nlbVar);
            int i3 = 0;
            while (i3 < i) {
                nlb.j(nlbVar);
                nlb.d(nlbVar);
                int r = r(iArr, 0, nlbVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + nlb.i(nlbVar, r); i4 != 0; i4--) {
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
            if (nlb.i(nlbVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(wlb wlbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, wlbVar) == null) {
            b(wlbVar, 0);
            int i = wlbVar.p[1];
            int i2 = i << 6;
            wlbVar.B = i2;
            int i3 = wlbVar.A[i2] & 255;
            wlbVar.v = i3;
            wlbVar.w = wlbVar.k.c[i3];
            byte b2 = wlbVar.z[i];
            int[] iArr = plb.b;
            wlbVar.D = iArr[b2];
            wlbVar.E = iArr[b2 + 1];
        }
    }

    public static void g(nlb nlbVar, wlb wlbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, nlbVar, wlbVar) == null) {
            boolean z2 = true;
            if (nlb.i(nlbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            wlbVar.h = z;
            wlbVar.g = 0;
            wlbVar.i = false;
            wlbVar.j = false;
            if (z && nlb.i(nlbVar, 1) != 0) {
                return;
            }
            int i = nlb.i(nlbVar, 2) + 4;
            if (i == 7) {
                wlbVar.j = true;
                if (nlb.i(nlbVar, 1) == 0) {
                    int i2 = nlb.i(nlbVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = nlb.i(nlbVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        wlbVar.g = (i4 << (i3 * 8)) | wlbVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = nlb.i(nlbVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    wlbVar.g = (i6 << (i5 * 4)) | wlbVar.g;
                }
            }
            wlbVar.g++;
            if (!wlbVar.h) {
                if (nlb.i(nlbVar, 1) != 1) {
                    z2 = false;
                }
                wlbVar.i = z2;
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
    public static void i(wlb wlbVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, wlbVar) == null) {
            int i8 = wlbVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    nlb nlbVar = wlbVar.c;
                    int i9 = wlbVar.Q - 1;
                    byte[] bArr = wlbVar.d;
                    while (true) {
                        int i10 = wlbVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (wlbVar.g >= 0) {
                                            q(wlbVar);
                                            i9 = wlbVar.Q - 1;
                                            bArr = wlbVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(wlbVar);
                                        wlbVar.a = 3;
                                        if (wlbVar.g > 0) {
                                            wlbVar.a = 1;
                                            break;
                                        } else {
                                            nlb.j(nlbVar);
                                            if (wlbVar.n[1] == 0) {
                                                c(wlbVar);
                                            }
                                            int[] iArr = wlbVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            nlb.d(nlbVar);
                                            int r = r(wlbVar.l.b, wlbVar.F, nlbVar);
                                            int i12 = r >>> 6;
                                            wlbVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                wlbVar.G = -1;
                                            }
                                            int i13 = vlb.g[i12] + ((r >>> 3) & 7);
                                            int i14 = vlb.h[i12] + (r & 7);
                                            wlbVar.y = vlb.c[i13] + nlb.i(nlbVar, vlb.d[i13]);
                                            wlbVar.M = vlb.e[i14] + nlb.i(nlbVar, vlb.f[i14]);
                                            wlbVar.x = 0;
                                            wlbVar.a = 6;
                                            if (wlbVar.u) {
                                                int i15 = wlbVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (wlbVar.x < wlbVar.y) {
                                                        nlb.j(nlbVar);
                                                        if (wlbVar.n[0] == 0) {
                                                            f(wlbVar);
                                                        }
                                                        byte[] bArr2 = wlbVar.A;
                                                        int i18 = wlbVar.B;
                                                        int[] iArr2 = plb.a;
                                                        int i19 = iArr2[wlbVar.D + i16];
                                                        int[] iArr3 = wlbVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        nlb.d(nlbVar);
                                                        tlb tlbVar = wlbVar.k;
                                                        int r2 = r(tlbVar.b, tlbVar.c[bArr2[i18 + (iArr2[wlbVar.E + i17] | i19)] & 255], nlbVar);
                                                        int i20 = wlbVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        wlbVar.x++;
                                                        wlbVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            wlbVar.b = 6;
                                                            wlbVar.Y = wlbVar.Q;
                                                            wlbVar.X = 0;
                                                            wlbVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (wlbVar.x < wlbVar.y) {
                                                        nlb.j(nlbVar);
                                                        if (wlbVar.n[0] == 0) {
                                                            f(wlbVar);
                                                        }
                                                        int[] iArr4 = wlbVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        nlb.d(nlbVar);
                                                        bArr[wlbVar.r] = (byte) r(wlbVar.k.b, wlbVar.w, nlbVar);
                                                        wlbVar.x++;
                                                        int i22 = wlbVar.r;
                                                        wlbVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            wlbVar.b = 6;
                                                            wlbVar.Y = wlbVar.Q;
                                                            wlbVar.X = 0;
                                                            wlbVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (wlbVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = wlbVar.g - wlbVar.y;
                                                wlbVar.g = i23;
                                                if (i23 <= 0) {
                                                    wlbVar.a = 3;
                                                    break;
                                                } else {
                                                    if (wlbVar.G < 0) {
                                                        nlb.j(nlbVar);
                                                        if (wlbVar.n[2] == 0) {
                                                            e(wlbVar);
                                                        }
                                                        int[] iArr5 = wlbVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        nlb.d(nlbVar);
                                                        tlb tlbVar2 = wlbVar.m;
                                                        int[] iArr6 = tlbVar2.b;
                                                        int[] iArr7 = tlbVar2.c;
                                                        byte[] bArr3 = wlbVar.H;
                                                        int i24 = wlbVar.C;
                                                        int i25 = wlbVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], nlbVar);
                                                        wlbVar.G = r3;
                                                        int i26 = wlbVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            wlbVar.G = i27;
                                                            int i28 = wlbVar.J & i27;
                                                            int i29 = i27 >>> wlbVar.K;
                                                            wlbVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            wlbVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + nlb.i(nlbVar, i30)) << wlbVar.K);
                                                        }
                                                    }
                                                    int t = t(wlbVar.G, wlbVar.q, wlbVar.t);
                                                    wlbVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = wlbVar.s;
                                                        int i32 = wlbVar.O;
                                                        if (i31 != i32 && (i6 = wlbVar.r) < i32) {
                                                            wlbVar.s = i6;
                                                        } else {
                                                            wlbVar.s = wlbVar.O;
                                                        }
                                                        wlbVar.N = wlbVar.r;
                                                        int i33 = wlbVar.L;
                                                        if (i33 > wlbVar.s) {
                                                            wlbVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (wlbVar.G > 0) {
                                                                int[] iArr8 = wlbVar.q;
                                                                int i34 = wlbVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                wlbVar.t = i34 + 1;
                                                            }
                                                            if (wlbVar.M <= wlbVar.g) {
                                                                wlbVar.x = 0;
                                                                wlbVar.a = 7;
                                                                int i35 = wlbVar.r;
                                                                i = (i35 - wlbVar.L) & i9;
                                                                i2 = wlbVar.M - wlbVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    wlbVar.x += i2;
                                                                    wlbVar.g -= i2;
                                                                    wlbVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = wlbVar.x;
                                                                        if (i3 >= wlbVar.M) {
                                                                            i4 = wlbVar.r;
                                                                            bArr[i4] = bArr[(i4 - wlbVar.L) & i9];
                                                                            wlbVar.g--;
                                                                            wlbVar.x = i3 + 1;
                                                                            wlbVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    wlbVar.b = 7;
                                                                    wlbVar.Y = wlbVar.Q;
                                                                    wlbVar.X = 0;
                                                                    wlbVar.a = 12;
                                                                    if (wlbVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        wlbVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (wlbVar.a != i5) {
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
                                        if (wlbVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (wlbVar.g > 0) {
                                            nlb.j(nlbVar);
                                            nlb.i(nlbVar, 8);
                                            wlbVar.g--;
                                        }
                                        wlbVar.a = 1;
                                        break;
                                    case 5:
                                        a(wlbVar);
                                        break;
                                    case 6:
                                        if (wlbVar.u) {
                                        }
                                        if (wlbVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = wlbVar.r;
                                        i = (i352 - wlbVar.L) & i9;
                                        i2 = wlbVar.M - wlbVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = wlbVar.x;
                                            if (i3 >= wlbVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        wlbVar.b = 7;
                                        wlbVar.Y = wlbVar.Q;
                                        wlbVar.X = 0;
                                        wlbVar.a = 12;
                                        if (wlbVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = wlbVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, wlbVar.N - i36);
                                        wlbVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = wlbVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = rlb.a[i37];
                                            int i39 = (wlbVar.L - wlbVar.s) - 1;
                                            int i40 = rlb.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < xlb.d.length) {
                                                int b2 = xlb.b(bArr, wlbVar.N, rlb.a(), i43, wlbVar.M, xlb.d[i42]);
                                                int i44 = wlbVar.N + b2;
                                                wlbVar.N = i44;
                                                wlbVar.r += b2;
                                                wlbVar.g -= b2;
                                                int i45 = wlbVar.Q;
                                                if (i44 >= i45) {
                                                    wlbVar.b = 8;
                                                    wlbVar.Y = i45;
                                                    wlbVar.X = 0;
                                                    wlbVar.a = 12;
                                                    break;
                                                } else {
                                                    wlbVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + wlbVar.a);
                                }
                            } else if (!u(wlbVar)) {
                                return;
                            } else {
                                int i46 = wlbVar.r;
                                int i47 = wlbVar.O;
                                if (i46 >= i47) {
                                    wlbVar.s = i47;
                                }
                                wlbVar.r &= i9;
                                wlbVar.a = wlbVar.b;
                            }
                        } else if (i10 == 10) {
                            if (wlbVar.g >= 0) {
                                nlb.g(nlbVar);
                                nlb.a(wlbVar.c, true);
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

    public static void s(wlb wlbVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, wlbVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            wlbVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, nlb nlbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, nlbVar)) == null) {
            nlb.d(nlbVar);
            int r = r(iArr, i, nlbVar);
            return vlb.a[r] + nlb.i(nlbVar, vlb.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, nlb nlbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), nlbVar}) == null) {
            nlb.j(nlbVar);
            int[] iArr2 = new int[i];
            int i3 = nlb.i(nlbVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = nlb.i(nlbVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = nlb.i(nlbVar, i6) % i;
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
                            if (nlb.i(nlbVar, 1) == 1) {
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
                    slb.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                nlb.d(nlbVar);
                long j = nlbVar.f;
                int i11 = nlbVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                nlbVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, nlbVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.ylb.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, nlb nlbVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, nlbVar) == null) {
            int[] iArr3 = new int[32];
            slb.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    nlb.j(nlbVar);
                    nlb.d(nlbVar);
                    long j = nlbVar.f;
                    int i9 = nlbVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    nlbVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + nlb.i(nlbVar, i13) + 3;
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

    public static void p(wlb wlbVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, wlbVar) == null) {
            nlb nlbVar = wlbVar.c;
            for (int i = 0; i < 3; i++) {
                wlbVar.o[i] = h(nlbVar) + 1;
                wlbVar.n[i] = 268435456;
                int[] iArr2 = wlbVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, wlbVar.e, i2, nlbVar);
                    n(26, wlbVar.f, i2, nlbVar);
                    wlbVar.n[i] = m(wlbVar.f, i2, nlbVar);
                }
            }
            nlb.j(nlbVar);
            wlbVar.K = nlb.i(nlbVar, 2);
            int i3 = nlb.i(nlbVar, 4);
            int i4 = wlbVar.K;
            int i5 = (i3 << i4) + 16;
            wlbVar.I = i5;
            wlbVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            wlbVar.z = new byte[wlbVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = wlbVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    wlbVar.z[i7] = (byte) (nlb.i(nlbVar, 2) << 1);
                    i7++;
                }
                nlb.j(nlbVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            wlbVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, nlbVar);
            wlbVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (wlbVar.o[0] << 6)) {
                    break;
                } else if (wlbVar.A[i8] != (i8 >> 6)) {
                    wlbVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = wlbVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            wlbVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, nlbVar);
            tlb.b(wlbVar.k, 256, d2);
            tlb.b(wlbVar.l, 704, wlbVar.o[1]);
            tlb.b(wlbVar.m, i6, d3);
            tlb.a(wlbVar.k, nlbVar);
            tlb.a(wlbVar.l, nlbVar);
            tlb.a(wlbVar.m, nlbVar);
            wlbVar.B = 0;
            wlbVar.C = 0;
            int[] iArr4 = plb.b;
            byte[] bArr3 = wlbVar.z;
            wlbVar.D = iArr4[bArr3[0]];
            wlbVar.E = iArr4[bArr3[0] + 1];
            wlbVar.v = 0;
            wlbVar.w = wlbVar.k.c[0];
            wlbVar.F = wlbVar.l.c[0];
            int[] iArr5 = wlbVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(wlb wlbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, wlbVar) == null) {
            nlb nlbVar = wlbVar.c;
            if (wlbVar.h) {
                wlbVar.b = 10;
                wlbVar.Y = wlbVar.r;
                wlbVar.X = 0;
                wlbVar.a = 12;
                return;
            }
            tlb tlbVar = wlbVar.k;
            tlbVar.b = null;
            tlbVar.c = null;
            tlb tlbVar2 = wlbVar.l;
            tlbVar2.b = null;
            tlbVar2.c = null;
            tlb tlbVar3 = wlbVar.m;
            tlbVar3.b = null;
            tlbVar3.c = null;
            nlb.j(nlbVar);
            g(nlbVar, wlbVar);
            if (wlbVar.g == 0 && !wlbVar.j) {
                return;
            }
            if (!wlbVar.i && !wlbVar.j) {
                wlbVar.a = 2;
            } else {
                nlb.g(nlbVar);
                if (wlbVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                wlbVar.a = i;
            }
            if (wlbVar.j) {
                return;
            }
            wlbVar.R += wlbVar.g;
            if (wlbVar.Q < wlbVar.P) {
                k(wlbVar);
            }
        }
    }

    public static int r(int[] iArr, int i, nlb nlbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, nlbVar)) == null) {
            long j = nlbVar.f;
            int i2 = nlbVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                nlbVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            nlbVar.g = i2 + (iArr[i7] >> 16) + 8;
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
