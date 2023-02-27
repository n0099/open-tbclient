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
public class wg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948269605, "Lcom/baidu/tieba/wg4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948269605, "Lcom/baidu/tieba/wg4;");
        }
    }

    public wg4() {
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

    public static boolean b(sk4 sk4Var, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sk4Var, hh4Var)) == null) {
            if (hh4Var == null) {
                return true;
            }
            if (sk4Var == null) {
                hh4Var.C(new gi4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable wk4<JSONArray> wk4Var, @Nullable wk4<JSONObject> wk4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, wk4Var, wk4Var2)) == null) {
            return zk4.a(wk4Var, wk4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(tk4 tk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, tk4Var, hh4Var) == null) {
            synchronized (wg4.class) {
                m(tk4Var, hh4Var, null);
            }
        }
    }

    public static synchronized void c(ok4 ok4Var, hh4 hh4Var) {
        vi4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ok4Var, hh4Var) == null) {
            synchronized (wg4.class) {
                if (b(ok4Var, hh4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ok4Var.g())) {
                    hh4Var.C(new gi4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = qi4.i(ok4Var);
                if (hh4Var.B() != null) {
                    i.putAll(hh4Var.B());
                }
                hh4Var.D();
                if (ok4Var.n() == 1 && ok4Var.h() == 2101) {
                    M = xg4.b().n();
                } else {
                    M = xg4.b().M();
                }
                M.z(ui4.e(), i, hh4Var.t(), new bk4(ok4Var.g(), hh4Var, ok4Var));
            }
        }
    }

    public static synchronized void d(lk4 lk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, lk4Var, hh4Var) == null) {
            synchronized (wg4.class) {
                if (b(lk4Var, hh4Var)) {
                    return;
                }
                if (lk4Var.f() != null && !lk4Var.f().isEmpty()) {
                    HashMap<String, String> f = qi4.f(lk4Var);
                    if (hh4Var.B() != null && f != null) {
                        f.putAll(hh4Var.B());
                    }
                    JSONObject d = qi4.d(lk4Var);
                    if (d == null) {
                        hh4Var.C(new gi4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, hh4Var.y());
                    hh4Var.D();
                    xg4.b().M().b(ui4.d(), f, hh4Var.t(), d, new zj4(hh4Var, lk4Var));
                    return;
                }
                hh4Var.C(new gi4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(rk4 rk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, rk4Var, hh4Var) == null) {
            synchronized (wg4.class) {
                if (b(rk4Var, hh4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(rk4Var.f())) {
                    hh4Var.C(new gi4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(rk4Var.k())) {
                    hh4Var.C(new gi4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = qi4.k(rk4Var);
                    if (hh4Var.B() != null) {
                        k.putAll(hh4Var.B());
                    }
                    hh4Var.D();
                    xg4.b().M().z(ui4.e(), k, hh4Var.t(), new dk4(rk4Var.f(), hh4Var, rk4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable bh4 bh4Var) {
        vg4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, bh4Var) != null) || (b = xg4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            bm4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(ui4.c(), hashMap, null, jSONObject, new ch4(bh4Var));
    }

    public static synchronized void f(nk4 nk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, nk4Var, hh4Var) == null) {
            synchronized (wg4.class) {
                if (b(nk4Var, hh4Var)) {
                    return;
                }
                if (nk4Var.f() != null && !nk4Var.f().isEmpty()) {
                    HashMap<String, String> f = qi4.f(nk4Var);
                    if (hh4Var.B() != null && f != null) {
                        f.putAll(hh4Var.B());
                    }
                    JSONObject e = qi4.e(nk4Var);
                    if (e == null) {
                        hh4Var.C(new gi4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(xg4.b())) {
                        bm4.e().f();
                    }
                    a(e, hh4Var.y());
                    hh4Var.D();
                    xg4.b().M().b(ui4.d(), f, hh4Var.t(), e, new ak4(hh4Var, nk4Var));
                    return;
                }
                hh4Var.C(new gi4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(pk4 pk4Var, hh4 hh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, pk4Var, hh4Var) == null) {
            synchronized (wg4.class) {
                if (b(pk4Var, hh4Var)) {
                    return;
                }
                HashMap<String, String> j = qi4.j(pk4Var);
                if (hh4Var.B() != null) {
                    j.putAll(hh4Var.B());
                }
                hh4Var.D();
                xg4.b().M().z(ui4.f(), j, hh4Var.t(), new ck4(hh4Var, pk4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (wg4.class) {
                c = mj4.b().c(str);
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
            synchronized (wg4.class) {
                d = mj4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(tk4 tk4Var, hh4 hh4Var, hh4 hh4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, tk4Var, hh4Var, hh4Var2) == null) {
            synchronized (wg4.class) {
                n(tk4Var, hh4Var, hh4Var2, null);
            }
        }
    }

    public static synchronized void n(tk4 tk4Var, hh4 hh4Var, hh4 hh4Var2, @Nullable jm4 jm4Var) {
        wk4<JSONArray> g;
        hh4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, tk4Var, hh4Var, hh4Var2, jm4Var) == null) {
            synchronized (wg4.class) {
                if (b(tk4Var, hh4Var)) {
                    return;
                }
                if (PMSConstants.a(xg4.b())) {
                    bm4.e().f();
                }
                if (jm4Var == null) {
                    g = null;
                } else {
                    g = jm4Var.g();
                }
                if (jm4Var == null) {
                    callback = null;
                } else {
                    callback = jm4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (hh4Var.B() != null) {
                    hashMap.putAll(hh4Var.B());
                }
                hh4Var.D();
                xg4.b().M().b(ui4.g(), hashMap, hh4Var.t(), i(g, null), new ek4(hh4Var, tk4Var, hh4Var2, callback));
            }
        }
    }

    public static synchronized void o(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, jm4Var) == null) {
            synchronized (wg4.class) {
                if (jm4Var == null) {
                    return;
                }
                hh4 callback = jm4Var.getCallback();
                if (callback == null) {
                    return;
                }
                sk4 request = jm4Var.getRequest();
                if (request == null) {
                    callback.C(new gi4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                xg4.b().M().b(ui4.g(), B, callback.t(), i(jm4Var.g(), null), new ek4(callback, request, null, callback));
            }
        }
    }
}
