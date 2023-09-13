package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.du2;
import com.baidu.tieba.th2;
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
public class sh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable th2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static th2.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (th2.a) invokeL.objValue;
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
        public final /* synthetic */ nx1 a;

        public a(nx1 nx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sh2.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151340, "Lcom/baidu/tieba/sh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151340, "Lcom/baidu/tieba/sh2;");
                return;
            }
        }
        a = rr1.a;
        ou2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        h82.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull nx1<?> nx1Var, @NonNull h13 h13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, nx1Var, h13Var)) == null) {
            wb3 f = uw2.T().f(h13Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + h13Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + h13Var.d);
            }
            return bp3.S(nx1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static th2.a b(@NonNull hb3 hb3Var, @NonNull nx1<?> nx1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, hb3Var, nx1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = du2.e.i(str, valueOf).getPath() + File.separator;
                    th2 th2Var = new th2();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            h13 d = h13.d(zo3.g(str3), str2);
                            if (bp3.b(hb3Var.Q(), d, true) && a(nx1Var, d)) {
                                th2Var.a(f(nx1Var, d));
                            }
                        }
                    }
                    return th2Var.b();
                }
            }
            return null;
        }
        return (th2.a) invokeLLL.objValue;
    }

    public static h13 c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        pa2 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed() || (H = uw2.T().H()) == null) {
                return null;
            }
            return H.o3();
        }
        return (h13) invokeV.objValue;
    }

    public static il2 f(nx1<?> nx1Var, h13 h13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, nx1Var, h13Var)) == null) {
            return yh2.a(qe3.a(nx1Var, h13Var, ""));
        }
        return (il2) invokeLL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            return du2.C(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) {
            return m13.g().k(pMSAppInfo);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void i(nx1<?> nx1Var) {
        long j;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, nx1Var) != null) || !b || nx1Var == null) {
            return;
        }
        if (a) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        hb3 b0 = hb3.b0();
        if (b0 == null || (f0 = b0.W().f0()) == null) {
            return;
        }
        th2.a e = e(f0);
        if (e == null) {
            e = b(b0, nx1Var, f0);
            d(f0, e);
        }
        if (e != null) {
            bi2.U().V0(nx1Var.a(), e);
        }
        if (a) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis - j) + "ms");
        }
    }

    public static void j(nx1<?> nx1Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, nx1Var) == null) && b && nx1Var != null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            ExecutorUtilsExt.postOnElastic(new a(nx1Var), "SwanAppSlaveTopPages", 2);
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
                h13 c = c();
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
