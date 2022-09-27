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
/* loaded from: classes6.dex */
public class vn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948246479, "Lcom/baidu/tieba/vn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948246479, "Lcom/baidu/tieba/vn2;");
                return;
            }
        }
        a = vj1.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(j22 j22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, j22Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (j22Var != null) {
                try {
                    jSONObject.put("containerId", j22Var.getContainerId());
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
            String b = b(fa2.U().T());
            l02.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + ye2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(tm2.i().s()));
            jSONObject.put("isDebugSdk", a);
            if ((j22Var instanceof NgWebView) && ((NgWebView) j22Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", zb3.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = zb3.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && kz2.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = sm2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = rc3.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", if2.USER_DATA_PATH);
            jSONObject.put("preloadId", fa2.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", uf4.b().a());
            jSONObject.put("coreJSPath", fa2.U().c0());
            if (vs1.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) gv1.d()));
            }
            jSONObject.put("swanNativeVersion", wj1.a());
            String jSONObject2 = jSONObject.toString();
            return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, extensionCore)) == null) ? (extensionCore == null || TextUtils.isEmpty(extensionCore.extensionCorePath)) ? "" : extensionCore.extensionCorePath : (String) invokeL.objValue;
    }
}
