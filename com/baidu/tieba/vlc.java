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
public final class vlc {
    public static /* synthetic */ Interceptable $ic;
    public static final vlc[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948246076, "Lcom/baidu/tieba/vlc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948246076, "Lcom/baidu/tieba/vlc;");
                return;
            }
        }
        d = new vlc[]{new vlc("", 0, ""), new vlc("", 0, " "), new vlc(" ", 0, " "), new vlc("", 12, ""), new vlc("", 10, " "), new vlc("", 0, " the "), new vlc(" ", 0, ""), new vlc("s ", 0, " "), new vlc("", 0, " of "), new vlc("", 10, ""), new vlc("", 0, " and "), new vlc("", 13, ""), new vlc("", 1, ""), new vlc(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new vlc("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new vlc(" ", 10, " "), new vlc("", 0, " in "), new vlc("", 0, " to "), new vlc("e ", 0, " "), new vlc("", 0, "\""), new vlc("", 0, "."), new vlc("", 0, "\">"), new vlc("", 0, "\n"), new vlc("", 3, ""), new vlc("", 0, PreferencesUtil.RIGHT_MOUNT), new vlc("", 0, " for "), new vlc("", 14, ""), new vlc("", 2, ""), new vlc("", 0, " a "), new vlc("", 0, " that "), new vlc(" ", 10, ""), new vlc("", 0, ". "), new vlc(".", 0, ""), new vlc(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new vlc("", 15, ""), new vlc("", 0, " with "), new vlc("", 0, "'"), new vlc("", 0, " from "), new vlc("", 0, " by "), new vlc("", 16, ""), new vlc("", 17, ""), new vlc(" the ", 0, ""), new vlc("", 4, ""), new vlc("", 0, ". The "), new vlc("", 11, ""), new vlc("", 0, " on "), new vlc("", 0, " as "), new vlc("", 0, " is "), new vlc("", 7, ""), new vlc("", 1, "ing "), new vlc("", 0, "\n\t"), new vlc("", 0, ":"), new vlc(" ", 0, ". "), new vlc("", 0, "ed "), new vlc("", 20, ""), new vlc("", 18, ""), new vlc("", 6, ""), new vlc("", 0, "("), new vlc("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new vlc("", 8, ""), new vlc("", 0, " at "), new vlc("", 0, "ly "), new vlc(" the ", 0, " of "), new vlc("", 5, ""), new vlc("", 9, ""), new vlc(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new vlc("", 10, "\""), new vlc(".", 0, "("), new vlc("", 11, " "), new vlc("", 10, "\">"), new vlc("", 0, "=\""), new vlc(" ", 0, "."), new vlc(".com/", 0, ""), new vlc(" the ", 0, " of the "), new vlc("", 10, "'"), new vlc("", 0, ". This "), new vlc("", 0, ","), new vlc(".", 0, " "), new vlc("", 10, "("), new vlc("", 10, "."), new vlc("", 0, " not "), new vlc(" ", 0, "=\""), new vlc("", 0, "er "), new vlc(" ", 11, " "), new vlc("", 0, "al "), new vlc(" ", 11, ""), new vlc("", 0, "='"), new vlc("", 11, "\""), new vlc("", 10, ". "), new vlc(" ", 0, "("), new vlc("", 0, "ful "), new vlc(" ", 10, ". "), new vlc("", 0, "ive "), new vlc("", 0, "less "), new vlc("", 11, "'"), new vlc("", 0, "est "), new vlc(" ", 10, "."), new vlc("", 11, "\">"), new vlc(" ", 0, "='"), new vlc("", 10, ","), new vlc("", 0, "ize "), new vlc("", 11, "."), new vlc("Â ", 0, ""), new vlc(" ", 0, ","), new vlc("", 10, "=\""), new vlc("", 11, "=\""), new vlc("", 0, "ous "), new vlc("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new vlc("", 10, "='"), new vlc(" ", 10, ","), new vlc(" ", 11, "=\""), new vlc(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new vlc("", 11, ","), new vlc("", 11, "("), new vlc("", 11, ". "), new vlc(" ", 11, "."), new vlc("", 11, "='"), new vlc(" ", 11, ". "), new vlc(" ", 10, "=\""), new vlc(" ", 11, "='"), new vlc(" ", 10, "='")};
    }

    public vlc(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, vlc vlcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), vlcVar})) == null) {
            int i4 = i;
            for (byte b : vlcVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = vlcVar.b;
            int a = xlc.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - xlc.b(i5);
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
            for (byte b3 : vlcVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
