package com.bytedance.pangle.log;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.c.d;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.j;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, jSONObject, jSONObject2, jSONObject3) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            String str2 = null;
            if (Zeus.getAppApplication() != null) {
                Zeus.getAppApplication();
                str2 = d.a();
            }
            if (str2 == null) {
                str2 = "unknown";
            }
            try {
                jSONObject.putOpt("net_type", a(Integer.valueOf(com.bytedance.pangle.download.a.a(Zeus.getAppApplication()).h)));
                jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, a(str2));
                Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                jSONObject.putOpt("plugin_api_version", a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                jSONObject.putOpt("zeus_sdk_version", a("0.0.1-beta.4200.55-systemconfig-pangle"));
                ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                if (reporter != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject4.putOpt(next, jSONObject.opt(next));
                    }
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                    }
                    Iterator<String> keys3 = jSONObject3.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                    }
                    reporter.report(str, jSONObject4);
                }
                a.a();
                a.b();
            } catch (JSONException e) {
                ZeusLogger.e(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
            }
        }
    }

    public static int b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj == null) {
                return -1;
            }
            return j.a(obj.toString());
        }
        return invokeL.intValue;
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) ? obj == null ? "" : obj.toString() : (String) invokeL.objValue;
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }
}
