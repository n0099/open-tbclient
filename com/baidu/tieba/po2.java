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
/* loaded from: classes5.dex */
public class po2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068694, "Lcom/baidu/tieba/po2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068694, "Lcom/baidu/tieba/po2;");
                return;
            }
        }
        a = pk1.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(d32 d32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, d32Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (d32Var != null) {
                try {
                    jSONObject.put("containerId", d32Var.getContainerId());
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
            String b = b(za2.U().T());
            f12.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + sf2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(nn2.i().s()));
            jSONObject.put("isDebugSdk", a);
            if ((d32Var instanceof NgWebView) && ((NgWebView) d32Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", tc3.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = tc3.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && e03.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = mn2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = ld3.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", cg2.USER_DATA_PATH);
            jSONObject.put("preloadId", za2.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", og4.b().a());
            jSONObject.put("coreJSPath", za2.U().c0());
            if (pt1.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) aw1.d()));
            }
            jSONObject.put("swanNativeVersion", qk1.a());
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
