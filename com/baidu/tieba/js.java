package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes6.dex */
public class js {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class b extends a {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(255153222, "Lcom/baidu/tieba/js$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(255153222, "Lcom/baidu/tieba/js$b;");
                    return;
                }
            }
            k = !js.class.desiredAssertionStatus();
            j = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, QCodec.UNDERSCORE};
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = j;
            this.c = new byte[2];
            this.d = 0;
            this.e = 0 != 0 ? 19 : -1;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308612, "Lcom/baidu/tieba/js;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308612, "Lcom/baidu/tieba/js;");
                return;
            }
        }
        a = !js.class.desiredAssertionStatus();
    }

    public js() {
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

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0109, code lost:
        if (r2.h == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010b, code lost:
        r5[r11] = 13;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0110, code lost:
        r5[r11] = 10;
        r11 = r11 + 1;
        r13 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0205 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0216 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0110 -> B:41:0x00bd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        int i2;
        int i3;
        int i4;
        byte b2;
        byte b3;
        byte b4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        int length = bArr.length;
        b bVar = new b();
        int i6 = (length / 3) * 4;
        int i7 = 1;
        if (!bVar.f) {
            int i8 = length % 3;
            if (i8 == 1) {
                i6 += 2;
            } else if (i8 == 2) {
                i6 += 3;
            }
        } else if (length % 3 > 0) {
            i6 += 4;
        }
        if (bVar.g && length > 0) {
            i6 += (((length - 1) / 57) + 1) * (bVar.h ? 2 : 1);
        }
        byte[] bArr2 = new byte[i6];
        bVar.a = bArr2;
        byte[] bArr3 = bVar.i;
        int i9 = bVar.e;
        int i10 = length + 0;
        int i11 = bVar.d;
        if (i11 != 1) {
            if (i11 == 2 && i10 > 0) {
                byte[] bArr4 = bVar.c;
                i = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[0] & 255);
                bVar.d = 0;
                i2 = 1;
            }
            i = -1;
            i2 = 0;
        } else {
            if (2 <= i10) {
                i = ((bVar.c[0] & 255) << 16) | ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                bVar.d = 0;
                i2 = 2;
            }
            i = -1;
            i2 = 0;
        }
        if (i != -1) {
            bArr2[0] = bArr3[(i >> 18) & 63];
            bArr2[1] = bArr3[(i >> 12) & 63];
            bArr2[2] = bArr3[(i >> 6) & 63];
            bArr2[3] = bArr3[i & 63];
            i9--;
            if (i9 == 0) {
                if (bVar.h) {
                    i5 = 5;
                    bArr2[4] = 13;
                } else {
                    i5 = 4;
                }
                i3 = i5 + 1;
                bArr2[i5] = 10;
                i9 = 19;
            } else {
                i3 = 4;
            }
        } else {
            i3 = 0;
        }
        while (true) {
            int i12 = i2 + 3;
            if (i12 > i10) {
                int i13 = bVar.d;
                if (i2 - i13 == i10 - 1) {
                    if (i13 > 0) {
                        b4 = bVar.c[0];
                    } else {
                        b4 = bArr[i2];
                        i2++;
                        i7 = 0;
                    }
                    int i14 = (b4 & 255) << 4;
                    bVar.d -= i7;
                    int i15 = i3 + 1;
                    bArr2[i3] = bArr3[(i14 >> 6) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = bArr3[i14 & 63];
                    if (bVar.f) {
                        int i17 = i16 + 1;
                        bArr2[i16] = 61;
                        i16 = i17 + 1;
                        bArr2[i17] = 61;
                    }
                    if (!bVar.g) {
                        i3 = i16;
                        if (b.k) {
                        }
                        if (b.k) {
                        }
                        bVar.b = i3;
                        bVar.e = i9;
                        if (a) {
                        }
                        return bVar.a;
                    }
                    if (bVar.h) {
                        bArr2[i16] = 13;
                        i16++;
                    }
                    i4 = i16 + 1;
                    bArr2[i16] = 10;
                    i3 = i4;
                    if (!b.k || bVar.d == 0) {
                        if (!b.k || i2 == i10) {
                            bVar.b = i3;
                            bVar.e = i9;
                            if (!a || i3 == i6) {
                                return bVar.a;
                            }
                            throw new AssertionError();
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                } else if (i2 - i13 != i10 - 2) {
                    if (bVar.g && i3 > 0 && i9 != 19) {
                        if (bVar.h) {
                            bArr2[i3] = 13;
                            i3++;
                        }
                        i4 = i3 + 1;
                        bArr2[i3] = 10;
                        i3 = i4;
                    }
                    if (b.k) {
                    }
                    if (b.k) {
                    }
                    bVar.b = i3;
                    bVar.e = i9;
                    if (a) {
                    }
                    return bVar.a;
                } else {
                    if (i13 > 1) {
                        b2 = bVar.c[0];
                    } else {
                        byte b5 = bArr[i2];
                        i2++;
                        b2 = b5;
                        i7 = 0;
                    }
                    int i18 = (b2 & 255) << 10;
                    if (bVar.d > 0) {
                        b3 = bVar.c[i7];
                        i7++;
                    } else {
                        b3 = bArr[i2];
                        i2++;
                    }
                    int i19 = ((b3 & 255) << 2) | i18;
                    bVar.d -= i7;
                    int i20 = i3 + 1;
                    bArr2[i3] = bArr3[(i19 >> 12) & 63];
                    int i21 = i20 + 1;
                    bArr2[i20] = bArr3[(i19 >> 6) & 63];
                    int i22 = i21 + 1;
                    bArr2[i21] = bArr3[i19 & 63];
                    if (bVar.f) {
                        bArr2[i22] = 61;
                        i22++;
                    }
                    if (!bVar.g) {
                        i3 = i22;
                        if (b.k) {
                        }
                        if (b.k) {
                        }
                        bVar.b = i3;
                        bVar.e = i9;
                        if (a) {
                        }
                        return bVar.a;
                    }
                    if (bVar.h) {
                        bArr2[i22] = 13;
                        i22++;
                    }
                    i4 = i22 + 1;
                    bArr2[i22] = 10;
                    i3 = i4;
                    if (b.k) {
                    }
                    if (b.k) {
                    }
                    bVar.b = i3;
                    bVar.e = i9;
                    if (a) {
                    }
                    return bVar.a;
                }
            }
            int i23 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16) | (bArr[i2 + 2] & 255);
            bArr2[i3] = bArr3[(i23 >> 18) & 63];
            bArr2[i3 + 1] = bArr3[(i23 >> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i23 >> 6) & 63];
            bArr2[i3 + 3] = bArr3[i23 & 63];
            i3 += 4;
            i9--;
            if (i9 == 0) {
                break;
            }
            i2 = i12;
        }
    }
}
