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
public final class pf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ig3 a;

        public a(ig3 ig3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ig3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ig3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nf3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948060076, "Lcom/baidu/tieba/pf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948060076, "Lcom/baidu/tieba/pf3;");
                return;
            }
        }
        a = qp1.a;
    }

    public static void a(ig3 ig3Var, du2 du2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, ig3Var, du2Var) == null) && ig3Var != null && du2Var != null) {
            ig3Var.a = zf3.n(du2Var.G());
            ig3Var.f = du2Var.H();
            ig3Var.c = du2Var.T();
            ig3Var.a("swan", li3.h(du2Var.G()));
            ig3Var.a("appversion", du2Var.v1());
            ig3Var.a("thirdversion", du2Var.w1());
            ig3Var.b(zf3.k(du2Var.W()));
            ig3Var.d(du2Var.s0().getString("ubc"));
        }
    }

    public static void b(jg3 jg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jg3Var) == null) {
            if (jg3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            ig3 ig3Var = new ig3();
            ig3Var.f = jg3Var.f;
            ig3Var.a = jg3Var.a;
            ig3Var.g = jg3Var.g;
            ig3Var.c = jg3Var.c;
            ig3Var.b = jg3Var.b;
            ig3Var.e = jg3Var.e;
            ig3Var.e(jg3Var.c());
            c(ig3Var);
        }
    }

    public static void c(ig3 ig3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ig3Var) == null) {
            am3.j(new a(ig3Var), "SwanAppFuncClickUBC");
        }
    }
}
