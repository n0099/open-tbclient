package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ql0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, str2, str3, str4)) == null) {
            JSONObject jSONObject = new JSONObject();
            xz0.f(jSONObject, "downStatus", str);
            try {
                d = Double.parseDouble(str2) * 100.0d;
            } catch (Exception unused) {
                d = 0.0d;
            }
            xz0.e(jSONObject, "process", Math.round(d));
            xz0.f(jSONObject, "uri", str3);
            xz0.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str4);
            return jSONObject.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static void b(@Nullable ri0 ri0Var, boolean z, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ri0Var, Boolean.valueOf(z), map}) == null) || ri0Var == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        yz0.e(map, "status", z ? "0" : "202");
        yz0.e(map, "message", z ? "调用成功" : "");
        ri0Var.a(z, map);
    }

    public static void c(@Nullable ri0 ri0Var, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, ri0Var, str, str2, str3, str4) == null) || ri0Var == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, str);
        JSONObject jSONObject = new JSONObject();
        xz0.f(jSONObject, "uri", str2);
        xz0.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str3);
        xz0.f(jSONObject, "downStatus", str4);
        hashMap.put("data", jSONObject.toString());
        b(ri0Var, true, hashMap);
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : xz0.c(str).optString("bt_info") : (String) invokeL.objValue;
    }
}
