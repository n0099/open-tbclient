package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class y94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile y94 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<wr1, x94> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284981, "Lcom/baidu/tieba/y94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284981, "Lcom/baidu/tieba/y94;");
                return;
            }
        }
        b = am1.a;
        c = y94.class.getSimpleName();
    }

    public y94() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        w94.a();
        this.a = new HashMap();
    }

    public static y94 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (y94.class) {
                    if (d == null) {
                        d = new y94();
                    }
                }
            }
            return d;
        }
        return (y94) invokeV.objValue;
    }

    public static void d(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, wr1Var) == null) {
            synchronized (y94.class) {
                if (d != null) {
                    d.c(wr1Var).i();
                }
            }
        }
    }

    public static void e(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, wr1Var) == null) {
            synchronized (y94.class) {
                if (d != null) {
                    d.f(wr1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, wr1Var) == null) {
            synchronized (y94.class) {
                if (d != null) {
                    d.c(wr1Var).l();
                }
            }
        }
    }

    public synchronized x94 c(wr1 wr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wr1Var)) == null) {
            synchronized (this) {
                if (wr1Var == null) {
                    return null;
                }
                x94 x94Var = this.a.get(wr1Var);
                if (x94Var == null) {
                    x94Var = new x94();
                    this.a.put(wr1Var, x94Var);
                }
                return x94Var;
            }
        }
        return (x94) invokeL.objValue;
    }

    public final synchronized void f(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wr1Var) == null) {
            synchronized (this) {
                if (wr1Var == null) {
                    return;
                }
                x94 remove = this.a.remove(wr1Var);
                if (remove != null) {
                    remove.j();
                }
            }
        }
    }

    public boolean a(Context context, bs2 bs2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, bs2Var)) == null) {
            p22.i("map", "map create start");
            if (jj3.m(bs2Var.c) != null && bs2Var.isValid()) {
                yr1 B = cr2.V().B(bs2Var.c);
                if (!(B instanceof wr1)) {
                    p22.c("map", "WebViewManager is null");
                    return false;
                }
                x94 c2 = c((wr1) B);
                if (c2.d(bs2Var.b) != null) {
                    p22.c("map", "map with id " + bs2Var.b + " exist");
                    return false;
                }
                za4 M = za4.M(context, bs2Var);
                if (M == null) {
                    p22.c("map", "map with id " + bs2Var.b + " model is invalid");
                    return false;
                }
                h12 w = M.w();
                if (!w.a()) {
                    p22.c("map", "map with id " + bs2Var.b + " create fail: " + w.b);
                    return false;
                } else if (!c2.g(M)) {
                    return false;
                } else {
                    p22.i("map", "map with id " + bs2Var.b + " init start");
                    sa4.a(context, M, bs2Var, c2);
                    p22.i("map", "map with id " + bs2Var.b + " init end");
                    p22.i("map", "map create end");
                    return true;
                }
            }
            p22.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(bs2 bs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bs2Var)) == null) {
            p22.i("map", "map remove start");
            if (jj3.m(bs2Var.c) == null) {
                p22.c("map", "webView is null or mapModel is null");
                return false;
            }
            yr1 B = cr2.V().B(bs2Var.c);
            if (!(B instanceof wr1)) {
                p22.c("map", "WebViewManager is null");
                return false;
            }
            x94 c2 = c((wr1) B);
            za4 d2 = c2.d(bs2Var.b);
            if (d2 == null) {
                p22.c("map", "remove map with id " + bs2Var.b + " not exist");
                return false;
            } else if (!c2.k(bs2Var.b)) {
                return false;
            } else {
                p22.i("map", "map remove end");
                if (c22.a(bs2Var) == null) {
                    i22.a("map", "remove with a null map component");
                }
                h12 C = d2.C();
                boolean a = C.a();
                if (!a) {
                    String str = c;
                    p22.c(str, "map remove fail: " + C.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean i(Context context, bs2 bs2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, bs2Var)) == null) {
            p22.i("map", "map update start");
            if (jj3.m(bs2Var.c) == null) {
                p22.c("map", "webView is null or mapModel is null");
                return false;
            }
            yr1 B = cr2.V().B(bs2Var.c);
            if (B != null && (B instanceof wr1)) {
                x94 c2 = c((wr1) B);
                za4 d2 = c2.d(bs2Var.b);
                if (d2 == null) {
                    p22.c("map", "remove map with id " + bs2Var.b + " not exist");
                    return false;
                }
                d2.H();
                sa4.b(context, d2, bs2Var, c2, true);
                p22.i("map", "map update end");
                if (c22.a(bs2Var) == null) {
                    i22.a("map", "update with a null map component");
                }
                h12 G = d2.G(bs2Var);
                boolean a = G.a();
                if (!a) {
                    String str = c;
                    p22.c(str, "map update fail: " + G.b);
                }
                return a;
            }
            p22.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
