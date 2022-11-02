package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.an2;
import com.baidu.tieba.qa2;
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
/* loaded from: classes5.dex */
public class pa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable qa2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static qa2.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (qa2.a) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq1 a;

        public a(kq1 kq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pa2.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055240, "Lcom/baidu/tieba/pa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055240, "Lcom/baidu/tieba/pa2;");
                return;
            }
        }
        a = ok1.a;
        ln2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        e12.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull kq1<?> kq1Var, @NonNull eu2 eu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, kq1Var, eu2Var)) == null) {
            t43 f = rp2.U().f(eu2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + eu2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + eu2Var.d);
            }
            return yh3.S(kq1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static qa2.a b(@NonNull e43 e43Var, @NonNull kq1<?> kq1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, e43Var, kq1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = an2.e.i(str, valueOf).getPath() + File.separator;
                    qa2 qa2Var = new qa2();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            eu2 d = eu2.d(wh3.g(str3), str2);
                            if (yh3.b(e43Var.Q(), d, true) && a(kq1Var, d)) {
                                qa2Var.a(f(kq1Var, d));
                            }
                        }
                    }
                    return qa2Var.b();
                }
            }
            return null;
        }
        return (qa2.a) invokeLLL.objValue;
    }

    public static eu2 c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        m32 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            e43 b0 = e43.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed() || (H = rp2.U().H()) == null) {
                return null;
            }
            return H.m3();
        }
        return (eu2) invokeV.objValue;
    }

    public static fe2 f(kq1<?> kq1Var, eu2 eu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, kq1Var, eu2Var)) == null) {
            return va2.a(n73.a(kq1Var, eu2Var, ""));
        }
        return (fe2) invokeLL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            return an2.C(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) {
            return ju2.g().k(pMSAppInfo);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void i(kq1<?> kq1Var) {
        long j;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, kq1Var) != null) || !b || kq1Var == null) {
            return;
        }
        if (a) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        e43 b0 = e43.b0();
        if (b0 == null || (f0 = b0.W().f0()) == null) {
            return;
        }
        qa2.a e = e(f0);
        if (e == null) {
            e = b(b0, kq1Var, f0);
            d(f0, e);
        }
        if (e != null) {
            ya2.U().V0(kq1Var.a(), e);
        }
        if (a) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis - j) + "ms");
        }
    }

    public static void j(kq1<?> kq1Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, kq1Var) == null) && b && kq1Var != null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            ExecutorUtilsExt.postOnElastic(new a(kq1Var), "SwanAppSlaveTopPages", 2);
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
                eu2 c = c();
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
