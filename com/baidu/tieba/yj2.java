package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.bw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yj2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public static String d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bw2.a aVar = (bw2.a) new bw2.a().s(this.a);
                gi3 gi3Var = new gi3();
                gi3Var.a = wh3.n(0);
                gi3Var.b = "launch";
                gi3Var.e = "repeatlaunch";
                gi3Var.a("launchInterval", Long.valueOf(aVar.l("launch_interval", -1L)));
                gi3Var.j(aVar);
                gi3Var.d(aVar.s0().getString("ubc"));
                gi3Var.b(wh3.k(aVar.W()));
                wh3.onEvent(gi3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948332008, "Lcom/baidu/tieba/yj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948332008, "Lcom/baidu/tieba/yj2;");
                return;
            }
        }
        a = nr1.a;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return System.currentTimeMillis() - b;
        }
        return invokeV.longValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            b = System.currentTimeMillis();
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            long currentTimeMillis = System.currentTimeMillis() - b;
            if (currentTimeMillis < 800 && TextUtils.equals(c, str) && TextUtils.equals(d, str2)) {
                z = true;
            } else {
                z = false;
            }
            if (a && z) {
                Log.d("SeriesLaunchChecker", "CurrentLaunchInterval:" + currentTimeMillis + ",PreventSeriesLaunchInterval:800");
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle) == null) {
            ExecutorUtilsExt.postOnElastic(new a(bundle), "SeriesLaunchChecker", 3);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            c = str;
            d = str2;
        }
    }
}
