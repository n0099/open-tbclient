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
public class mf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile mf4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<jx1, lf4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947970734, "Lcom/baidu/tieba/mf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947970734, "Lcom/baidu/tieba/mf4;");
                return;
            }
        }
        b = nr1.a;
        c = mf4.class.getSimpleName();
    }

    public mf4() {
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
        kf4.a();
        this.a = new HashMap();
    }

    public static mf4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (mf4.class) {
                    if (d == null) {
                        d = new mf4();
                    }
                }
            }
            return d;
        }
        return (mf4) invokeV.objValue;
    }

    public static void d(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jx1Var) == null) {
            synchronized (mf4.class) {
                if (d != null) {
                    d.c(jx1Var).h();
                }
            }
        }
    }

    public static void e(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jx1Var) == null) {
            synchronized (mf4.class) {
                if (d != null) {
                    d.f(jx1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, jx1Var) == null) {
            synchronized (mf4.class) {
                if (d != null) {
                    d.c(jx1Var).k();
                }
            }
        }
    }

    public synchronized lf4 c(jx1 jx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jx1Var)) == null) {
            synchronized (this) {
                if (jx1Var == null) {
                    return null;
                }
                lf4 lf4Var = this.a.get(jx1Var);
                if (lf4Var == null) {
                    lf4Var = new lf4();
                    this.a.put(jx1Var, lf4Var);
                }
                return lf4Var;
            }
        }
        return (lf4) invokeL.objValue;
    }

    public final synchronized void f(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jx1Var) == null) {
            synchronized (this) {
                if (jx1Var == null) {
                    return;
                }
                lf4 remove = this.a.remove(jx1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, px2 px2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, px2Var)) == null) {
            d82.i("map", "map create start");
            if (xo3.m(px2Var.c) != null && px2Var.isValid()) {
                lx1 A = qw2.T().A(px2Var.c);
                if (!(A instanceof jx1)) {
                    d82.c("map", "WebViewManager is null");
                    return false;
                }
                lf4 c2 = c((jx1) A);
                if (c2.d(px2Var.b) != null) {
                    d82.c("map", "map with id " + px2Var.b + " exist");
                    return false;
                }
                ng4 K = ng4.K(context, px2Var);
                if (K == null) {
                    d82.c("map", "map with id " + px2Var.b + " model is invalid");
                    return false;
                }
                u62 insert = K.insert();
                if (!insert.a()) {
                    d82.c("map", "map with id " + px2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    d82.i("map", "map with id " + px2Var.b + " init start");
                    gg4.a(context, K, px2Var, c2);
                    d82.i("map", "map with id " + px2Var.b + " init end");
                    d82.i("map", "map create end");
                    return true;
                }
            }
            d82.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(px2 px2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, px2Var)) == null) {
            d82.i("map", "map remove start");
            if (xo3.m(px2Var.c) == null) {
                d82.c("map", "webView is null or mapModel is null");
                return false;
            }
            lx1 A = qw2.T().A(px2Var.c);
            if (!(A instanceof jx1)) {
                d82.c("map", "WebViewManager is null");
                return false;
            }
            lf4 c2 = c((jx1) A);
            ng4 d2 = c2.d(px2Var.b);
            if (d2 == null) {
                d82.c("map", "remove map with id " + px2Var.b + " not exist");
                return false;
            } else if (!c2.j(px2Var.b)) {
                return false;
            } else {
                d82.i("map", "map remove end");
                if (q72.a(px2Var) == null) {
                    w72.a("map", "remove with a null map component");
                }
                u62 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    d82.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, px2 px2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, px2Var)) == null) {
            d82.i("map", "map update start");
            if (xo3.m(px2Var.c) == null) {
                d82.c("map", "webView is null or mapModel is null");
                return false;
            }
            lx1 A = qw2.T().A(px2Var.c);
            if (A != null && (A instanceof jx1)) {
                lf4 c2 = c((jx1) A);
                ng4 d2 = c2.d(px2Var.b);
                if (d2 == null) {
                    d82.c("map", "remove map with id " + px2Var.b + " not exist");
                    return false;
                }
                d2.F();
                gg4.b(context, d2, px2Var, c2, true);
                d82.i("map", "map update end");
                if (q72.a(px2Var) == null) {
                    w72.a("map", "update with a null map component");
                }
                u62 update = d2.update((ng4) px2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    d82.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            d82.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
