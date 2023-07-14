package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kl1 {
    public static /* synthetic */ Interceptable $ic;
    public static hl1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exc)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, el1.b());
                jSONObject.put(CrashHianalyticsData.STACK_TRACE, Log.getStackTraceString(exc));
                jSONObject.put("process_info", el1.a());
                jSONObject.put("report_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(Exception exc) {
        hl1 hl1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, exc) == null) && (hl1Var = a) != null) {
            hl1Var.a(a(exc).toString());
        }
    }

    public static void c(String str) {
        hl1 hl1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && (hl1Var = a) != null) {
            hl1Var.a(str);
        }
    }
}
