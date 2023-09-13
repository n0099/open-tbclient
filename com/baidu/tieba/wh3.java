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
public final class wh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii3 a;

        public a(ii3 ii3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("671", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948270535, "Lcom/baidu/tieba/wh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948270535, "Lcom/baidu/tieba/wh3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(zi4 zi4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{zi4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (zi4Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "pms callback is null");
                    return;
                }
                return;
            }
            an3 an3Var = new an3();
            an3Var.k(11L);
            an3Var.i(2331L);
            an3Var.f("Retry=" + z + ", Scene=" + zi4Var.getClass().getName());
            ii3 ii3Var = new ii3();
            ii3Var.q(ai3.n(i));
            ii3Var.p(an3Var);
            if (zi4Var instanceof ie2) {
                ii3Var.r(((ie2) zi4Var).I0());
            }
            b(ii3Var);
            if (a) {
                Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + zi4Var.getClass().getSimpleName());
            }
        }
    }

    public static void b(ii3 ii3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ii3Var) == null) {
            if (ii3Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "event is null");
                    return;
                }
                return;
            }
            bo3.k(new a(ii3Var), "SwanStabilityUBC");
        }
    }
}
