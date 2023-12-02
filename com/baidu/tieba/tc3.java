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
public final class tc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md3 a;

        public a(md3 md3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948176357, "Lcom/baidu/tieba/tc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948176357, "Lcom/baidu/tieba/tc3;");
                return;
            }
        }
        a = vm1.a;
    }

    public static void a(md3 md3Var, hr2 hr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, md3Var, hr2Var) == null) && md3Var != null && hr2Var != null) {
            md3Var.a = dd3.n(hr2Var.H());
            md3Var.f = hr2Var.I();
            md3Var.c = hr2Var.U();
            md3Var.a("swan", pf3.h(hr2Var.H()));
            md3Var.a("appversion", hr2Var.x1());
            md3Var.a("thirdversion", hr2Var.y1());
            md3Var.b(dd3.k(hr2Var.X()));
            md3Var.d(hr2Var.t0().getString("ubc"));
        }
    }

    public static void b(nd3 nd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, nd3Var) == null) {
            if (nd3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            md3 md3Var = new md3();
            md3Var.f = nd3Var.f;
            md3Var.a = nd3Var.a;
            md3Var.g = nd3Var.g;
            md3Var.c = nd3Var.c;
            md3Var.b = nd3Var.b;
            md3Var.e = nd3Var.e;
            md3Var.e(nd3Var.c());
            c(md3Var);
        }
    }

    public static void c(md3 md3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, md3Var) == null) {
            ej3.j(new a(md3Var), "SwanAppFuncClickUBC");
        }
    }
}
