package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, jSONObject, str, str2)) == null) {
            if (jSONObject != null) {
                return jSONObject.optString(str, str2);
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }

    public static JSONObject b(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, jSONObject)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "NA";
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                if (TextUtils.isEmpty(a(jSONObject, "pre_source", null))) {
                    jSONObject.put("pre_source", str);
                }
                if (TextUtils.isEmpty(a(jSONObject, "pre_appid", null))) {
                    jSONObject.put("pre_appid", "NA");
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
