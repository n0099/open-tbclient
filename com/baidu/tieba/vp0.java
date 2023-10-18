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
/* loaded from: classes8.dex */
public final class vp0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sp0 a;
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
                pf0.c("AuthStrategyHelper", e.toString());
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "defaultHostAuthConfig.toString()");
            return jSONObject3;
        }
        return (String) invokeV.objValue;
    }

    public static final List<rp0> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = up0.a(bx0.j().getString("host_auth_config", a()));
            }
            sp0 sp0Var = a;
            if (sp0Var != null) {
                return sp0Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static final synchronized rp0 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (vp0.class) {
                if (str == null) {
                    return null;
                }
                List<rp0> b = b();
                if (b == null) {
                    return null;
                }
                try {
                    String host = new URL(str).getHost();
                    for (rp0 rp0Var : b) {
                        if (Pattern.matches(rp0Var.b(), host)) {
                            return rp0Var;
                        }
                    }
                } catch (Exception e) {
                    pf0.a("AuthStrategyHelper", e.getMessage());
                }
                return null;
            }
        }
        return (rp0) invokeL.objValue;
    }
}
