package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends p03 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u54 c;

        public a(u54 u54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u54Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p03, com.baidu.tieba.q03, com.baidu.tieba.o03
        public void onEvent(@NonNull m03 m03Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m03Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (m03Var.a() != null) {
                    i = m03Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (v54.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                u54 u54Var = this.c;
                u54Var.m = i;
                cb3.x("976", u54Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948191764, "Lcom/baidu/tieba/v54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948191764, "Lcom/baidu/tieba/v54;");
                return;
            }
        }
        a = tk1.a;
    }

    public static void b(u54 u54Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, u54Var) != null) || u54Var == null) {
            return;
        }
        e13.Q().X(null, xv2.class, new a(u54Var));
    }

    public static void c(ci1 ci1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ci1Var) != null) || ci1Var == null || (a2 = ci1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(t04.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= t04.a()) {
            return;
        }
        u54 u54Var = new u54();
        u54Var.b = "stuck";
        u54Var.e = "jserror";
        u54Var.f = j43.g0();
        if (j43.M() != null && j43.M().Y() != null) {
            gp2.a Y = j43.M().Y();
            u54Var.c = Y.T();
            u54Var.a = cb3.n(Y.G());
        }
        u54Var.l = str + ";" + str2;
        if (g54.d()) {
            i = 20;
        } else {
            i = 10;
        }
        u54Var.k = i;
        u54Var.n = t04.b();
        u54Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(u54Var);
    }
}
