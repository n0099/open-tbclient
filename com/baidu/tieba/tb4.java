package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class tb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948175427, "Lcom/baidu/tieba/tb4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948175427, "Lcom/baidu/tieba/tb4;");
        }
    }

    public tb4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(@NonNull JSONObject jSONObject, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, jSONObject, map) != null) || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(pf4 pf4Var, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, pf4Var, ec4Var)) == null) {
            if (ec4Var == null) {
                return true;
            }
            if (pf4Var == null) {
                ec4Var.C(new dd4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable tf4<JSONArray> tf4Var, @Nullable tf4<JSONObject> tf4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, tf4Var, tf4Var2)) == null) {
            return wf4.a(tf4Var, tf4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(qf4 qf4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, qf4Var, ec4Var) == null) {
            synchronized (tb4.class) {
                m(qf4Var, ec4Var, null);
            }
        }
    }

    public static synchronized void c(lf4 lf4Var, ec4 ec4Var) {
        sd4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lf4Var, ec4Var) == null) {
            synchronized (tb4.class) {
                if (b(lf4Var, ec4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(lf4Var.g())) {
                    ec4Var.C(new dd4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = nd4.i(lf4Var);
                if (ec4Var.B() != null) {
                    i.putAll(ec4Var.B());
                }
                ec4Var.D();
                if (lf4Var.n() == 1 && lf4Var.h() == 2101) {
                    M = ub4.b().n();
                } else {
                    M = ub4.b().M();
                }
                M.z(rd4.e(), i, ec4Var.t(), new ye4(lf4Var.g(), ec4Var, lf4Var));
            }
        }
    }

    public static synchronized void d(if4 if4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, if4Var, ec4Var) == null) {
            synchronized (tb4.class) {
                if (b(if4Var, ec4Var)) {
                    return;
                }
                if (if4Var.f() != null && !if4Var.f().isEmpty()) {
                    HashMap<String, String> f = nd4.f(if4Var);
                    if (ec4Var.B() != null && f != null) {
                        f.putAll(ec4Var.B());
                    }
                    JSONObject d = nd4.d(if4Var);
                    if (d == null) {
                        ec4Var.C(new dd4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, ec4Var.y());
                    ec4Var.D();
                    ub4.b().M().b(rd4.d(), f, ec4Var.t(), d, new we4(ec4Var, if4Var));
                    return;
                }
                ec4Var.C(new dd4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(of4 of4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, of4Var, ec4Var) == null) {
            synchronized (tb4.class) {
                if (b(of4Var, ec4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(of4Var.f())) {
                    ec4Var.C(new dd4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(of4Var.k())) {
                    ec4Var.C(new dd4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = nd4.k(of4Var);
                    if (ec4Var.B() != null) {
                        k.putAll(ec4Var.B());
                    }
                    ec4Var.D();
                    ub4.b().M().z(rd4.e(), k, ec4Var.t(), new af4(of4Var.f(), ec4Var, of4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable yb4 yb4Var) {
        sb4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, yb4Var) != null) || (b = ub4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            yg4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(rd4.c(), hashMap, null, jSONObject, new zb4(yb4Var));
    }

    public static synchronized void f(kf4 kf4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, kf4Var, ec4Var) == null) {
            synchronized (tb4.class) {
                if (b(kf4Var, ec4Var)) {
                    return;
                }
                if (kf4Var.f() != null && !kf4Var.f().isEmpty()) {
                    HashMap<String, String> f = nd4.f(kf4Var);
                    if (ec4Var.B() != null && f != null) {
                        f.putAll(ec4Var.B());
                    }
                    JSONObject e = nd4.e(kf4Var);
                    if (e == null) {
                        ec4Var.C(new dd4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(ub4.b())) {
                        yg4.e().f();
                    }
                    a(e, ec4Var.y());
                    ec4Var.D();
                    ub4.b().M().b(rd4.d(), f, ec4Var.t(), e, new xe4(ec4Var, kf4Var));
                    return;
                }
                ec4Var.C(new dd4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(mf4 mf4Var, ec4 ec4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, mf4Var, ec4Var) == null) {
            synchronized (tb4.class) {
                if (b(mf4Var, ec4Var)) {
                    return;
                }
                HashMap<String, String> j = nd4.j(mf4Var);
                if (ec4Var.B() != null) {
                    j.putAll(ec4Var.B());
                }
                ec4Var.D();
                ub4.b().M().z(rd4.f(), j, ec4Var.t(), new ze4(ec4Var, mf4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (tb4.class) {
                c = je4.b().c(str);
            }
            return c;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean k(String str) {
        InterceptResult invokeL;
        boolean d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (tb4.class) {
                d = je4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(qf4 qf4Var, ec4 ec4Var, ec4 ec4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, qf4Var, ec4Var, ec4Var2) == null) {
            synchronized (tb4.class) {
                n(qf4Var, ec4Var, ec4Var2, null);
            }
        }
    }

    public static synchronized void n(qf4 qf4Var, ec4 ec4Var, ec4 ec4Var2, @Nullable gh4 gh4Var) {
        tf4<JSONArray> g;
        ec4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, qf4Var, ec4Var, ec4Var2, gh4Var) == null) {
            synchronized (tb4.class) {
                if (b(qf4Var, ec4Var)) {
                    return;
                }
                if (PMSConstants.a(ub4.b())) {
                    yg4.e().f();
                }
                if (gh4Var == null) {
                    g = null;
                } else {
                    g = gh4Var.g();
                }
                if (gh4Var == null) {
                    callback = null;
                } else {
                    callback = gh4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (ec4Var.B() != null) {
                    hashMap.putAll(ec4Var.B());
                }
                ec4Var.D();
                ub4.b().M().b(rd4.g(), hashMap, ec4Var.t(), i(g, null), new bf4(ec4Var, qf4Var, ec4Var2, callback));
            }
        }
    }

    public static synchronized void o(gh4 gh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, gh4Var) == null) {
            synchronized (tb4.class) {
                if (gh4Var == null) {
                    return;
                }
                ec4 callback = gh4Var.getCallback();
                if (callback == null) {
                    return;
                }
                pf4 request = gh4Var.getRequest();
                if (request == null) {
                    callback.C(new dd4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                ub4.b().M().b(rd4.g(), B, callback.t(), i(gh4Var.g(), null), new bf4(callback, request, null, callback));
            }
        }
    }
}
