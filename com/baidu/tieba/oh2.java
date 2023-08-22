package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ph2;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable ph2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static ph2.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (ph2.a) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx1 a;

        public a(jx1 jx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh2.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948032176, "Lcom/baidu/tieba/oh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948032176, "Lcom/baidu/tieba/oh2;");
                return;
            }
        }
        a = nr1.a;
        ku2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        d82.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull jx1<?> jx1Var, @NonNull d13 d13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jx1Var, d13Var)) == null) {
            sb3 f = qw2.T().f(d13Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + d13Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + d13Var.d);
            }
            return xo3.S(jx1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static ph2.a b(@NonNull db3 db3Var, @NonNull jx1<?> jx1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, db3Var, jx1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = zt2.e.i(str, valueOf).getPath() + File.separator;
                    ph2 ph2Var = new ph2();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            d13 d = d13.d(vo3.g(str3), str2);
                            if (xo3.b(db3Var.Q(), d, true) && a(jx1Var, d)) {
                                ph2Var.a(f(jx1Var, d));
                            }
                        }
                    }
                    return ph2Var.b();
                }
            }
            return null;
        }
        return (ph2.a) invokeLLL.objValue;
    }

    public static d13 c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        la2 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            db3 b0 = db3.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed() || (H = qw2.T().H()) == null) {
                return null;
            }
            return H.o3();
        }
        return (d13) invokeV.objValue;
    }

    public static el2 f(jx1<?> jx1Var, d13 d13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jx1Var, d13Var)) == null) {
            return uh2.a(me3.a(jx1Var, d13Var, ""));
        }
        return (el2) invokeLL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            return zt2.C(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) {
            return i13.g().k(pMSAppInfo);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void i(jx1<?> jx1Var) {
        long j;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, jx1Var) != null) || !b || jx1Var == null) {
            return;
        }
        if (a) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        db3 b0 = db3.b0();
        if (b0 == null || (f0 = b0.W().f0()) == null) {
            return;
        }
        ph2.a e = e(f0);
        if (e == null) {
            e = b(b0, jx1Var, f0);
            d(f0, e);
        }
        if (e != null) {
            xh2.U().V0(jx1Var.a(), e);
        }
        if (a) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis - j) + "ms");
        }
    }

    public static void j(jx1<?> jx1Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, jx1Var) == null) && b && jx1Var != null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            ExecutorUtilsExt.postOnElastic(new a(jx1Var), "SwanAppSlaveTopPages", 2);
            if (a) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg async cost - " + (currentTimeMillis - j) + "ms");
            }
        }
    }

    public static Set<String> k(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            if (jSONObject.length() <= 0) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedHashSet.add(next);
                }
            }
            if (a) {
                Log.d("SwanAppSlaveTopPages", "get top pages - " + linkedHashSet);
            }
            return linkedHashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<String> m(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, pMSAppInfo)) == null) {
            if (a) {
                d13 c = c();
                Log.d("SwanAppSlaveTopPages", "current page - " + c);
            }
            JSONObject g = g(pMSAppInfo);
            if (g != null && g.length() > 0) {
                if (a) {
                    Log.d("SwanAppSlaveTopPages", "pages info - " + g);
                }
                return k(g);
            }
            return null;
        }
        return (Set) invokeL.objValue;
    }
}
