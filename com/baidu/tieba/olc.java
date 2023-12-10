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
public final class olc {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948037539, "Lcom/baidu/tieba/olc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948037539, "Lcom/baidu/tieba/olc;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(ulc ulcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ulcVar) == null) {
            llc llcVar = ulcVar.c;
            byte[] bArr = ulcVar.d;
            int i = ulcVar.g;
            if (i <= 0) {
                llc.k(llcVar);
                ulcVar.a = 1;
                return;
            }
            int min = Math.min(ulcVar.Q - ulcVar.r, i);
            llc.c(llcVar, bArr, ulcVar.r, min);
            ulcVar.g -= min;
            int i2 = ulcVar.r + min;
            ulcVar.r = i2;
            int i3 = ulcVar.Q;
            if (i2 == i3) {
                ulcVar.b = 5;
                ulcVar.Y = i3;
                ulcVar.X = 0;
                ulcVar.a = 12;
                return;
            }
            llc.k(llcVar);
            ulcVar.a = 1;
        }
    }

    public static void k(ulc ulcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, ulcVar) == null) {
            int i2 = ulcVar.P;
            long j = ulcVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + ulcVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!ulcVar.h && i2 < 16384 && ulcVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = ulcVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = ulcVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = ulcVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = ulcVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(ulcVar.S, i, bArr, 0, i5);
                    ulcVar.r = i5;
                    ulcVar.f1160T = i5;
                }
            }
            ulcVar.d = bArr;
            ulcVar.Q = i2;
        }
    }

    public static boolean u(ulc ulcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, ulcVar)) == null) {
            int i = ulcVar.f1160T;
            if (i != 0) {
                ulcVar.X += i;
                ulcVar.f1160T = 0;
            }
            int min = Math.min(ulcVar.V - ulcVar.W, ulcVar.Y - ulcVar.X);
            if (min != 0) {
                System.arraycopy(ulcVar.d, ulcVar.X, ulcVar.Z, ulcVar.U + ulcVar.W, min);
                ulcVar.W += min;
                ulcVar.X += min;
            }
            if (ulcVar.W >= ulcVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(ulc ulcVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, ulcVar, i) == null) {
            llc llcVar = ulcVar.c;
            int[] iArr = ulcVar.p;
            int i3 = i * 2;
            llc.d(llcVar);
            int i4 = i * 1080;
            int r = r(ulcVar.e, i4, llcVar);
            ulcVar.n[i] = m(ulcVar.f, i4, llcVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = ulcVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(ulc ulcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ulcVar) == null) {
            b(ulcVar, 1);
            ulcVar.F = ulcVar.l.c[ulcVar.p[3]];
        }
    }

    public static void e(ulc ulcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ulcVar) == null) {
            b(ulcVar, 2);
            ulcVar.C = ulcVar.p[5] << 2;
        }
    }

    public static int h(llc llcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, llcVar)) == null) {
            if (llc.i(llcVar, 1) != 0) {
                int i = llc.i(llcVar, 3);
                if (i == 0) {
                    return 1;
                }
                return llc.i(llcVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, llc llcVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, llcVar)) == null) {
            llc.j(llcVar);
            int h = h(llcVar) + 1;
            if (h == 1) {
                wlc.a(bArr, 0, i);
                return h;
            }
            if (llc.i(llcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = llc.i(llcVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, llcVar);
            int i3 = 0;
            while (i3 < i) {
                llc.j(llcVar);
                llc.d(llcVar);
                int r = r(iArr, 0, llcVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + llc.i(llcVar, r); i4 != 0; i4--) {
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
            if (llc.i(llcVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(ulc ulcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, ulcVar) == null) {
            b(ulcVar, 0);
            int i = ulcVar.p[1];
            int i2 = i << 6;
            ulcVar.B = i2;
            int i3 = ulcVar.A[i2] & 255;
            ulcVar.v = i3;
            ulcVar.w = ulcVar.k.c[i3];
            byte b2 = ulcVar.z[i];
            int[] iArr = nlc.b;
            ulcVar.D = iArr[b2];
            ulcVar.E = iArr[b2 + 1];
        }
    }

    public static void g(llc llcVar, ulc ulcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, llcVar, ulcVar) == null) {
            boolean z2 = true;
            if (llc.i(llcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            ulcVar.h = z;
            ulcVar.g = 0;
            ulcVar.i = false;
            ulcVar.j = false;
            if (z && llc.i(llcVar, 1) != 0) {
                return;
            }
            int i = llc.i(llcVar, 2) + 4;
            if (i == 7) {
                ulcVar.j = true;
                if (llc.i(llcVar, 1) == 0) {
                    int i2 = llc.i(llcVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = llc.i(llcVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        ulcVar.g = (i4 << (i3 * 8)) | ulcVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = llc.i(llcVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    ulcVar.g = (i6 << (i5 * 4)) | ulcVar.g;
                }
            }
            ulcVar.g++;
            if (!ulcVar.h) {
                if (llc.i(llcVar, 1) != 1) {
                    z2 = false;
                }
                ulcVar.i = z2;
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
    public static void i(ulc ulcVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ulcVar) == null) {
            int i8 = ulcVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    llc llcVar = ulcVar.c;
                    int i9 = ulcVar.Q - 1;
                    byte[] bArr = ulcVar.d;
                    while (true) {
                        int i10 = ulcVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (ulcVar.g >= 0) {
                                            q(ulcVar);
                                            i9 = ulcVar.Q - 1;
                                            bArr = ulcVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(ulcVar);
                                        ulcVar.a = 3;
                                        if (ulcVar.g > 0) {
                                            ulcVar.a = 1;
                                            break;
                                        } else {
                                            llc.j(llcVar);
                                            if (ulcVar.n[1] == 0) {
                                                c(ulcVar);
                                            }
                                            int[] iArr = ulcVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            llc.d(llcVar);
                                            int r = r(ulcVar.l.b, ulcVar.F, llcVar);
                                            int i12 = r >>> 6;
                                            ulcVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                ulcVar.G = -1;
                                            }
                                            int i13 = tlc.g[i12] + ((r >>> 3) & 7);
                                            int i14 = tlc.h[i12] + (r & 7);
                                            ulcVar.y = tlc.c[i13] + llc.i(llcVar, tlc.d[i13]);
                                            ulcVar.M = tlc.e[i14] + llc.i(llcVar, tlc.f[i14]);
                                            ulcVar.x = 0;
                                            ulcVar.a = 6;
                                            if (ulcVar.u) {
                                                int i15 = ulcVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (ulcVar.x < ulcVar.y) {
                                                        llc.j(llcVar);
                                                        if (ulcVar.n[0] == 0) {
                                                            f(ulcVar);
                                                        }
                                                        byte[] bArr2 = ulcVar.A;
                                                        int i18 = ulcVar.B;
                                                        int[] iArr2 = nlc.a;
                                                        int i19 = iArr2[ulcVar.D + i16];
                                                        int[] iArr3 = ulcVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        llc.d(llcVar);
                                                        rlc rlcVar = ulcVar.k;
                                                        int r2 = r(rlcVar.b, rlcVar.c[bArr2[i18 + (iArr2[ulcVar.E + i17] | i19)] & 255], llcVar);
                                                        int i20 = ulcVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        ulcVar.x++;
                                                        ulcVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            ulcVar.b = 6;
                                                            ulcVar.Y = ulcVar.Q;
                                                            ulcVar.X = 0;
                                                            ulcVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (ulcVar.x < ulcVar.y) {
                                                        llc.j(llcVar);
                                                        if (ulcVar.n[0] == 0) {
                                                            f(ulcVar);
                                                        }
                                                        int[] iArr4 = ulcVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        llc.d(llcVar);
                                                        bArr[ulcVar.r] = (byte) r(ulcVar.k.b, ulcVar.w, llcVar);
                                                        ulcVar.x++;
                                                        int i22 = ulcVar.r;
                                                        ulcVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            ulcVar.b = 6;
                                                            ulcVar.Y = ulcVar.Q;
                                                            ulcVar.X = 0;
                                                            ulcVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (ulcVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = ulcVar.g - ulcVar.y;
                                                ulcVar.g = i23;
                                                if (i23 <= 0) {
                                                    ulcVar.a = 3;
                                                    break;
                                                } else {
                                                    if (ulcVar.G < 0) {
                                                        llc.j(llcVar);
                                                        if (ulcVar.n[2] == 0) {
                                                            e(ulcVar);
                                                        }
                                                        int[] iArr5 = ulcVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        llc.d(llcVar);
                                                        rlc rlcVar2 = ulcVar.m;
                                                        int[] iArr6 = rlcVar2.b;
                                                        int[] iArr7 = rlcVar2.c;
                                                        byte[] bArr3 = ulcVar.H;
                                                        int i24 = ulcVar.C;
                                                        int i25 = ulcVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], llcVar);
                                                        ulcVar.G = r3;
                                                        int i26 = ulcVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            ulcVar.G = i27;
                                                            int i28 = ulcVar.J & i27;
                                                            int i29 = i27 >>> ulcVar.K;
                                                            ulcVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            ulcVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + llc.i(llcVar, i30)) << ulcVar.K);
                                                        }
                                                    }
                                                    int t = t(ulcVar.G, ulcVar.q, ulcVar.t);
                                                    ulcVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = ulcVar.s;
                                                        int i32 = ulcVar.O;
                                                        if (i31 != i32 && (i6 = ulcVar.r) < i32) {
                                                            ulcVar.s = i6;
                                                        } else {
                                                            ulcVar.s = ulcVar.O;
                                                        }
                                                        ulcVar.N = ulcVar.r;
                                                        int i33 = ulcVar.L;
                                                        if (i33 > ulcVar.s) {
                                                            ulcVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (ulcVar.G > 0) {
                                                                int[] iArr8 = ulcVar.q;
                                                                int i34 = ulcVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                ulcVar.t = i34 + 1;
                                                            }
                                                            if (ulcVar.M <= ulcVar.g) {
                                                                ulcVar.x = 0;
                                                                ulcVar.a = 7;
                                                                int i35 = ulcVar.r;
                                                                i = (i35 - ulcVar.L) & i9;
                                                                i2 = ulcVar.M - ulcVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    ulcVar.x += i2;
                                                                    ulcVar.g -= i2;
                                                                    ulcVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = ulcVar.x;
                                                                        if (i3 >= ulcVar.M) {
                                                                            i4 = ulcVar.r;
                                                                            bArr[i4] = bArr[(i4 - ulcVar.L) & i9];
                                                                            ulcVar.g--;
                                                                            ulcVar.x = i3 + 1;
                                                                            ulcVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    ulcVar.b = 7;
                                                                    ulcVar.Y = ulcVar.Q;
                                                                    ulcVar.X = 0;
                                                                    ulcVar.a = 12;
                                                                    if (ulcVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        ulcVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (ulcVar.a != i5) {
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
                                        if (ulcVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (ulcVar.g > 0) {
                                            llc.j(llcVar);
                                            llc.i(llcVar, 8);
                                            ulcVar.g--;
                                        }
                                        ulcVar.a = 1;
                                        break;
                                    case 5:
                                        a(ulcVar);
                                        break;
                                    case 6:
                                        if (ulcVar.u) {
                                        }
                                        if (ulcVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = ulcVar.r;
                                        i = (i352 - ulcVar.L) & i9;
                                        i2 = ulcVar.M - ulcVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = ulcVar.x;
                                            if (i3 >= ulcVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        ulcVar.b = 7;
                                        ulcVar.Y = ulcVar.Q;
                                        ulcVar.X = 0;
                                        ulcVar.a = 12;
                                        if (ulcVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = ulcVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, ulcVar.N - i36);
                                        ulcVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = ulcVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = plc.a[i37];
                                            int i39 = (ulcVar.L - ulcVar.s) - 1;
                                            int i40 = plc.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < vlc.d.length) {
                                                int b2 = vlc.b(bArr, ulcVar.N, plc.a(), i43, ulcVar.M, vlc.d[i42]);
                                                int i44 = ulcVar.N + b2;
                                                ulcVar.N = i44;
                                                ulcVar.r += b2;
                                                ulcVar.g -= b2;
                                                int i45 = ulcVar.Q;
                                                if (i44 >= i45) {
                                                    ulcVar.b = 8;
                                                    ulcVar.Y = i45;
                                                    ulcVar.X = 0;
                                                    ulcVar.a = 12;
                                                    break;
                                                } else {
                                                    ulcVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + ulcVar.a);
                                }
                            } else if (!u(ulcVar)) {
                                return;
                            } else {
                                int i46 = ulcVar.r;
                                int i47 = ulcVar.O;
                                if (i46 >= i47) {
                                    ulcVar.s = i47;
                                }
                                ulcVar.r &= i9;
                                ulcVar.a = ulcVar.b;
                            }
                        } else if (i10 == 10) {
                            if (ulcVar.g >= 0) {
                                llc.g(llcVar);
                                llc.a(ulcVar.c, true);
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

    public static void s(ulc ulcVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, ulcVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            ulcVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, llc llcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, llcVar)) == null) {
            llc.d(llcVar);
            int r = r(iArr, i, llcVar);
            return tlc.a[r] + llc.i(llcVar, tlc.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, llc llcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), llcVar}) == null) {
            llc.j(llcVar);
            int[] iArr2 = new int[i];
            int i3 = llc.i(llcVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = llc.i(llcVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = llc.i(llcVar, i6) % i;
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
                            if (llc.i(llcVar, 1) == 1) {
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
                    qlc.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                llc.d(llcVar);
                long j = llcVar.f;
                int i11 = llcVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                llcVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, llcVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.wlc.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, llc llcVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, llcVar) == null) {
            int[] iArr3 = new int[32];
            qlc.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    llc.j(llcVar);
                    llc.d(llcVar);
                    long j = llcVar.f;
                    int i9 = llcVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    llcVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + llc.i(llcVar, i13) + 3;
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

    public static void p(ulc ulcVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ulcVar) == null) {
            llc llcVar = ulcVar.c;
            for (int i = 0; i < 3; i++) {
                ulcVar.o[i] = h(llcVar) + 1;
                ulcVar.n[i] = 268435456;
                int[] iArr2 = ulcVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, ulcVar.e, i2, llcVar);
                    n(26, ulcVar.f, i2, llcVar);
                    ulcVar.n[i] = m(ulcVar.f, i2, llcVar);
                }
            }
            llc.j(llcVar);
            ulcVar.K = llc.i(llcVar, 2);
            int i3 = llc.i(llcVar, 4);
            int i4 = ulcVar.K;
            int i5 = (i3 << i4) + 16;
            ulcVar.I = i5;
            ulcVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            ulcVar.z = new byte[ulcVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = ulcVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    ulcVar.z[i7] = (byte) (llc.i(llcVar, 2) << 1);
                    i7++;
                }
                llc.j(llcVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            ulcVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, llcVar);
            ulcVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (ulcVar.o[0] << 6)) {
                    break;
                } else if (ulcVar.A[i8] != (i8 >> 6)) {
                    ulcVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = ulcVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            ulcVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, llcVar);
            rlc.b(ulcVar.k, 256, d2);
            rlc.b(ulcVar.l, 704, ulcVar.o[1]);
            rlc.b(ulcVar.m, i6, d3);
            rlc.a(ulcVar.k, llcVar);
            rlc.a(ulcVar.l, llcVar);
            rlc.a(ulcVar.m, llcVar);
            ulcVar.B = 0;
            ulcVar.C = 0;
            int[] iArr4 = nlc.b;
            byte[] bArr3 = ulcVar.z;
            ulcVar.D = iArr4[bArr3[0]];
            ulcVar.E = iArr4[bArr3[0] + 1];
            ulcVar.v = 0;
            ulcVar.w = ulcVar.k.c[0];
            ulcVar.F = ulcVar.l.c[0];
            int[] iArr5 = ulcVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(ulc ulcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, ulcVar) == null) {
            llc llcVar = ulcVar.c;
            if (ulcVar.h) {
                ulcVar.b = 10;
                ulcVar.Y = ulcVar.r;
                ulcVar.X = 0;
                ulcVar.a = 12;
                return;
            }
            rlc rlcVar = ulcVar.k;
            rlcVar.b = null;
            rlcVar.c = null;
            rlc rlcVar2 = ulcVar.l;
            rlcVar2.b = null;
            rlcVar2.c = null;
            rlc rlcVar3 = ulcVar.m;
            rlcVar3.b = null;
            rlcVar3.c = null;
            llc.j(llcVar);
            g(llcVar, ulcVar);
            if (ulcVar.g == 0 && !ulcVar.j) {
                return;
            }
            if (!ulcVar.i && !ulcVar.j) {
                ulcVar.a = 2;
            } else {
                llc.g(llcVar);
                if (ulcVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                ulcVar.a = i;
            }
            if (ulcVar.j) {
                return;
            }
            ulcVar.R += ulcVar.g;
            if (ulcVar.Q < ulcVar.P) {
                k(ulcVar);
            }
        }
    }

    public static int r(int[] iArr, int i, llc llcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, llcVar)) == null) {
            long j = llcVar.f;
            int i2 = llcVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                llcVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            llcVar.g = i2 + (iArr[i7] >> 16) + 8;
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
