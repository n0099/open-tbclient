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
public class jj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947885205, "Lcom/baidu/tieba/jj4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947885205, "Lcom/baidu/tieba/jj4;");
        }
    }

    public jj4() {
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

    public static boolean b(fn4 fn4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, fn4Var, uj4Var)) == null) {
            if (uj4Var == null) {
                return true;
            }
            if (fn4Var == null) {
                uj4Var.C(new tk4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable jn4<JSONArray> jn4Var, @Nullable jn4<JSONObject> jn4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jn4Var, jn4Var2)) == null) {
            return mn4.a(jn4Var, jn4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(gn4 gn4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, gn4Var, uj4Var) == null) {
            synchronized (jj4.class) {
                m(gn4Var, uj4Var, null);
            }
        }
    }

    public static synchronized void c(bn4 bn4Var, uj4 uj4Var) {
        il4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bn4Var, uj4Var) == null) {
            synchronized (jj4.class) {
                if (b(bn4Var, uj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(bn4Var.g())) {
                    uj4Var.C(new tk4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = dl4.i(bn4Var);
                if (uj4Var.B() != null) {
                    i.putAll(uj4Var.B());
                }
                uj4Var.D();
                if (bn4Var.n() == 1 && bn4Var.h() == 2101) {
                    M = kj4.b().n();
                } else {
                    M = kj4.b().M();
                }
                M.z(hl4.e(), i, uj4Var.t(), new om4(bn4Var.g(), uj4Var, bn4Var));
            }
        }
    }

    public static synchronized void d(ym4 ym4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ym4Var, uj4Var) == null) {
            synchronized (jj4.class) {
                if (b(ym4Var, uj4Var)) {
                    return;
                }
                if (ym4Var.f() != null && !ym4Var.f().isEmpty()) {
                    HashMap<String, String> f = dl4.f(ym4Var);
                    if (uj4Var.B() != null && f != null) {
                        f.putAll(uj4Var.B());
                    }
                    JSONObject d = dl4.d(ym4Var);
                    if (d == null) {
                        uj4Var.C(new tk4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, uj4Var.y());
                    uj4Var.D();
                    kj4.b().M().b(hl4.d(), f, uj4Var.t(), d, new mm4(uj4Var, ym4Var));
                    return;
                }
                uj4Var.C(new tk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(en4 en4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, en4Var, uj4Var) == null) {
            synchronized (jj4.class) {
                if (b(en4Var, uj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(en4Var.f())) {
                    uj4Var.C(new tk4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(en4Var.k())) {
                    uj4Var.C(new tk4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = dl4.k(en4Var);
                    if (uj4Var.B() != null) {
                        k.putAll(uj4Var.B());
                    }
                    uj4Var.D();
                    kj4.b().M().z(hl4.e(), k, uj4Var.t(), new qm4(en4Var.f(), uj4Var, en4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable oj4 oj4Var) {
        ij4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, oj4Var) != null) || (b = kj4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            oo4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(hl4.c(), hashMap, null, jSONObject, new pj4(oj4Var));
    }

    public static synchronized void f(an4 an4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, an4Var, uj4Var) == null) {
            synchronized (jj4.class) {
                if (b(an4Var, uj4Var)) {
                    return;
                }
                if (an4Var.f() != null && !an4Var.f().isEmpty()) {
                    HashMap<String, String> f = dl4.f(an4Var);
                    if (uj4Var.B() != null && f != null) {
                        f.putAll(uj4Var.B());
                    }
                    JSONObject e = dl4.e(an4Var);
                    if (e == null) {
                        uj4Var.C(new tk4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(kj4.b())) {
                        oo4.e().f();
                    }
                    a(e, uj4Var.y());
                    uj4Var.D();
                    kj4.b().M().b(hl4.d(), f, uj4Var.t(), e, new nm4(uj4Var, an4Var));
                    return;
                }
                uj4Var.C(new tk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(cn4 cn4Var, uj4 uj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, cn4Var, uj4Var) == null) {
            synchronized (jj4.class) {
                if (b(cn4Var, uj4Var)) {
                    return;
                }
                HashMap<String, String> j = dl4.j(cn4Var);
                if (uj4Var.B() != null) {
                    j.putAll(uj4Var.B());
                }
                uj4Var.D();
                kj4.b().M().z(hl4.f(), j, uj4Var.t(), new pm4(uj4Var, cn4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (jj4.class) {
                c = zl4.b().c(str);
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
            synchronized (jj4.class) {
                d = zl4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(gn4 gn4Var, uj4 uj4Var, uj4 uj4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, gn4Var, uj4Var, uj4Var2) == null) {
            synchronized (jj4.class) {
                n(gn4Var, uj4Var, uj4Var2, null);
            }
        }
    }

    public static synchronized void n(gn4 gn4Var, uj4 uj4Var, uj4 uj4Var2, @Nullable wo4 wo4Var) {
        jn4<JSONArray> g;
        uj4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, gn4Var, uj4Var, uj4Var2, wo4Var) == null) {
            synchronized (jj4.class) {
                if (b(gn4Var, uj4Var)) {
                    return;
                }
                if (PMSConstants.a(kj4.b())) {
                    oo4.e().f();
                }
                if (wo4Var == null) {
                    g = null;
                } else {
                    g = wo4Var.g();
                }
                if (wo4Var == null) {
                    callback = null;
                } else {
                    callback = wo4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (uj4Var.B() != null) {
                    hashMap.putAll(uj4Var.B());
                }
                uj4Var.D();
                kj4.b().M().b(hl4.g(), hashMap, uj4Var.t(), i(g, null), new rm4(uj4Var, gn4Var, uj4Var2, callback));
            }
        }
    }

    public static synchronized void o(wo4 wo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, wo4Var) == null) {
            synchronized (jj4.class) {
                if (wo4Var == null) {
                    return;
                }
                uj4 callback = wo4Var.getCallback();
                if (callback == null) {
                    return;
                }
                fn4 request = wo4Var.getRequest();
                if (request == null) {
                    callback.C(new tk4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                kj4.b().M().b(hl4.g(), B, callback.t(), i(wo4Var.g(), null), new rm4(callback, request, null, callback));
            }
        }
    }
}
