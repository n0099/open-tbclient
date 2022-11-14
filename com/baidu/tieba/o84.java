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
/* loaded from: classes5.dex */
public class o84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile o84 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<lq1, n84> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947986110, "Lcom/baidu/tieba/o84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947986110, "Lcom/baidu/tieba/o84;");
                return;
            }
        }
        b = pk1.a;
        c = o84.class.getSimpleName();
    }

    public o84() {
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
        m84.a();
        this.a = new HashMap();
    }

    public static o84 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (o84.class) {
                    if (d == null) {
                        d = new o84();
                    }
                }
            }
            return d;
        }
        return (o84) invokeV.objValue;
    }

    public static void d(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, lq1Var) == null) {
            synchronized (o84.class) {
                if (d != null) {
                    d.c(lq1Var).h();
                }
            }
        }
    }

    public static void e(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lq1Var) == null) {
            synchronized (o84.class) {
                if (d != null) {
                    d.f(lq1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, lq1Var) == null) {
            synchronized (o84.class) {
                if (d != null) {
                    d.c(lq1Var).k();
                }
            }
        }
    }

    public synchronized n84 c(lq1 lq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lq1Var)) == null) {
            synchronized (this) {
                if (lq1Var == null) {
                    return null;
                }
                n84 n84Var = this.a.get(lq1Var);
                if (n84Var == null) {
                    n84Var = new n84();
                    this.a.put(lq1Var, n84Var);
                }
                return n84Var;
            }
        }
        return (n84) invokeL.objValue;
    }

    public final synchronized void f(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq1Var) == null) {
            synchronized (this) {
                if (lq1Var == null) {
                    return;
                }
                n84 remove = this.a.remove(lq1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, rq2 rq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, rq2Var)) == null) {
            f12.i("map", "map create start");
            if (zh3.m(rq2Var.c) != null && rq2Var.isValid()) {
                nq1 A = sp2.U().A(rq2Var.c);
                if (!(A instanceof lq1)) {
                    f12.c("map", "WebViewManager is null");
                    return false;
                }
                n84 c2 = c((lq1) A);
                if (c2.d(rq2Var.b) != null) {
                    f12.c("map", "map with id " + rq2Var.b + " exist");
                    return false;
                }
                p94 K = p94.K(context, rq2Var);
                if (K == null) {
                    f12.c("map", "map with id " + rq2Var.b + " model is invalid");
                    return false;
                }
                wz1 insert = K.insert();
                if (!insert.a()) {
                    f12.c("map", "map with id " + rq2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    f12.i("map", "map with id " + rq2Var.b + " init start");
                    i94.a(context, K, rq2Var, c2);
                    f12.i("map", "map with id " + rq2Var.b + " init end");
                    f12.i("map", "map create end");
                    return true;
                }
            }
            f12.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(rq2 rq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rq2Var)) == null) {
            f12.i("map", "map remove start");
            if (zh3.m(rq2Var.c) == null) {
                f12.c("map", "webView is null or mapModel is null");
                return false;
            }
            nq1 A = sp2.U().A(rq2Var.c);
            if (!(A instanceof lq1)) {
                f12.c("map", "WebViewManager is null");
                return false;
            }
            n84 c2 = c((lq1) A);
            p94 d2 = c2.d(rq2Var.b);
            if (d2 == null) {
                f12.c("map", "remove map with id " + rq2Var.b + " not exist");
                return false;
            } else if (!c2.j(rq2Var.b)) {
                return false;
            } else {
                f12.i("map", "map remove end");
                if (s02.a(rq2Var) == null) {
                    y02.a("map", "remove with a null map component");
                }
                wz1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    f12.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, rq2 rq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, rq2Var)) == null) {
            f12.i("map", "map update start");
            if (zh3.m(rq2Var.c) == null) {
                f12.c("map", "webView is null or mapModel is null");
                return false;
            }
            nq1 A = sp2.U().A(rq2Var.c);
            if (A != null && (A instanceof lq1)) {
                n84 c2 = c((lq1) A);
                p94 d2 = c2.d(rq2Var.b);
                if (d2 == null) {
                    f12.c("map", "remove map with id " + rq2Var.b + " not exist");
                    return false;
                }
                d2.F();
                i94.b(context, d2, rq2Var, c2, true);
                f12.i("map", "map update end");
                if (s02.a(rq2Var) == null) {
                    y02.a("map", "update with a null map component");
                }
                wz1 update = d2.update((p94) rq2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    f12.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            f12.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
