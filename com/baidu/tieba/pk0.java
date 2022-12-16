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
public class pk0 {
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
    public nk0 k;

    public pk0() {
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
    public static pk0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = p01.c(str);
            pk0 pk0Var = new pk0();
            pk0Var.a = c.optString("als_ext");
            pk0Var.b = c.optString("cmd");
            pk0Var.c = c.optString("defer_cmd");
            pk0Var.d = c.optString("init_text");
            pk0Var.e = c.optString("opt_icon");
            pk0Var.f = c.optString("opt_text");
            pk0Var.g = c.optString("app_icon_url");
            pk0Var.h = c.optString("app_name");
            pk0Var.i = c.optString("version_code");
            pk0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return pk0Var;
        }
        return (pk0) invokeL.objValue;
    }

    public static String b(@NonNull pk0 pk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pk0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", pk0Var.a);
                jSONObject.put("cmd", pk0Var.b);
                jSONObject.put("defer_cmd", pk0Var.c);
                jSONObject.put("init_text", pk0Var.d);
                jSONObject.put("opt_icon", pk0Var.e);
                jSONObject.put("opt_text", pk0Var.f);
                jSONObject.put("app_icon_url", pk0Var.g);
                jSONObject.put("app_name", pk0Var.h);
                jSONObject.put("version_code", pk0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, pk0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
