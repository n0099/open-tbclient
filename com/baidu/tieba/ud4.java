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
public class ud4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948207140, "Lcom/baidu/tieba/ud4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948207140, "Lcom/baidu/tieba/ud4;");
        }
    }

    public ud4() {
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

    public static boolean b(qh4 qh4Var, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, qh4Var, fe4Var)) == null) {
            if (fe4Var == null) {
                return true;
            }
            if (qh4Var == null) {
                fe4Var.C(new ef4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable uh4<JSONArray> uh4Var, @Nullable uh4<JSONObject> uh4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, uh4Var, uh4Var2)) == null) {
            return xh4.a(uh4Var, uh4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(rh4 rh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, rh4Var, fe4Var) == null) {
            synchronized (ud4.class) {
                m(rh4Var, fe4Var, null);
            }
        }
    }

    public static synchronized void c(mh4 mh4Var, fe4 fe4Var) {
        tf4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mh4Var, fe4Var) == null) {
            synchronized (ud4.class) {
                if (b(mh4Var, fe4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(mh4Var.g())) {
                    fe4Var.C(new ef4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = of4.i(mh4Var);
                if (fe4Var.B() != null) {
                    i.putAll(fe4Var.B());
                }
                fe4Var.D();
                if (mh4Var.n() == 1 && mh4Var.h() == 2101) {
                    M = vd4.b().n();
                } else {
                    M = vd4.b().M();
                }
                M.z(sf4.e(), i, fe4Var.t(), new zg4(mh4Var.g(), fe4Var, mh4Var));
            }
        }
    }

    public static synchronized void d(jh4 jh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, jh4Var, fe4Var) == null) {
            synchronized (ud4.class) {
                if (b(jh4Var, fe4Var)) {
                    return;
                }
                if (jh4Var.f() != null && !jh4Var.f().isEmpty()) {
                    HashMap<String, String> f = of4.f(jh4Var);
                    if (fe4Var.B() != null && f != null) {
                        f.putAll(fe4Var.B());
                    }
                    JSONObject d = of4.d(jh4Var);
                    if (d == null) {
                        fe4Var.C(new ef4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, fe4Var.y());
                    fe4Var.D();
                    vd4.b().M().b(sf4.d(), f, fe4Var.t(), d, new xg4(fe4Var, jh4Var));
                    return;
                }
                fe4Var.C(new ef4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(ph4 ph4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, ph4Var, fe4Var) == null) {
            synchronized (ud4.class) {
                if (b(ph4Var, fe4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ph4Var.f())) {
                    fe4Var.C(new ef4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(ph4Var.k())) {
                    fe4Var.C(new ef4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = of4.k(ph4Var);
                    if (fe4Var.B() != null) {
                        k.putAll(fe4Var.B());
                    }
                    fe4Var.D();
                    vd4.b().M().z(sf4.e(), k, fe4Var.t(), new bh4(ph4Var.f(), fe4Var, ph4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable zd4 zd4Var) {
        td4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, zd4Var) != null) || (b = vd4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            zi4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(sf4.c(), hashMap, null, jSONObject, new ae4(zd4Var));
    }

    public static synchronized void f(lh4 lh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, lh4Var, fe4Var) == null) {
            synchronized (ud4.class) {
                if (b(lh4Var, fe4Var)) {
                    return;
                }
                if (lh4Var.f() != null && !lh4Var.f().isEmpty()) {
                    HashMap<String, String> f = of4.f(lh4Var);
                    if (fe4Var.B() != null && f != null) {
                        f.putAll(fe4Var.B());
                    }
                    JSONObject e = of4.e(lh4Var);
                    if (e == null) {
                        fe4Var.C(new ef4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(vd4.b())) {
                        zi4.e().f();
                    }
                    a(e, fe4Var.y());
                    fe4Var.D();
                    vd4.b().M().b(sf4.d(), f, fe4Var.t(), e, new yg4(fe4Var, lh4Var));
                    return;
                }
                fe4Var.C(new ef4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(nh4 nh4Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, nh4Var, fe4Var) == null) {
            synchronized (ud4.class) {
                if (b(nh4Var, fe4Var)) {
                    return;
                }
                HashMap<String, String> j = of4.j(nh4Var);
                if (fe4Var.B() != null) {
                    j.putAll(fe4Var.B());
                }
                fe4Var.D();
                vd4.b().M().z(sf4.f(), j, fe4Var.t(), new ah4(fe4Var, nh4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ud4.class) {
                c = kg4.b().c(str);
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
            synchronized (ud4.class) {
                d = kg4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(rh4 rh4Var, fe4 fe4Var, fe4 fe4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, rh4Var, fe4Var, fe4Var2) == null) {
            synchronized (ud4.class) {
                n(rh4Var, fe4Var, fe4Var2, null);
            }
        }
    }

    public static synchronized void n(rh4 rh4Var, fe4 fe4Var, fe4 fe4Var2, @Nullable hj4 hj4Var) {
        uh4<JSONArray> g;
        fe4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, rh4Var, fe4Var, fe4Var2, hj4Var) == null) {
            synchronized (ud4.class) {
                if (b(rh4Var, fe4Var)) {
                    return;
                }
                if (PMSConstants.a(vd4.b())) {
                    zi4.e().f();
                }
                if (hj4Var == null) {
                    g = null;
                } else {
                    g = hj4Var.g();
                }
                if (hj4Var == null) {
                    callback = null;
                } else {
                    callback = hj4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (fe4Var.B() != null) {
                    hashMap.putAll(fe4Var.B());
                }
                fe4Var.D();
                vd4.b().M().b(sf4.g(), hashMap, fe4Var.t(), i(g, null), new ch4(fe4Var, rh4Var, fe4Var2, callback));
            }
        }
    }

    public static synchronized void o(hj4 hj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, hj4Var) == null) {
            synchronized (ud4.class) {
                if (hj4Var == null) {
                    return;
                }
                fe4 callback = hj4Var.getCallback();
                if (callback == null) {
                    return;
                }
                qh4 request = hj4Var.getRequest();
                if (request == null) {
                    callback.C(new ef4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                vd4.b().M().b(sf4.g(), B, callback.t(), i(hj4Var.g(), null), new ch4(callback, request, null, callback));
            }
        }
    }
}
