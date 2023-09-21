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
public class ll0 {
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
    public jl0 k;
    public String l;
    public WeakReference<Context> m;
    public Long n;
    public String o;
    public boolean p;

    public ll0() {
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
    public static ll0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = h31.c(str);
            ll0 ll0Var = new ll0();
            ll0Var.a = c.optString("als_ext");
            ll0Var.b = c.optString("cmd");
            ll0Var.c = c.optString("defer_cmd");
            ll0Var.d = c.optString("init_text");
            ll0Var.e = c.optString("opt_icon");
            ll0Var.f = c.optString("opt_text");
            ll0Var.g = c.optString("app_icon_url");
            ll0Var.h = c.optString("app_name");
            ll0Var.i = c.optString("version_code");
            ll0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            ll0Var.n = Long.valueOf(c.optLong("schedule_time"));
            ll0Var.o = c.optString("request_url");
            ll0Var.p = c.optBoolean("auto_download");
            return ll0Var;
        }
        return (ll0) invokeL.objValue;
    }

    public static String b(@NonNull ll0 ll0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ll0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", ll0Var.a);
                jSONObject.put("cmd", ll0Var.b);
                jSONObject.put("defer_cmd", ll0Var.c);
                jSONObject.put("init_text", ll0Var.d);
                jSONObject.put("opt_icon", ll0Var.e);
                jSONObject.put("opt_text", ll0Var.f);
                jSONObject.put("app_icon_url", ll0Var.g);
                jSONObject.put("app_name", ll0Var.h);
                jSONObject.put("version_code", ll0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, ll0Var.j);
                jSONObject.put("schedule_time", ll0Var.n);
                jSONObject.put("request_url", ll0Var.o);
                jSONObject.put("auto_download", ll0Var.p);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
