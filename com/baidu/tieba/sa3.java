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
/* loaded from: classes6.dex */
public final class sa3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb3 a;

        public a(lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qa3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948144644, "Lcom/baidu/tieba/sa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948144644, "Lcom/baidu/tieba/sa3;");
                return;
            }
        }
        a = tk1.a;
    }

    public static void a(lb3 lb3Var, gp2 gp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, lb3Var, gp2Var) == null) && lb3Var != null && gp2Var != null) {
            lb3Var.a = cb3.n(gp2Var.G());
            lb3Var.f = gp2Var.H();
            lb3Var.c = gp2Var.T();
            lb3Var.a("swan", od3.h(gp2Var.G()));
            lb3Var.a("appversion", gp2Var.v1());
            lb3Var.a("thirdversion", gp2Var.w1());
            lb3Var.b(cb3.k(gp2Var.W()));
            lb3Var.d(gp2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(mb3 mb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mb3Var) == null) {
            if (mb3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            lb3 lb3Var = new lb3();
            lb3Var.f = mb3Var.f;
            lb3Var.a = mb3Var.a;
            lb3Var.g = mb3Var.g;
            lb3Var.c = mb3Var.c;
            lb3Var.b = mb3Var.b;
            lb3Var.e = mb3Var.e;
            lb3Var.e(mb3Var.c());
            c(lb3Var);
        }
    }

    public static void c(lb3 lb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, lb3Var) == null) {
            dh3.j(new a(lb3Var), "SwanAppFuncClickUBC");
        }
    }
}
