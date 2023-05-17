package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class w2b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            if (bArr != null && bArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (byte b : bArr) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        sb.append(TransactionIdCreater.FILL_BYTE);
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new byte[0];
            }
            try {
                String upperCase = str.toUpperCase(Locale.ENGLISH);
                int length = upperCase.length() / 2;
                byte[] bArr = new byte[length];
                try {
                    byte[] bytes = upperCase.getBytes("UTF-8");
                    for (int i = 0; i < length; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("0x");
                        int i2 = i * 2;
                        sb.append(new String(new byte[]{bytes[i2]}, "UTF-8"));
                        bArr[i] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i2 + 1]}, "UTF-8")).byteValue());
                    }
                    return bArr;
                } catch (UnsupportedEncodingException | NumberFormatException e) {
                    z2b.c("HexUtil", "hex string 2 byte array exception : " + e.getMessage());
                    return new byte[0];
                }
            } catch (Throwable th) {
                z2b.c("HexUtil", "hex string toUpperCase exception : " + th.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
