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
public class ri4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948122572, "Lcom/baidu/tieba/ri4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948122572, "Lcom/baidu/tieba/ri4;");
        }
    }

    public ri4() {
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

    public static boolean b(nm4 nm4Var, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, nm4Var, cj4Var)) == null) {
            if (cj4Var == null) {
                return true;
            }
            if (nm4Var == null) {
                cj4Var.C(new bk4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable rm4<JSONArray> rm4Var, @Nullable rm4<JSONObject> rm4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, rm4Var, rm4Var2)) == null) {
            return um4.a(rm4Var, rm4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(om4 om4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, om4Var, cj4Var) == null) {
            synchronized (ri4.class) {
                m(om4Var, cj4Var, null);
            }
        }
    }

    public static synchronized void c(jm4 jm4Var, cj4 cj4Var) {
        qk4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jm4Var, cj4Var) == null) {
            synchronized (ri4.class) {
                if (b(jm4Var, cj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(jm4Var.g())) {
                    cj4Var.C(new bk4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = lk4.i(jm4Var);
                if (cj4Var.B() != null) {
                    i.putAll(cj4Var.B());
                }
                cj4Var.D();
                if (jm4Var.n() == 1 && jm4Var.h() == 2101) {
                    M = si4.b().n();
                } else {
                    M = si4.b().M();
                }
                M.z(pk4.e(), i, cj4Var.t(), new wl4(jm4Var.g(), cj4Var, jm4Var));
            }
        }
    }

    public static synchronized void d(gm4 gm4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, gm4Var, cj4Var) == null) {
            synchronized (ri4.class) {
                if (b(gm4Var, cj4Var)) {
                    return;
                }
                if (gm4Var.f() != null && !gm4Var.f().isEmpty()) {
                    HashMap<String, String> f = lk4.f(gm4Var);
                    if (cj4Var.B() != null && f != null) {
                        f.putAll(cj4Var.B());
                    }
                    JSONObject d = lk4.d(gm4Var);
                    if (d == null) {
                        cj4Var.C(new bk4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, cj4Var.y());
                    cj4Var.D();
                    si4.b().M().b(pk4.d(), f, cj4Var.t(), d, new ul4(cj4Var, gm4Var));
                    return;
                }
                cj4Var.C(new bk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(mm4 mm4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, mm4Var, cj4Var) == null) {
            synchronized (ri4.class) {
                if (b(mm4Var, cj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(mm4Var.f())) {
                    cj4Var.C(new bk4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(mm4Var.k())) {
                    cj4Var.C(new bk4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = lk4.k(mm4Var);
                    if (cj4Var.B() != null) {
                        k.putAll(cj4Var.B());
                    }
                    cj4Var.D();
                    si4.b().M().z(pk4.e(), k, cj4Var.t(), new yl4(mm4Var.f(), cj4Var, mm4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable wi4 wi4Var) {
        qi4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, wi4Var) != null) || (b = si4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            wn4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(pk4.c(), hashMap, null, jSONObject, new xi4(wi4Var));
    }

    public static synchronized void f(im4 im4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, im4Var, cj4Var) == null) {
            synchronized (ri4.class) {
                if (b(im4Var, cj4Var)) {
                    return;
                }
                if (im4Var.f() != null && !im4Var.f().isEmpty()) {
                    HashMap<String, String> f = lk4.f(im4Var);
                    if (cj4Var.B() != null && f != null) {
                        f.putAll(cj4Var.B());
                    }
                    JSONObject e = lk4.e(im4Var);
                    if (e == null) {
                        cj4Var.C(new bk4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(si4.b())) {
                        wn4.e().f();
                    }
                    a(e, cj4Var.y());
                    cj4Var.D();
                    si4.b().M().b(pk4.d(), f, cj4Var.t(), e, new vl4(cj4Var, im4Var));
                    return;
                }
                cj4Var.C(new bk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(km4 km4Var, cj4 cj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, km4Var, cj4Var) == null) {
            synchronized (ri4.class) {
                if (b(km4Var, cj4Var)) {
                    return;
                }
                HashMap<String, String> j = lk4.j(km4Var);
                if (cj4Var.B() != null) {
                    j.putAll(cj4Var.B());
                }
                cj4Var.D();
                si4.b().M().z(pk4.f(), j, cj4Var.t(), new xl4(cj4Var, km4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ri4.class) {
                c = hl4.b().c(str);
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
            synchronized (ri4.class) {
                d = hl4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(om4 om4Var, cj4 cj4Var, cj4 cj4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, om4Var, cj4Var, cj4Var2) == null) {
            synchronized (ri4.class) {
                n(om4Var, cj4Var, cj4Var2, null);
            }
        }
    }

    public static synchronized void n(om4 om4Var, cj4 cj4Var, cj4 cj4Var2, @Nullable eo4 eo4Var) {
        rm4<JSONArray> g;
        cj4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, om4Var, cj4Var, cj4Var2, eo4Var) == null) {
            synchronized (ri4.class) {
                if (b(om4Var, cj4Var)) {
                    return;
                }
                if (PMSConstants.a(si4.b())) {
                    wn4.e().f();
                }
                if (eo4Var == null) {
                    g = null;
                } else {
                    g = eo4Var.g();
                }
                if (eo4Var == null) {
                    callback = null;
                } else {
                    callback = eo4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (cj4Var.B() != null) {
                    hashMap.putAll(cj4Var.B());
                }
                cj4Var.D();
                si4.b().M().b(pk4.g(), hashMap, cj4Var.t(), i(g, null), new zl4(cj4Var, om4Var, cj4Var2, callback));
            }
        }
    }

    public static synchronized void o(eo4 eo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, eo4Var) == null) {
            synchronized (ri4.class) {
                if (eo4Var == null) {
                    return;
                }
                cj4 callback = eo4Var.getCallback();
                if (callback == null) {
                    return;
                }
                nm4 request = eo4Var.getRequest();
                if (request == null) {
                    callback.C(new bk4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                si4.b().M().b(pk4.g(), B, callback.t(), i(eo4Var.g(), null), new zl4(callback, request, null, callback));
            }
        }
    }
}
