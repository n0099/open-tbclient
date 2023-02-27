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
public final class uja {
    public static /* synthetic */ Interceptable $ic;
    public static final uja[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948214301, "Lcom/baidu/tieba/uja;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948214301, "Lcom/baidu/tieba/uja;");
                return;
            }
        }
        d = new uja[]{new uja("", 0, ""), new uja("", 0, " "), new uja(" ", 0, " "), new uja("", 12, ""), new uja("", 10, " "), new uja("", 0, " the "), new uja(" ", 0, ""), new uja("s ", 0, " "), new uja("", 0, " of "), new uja("", 10, ""), new uja("", 0, " and "), new uja("", 13, ""), new uja("", 1, ""), new uja(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new uja("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uja(" ", 10, " "), new uja("", 0, " in "), new uja("", 0, " to "), new uja("e ", 0, " "), new uja("", 0, "\""), new uja("", 0, "."), new uja("", 0, "\">"), new uja("", 0, "\n"), new uja("", 3, ""), new uja("", 0, PreferencesUtil.RIGHT_MOUNT), new uja("", 0, " for "), new uja("", 14, ""), new uja("", 2, ""), new uja("", 0, " a "), new uja("", 0, " that "), new uja(" ", 10, ""), new uja("", 0, ". "), new uja(".", 0, ""), new uja(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uja("", 15, ""), new uja("", 0, " with "), new uja("", 0, "'"), new uja("", 0, " from "), new uja("", 0, " by "), new uja("", 16, ""), new uja("", 17, ""), new uja(" the ", 0, ""), new uja("", 4, ""), new uja("", 0, ". The "), new uja("", 11, ""), new uja("", 0, " on "), new uja("", 0, " as "), new uja("", 0, " is "), new uja("", 7, ""), new uja("", 1, "ing "), new uja("", 0, "\n\t"), new uja("", 0, ":"), new uja(" ", 0, ". "), new uja("", 0, "ed "), new uja("", 20, ""), new uja("", 18, ""), new uja("", 6, ""), new uja("", 0, "("), new uja("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uja("", 8, ""), new uja("", 0, " at "), new uja("", 0, "ly "), new uja(" the ", 0, " of "), new uja("", 5, ""), new uja("", 9, ""), new uja(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uja("", 10, "\""), new uja(".", 0, "("), new uja("", 11, " "), new uja("", 10, "\">"), new uja("", 0, "=\""), new uja(" ", 0, "."), new uja(".com/", 0, ""), new uja(" the ", 0, " of the "), new uja("", 10, "'"), new uja("", 0, ". This "), new uja("", 0, ","), new uja(".", 0, " "), new uja("", 10, "("), new uja("", 10, "."), new uja("", 0, " not "), new uja(" ", 0, "=\""), new uja("", 0, "er "), new uja(" ", 11, " "), new uja("", 0, "al "), new uja(" ", 11, ""), new uja("", 0, "='"), new uja("", 11, "\""), new uja("", 10, ". "), new uja(" ", 0, "("), new uja("", 0, "ful "), new uja(" ", 10, ". "), new uja("", 0, "ive "), new uja("", 0, "less "), new uja("", 11, "'"), new uja("", 0, "est "), new uja(" ", 10, "."), new uja("", 11, "\">"), new uja(" ", 0, "='"), new uja("", 10, ","), new uja("", 0, "ize "), new uja("", 11, "."), new uja("Â ", 0, ""), new uja(" ", 0, ","), new uja("", 10, "=\""), new uja("", 11, "=\""), new uja("", 0, "ous "), new uja("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uja("", 10, "='"), new uja(" ", 10, ","), new uja(" ", 11, "=\""), new uja(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new uja("", 11, ","), new uja("", 11, "("), new uja("", 11, ". "), new uja(" ", 11, "."), new uja("", 11, "='"), new uja(" ", 11, ". "), new uja(" ", 10, "=\""), new uja(" ", 11, "='"), new uja(" ", 10, "='")};
    }

    public uja(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, uja ujaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), ujaVar})) == null) {
            int i4 = i;
            for (byte b : ujaVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = ujaVar.b;
            int a = wja.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - wja.b(i5);
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
            for (byte b3 : ujaVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
