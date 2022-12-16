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
public class ob4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948026472, "Lcom/baidu/tieba/ob4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948026472, "Lcom/baidu/tieba/ob4;");
        }
    }

    public ob4() {
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

    public static boolean b(kf4 kf4Var, zb4 zb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, kf4Var, zb4Var)) == null) {
            if (zb4Var == null) {
                return true;
            }
            if (kf4Var == null) {
                zb4Var.C(new yc4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable of4<JSONArray> of4Var, @Nullable of4<JSONObject> of4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, of4Var, of4Var2)) == null) {
            return rf4.a(of4Var, of4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(lf4 lf4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, lf4Var, zb4Var) == null) {
            synchronized (ob4.class) {
                m(lf4Var, zb4Var, null);
            }
        }
    }

    public static synchronized void c(gf4 gf4Var, zb4 zb4Var) {
        nd4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gf4Var, zb4Var) == null) {
            synchronized (ob4.class) {
                if (b(gf4Var, zb4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(gf4Var.g())) {
                    zb4Var.C(new yc4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = id4.i(gf4Var);
                if (zb4Var.B() != null) {
                    i.putAll(zb4Var.B());
                }
                zb4Var.D();
                if (gf4Var.n() == 1 && gf4Var.h() == 2101) {
                    M = pb4.b().n();
                } else {
                    M = pb4.b().M();
                }
                M.z(md4.e(), i, zb4Var.t(), new te4(gf4Var.g(), zb4Var, gf4Var));
            }
        }
    }

    public static synchronized void d(df4 df4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, df4Var, zb4Var) == null) {
            synchronized (ob4.class) {
                if (b(df4Var, zb4Var)) {
                    return;
                }
                if (df4Var.f() != null && !df4Var.f().isEmpty()) {
                    HashMap<String, String> f = id4.f(df4Var);
                    if (zb4Var.B() != null && f != null) {
                        f.putAll(zb4Var.B());
                    }
                    JSONObject d = id4.d(df4Var);
                    if (d == null) {
                        zb4Var.C(new yc4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, zb4Var.y());
                    zb4Var.D();
                    pb4.b().M().b(md4.d(), f, zb4Var.t(), d, new re4(zb4Var, df4Var));
                    return;
                }
                zb4Var.C(new yc4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(jf4 jf4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, jf4Var, zb4Var) == null) {
            synchronized (ob4.class) {
                if (b(jf4Var, zb4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(jf4Var.f())) {
                    zb4Var.C(new yc4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(jf4Var.k())) {
                    zb4Var.C(new yc4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = id4.k(jf4Var);
                    if (zb4Var.B() != null) {
                        k.putAll(zb4Var.B());
                    }
                    zb4Var.D();
                    pb4.b().M().z(md4.e(), k, zb4Var.t(), new ve4(jf4Var.f(), zb4Var, jf4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable tb4 tb4Var) {
        nb4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, tb4Var) != null) || (b = pb4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            tg4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(md4.c(), hashMap, null, jSONObject, new ub4(tb4Var));
    }

    public static synchronized void f(ff4 ff4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ff4Var, zb4Var) == null) {
            synchronized (ob4.class) {
                if (b(ff4Var, zb4Var)) {
                    return;
                }
                if (ff4Var.f() != null && !ff4Var.f().isEmpty()) {
                    HashMap<String, String> f = id4.f(ff4Var);
                    if (zb4Var.B() != null && f != null) {
                        f.putAll(zb4Var.B());
                    }
                    JSONObject e = id4.e(ff4Var);
                    if (e == null) {
                        zb4Var.C(new yc4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(pb4.b())) {
                        tg4.e().f();
                    }
                    a(e, zb4Var.y());
                    zb4Var.D();
                    pb4.b().M().b(md4.d(), f, zb4Var.t(), e, new se4(zb4Var, ff4Var));
                    return;
                }
                zb4Var.C(new yc4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(hf4 hf4Var, zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, hf4Var, zb4Var) == null) {
            synchronized (ob4.class) {
                if (b(hf4Var, zb4Var)) {
                    return;
                }
                HashMap<String, String> j = id4.j(hf4Var);
                if (zb4Var.B() != null) {
                    j.putAll(zb4Var.B());
                }
                zb4Var.D();
                pb4.b().M().z(md4.f(), j, zb4Var.t(), new ue4(zb4Var, hf4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ob4.class) {
                c = ee4.b().c(str);
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
            synchronized (ob4.class) {
                d = ee4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(lf4 lf4Var, zb4 zb4Var, zb4 zb4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, lf4Var, zb4Var, zb4Var2) == null) {
            synchronized (ob4.class) {
                n(lf4Var, zb4Var, zb4Var2, null);
            }
        }
    }

    public static synchronized void n(lf4 lf4Var, zb4 zb4Var, zb4 zb4Var2, @Nullable bh4 bh4Var) {
        of4<JSONArray> g;
        zb4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, lf4Var, zb4Var, zb4Var2, bh4Var) == null) {
            synchronized (ob4.class) {
                if (b(lf4Var, zb4Var)) {
                    return;
                }
                if (PMSConstants.a(pb4.b())) {
                    tg4.e().f();
                }
                if (bh4Var == null) {
                    g = null;
                } else {
                    g = bh4Var.g();
                }
                if (bh4Var == null) {
                    callback = null;
                } else {
                    callback = bh4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (zb4Var.B() != null) {
                    hashMap.putAll(zb4Var.B());
                }
                zb4Var.D();
                pb4.b().M().b(md4.g(), hashMap, zb4Var.t(), i(g, null), new we4(zb4Var, lf4Var, zb4Var2, callback));
            }
        }
    }

    public static synchronized void o(bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, bh4Var) == null) {
            synchronized (ob4.class) {
                if (bh4Var == null) {
                    return;
                }
                zb4 callback = bh4Var.getCallback();
                if (callback == null) {
                    return;
                }
                kf4 request = bh4Var.getRequest();
                if (request == null) {
                    callback.C(new yc4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                pb4.b().M().b(md4.g(), B, callback.t(), i(bh4Var.g(), null), new we4(callback, request, null, callback));
            }
        }
    }
}
