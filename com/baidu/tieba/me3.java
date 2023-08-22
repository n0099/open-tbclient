package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ma2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class me3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ma2 U;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (U = qw2.T().U()) != null) {
                ma2.b i = U.i(this.a);
                i.f();
                i.b();
                d82.k("ActionUtils", "popAllFragment: finish");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969742, "Lcom/baidu/tieba/me3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969742, "Lcom/baidu/tieba/me3;");
                return;
            }
        }
        a = nr1.a;
    }

    public static String h() {
        InterceptResult invokeV;
        jx1 q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            la2 H = qw2.T().H();
            if (H == null || (q3 = H.q3()) == null) {
                return null;
            }
            return q3.l();
        }
        return (String) invokeV.objValue;
    }

    public static uh2 a(jx1<?> jx1Var, d13 d13Var, String str) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jx1Var, d13Var, str)) == null) {
            sb3 f = qw2.T().f(d13Var.d);
            uh2 uh2Var = new uh2();
            uh2Var.i = jx1Var.I();
            uh2Var.a = d13Var.c;
            if (db3.M() != null) {
                uh2Var.c = db3.M().d0(d13Var.d);
            }
            uh2Var.k = rh2.c(db3.M(), d13Var.a);
            uh2Var.b = d13.b(d13Var);
            uh2Var.d = f.g;
            uh2Var.e = String.valueOf(a82.a());
            if (db3.M() != null) {
                String X = db3.M().X(d13Var.d);
                if (!TextUtils.isEmpty(X)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + X);
                    }
                    uh2Var.f = X;
                }
            }
            if (!a && !qw2.T().M()) {
                z = false;
            } else {
                z = true;
            }
            uh2Var.g = z;
            uh2Var.h = str;
            if (c73.H()) {
                uh2Var.j = g82.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            fl3.b(uh2Var.a, uh2Var.b);
            return uh2Var;
        }
        return (uh2) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull db3 db3Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, db3Var, str, str2, list)) == null) {
            String f = vo3.f(str);
            String o = vo3.o(str);
            String b = ve3.b(f);
            String c0 = db3Var.c0(f);
            String d0 = db3Var.d0(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject.put("root", c0);
                jSONObject.put("pageType", d0);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str);
                }
                if (!TextUtils.equals(f, b)) {
                    if (!TextUtils.isEmpty(o)) {
                        b = b + "?" + o;
                    }
                    jSONObject.put("pageRoutePath", b);
                }
                if (list != null && !list.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : list) {
                        jSONArray.put(str3);
                    }
                    jSONObject.put("removedSlaveIDs", jSONArray);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return d(str, "");
        }
        return (JSONObject) invokeL.objValue;
    }

    @Nullable
    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.optString("url");
        }
        return (String) invokeL.objValue;
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            d82.k("ActionUtils", "popAllFragment: routeType=" + str);
            xo3.e0(new a(str));
        }
    }

    public static JSONObject d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.baidu.tieba.kx1] */
    public static void e(jx1<?> jx1Var, d13 d13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, jx1Var, d13Var, str) == null) {
            h43.a("route", "createAndLoadPage start.");
            String a2 = xo3.a(d13Var.c, d13Var.a, d13Var.b);
            uh2 a3 = a(jx1Var, d13Var, str);
            i43.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            ko3.d();
            jx1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d13Var.e());
            jx1Var.Q(a3.b);
            qw2.T().m(jx1Var.a(), uh2.a(a3));
            if (vh2.b()) {
                vh2 vh2Var = new vh2();
                vh2Var.a = jx1Var.a();
                qw2.T().u(vh2.a(vh2Var));
            }
            nh3.F(jx1Var.a(), a3.b);
            ih2.o(a2, jx1Var);
            h43.a("route", "createAndLoadPage end.");
        }
    }

    public static void f(String str, String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("from", str2);
            }
            hashMap.put("url", str3);
            el2 el2Var = new el2(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                qw2.T().u(el2Var);
                return;
            }
            th2 th2Var = new th2();
            th2Var.t(createFromReLaunch);
            th2Var.t(el2Var);
            qw2.T().u(th2Var);
        }
    }

    public static List<String> g(ma2 ma2Var) {
        InterceptResult invokeL;
        ja2 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, ma2Var)) == null) {
            if (ma2Var == null || ma2Var.k() < w02.g || (j = ma2Var.j(0)) == null || !(j instanceof la2)) {
                return null;
            }
            return ((la2) j).w3();
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String h = h();
            if (a) {
                Log.i("ActionUtils", "lastPageUrl: " + h + "\ncurPageUrl: " + str);
            }
            if (h != null && str != null) {
                String x1 = aw2.x1(h);
                String x12 = aw2.x1(str);
                if (TextUtils.equals(x1, x12) || TextUtils.equals(Uri.decode(x1), x12) || TextUtils.equals(x1, Uri.decode(x12))) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, unitedSchemeEntity, callbackHandler, str) == null) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
        }
    }

    public static void k(dz1 dz1Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, dz1Var, str) != null) || dz1Var == null) {
            return;
        }
        dz1Var.d(str, new d32(1001, "No Package"));
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, unitedSchemeEntity, str)) == null) {
            return n(unitedSchemeEntity, str, "url");
        }
        return (String) invokeLL.objValue;
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, db3Var, str, str2, list, str3}) == null) && db3Var != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(db3Var, str2, str, list), 0).toString(), str3);
        }
    }

    public static void m(dz1 dz1Var, db3 db3Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{dz1Var, db3Var, str, str2, list, str3}) == null) && dz1Var != null && db3Var != null && !TextUtils.isEmpty(str3)) {
            dz1Var.d(str3, new d32(0, b(db3Var, str2, str, list)));
        }
    }

    public static String n(UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, unitedSchemeEntity, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = unitedSchemeEntity.getParams().get(str);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                return new JSONObject(str3).optString(str2);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
