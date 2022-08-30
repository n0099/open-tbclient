package com.baidu.tieba;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class j73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c83 a;

        public a(c83 c83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h73.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836163, "Lcom/baidu/tieba/j73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836163, "Lcom/baidu/tieba/j73;");
                return;
            }
        }
        a = kh1.a;
    }

    public static void a(c83 c83Var, xl2 xl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, c83Var, xl2Var) == null) || c83Var == null || xl2Var == null) {
            return;
        }
        c83Var.a = t73.n(xl2Var.G());
        c83Var.f = xl2Var.H();
        c83Var.c = xl2Var.T();
        c83Var.a("swan", fa3.h(xl2Var.G()));
        c83Var.a("appversion", xl2Var.v1());
        c83Var.a("thirdversion", xl2Var.w1());
        c83Var.b(t73.k(xl2Var.W()));
        c83Var.d(xl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(d83 d83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, d83Var) == null) {
            if (d83Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            c83 c83Var = new c83();
            c83Var.f = d83Var.f;
            c83Var.a = d83Var.a;
            c83Var.g = d83Var.g;
            c83Var.c = d83Var.c;
            c83Var.b = d83Var.b;
            c83Var.e = d83Var.e;
            c83Var.e(d83Var.c());
            c(c83Var);
        }
    }

    public static void c(c83 c83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, c83Var) == null) {
            ud3.j(new a(c83Var), "SwanAppFuncClickUBC");
        }
    }
}
