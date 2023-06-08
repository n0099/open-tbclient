package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.common.jscore.BridgeConfig_tbadkcore;
import com.baidu.tieba.common.jscore.JsInterfaces_tbadkcore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ql6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948095726, "Lcom/baidu/tieba/ql6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948095726, "Lcom/baidu/tieba/ql6;");
                return;
            }
        }
        new HashSet();
        a = new HashSet();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                b();
            } catch (Exception unused) {
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            JsInterfaces_tbadkcore.register();
            BridgeConfig_tbadkcore.register();
        }
    }

    public static void c(String str) {
        JSONArray jSONArray;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a.clear();
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = null;
            }
            if (jm6.c(jSONArray)) {
                return;
            }
            yi6 yi6Var = (yi6) ServiceManager.getService(yi6.a);
            if (yi6Var != null) {
                str2 = yi6Var.b();
            } else {
                str2 = com.kuaishou.weapon.p0.q1.e;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("limitVersion", "99.99.99.99");
                    String optString2 = optJSONObject.optString("url", "");
                    if (!TextUtils.isEmpty(optString2) && qm6.a(str2, optString)) {
                        hm6.b("newHybrid", "我被加入到了黑名单:" + optString2);
                        a.add(optString2);
                    }
                }
            }
        }
    }

    public static void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) && jSONObject != null) {
            try {
                c(jSONObject.optString("wv_black_url_list", "[]"));
                ol6.b(jSONObject.optString("wv_prefetch_config", "[]"));
            } catch (Exception unused) {
                hm6.b("newHybrid", "parseSupportUrlList error!");
            }
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            yi6 yi6Var = (yi6) ServiceManager.getService(yi6.a);
            if (yi6Var == null || !yi6Var.a() || TextUtils.isEmpty(str) || str.contains("https://unknown-tmp/") || str.contains("https://ad-tmp/")) {
                return false;
            }
            for (String str2 : a) {
                if (str.contains(str2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
