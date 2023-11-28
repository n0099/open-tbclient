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
public final class qc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;

        public a(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oc3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948086984, "Lcom/baidu/tieba/qc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948086984, "Lcom/baidu/tieba/qc3;");
                return;
            }
        }
        a = sm1.a;
    }

    public static void a(jd3 jd3Var, er2 er2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, jd3Var, er2Var) == null) && jd3Var != null && er2Var != null) {
            jd3Var.a = ad3.n(er2Var.H());
            jd3Var.f = er2Var.I();
            jd3Var.c = er2Var.U();
            jd3Var.a("swan", mf3.h(er2Var.H()));
            jd3Var.a("appversion", er2Var.x1());
            jd3Var.a("thirdversion", er2Var.y1());
            jd3Var.b(ad3.k(er2Var.X()));
            jd3Var.d(er2Var.t0().getString("ubc"));
        }
    }

    public static void b(kd3 kd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, kd3Var) == null) {
            if (kd3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            jd3 jd3Var = new jd3();
            jd3Var.f = kd3Var.f;
            jd3Var.a = kd3Var.a;
            jd3Var.g = kd3Var.g;
            jd3Var.c = kd3Var.c;
            jd3Var.b = kd3Var.b;
            jd3Var.e = kd3Var.e;
            jd3Var.e(kd3Var.c());
            c(jd3Var);
        }
    }

    public static void c(jd3 jd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jd3Var) == null) {
            bj3.j(new a(jd3Var), "SwanAppFuncClickUBC");
        }
    }
}
