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
/* loaded from: classes9.dex */
public class zc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948355134, "Lcom/baidu/tieba/zc4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948355134, "Lcom/baidu/tieba/zc4;");
        }
    }

    public zc4() {
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

    public static boolean b(vg4 vg4Var, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, vg4Var, kd4Var)) == null) {
            if (kd4Var == null) {
                return true;
            }
            if (vg4Var == null) {
                kd4Var.C(new je4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable zg4<JSONArray> zg4Var, @Nullable zg4<JSONObject> zg4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, zg4Var, zg4Var2)) == null) {
            return ch4.a(zg4Var, zg4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(wg4 wg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, wg4Var, kd4Var) == null) {
            synchronized (zc4.class) {
                m(wg4Var, kd4Var, null);
            }
        }
    }

    public static synchronized void c(rg4 rg4Var, kd4 kd4Var) {
        ye4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, rg4Var, kd4Var) == null) {
            synchronized (zc4.class) {
                if (b(rg4Var, kd4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(rg4Var.g())) {
                    kd4Var.C(new je4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = te4.i(rg4Var);
                if (kd4Var.B() != null) {
                    i.putAll(kd4Var.B());
                }
                kd4Var.D();
                if (rg4Var.n() == 1 && rg4Var.h() == 2101) {
                    M = ad4.b().n();
                } else {
                    M = ad4.b().M();
                }
                M.z(xe4.e(), i, kd4Var.t(), new eg4(rg4Var.g(), kd4Var, rg4Var));
            }
        }
    }

    public static synchronized void d(og4 og4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, og4Var, kd4Var) == null) {
            synchronized (zc4.class) {
                if (b(og4Var, kd4Var)) {
                    return;
                }
                if (og4Var.f() != null && !og4Var.f().isEmpty()) {
                    HashMap<String, String> f = te4.f(og4Var);
                    if (kd4Var.B() != null && f != null) {
                        f.putAll(kd4Var.B());
                    }
                    JSONObject d = te4.d(og4Var);
                    if (d == null) {
                        kd4Var.C(new je4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, kd4Var.y());
                    kd4Var.D();
                    ad4.b().M().b(xe4.d(), f, kd4Var.t(), d, new cg4(kd4Var, og4Var));
                    return;
                }
                kd4Var.C(new je4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(ug4 ug4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, ug4Var, kd4Var) == null) {
            synchronized (zc4.class) {
                if (b(ug4Var, kd4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ug4Var.f())) {
                    kd4Var.C(new je4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(ug4Var.k())) {
                    kd4Var.C(new je4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = te4.k(ug4Var);
                    if (kd4Var.B() != null) {
                        k.putAll(kd4Var.B());
                    }
                    kd4Var.D();
                    ad4.b().M().z(xe4.e(), k, kd4Var.t(), new gg4(ug4Var.f(), kd4Var, ug4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable ed4 ed4Var) {
        yc4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, ed4Var) != null) || (b = ad4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ei4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(xe4.c(), hashMap, null, jSONObject, new fd4(ed4Var));
    }

    public static synchronized void f(qg4 qg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, qg4Var, kd4Var) == null) {
            synchronized (zc4.class) {
                if (b(qg4Var, kd4Var)) {
                    return;
                }
                if (qg4Var.f() != null && !qg4Var.f().isEmpty()) {
                    HashMap<String, String> f = te4.f(qg4Var);
                    if (kd4Var.B() != null && f != null) {
                        f.putAll(kd4Var.B());
                    }
                    JSONObject e = te4.e(qg4Var);
                    if (e == null) {
                        kd4Var.C(new je4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(ad4.b())) {
                        ei4.e().f();
                    }
                    a(e, kd4Var.y());
                    kd4Var.D();
                    ad4.b().M().b(xe4.d(), f, kd4Var.t(), e, new dg4(kd4Var, qg4Var));
                    return;
                }
                kd4Var.C(new je4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(sg4 sg4Var, kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, sg4Var, kd4Var) == null) {
            synchronized (zc4.class) {
                if (b(sg4Var, kd4Var)) {
                    return;
                }
                HashMap<String, String> j = te4.j(sg4Var);
                if (kd4Var.B() != null) {
                    j.putAll(kd4Var.B());
                }
                kd4Var.D();
                ad4.b().M().z(xe4.f(), j, kd4Var.t(), new fg4(kd4Var, sg4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (zc4.class) {
                c = pf4.b().c(str);
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
            synchronized (zc4.class) {
                d = pf4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(wg4 wg4Var, kd4 kd4Var, kd4 kd4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, wg4Var, kd4Var, kd4Var2) == null) {
            synchronized (zc4.class) {
                n(wg4Var, kd4Var, kd4Var2, null);
            }
        }
    }

    public static synchronized void n(wg4 wg4Var, kd4 kd4Var, kd4 kd4Var2, @Nullable mi4 mi4Var) {
        zg4<JSONArray> g;
        kd4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, wg4Var, kd4Var, kd4Var2, mi4Var) == null) {
            synchronized (zc4.class) {
                if (b(wg4Var, kd4Var)) {
                    return;
                }
                if (PMSConstants.a(ad4.b())) {
                    ei4.e().f();
                }
                if (mi4Var == null) {
                    g = null;
                } else {
                    g = mi4Var.g();
                }
                if (mi4Var == null) {
                    callback = null;
                } else {
                    callback = mi4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (kd4Var.B() != null) {
                    hashMap.putAll(kd4Var.B());
                }
                kd4Var.D();
                ad4.b().M().b(xe4.g(), hashMap, kd4Var.t(), i(g, null), new hg4(kd4Var, wg4Var, kd4Var2, callback));
            }
        }
    }

    public static synchronized void o(mi4 mi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, mi4Var) == null) {
            synchronized (zc4.class) {
                if (mi4Var == null) {
                    return;
                }
                kd4 callback = mi4Var.getCallback();
                if (callback == null) {
                    return;
                }
                vg4 request = mi4Var.getRequest();
                if (request == null) {
                    callback.C(new je4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                ad4.b().M().b(xe4.g(), B, callback.t(), i(mi4Var.g(), null), new hg4(callback, request, null, callback));
            }
        }
    }
}
