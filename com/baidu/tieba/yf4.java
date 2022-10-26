package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yf4 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public static HashMap b;
    public transient /* synthetic */ FieldHolder $fh;

    public yf4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return xa4.c().a("SwanDownloadApiStrategy").getString("version", "0");
        }
        return (String) invokeV.objValue;
    }

    public static zf4 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (a == null) {
                synchronized (yf4.class) {
                    if (a == null) {
                        HashMap hashMap = new HashMap();
                        a = hashMap;
                        e(hashMap, "download_api_ctrl");
                    }
                }
            }
            return c(str, a);
        }
        return (zf4) invokeL.objValue;
    }

    public static zf4 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (b == null) {
                synchronized (yf4.class) {
                    if (b == null) {
                        HashMap hashMap = new HashMap();
                        b = hashMap;
                        e(hashMap, "preload_api_ctrl");
                    }
                }
            }
            return c(str, b);
        }
        return (zf4) invokeL.objValue;
    }

    public static void f(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        oj4 a2 = xa4.c().a("SwanDownloadApiStrategy");
        a2.putString("version", optString);
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        } else {
            str = null;
        }
        a2.putString("data", str);
    }

    public static zf4 c(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        zf4 zf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, hashMap)) == null) {
            if (!TextUtils.isEmpty(str) && (zf4Var = (zf4) hashMap.get(str)) != null) {
                return zf4Var;
            }
            zf4 zf4Var2 = (zf4) hashMap.get("default");
            if (zf4Var2 != null) {
                return zf4Var2;
            }
            return zf4.a();
        }
        return (zf4) invokeLL.objValue;
    }

    public static void e(HashMap hashMap, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, hashMap, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(xa4.c().a("SwanDownloadApiStrategy").getString("data", StringUtil.EMPTY_ARRAY)).optJSONObject(str);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            hashMap.put(next, zf4.b(optJSONObject.optJSONObject(next)));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
