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
/* loaded from: classes5.dex */
public class pb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948056263, "Lcom/baidu/tieba/pb4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948056263, "Lcom/baidu/tieba/pb4;");
        }
    }

    public pb4() {
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

    public static boolean b(lf4 lf4Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, lf4Var, ac4Var)) == null) {
            if (ac4Var == null) {
                return true;
            }
            if (lf4Var == null) {
                ac4Var.C(new zc4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable pf4<JSONArray> pf4Var, @Nullable pf4<JSONObject> pf4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, pf4Var, pf4Var2)) == null) {
            return sf4.a(pf4Var, pf4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(mf4 mf4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, mf4Var, ac4Var) == null) {
            synchronized (pb4.class) {
                m(mf4Var, ac4Var, null);
            }
        }
    }

    public static synchronized void c(hf4 hf4Var, ac4 ac4Var) {
        od4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hf4Var, ac4Var) == null) {
            synchronized (pb4.class) {
                if (b(hf4Var, ac4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(hf4Var.g())) {
                    ac4Var.C(new zc4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = jd4.i(hf4Var);
                if (ac4Var.B() != null) {
                    i.putAll(ac4Var.B());
                }
                ac4Var.D();
                if (hf4Var.n() == 1 && hf4Var.h() == 2101) {
                    M = qb4.b().n();
                } else {
                    M = qb4.b().M();
                }
                M.z(nd4.e(), i, ac4Var.t(), new ue4(hf4Var.g(), ac4Var, hf4Var));
            }
        }
    }

    public static synchronized void d(ef4 ef4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ef4Var, ac4Var) == null) {
            synchronized (pb4.class) {
                if (b(ef4Var, ac4Var)) {
                    return;
                }
                if (ef4Var.f() != null && !ef4Var.f().isEmpty()) {
                    HashMap<String, String> f = jd4.f(ef4Var);
                    if (ac4Var.B() != null && f != null) {
                        f.putAll(ac4Var.B());
                    }
                    JSONObject d = jd4.d(ef4Var);
                    if (d == null) {
                        ac4Var.C(new zc4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, ac4Var.y());
                    ac4Var.D();
                    qb4.b().M().b(nd4.d(), f, ac4Var.t(), d, new se4(ac4Var, ef4Var));
                    return;
                }
                ac4Var.C(new zc4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(kf4 kf4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, kf4Var, ac4Var) == null) {
            synchronized (pb4.class) {
                if (b(kf4Var, ac4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(kf4Var.f())) {
                    ac4Var.C(new zc4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(kf4Var.k())) {
                    ac4Var.C(new zc4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = jd4.k(kf4Var);
                    if (ac4Var.B() != null) {
                        k.putAll(ac4Var.B());
                    }
                    ac4Var.D();
                    qb4.b().M().z(nd4.e(), k, ac4Var.t(), new we4(kf4Var.f(), ac4Var, kf4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable ub4 ub4Var) {
        ob4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, ub4Var) != null) || (b = qb4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ug4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(nd4.c(), hashMap, null, jSONObject, new vb4(ub4Var));
    }

    public static synchronized void f(gf4 gf4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, gf4Var, ac4Var) == null) {
            synchronized (pb4.class) {
                if (b(gf4Var, ac4Var)) {
                    return;
                }
                if (gf4Var.f() != null && !gf4Var.f().isEmpty()) {
                    HashMap<String, String> f = jd4.f(gf4Var);
                    if (ac4Var.B() != null && f != null) {
                        f.putAll(ac4Var.B());
                    }
                    JSONObject e = jd4.e(gf4Var);
                    if (e == null) {
                        ac4Var.C(new zc4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(qb4.b())) {
                        ug4.e().f();
                    }
                    a(e, ac4Var.y());
                    ac4Var.D();
                    qb4.b().M().b(nd4.d(), f, ac4Var.t(), e, new te4(ac4Var, gf4Var));
                    return;
                }
                ac4Var.C(new zc4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(if4 if4Var, ac4 ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, if4Var, ac4Var) == null) {
            synchronized (pb4.class) {
                if (b(if4Var, ac4Var)) {
                    return;
                }
                HashMap<String, String> j = jd4.j(if4Var);
                if (ac4Var.B() != null) {
                    j.putAll(ac4Var.B());
                }
                ac4Var.D();
                qb4.b().M().z(nd4.f(), j, ac4Var.t(), new ve4(ac4Var, if4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (pb4.class) {
                c = fe4.b().c(str);
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
            synchronized (pb4.class) {
                d = fe4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(mf4 mf4Var, ac4 ac4Var, ac4 ac4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, mf4Var, ac4Var, ac4Var2) == null) {
            synchronized (pb4.class) {
                n(mf4Var, ac4Var, ac4Var2, null);
            }
        }
    }

    public static synchronized void n(mf4 mf4Var, ac4 ac4Var, ac4 ac4Var2, @Nullable ch4 ch4Var) {
        pf4<JSONArray> g;
        ac4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, mf4Var, ac4Var, ac4Var2, ch4Var) == null) {
            synchronized (pb4.class) {
                if (b(mf4Var, ac4Var)) {
                    return;
                }
                if (PMSConstants.a(qb4.b())) {
                    ug4.e().f();
                }
                if (ch4Var == null) {
                    g = null;
                } else {
                    g = ch4Var.g();
                }
                if (ch4Var == null) {
                    callback = null;
                } else {
                    callback = ch4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (ac4Var.B() != null) {
                    hashMap.putAll(ac4Var.B());
                }
                ac4Var.D();
                qb4.b().M().b(nd4.g(), hashMap, ac4Var.t(), i(g, null), new xe4(ac4Var, mf4Var, ac4Var2, callback));
            }
        }
    }

    public static synchronized void o(ch4 ch4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ch4Var) == null) {
            synchronized (pb4.class) {
                if (ch4Var == null) {
                    return;
                }
                ac4 callback = ch4Var.getCallback();
                if (callback == null) {
                    return;
                }
                lf4 request = ch4Var.getRequest();
                if (request == null) {
                    callback.C(new zc4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                qb4.b().M().b(nd4.g(), B, callback.t(), i(ch4Var.g(), null), new xe4(callback, request, null, callback));
            }
        }
    }
}
