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
public final class lzb {
    public static /* synthetic */ Interceptable $ic;
    public static final lzb[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947961589, "Lcom/baidu/tieba/lzb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947961589, "Lcom/baidu/tieba/lzb;");
                return;
            }
        }
        d = new lzb[]{new lzb("", 0, ""), new lzb("", 0, " "), new lzb(" ", 0, " "), new lzb("", 12, ""), new lzb("", 10, " "), new lzb("", 0, " the "), new lzb(" ", 0, ""), new lzb("s ", 0, " "), new lzb("", 0, " of "), new lzb("", 10, ""), new lzb("", 0, " and "), new lzb("", 13, ""), new lzb("", 1, ""), new lzb(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new lzb("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new lzb(" ", 10, " "), new lzb("", 0, " in "), new lzb("", 0, " to "), new lzb("e ", 0, " "), new lzb("", 0, "\""), new lzb("", 0, "."), new lzb("", 0, "\">"), new lzb("", 0, "\n"), new lzb("", 3, ""), new lzb("", 0, PreferencesUtil.RIGHT_MOUNT), new lzb("", 0, " for "), new lzb("", 14, ""), new lzb("", 2, ""), new lzb("", 0, " a "), new lzb("", 0, " that "), new lzb(" ", 10, ""), new lzb("", 0, ". "), new lzb(".", 0, ""), new lzb(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new lzb("", 15, ""), new lzb("", 0, " with "), new lzb("", 0, "'"), new lzb("", 0, " from "), new lzb("", 0, " by "), new lzb("", 16, ""), new lzb("", 17, ""), new lzb(" the ", 0, ""), new lzb("", 4, ""), new lzb("", 0, ". The "), new lzb("", 11, ""), new lzb("", 0, " on "), new lzb("", 0, " as "), new lzb("", 0, " is "), new lzb("", 7, ""), new lzb("", 1, "ing "), new lzb("", 0, "\n\t"), new lzb("", 0, ":"), new lzb(" ", 0, ". "), new lzb("", 0, "ed "), new lzb("", 20, ""), new lzb("", 18, ""), new lzb("", 6, ""), new lzb("", 0, "("), new lzb("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new lzb("", 8, ""), new lzb("", 0, " at "), new lzb("", 0, "ly "), new lzb(" the ", 0, " of "), new lzb("", 5, ""), new lzb("", 9, ""), new lzb(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new lzb("", 10, "\""), new lzb(".", 0, "("), new lzb("", 11, " "), new lzb("", 10, "\">"), new lzb("", 0, "=\""), new lzb(" ", 0, "."), new lzb(".com/", 0, ""), new lzb(" the ", 0, " of the "), new lzb("", 10, "'"), new lzb("", 0, ". This "), new lzb("", 0, ","), new lzb(".", 0, " "), new lzb("", 10, "("), new lzb("", 10, "."), new lzb("", 0, " not "), new lzb(" ", 0, "=\""), new lzb("", 0, "er "), new lzb(" ", 11, " "), new lzb("", 0, "al "), new lzb(" ", 11, ""), new lzb("", 0, "='"), new lzb("", 11, "\""), new lzb("", 10, ". "), new lzb(" ", 0, "("), new lzb("", 0, "ful "), new lzb(" ", 10, ". "), new lzb("", 0, "ive "), new lzb("", 0, "less "), new lzb("", 11, "'"), new lzb("", 0, "est "), new lzb(" ", 10, "."), new lzb("", 11, "\">"), new lzb(" ", 0, "='"), new lzb("", 10, ","), new lzb("", 0, "ize "), new lzb("", 11, "."), new lzb("Â ", 0, ""), new lzb(" ", 0, ","), new lzb("", 10, "=\""), new lzb("", 11, "=\""), new lzb("", 0, "ous "), new lzb("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new lzb("", 10, "='"), new lzb(" ", 10, ","), new lzb(" ", 11, "=\""), new lzb(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new lzb("", 11, ","), new lzb("", 11, "("), new lzb("", 11, ". "), new lzb(" ", 11, "."), new lzb("", 11, "='"), new lzb(" ", 11, ". "), new lzb(" ", 10, "=\""), new lzb(" ", 11, "='"), new lzb(" ", 10, "='")};
    }

    public lzb(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, lzb lzbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), lzbVar})) == null) {
            int i4 = i;
            for (byte b : lzbVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = lzbVar.b;
            int a = nzb.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - nzb.b(i5);
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
            for (byte b3 : lzbVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
