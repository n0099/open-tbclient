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
public class mj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947974578, "Lcom/baidu/tieba/mj4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947974578, "Lcom/baidu/tieba/mj4;");
        }
    }

    public mj4() {
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

    public static boolean b(in4 in4Var, xj4 xj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, in4Var, xj4Var)) == null) {
            if (xj4Var == null) {
                return true;
            }
            if (in4Var == null) {
                xj4Var.C(new wk4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable mn4<JSONArray> mn4Var, @Nullable mn4<JSONObject> mn4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, mn4Var, mn4Var2)) == null) {
            return pn4.a(mn4Var, mn4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(jn4 jn4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, jn4Var, xj4Var) == null) {
            synchronized (mj4.class) {
                m(jn4Var, xj4Var, null);
            }
        }
    }

    public static synchronized void c(en4 en4Var, xj4 xj4Var) {
        ll4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, en4Var, xj4Var) == null) {
            synchronized (mj4.class) {
                if (b(en4Var, xj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(en4Var.g())) {
                    xj4Var.C(new wk4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = gl4.i(en4Var);
                if (xj4Var.B() != null) {
                    i.putAll(xj4Var.B());
                }
                xj4Var.D();
                if (en4Var.n() == 1 && en4Var.h() == 2101) {
                    M = nj4.b().n();
                } else {
                    M = nj4.b().M();
                }
                M.z(kl4.e(), i, xj4Var.t(), new rm4(en4Var.g(), xj4Var, en4Var));
            }
        }
    }

    public static synchronized void d(bn4 bn4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bn4Var, xj4Var) == null) {
            synchronized (mj4.class) {
                if (b(bn4Var, xj4Var)) {
                    return;
                }
                if (bn4Var.f() != null && !bn4Var.f().isEmpty()) {
                    HashMap<String, String> f = gl4.f(bn4Var);
                    if (xj4Var.B() != null && f != null) {
                        f.putAll(xj4Var.B());
                    }
                    JSONObject d = gl4.d(bn4Var);
                    if (d == null) {
                        xj4Var.C(new wk4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, xj4Var.y());
                    xj4Var.D();
                    nj4.b().M().b(kl4.d(), f, xj4Var.t(), d, new pm4(xj4Var, bn4Var));
                    return;
                }
                xj4Var.C(new wk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(hn4 hn4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, hn4Var, xj4Var) == null) {
            synchronized (mj4.class) {
                if (b(hn4Var, xj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(hn4Var.f())) {
                    xj4Var.C(new wk4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(hn4Var.k())) {
                    xj4Var.C(new wk4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = gl4.k(hn4Var);
                    if (xj4Var.B() != null) {
                        k.putAll(xj4Var.B());
                    }
                    xj4Var.D();
                    nj4.b().M().z(kl4.e(), k, xj4Var.t(), new tm4(hn4Var.f(), xj4Var, hn4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable rj4 rj4Var) {
        lj4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, rj4Var) != null) || (b = nj4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ro4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(kl4.c(), hashMap, null, jSONObject, new sj4(rj4Var));
    }

    public static synchronized void f(dn4 dn4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, dn4Var, xj4Var) == null) {
            synchronized (mj4.class) {
                if (b(dn4Var, xj4Var)) {
                    return;
                }
                if (dn4Var.f() != null && !dn4Var.f().isEmpty()) {
                    HashMap<String, String> f = gl4.f(dn4Var);
                    if (xj4Var.B() != null && f != null) {
                        f.putAll(xj4Var.B());
                    }
                    JSONObject e = gl4.e(dn4Var);
                    if (e == null) {
                        xj4Var.C(new wk4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(nj4.b())) {
                        ro4.e().f();
                    }
                    a(e, xj4Var.y());
                    xj4Var.D();
                    nj4.b().M().b(kl4.d(), f, xj4Var.t(), e, new qm4(xj4Var, dn4Var));
                    return;
                }
                xj4Var.C(new wk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(fn4 fn4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, fn4Var, xj4Var) == null) {
            synchronized (mj4.class) {
                if (b(fn4Var, xj4Var)) {
                    return;
                }
                HashMap<String, String> j = gl4.j(fn4Var);
                if (xj4Var.B() != null) {
                    j.putAll(xj4Var.B());
                }
                xj4Var.D();
                nj4.b().M().z(kl4.f(), j, xj4Var.t(), new sm4(xj4Var, fn4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (mj4.class) {
                c = cm4.b().c(str);
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
            synchronized (mj4.class) {
                d = cm4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(jn4 jn4Var, xj4 xj4Var, xj4 xj4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, jn4Var, xj4Var, xj4Var2) == null) {
            synchronized (mj4.class) {
                n(jn4Var, xj4Var, xj4Var2, null);
            }
        }
    }

    public static synchronized void n(jn4 jn4Var, xj4 xj4Var, xj4 xj4Var2, @Nullable zo4 zo4Var) {
        mn4<JSONArray> g;
        xj4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, jn4Var, xj4Var, xj4Var2, zo4Var) == null) {
            synchronized (mj4.class) {
                if (b(jn4Var, xj4Var)) {
                    return;
                }
                if (PMSConstants.a(nj4.b())) {
                    ro4.e().f();
                }
                if (zo4Var == null) {
                    g = null;
                } else {
                    g = zo4Var.g();
                }
                if (zo4Var == null) {
                    callback = null;
                } else {
                    callback = zo4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (xj4Var.B() != null) {
                    hashMap.putAll(xj4Var.B());
                }
                xj4Var.D();
                nj4.b().M().b(kl4.g(), hashMap, xj4Var.t(), i(g, null), new um4(xj4Var, jn4Var, xj4Var2, callback));
            }
        }
    }

    public static synchronized void o(zo4 zo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, zo4Var) == null) {
            synchronized (mj4.class) {
                if (zo4Var == null) {
                    return;
                }
                xj4 callback = zo4Var.getCallback();
                if (callback == null) {
                    return;
                }
                in4 request = zo4Var.getRequest();
                if (request == null) {
                    callback.C(new wk4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                nj4.b().M().b(kl4.g(), B, callback.t(), i(zo4Var.g(), null), new um4(callback, request, null, callback));
            }
        }
    }
}
