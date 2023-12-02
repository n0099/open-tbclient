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
public final class nlc {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948007748, "Lcom/baidu/tieba/nlc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948007748, "Lcom/baidu/tieba/nlc;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(tlc tlcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, tlcVar) == null) {
            klc klcVar = tlcVar.c;
            byte[] bArr = tlcVar.d;
            int i = tlcVar.g;
            if (i <= 0) {
                klc.k(klcVar);
                tlcVar.a = 1;
                return;
            }
            int min = Math.min(tlcVar.Q - tlcVar.r, i);
            klc.c(klcVar, bArr, tlcVar.r, min);
            tlcVar.g -= min;
            int i2 = tlcVar.r + min;
            tlcVar.r = i2;
            int i3 = tlcVar.Q;
            if (i2 == i3) {
                tlcVar.b = 5;
                tlcVar.Y = i3;
                tlcVar.X = 0;
                tlcVar.a = 12;
                return;
            }
            klc.k(klcVar);
            tlcVar.a = 1;
        }
    }

    public static void k(tlc tlcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, tlcVar) == null) {
            int i2 = tlcVar.P;
            long j = tlcVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + tlcVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!tlcVar.h && i2 < 16384 && tlcVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = tlcVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = tlcVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = tlcVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = tlcVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(tlcVar.S, i, bArr, 0, i5);
                    tlcVar.r = i5;
                    tlcVar.f1158T = i5;
                }
            }
            tlcVar.d = bArr;
            tlcVar.Q = i2;
        }
    }

    public static boolean u(tlc tlcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tlcVar)) == null) {
            int i = tlcVar.f1158T;
            if (i != 0) {
                tlcVar.X += i;
                tlcVar.f1158T = 0;
            }
            int min = Math.min(tlcVar.V - tlcVar.W, tlcVar.Y - tlcVar.X);
            if (min != 0) {
                System.arraycopy(tlcVar.d, tlcVar.X, tlcVar.Z, tlcVar.U + tlcVar.W, min);
                tlcVar.W += min;
                tlcVar.X += min;
            }
            if (tlcVar.W >= tlcVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(tlc tlcVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, tlcVar, i) == null) {
            klc klcVar = tlcVar.c;
            int[] iArr = tlcVar.p;
            int i3 = i * 2;
            klc.d(klcVar);
            int i4 = i * 1080;
            int r = r(tlcVar.e, i4, klcVar);
            tlcVar.n[i] = m(tlcVar.f, i4, klcVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = tlcVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(tlc tlcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, tlcVar) == null) {
            b(tlcVar, 1);
            tlcVar.F = tlcVar.l.c[tlcVar.p[3]];
        }
    }

    public static void e(tlc tlcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, tlcVar) == null) {
            b(tlcVar, 2);
            tlcVar.C = tlcVar.p[5] << 2;
        }
    }

    public static int h(klc klcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, klcVar)) == null) {
            if (klc.i(klcVar, 1) != 0) {
                int i = klc.i(klcVar, 3);
                if (i == 0) {
                    return 1;
                }
                return klc.i(klcVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, klc klcVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, klcVar)) == null) {
            klc.j(klcVar);
            int h = h(klcVar) + 1;
            if (h == 1) {
                vlc.a(bArr, 0, i);
                return h;
            }
            if (klc.i(klcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = klc.i(klcVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, klcVar);
            int i3 = 0;
            while (i3 < i) {
                klc.j(klcVar);
                klc.d(klcVar);
                int r = r(iArr, 0, klcVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + klc.i(klcVar, r); i4 != 0; i4--) {
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
            if (klc.i(klcVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(tlc tlcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, tlcVar) == null) {
            b(tlcVar, 0);
            int i = tlcVar.p[1];
            int i2 = i << 6;
            tlcVar.B = i2;
            int i3 = tlcVar.A[i2] & 255;
            tlcVar.v = i3;
            tlcVar.w = tlcVar.k.c[i3];
            byte b2 = tlcVar.z[i];
            int[] iArr = mlc.b;
            tlcVar.D = iArr[b2];
            tlcVar.E = iArr[b2 + 1];
        }
    }

    public static void g(klc klcVar, tlc tlcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, klcVar, tlcVar) == null) {
            boolean z2 = true;
            if (klc.i(klcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            tlcVar.h = z;
            tlcVar.g = 0;
            tlcVar.i = false;
            tlcVar.j = false;
            if (z && klc.i(klcVar, 1) != 0) {
                return;
            }
            int i = klc.i(klcVar, 2) + 4;
            if (i == 7) {
                tlcVar.j = true;
                if (klc.i(klcVar, 1) == 0) {
                    int i2 = klc.i(klcVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = klc.i(klcVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        tlcVar.g = (i4 << (i3 * 8)) | tlcVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = klc.i(klcVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    tlcVar.g = (i6 << (i5 * 4)) | tlcVar.g;
                }
            }
            tlcVar.g++;
            if (!tlcVar.h) {
                if (klc.i(klcVar, 1) != 1) {
                    z2 = false;
                }
                tlcVar.i = z2;
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
    public static void i(tlc tlcVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, tlcVar) == null) {
            int i8 = tlcVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    klc klcVar = tlcVar.c;
                    int i9 = tlcVar.Q - 1;
                    byte[] bArr = tlcVar.d;
                    while (true) {
                        int i10 = tlcVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (tlcVar.g >= 0) {
                                            q(tlcVar);
                                            i9 = tlcVar.Q - 1;
                                            bArr = tlcVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(tlcVar);
                                        tlcVar.a = 3;
                                        if (tlcVar.g > 0) {
                                            tlcVar.a = 1;
                                            break;
                                        } else {
                                            klc.j(klcVar);
                                            if (tlcVar.n[1] == 0) {
                                                c(tlcVar);
                                            }
                                            int[] iArr = tlcVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            klc.d(klcVar);
                                            int r = r(tlcVar.l.b, tlcVar.F, klcVar);
                                            int i12 = r >>> 6;
                                            tlcVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                tlcVar.G = -1;
                                            }
                                            int i13 = slc.g[i12] + ((r >>> 3) & 7);
                                            int i14 = slc.h[i12] + (r & 7);
                                            tlcVar.y = slc.c[i13] + klc.i(klcVar, slc.d[i13]);
                                            tlcVar.M = slc.e[i14] + klc.i(klcVar, slc.f[i14]);
                                            tlcVar.x = 0;
                                            tlcVar.a = 6;
                                            if (tlcVar.u) {
                                                int i15 = tlcVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (tlcVar.x < tlcVar.y) {
                                                        klc.j(klcVar);
                                                        if (tlcVar.n[0] == 0) {
                                                            f(tlcVar);
                                                        }
                                                        byte[] bArr2 = tlcVar.A;
                                                        int i18 = tlcVar.B;
                                                        int[] iArr2 = mlc.a;
                                                        int i19 = iArr2[tlcVar.D + i16];
                                                        int[] iArr3 = tlcVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        klc.d(klcVar);
                                                        qlc qlcVar = tlcVar.k;
                                                        int r2 = r(qlcVar.b, qlcVar.c[bArr2[i18 + (iArr2[tlcVar.E + i17] | i19)] & 255], klcVar);
                                                        int i20 = tlcVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        tlcVar.x++;
                                                        tlcVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            tlcVar.b = 6;
                                                            tlcVar.Y = tlcVar.Q;
                                                            tlcVar.X = 0;
                                                            tlcVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (tlcVar.x < tlcVar.y) {
                                                        klc.j(klcVar);
                                                        if (tlcVar.n[0] == 0) {
                                                            f(tlcVar);
                                                        }
                                                        int[] iArr4 = tlcVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        klc.d(klcVar);
                                                        bArr[tlcVar.r] = (byte) r(tlcVar.k.b, tlcVar.w, klcVar);
                                                        tlcVar.x++;
                                                        int i22 = tlcVar.r;
                                                        tlcVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            tlcVar.b = 6;
                                                            tlcVar.Y = tlcVar.Q;
                                                            tlcVar.X = 0;
                                                            tlcVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (tlcVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = tlcVar.g - tlcVar.y;
                                                tlcVar.g = i23;
                                                if (i23 <= 0) {
                                                    tlcVar.a = 3;
                                                    break;
                                                } else {
                                                    if (tlcVar.G < 0) {
                                                        klc.j(klcVar);
                                                        if (tlcVar.n[2] == 0) {
                                                            e(tlcVar);
                                                        }
                                                        int[] iArr5 = tlcVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        klc.d(klcVar);
                                                        qlc qlcVar2 = tlcVar.m;
                                                        int[] iArr6 = qlcVar2.b;
                                                        int[] iArr7 = qlcVar2.c;
                                                        byte[] bArr3 = tlcVar.H;
                                                        int i24 = tlcVar.C;
                                                        int i25 = tlcVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], klcVar);
                                                        tlcVar.G = r3;
                                                        int i26 = tlcVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            tlcVar.G = i27;
                                                            int i28 = tlcVar.J & i27;
                                                            int i29 = i27 >>> tlcVar.K;
                                                            tlcVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            tlcVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + klc.i(klcVar, i30)) << tlcVar.K);
                                                        }
                                                    }
                                                    int t = t(tlcVar.G, tlcVar.q, tlcVar.t);
                                                    tlcVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = tlcVar.s;
                                                        int i32 = tlcVar.O;
                                                        if (i31 != i32 && (i6 = tlcVar.r) < i32) {
                                                            tlcVar.s = i6;
                                                        } else {
                                                            tlcVar.s = tlcVar.O;
                                                        }
                                                        tlcVar.N = tlcVar.r;
                                                        int i33 = tlcVar.L;
                                                        if (i33 > tlcVar.s) {
                                                            tlcVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (tlcVar.G > 0) {
                                                                int[] iArr8 = tlcVar.q;
                                                                int i34 = tlcVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                tlcVar.t = i34 + 1;
                                                            }
                                                            if (tlcVar.M <= tlcVar.g) {
                                                                tlcVar.x = 0;
                                                                tlcVar.a = 7;
                                                                int i35 = tlcVar.r;
                                                                i = (i35 - tlcVar.L) & i9;
                                                                i2 = tlcVar.M - tlcVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    tlcVar.x += i2;
                                                                    tlcVar.g -= i2;
                                                                    tlcVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = tlcVar.x;
                                                                        if (i3 >= tlcVar.M) {
                                                                            i4 = tlcVar.r;
                                                                            bArr[i4] = bArr[(i4 - tlcVar.L) & i9];
                                                                            tlcVar.g--;
                                                                            tlcVar.x = i3 + 1;
                                                                            tlcVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    tlcVar.b = 7;
                                                                    tlcVar.Y = tlcVar.Q;
                                                                    tlcVar.X = 0;
                                                                    tlcVar.a = 12;
                                                                    if (tlcVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        tlcVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (tlcVar.a != i5) {
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
                                        if (tlcVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (tlcVar.g > 0) {
                                            klc.j(klcVar);
                                            klc.i(klcVar, 8);
                                            tlcVar.g--;
                                        }
                                        tlcVar.a = 1;
                                        break;
                                    case 5:
                                        a(tlcVar);
                                        break;
                                    case 6:
                                        if (tlcVar.u) {
                                        }
                                        if (tlcVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = tlcVar.r;
                                        i = (i352 - tlcVar.L) & i9;
                                        i2 = tlcVar.M - tlcVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = tlcVar.x;
                                            if (i3 >= tlcVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        tlcVar.b = 7;
                                        tlcVar.Y = tlcVar.Q;
                                        tlcVar.X = 0;
                                        tlcVar.a = 12;
                                        if (tlcVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = tlcVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, tlcVar.N - i36);
                                        tlcVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = tlcVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = olc.a[i37];
                                            int i39 = (tlcVar.L - tlcVar.s) - 1;
                                            int i40 = olc.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < ulc.d.length) {
                                                int b2 = ulc.b(bArr, tlcVar.N, olc.a(), i43, tlcVar.M, ulc.d[i42]);
                                                int i44 = tlcVar.N + b2;
                                                tlcVar.N = i44;
                                                tlcVar.r += b2;
                                                tlcVar.g -= b2;
                                                int i45 = tlcVar.Q;
                                                if (i44 >= i45) {
                                                    tlcVar.b = 8;
                                                    tlcVar.Y = i45;
                                                    tlcVar.X = 0;
                                                    tlcVar.a = 12;
                                                    break;
                                                } else {
                                                    tlcVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + tlcVar.a);
                                }
                            } else if (!u(tlcVar)) {
                                return;
                            } else {
                                int i46 = tlcVar.r;
                                int i47 = tlcVar.O;
                                if (i46 >= i47) {
                                    tlcVar.s = i47;
                                }
                                tlcVar.r &= i9;
                                tlcVar.a = tlcVar.b;
                            }
                        } else if (i10 == 10) {
                            if (tlcVar.g >= 0) {
                                klc.g(klcVar);
                                klc.a(tlcVar.c, true);
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

    public static void s(tlc tlcVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, tlcVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            tlcVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, klc klcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, klcVar)) == null) {
            klc.d(klcVar);
            int r = r(iArr, i, klcVar);
            return slc.a[r] + klc.i(klcVar, slc.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, klc klcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), klcVar}) == null) {
            klc.j(klcVar);
            int[] iArr2 = new int[i];
            int i3 = klc.i(klcVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = klc.i(klcVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = klc.i(klcVar, i6) % i;
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
                            if (klc.i(klcVar, 1) == 1) {
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
                    plc.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                klc.d(klcVar);
                long j = klcVar.f;
                int i11 = klcVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                klcVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, klcVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.vlc.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, klc klcVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, klcVar) == null) {
            int[] iArr3 = new int[32];
            plc.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    klc.j(klcVar);
                    klc.d(klcVar);
                    long j = klcVar.f;
                    int i9 = klcVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    klcVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + klc.i(klcVar, i13) + 3;
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

    public static void p(tlc tlcVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, tlcVar) == null) {
            klc klcVar = tlcVar.c;
            for (int i = 0; i < 3; i++) {
                tlcVar.o[i] = h(klcVar) + 1;
                tlcVar.n[i] = 268435456;
                int[] iArr2 = tlcVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, tlcVar.e, i2, klcVar);
                    n(26, tlcVar.f, i2, klcVar);
                    tlcVar.n[i] = m(tlcVar.f, i2, klcVar);
                }
            }
            klc.j(klcVar);
            tlcVar.K = klc.i(klcVar, 2);
            int i3 = klc.i(klcVar, 4);
            int i4 = tlcVar.K;
            int i5 = (i3 << i4) + 16;
            tlcVar.I = i5;
            tlcVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            tlcVar.z = new byte[tlcVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = tlcVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    tlcVar.z[i7] = (byte) (klc.i(klcVar, 2) << 1);
                    i7++;
                }
                klc.j(klcVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            tlcVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, klcVar);
            tlcVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (tlcVar.o[0] << 6)) {
                    break;
                } else if (tlcVar.A[i8] != (i8 >> 6)) {
                    tlcVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = tlcVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            tlcVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, klcVar);
            qlc.b(tlcVar.k, 256, d2);
            qlc.b(tlcVar.l, 704, tlcVar.o[1]);
            qlc.b(tlcVar.m, i6, d3);
            qlc.a(tlcVar.k, klcVar);
            qlc.a(tlcVar.l, klcVar);
            qlc.a(tlcVar.m, klcVar);
            tlcVar.B = 0;
            tlcVar.C = 0;
            int[] iArr4 = mlc.b;
            byte[] bArr3 = tlcVar.z;
            tlcVar.D = iArr4[bArr3[0]];
            tlcVar.E = iArr4[bArr3[0] + 1];
            tlcVar.v = 0;
            tlcVar.w = tlcVar.k.c[0];
            tlcVar.F = tlcVar.l.c[0];
            int[] iArr5 = tlcVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(tlc tlcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, tlcVar) == null) {
            klc klcVar = tlcVar.c;
            if (tlcVar.h) {
                tlcVar.b = 10;
                tlcVar.Y = tlcVar.r;
                tlcVar.X = 0;
                tlcVar.a = 12;
                return;
            }
            qlc qlcVar = tlcVar.k;
            qlcVar.b = null;
            qlcVar.c = null;
            qlc qlcVar2 = tlcVar.l;
            qlcVar2.b = null;
            qlcVar2.c = null;
            qlc qlcVar3 = tlcVar.m;
            qlcVar3.b = null;
            qlcVar3.c = null;
            klc.j(klcVar);
            g(klcVar, tlcVar);
            if (tlcVar.g == 0 && !tlcVar.j) {
                return;
            }
            if (!tlcVar.i && !tlcVar.j) {
                tlcVar.a = 2;
            } else {
                klc.g(klcVar);
                if (tlcVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                tlcVar.a = i;
            }
            if (tlcVar.j) {
                return;
            }
            tlcVar.R += tlcVar.g;
            if (tlcVar.Q < tlcVar.P) {
                k(tlcVar);
            }
        }
    }

    public static int r(int[] iArr, int i, klc klcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, klcVar)) == null) {
            long j = klcVar.f;
            int i2 = klcVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                klcVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            klcVar.g = i2 + (iArr[i7] >> 16) + 8;
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
