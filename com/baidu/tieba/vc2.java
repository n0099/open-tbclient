package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.gp2;
import com.baidu.tieba.wc2;
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
/* loaded from: classes8.dex */
public class vc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable wc2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static wc2.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (wc2.a) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs1 a;

        public a(rs1 rs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vc2.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948235908, "Lcom/baidu/tieba/vc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948235908, "Lcom/baidu/tieba/vc2;");
                return;
            }
        }
        a = vm1.a;
        rp2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        k32.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull rs1<?> rs1Var, @NonNull kw2 kw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, rs1Var, kw2Var)) == null) {
            z63 f = xr2.V().f(kw2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + kw2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + kw2Var.d);
            }
            return ek3.S(rs1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static wc2.a b(@NonNull k63 k63Var, @NonNull rs1<?> rs1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, k63Var, rs1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = gp2.e.i(str, valueOf).getPath() + File.separator;
                    wc2 wc2Var = new wc2();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            kw2 d = kw2.d(ck3.g(str3), str2);
                            if (ek3.b(k63Var.R(), d, true) && a(rs1Var, d)) {
                                wc2Var.a(f(rs1Var, d));
                            }
                        }
                    }
                    return wc2Var.b();
                }
            }
            return null;
        }
        return (wc2.a) invokeLLL.objValue;
    }

    public static kw2 c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        s52 J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null || (w = c0.w()) == null || w.isFinishing() || w.isDestroyed() || (J = xr2.V().J()) == null) {
                return null;
            }
            return J.t3();
        }
        return (kw2) invokeV.objValue;
    }

    public static lg2 f(rs1<?> rs1Var, kw2 kw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, rs1Var, kw2Var)) == null) {
            return bd2.a(t93.a(rs1Var, kw2Var, ""));
        }
        return (lg2) invokeLL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            return gp2.C(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) {
            return pw2.g().k(pMSAppInfo);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void i(rs1<?> rs1Var) {
        long j;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, rs1Var) != null) || !b || rs1Var == null) {
            return;
        }
        if (a) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        k63 c0 = k63.c0();
        if (c0 == null || (g0 = c0.X().g0()) == null) {
            return;
        }
        wc2.a e = e(g0);
        if (e == null) {
            e = b(c0, rs1Var, g0);
            d(g0, e);
        }
        if (e != null) {
            ed2.V().W0(rs1Var.a(), e);
        }
        if (a) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis - j) + ms.c);
        }
    }

    public static void j(rs1<?> rs1Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, rs1Var) == null) && b && rs1Var != null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            ExecutorUtilsExt.postOnElastic(new a(rs1Var), "SwanAppSlaveTopPages", 2);
            if (a) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg async cost - " + (currentTimeMillis - j) + ms.c);
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
                kw2 c = c();
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
