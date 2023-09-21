package com.baidu.tieba;

import android.util.Log;
import com.baidu.searchbox.retrieve.file.util.AESUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public class v4c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return b(str, "1234567890abcdef");
            } catch (Exception unused) {
                Log.e("AesUtils", "AesUtils.aesEncrypt fail@encryptStr:{} error:" + str);
                if (str.isEmpty()) {
                    return "";
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            return d(c(str, str2));
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] c(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            Cipher cipher = Cipher.getInstance(AESUtil.ECB_TRANSFORMATION);
            cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
            return cipher.doFinal(str.getBytes(Charset.forName("UTF-8")));
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            char[] cArr = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            int length = bArr.length;
            char[] cArr2 = new char[length << 1];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
                i = i3 + 1;
                cArr2[i3] = cArr[bArr[i2] & 15];
            }
            return new String(cArr2);
        }
        return (String) invokeL.objValue;
    }
}
