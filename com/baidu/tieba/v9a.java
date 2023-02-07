package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class v9a {
    public static /* synthetic */ Interceptable $ic;
    public static final v9a[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948197003, "Lcom/baidu/tieba/v9a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948197003, "Lcom/baidu/tieba/v9a;");
                return;
            }
        }
        d = new v9a[]{new v9a("", 0, ""), new v9a("", 0, " "), new v9a(" ", 0, " "), new v9a("", 12, ""), new v9a("", 10, " "), new v9a("", 0, " the "), new v9a(" ", 0, ""), new v9a("s ", 0, " "), new v9a("", 0, " of "), new v9a("", 10, ""), new v9a("", 0, " and "), new v9a("", 13, ""), new v9a("", 1, ""), new v9a(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new v9a("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new v9a(" ", 10, " "), new v9a("", 0, " in "), new v9a("", 0, " to "), new v9a("e ", 0, " "), new v9a("", 0, "\""), new v9a("", 0, "."), new v9a("", 0, "\">"), new v9a("", 0, "\n"), new v9a("", 3, ""), new v9a("", 0, PreferencesUtil.RIGHT_MOUNT), new v9a("", 0, " for "), new v9a("", 14, ""), new v9a("", 2, ""), new v9a("", 0, " a "), new v9a("", 0, " that "), new v9a(" ", 10, ""), new v9a("", 0, ". "), new v9a(".", 0, ""), new v9a(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new v9a("", 15, ""), new v9a("", 0, " with "), new v9a("", 0, "'"), new v9a("", 0, " from "), new v9a("", 0, " by "), new v9a("", 16, ""), new v9a("", 17, ""), new v9a(" the ", 0, ""), new v9a("", 4, ""), new v9a("", 0, ". The "), new v9a("", 11, ""), new v9a("", 0, " on "), new v9a("", 0, " as "), new v9a("", 0, " is "), new v9a("", 7, ""), new v9a("", 1, "ing "), new v9a("", 0, "\n\t"), new v9a("", 0, ":"), new v9a(" ", 0, ". "), new v9a("", 0, "ed "), new v9a("", 20, ""), new v9a("", 18, ""), new v9a("", 6, ""), new v9a("", 0, "("), new v9a("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new v9a("", 8, ""), new v9a("", 0, " at "), new v9a("", 0, "ly "), new v9a(" the ", 0, " of "), new v9a("", 5, ""), new v9a("", 9, ""), new v9a(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new v9a("", 10, "\""), new v9a(".", 0, "("), new v9a("", 11, " "), new v9a("", 10, "\">"), new v9a("", 0, "=\""), new v9a(" ", 0, "."), new v9a(".com/", 0, ""), new v9a(" the ", 0, " of the "), new v9a("", 10, "'"), new v9a("", 0, ". This "), new v9a("", 0, ","), new v9a(".", 0, " "), new v9a("", 10, "("), new v9a("", 10, "."), new v9a("", 0, " not "), new v9a(" ", 0, "=\""), new v9a("", 0, "er "), new v9a(" ", 11, " "), new v9a("", 0, "al "), new v9a(" ", 11, ""), new v9a("", 0, "='"), new v9a("", 11, "\""), new v9a("", 10, ". "), new v9a(" ", 0, "("), new v9a("", 0, "ful "), new v9a(" ", 10, ". "), new v9a("", 0, "ive "), new v9a("", 0, "less "), new v9a("", 11, "'"), new v9a("", 0, "est "), new v9a(" ", 10, "."), new v9a("", 11, "\">"), new v9a(" ", 0, "='"), new v9a("", 10, ","), new v9a("", 0, "ize "), new v9a("", 11, "."), new v9a("Â ", 0, ""), new v9a(" ", 0, ","), new v9a("", 10, "=\""), new v9a("", 11, "=\""), new v9a("", 0, "ous "), new v9a("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new v9a("", 10, "='"), new v9a(" ", 10, ","), new v9a(" ", 11, "=\""), new v9a(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new v9a("", 11, ","), new v9a("", 11, "("), new v9a("", 11, ". "), new v9a(" ", 11, "."), new v9a("", 11, "='"), new v9a(" ", 11, ". "), new v9a(" ", 10, "=\""), new v9a(" ", 11, "='"), new v9a(" ", 10, "='")};
    }

    public v9a(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = a(str);
        this.b = i;
        this.c = a(str2);
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) str.charAt(i);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, v9a v9aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), v9aVar})) == null) {
            int i4 = i;
            for (byte b : v9aVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = v9aVar.b;
            int a = x9a.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - x9a.b(i5);
            int i7 = b2;
            while (i7 > 0) {
                bArr[i4] = bArr2[i6];
                i7--;
                i4++;
                i6++;
            }
            if (i5 == 11 || i5 == 10) {
                int i8 = i4 - b2;
                if (i5 == 10) {
                    b2 = 1;
                }
                while (b2 > 0) {
                    int i9 = bArr[i8] & 255;
                    if (i9 < 192) {
                        if (i9 >= 97 && i9 <= 122) {
                            bArr[i8] = (byte) (bArr[i8] ^ 32);
                        }
                        i8++;
                        b2--;
                    } else if (i9 < 224) {
                        int i10 = i8 + 1;
                        bArr[i10] = (byte) (bArr[i10] ^ 32);
                        i8 += 2;
                        b2 -= 2;
                    } else {
                        int i11 = i8 + 2;
                        bArr[i11] = (byte) (bArr[i11] ^ 5);
                        i8 += 3;
                        b2 -= 3;
                    }
                }
            }
            for (byte b3 : v9aVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
