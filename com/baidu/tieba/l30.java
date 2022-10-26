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
public class l30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947891808, "Lcom/baidu/tieba/l30;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947891808, "Lcom/baidu/tieba/l30;");
        }
    }

    /* loaded from: classes4.dex */
    public abstract class a {
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
    public class b extends a {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-681732574, "Lcom/baidu/tieba/l30$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-681732574, "Lcom/baidu/tieba/l30$b;");
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
                        if (i8 != 1) {
                            if (i8 != 2) {
                                if (i8 != 3) {
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
                                    this.c = 6;
                                    return false;
                                }
                            } else {
                                if (i12 < 0) {
                                    if (i12 == -2) {
                                        bArr2[i7] = (byte) (i6 >> 4);
                                        i7++;
                                        i8 = 4;
                                    } else if (i12 != -1) {
                                        this.c = 6;
                                        return false;
                                    }
                                }
                                i12 |= i6 << 6;
                            }
                        } else {
                            if (i12 < 0) {
                                if (i12 != -1) {
                                    this.c = 6;
                                    return false;
                                }
                            }
                            i12 |= i6 << 6;
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
                if (!z) {
                    this.c = i8;
                    this.d = i6;
                    this.b = i7;
                    return true;
                } else if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                this.c = 6;
                                return false;
                            }
                        } else {
                            int i14 = i7 + 1;
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 = i14 + 1;
                            bArr2[i14] = (byte) (i6 >> 2);
                        }
                    } else {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                    }
                    this.c = i8;
                    this.b = i7;
                    return true;
                } else {
                    this.c = 6;
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] j;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-681732543, "Lcom/baidu/tieba/l30$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-681732543, "Lcom/baidu/tieba/l30$c;");
                    return;
                }
            }
            j = new byte[64];
            for (int i = 0; i < 64; i++) {
                j[i] = (byte) i;
            }
        }

        public c(int i, byte[] bArr) {
            boolean z;
            boolean z2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            if ((i & 1) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            if ((i & 2) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.g = z2;
            this.h = (i & 4) != 0;
            this.i = j;
            this.c = new byte[2];
            this.d = 0;
            if (this.g) {
                i2 = 19;
            } else {
                i2 = -1;
            }
            this.e = i2;
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
            byte b2;
            byte b3;
            int i7;
            int i8;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                byte[] bArr2 = this.i;
                byte[] bArr3 = this.a;
                int i9 = this.e;
                int i10 = i2 + i;
                int i11 = this.d;
                int i12 = 0;
                if (i11 != 1) {
                    if (i11 == 2 && (i8 = i + 1) <= i10) {
                        byte[] bArr4 = this.c;
                        i4 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                        this.d = 0;
                        i3 = i8;
                    }
                    i3 = i;
                    i4 = -1;
                } else {
                    if (i + 2 <= i10) {
                        int i13 = i + 1;
                        i3 = i13 + 1;
                        i4 = (bArr[i13] & 255) | ((this.c[0] & 255) << 16) | ((bArr[i] & 255) << 8);
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
                    i9--;
                    if (i9 == 0) {
                        if (this.h) {
                            i7 = 5;
                            bArr3[4] = StrictLineReader.CR;
                        } else {
                            i7 = 4;
                        }
                        i5 = i7 + 1;
                        bArr3[i7] = 10;
                        i9 = 19;
                    } else {
                        i5 = 4;
                    }
                } else {
                    i5 = 0;
                }
                while (true) {
                    int i14 = i3 + 3;
                    if (i14 <= i10) {
                        int i15 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
                        bArr3[i5] = bArr2[(i15 >> 18) & 63];
                        bArr3[i5 + 1] = bArr2[(i15 >> 12) & 63];
                        bArr3[i5 + 2] = bArr2[(i15 >> 6) & 63];
                        bArr3[i5 + 3] = bArr2[i15 & 63];
                        i5 += 4;
                        i9--;
                        if (i9 == 0) {
                            break;
                        }
                        i3 = i14;
                    } else {
                        if (z) {
                            int i16 = this.d;
                            if (i3 - i16 == i10 - 1) {
                                if (i16 > 0) {
                                    b3 = this.c[0];
                                    i12 = 1;
                                } else {
                                    b3 = bArr[i3];
                                }
                                int i17 = (b3 & 255) << 4;
                                this.d -= i12;
                                int i18 = i5 + 1;
                                bArr3[i5] = bArr2[(i17 >> 6) & 63];
                                i5 = i18 + 1;
                                bArr3[i18] = bArr2[i17 & 63];
                                if (this.f) {
                                    int i19 = i5 + 1;
                                    bArr3[i5] = BaseNCodec.PAD_DEFAULT;
                                    i5 = i19 + 1;
                                    bArr3[i19] = BaseNCodec.PAD_DEFAULT;
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
                            } else if (i3 - i16 == i10 - 2) {
                                if (i16 > 1) {
                                    b = this.c[0];
                                    i12 = 1;
                                } else {
                                    byte b4 = bArr[i3];
                                    i3++;
                                    b = b4;
                                }
                                int i20 = (b & 255) << 10;
                                if (this.d > 0) {
                                    b2 = this.c[i12];
                                    i12++;
                                } else {
                                    b2 = bArr[i3];
                                }
                                int i21 = i20 | ((b2 & 255) << 2);
                                this.d -= i12;
                                int i22 = i5 + 1;
                                bArr3[i5] = bArr2[(i21 >> 12) & 63];
                                int i23 = i22 + 1;
                                bArr3[i22] = bArr2[(i21 >> 6) & 63];
                                int i24 = i23 + 1;
                                bArr3[i23] = bArr2[i21 & 63];
                                if (this.f) {
                                    bArr3[i24] = BaseNCodec.PAD_DEFAULT;
                                    i24++;
                                }
                                if (this.g) {
                                    if (this.h) {
                                        bArr3[i24] = StrictLineReader.CR;
                                        i24++;
                                    }
                                    bArr3[i24] = 10;
                                    i24++;
                                }
                                i5 = i24;
                            } else if (this.g && i5 > 0 && i9 != 19) {
                                if (this.h) {
                                    bArr3[i5] = StrictLineReader.CR;
                                    i5++;
                                }
                                i6 = i5 + 1;
                                bArr3[i5] = 10;
                                i5 = i6;
                            }
                        } else if (i3 == i10 - 1) {
                            byte[] bArr5 = this.c;
                            int i25 = this.d;
                            this.d = i25 + 1;
                            bArr5[i25] = bArr[i3];
                        } else if (i3 == i10 - 2) {
                            byte[] bArr6 = this.c;
                            int i26 = this.d;
                            int i27 = i26 + 1;
                            this.d = i27;
                            bArr6[i26] = bArr[i3];
                            this.d = i27 + 1;
                            bArr6[i27] = bArr[i3 + 1];
                        }
                        this.b = i5;
                        this.e = i9;
                        return true;
                    }
                }
            } else {
                return invokeCommon.booleanValue;
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            return b(bArr, 0, bArr.length);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            return d(bArr, 0, bArr.length);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i, i2)) == null) {
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

    public static byte[] d(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            c cVar = new c(19, null);
            int i3 = (i2 / 3) * 4;
            int i4 = 2;
            if (cVar.f) {
                if (i2 % 3 > 0) {
                    i3 += 4;
                }
            } else {
                int i5 = i2 % 3;
                if (i5 != 1) {
                    if (i5 == 2) {
                        i3 += 3;
                    }
                } else {
                    i3 += 2;
                }
            }
            if (cVar.g && i2 > 0) {
                int i6 = ((i2 - 1) / 57) + 1;
                if (!cVar.h) {
                    i4 = 1;
                }
                i3 += i6 * i4;
            }
            cVar.a = new byte[i3];
            cVar.a(bArr, i, i2, true);
            return cVar.a;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            c cVar = new c(19, null);
            int i2 = (i / 3) * 4;
            int i3 = 2;
            if (cVar.f) {
                if (i % 3 > 0) {
                    i2 += 4;
                }
            } else {
                int i4 = i % 3;
                if (i4 != 1) {
                    if (i4 == 2) {
                        i2 += 3;
                    }
                } else {
                    i2 += 2;
                }
            }
            if (cVar.g && i > 0) {
                int i5 = ((i - 1) / 57) + 1;
                if (!cVar.h) {
                    i3 = 1;
                }
                return i2 + (i5 * i3);
            }
            return i2;
        }
        return invokeI.intValue;
    }
}
