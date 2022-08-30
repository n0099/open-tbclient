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
public class qi0 {
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
    public long o;
    public long p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;

    public qi0() {
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
        this.o = -1L;
        this.p = -1L;
        this.r = false;
        this.s = 0;
        this.t = true;
    }

    public static String a(@NonNull qi0 qi0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qi0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", qi0Var.a);
                jSONObject.put(Constant.KEY_BUSINESS, qi0Var.b);
                jSONObject.put("content_type", qi0Var.d);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, qi0Var.e);
                int i = 1;
                jSONObject.put("is_dirty", qi0Var.f ? 1 : 0);
                jSONObject.put("close_v_download", qi0Var.g);
                jSONObject.put("no_click_opt", qi0Var.h);
                jSONObject.put("open_after_install", qi0Var.i);
                jSONObject.put("action_area", qi0Var.j);
                jSONObject.put("notification_show_count", qi0Var.k);
                jSONObject.put("tips_show_count", qi0Var.l);
                jSONObject.put("als_app_save_day", qi0Var.o);
                jSONObject.put("finished_install_time", qi0Var.p);
                jSONObject.put("lazy_launch_switch", qi0Var.r ? 1 : 0);
                jSONObject.put("lazy_launch_internal", qi0Var.s);
                if (!qi0Var.t) {
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
