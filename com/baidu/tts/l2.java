package com.baidu.tts;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class l2 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public static final Pattern b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722260171, "Lcom/baidu/tts/l2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722260171, "Lcom/baidu/tts/l2;");
                return;
            }
        }
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        a = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        b = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String str = k2.d;
            if (!TextUtils.isEmpty(str)) {
                LoggerProxy.w("Utility", "packageNameForTest not empty , the value is " + str);
                return str;
            }
            return context.getPackageName();
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.length() == 0) {
                return null;
            }
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            return new String(Base64.decode(bytes, 0, bytes.length, 0), StandardCharsets.UTF_8);
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    int i = b2 & 255;
                    if (Integer.toHexString(i).length() == 1) {
                        sb.append("0");
                        sb.append(Integer.toHexString(i));
                    } else {
                        sb.append(Integer.toHexString(i));
                    }
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
