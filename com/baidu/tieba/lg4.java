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
public class lg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile lg4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<iy1, kg4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947941904, "Lcom/baidu/tieba/lg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947941904, "Lcom/baidu/tieba/lg4;");
                return;
            }
        }
        b = ms1.a;
        c = lg4.class.getSimpleName();
    }

    public lg4() {
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
        jg4.a();
        this.a = new HashMap();
    }

    public static lg4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (lg4.class) {
                    if (d == null) {
                        d = new lg4();
                    }
                }
            }
            return d;
        }
        return (lg4) invokeV.objValue;
    }

    public static void d(iy1 iy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iy1Var) == null) {
            synchronized (lg4.class) {
                if (d != null) {
                    d.c(iy1Var).h();
                }
            }
        }
    }

    public static void e(iy1 iy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iy1Var) == null) {
            synchronized (lg4.class) {
                if (d != null) {
                    d.f(iy1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(iy1 iy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, iy1Var) == null) {
            synchronized (lg4.class) {
                if (d != null) {
                    d.c(iy1Var).k();
                }
            }
        }
    }

    public synchronized kg4 c(iy1 iy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iy1Var)) == null) {
            synchronized (this) {
                if (iy1Var == null) {
                    return null;
                }
                kg4 kg4Var = this.a.get(iy1Var);
                if (kg4Var == null) {
                    kg4Var = new kg4();
                    this.a.put(iy1Var, kg4Var);
                }
                return kg4Var;
            }
        }
        return (kg4) invokeL.objValue;
    }

    public final synchronized void f(iy1 iy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iy1Var) == null) {
            synchronized (this) {
                if (iy1Var == null) {
                    return;
                }
                kg4 remove = this.a.remove(iy1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, oy2 oy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, oy2Var)) == null) {
            c92.i("map", "map create start");
            if (wp3.m(oy2Var.c) != null && oy2Var.isValid()) {
                ky1 A = px2.T().A(oy2Var.c);
                if (!(A instanceof iy1)) {
                    c92.c("map", "WebViewManager is null");
                    return false;
                }
                kg4 c2 = c((iy1) A);
                if (c2.d(oy2Var.b) != null) {
                    c92.c("map", "map with id " + oy2Var.b + " exist");
                    return false;
                }
                mh4 K = mh4.K(context, oy2Var);
                if (K == null) {
                    c92.c("map", "map with id " + oy2Var.b + " model is invalid");
                    return false;
                }
                t72 insert = K.insert();
                if (!insert.a()) {
                    c92.c("map", "map with id " + oy2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    c92.i("map", "map with id " + oy2Var.b + " init start");
                    fh4.a(context, K, oy2Var, c2);
                    c92.i("map", "map with id " + oy2Var.b + " init end");
                    c92.i("map", "map create end");
                    return true;
                }
            }
            c92.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(oy2 oy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, oy2Var)) == null) {
            c92.i("map", "map remove start");
            if (wp3.m(oy2Var.c) == null) {
                c92.c("map", "webView is null or mapModel is null");
                return false;
            }
            ky1 A = px2.T().A(oy2Var.c);
            if (!(A instanceof iy1)) {
                c92.c("map", "WebViewManager is null");
                return false;
            }
            kg4 c2 = c((iy1) A);
            mh4 d2 = c2.d(oy2Var.b);
            if (d2 == null) {
                c92.c("map", "remove map with id " + oy2Var.b + " not exist");
                return false;
            } else if (!c2.j(oy2Var.b)) {
                return false;
            } else {
                c92.i("map", "map remove end");
                if (p82.a(oy2Var) == null) {
                    v82.a("map", "remove with a null map component");
                }
                t72 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    c92.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, oy2 oy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, oy2Var)) == null) {
            c92.i("map", "map update start");
            if (wp3.m(oy2Var.c) == null) {
                c92.c("map", "webView is null or mapModel is null");
                return false;
            }
            ky1 A = px2.T().A(oy2Var.c);
            if (A != null && (A instanceof iy1)) {
                kg4 c2 = c((iy1) A);
                mh4 d2 = c2.d(oy2Var.b);
                if (d2 == null) {
                    c92.c("map", "remove map with id " + oy2Var.b + " not exist");
                    return false;
                }
                d2.F();
                fh4.b(context, d2, oy2Var, c2, true);
                c92.i("map", "map update end");
                if (p82.a(oy2Var) == null) {
                    v82.a("map", "update with a null map component");
                }
                t72 update = d2.update((mh4) oy2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    c92.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            c92.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
