package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ml0 {
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
    public kl0 k;
    public String l;
    public WeakReference<Context> m;
    public Long n;
    public String o;
    public boolean p;

    public ml0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -1L;
        this.p = false;
    }

    @NonNull
    public static ml0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = i31.c(str);
            ml0 ml0Var = new ml0();
            ml0Var.a = c.optString("als_ext");
            ml0Var.b = c.optString("cmd");
            ml0Var.c = c.optString("defer_cmd");
            ml0Var.d = c.optString("init_text");
            ml0Var.e = c.optString("opt_icon");
            ml0Var.f = c.optString("opt_text");
            ml0Var.g = c.optString("app_icon_url");
            ml0Var.h = c.optString("app_name");
            ml0Var.i = c.optString("version_code");
            ml0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            ml0Var.n = Long.valueOf(c.optLong("schedule_time"));
            ml0Var.o = c.optString("request_url");
            ml0Var.p = c.optBoolean("auto_download");
            return ml0Var;
        }
        return (ml0) invokeL.objValue;
    }

    public static String b(@NonNull ml0 ml0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ml0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", ml0Var.a);
                jSONObject.put("cmd", ml0Var.b);
                jSONObject.put("defer_cmd", ml0Var.c);
                jSONObject.put("init_text", ml0Var.d);
                jSONObject.put("opt_icon", ml0Var.e);
                jSONObject.put("opt_text", ml0Var.f);
                jSONObject.put("app_icon_url", ml0Var.g);
                jSONObject.put("app_name", ml0Var.h);
                jSONObject.put("version_code", ml0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, ml0Var.j);
                jSONObject.put("schedule_time", ml0Var.n);
                jSONObject.put("request_url", ml0Var.o);
                jSONObject.put("auto_download", ml0Var.p);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
