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
public class vd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile vd4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<sv1, ud4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236931, "Lcom/baidu/tieba/vd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948236931, "Lcom/baidu/tieba/vd4;");
                return;
            }
        }
        b = wp1.a;
        c = vd4.class.getSimpleName();
    }

    public vd4() {
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
        td4.a();
        this.a = new HashMap();
    }

    public static vd4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (vd4.class) {
                    if (d == null) {
                        d = new vd4();
                    }
                }
            }
            return d;
        }
        return (vd4) invokeV.objValue;
    }

    public static void d(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, sv1Var) == null) {
            synchronized (vd4.class) {
                if (d != null) {
                    d.c(sv1Var).h();
                }
            }
        }
    }

    public static void e(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sv1Var) == null) {
            synchronized (vd4.class) {
                if (d != null) {
                    d.f(sv1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, sv1Var) == null) {
            synchronized (vd4.class) {
                if (d != null) {
                    d.c(sv1Var).k();
                }
            }
        }
    }

    public synchronized ud4 c(sv1 sv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv1Var)) == null) {
            synchronized (this) {
                if (sv1Var == null) {
                    return null;
                }
                ud4 ud4Var = this.a.get(sv1Var);
                if (ud4Var == null) {
                    ud4Var = new ud4();
                    this.a.put(sv1Var, ud4Var);
                }
                return ud4Var;
            }
        }
        return (ud4) invokeL.objValue;
    }

    public final synchronized void f(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sv1Var) == null) {
            synchronized (this) {
                if (sv1Var == null) {
                    return;
                }
                ud4 remove = this.a.remove(sv1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, yv2 yv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, yv2Var)) == null) {
            m62.i("map", "map create start");
            if (gn3.m(yv2Var.c) != null && yv2Var.isValid()) {
                uv1 A = zu2.U().A(yv2Var.c);
                if (!(A instanceof sv1)) {
                    m62.c("map", "WebViewManager is null");
                    return false;
                }
                ud4 c2 = c((sv1) A);
                if (c2.d(yv2Var.b) != null) {
                    m62.c("map", "map with id " + yv2Var.b + " exist");
                    return false;
                }
                we4 K = we4.K(context, yv2Var);
                if (K == null) {
                    m62.c("map", "map with id " + yv2Var.b + " model is invalid");
                    return false;
                }
                d52 insert = K.insert();
                if (!insert.a()) {
                    m62.c("map", "map with id " + yv2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    m62.i("map", "map with id " + yv2Var.b + " init start");
                    pe4.a(context, K, yv2Var, c2);
                    m62.i("map", "map with id " + yv2Var.b + " init end");
                    m62.i("map", "map create end");
                    return true;
                }
            }
            m62.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(yv2 yv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yv2Var)) == null) {
            m62.i("map", "map remove start");
            if (gn3.m(yv2Var.c) == null) {
                m62.c("map", "webView is null or mapModel is null");
                return false;
            }
            uv1 A = zu2.U().A(yv2Var.c);
            if (!(A instanceof sv1)) {
                m62.c("map", "WebViewManager is null");
                return false;
            }
            ud4 c2 = c((sv1) A);
            we4 d2 = c2.d(yv2Var.b);
            if (d2 == null) {
                m62.c("map", "remove map with id " + yv2Var.b + " not exist");
                return false;
            } else if (!c2.j(yv2Var.b)) {
                return false;
            } else {
                m62.i("map", "map remove end");
                if (z52.a(yv2Var) == null) {
                    f62.a("map", "remove with a null map component");
                }
                d52 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    m62.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, yv2 yv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, yv2Var)) == null) {
            m62.i("map", "map update start");
            if (gn3.m(yv2Var.c) == null) {
                m62.c("map", "webView is null or mapModel is null");
                return false;
            }
            uv1 A = zu2.U().A(yv2Var.c);
            if (A != null && (A instanceof sv1)) {
                ud4 c2 = c((sv1) A);
                we4 d2 = c2.d(yv2Var.b);
                if (d2 == null) {
                    m62.c("map", "remove map with id " + yv2Var.b + " not exist");
                    return false;
                }
                d2.F();
                pe4.b(context, d2, yv2Var, c2, true);
                m62.i("map", "map update end");
                if (z52.a(yv2Var) == null) {
                    f62.a("map", "update with a null map component");
                }
                d52 update = d2.update((we4) yv2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    m62.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            m62.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
