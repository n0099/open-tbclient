package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xj0 {
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

    public xj0() {
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
    public static xj0 a(String str) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            xj0 xj0Var = new xj0();
            JSONObject c = v01.c(str);
            xj0Var.a = c.optString("page");
            xj0Var.b = c.optString("business");
            xj0Var.d = c.optString("content_type");
            xj0Var.e = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            boolean z3 = false;
            if (c.optInt("is_dirty", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            xj0Var.f = z;
            xj0Var.g = c.optInt("close_v_download", 0);
            xj0Var.h = c.optInt("no_click_opt");
            xj0Var.i = c.optInt("open_after_install");
            xj0Var.j = c.optString("action_area");
            xj0Var.k = c.optInt("notification_show_count");
            xj0Var.l = c.optInt("tips_show_count");
            xj0Var.p = c.optLong("als_app_save_day");
            xj0Var.q = c.optLong("finished_install_time", -1L);
            if (c.optInt("lazy_launch_switch", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            xj0Var.s = z2;
            xj0Var.t = c.optInt("lazy_launch_internal", 0);
            int optInt = c.optInt("package_launch_switch", Integer.MIN_VALUE);
            if (optInt == Integer.MIN_VALUE) {
                if (bm0.b().a().a("package_launch_switch", 1) == 1) {
                    z3 = true;
                }
                xj0Var.u = z3;
            } else {
                if (optInt == 1) {
                    z3 = true;
                }
                xj0Var.u = z3;
            }
            return xj0Var;
        }
        return (xj0) invokeL.objValue;
    }

    public static String b(@NonNull xj0 xj0Var) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xj0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", xj0Var.a);
                jSONObject.put("business", xj0Var.b);
                jSONObject.put("content_type", xj0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, xj0Var.e);
                int i3 = 1;
                if (xj0Var.f) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_dirty", i);
                jSONObject.put("close_v_download", xj0Var.g);
                jSONObject.put("no_click_opt", xj0Var.h);
                jSONObject.put("open_after_install", xj0Var.i);
                jSONObject.put("action_area", xj0Var.j);
                jSONObject.put("notification_show_count", xj0Var.k);
                jSONObject.put("tips_show_count", xj0Var.l);
                jSONObject.put("als_app_save_day", xj0Var.p);
                jSONObject.put("finished_install_time", xj0Var.q);
                if (xj0Var.s) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("lazy_launch_switch", i2);
                jSONObject.put("lazy_launch_internal", xj0Var.t);
                if (!xj0Var.u) {
                    i3 = 0;
                }
                jSONObject.put("package_launch_switch", i3);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
