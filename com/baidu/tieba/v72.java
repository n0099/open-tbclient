package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public static Runnable c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jl3.e(AppRuntime.getAppContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jl3.d(AppRuntime.getAppContext()).g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/v72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/v72;");
                return;
            }
        }
        a = kh1.a;
        hk2.g0().getSwitch("swan_cpu_booster", 0);
        b = b(0);
        if (a) {
            Log.d("SwanCpuBoosterWrapper", "swan_cpu_booster - 0");
            Log.d("SwanCpuBoosterWrapper", "SWAN_CPU_BOOSTER - " + b);
        }
        a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && b) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            jl3.b(a);
            if (c == null) {
                c = new b();
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanCpuBoosterWrapper", "init cpu booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i <= 0) {
                return false;
            }
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return hk2.u0().a();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65539, null, z) == null) && b) {
            if (a) {
                Log.d("SwanCpuBoosterWrapper", "cpu-booster preInit async ? - " + z);
            }
            a aVar = new a();
            if (z) {
                ExecutorUtilsExt.postOnElastic(aVar, "booster-preInit", 3);
            } else {
                aVar.run();
            }
        }
    }

    public static void d(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) || runnable == null) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(runnable, "SwanCpuBoosterWrapper", 0);
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && b) {
            if (a) {
                Log.d("SwanCpuBoosterWrapper", "startBooster");
            }
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            d(c);
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanCpuBoosterWrapper", "startBooster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }
}
