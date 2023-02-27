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
public final class vf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og3 a;

        public a(og3 og3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tf3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948238822, "Lcom/baidu/tieba/vf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948238822, "Lcom/baidu/tieba/vf3;");
                return;
            }
        }
        a = wp1.a;
    }

    public static void a(og3 og3Var, ju2 ju2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, og3Var, ju2Var) == null) && og3Var != null && ju2Var != null) {
            og3Var.a = fg3.n(ju2Var.G());
            og3Var.f = ju2Var.H();
            og3Var.c = ju2Var.T();
            og3Var.a("swan", ri3.h(ju2Var.G()));
            og3Var.a("appversion", ju2Var.v1());
            og3Var.a("thirdversion", ju2Var.w1());
            og3Var.b(fg3.k(ju2Var.W()));
            og3Var.d(ju2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(pg3 pg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pg3Var) == null) {
            if (pg3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            og3 og3Var = new og3();
            og3Var.f = pg3Var.f;
            og3Var.a = pg3Var.a;
            og3Var.g = pg3Var.g;
            og3Var.c = pg3Var.c;
            og3Var.b = pg3Var.b;
            og3Var.e = pg3Var.e;
            og3Var.e(pg3Var.c());
            c(og3Var);
        }
    }

    public static void c(og3 og3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, og3Var) == null) {
            gm3.j(new a(og3Var), "SwanAppFuncClickUBC");
        }
    }
}
