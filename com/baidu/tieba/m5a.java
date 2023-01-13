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
/* loaded from: classes5.dex */
public final class m5a {
    public static /* synthetic */ Interceptable $ic;
    public static final m5a[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925040, "Lcom/baidu/tieba/m5a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925040, "Lcom/baidu/tieba/m5a;");
                return;
            }
        }
        d = new m5a[]{new m5a("", 0, ""), new m5a("", 0, " "), new m5a(" ", 0, " "), new m5a("", 12, ""), new m5a("", 10, " "), new m5a("", 0, " the "), new m5a(" ", 0, ""), new m5a("s ", 0, " "), new m5a("", 0, " of "), new m5a("", 10, ""), new m5a("", 0, " and "), new m5a("", 13, ""), new m5a("", 1, ""), new m5a(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new m5a("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new m5a(" ", 10, " "), new m5a("", 0, " in "), new m5a("", 0, " to "), new m5a("e ", 0, " "), new m5a("", 0, "\""), new m5a("", 0, "."), new m5a("", 0, "\">"), new m5a("", 0, "\n"), new m5a("", 3, ""), new m5a("", 0, PreferencesUtil.RIGHT_MOUNT), new m5a("", 0, " for "), new m5a("", 14, ""), new m5a("", 2, ""), new m5a("", 0, " a "), new m5a("", 0, " that "), new m5a(" ", 10, ""), new m5a("", 0, ". "), new m5a(".", 0, ""), new m5a(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new m5a("", 15, ""), new m5a("", 0, " with "), new m5a("", 0, "'"), new m5a("", 0, " from "), new m5a("", 0, " by "), new m5a("", 16, ""), new m5a("", 17, ""), new m5a(" the ", 0, ""), new m5a("", 4, ""), new m5a("", 0, ". The "), new m5a("", 11, ""), new m5a("", 0, " on "), new m5a("", 0, " as "), new m5a("", 0, " is "), new m5a("", 7, ""), new m5a("", 1, "ing "), new m5a("", 0, "\n\t"), new m5a("", 0, ":"), new m5a(" ", 0, ". "), new m5a("", 0, "ed "), new m5a("", 20, ""), new m5a("", 18, ""), new m5a("", 6, ""), new m5a("", 0, "("), new m5a("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new m5a("", 8, ""), new m5a("", 0, " at "), new m5a("", 0, "ly "), new m5a(" the ", 0, " of "), new m5a("", 5, ""), new m5a("", 9, ""), new m5a(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new m5a("", 10, "\""), new m5a(".", 0, "("), new m5a("", 11, " "), new m5a("", 10, "\">"), new m5a("", 0, "=\""), new m5a(" ", 0, "."), new m5a(".com/", 0, ""), new m5a(" the ", 0, " of the "), new m5a("", 10, "'"), new m5a("", 0, ". This "), new m5a("", 0, ","), new m5a(".", 0, " "), new m5a("", 10, "("), new m5a("", 10, "."), new m5a("", 0, " not "), new m5a(" ", 0, "=\""), new m5a("", 0, "er "), new m5a(" ", 11, " "), new m5a("", 0, "al "), new m5a(" ", 11, ""), new m5a("", 0, "='"), new m5a("", 11, "\""), new m5a("", 10, ". "), new m5a(" ", 0, "("), new m5a("", 0, "ful "), new m5a(" ", 10, ". "), new m5a("", 0, "ive "), new m5a("", 0, "less "), new m5a("", 11, "'"), new m5a("", 0, "est "), new m5a(" ", 10, "."), new m5a("", 11, "\">"), new m5a(" ", 0, "='"), new m5a("", 10, ","), new m5a("", 0, "ize "), new m5a("", 11, "."), new m5a("Â ", 0, ""), new m5a(" ", 0, ","), new m5a("", 10, "=\""), new m5a("", 11, "=\""), new m5a("", 0, "ous "), new m5a("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new m5a("", 10, "='"), new m5a(" ", 10, ","), new m5a(" ", 11, "=\""), new m5a(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new m5a("", 11, ","), new m5a("", 11, "("), new m5a("", 11, ". "), new m5a(" ", 11, "."), new m5a("", 11, "='"), new m5a(" ", 11, ". "), new m5a(" ", 10, "=\""), new m5a(" ", 11, "='"), new m5a(" ", 10, "='")};
    }

    public m5a(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, m5a m5aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), m5aVar})) == null) {
            int i4 = i;
            for (byte b : m5aVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = m5aVar.b;
            int a = o5a.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - o5a.b(i5);
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
            for (byte b3 : m5aVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
