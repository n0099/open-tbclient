package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.cp2;
import com.baidu.tieba.zu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class su2 {
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

        /* renamed from: com.baidu.tieba.su2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0427a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ Bitmap b;
            public final /* synthetic */ Rect c;

            public RunnableC0427a(a aVar, int i, Bitmap bitmap, Rect rect) {
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
                    zu2 a = zu2.a.a("simple_parser");
                    a.c(this.a);
                    if (!a.a(this.b, this.c)) {
                        su2.h();
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
            o32 X;
            n32 o;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = sp2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (X = activity.X()) == null || (o = X.o()) == null) {
                return;
            }
            Bitmap p = wh3.p();
            zg3.f().execute(new RunnableC0427a(this, ou2.d(o), p, ou2.b(p, o, sp2.U().B(this.a))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163833, "Lcom/baidu/tieba/su2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163833, "Lcom/baidu/tieba/su2;");
                return;
            }
        }
        a = pk1.a;
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
        cp2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (f43.M() != null) {
                aVar = f43.M().Y();
            } else {
                aVar = null;
            }
            pa3.o(aVar);
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
            zh3.a0(new a(str));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b = str;
        }
    }

    public static void c() {
        o32 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start handle arrival report");
            }
            if (pa3.f() || (V = sp2.U().V()) == null) {
                return;
            }
            n32 o = V.o();
            wq1 wq1Var = null;
            if (o != null) {
                lq1 o3 = o.o3();
                if (o3 == null) {
                    return;
                }
                oq1 k = o3.k();
                if (k != null) {
                    wq1Var = k.M();
                } else {
                    wq1Var = o3.M();
                }
            }
            if (wq1Var != null && wq1Var.b > 0) {
                pa3.a(wq1Var);
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || pa3.h()) {
            return;
        }
        n32 H = sp2.U().H();
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
            b(H.t3());
        }
    }

    public static boolean f(n32 n32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, n32Var)) == null) {
            if (n32Var == null) {
                return false;
            }
            boolean equals = TextUtils.equals(b, n32Var.t3());
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
            if (z && pa3.j()) {
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
            pa3.G();
            c();
            f43 M = f43.M();
            if (M != null && !z) {
                pa3.q(M.Y());
            }
        }
    }
}
