package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.provider.ContentProviderManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ne1 {
    public static /* synthetic */ Interceptable $ic;
    public static ke1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exc)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, he1.b());
                jSONObject.put("stack_trace", Log.getStackTraceString(exc));
                jSONObject.put("process_info", he1.a());
                jSONObject.put("report_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(Exception exc) {
        ke1 ke1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, exc) == null) || (ke1Var = a) == null) {
            return;
        }
        ke1Var.a(a(exc).toString());
    }

    public static void c(String str) {
        ke1 ke1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || (ke1Var = a) == null) {
            return;
        }
        ke1Var.a(str);
    }
}
