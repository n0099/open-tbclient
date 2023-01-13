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
/* loaded from: classes6.dex */
public class uk0 {
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
    public sk0 k;

    public uk0() {
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
    public static uk0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = u01.c(str);
            uk0 uk0Var = new uk0();
            uk0Var.a = c.optString("als_ext");
            uk0Var.b = c.optString("cmd");
            uk0Var.c = c.optString("defer_cmd");
            uk0Var.d = c.optString("init_text");
            uk0Var.e = c.optString("opt_icon");
            uk0Var.f = c.optString("opt_text");
            uk0Var.g = c.optString("app_icon_url");
            uk0Var.h = c.optString("app_name");
            uk0Var.i = c.optString("version_code");
            uk0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return uk0Var;
        }
        return (uk0) invokeL.objValue;
    }

    public static String b(@NonNull uk0 uk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uk0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", uk0Var.a);
                jSONObject.put("cmd", uk0Var.b);
                jSONObject.put("defer_cmd", uk0Var.c);
                jSONObject.put("init_text", uk0Var.d);
                jSONObject.put("opt_icon", uk0Var.e);
                jSONObject.put("opt_text", uk0Var.f);
                jSONObject.put("app_icon_url", uk0Var.g);
                jSONObject.put("app_name", uk0Var.h);
                jSONObject.put("version_code", uk0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, uk0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
