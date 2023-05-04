package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ry2;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class ky2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile String b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: com.baidu.tieba.ky2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0342a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ Bitmap b;
            public final /* synthetic */ Rect c;

            public RunnableC0342a(a aVar, int i, Bitmap bitmap, Rect rect) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), bitmap, rect};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i;
                this.b = bitmap;
                this.c = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ry2 a = ry2.a.a("simple_parser");
                    a.c(this.a);
                    if (!a.a(this.b, this.c)) {
                        ky2.h();
                    }
                }
            }
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            g72 Z;
            f72 o;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = kt2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (Z = activity.Z()) == null || (o = Z.o()) == null) {
                return;
            }
            Bitmap p = ol3.p();
            rk3.f().execute(new RunnableC0342a(this, gy2.d(o), p, gy2.b(p, o, kt2.U().B(this.a))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947929349, "Lcom/baidu/tieba/ky2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947929349, "Lcom/baidu/tieba/ky2;");
                return;
            }
        }
        a = ho1.a;
        b = "";
        c = true;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return c;
        }
        return invokeV.booleanValue;
    }

    public static void h() {
        us2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (x73.M() != null) {
                aVar = x73.M().Y();
            } else {
                aVar = null;
            }
            he3.o(aVar);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            b = "";
            c = true;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            rl3.a0(new a(str));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b = str;
        }
    }

    public static void c() {
        g72 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start handle arrival report");
            }
            if (he3.f() || (V = kt2.U().V()) == null) {
                return;
            }
            f72 o = V.o();
            ou1 ou1Var = null;
            if (o != null) {
                du1 r3 = o.r3();
                if (r3 == null) {
                    return;
                }
                gu1 k = r3.k();
                if (k != null) {
                    ou1Var = k.M();
                } else {
                    ou1Var = r3.M();
                }
            }
            if (ou1Var != null && ou1Var.b > 0) {
                he3.a(ou1Var);
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || he3.h()) {
            return;
        }
        f72 H = kt2.U().H();
        if (H == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(H)) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(H.w3());
        }
    }

    public static boolean f(f72 f72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, f72Var)) == null) {
            if (f72Var == null) {
                return false;
            }
            boolean equals = TextUtils.equals(b, f72Var.w3());
            if (a) {
                Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
            }
            if (z && he3.j()) {
                if (a) {
                    Log.d("SwanArrivalMonitor", "end handle swan page change");
                    return;
                }
                return;
            }
            if (z) {
                c = false;
            }
            if (!z) {
                d();
            }
            he3.G();
            c();
            x73 M = x73.M();
            if (M != null && !z) {
                he3.q(M.Y());
            }
        }
    }
}
