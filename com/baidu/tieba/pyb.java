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
public final class pyb {
    public static /* synthetic */ Interceptable $ic;
    public static final pyb[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948079792, "Lcom/baidu/tieba/pyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948079792, "Lcom/baidu/tieba/pyb;");
                return;
            }
        }
        d = new pyb[]{new pyb("", 0, ""), new pyb("", 0, " "), new pyb(" ", 0, " "), new pyb("", 12, ""), new pyb("", 10, " "), new pyb("", 0, " the "), new pyb(" ", 0, ""), new pyb("s ", 0, " "), new pyb("", 0, " of "), new pyb("", 10, ""), new pyb("", 0, " and "), new pyb("", 13, ""), new pyb("", 1, ""), new pyb(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new pyb("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new pyb(" ", 10, " "), new pyb("", 0, " in "), new pyb("", 0, " to "), new pyb("e ", 0, " "), new pyb("", 0, "\""), new pyb("", 0, "."), new pyb("", 0, "\">"), new pyb("", 0, "\n"), new pyb("", 3, ""), new pyb("", 0, PreferencesUtil.RIGHT_MOUNT), new pyb("", 0, " for "), new pyb("", 14, ""), new pyb("", 2, ""), new pyb("", 0, " a "), new pyb("", 0, " that "), new pyb(" ", 10, ""), new pyb("", 0, ". "), new pyb(".", 0, ""), new pyb(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new pyb("", 15, ""), new pyb("", 0, " with "), new pyb("", 0, "'"), new pyb("", 0, " from "), new pyb("", 0, " by "), new pyb("", 16, ""), new pyb("", 17, ""), new pyb(" the ", 0, ""), new pyb("", 4, ""), new pyb("", 0, ". The "), new pyb("", 11, ""), new pyb("", 0, " on "), new pyb("", 0, " as "), new pyb("", 0, " is "), new pyb("", 7, ""), new pyb("", 1, "ing "), new pyb("", 0, "\n\t"), new pyb("", 0, ":"), new pyb(" ", 0, ". "), new pyb("", 0, "ed "), new pyb("", 20, ""), new pyb("", 18, ""), new pyb("", 6, ""), new pyb("", 0, "("), new pyb("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new pyb("", 8, ""), new pyb("", 0, " at "), new pyb("", 0, "ly "), new pyb(" the ", 0, " of "), new pyb("", 5, ""), new pyb("", 9, ""), new pyb(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new pyb("", 10, "\""), new pyb(".", 0, "("), new pyb("", 11, " "), new pyb("", 10, "\">"), new pyb("", 0, "=\""), new pyb(" ", 0, "."), new pyb(".com/", 0, ""), new pyb(" the ", 0, " of the "), new pyb("", 10, "'"), new pyb("", 0, ". This "), new pyb("", 0, ","), new pyb(".", 0, " "), new pyb("", 10, "("), new pyb("", 10, "."), new pyb("", 0, " not "), new pyb(" ", 0, "=\""), new pyb("", 0, "er "), new pyb(" ", 11, " "), new pyb("", 0, "al "), new pyb(" ", 11, ""), new pyb("", 0, "='"), new pyb("", 11, "\""), new pyb("", 10, ". "), new pyb(" ", 0, "("), new pyb("", 0, "ful "), new pyb(" ", 10, ". "), new pyb("", 0, "ive "), new pyb("", 0, "less "), new pyb("", 11, "'"), new pyb("", 0, "est "), new pyb(" ", 10, "."), new pyb("", 11, "\">"), new pyb(" ", 0, "='"), new pyb("", 10, ","), new pyb("", 0, "ize "), new pyb("", 11, "."), new pyb("Â ", 0, ""), new pyb(" ", 0, ","), new pyb("", 10, "=\""), new pyb("", 11, "=\""), new pyb("", 0, "ous "), new pyb("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new pyb("", 10, "='"), new pyb(" ", 10, ","), new pyb(" ", 11, "=\""), new pyb(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new pyb("", 11, ","), new pyb("", 11, "("), new pyb("", 11, ". "), new pyb(" ", 11, "."), new pyb("", 11, "='"), new pyb(" ", 11, ". "), new pyb(" ", 10, "=\""), new pyb(" ", 11, "='"), new pyb(" ", 10, "='")};
    }

    public pyb(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, pyb pybVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), pybVar})) == null) {
            int i4 = i;
            for (byte b : pybVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = pybVar.b;
            int a = ryb.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - ryb.b(i5);
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
            for (byte b3 : pybVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
