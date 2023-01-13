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
/* loaded from: classes6.dex */
public class s84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile s84 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<pq1, r84> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105274, "Lcom/baidu/tieba/s84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105274, "Lcom/baidu/tieba/s84;");
                return;
            }
        }
        b = tk1.a;
        c = s84.class.getSimpleName();
    }

    public s84() {
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
        q84.a();
        this.a = new HashMap();
    }

    public static s84 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (s84.class) {
                    if (d == null) {
                        d = new s84();
                    }
                }
            }
            return d;
        }
        return (s84) invokeV.objValue;
    }

    public static void d(pq1 pq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, pq1Var) == null) {
            synchronized (s84.class) {
                if (d != null) {
                    d.c(pq1Var).h();
                }
            }
        }
    }

    public static void e(pq1 pq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pq1Var) == null) {
            synchronized (s84.class) {
                if (d != null) {
                    d.f(pq1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(pq1 pq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, pq1Var) == null) {
            synchronized (s84.class) {
                if (d != null) {
                    d.c(pq1Var).k();
                }
            }
        }
    }

    public synchronized r84 c(pq1 pq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pq1Var)) == null) {
            synchronized (this) {
                if (pq1Var == null) {
                    return null;
                }
                r84 r84Var = this.a.get(pq1Var);
                if (r84Var == null) {
                    r84Var = new r84();
                    this.a.put(pq1Var, r84Var);
                }
                return r84Var;
            }
        }
        return (r84) invokeL.objValue;
    }

    public final synchronized void f(pq1 pq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pq1Var) == null) {
            synchronized (this) {
                if (pq1Var == null) {
                    return;
                }
                r84 remove = this.a.remove(pq1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, vq2 vq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, vq2Var)) == null) {
            j12.i("map", "map create start");
            if (di3.m(vq2Var.c) != null && vq2Var.isValid()) {
                rq1 A = wp2.U().A(vq2Var.c);
                if (!(A instanceof pq1)) {
                    j12.c("map", "WebViewManager is null");
                    return false;
                }
                r84 c2 = c((pq1) A);
                if (c2.d(vq2Var.b) != null) {
                    j12.c("map", "map with id " + vq2Var.b + " exist");
                    return false;
                }
                t94 K = t94.K(context, vq2Var);
                if (K == null) {
                    j12.c("map", "map with id " + vq2Var.b + " model is invalid");
                    return false;
                }
                a02 insert = K.insert();
                if (!insert.a()) {
                    j12.c("map", "map with id " + vq2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    j12.i("map", "map with id " + vq2Var.b + " init start");
                    m94.a(context, K, vq2Var, c2);
                    j12.i("map", "map with id " + vq2Var.b + " init end");
                    j12.i("map", "map create end");
                    return true;
                }
            }
            j12.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(vq2 vq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vq2Var)) == null) {
            j12.i("map", "map remove start");
            if (di3.m(vq2Var.c) == null) {
                j12.c("map", "webView is null or mapModel is null");
                return false;
            }
            rq1 A = wp2.U().A(vq2Var.c);
            if (!(A instanceof pq1)) {
                j12.c("map", "WebViewManager is null");
                return false;
            }
            r84 c2 = c((pq1) A);
            t94 d2 = c2.d(vq2Var.b);
            if (d2 == null) {
                j12.c("map", "remove map with id " + vq2Var.b + " not exist");
                return false;
            } else if (!c2.j(vq2Var.b)) {
                return false;
            } else {
                j12.i("map", "map remove end");
                if (w02.a(vq2Var) == null) {
                    c12.a("map", "remove with a null map component");
                }
                a02 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    j12.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, vq2 vq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, vq2Var)) == null) {
            j12.i("map", "map update start");
            if (di3.m(vq2Var.c) == null) {
                j12.c("map", "webView is null or mapModel is null");
                return false;
            }
            rq1 A = wp2.U().A(vq2Var.c);
            if (A != null && (A instanceof pq1)) {
                r84 c2 = c((pq1) A);
                t94 d2 = c2.d(vq2Var.b);
                if (d2 == null) {
                    j12.c("map", "remove map with id " + vq2Var.b + " not exist");
                    return false;
                }
                d2.F();
                m94.b(context, d2, vq2Var, c2, true);
                j12.i("map", "map update end");
                if (w02.a(vq2Var) == null) {
                    c12.a("map", "update with a null map component");
                }
                a02 update = d2.update((t94) vq2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    j12.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            j12.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
