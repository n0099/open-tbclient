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
public class ta4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile ta4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<rs1, sa4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948174466, "Lcom/baidu/tieba/ta4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948174466, "Lcom/baidu/tieba/ta4;");
                return;
            }
        }
        b = vm1.a;
        c = ta4.class.getSimpleName();
    }

    public ta4() {
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
        ra4.a();
        this.a = new HashMap();
    }

    public static ta4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (ta4.class) {
                    if (d == null) {
                        d = new ta4();
                    }
                }
            }
            return d;
        }
        return (ta4) invokeV.objValue;
    }

    public static void d(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rs1Var) == null) {
            synchronized (ta4.class) {
                if (d != null) {
                    d.c(rs1Var).i();
                }
            }
        }
    }

    public static void e(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rs1Var) == null) {
            synchronized (ta4.class) {
                if (d != null) {
                    d.f(rs1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, rs1Var) == null) {
            synchronized (ta4.class) {
                if (d != null) {
                    d.c(rs1Var).l();
                }
            }
        }
    }

    public synchronized sa4 c(rs1 rs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs1Var)) == null) {
            synchronized (this) {
                if (rs1Var == null) {
                    return null;
                }
                sa4 sa4Var = this.a.get(rs1Var);
                if (sa4Var == null) {
                    sa4Var = new sa4();
                    this.a.put(rs1Var, sa4Var);
                }
                return sa4Var;
            }
        }
        return (sa4) invokeL.objValue;
    }

    public final synchronized void f(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rs1Var) == null) {
            synchronized (this) {
                if (rs1Var == null) {
                    return;
                }
                sa4 remove = this.a.remove(rs1Var);
                if (remove != null) {
                    remove.j();
                }
            }
        }
    }

    public boolean a(Context context, ws2 ws2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ws2Var)) == null) {
            k32.i("map", "map create start");
            if (ek3.m(ws2Var.c) != null && ws2Var.isValid()) {
                ts1 B = xr2.V().B(ws2Var.c);
                if (!(B instanceof rs1)) {
                    k32.c("map", "WebViewManager is null");
                    return false;
                }
                sa4 c2 = c((rs1) B);
                if (c2.d(ws2Var.b) != null) {
                    k32.c("map", "map with id " + ws2Var.b + " exist");
                    return false;
                }
                ub4 M = ub4.M(context, ws2Var);
                if (M == null) {
                    k32.c("map", "map with id " + ws2Var.b + " model is invalid");
                    return false;
                }
                c22 w = M.w();
                if (!w.a()) {
                    k32.c("map", "map with id " + ws2Var.b + " create fail: " + w.b);
                    return false;
                } else if (!c2.g(M)) {
                    return false;
                } else {
                    k32.i("map", "map with id " + ws2Var.b + " init start");
                    nb4.a(context, M, ws2Var, c2);
                    k32.i("map", "map with id " + ws2Var.b + " init end");
                    k32.i("map", "map create end");
                    return true;
                }
            }
            k32.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ws2 ws2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ws2Var)) == null) {
            k32.i("map", "map remove start");
            if (ek3.m(ws2Var.c) == null) {
                k32.c("map", "webView is null or mapModel is null");
                return false;
            }
            ts1 B = xr2.V().B(ws2Var.c);
            if (!(B instanceof rs1)) {
                k32.c("map", "WebViewManager is null");
                return false;
            }
            sa4 c2 = c((rs1) B);
            ub4 d2 = c2.d(ws2Var.b);
            if (d2 == null) {
                k32.c("map", "remove map with id " + ws2Var.b + " not exist");
                return false;
            } else if (!c2.k(ws2Var.b)) {
                return false;
            } else {
                k32.i("map", "map remove end");
                if (x22.a(ws2Var) == null) {
                    d32.a("map", "remove with a null map component");
                }
                c22 C = d2.C();
                boolean a = C.a();
                if (!a) {
                    String str = c;
                    k32.c(str, "map remove fail: " + C.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean i(Context context, ws2 ws2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, ws2Var)) == null) {
            k32.i("map", "map update start");
            if (ek3.m(ws2Var.c) == null) {
                k32.c("map", "webView is null or mapModel is null");
                return false;
            }
            ts1 B = xr2.V().B(ws2Var.c);
            if (B != null && (B instanceof rs1)) {
                sa4 c2 = c((rs1) B);
                ub4 d2 = c2.d(ws2Var.b);
                if (d2 == null) {
                    k32.c("map", "remove map with id " + ws2Var.b + " not exist");
                    return false;
                }
                d2.H();
                nb4.b(context, d2, ws2Var, c2, true);
                k32.i("map", "map update end");
                if (x22.a(ws2Var) == null) {
                    d32.a("map", "update with a null map component");
                }
                c22 G = d2.G(ws2Var);
                boolean a = G.a();
                if (!a) {
                    String str = c;
                    k32.c(str, "map update fail: " + G.b);
                }
                return a;
            }
            k32.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
