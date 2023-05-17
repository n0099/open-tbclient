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
/* loaded from: classes8.dex */
public final class w5b {
    public static /* synthetic */ Interceptable $ic;
    public static final w5b[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222981, "Lcom/baidu/tieba/w5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222981, "Lcom/baidu/tieba/w5b;");
                return;
            }
        }
        d = new w5b[]{new w5b("", 0, ""), new w5b("", 0, " "), new w5b(" ", 0, " "), new w5b("", 12, ""), new w5b("", 10, " "), new w5b("", 0, " the "), new w5b(" ", 0, ""), new w5b("s ", 0, " "), new w5b("", 0, " of "), new w5b("", 10, ""), new w5b("", 0, " and "), new w5b("", 13, ""), new w5b("", 1, ""), new w5b(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new w5b("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new w5b(" ", 10, " "), new w5b("", 0, " in "), new w5b("", 0, " to "), new w5b("e ", 0, " "), new w5b("", 0, "\""), new w5b("", 0, "."), new w5b("", 0, "\">"), new w5b("", 0, "\n"), new w5b("", 3, ""), new w5b("", 0, PreferencesUtil.RIGHT_MOUNT), new w5b("", 0, " for "), new w5b("", 14, ""), new w5b("", 2, ""), new w5b("", 0, " a "), new w5b("", 0, " that "), new w5b(" ", 10, ""), new w5b("", 0, ". "), new w5b(".", 0, ""), new w5b(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new w5b("", 15, ""), new w5b("", 0, " with "), new w5b("", 0, "'"), new w5b("", 0, " from "), new w5b("", 0, " by "), new w5b("", 16, ""), new w5b("", 17, ""), new w5b(" the ", 0, ""), new w5b("", 4, ""), new w5b("", 0, ". The "), new w5b("", 11, ""), new w5b("", 0, " on "), new w5b("", 0, " as "), new w5b("", 0, " is "), new w5b("", 7, ""), new w5b("", 1, "ing "), new w5b("", 0, "\n\t"), new w5b("", 0, ":"), new w5b(" ", 0, ". "), new w5b("", 0, "ed "), new w5b("", 20, ""), new w5b("", 18, ""), new w5b("", 6, ""), new w5b("", 0, "("), new w5b("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new w5b("", 8, ""), new w5b("", 0, " at "), new w5b("", 0, "ly "), new w5b(" the ", 0, " of "), new w5b("", 5, ""), new w5b("", 9, ""), new w5b(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new w5b("", 10, "\""), new w5b(".", 0, "("), new w5b("", 11, " "), new w5b("", 10, "\">"), new w5b("", 0, "=\""), new w5b(" ", 0, "."), new w5b(".com/", 0, ""), new w5b(" the ", 0, " of the "), new w5b("", 10, "'"), new w5b("", 0, ". This "), new w5b("", 0, ","), new w5b(".", 0, " "), new w5b("", 10, "("), new w5b("", 10, "."), new w5b("", 0, " not "), new w5b(" ", 0, "=\""), new w5b("", 0, "er "), new w5b(" ", 11, " "), new w5b("", 0, "al "), new w5b(" ", 11, ""), new w5b("", 0, "='"), new w5b("", 11, "\""), new w5b("", 10, ". "), new w5b(" ", 0, "("), new w5b("", 0, "ful "), new w5b(" ", 10, ". "), new w5b("", 0, "ive "), new w5b("", 0, "less "), new w5b("", 11, "'"), new w5b("", 0, "est "), new w5b(" ", 10, "."), new w5b("", 11, "\">"), new w5b(" ", 0, "='"), new w5b("", 10, ","), new w5b("", 0, "ize "), new w5b("", 11, "."), new w5b("Â ", 0, ""), new w5b(" ", 0, ","), new w5b("", 10, "=\""), new w5b("", 11, "=\""), new w5b("", 0, "ous "), new w5b("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new w5b("", 10, "='"), new w5b(" ", 10, ","), new w5b(" ", 11, "=\""), new w5b(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new w5b("", 11, ","), new w5b("", 11, "("), new w5b("", 11, ". "), new w5b(" ", 11, "."), new w5b("", 11, "='"), new w5b(" ", 11, ". "), new w5b(" ", 10, "=\""), new w5b(" ", 11, "='"), new w5b(" ", 10, "='")};
    }

    public w5b(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, w5b w5bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), w5bVar})) == null) {
            int i4 = i;
            for (byte b : w5bVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = w5bVar.b;
            int a = y5b.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - y5b.b(i5);
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
            for (byte b3 : w5bVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
