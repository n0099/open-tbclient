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
public class qf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile qf4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<nx1, pf4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948089898, "Lcom/baidu/tieba/qf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948089898, "Lcom/baidu/tieba/qf4;");
                return;
            }
        }
        b = rr1.a;
        c = qf4.class.getSimpleName();
    }

    public qf4() {
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
        of4.a();
        this.a = new HashMap();
    }

    public static qf4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (qf4.class) {
                    if (d == null) {
                        d = new qf4();
                    }
                }
            }
            return d;
        }
        return (qf4) invokeV.objValue;
    }

    public static void d(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nx1Var) == null) {
            synchronized (qf4.class) {
                if (d != null) {
                    d.c(nx1Var).h();
                }
            }
        }
    }

    public static void e(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nx1Var) == null) {
            synchronized (qf4.class) {
                if (d != null) {
                    d.f(nx1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, nx1Var) == null) {
            synchronized (qf4.class) {
                if (d != null) {
                    d.c(nx1Var).k();
                }
            }
        }
    }

    public synchronized pf4 c(nx1 nx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nx1Var)) == null) {
            synchronized (this) {
                if (nx1Var == null) {
                    return null;
                }
                pf4 pf4Var = this.a.get(nx1Var);
                if (pf4Var == null) {
                    pf4Var = new pf4();
                    this.a.put(nx1Var, pf4Var);
                }
                return pf4Var;
            }
        }
        return (pf4) invokeL.objValue;
    }

    public final synchronized void f(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nx1Var) == null) {
            synchronized (this) {
                if (nx1Var == null) {
                    return;
                }
                pf4 remove = this.a.remove(nx1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, tx2 tx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, tx2Var)) == null) {
            h82.i("map", "map create start");
            if (bp3.m(tx2Var.c) != null && tx2Var.isValid()) {
                px1 A = uw2.T().A(tx2Var.c);
                if (!(A instanceof nx1)) {
                    h82.c("map", "WebViewManager is null");
                    return false;
                }
                pf4 c2 = c((nx1) A);
                if (c2.d(tx2Var.b) != null) {
                    h82.c("map", "map with id " + tx2Var.b + " exist");
                    return false;
                }
                rg4 K = rg4.K(context, tx2Var);
                if (K == null) {
                    h82.c("map", "map with id " + tx2Var.b + " model is invalid");
                    return false;
                }
                y62 insert = K.insert();
                if (!insert.a()) {
                    h82.c("map", "map with id " + tx2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    h82.i("map", "map with id " + tx2Var.b + " init start");
                    kg4.a(context, K, tx2Var, c2);
                    h82.i("map", "map with id " + tx2Var.b + " init end");
                    h82.i("map", "map create end");
                    return true;
                }
            }
            h82.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(tx2 tx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tx2Var)) == null) {
            h82.i("map", "map remove start");
            if (bp3.m(tx2Var.c) == null) {
                h82.c("map", "webView is null or mapModel is null");
                return false;
            }
            px1 A = uw2.T().A(tx2Var.c);
            if (!(A instanceof nx1)) {
                h82.c("map", "WebViewManager is null");
                return false;
            }
            pf4 c2 = c((nx1) A);
            rg4 d2 = c2.d(tx2Var.b);
            if (d2 == null) {
                h82.c("map", "remove map with id " + tx2Var.b + " not exist");
                return false;
            } else if (!c2.j(tx2Var.b)) {
                return false;
            } else {
                h82.i("map", "map remove end");
                if (u72.a(tx2Var) == null) {
                    a82.a("map", "remove with a null map component");
                }
                y62 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    h82.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, tx2 tx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, tx2Var)) == null) {
            h82.i("map", "map update start");
            if (bp3.m(tx2Var.c) == null) {
                h82.c("map", "webView is null or mapModel is null");
                return false;
            }
            px1 A = uw2.T().A(tx2Var.c);
            if (A != null && (A instanceof nx1)) {
                pf4 c2 = c((nx1) A);
                rg4 d2 = c2.d(tx2Var.b);
                if (d2 == null) {
                    h82.c("map", "remove map with id " + tx2Var.b + " not exist");
                    return false;
                }
                d2.F();
                kg4.b(context, d2, tx2Var, c2, true);
                h82.i("map", "map update end");
                if (u72.a(tx2Var) == null) {
                    a82.a("map", "update with a null map component");
                }
                y62 update = d2.update((rg4) tx2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    h82.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            h82.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
