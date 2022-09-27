package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public String j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public long p;
    public long q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;

    public mk0() {
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
        this.d = "";
        this.e = 0L;
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.p = -1L;
        this.q = -1L;
        this.s = false;
        this.t = 0;
        this.u = true;
    }

    @NonNull
    public static mk0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            mk0 mk0Var = new mk0();
            JSONObject c = xz0.c(str);
            mk0Var.a = c.optString("page");
            mk0Var.b = c.optString(Constant.KEY_BUSINESS);
            mk0Var.d = c.optString("content_type");
            mk0Var.e = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            mk0Var.f = c.optInt("is_dirty", 0) == 1;
            mk0Var.g = c.optInt("close_v_download", 0);
            mk0Var.h = c.optInt("no_click_opt");
            mk0Var.i = c.optInt("open_after_install");
            mk0Var.j = c.optString("action_area");
            mk0Var.k = c.optInt("notification_show_count");
            mk0Var.l = c.optInt("tips_show_count");
            mk0Var.p = c.optLong("als_app_save_day");
            mk0Var.q = c.optLong("finished_install_time", -1L);
            mk0Var.s = c.optInt("lazy_launch_switch", 0) == 1;
            mk0Var.t = c.optInt("lazy_launch_internal", 0);
            int optInt = c.optInt("package_launch_switch", Integer.MIN_VALUE);
            if (optInt == Integer.MIN_VALUE) {
                mk0Var.u = qm0.b().a().a("package_launch_switch", 1) == 1;
            } else {
                mk0Var.u = optInt == 1;
            }
            return mk0Var;
        }
        return (mk0) invokeL.objValue;
    }

    public static String b(@NonNull mk0 mk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mk0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", mk0Var.a);
                jSONObject.put(Constant.KEY_BUSINESS, mk0Var.b);
                jSONObject.put("content_type", mk0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, mk0Var.e);
                int i = 1;
                jSONObject.put("is_dirty", mk0Var.f ? 1 : 0);
                jSONObject.put("close_v_download", mk0Var.g);
                jSONObject.put("no_click_opt", mk0Var.h);
                jSONObject.put("open_after_install", mk0Var.i);
                jSONObject.put("action_area", mk0Var.j);
                jSONObject.put("notification_show_count", mk0Var.k);
                jSONObject.put("tips_show_count", mk0Var.l);
                jSONObject.put("als_app_save_day", mk0Var.p);
                jSONObject.put("finished_install_time", mk0Var.q);
                jSONObject.put("lazy_launch_switch", mk0Var.s ? 1 : 0);
                jSONObject.put("lazy_launch_internal", mk0Var.t);
                if (!mk0Var.u) {
                    i = 0;
                }
                jSONObject.put("package_launch_switch", i);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
