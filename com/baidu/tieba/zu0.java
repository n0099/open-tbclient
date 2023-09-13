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
/* loaded from: classes9.dex */
public final class zu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wu0 a;
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
                tk0.c("AuthStrategyHelper", e.toString());
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "defaultHostAuthConfig.toString()");
            return jSONObject3;
        }
        return (String) invokeV.objValue;
    }

    public static final List<vu0> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = yu0.a(p21.k().getString("host_auth_config", a()));
            }
            wu0 wu0Var = a;
            if (wu0Var != null) {
                return wu0Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static final synchronized vu0 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (zu0.class) {
                if (str == null) {
                    return null;
                }
                List<vu0> b = b();
                if (b == null) {
                    return null;
                }
                try {
                    String host = new URL(str).getHost();
                    for (vu0 vu0Var : b) {
                        if (Pattern.matches(vu0Var.b(), host)) {
                            return vu0Var;
                        }
                    }
                } catch (Exception e) {
                    tk0.a("AuthStrategyHelper", e.getMessage());
                }
                return null;
            }
        }
        return (vu0) invokeL.objValue;
    }
}
