package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wk1 {
    public static /* synthetic */ Interceptable $ic;
    public static tk1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exc)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, qk1.b());
                jSONObject.put(CrashHianalyticsData.STACK_TRACE, Log.getStackTraceString(exc));
                jSONObject.put("process_info", qk1.a());
                jSONObject.put("report_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(Exception exc) {
        tk1 tk1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, exc) == null) && (tk1Var = a) != null) {
            tk1Var.a(a(exc).toString());
        }
    }

    public static void c(String str) {
        tk1 tk1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && (tk1Var = a) != null) {
            tk1Var.a(str);
        }
    }
}
