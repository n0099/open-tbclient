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
public final class ulc {
    public static /* synthetic */ Interceptable $ic;
    public static final ulc[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216285, "Lcom/baidu/tieba/ulc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216285, "Lcom/baidu/tieba/ulc;");
                return;
            }
        }
        d = new ulc[]{new ulc("", 0, ""), new ulc("", 0, " "), new ulc(" ", 0, " "), new ulc("", 12, ""), new ulc("", 10, " "), new ulc("", 0, " the "), new ulc(" ", 0, ""), new ulc("s ", 0, " "), new ulc("", 0, " of "), new ulc("", 10, ""), new ulc("", 0, " and "), new ulc("", 13, ""), new ulc("", 1, ""), new ulc(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new ulc("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ulc(" ", 10, " "), new ulc("", 0, " in "), new ulc("", 0, " to "), new ulc("e ", 0, " "), new ulc("", 0, "\""), new ulc("", 0, "."), new ulc("", 0, "\">"), new ulc("", 0, "\n"), new ulc("", 3, ""), new ulc("", 0, PreferencesUtil.RIGHT_MOUNT), new ulc("", 0, " for "), new ulc("", 14, ""), new ulc("", 2, ""), new ulc("", 0, " a "), new ulc("", 0, " that "), new ulc(" ", 10, ""), new ulc("", 0, ". "), new ulc(".", 0, ""), new ulc(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ulc("", 15, ""), new ulc("", 0, " with "), new ulc("", 0, "'"), new ulc("", 0, " from "), new ulc("", 0, " by "), new ulc("", 16, ""), new ulc("", 17, ""), new ulc(" the ", 0, ""), new ulc("", 4, ""), new ulc("", 0, ". The "), new ulc("", 11, ""), new ulc("", 0, " on "), new ulc("", 0, " as "), new ulc("", 0, " is "), new ulc("", 7, ""), new ulc("", 1, "ing "), new ulc("", 0, "\n\t"), new ulc("", 0, ":"), new ulc(" ", 0, ". "), new ulc("", 0, "ed "), new ulc("", 20, ""), new ulc("", 18, ""), new ulc("", 6, ""), new ulc("", 0, "("), new ulc("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ulc("", 8, ""), new ulc("", 0, " at "), new ulc("", 0, "ly "), new ulc(" the ", 0, " of "), new ulc("", 5, ""), new ulc("", 9, ""), new ulc(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ulc("", 10, "\""), new ulc(".", 0, "("), new ulc("", 11, " "), new ulc("", 10, "\">"), new ulc("", 0, "=\""), new ulc(" ", 0, "."), new ulc(".com/", 0, ""), new ulc(" the ", 0, " of the "), new ulc("", 10, "'"), new ulc("", 0, ". This "), new ulc("", 0, ","), new ulc(".", 0, " "), new ulc("", 10, "("), new ulc("", 10, "."), new ulc("", 0, " not "), new ulc(" ", 0, "=\""), new ulc("", 0, "er "), new ulc(" ", 11, " "), new ulc("", 0, "al "), new ulc(" ", 11, ""), new ulc("", 0, "='"), new ulc("", 11, "\""), new ulc("", 10, ". "), new ulc(" ", 0, "("), new ulc("", 0, "ful "), new ulc(" ", 10, ". "), new ulc("", 0, "ive "), new ulc("", 0, "less "), new ulc("", 11, "'"), new ulc("", 0, "est "), new ulc(" ", 10, "."), new ulc("", 11, "\">"), new ulc(" ", 0, "='"), new ulc("", 10, ","), new ulc("", 0, "ize "), new ulc("", 11, "."), new ulc("Â ", 0, ""), new ulc(" ", 0, ","), new ulc("", 10, "=\""), new ulc("", 11, "=\""), new ulc("", 0, "ous "), new ulc("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ulc("", 10, "='"), new ulc(" ", 10, ","), new ulc(" ", 11, "=\""), new ulc(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ulc("", 11, ","), new ulc("", 11, "("), new ulc("", 11, ". "), new ulc(" ", 11, "."), new ulc("", 11, "='"), new ulc(" ", 11, ". "), new ulc(" ", 10, "=\""), new ulc(" ", 11, "='"), new ulc(" ", 10, "='")};
    }

    public ulc(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, ulc ulcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), ulcVar})) == null) {
            int i4 = i;
            for (byte b : ulcVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = ulcVar.b;
            int a = wlc.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - wlc.b(i5);
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
            for (byte b3 : ulcVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
