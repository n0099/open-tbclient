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
public class n84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile n84 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<kq1, m84> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947956319, "Lcom/baidu/tieba/n84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947956319, "Lcom/baidu/tieba/n84;");
                return;
            }
        }
        b = ok1.a;
        c = n84.class.getSimpleName();
    }

    public n84() {
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
        l84.a();
        this.a = new HashMap();
    }

    public static n84 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (n84.class) {
                    if (d == null) {
                        d = new n84();
                    }
                }
            }
            return d;
        }
        return (n84) invokeV.objValue;
    }

    public static void d(kq1 kq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, kq1Var) == null) {
            synchronized (n84.class) {
                if (d != null) {
                    d.c(kq1Var).h();
                }
            }
        }
    }

    public static void e(kq1 kq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kq1Var) == null) {
            synchronized (n84.class) {
                if (d != null) {
                    d.f(kq1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(kq1 kq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, kq1Var) == null) {
            synchronized (n84.class) {
                if (d != null) {
                    d.c(kq1Var).k();
                }
            }
        }
    }

    public synchronized m84 c(kq1 kq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kq1Var)) == null) {
            synchronized (this) {
                if (kq1Var == null) {
                    return null;
                }
                m84 m84Var = this.a.get(kq1Var);
                if (m84Var == null) {
                    m84Var = new m84();
                    this.a.put(kq1Var, m84Var);
                }
                return m84Var;
            }
        }
        return (m84) invokeL.objValue;
    }

    public final synchronized void f(kq1 kq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kq1Var) == null) {
            synchronized (this) {
                if (kq1Var == null) {
                    return;
                }
                m84 remove = this.a.remove(kq1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, qq2 qq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, qq2Var)) == null) {
            e12.i("map", "map create start");
            if (yh3.m(qq2Var.c) != null && qq2Var.isValid()) {
                mq1 A = rp2.U().A(qq2Var.c);
                if (!(A instanceof kq1)) {
                    e12.c("map", "WebViewManager is null");
                    return false;
                }
                m84 c2 = c((kq1) A);
                if (c2.d(qq2Var.b) != null) {
                    e12.c("map", "map with id " + qq2Var.b + " exist");
                    return false;
                }
                o94 K = o94.K(context, qq2Var);
                if (K == null) {
                    e12.c("map", "map with id " + qq2Var.b + " model is invalid");
                    return false;
                }
                vz1 insert = K.insert();
                if (!insert.a()) {
                    e12.c("map", "map with id " + qq2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    e12.i("map", "map with id " + qq2Var.b + " init start");
                    h94.a(context, K, qq2Var, c2);
                    e12.i("map", "map with id " + qq2Var.b + " init end");
                    e12.i("map", "map create end");
                    return true;
                }
            }
            e12.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(qq2 qq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qq2Var)) == null) {
            e12.i("map", "map remove start");
            if (yh3.m(qq2Var.c) == null) {
                e12.c("map", "webView is null or mapModel is null");
                return false;
            }
            mq1 A = rp2.U().A(qq2Var.c);
            if (!(A instanceof kq1)) {
                e12.c("map", "WebViewManager is null");
                return false;
            }
            m84 c2 = c((kq1) A);
            o94 d2 = c2.d(qq2Var.b);
            if (d2 == null) {
                e12.c("map", "remove map with id " + qq2Var.b + " not exist");
                return false;
            } else if (!c2.j(qq2Var.b)) {
                return false;
            } else {
                e12.i("map", "map remove end");
                if (r02.a(qq2Var) == null) {
                    x02.a("map", "remove with a null map component");
                }
                vz1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    e12.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, qq2 qq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, qq2Var)) == null) {
            e12.i("map", "map update start");
            if (yh3.m(qq2Var.c) == null) {
                e12.c("map", "webView is null or mapModel is null");
                return false;
            }
            mq1 A = rp2.U().A(qq2Var.c);
            if (A != null && (A instanceof kq1)) {
                m84 c2 = c((kq1) A);
                o94 d2 = c2.d(qq2Var.b);
                if (d2 == null) {
                    e12.c("map", "remove map with id " + qq2Var.b + " not exist");
                    return false;
                }
                d2.F();
                h94.b(context, d2, qq2Var, c2, true);
                e12.i("map", "map update end");
                if (r02.a(qq2Var) == null) {
                    x02.a("map", "update with a null map component");
                }
                vz1 update = d2.update((o94) qq2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    e12.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            e12.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
