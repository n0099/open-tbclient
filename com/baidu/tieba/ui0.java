package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes8.dex */
public class ui0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        InterceptResult invokeLLLL;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, map, map2, str2)) == null) {
            if (map != null) {
                str3 = map.get(str);
                if (TextUtils.isEmpty(str3)) {
                    str3 = map.get("default");
                }
            } else {
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                str = str3;
            }
            if (map2 != null) {
                str4 = map2.get(str);
            } else {
                str4 = null;
            }
            if (TextUtils.equals(str4, "__CMD_NONE__")) {
                return null;
            }
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            return str2;
        }
        return (String) invokeLLLL.objValue;
    }
}
