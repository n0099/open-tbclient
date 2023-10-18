package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zp2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948367565, "Lcom/baidu/tieba/zp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948367565, "Lcom/baidu/tieba/zp2;");
                return;
            }
        }
        a = am1.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(n42 n42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, n42Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (n42Var != null) {
                try {
                    jSONObject.put("containerId", n42Var.getContainerId());
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
            String b = b(jc2.V().U());
            p22.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + ch2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(xo2.i().s()));
            jSONObject.put("isDebugSdk", a);
            if ((n42Var instanceof NgWebView) && ((NgWebView) n42Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", de3.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = de3.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && o13.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = wo2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = ve3.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", mh2.USER_DATA_PATH);
            jSONObject.put("preloadId", jc2.V().b0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", yh4.b().a());
            jSONObject.put("coreJSPath", jc2.V().d0());
            if (av1.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) lx1.e()));
            }
            jSONObject.put("swanNativeVersion", bm1.a());
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
