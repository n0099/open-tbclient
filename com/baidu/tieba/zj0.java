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
/* loaded from: classes6.dex */
public class zj0 {
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

    public zj0() {
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
    public static zj0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            zj0 zj0Var = new zj0();
            JSONObject c = kz0.c(str);
            zj0Var.a = c.optString("page");
            zj0Var.b = c.optString(Constant.KEY_BUSINESS);
            zj0Var.d = c.optString("content_type");
            zj0Var.e = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            zj0Var.f = c.optInt("is_dirty", 0) == 1;
            zj0Var.g = c.optInt("close_v_download", 0);
            zj0Var.h = c.optInt("no_click_opt");
            zj0Var.i = c.optInt("open_after_install");
            zj0Var.j = c.optString("action_area");
            zj0Var.k = c.optInt("notification_show_count");
            zj0Var.l = c.optInt("tips_show_count");
            zj0Var.p = c.optLong("als_app_save_day");
            zj0Var.q = c.optLong("finished_install_time", -1L);
            zj0Var.s = c.optInt("lazy_launch_switch", 0) == 1;
            zj0Var.t = c.optInt("lazy_launch_internal", 0);
            int optInt = c.optInt("package_launch_switch", Integer.MIN_VALUE);
            if (optInt == Integer.MIN_VALUE) {
                zj0Var.u = dm0.b().a().a("package_launch_switch", 1) == 1;
            } else {
                zj0Var.u = optInt == 1;
            }
            return zj0Var;
        }
        return (zj0) invokeL.objValue;
    }

    public static String b(@NonNull zj0 zj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zj0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", zj0Var.a);
                jSONObject.put(Constant.KEY_BUSINESS, zj0Var.b);
                jSONObject.put("content_type", zj0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, zj0Var.e);
                int i = 1;
                jSONObject.put("is_dirty", zj0Var.f ? 1 : 0);
                jSONObject.put("close_v_download", zj0Var.g);
                jSONObject.put("no_click_opt", zj0Var.h);
                jSONObject.put("open_after_install", zj0Var.i);
                jSONObject.put("action_area", zj0Var.j);
                jSONObject.put("notification_show_count", zj0Var.k);
                jSONObject.put("tips_show_count", zj0Var.l);
                jSONObject.put("als_app_save_day", zj0Var.p);
                jSONObject.put("finished_install_time", zj0Var.q);
                jSONObject.put("lazy_launch_switch", zj0Var.s ? 1 : 0);
                jSONObject.put("lazy_launch_internal", zj0Var.t);
                if (!zj0Var.u) {
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
