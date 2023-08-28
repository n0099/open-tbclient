package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class jwb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "SHA";
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947899124, "Lcom/baidu/tieba/jwb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947899124, "Lcom/baidu/tieba/jwb;");
                return;
            }
        }
        b = new String[]{"SHA-256", "SHA-384", "SHA-512"};
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            for (String str2 : b) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return c(str, "SHA-256");
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!a(str2)) {
                    qwb.c(a, "algorithm is not safe or legal");
                    return "";
                }
                try {
                    bArr = str.getBytes("UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    bArr = new byte[0];
                    qwb.c(a, "Error in generate SHA UnsupportedEncodingException");
                }
                return nwb.a(d(bArr, str2));
            }
            qwb.c(a, "content or algorithm is null.");
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] d(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str)) == null) {
            if (bArr != null && !TextUtils.isEmpty(str)) {
                if (!a(str)) {
                    qwb.c(a, "algorithm is not safe or legal");
                    return new byte[0];
                }
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(str);
                    messageDigest.update(bArr);
                    return messageDigest.digest();
                } catch (NoSuchAlgorithmException unused) {
                    qwb.c(a, "Error in generate SHA NoSuchAlgorithmException");
                    return new byte[0];
                }
            }
            qwb.c(a, "content or algorithm is null.");
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }
}
