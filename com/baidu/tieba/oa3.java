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
/* loaded from: classes5.dex */
public final class oa3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb3 a;

        public a(hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ma3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948025480, "Lcom/baidu/tieba/oa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948025480, "Lcom/baidu/tieba/oa3;");
                return;
            }
        }
        a = pk1.a;
    }

    public static void a(hb3 hb3Var, cp2 cp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, hb3Var, cp2Var) == null) && hb3Var != null && cp2Var != null) {
            hb3Var.a = ya3.n(cp2Var.G());
            hb3Var.f = cp2Var.H();
            hb3Var.c = cp2Var.T();
            hb3Var.a("swan", kd3.h(cp2Var.G()));
            hb3Var.a("appversion", cp2Var.v1());
            hb3Var.a("thirdversion", cp2Var.w1());
            hb3Var.b(ya3.k(cp2Var.W()));
            hb3Var.d(cp2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(ib3 ib3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ib3Var) == null) {
            if (ib3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            hb3 hb3Var = new hb3();
            hb3Var.f = ib3Var.f;
            hb3Var.a = ib3Var.a;
            hb3Var.g = ib3Var.g;
            hb3Var.c = ib3Var.c;
            hb3Var.b = ib3Var.b;
            hb3Var.e = ib3Var.e;
            hb3Var.e(ib3Var.c());
            c(hb3Var);
        }
    }

    public static void c(hb3 hb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, hb3Var) == null) {
            zg3.j(new a(hb3Var), "SwanAppFuncClickUBC");
        }
    }
}
