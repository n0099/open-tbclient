package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes7.dex */
public class oz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Map<String, String> map) {
        InterceptResult invokeL;
        String encode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, map)) == null) {
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
                        throw new RuntimeException("This method requires UTF-8 encoding support", e);
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

    public static String b(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String a = a(map);
            if (TextUtils.isEmpty(a)) {
                return str;
            }
            if (!str.contains("?")) {
                return str + "?" + a;
            }
            if (str.lastIndexOf("?") == str.length() - 1) {
                return str + a;
            }
            return str + "&" + a;
        }
        return (String) invokeLL.objValue;
    }
}
