package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class kl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public il0 k;

    public kl0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static kl0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = f21.c(str);
            kl0 kl0Var = new kl0();
            kl0Var.a = c.optString("als_ext");
            kl0Var.b = c.optString("cmd");
            kl0Var.c = c.optString("defer_cmd");
            kl0Var.d = c.optString("init_text");
            kl0Var.e = c.optString("opt_icon");
            kl0Var.f = c.optString("opt_text");
            kl0Var.g = c.optString("app_icon_url");
            kl0Var.h = c.optString("app_name");
            kl0Var.i = c.optString("version_code");
            kl0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return kl0Var;
        }
        return (kl0) invokeL.objValue;
    }

    public static String b(@NonNull kl0 kl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kl0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", kl0Var.a);
                jSONObject.put("cmd", kl0Var.b);
                jSONObject.put("defer_cmd", kl0Var.c);
                jSONObject.put("init_text", kl0Var.d);
                jSONObject.put("opt_icon", kl0Var.e);
                jSONObject.put("opt_text", kl0Var.f);
                jSONObject.put("app_icon_url", kl0Var.g);
                jSONObject.put("app_name", kl0Var.h);
                jSONObject.put("version_code", kl0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, kl0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
