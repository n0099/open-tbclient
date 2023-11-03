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
/* loaded from: classes9.dex */
public final class zgc {
    public static /* synthetic */ Interceptable $ic;
    public static final zgc[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948360435, "Lcom/baidu/tieba/zgc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948360435, "Lcom/baidu/tieba/zgc;");
                return;
            }
        }
        d = new zgc[]{new zgc("", 0, ""), new zgc("", 0, " "), new zgc(" ", 0, " "), new zgc("", 12, ""), new zgc("", 10, " "), new zgc("", 0, " the "), new zgc(" ", 0, ""), new zgc("s ", 0, " "), new zgc("", 0, " of "), new zgc("", 10, ""), new zgc("", 0, " and "), new zgc("", 13, ""), new zgc("", 1, ""), new zgc(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new zgc("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zgc(" ", 10, " "), new zgc("", 0, " in "), new zgc("", 0, " to "), new zgc("e ", 0, " "), new zgc("", 0, "\""), new zgc("", 0, "."), new zgc("", 0, "\">"), new zgc("", 0, "\n"), new zgc("", 3, ""), new zgc("", 0, PreferencesUtil.RIGHT_MOUNT), new zgc("", 0, " for "), new zgc("", 14, ""), new zgc("", 2, ""), new zgc("", 0, " a "), new zgc("", 0, " that "), new zgc(" ", 10, ""), new zgc("", 0, ". "), new zgc(".", 0, ""), new zgc(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zgc("", 15, ""), new zgc("", 0, " with "), new zgc("", 0, "'"), new zgc("", 0, " from "), new zgc("", 0, " by "), new zgc("", 16, ""), new zgc("", 17, ""), new zgc(" the ", 0, ""), new zgc("", 4, ""), new zgc("", 0, ". The "), new zgc("", 11, ""), new zgc("", 0, " on "), new zgc("", 0, " as "), new zgc("", 0, " is "), new zgc("", 7, ""), new zgc("", 1, "ing "), new zgc("", 0, "\n\t"), new zgc("", 0, ":"), new zgc(" ", 0, ". "), new zgc("", 0, "ed "), new zgc("", 20, ""), new zgc("", 18, ""), new zgc("", 6, ""), new zgc("", 0, "("), new zgc("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zgc("", 8, ""), new zgc("", 0, " at "), new zgc("", 0, "ly "), new zgc(" the ", 0, " of "), new zgc("", 5, ""), new zgc("", 9, ""), new zgc(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zgc("", 10, "\""), new zgc(".", 0, "("), new zgc("", 11, " "), new zgc("", 10, "\">"), new zgc("", 0, "=\""), new zgc(" ", 0, "."), new zgc(".com/", 0, ""), new zgc(" the ", 0, " of the "), new zgc("", 10, "'"), new zgc("", 0, ". This "), new zgc("", 0, ","), new zgc(".", 0, " "), new zgc("", 10, "("), new zgc("", 10, "."), new zgc("", 0, " not "), new zgc(" ", 0, "=\""), new zgc("", 0, "er "), new zgc(" ", 11, " "), new zgc("", 0, "al "), new zgc(" ", 11, ""), new zgc("", 0, "='"), new zgc("", 11, "\""), new zgc("", 10, ". "), new zgc(" ", 0, "("), new zgc("", 0, "ful "), new zgc(" ", 10, ". "), new zgc("", 0, "ive "), new zgc("", 0, "less "), new zgc("", 11, "'"), new zgc("", 0, "est "), new zgc(" ", 10, "."), new zgc("", 11, "\">"), new zgc(" ", 0, "='"), new zgc("", 10, ","), new zgc("", 0, "ize "), new zgc("", 11, "."), new zgc("Â ", 0, ""), new zgc(" ", 0, ","), new zgc("", 10, "=\""), new zgc("", 11, "=\""), new zgc("", 0, "ous "), new zgc("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zgc("", 10, "='"), new zgc(" ", 10, ","), new zgc(" ", 11, "=\""), new zgc(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zgc("", 11, ","), new zgc("", 11, "("), new zgc("", 11, ". "), new zgc(" ", 11, "."), new zgc("", 11, "='"), new zgc(" ", 11, ". "), new zgc(" ", 10, "=\""), new zgc(" ", 11, "='"), new zgc(" ", 10, "='")};
    }

    public zgc(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, zgc zgcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), zgcVar})) == null) {
            int i4 = i;
            for (byte b : zgcVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = zgcVar.b;
            int a = bhc.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - bhc.b(i5);
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
            for (byte b3 : zgcVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
