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
public final class uw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final uw9[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948225554, "Lcom/baidu/tieba/uw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948225554, "Lcom/baidu/tieba/uw9;");
                return;
            }
        }
        d = new uw9[]{new uw9("", 0, ""), new uw9("", 0, " "), new uw9(" ", 0, " "), new uw9("", 12, ""), new uw9("", 10, " "), new uw9("", 0, " the "), new uw9(" ", 0, ""), new uw9("s ", 0, " "), new uw9("", 0, " of "), new uw9("", 10, ""), new uw9("", 0, " and "), new uw9("", 13, ""), new uw9("", 1, ""), new uw9(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new uw9("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uw9(" ", 10, " "), new uw9("", 0, " in "), new uw9("", 0, " to "), new uw9("e ", 0, " "), new uw9("", 0, "\""), new uw9("", 0, "."), new uw9("", 0, "\">"), new uw9("", 0, "\n"), new uw9("", 3, ""), new uw9("", 0, PreferencesUtil.RIGHT_MOUNT), new uw9("", 0, " for "), new uw9("", 14, ""), new uw9("", 2, ""), new uw9("", 0, " a "), new uw9("", 0, " that "), new uw9(" ", 10, ""), new uw9("", 0, ". "), new uw9(".", 0, ""), new uw9(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uw9("", 15, ""), new uw9("", 0, " with "), new uw9("", 0, "'"), new uw9("", 0, " from "), new uw9("", 0, " by "), new uw9("", 16, ""), new uw9("", 17, ""), new uw9(" the ", 0, ""), new uw9("", 4, ""), new uw9("", 0, ". The "), new uw9("", 11, ""), new uw9("", 0, " on "), new uw9("", 0, " as "), new uw9("", 0, " is "), new uw9("", 7, ""), new uw9("", 1, "ing "), new uw9("", 0, "\n\t"), new uw9("", 0, ":"), new uw9(" ", 0, ". "), new uw9("", 0, "ed "), new uw9("", 20, ""), new uw9("", 18, ""), new uw9("", 6, ""), new uw9("", 0, "("), new uw9("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uw9("", 8, ""), new uw9("", 0, " at "), new uw9("", 0, "ly "), new uw9(" the ", 0, " of "), new uw9("", 5, ""), new uw9("", 9, ""), new uw9(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uw9("", 10, "\""), new uw9(".", 0, "("), new uw9("", 11, " "), new uw9("", 10, "\">"), new uw9("", 0, "=\""), new uw9(" ", 0, "."), new uw9(".com/", 0, ""), new uw9(" the ", 0, " of the "), new uw9("", 10, "'"), new uw9("", 0, ". This "), new uw9("", 0, ","), new uw9(".", 0, " "), new uw9("", 10, "("), new uw9("", 10, "."), new uw9("", 0, " not "), new uw9(" ", 0, "=\""), new uw9("", 0, "er "), new uw9(" ", 11, " "), new uw9("", 0, "al "), new uw9(" ", 11, ""), new uw9("", 0, "='"), new uw9("", 11, "\""), new uw9("", 10, ". "), new uw9(" ", 0, "("), new uw9("", 0, "ful "), new uw9(" ", 10, ". "), new uw9("", 0, "ive "), new uw9("", 0, "less "), new uw9("", 11, "'"), new uw9("", 0, "est "), new uw9(" ", 10, "."), new uw9("", 11, "\">"), new uw9(" ", 0, "='"), new uw9("", 10, ","), new uw9("", 0, "ize "), new uw9("", 11, "."), new uw9("Â ", 0, ""), new uw9(" ", 0, ","), new uw9("", 10, "=\""), new uw9("", 11, "=\""), new uw9("", 0, "ous "), new uw9("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uw9("", 10, "='"), new uw9(" ", 10, ","), new uw9(" ", 11, "=\""), new uw9(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uw9("", 11, ","), new uw9("", 11, "("), new uw9("", 11, ". "), new uw9(" ", 11, "."), new uw9("", 11, "='"), new uw9(" ", 11, ". "), new uw9(" ", 10, "=\""), new uw9(" ", 11, "='"), new uw9(" ", 10, "='")};
    }

    public uw9(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, uw9 uw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), uw9Var})) == null) {
            int i4 = i;
            for (byte b : uw9Var.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = uw9Var.b;
            int a = ww9.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - ww9.b(i5);
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
            for (byte b3 : uw9Var.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
