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
public class pf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile pf4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<mx1, of4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948060107, "Lcom/baidu/tieba/pf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948060107, "Lcom/baidu/tieba/pf4;");
                return;
            }
        }
        b = qr1.a;
        c = pf4.class.getSimpleName();
    }

    public pf4() {
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
        nf4.a();
        this.a = new HashMap();
    }

    public static pf4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (pf4.class) {
                    if (d == null) {
                        d = new pf4();
                    }
                }
            }
            return d;
        }
        return (pf4) invokeV.objValue;
    }

    public static void d(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mx1Var) == null) {
            synchronized (pf4.class) {
                if (d != null) {
                    d.c(mx1Var).h();
                }
            }
        }
    }

    public static void e(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mx1Var) == null) {
            synchronized (pf4.class) {
                if (d != null) {
                    d.f(mx1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, mx1Var) == null) {
            synchronized (pf4.class) {
                if (d != null) {
                    d.c(mx1Var).k();
                }
            }
        }
    }

    public synchronized of4 c(mx1 mx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx1Var)) == null) {
            synchronized (this) {
                if (mx1Var == null) {
                    return null;
                }
                of4 of4Var = this.a.get(mx1Var);
                if (of4Var == null) {
                    of4Var = new of4();
                    this.a.put(mx1Var, of4Var);
                }
                return of4Var;
            }
        }
        return (of4) invokeL.objValue;
    }

    public final synchronized void f(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mx1Var) == null) {
            synchronized (this) {
                if (mx1Var == null) {
                    return;
                }
                of4 remove = this.a.remove(mx1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, sx2 sx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, sx2Var)) == null) {
            g82.i("map", "map create start");
            if (ap3.m(sx2Var.c) != null && sx2Var.isValid()) {
                ox1 A = tw2.T().A(sx2Var.c);
                if (!(A instanceof mx1)) {
                    g82.c("map", "WebViewManager is null");
                    return false;
                }
                of4 c2 = c((mx1) A);
                if (c2.d(sx2Var.b) != null) {
                    g82.c("map", "map with id " + sx2Var.b + " exist");
                    return false;
                }
                qg4 K = qg4.K(context, sx2Var);
                if (K == null) {
                    g82.c("map", "map with id " + sx2Var.b + " model is invalid");
                    return false;
                }
                x62 insert = K.insert();
                if (!insert.a()) {
                    g82.c("map", "map with id " + sx2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    g82.i("map", "map with id " + sx2Var.b + " init start");
                    jg4.a(context, K, sx2Var, c2);
                    g82.i("map", "map with id " + sx2Var.b + " init end");
                    g82.i("map", "map create end");
                    return true;
                }
            }
            g82.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(sx2 sx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sx2Var)) == null) {
            g82.i("map", "map remove start");
            if (ap3.m(sx2Var.c) == null) {
                g82.c("map", "webView is null or mapModel is null");
                return false;
            }
            ox1 A = tw2.T().A(sx2Var.c);
            if (!(A instanceof mx1)) {
                g82.c("map", "WebViewManager is null");
                return false;
            }
            of4 c2 = c((mx1) A);
            qg4 d2 = c2.d(sx2Var.b);
            if (d2 == null) {
                g82.c("map", "remove map with id " + sx2Var.b + " not exist");
                return false;
            } else if (!c2.j(sx2Var.b)) {
                return false;
            } else {
                g82.i("map", "map remove end");
                if (t72.a(sx2Var) == null) {
                    z72.a("map", "remove with a null map component");
                }
                x62 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    g82.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, sx2 sx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, sx2Var)) == null) {
            g82.i("map", "map update start");
            if (ap3.m(sx2Var.c) == null) {
                g82.c("map", "webView is null or mapModel is null");
                return false;
            }
            ox1 A = tw2.T().A(sx2Var.c);
            if (A != null && (A instanceof mx1)) {
                of4 c2 = c((mx1) A);
                qg4 d2 = c2.d(sx2Var.b);
                if (d2 == null) {
                    g82.c("map", "remove map with id " + sx2Var.b + " not exist");
                    return false;
                }
                d2.F();
                jg4.b(context, d2, sx2Var, c2, true);
                g82.i("map", "map update end");
                if (t72.a(sx2Var) == null) {
                    z72.a("map", "update with a null map component");
                }
                x62 update = d2.update((qg4) sx2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    g82.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            g82.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
