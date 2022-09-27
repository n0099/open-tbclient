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
public final class u93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na3 a;

        public a(na3 na3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165786, "Lcom/baidu/tieba/u93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165786, "Lcom/baidu/tieba/u93;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a(na3 na3Var, io2 io2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, na3Var, io2Var) == null) || na3Var == null || io2Var == null) {
            return;
        }
        na3Var.a = ea3.n(io2Var.G());
        na3Var.f = io2Var.H();
        na3Var.c = io2Var.T();
        na3Var.a("swan", qc3.h(io2Var.G()));
        na3Var.a("appversion", io2Var.v1());
        na3Var.a("thirdversion", io2Var.w1());
        na3Var.b(ea3.k(io2Var.W()));
        na3Var.d(io2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(oa3 oa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, oa3Var) == null) {
            if (oa3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            na3 na3Var = new na3();
            na3Var.f = oa3Var.f;
            na3Var.a = oa3Var.a;
            na3Var.g = oa3Var.g;
            na3Var.c = oa3Var.c;
            na3Var.b = oa3Var.b;
            na3Var.e = oa3Var.e;
            na3Var.e(oa3Var.c());
            c(na3Var);
        }
    }

    public static void c(na3 na3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, na3Var) == null) {
            fg3.j(new a(na3Var), "SwanAppFuncClickUBC");
        }
    }
}
