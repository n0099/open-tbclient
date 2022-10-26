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
public final class v93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa3 a;

        public a(oa3 oa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oa3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t93.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195577, "Lcom/baidu/tieba/v93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195577, "Lcom/baidu/tieba/v93;");
                return;
            }
        }
        a = wj1.a;
    }

    public static void a(oa3 oa3Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, oa3Var, jo2Var) == null) && oa3Var != null && jo2Var != null) {
            oa3Var.a = fa3.n(jo2Var.G());
            oa3Var.f = jo2Var.H();
            oa3Var.c = jo2Var.T();
            oa3Var.a("swan", rc3.h(jo2Var.G()));
            oa3Var.a("appversion", jo2Var.v1());
            oa3Var.a("thirdversion", jo2Var.w1());
            oa3Var.b(fa3.k(jo2Var.W()));
            oa3Var.d(jo2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(pa3 pa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pa3Var) == null) {
            if (pa3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            oa3 oa3Var = new oa3();
            oa3Var.f = pa3Var.f;
            oa3Var.a = pa3Var.a;
            oa3Var.g = pa3Var.g;
            oa3Var.c = pa3Var.c;
            oa3Var.b = pa3Var.b;
            oa3Var.e = pa3Var.e;
            oa3Var.e(pa3Var.c());
            c(oa3Var);
        }
    }

    public static void c(oa3 oa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, oa3Var) == null) {
            gg3.j(new a(oa3Var), "SwanAppFuncClickUBC");
        }
    }
}
