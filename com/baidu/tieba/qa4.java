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
public class qa4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile qa4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<os1, pa4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948085093, "Lcom/baidu/tieba/qa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948085093, "Lcom/baidu/tieba/qa4;");
                return;
            }
        }
        b = sm1.a;
        c = qa4.class.getSimpleName();
    }

    public qa4() {
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
        oa4.a();
        this.a = new HashMap();
    }

    public static qa4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (qa4.class) {
                    if (d == null) {
                        d = new qa4();
                    }
                }
            }
            return d;
        }
        return (qa4) invokeV.objValue;
    }

    public static void d(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, os1Var) == null) {
            synchronized (qa4.class) {
                if (d != null) {
                    d.c(os1Var).i();
                }
            }
        }
    }

    public static void e(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, os1Var) == null) {
            synchronized (qa4.class) {
                if (d != null) {
                    d.f(os1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, os1Var) == null) {
            synchronized (qa4.class) {
                if (d != null) {
                    d.c(os1Var).l();
                }
            }
        }
    }

    public synchronized pa4 c(os1 os1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, os1Var)) == null) {
            synchronized (this) {
                if (os1Var == null) {
                    return null;
                }
                pa4 pa4Var = this.a.get(os1Var);
                if (pa4Var == null) {
                    pa4Var = new pa4();
                    this.a.put(os1Var, pa4Var);
                }
                return pa4Var;
            }
        }
        return (pa4) invokeL.objValue;
    }

    public final synchronized void f(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, os1Var) == null) {
            synchronized (this) {
                if (os1Var == null) {
                    return;
                }
                pa4 remove = this.a.remove(os1Var);
                if (remove != null) {
                    remove.j();
                }
            }
        }
    }

    public boolean a(Context context, ts2 ts2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ts2Var)) == null) {
            h32.i("map", "map create start");
            if (bk3.m(ts2Var.c) != null && ts2Var.isValid()) {
                qs1 B = ur2.V().B(ts2Var.c);
                if (!(B instanceof os1)) {
                    h32.c("map", "WebViewManager is null");
                    return false;
                }
                pa4 c2 = c((os1) B);
                if (c2.d(ts2Var.b) != null) {
                    h32.c("map", "map with id " + ts2Var.b + " exist");
                    return false;
                }
                rb4 M = rb4.M(context, ts2Var);
                if (M == null) {
                    h32.c("map", "map with id " + ts2Var.b + " model is invalid");
                    return false;
                }
                z12 w = M.w();
                if (!w.a()) {
                    h32.c("map", "map with id " + ts2Var.b + " create fail: " + w.b);
                    return false;
                } else if (!c2.g(M)) {
                    return false;
                } else {
                    h32.i("map", "map with id " + ts2Var.b + " init start");
                    kb4.a(context, M, ts2Var, c2);
                    h32.i("map", "map with id " + ts2Var.b + " init end");
                    h32.i("map", "map create end");
                    return true;
                }
            }
            h32.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ts2 ts2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ts2Var)) == null) {
            h32.i("map", "map remove start");
            if (bk3.m(ts2Var.c) == null) {
                h32.c("map", "webView is null or mapModel is null");
                return false;
            }
            qs1 B = ur2.V().B(ts2Var.c);
            if (!(B instanceof os1)) {
                h32.c("map", "WebViewManager is null");
                return false;
            }
            pa4 c2 = c((os1) B);
            rb4 d2 = c2.d(ts2Var.b);
            if (d2 == null) {
                h32.c("map", "remove map with id " + ts2Var.b + " not exist");
                return false;
            } else if (!c2.k(ts2Var.b)) {
                return false;
            } else {
                h32.i("map", "map remove end");
                if (u22.a(ts2Var) == null) {
                    a32.a("map", "remove with a null map component");
                }
                z12 C = d2.C();
                boolean a = C.a();
                if (!a) {
                    String str = c;
                    h32.c(str, "map remove fail: " + C.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean i(Context context, ts2 ts2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, ts2Var)) == null) {
            h32.i("map", "map update start");
            if (bk3.m(ts2Var.c) == null) {
                h32.c("map", "webView is null or mapModel is null");
                return false;
            }
            qs1 B = ur2.V().B(ts2Var.c);
            if (B != null && (B instanceof os1)) {
                pa4 c2 = c((os1) B);
                rb4 d2 = c2.d(ts2Var.b);
                if (d2 == null) {
                    h32.c("map", "remove map with id " + ts2Var.b + " not exist");
                    return false;
                }
                d2.H();
                kb4.b(context, d2, ts2Var, c2, true);
                h32.i("map", "map update end");
                if (u22.a(ts2Var) == null) {
                    a32.a("map", "update with a null map component");
                }
                z12 G = d2.G(ts2Var);
                boolean a = G.a();
                if (!a) {
                    String str = c;
                    h32.c(str, "map update fail: " + G.b);
                }
                return a;
            }
            h32.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
