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
/* loaded from: classes7.dex */
public class pa4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile pa4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<ns1, oa4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055302, "Lcom/baidu/tieba/pa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055302, "Lcom/baidu/tieba/pa4;");
                return;
            }
        }
        b = rm1.a;
        c = pa4.class.getSimpleName();
    }

    public pa4() {
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
        na4.a();
        this.a = new HashMap();
    }

    public static pa4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (pa4.class) {
                    if (d == null) {
                        d = new pa4();
                    }
                }
            }
            return d;
        }
        return (pa4) invokeV.objValue;
    }

    public static void d(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ns1Var) == null) {
            synchronized (pa4.class) {
                if (d != null) {
                    d.c(ns1Var).i();
                }
            }
        }
    }

    public static void e(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ns1Var) == null) {
            synchronized (pa4.class) {
                if (d != null) {
                    d.f(ns1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ns1Var) == null) {
            synchronized (pa4.class) {
                if (d != null) {
                    d.c(ns1Var).l();
                }
            }
        }
    }

    public synchronized oa4 c(ns1 ns1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ns1Var)) == null) {
            synchronized (this) {
                if (ns1Var == null) {
                    return null;
                }
                oa4 oa4Var = this.a.get(ns1Var);
                if (oa4Var == null) {
                    oa4Var = new oa4();
                    this.a.put(ns1Var, oa4Var);
                }
                return oa4Var;
            }
        }
        return (oa4) invokeL.objValue;
    }

    public final synchronized void f(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ns1Var) == null) {
            synchronized (this) {
                if (ns1Var == null) {
                    return;
                }
                oa4 remove = this.a.remove(ns1Var);
                if (remove != null) {
                    remove.j();
                }
            }
        }
    }

    public boolean a(Context context, ss2 ss2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ss2Var)) == null) {
            g32.i("map", "map create start");
            if (ak3.m(ss2Var.c) != null && ss2Var.isValid()) {
                ps1 B = tr2.V().B(ss2Var.c);
                if (!(B instanceof ns1)) {
                    g32.c("map", "WebViewManager is null");
                    return false;
                }
                oa4 c2 = c((ns1) B);
                if (c2.d(ss2Var.b) != null) {
                    g32.c("map", "map with id " + ss2Var.b + " exist");
                    return false;
                }
                qb4 M = qb4.M(context, ss2Var);
                if (M == null) {
                    g32.c("map", "map with id " + ss2Var.b + " model is invalid");
                    return false;
                }
                y12 w = M.w();
                if (!w.a()) {
                    g32.c("map", "map with id " + ss2Var.b + " create fail: " + w.b);
                    return false;
                } else if (!c2.g(M)) {
                    return false;
                } else {
                    g32.i("map", "map with id " + ss2Var.b + " init start");
                    jb4.a(context, M, ss2Var, c2);
                    g32.i("map", "map with id " + ss2Var.b + " init end");
                    g32.i("map", "map create end");
                    return true;
                }
            }
            g32.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ss2 ss2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ss2Var)) == null) {
            g32.i("map", "map remove start");
            if (ak3.m(ss2Var.c) == null) {
                g32.c("map", "webView is null or mapModel is null");
                return false;
            }
            ps1 B = tr2.V().B(ss2Var.c);
            if (!(B instanceof ns1)) {
                g32.c("map", "WebViewManager is null");
                return false;
            }
            oa4 c2 = c((ns1) B);
            qb4 d2 = c2.d(ss2Var.b);
            if (d2 == null) {
                g32.c("map", "remove map with id " + ss2Var.b + " not exist");
                return false;
            } else if (!c2.k(ss2Var.b)) {
                return false;
            } else {
                g32.i("map", "map remove end");
                if (t22.a(ss2Var) == null) {
                    z22.a("map", "remove with a null map component");
                }
                y12 C = d2.C();
                boolean a = C.a();
                if (!a) {
                    String str = c;
                    g32.c(str, "map remove fail: " + C.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean i(Context context, ss2 ss2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, ss2Var)) == null) {
            g32.i("map", "map update start");
            if (ak3.m(ss2Var.c) == null) {
                g32.c("map", "webView is null or mapModel is null");
                return false;
            }
            ps1 B = tr2.V().B(ss2Var.c);
            if (B != null && (B instanceof ns1)) {
                oa4 c2 = c((ns1) B);
                qb4 d2 = c2.d(ss2Var.b);
                if (d2 == null) {
                    g32.c("map", "remove map with id " + ss2Var.b + " not exist");
                    return false;
                }
                d2.H();
                jb4.b(context, d2, ss2Var, c2, true);
                g32.i("map", "map update end");
                if (t22.a(ss2Var) == null) {
                    z22.a("map", "update with a null map component");
                }
                y12 G = d2.G(ss2Var);
                boolean a = G.a();
                if (!a) {
                    String str = c;
                    g32.c(str, "map update fail: " + G.b);
                }
                return a;
            }
            g32.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
