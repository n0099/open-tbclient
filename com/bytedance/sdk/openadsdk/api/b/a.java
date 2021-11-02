package com.bytedance.sdk.openadsdk.api.b;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes11.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, str3)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
                return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
