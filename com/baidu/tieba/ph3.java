package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ph3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii3 a;

        public a(ii3 ii3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nh3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948061998, "Lcom/baidu/tieba/ph3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948061998, "Lcom/baidu/tieba/ph3;");
                return;
            }
        }
        a = qr1.a;
    }

    public static void a(ii3 ii3Var, dw2 dw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, ii3Var, dw2Var) == null) && ii3Var != null && dw2Var != null) {
            ii3Var.a = zh3.n(dw2Var.G());
            ii3Var.f = dw2Var.H();
            ii3Var.c = dw2Var.T();
            ii3Var.a("swan", lk3.h(dw2Var.G()));
            ii3Var.a("appversion", dw2Var.v1());
            ii3Var.a("thirdversion", dw2Var.w1());
            ii3Var.b(zh3.k(dw2Var.W()));
            ii3Var.d(dw2Var.s0().getString("ubc"));
        }
    }

    public static void b(ji3 ji3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ji3Var) == null) {
            if (ji3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            ii3 ii3Var = new ii3();
            ii3Var.f = ji3Var.f;
            ii3Var.a = ji3Var.a;
            ii3Var.g = ji3Var.g;
            ii3Var.c = ji3Var.c;
            ii3Var.b = ji3Var.b;
            ii3Var.e = ji3Var.e;
            ii3Var.e(ji3Var.c());
            c(ii3Var);
        }
    }

    public static void c(ii3 ii3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ii3Var) == null) {
            ao3.j(new a(ii3Var), "SwanAppFuncClickUBC");
        }
    }
}
