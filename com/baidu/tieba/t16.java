package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
/* loaded from: classes8.dex */
public class t16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, file)) == null) {
            if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
                try {
                    PublicKey e = yd.e(kd.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGKmjUQl+RAVovXDJpDU/V8IEWm0Mejnq1yFD8V7mbTT0iD3XvoZNGQ46xiawGYv/f3MlYrttv2kectaH9HjQHsZI2mM6NbxOm+3lv6oRfAIH+2LQvopr1GRZIyueCCfdzBk+w6twrQFfWrAOAl+8g4+k1eic0oPMyT2EknFv2xwIDAQAB"));
                    if (e == null) {
                        TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "publicKeyCode is null").param("obj_source", file.getName()));
                        return false;
                    }
                    byte[] b = b(str);
                    if (b != null && b.length > 0) {
                        byte[] b2 = yd.b(e, b);
                        if (b2 != null && b2.length > 0) {
                            String trim = new String(b2, "UTF-8").trim();
                            String b3 = xd.b(new FileInputStream(file));
                            if (b3 != null) {
                                b3 = b3.trim();
                            }
                            if (!TextUtils.isEmpty(b3) && !TextUtils.isEmpty(trim)) {
                                if (b3.equalsIgnoreCase(trim)) {
                                    return true;
                                }
                                TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "apkMd5 != serverMD5").param("obj_source", file.getName()));
                                BdLog.e("download MD5 RSA ERROR; file:" + file.getName());
                                return false;
                            }
                            TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "apkMd5 or serverMD5 is null").param("obj_source", file.getName()));
                            return false;
                        }
                        TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "des is null").param("obj_source", file.getName()));
                        return false;
                    }
                    TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "server_data is null").param("obj_source", file.getName()));
                    return false;
                } catch (Exception e2) {
                    StatisticItem statisticItem = new StatisticItem("c10836");
                    TiebaStatic.log(statisticItem.param("obj_type", "exception:" + e2.getMessage()).param("obj_source", file.getName()));
                    BdLog.e("download MD5 RSA ERROR！Exception:" + e2.getMessage() + " ; file:" + file.getName());
                    return false;
                }
            }
            TiebaStatic.log(new StatisticItem("c10836").param("obj_type", "checkRSA input args is null"));
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                char[] charArray = str.toCharArray();
                int length = charArray.length / 2;
                byte[] bArr = new byte[length];
                if (charArray.length % 2 != 0) {
                    return null;
                }
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = i + 1;
                    if (i3 >= charArray.length || i2 >= length) {
                        break;
                    }
                    bArr[i2] = (byte) ((c(charArray[i]) << 4) | c(charArray[i3]));
                    i2++;
                    i = i3 + 1;
                }
                return bArr;
            }
            throw new IllegalArgumentException("binary string is null");
        }
        return (byte[]) invokeL.objValue;
    }

    public static int c(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c)})) == null) {
            int digit = Character.digit(c, 16);
            if (digit != -1) {
                return digit;
            }
            throw new RuntimeException("Illegal hexadecimal character " + c);
        }
        return invokeCommon.intValue;
    }
}
