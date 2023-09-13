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
public final class qh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji3 a;

        public a(ji3 ji3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948091789, "Lcom/baidu/tieba/qh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948091789, "Lcom/baidu/tieba/qh3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(ji3 ji3Var, ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, ji3Var, ew2Var) == null) && ji3Var != null && ew2Var != null) {
            ji3Var.a = ai3.n(ew2Var.G());
            ji3Var.f = ew2Var.H();
            ji3Var.c = ew2Var.T();
            ji3Var.a("swan", mk3.h(ew2Var.G()));
            ji3Var.a("appversion", ew2Var.v1());
            ji3Var.a("thirdversion", ew2Var.w1());
            ji3Var.b(ai3.k(ew2Var.W()));
            ji3Var.d(ew2Var.s0().getString("ubc"));
        }
    }

    public static void b(ki3 ki3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ki3Var) == null) {
            if (ki3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            ji3 ji3Var = new ji3();
            ji3Var.f = ki3Var.f;
            ji3Var.a = ki3Var.a;
            ji3Var.g = ki3Var.g;
            ji3Var.c = ki3Var.c;
            ji3Var.b = ki3Var.b;
            ji3Var.e = ki3Var.e;
            ji3Var.e(ki3Var.c());
            c(ji3Var);
        }
    }

    public static void c(ji3 ji3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ji3Var) == null) {
            bo3.j(new a(ji3Var), "SwanAppFuncClickUBC");
        }
    }
}
