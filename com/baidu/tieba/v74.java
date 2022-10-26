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
public class v74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile v74 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193686, "Lcom/baidu/tieba/v74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193686, "Lcom/baidu/tieba/v74;");
                return;
            }
        }
        b = wj1.a;
        c = v74.class.getSimpleName();
    }

    public v74() {
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
        t74.a();
        this.a = new HashMap();
    }

    public static v74 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (v74.class) {
                    if (d == null) {
                        d = new v74();
                    }
                }
            }
            return d;
        }
        return (v74) invokeV.objValue;
    }

    public static void d(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, sp1Var) == null) {
            synchronized (v74.class) {
                if (d != null) {
                    d.c(sp1Var).h();
                }
            }
        }
    }

    public static void e(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sp1Var) == null) {
            synchronized (v74.class) {
                if (d != null) {
                    d.f(sp1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, sp1Var) == null) {
            synchronized (v74.class) {
                if (d != null) {
                    d.c(sp1Var).k();
                }
            }
        }
    }

    public synchronized u74 c(sp1 sp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sp1Var)) == null) {
            synchronized (this) {
                if (sp1Var == null) {
                    return null;
                }
                u74 u74Var = (u74) this.a.get(sp1Var);
                if (u74Var == null) {
                    u74Var = new u74();
                    this.a.put(sp1Var, u74Var);
                }
                return u74Var;
            }
        }
        return (u74) invokeL.objValue;
    }

    public final synchronized void f(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sp1Var) == null) {
            synchronized (this) {
                if (sp1Var == null) {
                    return;
                }
                u74 u74Var = (u74) this.a.remove(sp1Var);
                if (u74Var != null) {
                    u74Var.i();
                }
            }
        }
    }

    public boolean a(Context context, yp2 yp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, yp2Var)) == null) {
            m02.i("map", "map create start");
            if (gh3.m(yp2Var.c) != null && yp2Var.isValid()) {
                up1 A = zo2.U().A(yp2Var.c);
                if (!(A instanceof sp1)) {
                    m02.c("map", "WebViewManager is null");
                    return false;
                }
                u74 c2 = c((sp1) A);
                if (c2.d(yp2Var.b) != null) {
                    m02.c("map", "map with id " + yp2Var.b + " exist");
                    return false;
                }
                w84 K = w84.K(context, yp2Var);
                if (K == null) {
                    m02.c("map", "map with id " + yp2Var.b + " model is invalid");
                    return false;
                }
                dz1 insert = K.insert();
                if (!insert.a()) {
                    m02.c("map", "map with id " + yp2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    m02.i("map", "map with id " + yp2Var.b + " init start");
                    p84.a(context, K, yp2Var, c2);
                    m02.i("map", "map with id " + yp2Var.b + " init end");
                    m02.i("map", "map create end");
                    return true;
                }
            }
            m02.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(yp2 yp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yp2Var)) == null) {
            m02.i("map", "map remove start");
            if (gh3.m(yp2Var.c) == null) {
                m02.c("map", "webView is null or mapModel is null");
                return false;
            }
            up1 A = zo2.U().A(yp2Var.c);
            if (!(A instanceof sp1)) {
                m02.c("map", "WebViewManager is null");
                return false;
            }
            u74 c2 = c((sp1) A);
            w84 d2 = c2.d(yp2Var.b);
            if (d2 == null) {
                m02.c("map", "remove map with id " + yp2Var.b + " not exist");
                return false;
            } else if (!c2.j(yp2Var.b)) {
                return false;
            } else {
                m02.i("map", "map remove end");
                if (zz1.a(yp2Var) == null) {
                    f02.a("map", "remove with a null map component");
                }
                dz1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    m02.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, yp2 yp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, yp2Var)) == null) {
            m02.i("map", "map update start");
            if (gh3.m(yp2Var.c) == null) {
                m02.c("map", "webView is null or mapModel is null");
                return false;
            }
            up1 A = zo2.U().A(yp2Var.c);
            if (A != null && (A instanceof sp1)) {
                u74 c2 = c((sp1) A);
                w84 d2 = c2.d(yp2Var.b);
                if (d2 == null) {
                    m02.c("map", "remove map with id " + yp2Var.b + " not exist");
                    return false;
                }
                d2.F();
                p84.b(context, d2, yp2Var, c2, true);
                m02.i("map", "map update end");
                if (zz1.a(yp2Var) == null) {
                    f02.a("map", "update with a null map component");
                }
                dz1 update = d2.update((cz1) yp2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    m02.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            m02.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
