package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class qb0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948085930, "Lcom/baidu/tieba/qb0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948085930, "Lcom/baidu/tieba/qb0;");
        }
    }

    public static String a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String f = f(map);
            if (TextUtils.isEmpty(f)) {
                return str;
            }
            if (str.contains("?")) {
                return str + "&" + f;
            }
            return str + "?" + f;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (!a) {
                c();
            }
            return e(str);
        }
        return (String) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                b = Class.forName("com.baidu.common.param.CommonUrlParamManager").getMethod("appendParam", String.class, Integer.TYPE) != null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
            a = true;
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                return str.substring(indexOf + 1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (b) {
                return CommonUrlParamManager.getInstance().appendParam(str, 1);
            }
            return CommonUrlParamManager.getInstance().processUrl(str);
        }
        return (String) invokeL.objValue;
    }

    public static String f(Map<String, String> map) {
        InterceptResult invokeL;
        String encode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                String str2 = map.get(str);
                if (str != null) {
                    try {
                        encode = URLEncoder.encode(str, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    encode = "";
                }
                sb.append(encode);
                sb.append("=");
                sb.append(str2 != null ? URLEncoder.encode(str2, "UTF-8") : "");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    hashMap.put(URLDecoder.decode(split[0], "UTF-8"), split.length > 1 ? URLDecoder.decode(split[1], "UTF-8") : "");
                } catch (UnsupportedEncodingException unused) {
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
