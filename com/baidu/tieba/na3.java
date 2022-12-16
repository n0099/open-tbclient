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
public final class na3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb3 a;

        public a(gb3 gb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                la3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947995689, "Lcom/baidu/tieba/na3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947995689, "Lcom/baidu/tieba/na3;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void a(gb3 gb3Var, bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, gb3Var, bp2Var) == null) && gb3Var != null && bp2Var != null) {
            gb3Var.a = xa3.n(bp2Var.G());
            gb3Var.f = bp2Var.H();
            gb3Var.c = bp2Var.T();
            gb3Var.a("swan", jd3.h(bp2Var.G()));
            gb3Var.a("appversion", bp2Var.v1());
            gb3Var.a("thirdversion", bp2Var.w1());
            gb3Var.b(xa3.k(bp2Var.W()));
            gb3Var.d(bp2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(hb3 hb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, hb3Var) == null) {
            if (hb3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            gb3 gb3Var = new gb3();
            gb3Var.f = hb3Var.f;
            gb3Var.a = hb3Var.a;
            gb3Var.g = hb3Var.g;
            gb3Var.c = hb3Var.c;
            gb3Var.b = hb3Var.b;
            gb3Var.e = hb3Var.e;
            gb3Var.e(hb3Var.c());
            c(gb3Var);
        }
    }

    public static void c(gb3 gb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gb3Var) == null) {
            yg3.j(new a(gb3Var), "SwanAppFuncClickUBC");
        }
    }
}
