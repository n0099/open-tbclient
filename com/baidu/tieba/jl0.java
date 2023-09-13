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
public class jl0 {
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
    public boolean v;
    public boolean w;

    public jl0() {
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
        this.v = false;
        this.w = un0.b().a().a("uad_notification_progress_switch", 1) == 1;
    }

    @NonNull
    public static jl0 a(String str) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            jl0 jl0Var = new jl0();
            JSONObject c = i31.c(str);
            jl0Var.a = c.optString("page");
            jl0Var.b = c.optString("business");
            jl0Var.c = c.optString("source");
            jl0Var.d = c.optString("content_type");
            jl0Var.e = c.optLong(BreakpointSQLiteKey.CONTENT_LENGTH);
            boolean z6 = false;
            if (c.optInt("is_dirty", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            jl0Var.f = z;
            jl0Var.g = c.optInt("close_v_download", 0);
            jl0Var.h = c.optInt("no_click_opt");
            jl0Var.i = c.optInt("open_after_install");
            jl0Var.j = c.optString("action_area");
            jl0Var.k = c.optInt("notification_show_count");
            jl0Var.l = c.optInt("tips_show_count");
            jl0Var.p = c.optLong("als_app_save_day");
            jl0Var.q = c.optLong("finished_install_time", -1L);
            if (c.optInt("lazy_launch_switch", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            jl0Var.s = z2;
            jl0Var.t = c.optInt("lazy_launch_internal", 0);
            if (c.optInt("is_start_download", 0) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            jl0Var.v = z3;
            int optInt = c.optInt("need_notification_progress", Integer.MIN_VALUE);
            if (optInt == Integer.MIN_VALUE) {
                if (un0.b().a().a("uad_notification_progress_switch", 1) == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                jl0Var.w = z5;
            } else {
                if (optInt == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                jl0Var.w = z4;
            }
            int optInt2 = c.optInt("package_launch_switch", Integer.MIN_VALUE);
            if (optInt2 == Integer.MIN_VALUE) {
                if (un0.b().a().a("package_launch_switch", 1) == 1) {
                    z6 = true;
                }
                jl0Var.u = z6;
            } else {
                if (optInt2 == 1) {
                    z6 = true;
                }
                jl0Var.u = z6;
            }
            return jl0Var;
        }
        return (jl0) invokeL.objValue;
    }

    public static String b(@NonNull jl0 jl0Var) {
        InterceptResult invokeL;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jl0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", jl0Var.a);
                jSONObject.put("business", jl0Var.b);
                jSONObject.put("source", jl0Var.c);
                jSONObject.put("content_type", jl0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, jl0Var.e);
                int i5 = 1;
                if (jl0Var.f) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_dirty", i);
                jSONObject.put("close_v_download", jl0Var.g);
                jSONObject.put("no_click_opt", jl0Var.h);
                jSONObject.put("open_after_install", jl0Var.i);
                jSONObject.put("action_area", jl0Var.j);
                jSONObject.put("notification_show_count", jl0Var.k);
                jSONObject.put("tips_show_count", jl0Var.l);
                jSONObject.put("als_app_save_day", jl0Var.p);
                jSONObject.put("finished_install_time", jl0Var.q);
                if (jl0Var.s) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("lazy_launch_switch", i2);
                jSONObject.put("lazy_launch_internal", jl0Var.t);
                if (jl0Var.u) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("package_launch_switch", i3);
                if (jl0Var.v) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject.put("is_start_download", i4);
                if (!jl0Var.w) {
                    i5 = 0;
                }
                jSONObject.put("need_notification_progress", i5);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
