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
/* loaded from: classes7.dex */
public final class y3b {
    public static /* synthetic */ Interceptable $ic;
    public static final y3b[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280641, "Lcom/baidu/tieba/y3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280641, "Lcom/baidu/tieba/y3b;");
                return;
            }
        }
        d = new y3b[]{new y3b("", 0, ""), new y3b("", 0, " "), new y3b(" ", 0, " "), new y3b("", 12, ""), new y3b("", 10, " "), new y3b("", 0, " the "), new y3b(" ", 0, ""), new y3b("s ", 0, " "), new y3b("", 0, " of "), new y3b("", 10, ""), new y3b("", 0, " and "), new y3b("", 13, ""), new y3b("", 1, ""), new y3b(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new y3b("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new y3b(" ", 10, " "), new y3b("", 0, " in "), new y3b("", 0, " to "), new y3b("e ", 0, " "), new y3b("", 0, "\""), new y3b("", 0, "."), new y3b("", 0, "\">"), new y3b("", 0, "\n"), new y3b("", 3, ""), new y3b("", 0, PreferencesUtil.RIGHT_MOUNT), new y3b("", 0, " for "), new y3b("", 14, ""), new y3b("", 2, ""), new y3b("", 0, " a "), new y3b("", 0, " that "), new y3b(" ", 10, ""), new y3b("", 0, ". "), new y3b(".", 0, ""), new y3b(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new y3b("", 15, ""), new y3b("", 0, " with "), new y3b("", 0, "'"), new y3b("", 0, " from "), new y3b("", 0, " by "), new y3b("", 16, ""), new y3b("", 17, ""), new y3b(" the ", 0, ""), new y3b("", 4, ""), new y3b("", 0, ". The "), new y3b("", 11, ""), new y3b("", 0, " on "), new y3b("", 0, " as "), new y3b("", 0, " is "), new y3b("", 7, ""), new y3b("", 1, "ing "), new y3b("", 0, "\n\t"), new y3b("", 0, ":"), new y3b(" ", 0, ". "), new y3b("", 0, "ed "), new y3b("", 20, ""), new y3b("", 18, ""), new y3b("", 6, ""), new y3b("", 0, "("), new y3b("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new y3b("", 8, ""), new y3b("", 0, " at "), new y3b("", 0, "ly "), new y3b(" the ", 0, " of "), new y3b("", 5, ""), new y3b("", 9, ""), new y3b(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new y3b("", 10, "\""), new y3b(".", 0, "("), new y3b("", 11, " "), new y3b("", 10, "\">"), new y3b("", 0, "=\""), new y3b(" ", 0, "."), new y3b(".com/", 0, ""), new y3b(" the ", 0, " of the "), new y3b("", 10, "'"), new y3b("", 0, ". This "), new y3b("", 0, ","), new y3b(".", 0, " "), new y3b("", 10, "("), new y3b("", 10, "."), new y3b("", 0, " not "), new y3b(" ", 0, "=\""), new y3b("", 0, "er "), new y3b(" ", 11, " "), new y3b("", 0, "al "), new y3b(" ", 11, ""), new y3b("", 0, "='"), new y3b("", 11, "\""), new y3b("", 10, ". "), new y3b(" ", 0, "("), new y3b("", 0, "ful "), new y3b(" ", 10, ". "), new y3b("", 0, "ive "), new y3b("", 0, "less "), new y3b("", 11, "'"), new y3b("", 0, "est "), new y3b(" ", 10, "."), new y3b("", 11, "\">"), new y3b(" ", 0, "='"), new y3b("", 10, ","), new y3b("", 0, "ize "), new y3b("", 11, "."), new y3b("Â ", 0, ""), new y3b(" ", 0, ","), new y3b("", 10, "=\""), new y3b("", 11, "=\""), new y3b("", 0, "ous "), new y3b("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new y3b("", 10, "='"), new y3b(" ", 10, ","), new y3b(" ", 11, "=\""), new y3b(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new y3b("", 11, ","), new y3b("", 11, "("), new y3b("", 11, ". "), new y3b(" ", 11, "."), new y3b("", 11, "='"), new y3b(" ", 11, ". "), new y3b(" ", 10, "=\""), new y3b(" ", 11, "='"), new y3b(" ", 10, "='")};
    }

    public y3b(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, y3b y3bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), y3bVar})) == null) {
            int i4 = i;
            for (byte b : y3bVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = y3bVar.b;
            int a = a4b.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - a4b.b(i5);
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
            for (byte b3 : y3bVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
