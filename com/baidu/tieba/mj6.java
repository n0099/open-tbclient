package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.common.jscore.BridgeConfig_tbadkcore;
import com.baidu.tieba.common.jscore.JsInterfaces_tbadkcore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mj6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947974640, "Lcom/baidu/tieba/mj6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947974640, "Lcom/baidu/tieba/mj6;");
                return;
            }
        }
        new HashSet();
        a = new HashSet();
        b = false;
    }

    public mj6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, null) != null) || b) {
            return;
        }
        synchronized (mj6.class) {
            if (b) {
                return;
            }
            try {
                b();
                b = true;
            } catch (Exception unused) {
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            BridgeConfig_tbadkcore.register();
            JsInterfaces_tbadkcore.register();
        }
    }

    public static void c(String str) {
        JSONArray jSONArray;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            a.clear();
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = null;
            }
            if (jk6.c(jSONArray)) {
                return;
            }
            og6 og6Var = (og6) ServiceManager.getService(og6.a);
            if (og6Var != null) {
                str2 = og6Var.b();
            } else {
                str2 = com.kuaishou.weapon.p0.bq.e;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("limitVersion", "99.99.99.99");
                    String optString2 = optJSONObject.optString("url", "");
                    if (!TextUtils.isEmpty(optString2) && qk6.a(str2, optString)) {
                        dk6.b("newHybrid", "我被加入到了黑名单:" + optString2);
                        a.add(optString2);
                    }
                }
            }
        }
    }

    public static void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, jSONObject) == null) && jSONObject != null) {
            try {
                c(jSONObject.optString("wv_black_url_list", "[]"));
                kj6.b(jSONObject.optString("wv_prefetch_config", "[]"));
            } catch (Exception unused) {
                dk6.b("newHybrid", "parseSupportUrlList error!");
            }
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            og6 og6Var = (og6) ServiceManager.getService(og6.a);
            if (og6Var == null || !og6Var.a() || TextUtils.isEmpty(str) || str.contains("https://unknown-tmp/") || str.contains("https://ad-tmp/")) {
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
