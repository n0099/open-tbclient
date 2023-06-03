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
public final class zjb {
    public static /* synthetic */ Interceptable $ic;
    public static final zjb[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948363287, "Lcom/baidu/tieba/zjb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948363287, "Lcom/baidu/tieba/zjb;");
                return;
            }
        }
        d = new zjb[]{new zjb("", 0, ""), new zjb("", 0, " "), new zjb(" ", 0, " "), new zjb("", 12, ""), new zjb("", 10, " "), new zjb("", 0, " the "), new zjb(" ", 0, ""), new zjb("s ", 0, " "), new zjb("", 0, " of "), new zjb("", 10, ""), new zjb("", 0, " and "), new zjb("", 13, ""), new zjb("", 1, ""), new zjb(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new zjb("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zjb(" ", 10, " "), new zjb("", 0, " in "), new zjb("", 0, " to "), new zjb("e ", 0, " "), new zjb("", 0, "\""), new zjb("", 0, "."), new zjb("", 0, "\">"), new zjb("", 0, "\n"), new zjb("", 3, ""), new zjb("", 0, PreferencesUtil.RIGHT_MOUNT), new zjb("", 0, " for "), new zjb("", 14, ""), new zjb("", 2, ""), new zjb("", 0, " a "), new zjb("", 0, " that "), new zjb(" ", 10, ""), new zjb("", 0, ". "), new zjb(".", 0, ""), new zjb(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zjb("", 15, ""), new zjb("", 0, " with "), new zjb("", 0, "'"), new zjb("", 0, " from "), new zjb("", 0, " by "), new zjb("", 16, ""), new zjb("", 17, ""), new zjb(" the ", 0, ""), new zjb("", 4, ""), new zjb("", 0, ". The "), new zjb("", 11, ""), new zjb("", 0, " on "), new zjb("", 0, " as "), new zjb("", 0, " is "), new zjb("", 7, ""), new zjb("", 1, "ing "), new zjb("", 0, "\n\t"), new zjb("", 0, ":"), new zjb(" ", 0, ". "), new zjb("", 0, "ed "), new zjb("", 20, ""), new zjb("", 18, ""), new zjb("", 6, ""), new zjb("", 0, "("), new zjb("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zjb("", 8, ""), new zjb("", 0, " at "), new zjb("", 0, "ly "), new zjb(" the ", 0, " of "), new zjb("", 5, ""), new zjb("", 9, ""), new zjb(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zjb("", 10, "\""), new zjb(".", 0, "("), new zjb("", 11, " "), new zjb("", 10, "\">"), new zjb("", 0, "=\""), new zjb(" ", 0, "."), new zjb(".com/", 0, ""), new zjb(" the ", 0, " of the "), new zjb("", 10, "'"), new zjb("", 0, ". This "), new zjb("", 0, ","), new zjb(".", 0, " "), new zjb("", 10, "("), new zjb("", 10, "."), new zjb("", 0, " not "), new zjb(" ", 0, "=\""), new zjb("", 0, "er "), new zjb(" ", 11, " "), new zjb("", 0, "al "), new zjb(" ", 11, ""), new zjb("", 0, "='"), new zjb("", 11, "\""), new zjb("", 10, ". "), new zjb(" ", 0, "("), new zjb("", 0, "ful "), new zjb(" ", 10, ". "), new zjb("", 0, "ive "), new zjb("", 0, "less "), new zjb("", 11, "'"), new zjb("", 0, "est "), new zjb(" ", 10, "."), new zjb("", 11, "\">"), new zjb(" ", 0, "='"), new zjb("", 10, ","), new zjb("", 0, "ize "), new zjb("", 11, "."), new zjb("Â ", 0, ""), new zjb(" ", 0, ","), new zjb("", 10, "=\""), new zjb("", 11, "=\""), new zjb("", 0, "ous "), new zjb("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zjb("", 10, "='"), new zjb(" ", 10, ","), new zjb(" ", 11, "=\""), new zjb(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zjb("", 11, ","), new zjb("", 11, "("), new zjb("", 11, ". "), new zjb(" ", 11, "."), new zjb("", 11, "='"), new zjb(" ", 11, ". "), new zjb(" ", 10, "=\""), new zjb(" ", 11, "='"), new zjb(" ", 10, "='")};
    }

    public zjb(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, zjb zjbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), zjbVar})) == null) {
            int i4 = i;
            for (byte b : zjbVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = zjbVar.b;
            int a = bkb.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - bkb.b(i5);
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
            for (byte b3 : zjbVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
