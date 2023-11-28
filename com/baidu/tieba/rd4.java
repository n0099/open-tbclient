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
/* loaded from: classes8.dex */
public class rd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948117767, "Lcom/baidu/tieba/rd4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948117767, "Lcom/baidu/tieba/rd4;");
        }
    }

    public rd4() {
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

    public static boolean b(nh4 nh4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, nh4Var, ce4Var)) == null) {
            if (ce4Var == null) {
                return true;
            }
            if (nh4Var == null) {
                ce4Var.C(new bf4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable rh4<JSONArray> rh4Var, @Nullable rh4<JSONObject> rh4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, rh4Var, rh4Var2)) == null) {
            return uh4.a(rh4Var, rh4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(oh4 oh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, oh4Var, ce4Var) == null) {
            synchronized (rd4.class) {
                m(oh4Var, ce4Var, null);
            }
        }
    }

    public static synchronized void c(jh4 jh4Var, ce4 ce4Var) {
        qf4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jh4Var, ce4Var) == null) {
            synchronized (rd4.class) {
                if (b(jh4Var, ce4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(jh4Var.g())) {
                    ce4Var.C(new bf4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = lf4.i(jh4Var);
                if (ce4Var.B() != null) {
                    i.putAll(ce4Var.B());
                }
                ce4Var.D();
                if (jh4Var.n() == 1 && jh4Var.h() == 2101) {
                    M = sd4.b().n();
                } else {
                    M = sd4.b().M();
                }
                M.z(pf4.e(), i, ce4Var.t(), new wg4(jh4Var.g(), ce4Var, jh4Var));
            }
        }
    }

    public static synchronized void d(gh4 gh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, gh4Var, ce4Var) == null) {
            synchronized (rd4.class) {
                if (b(gh4Var, ce4Var)) {
                    return;
                }
                if (gh4Var.f() != null && !gh4Var.f().isEmpty()) {
                    HashMap<String, String> f = lf4.f(gh4Var);
                    if (ce4Var.B() != null && f != null) {
                        f.putAll(ce4Var.B());
                    }
                    JSONObject d = lf4.d(gh4Var);
                    if (d == null) {
                        ce4Var.C(new bf4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, ce4Var.y());
                    ce4Var.D();
                    sd4.b().M().b(pf4.d(), f, ce4Var.t(), d, new ug4(ce4Var, gh4Var));
                    return;
                }
                ce4Var.C(new bf4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(mh4 mh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, mh4Var, ce4Var) == null) {
            synchronized (rd4.class) {
                if (b(mh4Var, ce4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(mh4Var.f())) {
                    ce4Var.C(new bf4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(mh4Var.k())) {
                    ce4Var.C(new bf4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = lf4.k(mh4Var);
                    if (ce4Var.B() != null) {
                        k.putAll(ce4Var.B());
                    }
                    ce4Var.D();
                    sd4.b().M().z(pf4.e(), k, ce4Var.t(), new yg4(mh4Var.f(), ce4Var, mh4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable wd4 wd4Var) {
        qd4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, wd4Var) != null) || (b = sd4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            wi4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(pf4.c(), hashMap, null, jSONObject, new xd4(wd4Var));
    }

    public static synchronized void f(ih4 ih4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ih4Var, ce4Var) == null) {
            synchronized (rd4.class) {
                if (b(ih4Var, ce4Var)) {
                    return;
                }
                if (ih4Var.f() != null && !ih4Var.f().isEmpty()) {
                    HashMap<String, String> f = lf4.f(ih4Var);
                    if (ce4Var.B() != null && f != null) {
                        f.putAll(ce4Var.B());
                    }
                    JSONObject e = lf4.e(ih4Var);
                    if (e == null) {
                        ce4Var.C(new bf4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(sd4.b())) {
                        wi4.e().f();
                    }
                    a(e, ce4Var.y());
                    ce4Var.D();
                    sd4.b().M().b(pf4.d(), f, ce4Var.t(), e, new vg4(ce4Var, ih4Var));
                    return;
                }
                ce4Var.C(new bf4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(kh4 kh4Var, ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, kh4Var, ce4Var) == null) {
            synchronized (rd4.class) {
                if (b(kh4Var, ce4Var)) {
                    return;
                }
                HashMap<String, String> j = lf4.j(kh4Var);
                if (ce4Var.B() != null) {
                    j.putAll(ce4Var.B());
                }
                ce4Var.D();
                sd4.b().M().z(pf4.f(), j, ce4Var.t(), new xg4(ce4Var, kh4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (rd4.class) {
                c = hg4.b().c(str);
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
            synchronized (rd4.class) {
                d = hg4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(oh4 oh4Var, ce4 ce4Var, ce4 ce4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, oh4Var, ce4Var, ce4Var2) == null) {
            synchronized (rd4.class) {
                n(oh4Var, ce4Var, ce4Var2, null);
            }
        }
    }

    public static synchronized void n(oh4 oh4Var, ce4 ce4Var, ce4 ce4Var2, @Nullable ej4 ej4Var) {
        rh4<JSONArray> g;
        ce4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, oh4Var, ce4Var, ce4Var2, ej4Var) == null) {
            synchronized (rd4.class) {
                if (b(oh4Var, ce4Var)) {
                    return;
                }
                if (PMSConstants.a(sd4.b())) {
                    wi4.e().f();
                }
                if (ej4Var == null) {
                    g = null;
                } else {
                    g = ej4Var.g();
                }
                if (ej4Var == null) {
                    callback = null;
                } else {
                    callback = ej4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (ce4Var.B() != null) {
                    hashMap.putAll(ce4Var.B());
                }
                ce4Var.D();
                sd4.b().M().b(pf4.g(), hashMap, ce4Var.t(), i(g, null), new zg4(ce4Var, oh4Var, ce4Var2, callback));
            }
        }
    }

    public static synchronized void o(ej4 ej4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ej4Var) == null) {
            synchronized (rd4.class) {
                if (ej4Var == null) {
                    return;
                }
                ce4 callback = ej4Var.getCallback();
                if (callback == null) {
                    return;
                }
                nh4 request = ej4Var.getRequest();
                if (request == null) {
                    callback.C(new bf4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                sd4.b().M().b(pf4.g(), B, callback.t(), i(ej4Var.g(), null), new zg4(callback, request, null, callback));
            }
        }
    }
}
