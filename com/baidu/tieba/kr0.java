package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@JvmName(name = "AuthStrategyHelper")
/* loaded from: classes4.dex */
public final class kr0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hr0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host", "vdept3.bdstatic.com");
                jSONObject2.put("auth", "1_1_1_3");
                jSONArray.put(jSONObject2);
                jSONObject.put("hosts", jSONArray);
            } catch (Exception e) {
                jj0.c("AuthStrategyHelper", e.toString());
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "defaultHostAuthConfig.toString()");
            return jSONObject3;
        }
        return (String) invokeV.objValue;
    }

    public static final List<gr0> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = jr0.a(bz0.l().getString("host_auth_config", a()));
            }
            hr0 hr0Var = a;
            if (hr0Var != null) {
                return hr0Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static final synchronized gr0 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (kr0.class) {
                if (str != null) {
                    List<gr0> b = b();
                    if (b != null) {
                        try {
                            String host = new URL(str).getHost();
                            for (gr0 gr0Var : b) {
                                if (Pattern.matches(gr0Var.b(), host)) {
                                    return gr0Var;
                                }
                            }
                        } catch (Exception e) {
                            jj0.a("AuthStrategyHelper", e.getMessage());
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
        }
        return (gr0) invokeL.objValue;
    }
}
