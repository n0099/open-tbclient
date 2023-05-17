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
/* loaded from: classes7.dex */
public class qg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948090859, "Lcom/baidu/tieba/qg4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948090859, "Lcom/baidu/tieba/qg4;");
        }
    }

    public qg4() {
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

    public static boolean b(mk4 mk4Var, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mk4Var, bh4Var)) == null) {
            if (bh4Var == null) {
                return true;
            }
            if (mk4Var == null) {
                bh4Var.C(new ai4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable qk4<JSONArray> qk4Var, @Nullable qk4<JSONObject> qk4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, qk4Var, qk4Var2)) == null) {
            return tk4.a(qk4Var, qk4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(nk4 nk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, nk4Var, bh4Var) == null) {
            synchronized (qg4.class) {
                m(nk4Var, bh4Var, null);
            }
        }
    }

    public static synchronized void c(ik4 ik4Var, bh4 bh4Var) {
        pi4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ik4Var, bh4Var) == null) {
            synchronized (qg4.class) {
                if (b(ik4Var, bh4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ik4Var.g())) {
                    bh4Var.C(new ai4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = ki4.i(ik4Var);
                if (bh4Var.B() != null) {
                    i.putAll(bh4Var.B());
                }
                bh4Var.D();
                if (ik4Var.n() == 1 && ik4Var.h() == 2101) {
                    M = rg4.b().n();
                } else {
                    M = rg4.b().M();
                }
                M.z(oi4.e(), i, bh4Var.t(), new vj4(ik4Var.g(), bh4Var, ik4Var));
            }
        }
    }

    public static synchronized void d(fk4 fk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, fk4Var, bh4Var) == null) {
            synchronized (qg4.class) {
                if (b(fk4Var, bh4Var)) {
                    return;
                }
                if (fk4Var.f() != null && !fk4Var.f().isEmpty()) {
                    HashMap<String, String> f = ki4.f(fk4Var);
                    if (bh4Var.B() != null && f != null) {
                        f.putAll(bh4Var.B());
                    }
                    JSONObject d = ki4.d(fk4Var);
                    if (d == null) {
                        bh4Var.C(new ai4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, bh4Var.y());
                    bh4Var.D();
                    rg4.b().M().b(oi4.d(), f, bh4Var.t(), d, new tj4(bh4Var, fk4Var));
                    return;
                }
                bh4Var.C(new ai4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(lk4 lk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, lk4Var, bh4Var) == null) {
            synchronized (qg4.class) {
                if (b(lk4Var, bh4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(lk4Var.f())) {
                    bh4Var.C(new ai4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(lk4Var.k())) {
                    bh4Var.C(new ai4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = ki4.k(lk4Var);
                    if (bh4Var.B() != null) {
                        k.putAll(bh4Var.B());
                    }
                    bh4Var.D();
                    rg4.b().M().z(oi4.e(), k, bh4Var.t(), new xj4(lk4Var.f(), bh4Var, lk4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable vg4 vg4Var) {
        pg4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, vg4Var) != null) || (b = rg4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            vl4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(oi4.c(), hashMap, null, jSONObject, new wg4(vg4Var));
    }

    public static synchronized void f(hk4 hk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hk4Var, bh4Var) == null) {
            synchronized (qg4.class) {
                if (b(hk4Var, bh4Var)) {
                    return;
                }
                if (hk4Var.f() != null && !hk4Var.f().isEmpty()) {
                    HashMap<String, String> f = ki4.f(hk4Var);
                    if (bh4Var.B() != null && f != null) {
                        f.putAll(bh4Var.B());
                    }
                    JSONObject e = ki4.e(hk4Var);
                    if (e == null) {
                        bh4Var.C(new ai4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(rg4.b())) {
                        vl4.e().f();
                    }
                    a(e, bh4Var.y());
                    bh4Var.D();
                    rg4.b().M().b(oi4.d(), f, bh4Var.t(), e, new uj4(bh4Var, hk4Var));
                    return;
                }
                bh4Var.C(new ai4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(jk4 jk4Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jk4Var, bh4Var) == null) {
            synchronized (qg4.class) {
                if (b(jk4Var, bh4Var)) {
                    return;
                }
                HashMap<String, String> j = ki4.j(jk4Var);
                if (bh4Var.B() != null) {
                    j.putAll(bh4Var.B());
                }
                bh4Var.D();
                rg4.b().M().z(oi4.f(), j, bh4Var.t(), new wj4(bh4Var, jk4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (qg4.class) {
                c = gj4.b().c(str);
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
            synchronized (qg4.class) {
                d = gj4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(nk4 nk4Var, bh4 bh4Var, bh4 bh4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, nk4Var, bh4Var, bh4Var2) == null) {
            synchronized (qg4.class) {
                n(nk4Var, bh4Var, bh4Var2, null);
            }
        }
    }

    public static synchronized void n(nk4 nk4Var, bh4 bh4Var, bh4 bh4Var2, @Nullable dm4 dm4Var) {
        qk4<JSONArray> g;
        bh4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, nk4Var, bh4Var, bh4Var2, dm4Var) == null) {
            synchronized (qg4.class) {
                if (b(nk4Var, bh4Var)) {
                    return;
                }
                if (PMSConstants.a(rg4.b())) {
                    vl4.e().f();
                }
                if (dm4Var == null) {
                    g = null;
                } else {
                    g = dm4Var.g();
                }
                if (dm4Var == null) {
                    callback = null;
                } else {
                    callback = dm4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (bh4Var.B() != null) {
                    hashMap.putAll(bh4Var.B());
                }
                bh4Var.D();
                rg4.b().M().b(oi4.g(), hashMap, bh4Var.t(), i(g, null), new yj4(bh4Var, nk4Var, bh4Var2, callback));
            }
        }
    }

    public static synchronized void o(dm4 dm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, dm4Var) == null) {
            synchronized (qg4.class) {
                if (dm4Var == null) {
                    return;
                }
                bh4 callback = dm4Var.getCallback();
                if (callback == null) {
                    return;
                }
                mk4 request = dm4Var.getRequest();
                if (request == null) {
                    callback.C(new ai4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                rg4.b().M().b(oi4.g(), B, callback.t(), i(dm4Var.g(), null), new yj4(callback, request, null, callback));
            }
        }
    }
}
