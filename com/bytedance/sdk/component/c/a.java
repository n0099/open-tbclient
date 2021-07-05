package com.bytedance.sdk.component.c;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.j;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
                return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
            } catch (Throwable th) {
                j.b(th.getMessage());
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] decode = Base64.decode(str, 0);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
                return new String(cipher.doFinal(decode));
            } catch (Exception e2) {
                j.b(e2.getMessage());
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, str)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                cipher.init(1, secretKeySpec);
                return Base64.encodeToString(cipher.doFinal(bArr), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    @Deprecated
    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] decode = Base64.decode(str, 0);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(2, secretKeySpec);
                return new String(cipher.doFinal(decode));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null || str.length() != 16) {
                return null;
            }
            return str.concat(str).substring(8, 24);
        }
        return (String) invokeL.objValue;
    }
}
