package com.baidu.tieba;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bundle a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, map)) == null) {
            Bundle bundle = new Bundle();
            for (String str : map.keySet()) {
                bundle.putString(str, map.get(str));
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static JSONObject b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static Map<String, String> d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            Map<String, String> c = c();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        c.put(next, jSONObject.optString(next));
                    }
                }
            }
            return c;
        }
        return (Map) invokeL.objValue;
    }

    public static <K, V> Map<K, V> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new ArrayMap();
            }
            return new HashMap();
        }
        return (Map) invokeV.objValue;
    }
}
