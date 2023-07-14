package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ra2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ra2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ c42 c;
        public final /* synthetic */ o64 d;

        public a(o64 o64Var, boolean z, Context context, c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o64Var, Boolean.valueOf(z), context, c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o64Var;
            this.a = z;
            this.b = context;
            this.c = c42Var;
        }

        @Override // com.baidu.tieba.ra2.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (!this.a) {
                        s82.c(this.b, false);
                        this.d.e(this.c, true, "setEnableDebug:ok");
                        return;
                    }
                    this.d.g(this.b, this.c);
                    return;
                }
                ra2.c(this.b, str);
                o64 o64Var = this.d;
                o64Var.e(this.c, false, o64Var.f(str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements oq3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ c42 b;
        public final /* synthetic */ o64 c;

        public b(o64 o64Var, Context context, c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o64Var, context, c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o64Var;
            this.a = context;
            this.b = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    s82.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                m64.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public o64(fj2 fj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return String.format("setEnableDebug:fail %s", str);
        }
        return (String) invokeL.objValue;
    }

    public final void d(@NonNull vb3 vb3Var, @NonNull Context context, @NonNull c42 c42Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{vb3Var, context, c42Var, Boolean.valueOf(z)}) == null) {
            ra2.a(vb3Var, context, new a(this, z, context, c42Var));
        }
    }

    public final void e(c42 c42Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{c42Var, Boolean.valueOf(z), str}) == null) {
            e64 e64Var = new e64();
            e64Var.errMsg = str;
            he4.call(c42Var, z, e64Var);
        }
    }

    public final void g(Context context, c42 c42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, c42Var) == null) {
            m64.m().o(new b(this, context, c42Var));
        }
    }

    public static void h(JSONObject jSONObject) {
        vb3 M;
        SwanAppActivity w;
        dj2 g1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || (M = vb3.M()) == null || !M.w0() || (w = M.w()) == null) {
            return;
        }
        uo2 R = w.R();
        if (!(R instanceof w74) || (g1 = ((w74) R).g1()) == null) {
            return;
        }
        g1.dispatchEvent(j64.a(jSONObject));
    }

    public void i(JsObject jsObject) {
        c42 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jsObject) != null) || (F = c42.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        vb3 M = vb3.M();
        if (M == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            e(F, false, f("internal error"));
        } else if (l == s82.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(M, w, F, l);
        }
    }
}
