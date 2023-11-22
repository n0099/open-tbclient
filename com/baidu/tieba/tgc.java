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
public final class tgc {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948181689, "Lcom/baidu/tieba/tgc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948181689, "Lcom/baidu/tieba/tgc;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(zgc zgcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, zgcVar) == null) {
            qgc qgcVar = zgcVar.c;
            byte[] bArr = zgcVar.d;
            int i = zgcVar.g;
            if (i <= 0) {
                qgc.k(qgcVar);
                zgcVar.a = 1;
                return;
            }
            int min = Math.min(zgcVar.Q - zgcVar.r, i);
            qgc.c(qgcVar, bArr, zgcVar.r, min);
            zgcVar.g -= min;
            int i2 = zgcVar.r + min;
            zgcVar.r = i2;
            int i3 = zgcVar.Q;
            if (i2 == i3) {
                zgcVar.b = 5;
                zgcVar.Y = i3;
                zgcVar.X = 0;
                zgcVar.a = 12;
                return;
            }
            qgc.k(qgcVar);
            zgcVar.a = 1;
        }
    }

    public static void k(zgc zgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, zgcVar) == null) {
            int i2 = zgcVar.P;
            long j = zgcVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + zgcVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!zgcVar.h && i2 < 16384 && zgcVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = zgcVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = zgcVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = zgcVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = zgcVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(zgcVar.S, i, bArr, 0, i5);
                    zgcVar.r = i5;
                    zgcVar.f1185T = i5;
                }
            }
            zgcVar.d = bArr;
            zgcVar.Q = i2;
        }
    }

    public static boolean u(zgc zgcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, zgcVar)) == null) {
            int i = zgcVar.f1185T;
            if (i != 0) {
                zgcVar.X += i;
                zgcVar.f1185T = 0;
            }
            int min = Math.min(zgcVar.V - zgcVar.W, zgcVar.Y - zgcVar.X);
            if (min != 0) {
                System.arraycopy(zgcVar.d, zgcVar.X, zgcVar.Z, zgcVar.U + zgcVar.W, min);
                zgcVar.W += min;
                zgcVar.X += min;
            }
            if (zgcVar.W >= zgcVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(zgc zgcVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, zgcVar, i) == null) {
            qgc qgcVar = zgcVar.c;
            int[] iArr = zgcVar.p;
            int i3 = i * 2;
            qgc.d(qgcVar);
            int i4 = i * 1080;
            int r = r(zgcVar.e, i4, qgcVar);
            zgcVar.n[i] = m(zgcVar.f, i4, qgcVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = zgcVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(zgc zgcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, zgcVar) == null) {
            b(zgcVar, 1);
            zgcVar.F = zgcVar.l.c[zgcVar.p[3]];
        }
    }

    public static void e(zgc zgcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, zgcVar) == null) {
            b(zgcVar, 2);
            zgcVar.C = zgcVar.p[5] << 2;
        }
    }

    public static int h(qgc qgcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, qgcVar)) == null) {
            if (qgc.i(qgcVar, 1) != 0) {
                int i = qgc.i(qgcVar, 3);
                if (i == 0) {
                    return 1;
                }
                return qgc.i(qgcVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, qgc qgcVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, qgcVar)) == null) {
            qgc.j(qgcVar);
            int h = h(qgcVar) + 1;
            if (h == 1) {
                bhc.a(bArr, 0, i);
                return h;
            }
            if (qgc.i(qgcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = qgc.i(qgcVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, qgcVar);
            int i3 = 0;
            while (i3 < i) {
                qgc.j(qgcVar);
                qgc.d(qgcVar);
                int r = r(iArr, 0, qgcVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + qgc.i(qgcVar, r); i4 != 0; i4--) {
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
            if (qgc.i(qgcVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(zgc zgcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, zgcVar) == null) {
            b(zgcVar, 0);
            int i = zgcVar.p[1];
            int i2 = i << 6;
            zgcVar.B = i2;
            int i3 = zgcVar.A[i2] & 255;
            zgcVar.v = i3;
            zgcVar.w = zgcVar.k.c[i3];
            byte b2 = zgcVar.z[i];
            int[] iArr = sgc.b;
            zgcVar.D = iArr[b2];
            zgcVar.E = iArr[b2 + 1];
        }
    }

    public static void g(qgc qgcVar, zgc zgcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, qgcVar, zgcVar) == null) {
            boolean z2 = true;
            if (qgc.i(qgcVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            zgcVar.h = z;
            zgcVar.g = 0;
            zgcVar.i = false;
            zgcVar.j = false;
            if (z && qgc.i(qgcVar, 1) != 0) {
                return;
            }
            int i = qgc.i(qgcVar, 2) + 4;
            if (i == 7) {
                zgcVar.j = true;
                if (qgc.i(qgcVar, 1) == 0) {
                    int i2 = qgc.i(qgcVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = qgc.i(qgcVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        zgcVar.g = (i4 << (i3 * 8)) | zgcVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = qgc.i(qgcVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    zgcVar.g = (i6 << (i5 * 4)) | zgcVar.g;
                }
            }
            zgcVar.g++;
            if (!zgcVar.h) {
                if (qgc.i(qgcVar, 1) != 1) {
                    z2 = false;
                }
                zgcVar.i = z2;
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
    public static void i(zgc zgcVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, zgcVar) == null) {
            int i8 = zgcVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    qgc qgcVar = zgcVar.c;
                    int i9 = zgcVar.Q - 1;
                    byte[] bArr = zgcVar.d;
                    while (true) {
                        int i10 = zgcVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (zgcVar.g >= 0) {
                                            q(zgcVar);
                                            i9 = zgcVar.Q - 1;
                                            bArr = zgcVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(zgcVar);
                                        zgcVar.a = 3;
                                        if (zgcVar.g > 0) {
                                            zgcVar.a = 1;
                                            break;
                                        } else {
                                            qgc.j(qgcVar);
                                            if (zgcVar.n[1] == 0) {
                                                c(zgcVar);
                                            }
                                            int[] iArr = zgcVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            qgc.d(qgcVar);
                                            int r = r(zgcVar.l.b, zgcVar.F, qgcVar);
                                            int i12 = r >>> 6;
                                            zgcVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                zgcVar.G = -1;
                                            }
                                            int i13 = ygc.g[i12] + ((r >>> 3) & 7);
                                            int i14 = ygc.h[i12] + (r & 7);
                                            zgcVar.y = ygc.c[i13] + qgc.i(qgcVar, ygc.d[i13]);
                                            zgcVar.M = ygc.e[i14] + qgc.i(qgcVar, ygc.f[i14]);
                                            zgcVar.x = 0;
                                            zgcVar.a = 6;
                                            if (zgcVar.u) {
                                                int i15 = zgcVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (zgcVar.x < zgcVar.y) {
                                                        qgc.j(qgcVar);
                                                        if (zgcVar.n[0] == 0) {
                                                            f(zgcVar);
                                                        }
                                                        byte[] bArr2 = zgcVar.A;
                                                        int i18 = zgcVar.B;
                                                        int[] iArr2 = sgc.a;
                                                        int i19 = iArr2[zgcVar.D + i16];
                                                        int[] iArr3 = zgcVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        qgc.d(qgcVar);
                                                        wgc wgcVar = zgcVar.k;
                                                        int r2 = r(wgcVar.b, wgcVar.c[bArr2[i18 + (iArr2[zgcVar.E + i17] | i19)] & 255], qgcVar);
                                                        int i20 = zgcVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        zgcVar.x++;
                                                        zgcVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            zgcVar.b = 6;
                                                            zgcVar.Y = zgcVar.Q;
                                                            zgcVar.X = 0;
                                                            zgcVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (zgcVar.x < zgcVar.y) {
                                                        qgc.j(qgcVar);
                                                        if (zgcVar.n[0] == 0) {
                                                            f(zgcVar);
                                                        }
                                                        int[] iArr4 = zgcVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        qgc.d(qgcVar);
                                                        bArr[zgcVar.r] = (byte) r(zgcVar.k.b, zgcVar.w, qgcVar);
                                                        zgcVar.x++;
                                                        int i22 = zgcVar.r;
                                                        zgcVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            zgcVar.b = 6;
                                                            zgcVar.Y = zgcVar.Q;
                                                            zgcVar.X = 0;
                                                            zgcVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (zgcVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = zgcVar.g - zgcVar.y;
                                                zgcVar.g = i23;
                                                if (i23 <= 0) {
                                                    zgcVar.a = 3;
                                                    break;
                                                } else {
                                                    if (zgcVar.G < 0) {
                                                        qgc.j(qgcVar);
                                                        if (zgcVar.n[2] == 0) {
                                                            e(zgcVar);
                                                        }
                                                        int[] iArr5 = zgcVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        qgc.d(qgcVar);
                                                        wgc wgcVar2 = zgcVar.m;
                                                        int[] iArr6 = wgcVar2.b;
                                                        int[] iArr7 = wgcVar2.c;
                                                        byte[] bArr3 = zgcVar.H;
                                                        int i24 = zgcVar.C;
                                                        int i25 = zgcVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], qgcVar);
                                                        zgcVar.G = r3;
                                                        int i26 = zgcVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            zgcVar.G = i27;
                                                            int i28 = zgcVar.J & i27;
                                                            int i29 = i27 >>> zgcVar.K;
                                                            zgcVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            zgcVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + qgc.i(qgcVar, i30)) << zgcVar.K);
                                                        }
                                                    }
                                                    int t = t(zgcVar.G, zgcVar.q, zgcVar.t);
                                                    zgcVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = zgcVar.s;
                                                        int i32 = zgcVar.O;
                                                        if (i31 != i32 && (i6 = zgcVar.r) < i32) {
                                                            zgcVar.s = i6;
                                                        } else {
                                                            zgcVar.s = zgcVar.O;
                                                        }
                                                        zgcVar.N = zgcVar.r;
                                                        int i33 = zgcVar.L;
                                                        if (i33 > zgcVar.s) {
                                                            zgcVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (zgcVar.G > 0) {
                                                                int[] iArr8 = zgcVar.q;
                                                                int i34 = zgcVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                zgcVar.t = i34 + 1;
                                                            }
                                                            if (zgcVar.M <= zgcVar.g) {
                                                                zgcVar.x = 0;
                                                                zgcVar.a = 7;
                                                                int i35 = zgcVar.r;
                                                                i = (i35 - zgcVar.L) & i9;
                                                                i2 = zgcVar.M - zgcVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    zgcVar.x += i2;
                                                                    zgcVar.g -= i2;
                                                                    zgcVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = zgcVar.x;
                                                                        if (i3 >= zgcVar.M) {
                                                                            i4 = zgcVar.r;
                                                                            bArr[i4] = bArr[(i4 - zgcVar.L) & i9];
                                                                            zgcVar.g--;
                                                                            zgcVar.x = i3 + 1;
                                                                            zgcVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    zgcVar.b = 7;
                                                                    zgcVar.Y = zgcVar.Q;
                                                                    zgcVar.X = 0;
                                                                    zgcVar.a = 12;
                                                                    if (zgcVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        zgcVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (zgcVar.a != i5) {
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
                                        if (zgcVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (zgcVar.g > 0) {
                                            qgc.j(qgcVar);
                                            qgc.i(qgcVar, 8);
                                            zgcVar.g--;
                                        }
                                        zgcVar.a = 1;
                                        break;
                                    case 5:
                                        a(zgcVar);
                                        break;
                                    case 6:
                                        if (zgcVar.u) {
                                        }
                                        if (zgcVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = zgcVar.r;
                                        i = (i352 - zgcVar.L) & i9;
                                        i2 = zgcVar.M - zgcVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = zgcVar.x;
                                            if (i3 >= zgcVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        zgcVar.b = 7;
                                        zgcVar.Y = zgcVar.Q;
                                        zgcVar.X = 0;
                                        zgcVar.a = 12;
                                        if (zgcVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = zgcVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, zgcVar.N - i36);
                                        zgcVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = zgcVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = ugc.a[i37];
                                            int i39 = (zgcVar.L - zgcVar.s) - 1;
                                            int i40 = ugc.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < ahc.d.length) {
                                                int b2 = ahc.b(bArr, zgcVar.N, ugc.a(), i43, zgcVar.M, ahc.d[i42]);
                                                int i44 = zgcVar.N + b2;
                                                zgcVar.N = i44;
                                                zgcVar.r += b2;
                                                zgcVar.g -= b2;
                                                int i45 = zgcVar.Q;
                                                if (i44 >= i45) {
                                                    zgcVar.b = 8;
                                                    zgcVar.Y = i45;
                                                    zgcVar.X = 0;
                                                    zgcVar.a = 12;
                                                    break;
                                                } else {
                                                    zgcVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + zgcVar.a);
                                }
                            } else if (!u(zgcVar)) {
                                return;
                            } else {
                                int i46 = zgcVar.r;
                                int i47 = zgcVar.O;
                                if (i46 >= i47) {
                                    zgcVar.s = i47;
                                }
                                zgcVar.r &= i9;
                                zgcVar.a = zgcVar.b;
                            }
                        } else if (i10 == 10) {
                            if (zgcVar.g >= 0) {
                                qgc.g(qgcVar);
                                qgc.a(zgcVar.c, true);
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

    public static void s(zgc zgcVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, zgcVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            zgcVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, qgc qgcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, qgcVar)) == null) {
            qgc.d(qgcVar);
            int r = r(iArr, i, qgcVar);
            return ygc.a[r] + qgc.i(qgcVar, ygc.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, qgc qgcVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), qgcVar}) == null) {
            qgc.j(qgcVar);
            int[] iArr2 = new int[i];
            int i3 = qgc.i(qgcVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = qgc.i(qgcVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = qgc.i(qgcVar, i6) % i;
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
                            if (qgc.i(qgcVar, 1) == 1) {
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
                    vgc.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                qgc.d(qgcVar);
                long j = qgcVar.f;
                int i11 = qgcVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                qgcVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, qgcVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.bhc.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, qgc qgcVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, qgcVar) == null) {
            int[] iArr3 = new int[32];
            vgc.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    qgc.j(qgcVar);
                    qgc.d(qgcVar);
                    long j = qgcVar.f;
                    int i9 = qgcVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    qgcVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + qgc.i(qgcVar, i13) + 3;
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

    public static void p(zgc zgcVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, zgcVar) == null) {
            qgc qgcVar = zgcVar.c;
            for (int i = 0; i < 3; i++) {
                zgcVar.o[i] = h(qgcVar) + 1;
                zgcVar.n[i] = 268435456;
                int[] iArr2 = zgcVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, zgcVar.e, i2, qgcVar);
                    n(26, zgcVar.f, i2, qgcVar);
                    zgcVar.n[i] = m(zgcVar.f, i2, qgcVar);
                }
            }
            qgc.j(qgcVar);
            zgcVar.K = qgc.i(qgcVar, 2);
            int i3 = qgc.i(qgcVar, 4);
            int i4 = zgcVar.K;
            int i5 = (i3 << i4) + 16;
            zgcVar.I = i5;
            zgcVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            zgcVar.z = new byte[zgcVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = zgcVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    zgcVar.z[i7] = (byte) (qgc.i(qgcVar, 2) << 1);
                    i7++;
                }
                qgc.j(qgcVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            zgcVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, qgcVar);
            zgcVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (zgcVar.o[0] << 6)) {
                    break;
                } else if (zgcVar.A[i8] != (i8 >> 6)) {
                    zgcVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = zgcVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            zgcVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, qgcVar);
            wgc.b(zgcVar.k, 256, d2);
            wgc.b(zgcVar.l, 704, zgcVar.o[1]);
            wgc.b(zgcVar.m, i6, d3);
            wgc.a(zgcVar.k, qgcVar);
            wgc.a(zgcVar.l, qgcVar);
            wgc.a(zgcVar.m, qgcVar);
            zgcVar.B = 0;
            zgcVar.C = 0;
            int[] iArr4 = sgc.b;
            byte[] bArr3 = zgcVar.z;
            zgcVar.D = iArr4[bArr3[0]];
            zgcVar.E = iArr4[bArr3[0] + 1];
            zgcVar.v = 0;
            zgcVar.w = zgcVar.k.c[0];
            zgcVar.F = zgcVar.l.c[0];
            int[] iArr5 = zgcVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(zgc zgcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, zgcVar) == null) {
            qgc qgcVar = zgcVar.c;
            if (zgcVar.h) {
                zgcVar.b = 10;
                zgcVar.Y = zgcVar.r;
                zgcVar.X = 0;
                zgcVar.a = 12;
                return;
            }
            wgc wgcVar = zgcVar.k;
            wgcVar.b = null;
            wgcVar.c = null;
            wgc wgcVar2 = zgcVar.l;
            wgcVar2.b = null;
            wgcVar2.c = null;
            wgc wgcVar3 = zgcVar.m;
            wgcVar3.b = null;
            wgcVar3.c = null;
            qgc.j(qgcVar);
            g(qgcVar, zgcVar);
            if (zgcVar.g == 0 && !zgcVar.j) {
                return;
            }
            if (!zgcVar.i && !zgcVar.j) {
                zgcVar.a = 2;
            } else {
                qgc.g(qgcVar);
                if (zgcVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                zgcVar.a = i;
            }
            if (zgcVar.j) {
                return;
            }
            zgcVar.R += zgcVar.g;
            if (zgcVar.Q < zgcVar.P) {
                k(zgcVar);
            }
        }
    }

    public static int r(int[] iArr, int i, qgc qgcVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, qgcVar)) == null) {
            long j = qgcVar.f;
            int i2 = qgcVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                qgcVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            qgcVar.g = i2 + (iArr[i7] >> 16) + 8;
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
