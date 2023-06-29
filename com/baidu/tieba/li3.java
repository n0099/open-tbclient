package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class li3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej3 a;

        public a(ej3 ej3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ji3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947943795, "Lcom/baidu/tieba/li3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947943795, "Lcom/baidu/tieba/li3;");
                return;
            }
        }
        a = ms1.a;
    }

    public static void a(ej3 ej3Var, zw2 zw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, ej3Var, zw2Var) == null) && ej3Var != null && zw2Var != null) {
            ej3Var.a = vi3.n(zw2Var.G());
            ej3Var.f = zw2Var.H();
            ej3Var.c = zw2Var.T();
            ej3Var.a("swan", hl3.h(zw2Var.G()));
            ej3Var.a("appversion", zw2Var.v1());
            ej3Var.a("thirdversion", zw2Var.w1());
            ej3Var.b(vi3.k(zw2Var.W()));
            ej3Var.d(zw2Var.s0().getString("ubc"));
        }
    }

    public static void b(fj3 fj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fj3Var) == null) {
            if (fj3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            ej3 ej3Var = new ej3();
            ej3Var.f = fj3Var.f;
            ej3Var.a = fj3Var.a;
            ej3Var.g = fj3Var.g;
            ej3Var.c = fj3Var.c;
            ej3Var.b = fj3Var.b;
            ej3Var.e = fj3Var.e;
            ej3Var.e(fj3Var.c());
            c(ej3Var);
        }
    }

    public static void c(ej3 ej3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ej3Var) == null) {
            wo3.j(new a(ej3Var), "SwanAppFuncClickUBC");
        }
    }
}
