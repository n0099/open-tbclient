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
public class qd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948087976, "Lcom/baidu/tieba/qd4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948087976, "Lcom/baidu/tieba/qd4;");
        }
    }

    public qd4() {
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

    public static boolean b(mh4 mh4Var, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mh4Var, be4Var)) == null) {
            if (be4Var == null) {
                return true;
            }
            if (mh4Var == null) {
                be4Var.C(new af4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable qh4<JSONArray> qh4Var, @Nullable qh4<JSONObject> qh4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, qh4Var, qh4Var2)) == null) {
            return th4.a(qh4Var, qh4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(nh4 nh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, nh4Var, be4Var) == null) {
            synchronized (qd4.class) {
                m(nh4Var, be4Var, null);
            }
        }
    }

    public static synchronized void c(ih4 ih4Var, be4 be4Var) {
        pf4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ih4Var, be4Var) == null) {
            synchronized (qd4.class) {
                if (b(ih4Var, be4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ih4Var.g())) {
                    be4Var.C(new af4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = kf4.i(ih4Var);
                if (be4Var.B() != null) {
                    i.putAll(be4Var.B());
                }
                be4Var.D();
                if (ih4Var.n() == 1 && ih4Var.h() == 2101) {
                    M = rd4.b().n();
                } else {
                    M = rd4.b().M();
                }
                M.z(of4.e(), i, be4Var.t(), new vg4(ih4Var.g(), be4Var, ih4Var));
            }
        }
    }

    public static synchronized void d(fh4 fh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, fh4Var, be4Var) == null) {
            synchronized (qd4.class) {
                if (b(fh4Var, be4Var)) {
                    return;
                }
                if (fh4Var.f() != null && !fh4Var.f().isEmpty()) {
                    HashMap<String, String> f = kf4.f(fh4Var);
                    if (be4Var.B() != null && f != null) {
                        f.putAll(be4Var.B());
                    }
                    JSONObject d = kf4.d(fh4Var);
                    if (d == null) {
                        be4Var.C(new af4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, be4Var.y());
                    be4Var.D();
                    rd4.b().M().b(of4.d(), f, be4Var.t(), d, new tg4(be4Var, fh4Var));
                    return;
                }
                be4Var.C(new af4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(lh4 lh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, lh4Var, be4Var) == null) {
            synchronized (qd4.class) {
                if (b(lh4Var, be4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(lh4Var.f())) {
                    be4Var.C(new af4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(lh4Var.k())) {
                    be4Var.C(new af4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = kf4.k(lh4Var);
                    if (be4Var.B() != null) {
                        k.putAll(be4Var.B());
                    }
                    be4Var.D();
                    rd4.b().M().z(of4.e(), k, be4Var.t(), new xg4(lh4Var.f(), be4Var, lh4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable vd4 vd4Var) {
        pd4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, vd4Var) != null) || (b = rd4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            vi4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(of4.c(), hashMap, null, jSONObject, new wd4(vd4Var));
    }

    public static synchronized void f(hh4 hh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hh4Var, be4Var) == null) {
            synchronized (qd4.class) {
                if (b(hh4Var, be4Var)) {
                    return;
                }
                if (hh4Var.f() != null && !hh4Var.f().isEmpty()) {
                    HashMap<String, String> f = kf4.f(hh4Var);
                    if (be4Var.B() != null && f != null) {
                        f.putAll(be4Var.B());
                    }
                    JSONObject e = kf4.e(hh4Var);
                    if (e == null) {
                        be4Var.C(new af4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(rd4.b())) {
                        vi4.e().f();
                    }
                    a(e, be4Var.y());
                    be4Var.D();
                    rd4.b().M().b(of4.d(), f, be4Var.t(), e, new ug4(be4Var, hh4Var));
                    return;
                }
                be4Var.C(new af4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(jh4 jh4Var, be4 be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jh4Var, be4Var) == null) {
            synchronized (qd4.class) {
                if (b(jh4Var, be4Var)) {
                    return;
                }
                HashMap<String, String> j = kf4.j(jh4Var);
                if (be4Var.B() != null) {
                    j.putAll(be4Var.B());
                }
                be4Var.D();
                rd4.b().M().z(of4.f(), j, be4Var.t(), new wg4(be4Var, jh4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (qd4.class) {
                c = gg4.b().c(str);
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
            synchronized (qd4.class) {
                d = gg4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(nh4 nh4Var, be4 be4Var, be4 be4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, nh4Var, be4Var, be4Var2) == null) {
            synchronized (qd4.class) {
                n(nh4Var, be4Var, be4Var2, null);
            }
        }
    }

    public static synchronized void n(nh4 nh4Var, be4 be4Var, be4 be4Var2, @Nullable dj4 dj4Var) {
        qh4<JSONArray> g;
        be4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, nh4Var, be4Var, be4Var2, dj4Var) == null) {
            synchronized (qd4.class) {
                if (b(nh4Var, be4Var)) {
                    return;
                }
                if (PMSConstants.a(rd4.b())) {
                    vi4.e().f();
                }
                if (dj4Var == null) {
                    g = null;
                } else {
                    g = dj4Var.g();
                }
                if (dj4Var == null) {
                    callback = null;
                } else {
                    callback = dj4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (be4Var.B() != null) {
                    hashMap.putAll(be4Var.B());
                }
                be4Var.D();
                rd4.b().M().b(of4.g(), hashMap, be4Var.t(), i(g, null), new yg4(be4Var, nh4Var, be4Var2, callback));
            }
        }
    }

    public static synchronized void o(dj4 dj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, dj4Var) == null) {
            synchronized (qd4.class) {
                if (dj4Var == null) {
                    return;
                }
                be4 callback = dj4Var.getCallback();
                if (callback == null) {
                    return;
                }
                mh4 request = dj4Var.getRequest();
                if (request == null) {
                    callback.C(new af4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                rd4.b().M().b(of4.g(), B, callback.t(), i(dj4Var.g(), null), new yg4(callback, request, null, callback));
            }
        }
    }
}
