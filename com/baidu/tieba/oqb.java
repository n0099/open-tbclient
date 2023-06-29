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
public final class oqb {
    public static /* synthetic */ Interceptable $ic;
    public static final oqb[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948042313, "Lcom/baidu/tieba/oqb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948042313, "Lcom/baidu/tieba/oqb;");
                return;
            }
        }
        d = new oqb[]{new oqb("", 0, ""), new oqb("", 0, " "), new oqb(" ", 0, " "), new oqb("", 12, ""), new oqb("", 10, " "), new oqb("", 0, " the "), new oqb(" ", 0, ""), new oqb("s ", 0, " "), new oqb("", 0, " of "), new oqb("", 10, ""), new oqb("", 0, " and "), new oqb("", 13, ""), new oqb("", 1, ""), new oqb(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new oqb("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oqb(" ", 10, " "), new oqb("", 0, " in "), new oqb("", 0, " to "), new oqb("e ", 0, " "), new oqb("", 0, "\""), new oqb("", 0, "."), new oqb("", 0, "\">"), new oqb("", 0, "\n"), new oqb("", 3, ""), new oqb("", 0, PreferencesUtil.RIGHT_MOUNT), new oqb("", 0, " for "), new oqb("", 14, ""), new oqb("", 2, ""), new oqb("", 0, " a "), new oqb("", 0, " that "), new oqb(" ", 10, ""), new oqb("", 0, ". "), new oqb(".", 0, ""), new oqb(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oqb("", 15, ""), new oqb("", 0, " with "), new oqb("", 0, "'"), new oqb("", 0, " from "), new oqb("", 0, " by "), new oqb("", 16, ""), new oqb("", 17, ""), new oqb(" the ", 0, ""), new oqb("", 4, ""), new oqb("", 0, ". The "), new oqb("", 11, ""), new oqb("", 0, " on "), new oqb("", 0, " as "), new oqb("", 0, " is "), new oqb("", 7, ""), new oqb("", 1, "ing "), new oqb("", 0, "\n\t"), new oqb("", 0, ":"), new oqb(" ", 0, ". "), new oqb("", 0, "ed "), new oqb("", 20, ""), new oqb("", 18, ""), new oqb("", 6, ""), new oqb("", 0, "("), new oqb("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oqb("", 8, ""), new oqb("", 0, " at "), new oqb("", 0, "ly "), new oqb(" the ", 0, " of "), new oqb("", 5, ""), new oqb("", 9, ""), new oqb(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oqb("", 10, "\""), new oqb(".", 0, "("), new oqb("", 11, " "), new oqb("", 10, "\">"), new oqb("", 0, "=\""), new oqb(" ", 0, "."), new oqb(".com/", 0, ""), new oqb(" the ", 0, " of the "), new oqb("", 10, "'"), new oqb("", 0, ". This "), new oqb("", 0, ","), new oqb(".", 0, " "), new oqb("", 10, "("), new oqb("", 10, "."), new oqb("", 0, " not "), new oqb(" ", 0, "=\""), new oqb("", 0, "er "), new oqb(" ", 11, " "), new oqb("", 0, "al "), new oqb(" ", 11, ""), new oqb("", 0, "='"), new oqb("", 11, "\""), new oqb("", 10, ". "), new oqb(" ", 0, "("), new oqb("", 0, "ful "), new oqb(" ", 10, ". "), new oqb("", 0, "ive "), new oqb("", 0, "less "), new oqb("", 11, "'"), new oqb("", 0, "est "), new oqb(" ", 10, "."), new oqb("", 11, "\">"), new oqb(" ", 0, "='"), new oqb("", 10, ","), new oqb("", 0, "ize "), new oqb("", 11, "."), new oqb("Â ", 0, ""), new oqb(" ", 0, ","), new oqb("", 10, "=\""), new oqb("", 11, "=\""), new oqb("", 0, "ous "), new oqb("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oqb("", 10, "='"), new oqb(" ", 10, ","), new oqb(" ", 11, "=\""), new oqb(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new oqb("", 11, ","), new oqb("", 11, "("), new oqb("", 11, ". "), new oqb(" ", 11, "."), new oqb("", 11, "='"), new oqb(" ", 11, ". "), new oqb(" ", 10, "=\""), new oqb(" ", 11, "='"), new oqb(" ", 10, "='")};
    }

    public oqb(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, oqb oqbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), oqbVar})) == null) {
            int i4 = i;
            for (byte b : oqbVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = oqbVar.b;
            int a = qqb.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - qqb.b(i5);
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
            for (byte b3 : oqbVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
