package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class oya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            if (!str.contains("?")) {
                sb.append("?");
            }
            sb.append("&");
            sb.append("clientfrom=native");
            sb.append("&");
            sb.append("client=android");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, hashMap)) == null) {
            if (TextUtils.isEmpty(str) || hashMap.isEmpty()) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            if (!str.contains("?")) {
                sb.append("?");
            }
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb.append("&");
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
