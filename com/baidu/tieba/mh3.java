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
public final class mh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;

        public a(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947972625, "Lcom/baidu/tieba/mh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947972625, "Lcom/baidu/tieba/mh3;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void a(fi3 fi3Var, aw2 aw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, fi3Var, aw2Var) == null) && fi3Var != null && aw2Var != null) {
            fi3Var.a = wh3.n(aw2Var.G());
            fi3Var.f = aw2Var.H();
            fi3Var.c = aw2Var.T();
            fi3Var.a("swan", ik3.h(aw2Var.G()));
            fi3Var.a("appversion", aw2Var.v1());
            fi3Var.a("thirdversion", aw2Var.w1());
            fi3Var.b(wh3.k(aw2Var.W()));
            fi3Var.d(aw2Var.s0().getString("ubc"));
        }
    }

    public static void b(gi3 gi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, gi3Var) == null) {
            if (gi3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            fi3 fi3Var = new fi3();
            fi3Var.f = gi3Var.f;
            fi3Var.a = gi3Var.a;
            fi3Var.g = gi3Var.g;
            fi3Var.c = gi3Var.c;
            fi3Var.b = gi3Var.b;
            fi3Var.e = gi3Var.e;
            fi3Var.e(gi3Var.c());
            c(fi3Var);
        }
    }

    public static void c(fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fi3Var) == null) {
            xn3.j(new a(fi3Var), "SwanAppFuncClickUBC");
        }
    }
}
