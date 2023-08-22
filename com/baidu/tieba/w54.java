package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.z92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements z92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ k32 c;
        public final /* synthetic */ w54 d;

        public a(w54 w54Var, boolean z, Context context, k32 k32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w54Var, Boolean.valueOf(z), context, k32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w54Var;
            this.a = z;
            this.b = context;
            this.c = k32Var;
        }

        @Override // com.baidu.tieba.z92.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (!this.a) {
                        a82.c(this.b, false);
                        this.d.e(this.c, true, "setEnableDebug:ok");
                        return;
                    }
                    this.d.g(this.b, this.c);
                    return;
                }
                z92.c(this.b, str);
                w54 w54Var = this.d;
                w54Var.e(this.c, false, w54Var.f(str));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements wp3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ k32 b;
        public final /* synthetic */ w54 c;

        public b(w54 w54Var, Context context, k32 k32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w54Var, context, k32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w54Var;
            this.a = context;
            this.b = k32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    a82.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                u54.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public w54(ni2 ni2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ni2Var};
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

    public final void d(@NonNull db3 db3Var, @NonNull Context context, @NonNull k32 k32Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{db3Var, context, k32Var, Boolean.valueOf(z)}) == null) {
            z92.a(db3Var, context, new a(this, z, context, k32Var));
        }
    }

    public final void e(k32 k32Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{k32Var, Boolean.valueOf(z), str}) == null) {
            m54 m54Var = new m54();
            m54Var.errMsg = str;
            pd4.call(k32Var, z, m54Var);
        }
    }

    public final void g(Context context, k32 k32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, k32Var) == null) {
            u54.m().o(new b(this, context, k32Var));
        }
    }

    public static void h(JSONObject jSONObject) {
        db3 M;
        SwanAppActivity w;
        li2 g1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || (M = db3.M()) == null || !M.w0() || (w = M.w()) == null) {
            return;
        }
        co2 Q = w.Q();
        if (!(Q instanceof e74) || (g1 = ((e74) Q).g1()) == null) {
            return;
        }
        g1.dispatchEvent(r54.a(jSONObject));
    }

    public void i(JsObject jsObject) {
        k32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jsObject) != null) || (F = k32.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        db3 M = db3.M();
        if (M == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            e(F, false, f("internal error"));
        } else if (l == a82.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(M, w, F, l);
        }
    }
}
