package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ki3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wi3 a;

        public a(wi3 wi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("671", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947914004, "Lcom/baidu/tieba/ki3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947914004, "Lcom/baidu/tieba/ki3;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a(nj4 nj4Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{nj4Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (nj4Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "pms callback is null");
                    return;
                }
                return;
            }
            on3 on3Var = new on3();
            on3Var.k(11L);
            on3Var.i(2331L);
            on3Var.f("Retry=" + z + ", Scene=" + nj4Var.getClass().getName());
            wi3 wi3Var = new wi3();
            wi3Var.q(oi3.n(i));
            wi3Var.p(on3Var);
            if (nj4Var instanceof we2) {
                wi3Var.r(((we2) nj4Var).I0());
            }
            b(wi3Var);
            if (a) {
                Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + nj4Var.getClass().getSimpleName());
            }
        }
    }

    public static void b(wi3 wi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, wi3Var) == null) {
            if (wi3Var == null) {
                if (a) {
                    Log.d("SwanStabilityUbc", "event is null");
                    return;
                }
                return;
            }
            po3.k(new a(wi3Var), "SwanStabilityUBC");
        }
    }
}
