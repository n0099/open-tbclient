package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.s23;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class l23 {
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

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: com.baidu.tieba.l23$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0375a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ Bitmap b;
            public final /* synthetic */ Rect c;

            public RunnableC0375a(a aVar, int i, Bitmap bitmap, Rect rect) {
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
                    s23 a = s23.a.a("simple_parser");
                    a.c(this.a);
                    if (!a.a(this.b, this.c)) {
                        l23.h();
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
            hb2 Y;
            gb2 o;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = lx2.T().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (Y = activity.Y()) == null || (o = Y.o()) == null) {
                return;
            }
            Bitmap p = pp3.p();
            so3.f().execute(new RunnableC0375a(this, h23.d(o), p, h23.b(p, o, lx2.T().B(this.a))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890940, "Lcom/baidu/tieba/l23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890940, "Lcom/baidu/tieba/l23;");
                return;
            }
        }
        a = is1.a;
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
        vw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (yb3.M() != null) {
                aVar = yb3.M().Y();
            } else {
                aVar = null;
            }
            ii3.o(aVar);
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
            sp3.a0(new a(str));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b = str;
        }
    }

    public static void c() {
        hb2 U;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start handle arrival report");
            }
            if (ii3.f() || (U = lx2.T().U()) == null) {
                return;
            }
            gb2 o = U.o();
            py1 py1Var = null;
            if (o != null) {
                ey1 q3 = o.q3();
                if (q3 == null) {
                    return;
                }
                hy1 j = q3.j();
                if (j != null) {
                    py1Var = j.M();
                } else {
                    py1Var = q3.M();
                }
            }
            if (py1Var != null && py1Var.b > 0) {
                ii3.a(py1Var);
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || ii3.h()) {
            return;
        }
        gb2 H = lx2.T().H();
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
            b(H.v3());
        }
    }

    public static boolean f(gb2 gb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, gb2Var)) == null) {
            if (gb2Var == null) {
                return false;
            }
            boolean equals = TextUtils.equals(b, gb2Var.v3());
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
            if (z && ii3.j()) {
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
            ii3.G();
            c();
            yb3 M = yb3.M();
            if (M != null && !z) {
                ii3.q(M.Y());
            }
        }
    }
}
