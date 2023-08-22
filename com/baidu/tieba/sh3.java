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
public final class sh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei3 a;

        public a(ei3 ei3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ei3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("671", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151371, "Lcom/baidu/tieba/sh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151371, "Lcom/baidu/tieba/sh3;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void a(vi4 vi4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{vi4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (vi4Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "pms callback is null");
                    return;
                }
                return;
            }
            wm3 wm3Var = new wm3();
            wm3Var.k(11L);
            wm3Var.i(2331L);
            wm3Var.f("Retry=" + z + ", Scene=" + vi4Var.getClass().getName());
            ei3 ei3Var = new ei3();
            ei3Var.q(wh3.n(i));
            ei3Var.p(wm3Var);
            if (vi4Var instanceof ee2) {
                ei3Var.r(((ee2) vi4Var).I0());
            }
            b(ei3Var);
            if (a) {
                Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + vi4Var.getClass().getSimpleName());
            }
        }
    }

    public static void b(ei3 ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ei3Var) == null) {
            if (ei3Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "event is null");
                    return;
                }
                return;
            }
            xn3.k(new a(ei3Var), "SwanStabilityUBC");
        }
    }
}
