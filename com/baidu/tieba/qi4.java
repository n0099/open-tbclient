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
public class qi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948092781, "Lcom/baidu/tieba/qi4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948092781, "Lcom/baidu/tieba/qi4;");
        }
    }

    public qi4() {
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

    public static boolean b(mm4 mm4Var, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mm4Var, bj4Var)) == null) {
            if (bj4Var == null) {
                return true;
            }
            if (mm4Var == null) {
                bj4Var.C(new ak4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable qm4<JSONArray> qm4Var, @Nullable qm4<JSONObject> qm4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, qm4Var, qm4Var2)) == null) {
            return tm4.a(qm4Var, qm4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(nm4 nm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, nm4Var, bj4Var) == null) {
            synchronized (qi4.class) {
                m(nm4Var, bj4Var, null);
            }
        }
    }

    public static synchronized void c(im4 im4Var, bj4 bj4Var) {
        pk4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, im4Var, bj4Var) == null) {
            synchronized (qi4.class) {
                if (b(im4Var, bj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(im4Var.g())) {
                    bj4Var.C(new ak4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = kk4.i(im4Var);
                if (bj4Var.B() != null) {
                    i.putAll(bj4Var.B());
                }
                bj4Var.D();
                if (im4Var.n() == 1 && im4Var.h() == 2101) {
                    M = ri4.b().n();
                } else {
                    M = ri4.b().M();
                }
                M.z(ok4.e(), i, bj4Var.t(), new vl4(im4Var.g(), bj4Var, im4Var));
            }
        }
    }

    public static synchronized void d(fm4 fm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, fm4Var, bj4Var) == null) {
            synchronized (qi4.class) {
                if (b(fm4Var, bj4Var)) {
                    return;
                }
                if (fm4Var.f() != null && !fm4Var.f().isEmpty()) {
                    HashMap<String, String> f = kk4.f(fm4Var);
                    if (bj4Var.B() != null && f != null) {
                        f.putAll(bj4Var.B());
                    }
                    JSONObject d = kk4.d(fm4Var);
                    if (d == null) {
                        bj4Var.C(new ak4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, bj4Var.y());
                    bj4Var.D();
                    ri4.b().M().b(ok4.d(), f, bj4Var.t(), d, new tl4(bj4Var, fm4Var));
                    return;
                }
                bj4Var.C(new ak4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(lm4 lm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, lm4Var, bj4Var) == null) {
            synchronized (qi4.class) {
                if (b(lm4Var, bj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(lm4Var.f())) {
                    bj4Var.C(new ak4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(lm4Var.k())) {
                    bj4Var.C(new ak4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = kk4.k(lm4Var);
                    if (bj4Var.B() != null) {
                        k.putAll(bj4Var.B());
                    }
                    bj4Var.D();
                    ri4.b().M().z(ok4.e(), k, bj4Var.t(), new xl4(lm4Var.f(), bj4Var, lm4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable vi4 vi4Var) {
        pi4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, vi4Var) != null) || (b = ri4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            vn4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(ok4.c(), hashMap, null, jSONObject, new wi4(vi4Var));
    }

    public static synchronized void f(hm4 hm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hm4Var, bj4Var) == null) {
            synchronized (qi4.class) {
                if (b(hm4Var, bj4Var)) {
                    return;
                }
                if (hm4Var.f() != null && !hm4Var.f().isEmpty()) {
                    HashMap<String, String> f = kk4.f(hm4Var);
                    if (bj4Var.B() != null && f != null) {
                        f.putAll(bj4Var.B());
                    }
                    JSONObject e = kk4.e(hm4Var);
                    if (e == null) {
                        bj4Var.C(new ak4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(ri4.b())) {
                        vn4.e().f();
                    }
                    a(e, bj4Var.y());
                    bj4Var.D();
                    ri4.b().M().b(ok4.d(), f, bj4Var.t(), e, new ul4(bj4Var, hm4Var));
                    return;
                }
                bj4Var.C(new ak4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(jm4 jm4Var, bj4 bj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jm4Var, bj4Var) == null) {
            synchronized (qi4.class) {
                if (b(jm4Var, bj4Var)) {
                    return;
                }
                HashMap<String, String> j = kk4.j(jm4Var);
                if (bj4Var.B() != null) {
                    j.putAll(bj4Var.B());
                }
                bj4Var.D();
                ri4.b().M().z(ok4.f(), j, bj4Var.t(), new wl4(bj4Var, jm4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (qi4.class) {
                c = gl4.b().c(str);
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
            synchronized (qi4.class) {
                d = gl4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(nm4 nm4Var, bj4 bj4Var, bj4 bj4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, nm4Var, bj4Var, bj4Var2) == null) {
            synchronized (qi4.class) {
                n(nm4Var, bj4Var, bj4Var2, null);
            }
        }
    }

    public static synchronized void n(nm4 nm4Var, bj4 bj4Var, bj4 bj4Var2, @Nullable do4 do4Var) {
        qm4<JSONArray> g;
        bj4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, nm4Var, bj4Var, bj4Var2, do4Var) == null) {
            synchronized (qi4.class) {
                if (b(nm4Var, bj4Var)) {
                    return;
                }
                if (PMSConstants.a(ri4.b())) {
                    vn4.e().f();
                }
                if (do4Var == null) {
                    g = null;
                } else {
                    g = do4Var.g();
                }
                if (do4Var == null) {
                    callback = null;
                } else {
                    callback = do4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (bj4Var.B() != null) {
                    hashMap.putAll(bj4Var.B());
                }
                bj4Var.D();
                ri4.b().M().b(ok4.g(), hashMap, bj4Var.t(), i(g, null), new yl4(bj4Var, nm4Var, bj4Var2, callback));
            }
        }
    }

    public static synchronized void o(do4 do4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, do4Var) == null) {
            synchronized (qi4.class) {
                if (do4Var == null) {
                    return;
                }
                bj4 callback = do4Var.getCallback();
                if (callback == null) {
                    return;
                }
                mm4 request = do4Var.getRequest();
                if (request == null) {
                    callback.C(new ak4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                ri4.b().M().b(ok4.g(), B, callback.t(), i(do4Var.g(), null), new yl4(callback, request, null, callback));
            }
        }
    }
}
