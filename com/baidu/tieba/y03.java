package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y03 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Integer num, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, num, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("level", String.valueOf(num));
            hashMap.put("percentage", str + "%");
            qw2.T().u(new el2("text-size-adjust", hashMap));
            n22.d(num.intValue());
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            jl2 jl2Var = new jl2();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "text-size-adjust");
                jSONObject.put("percentage", str3 + "%");
                jSONObject.put("level", str2);
            } catch (JSONException e) {
                v63.b(Log.getStackTraceString(e));
            }
            jl2Var.c = jSONObject;
            qw2.T().m(str, jl2Var);
        }
    }
}
