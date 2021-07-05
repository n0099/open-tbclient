package com.baidu.ufosdk.c;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.f.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"NewApi"})
    public static String a(Map map) {
        InterceptResult invokeL;
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, map)) == null) {
            if (map == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    obj = map.get(str);
                } catch (JSONException e2) {
                    c.a("Could not create JSON object for key " + str, e2);
                }
                if (obj instanceof String) {
                    obj2 = (String) obj;
                } else if (obj instanceof Integer) {
                    obj2 = (Integer) obj;
                } else if (obj instanceof Long) {
                    obj2 = (Long) obj;
                } else if (obj instanceof Float) {
                    obj2 = (Float) obj;
                } else {
                    c.d("mapRecord2JSON: unexpected key[" + str + "]'s value " + obj);
                }
                jSONObject.put(str, obj2);
            }
            c.c("json is " + jSONObject.toString());
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
