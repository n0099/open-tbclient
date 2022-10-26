package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948276270, "Lcom/baidu/tieba/wn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948276270, "Lcom/baidu/tieba/wn2;");
                return;
            }
        }
        a = wj1.a;
    }

    public static String a(k22 k22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, k22Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (k22Var != null) {
                try {
                    jSONObject.put("containerId", k22Var.getContainerId());
                    jSONObject.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, BdZeusUtil.isWebkitLoaded());
                } catch (JSONException e) {
                    if (!a) {
                        e.printStackTrace();
                    } else {
                        throw new RuntimeException(e);
                    }
                }
            }
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            String b = b(ga2.U().T());
            m02.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + ze2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(um2.i().s()));
            jSONObject.put("isDebugSdk", a);
            if ((k22Var instanceof NgWebView) && ((NgWebView) k22Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", ac3.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = ac3.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && lz2.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = tm2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = sc3.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", jf2.USER_DATA_PATH);
            jSONObject.put("preloadId", ga2.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", vf4.b().a());
            jSONObject.put("coreJSPath", ga2.U().c0());
            if (ws1.d()) {
                jSONObject.put("pendingList", new JSONArray(hv1.d()));
            }
            jSONObject.put("swanNativeVersion", xj1.a());
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return "";
            }
            return jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, extensionCore)) == null) {
            if (extensionCore != null && !TextUtils.isEmpty(extensionCore.extensionCorePath)) {
                return extensionCore.extensionCorePath;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
