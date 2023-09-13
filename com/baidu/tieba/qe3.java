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
import com.baidu.tieba.qa2;
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
public final class qe3 {
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
            qa2 U;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (U = uw2.T().U()) != null) {
                qa2.b i = U.i(this.a);
                i.f();
                i.b();
                h82.k("ActionUtils", "popAllFragment: finish");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948088906, "Lcom/baidu/tieba/qe3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948088906, "Lcom/baidu/tieba/qe3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static String h() {
        InterceptResult invokeV;
        nx1 q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            pa2 H = uw2.T().H();
            if (H == null || (q3 = H.q3()) == null) {
                return null;
            }
            return q3.l();
        }
        return (String) invokeV.objValue;
    }

    public static yh2 a(nx1<?> nx1Var, h13 h13Var, String str) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nx1Var, h13Var, str)) == null) {
            wb3 f = uw2.T().f(h13Var.d);
            yh2 yh2Var = new yh2();
            yh2Var.i = nx1Var.I();
            yh2Var.a = h13Var.c;
            if (hb3.M() != null) {
                yh2Var.c = hb3.M().d0(h13Var.d);
            }
            yh2Var.k = vh2.c(hb3.M(), h13Var.a);
            yh2Var.b = h13.b(h13Var);
            yh2Var.d = f.g;
            yh2Var.e = String.valueOf(e82.a());
            if (hb3.M() != null) {
                String X = hb3.M().X(h13Var.d);
                if (!TextUtils.isEmpty(X)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + X);
                    }
                    yh2Var.f = X;
                }
            }
            if (!a && !uw2.T().M()) {
                z = false;
            } else {
                z = true;
            }
            yh2Var.g = z;
            yh2Var.h = str;
            if (g73.H()) {
                yh2Var.j = k82.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            jl3.b(yh2Var.a, yh2Var.b);
            return yh2Var;
        }
        return (yh2) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull hb3 hb3Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, hb3Var, str, str2, list)) == null) {
            String f = zo3.f(str);
            String o = zo3.o(str);
            String b = ze3.b(f);
            String c0 = hb3Var.c0(f);
            String d0 = hb3Var.d0(f);
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
            h82.k("ActionUtils", "popAllFragment: routeType=" + str);
            bp3.e0(new a(str));
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

    /* JADX WARN: Type inference failed for: r7v2, types: [com.baidu.tieba.ox1] */
    public static void e(nx1<?> nx1Var, h13 h13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, nx1Var, h13Var, str) == null) {
            l43.a("route", "createAndLoadPage start.");
            String a2 = bp3.a(h13Var.c, h13Var.a, h13Var.b);
            yh2 a3 = a(nx1Var, h13Var, str);
            m43.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            oo3.d();
            nx1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, h13Var.e());
            nx1Var.Q(a3.b);
            uw2.T().m(nx1Var.a(), yh2.a(a3));
            if (zh2.b()) {
                zh2 zh2Var = new zh2();
                zh2Var.a = nx1Var.a();
                uw2.T().u(zh2.a(zh2Var));
            }
            rh3.F(nx1Var.a(), a3.b);
            mh2.o(a2, nx1Var);
            l43.a("route", "createAndLoadPage end.");
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
            il2 il2Var = new il2(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                uw2.T().u(il2Var);
                return;
            }
            xh2 xh2Var = new xh2();
            xh2Var.t(createFromReLaunch);
            xh2Var.t(il2Var);
            uw2.T().u(xh2Var);
        }
    }

    public static List<String> g(qa2 qa2Var) {
        InterceptResult invokeL;
        na2 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, qa2Var)) == null) {
            if (qa2Var == null || qa2Var.k() < a12.g || (j = qa2Var.j(0)) == null || !(j instanceof pa2)) {
                return null;
            }
            return ((pa2) j).w3();
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
                String x1 = ew2.x1(h);
                String x12 = ew2.x1(str);
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

    public static void k(hz1 hz1Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, hz1Var, str) != null) || hz1Var == null) {
            return;
        }
        hz1Var.d(str, new h32(1001, "No Package"));
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, unitedSchemeEntity, str)) == null) {
            return n(unitedSchemeEntity, str, "url");
        }
        return (String) invokeLL.objValue;
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, hb3Var, str, str2, list, str3}) == null) && hb3Var != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(hb3Var, str2, str, list), 0).toString(), str3);
        }
    }

    public static void m(hz1 hz1Var, hb3 hb3Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{hz1Var, hb3Var, str, str2, list, str3}) == null) && hz1Var != null && hb3Var != null && !TextUtils.isEmpty(str3)) {
            hz1Var.d(str3, new h32(0, b(hb3Var, str2, str, list)));
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
