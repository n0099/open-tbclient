package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ti3 {
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
                if (wj1.a) {
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
                if (wj1.a) {
                    e.printStackTrace();
                }
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }

    public static void c(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, str, str2, str3, str4, jSONObject) == null) {
            sd2 sd2Var = new sd2();
            sd2Var.c = b(str, str2, str3, str4, jSONObject);
            zo2.U().u(sd2Var);
        }
    }

    public static void d(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, str2, str3, str4, jSONObject) == null) {
            sd2 sd2Var = new sd2();
            sd2Var.c = b(str, str2, str3, str4, jSONObject);
            zo2.U().m(str, sd2Var);
        }
    }
}
