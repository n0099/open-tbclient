package com.baidu.tieba;

import android.os.Looper;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zb2 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public static volatile int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948354111, "Lcom/baidu/tieba/zb2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948354111, "Lcom/baidu/tieba/zb2;");
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zb2.c(this.a, this.b);
            }
        }
    }

    public static void d(@StringRes int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                c(i, i2);
            } else {
                tp3.a0(new a(i, i2));
            }
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b < 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            b = 0;
            a = 0L;
        }
    }

    public static void c(@StringRes int i, int i2) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) && (activity = mx2.T().getActivity()) != null && !activity.isFinishing()) {
            if (i2 != 1) {
                rb3.f(activity, i).G();
            } else {
                rb3.f(activity, i).I();
            }
        }
    }

    public static void f(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            g(i, 0);
        }
    }

    public static synchronized void g(@StringRes int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i, i2) == null) {
            synchronized (zb2.class) {
                int i3 = b;
                if (i3 != 0) {
                    if (i3 == 1 && (a + 5000) - System.currentTimeMillis() < 0) {
                        b = 2;
                        d(i, i2);
                        bc2.g("toast提示个数已达2个");
                    }
                } else {
                    b = 1;
                    a = System.currentTimeMillis();
                    d(i, i2);
                }
            }
        }
    }
}
