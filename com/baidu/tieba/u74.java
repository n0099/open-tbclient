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
public class u74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile u74 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<rp1, t74> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163895, "Lcom/baidu/tieba/u74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163895, "Lcom/baidu/tieba/u74;");
                return;
            }
        }
        b = vj1.a;
        c = u74.class.getSimpleName();
    }

    public u74() {
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
        s74.a();
        this.a = new HashMap();
    }

    public static u74 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (u74.class) {
                    if (d == null) {
                        d = new u74();
                    }
                }
            }
            return d;
        }
        return (u74) invokeV.objValue;
    }

    public static void d(rp1 rp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rp1Var) == null) {
            synchronized (u74.class) {
                if (d != null) {
                    d.c(rp1Var).h();
                }
            }
        }
    }

    public static void e(rp1 rp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rp1Var) == null) {
            synchronized (u74.class) {
                if (d != null) {
                    d.f(rp1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(rp1 rp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, rp1Var) == null) {
            synchronized (u74.class) {
                if (d != null) {
                    d.c(rp1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, xp2 xp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, xp2Var)) == null) {
            l02.i("map", "map create start");
            if (fh3.m(xp2Var.c) != null && xp2Var.isValid()) {
                tp1 A = yo2.U().A(xp2Var.c);
                if (!(A instanceof rp1)) {
                    l02.c("map", "WebViewManager is null");
                    return false;
                }
                t74 c2 = c((rp1) A);
                if (c2.d(xp2Var.b) != null) {
                    l02.c("map", "map with id " + xp2Var.b + " exist");
                    return false;
                }
                v84 K = v84.K(context, xp2Var);
                if (K == null) {
                    l02.c("map", "map with id " + xp2Var.b + " model is invalid");
                    return false;
                }
                cz1 insert = K.insert();
                if (!insert.a()) {
                    l02.c("map", "map with id " + xp2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    l02.i("map", "map with id " + xp2Var.b + " init start");
                    o84.a(context, K, xp2Var, c2);
                    l02.i("map", "map with id " + xp2Var.b + " init end");
                    l02.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            l02.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized t74 c(rp1 rp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rp1Var)) == null) {
            synchronized (this) {
                if (rp1Var == null) {
                    return null;
                }
                t74 t74Var = this.a.get(rp1Var);
                if (t74Var == null) {
                    t74Var = new t74();
                    this.a.put(rp1Var, t74Var);
                }
                return t74Var;
            }
        }
        return (t74) invokeL.objValue;
    }

    public final synchronized void f(rp1 rp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rp1Var) == null) {
            synchronized (this) {
                if (rp1Var == null) {
                    return;
                }
                t74 remove = this.a.remove(rp1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(xp2 xp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xp2Var)) == null) {
            l02.i("map", "map remove start");
            if (fh3.m(xp2Var.c) == null) {
                l02.c("map", "webView is null or mapModel is null");
                return false;
            }
            tp1 A = yo2.U().A(xp2Var.c);
            if (!(A instanceof rp1)) {
                l02.c("map", "WebViewManager is null");
                return false;
            }
            t74 c2 = c((rp1) A);
            v84 d2 = c2.d(xp2Var.b);
            if (d2 == null) {
                l02.c("map", "remove map with id " + xp2Var.b + " not exist");
                return false;
            } else if (c2.j(xp2Var.b)) {
                l02.i("map", "map remove end");
                if (yz1.a(xp2Var) == null) {
                    e02.a("map", "remove with a null map component");
                }
                cz1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    l02.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, xp2 xp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, xp2Var)) == null) {
            l02.i("map", "map update start");
            if (fh3.m(xp2Var.c) == null) {
                l02.c("map", "webView is null or mapModel is null");
                return false;
            }
            tp1 A = yo2.U().A(xp2Var.c);
            if (A != null && (A instanceof rp1)) {
                t74 c2 = c((rp1) A);
                v84 d2 = c2.d(xp2Var.b);
                if (d2 == null) {
                    l02.c("map", "remove map with id " + xp2Var.b + " not exist");
                    return false;
                }
                d2.F();
                o84.b(context, d2, xp2Var, c2, true);
                l02.i("map", "map update end");
                if (yz1.a(xp2Var) == null) {
                    e02.a("map", "update with a null map component");
                }
                cz1 update = d2.update((v84) xp2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    l02.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            l02.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
