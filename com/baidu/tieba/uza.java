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
public final class uza {
    public static /* synthetic */ Interceptable $ic;
    public static final uza[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948229677, "Lcom/baidu/tieba/uza;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948229677, "Lcom/baidu/tieba/uza;");
                return;
            }
        }
        d = new uza[]{new uza("", 0, ""), new uza("", 0, " "), new uza(" ", 0, " "), new uza("", 12, ""), new uza("", 10, " "), new uza("", 0, " the "), new uza(" ", 0, ""), new uza("s ", 0, " "), new uza("", 0, " of "), new uza("", 10, ""), new uza("", 0, " and "), new uza("", 13, ""), new uza("", 1, ""), new uza(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new uza("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uza(" ", 10, " "), new uza("", 0, " in "), new uza("", 0, " to "), new uza("e ", 0, " "), new uza("", 0, "\""), new uza("", 0, "."), new uza("", 0, "\">"), new uza("", 0, "\n"), new uza("", 3, ""), new uza("", 0, PreferencesUtil.RIGHT_MOUNT), new uza("", 0, " for "), new uza("", 14, ""), new uza("", 2, ""), new uza("", 0, " a "), new uza("", 0, " that "), new uza(" ", 10, ""), new uza("", 0, ". "), new uza(".", 0, ""), new uza(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uza("", 15, ""), new uza("", 0, " with "), new uza("", 0, "'"), new uza("", 0, " from "), new uza("", 0, " by "), new uza("", 16, ""), new uza("", 17, ""), new uza(" the ", 0, ""), new uza("", 4, ""), new uza("", 0, ". The "), new uza("", 11, ""), new uza("", 0, " on "), new uza("", 0, " as "), new uza("", 0, " is "), new uza("", 7, ""), new uza("", 1, "ing "), new uza("", 0, "\n\t"), new uza("", 0, ":"), new uza(" ", 0, ". "), new uza("", 0, "ed "), new uza("", 20, ""), new uza("", 18, ""), new uza("", 6, ""), new uza("", 0, "("), new uza("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uza("", 8, ""), new uza("", 0, " at "), new uza("", 0, "ly "), new uza(" the ", 0, " of "), new uza("", 5, ""), new uza("", 9, ""), new uza(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uza("", 10, "\""), new uza(".", 0, "("), new uza("", 11, " "), new uza("", 10, "\">"), new uza("", 0, "=\""), new uza(" ", 0, "."), new uza(".com/", 0, ""), new uza(" the ", 0, " of the "), new uza("", 10, "'"), new uza("", 0, ". This "), new uza("", 0, ","), new uza(".", 0, " "), new uza("", 10, "("), new uza("", 10, "."), new uza("", 0, " not "), new uza(" ", 0, "=\""), new uza("", 0, "er "), new uza(" ", 11, " "), new uza("", 0, "al "), new uza(" ", 11, ""), new uza("", 0, "='"), new uza("", 11, "\""), new uza("", 10, ". "), new uza(" ", 0, "("), new uza("", 0, "ful "), new uza(" ", 10, ". "), new uza("", 0, "ive "), new uza("", 0, "less "), new uza("", 11, "'"), new uza("", 0, "est "), new uza(" ", 10, "."), new uza("", 11, "\">"), new uza(" ", 0, "='"), new uza("", 10, ","), new uza("", 0, "ize "), new uza("", 11, "."), new uza("Â ", 0, ""), new uza(" ", 0, ","), new uza("", 10, "=\""), new uza("", 11, "=\""), new uza("", 0, "ous "), new uza("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uza("", 10, "='"), new uza(" ", 10, ","), new uza(" ", 11, "=\""), new uza(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uza("", 11, ","), new uza("", 11, "("), new uza("", 11, ". "), new uza(" ", 11, "."), new uza("", 11, "='"), new uza(" ", 11, ". "), new uza(" ", 10, "=\""), new uza(" ", 11, "='"), new uza(" ", 10, "='")};
    }

    public uza(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, uza uzaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), uzaVar})) == null) {
            int i4 = i;
            for (byte b : uzaVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = uzaVar.b;
            int a = wza.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - wza.b(i5);
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
            for (byte b3 : uzaVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
