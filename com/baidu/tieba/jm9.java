package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jm9 {
    public static /* synthetic */ Interceptable $ic;
    public static final float[] b;
    public static final float[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947888243, "Lcom/baidu/tieba/jm9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947888243, "Lcom/baidu/tieba/jm9;");
                return;
            }
        }
        b = new float[]{1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
        c = new float[]{1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};
    }

    public jm9() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x008e A[EDGE_INSN: B:114:0x008e->B:44:0x008e ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float b(String str, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        float f;
        char charAt;
        int i8;
        boolean z3;
        boolean z4;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, i2)) == null) {
            this.a = i;
            if (i >= i2) {
                return Float.NaN;
            }
            char charAt3 = str.charAt(i);
            if (charAt3 != '+') {
                if (charAt3 != '-') {
                    z = false;
                    int i9 = this.a;
                    long j = 0;
                    i3 = 0;
                    i4 = 0;
                    int i10 = 0;
                    z2 = false;
                    int i11 = 0;
                    while (true) {
                        i5 = this.a;
                        if (i5 >= i2) {
                            break;
                        }
                        char charAt4 = str.charAt(i5);
                        if (charAt4 == '0') {
                            if (i3 == 0) {
                                i10++;
                            } else {
                                i4++;
                            }
                        } else if (charAt4 >= '1' && charAt4 <= '9') {
                            int i12 = i3 + i4;
                            while (i4 > 0) {
                                if (j > 922337203685477580L) {
                                    return Float.NaN;
                                }
                                j *= 10;
                                i4--;
                            }
                            if (j > 922337203685477580L) {
                                return Float.NaN;
                            }
                            j = (j * 10) + (charAt4 - '0');
                            i3 = i12 + 1;
                            if (j < 0) {
                                return Float.NaN;
                            }
                        } else if (charAt4 != '.' || z2) {
                            break;
                        } else {
                            i11 = this.a - i9;
                            z2 = true;
                        }
                        this.a++;
                    }
                    if (!z2 && this.a == i11 + 1) {
                        return Float.NaN;
                    }
                    if (i3 == 0) {
                        if (i10 == 0) {
                            return Float.NaN;
                        }
                        i3 = 1;
                    }
                    if (z2) {
                        i4 = (i11 - i10) - i3;
                    }
                    i6 = this.a;
                    if (i6 < i2 && ((charAt = str.charAt(i6)) == 'E' || charAt == 'e')) {
                        i8 = this.a + 1;
                        this.a = i8;
                        if (i8 != i2) {
                            return Float.NaN;
                        }
                        char charAt5 = str.charAt(i8);
                        if (charAt5 != '+') {
                            if (charAt5 != '-') {
                                switch (charAt5) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        z3 = false;
                                        z4 = false;
                                        break;
                                    default:
                                        this.a--;
                                        z3 = false;
                                        z4 = true;
                                        break;
                                }
                                if (!z4) {
                                    int i13 = this.a;
                                    int i14 = 0;
                                    while (true) {
                                        int i15 = this.a;
                                        if (i15 < i2 && (charAt2 = str.charAt(i15)) >= '0' && charAt2 <= '9') {
                                            if (i14 > 922337203685477580L) {
                                                return Float.NaN;
                                            }
                                            i14 = (i14 * 10) + (charAt2 - '0');
                                            this.a++;
                                        }
                                    }
                                    if (this.a == i13) {
                                        return Float.NaN;
                                    }
                                    if (z3) {
                                        i4 -= i14;
                                    } else {
                                        i4 += i14;
                                    }
                                }
                            } else {
                                z3 = true;
                            }
                        } else {
                            z3 = false;
                        }
                        this.a++;
                        z4 = false;
                        if (!z4) {
                        }
                    }
                    i7 = i3 + i4;
                    if (i7 <= 39 || i7 < -44) {
                        return Float.NaN;
                    }
                    long j2 = j;
                    float f2 = (float) j2;
                    if (j2 != 0) {
                        if (i4 > 0) {
                            f = b[i4];
                        } else if (i4 < 0) {
                            if (i4 < -38) {
                                f2 = (float) (f2 * 1.0E-20d);
                                i4 += 20;
                            }
                            f = c[-i4];
                        }
                        f2 *= f;
                    }
                    if (z) {
                        return -f2;
                    }
                    return f2;
                }
                z = true;
            } else {
                z = false;
            }
            this.a++;
            int i92 = this.a;
            long j3 = 0;
            i3 = 0;
            i4 = 0;
            int i102 = 0;
            z2 = false;
            int i112 = 0;
            while (true) {
                i5 = this.a;
                if (i5 >= i2) {
                }
                this.a++;
            }
            if (!z2) {
            }
            if (i3 == 0) {
            }
            if (z2) {
            }
            i6 = this.a;
            if (i6 < i2) {
                i8 = this.a + 1;
                this.a = i8;
                if (i8 != i2) {
                }
            }
            i7 = i3 + i4;
            if (i7 <= 39) {
            }
            return Float.NaN;
        }
        return invokeLII.floatValue;
    }
}
