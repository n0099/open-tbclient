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
public class pd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile pd4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<mv1, od4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948058185, "Lcom/baidu/tieba/pd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948058185, "Lcom/baidu/tieba/pd4;");
                return;
            }
        }
        b = qp1.a;
        c = pd4.class.getSimpleName();
    }

    public pd4() {
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
        nd4.a();
        this.a = new HashMap();
    }

    public static pd4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (pd4.class) {
                    if (d == null) {
                        d = new pd4();
                    }
                }
            }
            return d;
        }
        return (pd4) invokeV.objValue;
    }

    public static void d(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mv1Var) == null) {
            synchronized (pd4.class) {
                if (d != null) {
                    d.c(mv1Var).h();
                }
            }
        }
    }

    public static void e(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mv1Var) == null) {
            synchronized (pd4.class) {
                if (d != null) {
                    d.f(mv1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, mv1Var) == null) {
            synchronized (pd4.class) {
                if (d != null) {
                    d.c(mv1Var).k();
                }
            }
        }
    }

    public synchronized od4 c(mv1 mv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mv1Var)) == null) {
            synchronized (this) {
                if (mv1Var == null) {
                    return null;
                }
                od4 od4Var = this.a.get(mv1Var);
                if (od4Var == null) {
                    od4Var = new od4();
                    this.a.put(mv1Var, od4Var);
                }
                return od4Var;
            }
        }
        return (od4) invokeL.objValue;
    }

    public final synchronized void f(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mv1Var) == null) {
            synchronized (this) {
                if (mv1Var == null) {
                    return;
                }
                od4 remove = this.a.remove(mv1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, sv2 sv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, sv2Var)) == null) {
            g62.i("map", "map create start");
            if (an3.m(sv2Var.c) != null && sv2Var.isValid()) {
                ov1 A = tu2.U().A(sv2Var.c);
                if (!(A instanceof mv1)) {
                    g62.c("map", "WebViewManager is null");
                    return false;
                }
                od4 c2 = c((mv1) A);
                if (c2.d(sv2Var.b) != null) {
                    g62.c("map", "map with id " + sv2Var.b + " exist");
                    return false;
                }
                qe4 K = qe4.K(context, sv2Var);
                if (K == null) {
                    g62.c("map", "map with id " + sv2Var.b + " model is invalid");
                    return false;
                }
                x42 insert = K.insert();
                if (!insert.a()) {
                    g62.c("map", "map with id " + sv2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    g62.i("map", "map with id " + sv2Var.b + " init start");
                    je4.a(context, K, sv2Var, c2);
                    g62.i("map", "map with id " + sv2Var.b + " init end");
                    g62.i("map", "map create end");
                    return true;
                }
            }
            g62.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(sv2 sv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sv2Var)) == null) {
            g62.i("map", "map remove start");
            if (an3.m(sv2Var.c) == null) {
                g62.c("map", "webView is null or mapModel is null");
                return false;
            }
            ov1 A = tu2.U().A(sv2Var.c);
            if (!(A instanceof mv1)) {
                g62.c("map", "WebViewManager is null");
                return false;
            }
            od4 c2 = c((mv1) A);
            qe4 d2 = c2.d(sv2Var.b);
            if (d2 == null) {
                g62.c("map", "remove map with id " + sv2Var.b + " not exist");
                return false;
            } else if (!c2.j(sv2Var.b)) {
                return false;
            } else {
                g62.i("map", "map remove end");
                if (t52.a(sv2Var) == null) {
                    z52.a("map", "remove with a null map component");
                }
                x42 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    g62.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, sv2 sv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, sv2Var)) == null) {
            g62.i("map", "map update start");
            if (an3.m(sv2Var.c) == null) {
                g62.c("map", "webView is null or mapModel is null");
                return false;
            }
            ov1 A = tu2.U().A(sv2Var.c);
            if (A != null && (A instanceof mv1)) {
                od4 c2 = c((mv1) A);
                qe4 d2 = c2.d(sv2Var.b);
                if (d2 == null) {
                    g62.c("map", "remove map with id " + sv2Var.b + " not exist");
                    return false;
                }
                d2.F();
                je4.b(context, d2, sv2Var, c2, true);
                g62.i("map", "map update end");
                if (t52.a(sv2Var) == null) {
                    z52.a("map", "update with a null map component");
                }
                x42 update = d2.update((qe4) sv2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    g62.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            g62.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
