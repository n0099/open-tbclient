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
public class qk0 {
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
    public ok0 k;

    public qk0() {
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
    public static qk0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = q01.c(str);
            qk0 qk0Var = new qk0();
            qk0Var.a = c.optString("als_ext");
            qk0Var.b = c.optString("cmd");
            qk0Var.c = c.optString("defer_cmd");
            qk0Var.d = c.optString("init_text");
            qk0Var.e = c.optString("opt_icon");
            qk0Var.f = c.optString("opt_text");
            qk0Var.g = c.optString("app_icon_url");
            qk0Var.h = c.optString("app_name");
            qk0Var.i = c.optString("version_code");
            qk0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return qk0Var;
        }
        return (qk0) invokeL.objValue;
    }

    public static String b(@NonNull qk0 qk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qk0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", qk0Var.a);
                jSONObject.put("cmd", qk0Var.b);
                jSONObject.put("defer_cmd", qk0Var.c);
                jSONObject.put("init_text", qk0Var.d);
                jSONObject.put("opt_icon", qk0Var.e);
                jSONObject.put("opt_text", qk0Var.f);
                jSONObject.put("app_icon_url", qk0Var.g);
                jSONObject.put("app_name", qk0Var.h);
                jSONObject.put("version_code", qk0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, qk0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
