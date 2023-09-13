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
/* loaded from: classes8.dex */
public class tm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, str2, str3, str4)) == null) {
            JSONObject jSONObject = new JSONObject();
            i31.f(jSONObject, "downStatus", str);
            try {
                d = Double.parseDouble(str2) * 100.0d;
            } catch (Exception unused) {
                d = 0.0d;
            }
            i31.e(jSONObject, "process", Math.round(d));
            i31.f(jSONObject, "uri", str3);
            i31.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str4);
            return jSONObject.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static void b(@Nullable lj0 lj0Var, boolean z, @Nullable Map<String, String> map) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{lj0Var, Boolean.valueOf(z), map}) != null) || lj0Var == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (z) {
            str = "0";
        } else {
            str = "202";
        }
        j31.e(map, "status", str);
        if (z) {
            str2 = "调用成功";
        } else {
            str2 = "";
        }
        j31.e(map, "message", str2);
        lj0Var.a(z, map);
    }

    public static void c(@Nullable lj0 lj0Var, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65538, null, lj0Var, str, str2, str3, str4) != null) || lj0Var == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, str);
        JSONObject jSONObject = new JSONObject();
        i31.f(jSONObject, "uri", str2);
        i31.f(jSONObject, FontsContractCompat.Columns.FILE_ID, str3);
        i31.f(jSONObject, "downStatus", str4);
        hashMap.put("data", jSONObject.toString());
        b(lj0Var, true, hashMap);
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return i31.c(str).optString("bt_info");
        }
        return (String) invokeL.objValue;
    }
}
