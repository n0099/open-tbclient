package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class yb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc3 a;

        public a(rc3 rc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948324351, "Lcom/baidu/tieba/yb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948324351, "Lcom/baidu/tieba/yb3;");
                return;
            }
        }
        a = am1.a;
    }

    public static void a(rc3 rc3Var, mq2 mq2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, rc3Var, mq2Var) == null) && rc3Var != null && mq2Var != null) {
            rc3Var.a = ic3.n(mq2Var.H());
            rc3Var.f = mq2Var.I();
            rc3Var.c = mq2Var.U();
            rc3Var.a("swan", ue3.h(mq2Var.H()));
            rc3Var.a("appversion", mq2Var.x1());
            rc3Var.a("thirdversion", mq2Var.y1());
            rc3Var.b(ic3.k(mq2Var.X()));
            rc3Var.d(mq2Var.t0().getString("ubc"));
        }
    }

    public static void b(sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sc3Var) == null) {
            if (sc3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            rc3 rc3Var = new rc3();
            rc3Var.f = sc3Var.f;
            rc3Var.a = sc3Var.a;
            rc3Var.g = sc3Var.g;
            rc3Var.c = sc3Var.c;
            rc3Var.b = sc3Var.b;
            rc3Var.e = sc3Var.e;
            rc3Var.e(sc3Var.c());
            c(rc3Var);
        }
    }

    public static void c(rc3 rc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rc3Var) == null) {
            ji3.j(new a(rc3Var), "SwanAppFuncClickUBC");
        }
    }
}
