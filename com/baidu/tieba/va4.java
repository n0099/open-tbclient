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
public class va4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948234048, "Lcom/baidu/tieba/va4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948234048, "Lcom/baidu/tieba/va4;");
        }
    }

    public va4() {
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
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jSONObject, map) == null) || map == null) {
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

    public static boolean b(re4 re4Var, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, re4Var, gb4Var)) == null) {
            if (gb4Var == null) {
                return true;
            }
            if (re4Var == null) {
                gb4Var.C(new fc4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(ne4 ne4Var, gb4 gb4Var) {
        uc4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ne4Var, gb4Var) == null) {
            synchronized (va4.class) {
                if (b(ne4Var, gb4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ne4Var.g())) {
                    gb4Var.C(new fc4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = pc4.i(ne4Var);
                if (gb4Var.B() != null) {
                    i.putAll(gb4Var.B());
                }
                gb4Var.D();
                if (ne4Var.n() == 1 && ne4Var.h() == 2101) {
                    M = wa4.b().n();
                } else {
                    M = wa4.b().M();
                }
                M.z(tc4.e(), i, gb4Var.t(), new ae4(ne4Var.g(), gb4Var, ne4Var));
            }
        }
    }

    public static synchronized void d(ke4 ke4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ke4Var, gb4Var) == null) {
            synchronized (va4.class) {
                if (b(ke4Var, gb4Var)) {
                    return;
                }
                if (ke4Var.f() != null && !ke4Var.f().isEmpty()) {
                    HashMap<String, String> f = pc4.f(ke4Var);
                    if (gb4Var.B() != null && f != null) {
                        f.putAll(gb4Var.B());
                    }
                    JSONObject d = pc4.d(ke4Var);
                    if (d == null) {
                        gb4Var.C(new fc4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, gb4Var.y());
                    gb4Var.D();
                    wa4.b().M().b(tc4.d(), f, gb4Var.t(), d, new yd4(gb4Var, ke4Var));
                    return;
                }
                gb4Var.C(new fc4(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable ab4 ab4Var) {
        ua4 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, ab4Var) == null) || (b = wa4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ag4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(tc4.c(), hashMap, null, jSONObject, new bb4(ab4Var));
    }

    public static synchronized void f(me4 me4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, me4Var, gb4Var) == null) {
            synchronized (va4.class) {
                if (b(me4Var, gb4Var)) {
                    return;
                }
                if (me4Var.f() != null && !me4Var.f().isEmpty()) {
                    HashMap<String, String> f = pc4.f(me4Var);
                    if (gb4Var.B() != null && f != null) {
                        f.putAll(gb4Var.B());
                    }
                    JSONObject e = pc4.e(me4Var);
                    if (e == null) {
                        gb4Var.C(new fc4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(wa4.b())) {
                        ag4.e().f();
                    }
                    a(e, gb4Var.y());
                    gb4Var.D();
                    wa4.b().M().b(tc4.d(), f, gb4Var.t(), e, new zd4(gb4Var, me4Var));
                    return;
                }
                gb4Var.C(new fc4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(oe4 oe4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, oe4Var, gb4Var) == null) {
            synchronized (va4.class) {
                if (b(oe4Var, gb4Var)) {
                    return;
                }
                HashMap<String, String> j = pc4.j(oe4Var);
                if (gb4Var.B() != null) {
                    j.putAll(gb4Var.B());
                }
                gb4Var.D();
                wa4.b().M().z(tc4.f(), j, gb4Var.t(), new be4(gb4Var, oe4Var));
            }
        }
    }

    public static synchronized void h(qe4 qe4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, qe4Var, gb4Var) == null) {
            synchronized (va4.class) {
                if (b(qe4Var, gb4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(qe4Var.f())) {
                    gb4Var.C(new fc4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(qe4Var.k())) {
                    gb4Var.C(new fc4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = pc4.k(qe4Var);
                    if (gb4Var.B() != null) {
                        k.putAll(gb4Var.B());
                    }
                    gb4Var.D();
                    wa4.b().M().z(tc4.e(), k, gb4Var.t(), new ce4(qe4Var.f(), gb4Var, qe4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable ve4<JSONArray> ve4Var, @Nullable ve4<JSONObject> ve4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, ve4Var, ve4Var2)) == null) ? ye4.a(ve4Var, ve4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (va4.class) {
                c = ld4.b().c(str);
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
            synchronized (va4.class) {
                d = ld4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(se4 se4Var, gb4 gb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, se4Var, gb4Var) == null) {
            synchronized (va4.class) {
                m(se4Var, gb4Var, null);
            }
        }
    }

    public static synchronized void m(se4 se4Var, gb4 gb4Var, gb4 gb4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, se4Var, gb4Var, gb4Var2) == null) {
            synchronized (va4.class) {
                n(se4Var, gb4Var, gb4Var2, null);
            }
        }
    }

    public static synchronized void n(se4 se4Var, gb4 gb4Var, gb4 gb4Var2, @Nullable ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, se4Var, gb4Var, gb4Var2, ig4Var) == null) {
            synchronized (va4.class) {
                if (b(se4Var, gb4Var)) {
                    return;
                }
                if (PMSConstants.a(wa4.b())) {
                    ag4.e().f();
                }
                ve4<JSONArray> g = ig4Var == null ? null : ig4Var.g();
                gb4 callback = ig4Var == null ? null : ig4Var.getCallback();
                HashMap hashMap = new HashMap();
                if (gb4Var.B() != null) {
                    hashMap.putAll(gb4Var.B());
                }
                gb4Var.D();
                wa4.b().M().b(tc4.g(), hashMap, gb4Var.t(), i(g, null), new de4(gb4Var, se4Var, gb4Var2, callback));
            }
        }
    }

    public static synchronized void o(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ig4Var) == null) {
            synchronized (va4.class) {
                if (ig4Var == null) {
                    return;
                }
                gb4 callback = ig4Var.getCallback();
                if (callback == null) {
                    return;
                }
                re4 request = ig4Var.getRequest();
                if (request == null) {
                    callback.C(new fc4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                wa4.b().M().b(tc4.g(), B, callback.t(), i(ig4Var.g(), null), new de4(callback, request, null, callback));
            }
        }
    }
}
