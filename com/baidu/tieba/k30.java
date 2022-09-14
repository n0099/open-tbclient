package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.disklrucache.StrictLineReader;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes4.dex */
public class k30 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public int b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public static final int[] f;
        public transient /* synthetic */ FieldHolder $fh;
        public int c;
        public int d;
        public final int[] e;

        static {
            InterceptResult invokeClinit;
            int i;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-710361725, "Lcom/baidu/tieba/k30$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-710361725, "Lcom/baidu/tieba/k30$b;");
                    return;
                }
            }
            f = new int[256];
            int i2 = 0;
            while (true) {
                if (i2 >= 64) {
                    break;
                }
                f[i2] = i2;
                i2++;
            }
            for (i = 64; i < 256; i++) {
                f[i] = -1;
            }
        }

        public b(int i, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.e = f;
            this.c = 0;
            this.d = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ff, code lost:
            if (r5 != 4) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                int i3 = this.c;
                if (i3 == 6) {
                    return false;
                }
                int i4 = i2 + i;
                int i5 = this.d;
                byte[] bArr2 = this.a;
                int[] iArr = this.e;
                int i6 = i5;
                int i7 = 0;
                int i8 = i3;
                int i9 = i;
                while (i9 < i4) {
                    if (i8 == 0) {
                        while (true) {
                            int i10 = i9 + 4;
                            if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                                break;
                            }
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i10;
                        }
                        if (i9 >= i4) {
                            break;
                        }
                    }
                    int i11 = i9 + 1;
                    int i12 = iArr[bArr[i9] & 255];
                    if (i8 != 0) {
                        if (i8 == 1) {
                            if (i12 < 0) {
                                if (i12 != -1) {
                                    this.c = 6;
                                    return false;
                                }
                            }
                            i12 |= i6 << 6;
                        } else if (i8 == 2) {
                            if (i12 < 0) {
                                if (i12 == -2) {
                                    bArr2[i7] = (byte) (i6 >> 4);
                                    i7++;
                                    i8 = 4;
                                } else if (i12 != -1) {
                                    break;
                                }
                            }
                            i12 |= i6 << 6;
                        } else if (i8 != 3) {
                            if (i8 != 4) {
                                if (i8 == 5 && i12 != -1) {
                                    this.c = 6;
                                    return false;
                                }
                            } else if (i12 == -2) {
                                i8++;
                            } else if (i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            int i13 = i12 | (i6 << 6);
                            bArr2[i7 + 2] = (byte) i13;
                            bArr2[i7 + 1] = (byte) (i13 >> 8);
                            bArr2[i7] = (byte) (i13 >> 16);
                            i7 += 3;
                            i6 = i13;
                            i8 = 0;
                        } else if (i12 == -2) {
                            bArr2[i7 + 1] = (byte) (i6 >> 2);
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 += 2;
                            i8 = 5;
                        } else if (i12 != -1) {
                            break;
                        }
                        i8++;
                        i6 = i12;
                    } else {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        }
                        i8++;
                        i6 = i12;
                    }
                    i9 = i11;
                }
                if (z) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            bArr2[i7] = (byte) (i6 >> 4);
                            i7++;
                        } else if (i8 == 3) {
                            int i14 = i7 + 1;
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 = i14 + 1;
                            bArr2[i14] = (byte) (i6 >> 2);
                        }
                        this.c = i8;
                    }
                    this.c = 6;
                    return false;
                }
                this.c = i8;
                this.d = i6;
                this.b = i7;
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] j;
        public static final /* synthetic */ boolean k;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] c;
        public int d;
        public int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final byte[] i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-710361694, "Lcom/baidu/tieba/k30$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-710361694, "Lcom/baidu/tieba/k30$c;");
                    return;
                }
            }
            k = !k30.class.desiredAssertionStatus();
            j = new byte[64];
            for (int i = 0; i < 64; i++) {
                j[i] = (byte) i;
            }
        }

        public c(int i, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.f = (i & 1) == 0;
            this.g = (i & 2) == 0;
            this.h = (i & 4) != 0;
            this.i = j;
            this.c = new byte[2];
            this.d = 0;
            this.e = this.g ? 19 : -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.h == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
            r2[r6] = com.bumptech.glide.disklrucache.StrictLineReader.CR;
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e1, code lost:
            r2[r6] = 10;
            r6 = r6 + 1;
            r11 = r10;
         */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01d1 A[ADDED_TO_REGION] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e1 -> B:24:0x008e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            int i3;
            int i4;
            int i5;
            int i6;
            byte b;
            int i7;
            byte b2;
            byte b3;
            int i8;
            int i9;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            byte[] bArr2 = this.i;
            byte[] bArr3 = this.a;
            int i10 = this.e;
            int i11 = i2 + i;
            int i12 = this.d;
            int i13 = 0;
            if (i12 != 1) {
                if (i12 == 2 && (i9 = i + 1) <= i11) {
                    byte[] bArr4 = this.c;
                    i4 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                    this.d = 0;
                    i3 = i9;
                }
                i3 = i;
                i4 = -1;
            } else {
                if (i + 2 <= i11) {
                    int i14 = i + 1;
                    i3 = i14 + 1;
                    i4 = (bArr[i14] & 255) | ((this.c[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                    this.d = 0;
                }
                i3 = i;
                i4 = -1;
            }
            if (i4 != -1) {
                bArr3[0] = bArr2[(i4 >> 18) & 63];
                bArr3[1] = bArr2[(i4 >> 12) & 63];
                bArr3[2] = bArr2[(i4 >> 6) & 63];
                bArr3[3] = bArr2[i4 & 63];
                i10--;
                if (i10 == 0) {
                    if (this.h) {
                        i8 = 5;
                        bArr3[4] = StrictLineReader.CR;
                    } else {
                        i8 = 4;
                    }
                    i5 = i8 + 1;
                    bArr3[i8] = 10;
                    i10 = 19;
                } else {
                    i5 = 4;
                }
            } else {
                i5 = 0;
            }
            while (true) {
                int i15 = i3 + 3;
                if (i15 > i11) {
                    if (z) {
                        int i16 = this.d;
                        int i17 = i3 - i16;
                        if (i17 == i11 - 1) {
                            if (i16 > 0) {
                                b3 = this.c[0];
                                i13 = 1;
                            } else {
                                byte b4 = bArr[i3];
                                i3++;
                                b3 = b4;
                            }
                            int i18 = (b3 & 255) << 4;
                            this.d -= i13;
                            int i19 = i5 + 1;
                            bArr3[i5] = bArr2[(i18 >> 6) & 63];
                            i5 = i19 + 1;
                            bArr3[i19] = bArr2[i18 & 63];
                            if (this.f) {
                                int i20 = i5 + 1;
                                bArr3[i5] = BaseNCodec.PAD_DEFAULT;
                                i5 = i20 + 1;
                                bArr3[i20] = BaseNCodec.PAD_DEFAULT;
                            }
                            if (this.g) {
                                if (this.h) {
                                    bArr3[i5] = StrictLineReader.CR;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                            if (k && this.d != 0) {
                                throw new AssertionError();
                            }
                            if (!k && i3 != i11) {
                                throw new AssertionError();
                            }
                        } else if (i17 == i11 - 2) {
                            if (i16 > 1) {
                                b = this.c[0];
                                i13 = 1;
                            } else {
                                byte b5 = bArr[i3];
                                i3++;
                                b = b5;
                            }
                            int i21 = (b & 255) << 10;
                            if (this.d > 0) {
                                i7 = i13 + 1;
                                b2 = this.c[i13];
                            } else {
                                i7 = i13;
                                b2 = bArr[i3];
                                i3++;
                            }
                            int i22 = i21 | ((b2 & 255) << 2);
                            this.d -= i7;
                            int i23 = i5 + 1;
                            bArr3[i5] = bArr2[(i22 >> 12) & 63];
                            int i24 = i23 + 1;
                            bArr3[i23] = bArr2[(i22 >> 6) & 63];
                            int i25 = i24 + 1;
                            bArr3[i24] = bArr2[i22 & 63];
                            if (this.f) {
                                bArr3[i25] = BaseNCodec.PAD_DEFAULT;
                                i25++;
                            }
                            if (this.g) {
                                if (this.h) {
                                    bArr3[i25] = StrictLineReader.CR;
                                    i25++;
                                }
                                i6 = i25 + 1;
                                bArr3[i25] = 10;
                                i5 = i6;
                                if (k) {
                                }
                                if (!k) {
                                    throw new AssertionError();
                                }
                            } else {
                                i5 = i25;
                                if (k) {
                                }
                                if (!k) {
                                }
                            }
                        } else {
                            if (this.g && i5 > 0 && i10 != 19) {
                                if (this.h) {
                                    bArr3[i5] = StrictLineReader.CR;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                            if (k) {
                            }
                            if (!k) {
                            }
                        }
                    } else if (i3 == i11 - 1) {
                        byte[] bArr5 = this.c;
                        int i26 = this.d;
                        this.d = i26 + 1;
                        bArr5[i26] = bArr[i3];
                    } else if (i3 == i11 - 2) {
                        byte[] bArr6 = this.c;
                        int i27 = this.d;
                        int i28 = i27 + 1;
                        this.d = i28;
                        bArr6[i27] = bArr[i3];
                        this.d = i28 + 1;
                        bArr6[i28] = bArr[i3 + 1];
                    }
                    this.b = i5;
                    this.e = i10;
                    return true;
                }
                int i29 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
                bArr3[i5] = bArr2[(i29 >> 18) & 63];
                bArr3[i5 + 1] = bArr2[(i29 >> 12) & 63];
                bArr3[i5 + 2] = bArr2[(i29 >> 6) & 63];
                bArr3[i5 + 3] = bArr2[i29 & 63];
                i5 += 4;
                i10--;
                if (i10 == 0) {
                    break;
                }
                i3 = i15;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947862017, "Lcom/baidu/tieba/k30;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947862017, "Lcom/baidu/tieba/k30;");
                return;
            }
        }
        a = !k30.class.desiredAssertionStatus();
    }

    public k30() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            c cVar = new c(19, null);
            int i2 = (i / 3) * 4;
            if (!cVar.f) {
                int i3 = i % 3;
                if (i3 == 1) {
                    i2 += 2;
                } else if (i3 == 2) {
                    i2 += 3;
                }
            } else if (i % 3 > 0) {
                i2 += 4;
            }
            if (!cVar.g || i <= 0) {
                return i2;
            }
            return i2 + ((((i - 1) / 57) + 1) * (cVar.h ? 2 : 1));
        }
        return invokeI.intValue;
    }

    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? c(bArr, 0, bArr.length) : (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            b bVar = new b(19, new byte[(i2 * 3) / 4]);
            if (bVar.a(bArr, i, i2, true)) {
                int i3 = bVar.b;
                byte[] bArr2 = bVar.a;
                if (i3 == bArr2.length) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i3];
                System.arraycopy(bArr2, 0, bArr3, 0, i3);
                return bArr3;
            }
            throw new IllegalArgumentException("bad base-64");
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? e(bArr, 0, bArr.length) : (byte[]) invokeL.objValue;
    }

    public static byte[] e(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i, i2)) == null) {
            c cVar = new c(19, null);
            int i3 = (i2 / 3) * 4;
            if (!cVar.f) {
                int i4 = i2 % 3;
                if (i4 == 1) {
                    i3 += 2;
                } else if (i4 == 2) {
                    i3 += 3;
                }
            } else if (i2 % 3 > 0) {
                i3 += 4;
            }
            if (cVar.g && i2 > 0) {
                i3 += (((i2 - 1) / 57) + 1) * (cVar.h ? 2 : 1);
            }
            cVar.a = new byte[i3];
            cVar.a(bArr, i, i2, true);
            if (a || cVar.b == i3) {
                return cVar.a;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeLII.objValue;
    }
}
