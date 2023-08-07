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
public final class oyb {
    public static /* synthetic */ Interceptable $ic;
    public static final oyb[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948050001, "Lcom/baidu/tieba/oyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948050001, "Lcom/baidu/tieba/oyb;");
                return;
            }
        }
        d = new oyb[]{new oyb("", 0, ""), new oyb("", 0, " "), new oyb(" ", 0, " "), new oyb("", 12, ""), new oyb("", 10, " "), new oyb("", 0, " the "), new oyb(" ", 0, ""), new oyb("s ", 0, " "), new oyb("", 0, " of "), new oyb("", 10, ""), new oyb("", 0, " and "), new oyb("", 13, ""), new oyb("", 1, ""), new oyb(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new oyb("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oyb(" ", 10, " "), new oyb("", 0, " in "), new oyb("", 0, " to "), new oyb("e ", 0, " "), new oyb("", 0, "\""), new oyb("", 0, "."), new oyb("", 0, "\">"), new oyb("", 0, "\n"), new oyb("", 3, ""), new oyb("", 0, PreferencesUtil.RIGHT_MOUNT), new oyb("", 0, " for "), new oyb("", 14, ""), new oyb("", 2, ""), new oyb("", 0, " a "), new oyb("", 0, " that "), new oyb(" ", 10, ""), new oyb("", 0, ". "), new oyb(".", 0, ""), new oyb(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oyb("", 15, ""), new oyb("", 0, " with "), new oyb("", 0, "'"), new oyb("", 0, " from "), new oyb("", 0, " by "), new oyb("", 16, ""), new oyb("", 17, ""), new oyb(" the ", 0, ""), new oyb("", 4, ""), new oyb("", 0, ". The "), new oyb("", 11, ""), new oyb("", 0, " on "), new oyb("", 0, " as "), new oyb("", 0, " is "), new oyb("", 7, ""), new oyb("", 1, "ing "), new oyb("", 0, "\n\t"), new oyb("", 0, ":"), new oyb(" ", 0, ". "), new oyb("", 0, "ed "), new oyb("", 20, ""), new oyb("", 18, ""), new oyb("", 6, ""), new oyb("", 0, "("), new oyb("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oyb("", 8, ""), new oyb("", 0, " at "), new oyb("", 0, "ly "), new oyb(" the ", 0, " of "), new oyb("", 5, ""), new oyb("", 9, ""), new oyb(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oyb("", 10, "\""), new oyb(".", 0, "("), new oyb("", 11, " "), new oyb("", 10, "\">"), new oyb("", 0, "=\""), new oyb(" ", 0, "."), new oyb(".com/", 0, ""), new oyb(" the ", 0, " of the "), new oyb("", 10, "'"), new oyb("", 0, ". This "), new oyb("", 0, ","), new oyb(".", 0, " "), new oyb("", 10, "("), new oyb("", 10, "."), new oyb("", 0, " not "), new oyb(" ", 0, "=\""), new oyb("", 0, "er "), new oyb(" ", 11, " "), new oyb("", 0, "al "), new oyb(" ", 11, ""), new oyb("", 0, "='"), new oyb("", 11, "\""), new oyb("", 10, ". "), new oyb(" ", 0, "("), new oyb("", 0, "ful "), new oyb(" ", 10, ". "), new oyb("", 0, "ive "), new oyb("", 0, "less "), new oyb("", 11, "'"), new oyb("", 0, "est "), new oyb(" ", 10, "."), new oyb("", 11, "\">"), new oyb(" ", 0, "='"), new oyb("", 10, ","), new oyb("", 0, "ize "), new oyb("", 11, "."), new oyb("Â ", 0, ""), new oyb(" ", 0, ","), new oyb("", 10, "=\""), new oyb("", 11, "=\""), new oyb("", 0, "ous "), new oyb("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oyb("", 10, "='"), new oyb(" ", 10, ","), new oyb(" ", 11, "=\""), new oyb(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oyb("", 11, ","), new oyb("", 11, "("), new oyb("", 11, ". "), new oyb(" ", 11, "."), new oyb("", 11, "='"), new oyb(" ", 11, ". "), new oyb(" ", 10, "=\""), new oyb(" ", 11, "='"), new oyb(" ", 10, "='")};
    }

    public oyb(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, oyb oybVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), oybVar})) == null) {
            int i4 = i;
            for (byte b : oybVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = oybVar.b;
            int a = qyb.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - qyb.b(i5);
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
            for (byte b3 : oybVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
