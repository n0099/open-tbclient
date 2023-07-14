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
/* loaded from: classes6.dex */
public class km0 {
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
    public im0 k;
    public String l;
    public WeakReference<Context> m;
    public Long n;
    public String o;
    public boolean p;

    public km0() {
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
    public static km0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = y31.c(str);
            km0 km0Var = new km0();
            km0Var.a = c.optString("als_ext");
            km0Var.b = c.optString("cmd");
            km0Var.c = c.optString("defer_cmd");
            km0Var.d = c.optString("init_text");
            km0Var.e = c.optString("opt_icon");
            km0Var.f = c.optString("opt_text");
            km0Var.g = c.optString("app_icon_url");
            km0Var.h = c.optString("app_name");
            km0Var.i = c.optString("version_code");
            km0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            km0Var.n = Long.valueOf(c.optLong("schedule_time"));
            km0Var.o = c.optString("request_url");
            km0Var.p = c.optBoolean("auto_download");
            return km0Var;
        }
        return (km0) invokeL.objValue;
    }

    public static String b(@NonNull km0 km0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, km0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", km0Var.a);
                jSONObject.put("cmd", km0Var.b);
                jSONObject.put("defer_cmd", km0Var.c);
                jSONObject.put("init_text", km0Var.d);
                jSONObject.put("opt_icon", km0Var.e);
                jSONObject.put("opt_text", km0Var.f);
                jSONObject.put("app_icon_url", km0Var.g);
                jSONObject.put("app_name", km0Var.h);
                jSONObject.put("version_code", km0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, km0Var.j);
                jSONObject.put("schedule_time", km0Var.n);
                jSONObject.put("request_url", km0Var.o);
                jSONObject.put("auto_download", km0Var.p);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
