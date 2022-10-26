package com.baidu.tieba;

import android.text.TextUtils;
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
public class wa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948263839, "Lcom/baidu/tieba/wa4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948263839, "Lcom/baidu/tieba/wa4;");
        }
    }

    public wa4() {
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

    public static void a(JSONObject jSONObject, Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, jSONObject, map) != null) || map == null) {
            return;
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(se4 se4Var, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, se4Var, hb4Var)) == null) {
            if (hb4Var == null) {
                return true;
            }
            if (se4Var == null) {
                hb4Var.C(new gc4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(we4 we4Var, we4 we4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, we4Var, we4Var2)) == null) {
            return ze4.a(we4Var, we4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(te4 te4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, te4Var, hb4Var) == null) {
            synchronized (wa4.class) {
                m(te4Var, hb4Var, null);
            }
        }
    }

    public static synchronized void c(oe4 oe4Var, hb4 hb4Var) {
        vc4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, oe4Var, hb4Var) == null) {
            synchronized (wa4.class) {
                if (b(oe4Var, hb4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(oe4Var.g())) {
                    hb4Var.C(new gc4(2100, "bundleId为空"));
                    return;
                }
                HashMap i = qc4.i(oe4Var);
                if (hb4Var.B() != null) {
                    i.putAll(hb4Var.B());
                }
                hb4Var.D();
                if (oe4Var.n() == 1 && oe4Var.h() == 2101) {
                    M = xa4.b().n();
                } else {
                    M = xa4.b().M();
                }
                M.z(uc4.e(), i, hb4Var.t(), new be4(oe4Var.g(), hb4Var, oe4Var));
            }
        }
    }

    public static synchronized void d(le4 le4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, le4Var, hb4Var) == null) {
            synchronized (wa4.class) {
                if (b(le4Var, hb4Var)) {
                    return;
                }
                if (le4Var.f() != null && !le4Var.f().isEmpty()) {
                    HashMap f = qc4.f(le4Var);
                    if (hb4Var.B() != null && f != null) {
                        f.putAll(hb4Var.B());
                    }
                    JSONObject d = qc4.d(le4Var);
                    if (d == null) {
                        hb4Var.C(new gc4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, hb4Var.y());
                    hb4Var.D();
                    xa4.b().M().b(uc4.d(), f, hb4Var.t(), d, new zd4(hb4Var, le4Var));
                    return;
                }
                hb4Var.C(new gc4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(re4 re4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, re4Var, hb4Var) == null) {
            synchronized (wa4.class) {
                if (b(re4Var, hb4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(re4Var.f())) {
                    hb4Var.C(new gc4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(re4Var.k())) {
                    hb4Var.C(new gc4(2100, "分包名为空"));
                } else {
                    HashMap k = qc4.k(re4Var);
                    if (hb4Var.B() != null) {
                        k.putAll(hb4Var.B());
                    }
                    hb4Var.D();
                    xa4.b().M().z(uc4.e(), k, hb4Var.t(), new de4(re4Var.f(), hb4Var, re4Var));
                }
            }
        }
    }

    public static void e(List list, String str, bb4 bb4Var) {
        va4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, bb4Var) != null) || (b = xa4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            bg4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(uc4.c(), hashMap, null, jSONObject, new cb4(bb4Var));
    }

    public static synchronized void f(ne4 ne4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ne4Var, hb4Var) == null) {
            synchronized (wa4.class) {
                if (b(ne4Var, hb4Var)) {
                    return;
                }
                if (ne4Var.f() != null && !ne4Var.f().isEmpty()) {
                    HashMap f = qc4.f(ne4Var);
                    if (hb4Var.B() != null && f != null) {
                        f.putAll(hb4Var.B());
                    }
                    JSONObject e = qc4.e(ne4Var);
                    if (e == null) {
                        hb4Var.C(new gc4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(xa4.b())) {
                        bg4.e().f();
                    }
                    a(e, hb4Var.y());
                    hb4Var.D();
                    xa4.b().M().b(uc4.d(), f, hb4Var.t(), e, new ae4(hb4Var, ne4Var));
                    return;
                }
                hb4Var.C(new gc4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(pe4 pe4Var, hb4 hb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, pe4Var, hb4Var) == null) {
            synchronized (wa4.class) {
                if (b(pe4Var, hb4Var)) {
                    return;
                }
                HashMap j = qc4.j(pe4Var);
                if (hb4Var.B() != null) {
                    j.putAll(hb4Var.B());
                }
                hb4Var.D();
                xa4.b().M().z(uc4.f(), j, hb4Var.t(), new ce4(hb4Var, pe4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (wa4.class) {
                c = md4.b().c(str);
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
            synchronized (wa4.class) {
                d = md4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(te4 te4Var, hb4 hb4Var, hb4 hb4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, te4Var, hb4Var, hb4Var2) == null) {
            synchronized (wa4.class) {
                n(te4Var, hb4Var, hb4Var2, null);
            }
        }
    }

    public static synchronized void n(te4 te4Var, hb4 hb4Var, hb4 hb4Var2, jg4 jg4Var) {
        we4 g;
        hb4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, te4Var, hb4Var, hb4Var2, jg4Var) == null) {
            synchronized (wa4.class) {
                if (b(te4Var, hb4Var)) {
                    return;
                }
                if (PMSConstants.a(xa4.b())) {
                    bg4.e().f();
                }
                if (jg4Var == null) {
                    g = null;
                } else {
                    g = jg4Var.g();
                }
                if (jg4Var == null) {
                    callback = null;
                } else {
                    callback = jg4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (hb4Var.B() != null) {
                    hashMap.putAll(hb4Var.B());
                }
                hb4Var.D();
                xa4.b().M().b(uc4.g(), hashMap, hb4Var.t(), i(g, null), new ee4(hb4Var, te4Var, hb4Var2, callback));
            }
        }
    }

    public static synchronized void o(jg4 jg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, jg4Var) == null) {
            synchronized (wa4.class) {
                if (jg4Var == null) {
                    return;
                }
                hb4 callback = jg4Var.getCallback();
                if (callback == null) {
                    return;
                }
                se4 request = jg4Var.getRequest();
                if (request == null) {
                    callback.C(new gc4(2100, "request对象为空"));
                    return;
                }
                Map B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                xa4.b().M().b(uc4.g(), B, callback.t(), i(jg4Var.g(), null), new ee4(callback, request, null, callback));
            }
        }
    }
}
