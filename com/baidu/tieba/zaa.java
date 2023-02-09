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
public final class zaa {
    public static /* synthetic */ Interceptable $ic;
    public static final zaa[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948354607, "Lcom/baidu/tieba/zaa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948354607, "Lcom/baidu/tieba/zaa;");
                return;
            }
        }
        d = new zaa[]{new zaa("", 0, ""), new zaa("", 0, " "), new zaa(" ", 0, " "), new zaa("", 12, ""), new zaa("", 10, " "), new zaa("", 0, " the "), new zaa(" ", 0, ""), new zaa("s ", 0, " "), new zaa("", 0, " of "), new zaa("", 10, ""), new zaa("", 0, " and "), new zaa("", 13, ""), new zaa("", 1, ""), new zaa(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new zaa("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zaa(" ", 10, " "), new zaa("", 0, " in "), new zaa("", 0, " to "), new zaa("e ", 0, " "), new zaa("", 0, "\""), new zaa("", 0, "."), new zaa("", 0, "\">"), new zaa("", 0, "\n"), new zaa("", 3, ""), new zaa("", 0, PreferencesUtil.RIGHT_MOUNT), new zaa("", 0, " for "), new zaa("", 14, ""), new zaa("", 2, ""), new zaa("", 0, " a "), new zaa("", 0, " that "), new zaa(" ", 10, ""), new zaa("", 0, ". "), new zaa(".", 0, ""), new zaa(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zaa("", 15, ""), new zaa("", 0, " with "), new zaa("", 0, "'"), new zaa("", 0, " from "), new zaa("", 0, " by "), new zaa("", 16, ""), new zaa("", 17, ""), new zaa(" the ", 0, ""), new zaa("", 4, ""), new zaa("", 0, ". The "), new zaa("", 11, ""), new zaa("", 0, " on "), new zaa("", 0, " as "), new zaa("", 0, " is "), new zaa("", 7, ""), new zaa("", 1, "ing "), new zaa("", 0, "\n\t"), new zaa("", 0, ":"), new zaa(" ", 0, ". "), new zaa("", 0, "ed "), new zaa("", 20, ""), new zaa("", 18, ""), new zaa("", 6, ""), new zaa("", 0, "("), new zaa("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zaa("", 8, ""), new zaa("", 0, " at "), new zaa("", 0, "ly "), new zaa(" the ", 0, " of "), new zaa("", 5, ""), new zaa("", 9, ""), new zaa(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zaa("", 10, "\""), new zaa(".", 0, "("), new zaa("", 11, " "), new zaa("", 10, "\">"), new zaa("", 0, "=\""), new zaa(" ", 0, "."), new zaa(".com/", 0, ""), new zaa(" the ", 0, " of the "), new zaa("", 10, "'"), new zaa("", 0, ". This "), new zaa("", 0, ","), new zaa(".", 0, " "), new zaa("", 10, "("), new zaa("", 10, "."), new zaa("", 0, " not "), new zaa(" ", 0, "=\""), new zaa("", 0, "er "), new zaa(" ", 11, " "), new zaa("", 0, "al "), new zaa(" ", 11, ""), new zaa("", 0, "='"), new zaa("", 11, "\""), new zaa("", 10, ". "), new zaa(" ", 0, "("), new zaa("", 0, "ful "), new zaa(" ", 10, ". "), new zaa("", 0, "ive "), new zaa("", 0, "less "), new zaa("", 11, "'"), new zaa("", 0, "est "), new zaa(" ", 10, "."), new zaa("", 11, "\">"), new zaa(" ", 0, "='"), new zaa("", 10, ","), new zaa("", 0, "ize "), new zaa("", 11, "."), new zaa("Â ", 0, ""), new zaa(" ", 0, ","), new zaa("", 10, "=\""), new zaa("", 11, "=\""), new zaa("", 0, "ous "), new zaa("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zaa("", 10, "='"), new zaa(" ", 10, ","), new zaa(" ", 11, "=\""), new zaa(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new zaa("", 11, ","), new zaa("", 11, "("), new zaa("", 11, ". "), new zaa(" ", 11, "."), new zaa("", 11, "='"), new zaa(" ", 11, ". "), new zaa(" ", 10, "=\""), new zaa(" ", 11, "='"), new zaa(" ", 10, "='")};
    }

    public zaa(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, zaa zaaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), zaaVar})) == null) {
            int i4 = i;
            for (byte b : zaaVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = zaaVar.b;
            int a = bba.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - bba.b(i5);
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
            for (byte b3 : zaaVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
