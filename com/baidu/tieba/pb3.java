package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes5.dex */
public class pb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, map) == null) && !TextUtils.isEmpty(str) && map != null) {
            String f = pl3.f(str);
            String o = pl3.o(str);
            String b = b(f);
            if (!TextUtils.equals(f, b)) {
                if (!TextUtils.isEmpty(o)) {
                    b = b + "?" + o;
                }
                map.put("pageRoutePath", b);
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return c(str, w73.K().q().Q());
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, swanAppConfigData)) == null) {
            if (swanAppConfigData == null) {
                return str;
            }
            String f = e33.f(str);
            if (!TextUtils.isEmpty(f)) {
                return f;
            }
            return swanAppConfigData.j(str);
        }
        return (String) invokeLL.objValue;
    }
}
