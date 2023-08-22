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
public class ni4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948003408, "Lcom/baidu/tieba/ni4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948003408, "Lcom/baidu/tieba/ni4;");
        }
    }

    public ni4() {
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

    public static boolean b(jm4 jm4Var, yi4 yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jm4Var, yi4Var)) == null) {
            if (yi4Var == null) {
                return true;
            }
            if (jm4Var == null) {
                yi4Var.C(new xj4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable nm4<JSONArray> nm4Var, @Nullable nm4<JSONObject> nm4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, nm4Var, nm4Var2)) == null) {
            return qm4.a(nm4Var, nm4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(km4 km4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, km4Var, yi4Var) == null) {
            synchronized (ni4.class) {
                m(km4Var, yi4Var, null);
            }
        }
    }

    public static synchronized void c(fm4 fm4Var, yi4 yi4Var) {
        mk4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fm4Var, yi4Var) == null) {
            synchronized (ni4.class) {
                if (b(fm4Var, yi4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(fm4Var.g())) {
                    yi4Var.C(new xj4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = hk4.i(fm4Var);
                if (yi4Var.B() != null) {
                    i.putAll(yi4Var.B());
                }
                yi4Var.D();
                if (fm4Var.n() == 1 && fm4Var.h() == 2101) {
                    M = oi4.b().n();
                } else {
                    M = oi4.b().M();
                }
                M.z(lk4.e(), i, yi4Var.t(), new sl4(fm4Var.g(), yi4Var, fm4Var));
            }
        }
    }

    public static synchronized void d(cm4 cm4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, cm4Var, yi4Var) == null) {
            synchronized (ni4.class) {
                if (b(cm4Var, yi4Var)) {
                    return;
                }
                if (cm4Var.f() != null && !cm4Var.f().isEmpty()) {
                    HashMap<String, String> f = hk4.f(cm4Var);
                    if (yi4Var.B() != null && f != null) {
                        f.putAll(yi4Var.B());
                    }
                    JSONObject d = hk4.d(cm4Var);
                    if (d == null) {
                        yi4Var.C(new xj4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, yi4Var.y());
                    yi4Var.D();
                    oi4.b().M().b(lk4.d(), f, yi4Var.t(), d, new ql4(yi4Var, cm4Var));
                    return;
                }
                yi4Var.C(new xj4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(im4 im4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, im4Var, yi4Var) == null) {
            synchronized (ni4.class) {
                if (b(im4Var, yi4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(im4Var.f())) {
                    yi4Var.C(new xj4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(im4Var.k())) {
                    yi4Var.C(new xj4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = hk4.k(im4Var);
                    if (yi4Var.B() != null) {
                        k.putAll(yi4Var.B());
                    }
                    yi4Var.D();
                    oi4.b().M().z(lk4.e(), k, yi4Var.t(), new ul4(im4Var.f(), yi4Var, im4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable si4 si4Var) {
        mi4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, si4Var) != null) || (b = oi4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            sn4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(lk4.c(), hashMap, null, jSONObject, new ti4(si4Var));
    }

    public static synchronized void f(em4 em4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, em4Var, yi4Var) == null) {
            synchronized (ni4.class) {
                if (b(em4Var, yi4Var)) {
                    return;
                }
                if (em4Var.f() != null && !em4Var.f().isEmpty()) {
                    HashMap<String, String> f = hk4.f(em4Var);
                    if (yi4Var.B() != null && f != null) {
                        f.putAll(yi4Var.B());
                    }
                    JSONObject e = hk4.e(em4Var);
                    if (e == null) {
                        yi4Var.C(new xj4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(oi4.b())) {
                        sn4.e().f();
                    }
                    a(e, yi4Var.y());
                    yi4Var.D();
                    oi4.b().M().b(lk4.d(), f, yi4Var.t(), e, new rl4(yi4Var, em4Var));
                    return;
                }
                yi4Var.C(new xj4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(gm4 gm4Var, yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, gm4Var, yi4Var) == null) {
            synchronized (ni4.class) {
                if (b(gm4Var, yi4Var)) {
                    return;
                }
                HashMap<String, String> j = hk4.j(gm4Var);
                if (yi4Var.B() != null) {
                    j.putAll(yi4Var.B());
                }
                yi4Var.D();
                oi4.b().M().z(lk4.f(), j, yi4Var.t(), new tl4(yi4Var, gm4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ni4.class) {
                c = dl4.b().c(str);
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
            synchronized (ni4.class) {
                d = dl4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(km4 km4Var, yi4 yi4Var, yi4 yi4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, km4Var, yi4Var, yi4Var2) == null) {
            synchronized (ni4.class) {
                n(km4Var, yi4Var, yi4Var2, null);
            }
        }
    }

    public static synchronized void n(km4 km4Var, yi4 yi4Var, yi4 yi4Var2, @Nullable ao4 ao4Var) {
        nm4<JSONArray> g;
        yi4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, km4Var, yi4Var, yi4Var2, ao4Var) == null) {
            synchronized (ni4.class) {
                if (b(km4Var, yi4Var)) {
                    return;
                }
                if (PMSConstants.a(oi4.b())) {
                    sn4.e().f();
                }
                if (ao4Var == null) {
                    g = null;
                } else {
                    g = ao4Var.g();
                }
                if (ao4Var == null) {
                    callback = null;
                } else {
                    callback = ao4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (yi4Var.B() != null) {
                    hashMap.putAll(yi4Var.B());
                }
                yi4Var.D();
                oi4.b().M().b(lk4.g(), hashMap, yi4Var.t(), i(g, null), new vl4(yi4Var, km4Var, yi4Var2, callback));
            }
        }
    }

    public static synchronized void o(ao4 ao4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ao4Var) == null) {
            synchronized (ni4.class) {
                if (ao4Var == null) {
                    return;
                }
                yi4 callback = ao4Var.getCallback();
                if (callback == null) {
                    return;
                }
                jm4 request = ao4Var.getRequest();
                if (request == null) {
                    callback.C(new xj4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                oi4.b().M().b(lk4.g(), B, callback.t(), i(ao4Var.g(), null), new vl4(callback, request, null, callback));
            }
        }
    }
}
