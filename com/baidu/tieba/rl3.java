package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class rl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("slaveId", str);
                jSONObject.put("type", str2);
            } catch (JSONException e) {
                if (vm1.a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", str2);
                jSONObject3.put("action", str4);
                jSONObject3.put("e", jSONObject);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("type", str3);
                jSONObject4.put("params", jSONObject3);
                jSONObject2.put("slaveId", str);
                jSONObject2.put("type", "abilityMessage");
                jSONObject2.put("value", jSONObject4);
            } catch (JSONException e) {
                if (vm1.a) {
                    e.printStackTrace();
                }
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [org.json.JSONObject, T] */
    public static void c(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, str, str2, str3, str4, jSONObject) == null) {
            qg2 qg2Var = new qg2();
            qg2Var.c = b(str, str2, str3, str4, jSONObject);
            xr2.V().v(qg2Var);
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [org.json.JSONObject, T] */
    public static void d(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, str2, str3, str4, jSONObject) == null) {
            qg2 qg2Var = new qg2();
            qg2Var.c = b(str, str2, str3, str4, jSONObject);
            xr2.V().n(str, qg2Var);
        }
    }
}
