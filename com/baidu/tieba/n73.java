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
import com.baidu.tieba.n32;
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
/* loaded from: classes5.dex */
public final class n73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
            n32 V;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (V = rp2.U().V()) != null) {
                n32.b i = V.i(this.a);
                i.f();
                i.b();
                e12.k("ActionUtils", "popAllFragment: finish");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955327, "Lcom/baidu/tieba/n73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955327, "Lcom/baidu/tieba/n73;");
                return;
            }
        }
        a = ok1.a;
    }

    public static String h() {
        InterceptResult invokeV;
        kq1 o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            m32 H = rp2.U().H();
            if (H == null || (o3 = H.o3()) == null) {
                return null;
            }
            return o3.m();
        }
        return (String) invokeV.objValue;
    }

    public static va2 a(kq1<?> kq1Var, eu2 eu2Var, String str) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, kq1Var, eu2Var, str)) == null) {
            t43 f = rp2.U().f(eu2Var.d);
            va2 va2Var = new va2();
            va2Var.i = kq1Var.K();
            va2Var.a = eu2Var.c;
            if (e43.M() != null) {
                va2Var.c = e43.M().d0(eu2Var.d);
            }
            va2Var.k = sa2.c(e43.M(), eu2Var.a);
            va2Var.b = eu2.b(eu2Var);
            va2Var.d = f.g;
            va2Var.e = String.valueOf(b12.a());
            if (e43.M() != null) {
                String X = e43.M().X(eu2Var.d);
                if (!TextUtils.isEmpty(X)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + X);
                    }
                    va2Var.f = X;
                }
            }
            if (!a && !rp2.U().N()) {
                z = false;
            } else {
                z = true;
            }
            va2Var.g = z;
            va2Var.h = str;
            if (d03.H()) {
                va2Var.j = h12.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            ge3.b(va2Var.a, va2Var.b);
            return va2Var;
        }
        return (va2) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull e43 e43Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, e43Var, str, str2, list)) == null) {
            String f = wh3.f(str);
            String o = wh3.o(str);
            String b = w73.b(f);
            String c0 = e43Var.c0(f);
            String d0 = e43Var.d0(f);
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
            e12.k("ActionUtils", "popAllFragment: routeType=" + str);
            yh3.e0(new a(str));
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

    /* JADX WARN: Type inference failed for: r7v2, types: [com.baidu.tieba.lq1] */
    public static void e(kq1<?> kq1Var, eu2 eu2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, kq1Var, eu2Var, str) == null) {
            ix2.a("route", "createAndLoadPage start.");
            String a2 = yh3.a(eu2Var.c, eu2Var.a, eu2Var.b);
            va2 a3 = a(kq1Var, eu2Var, str);
            jx2.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            lh3.d();
            kq1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, eu2Var.e());
            kq1Var.R(a3.b);
            rp2.U().m(kq1Var.a(), va2.a(a3));
            if (wa2.b()) {
                wa2 wa2Var = new wa2();
                wa2Var.a = kq1Var.a();
                rp2.U().u(wa2.a(wa2Var));
            }
            oa3.F(kq1Var.a(), a3.b);
            ja2.o(a2, kq1Var);
            ix2.a("route", "createAndLoadPage end.");
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
            fe2 fe2Var = new fe2(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                rp2.U().u(fe2Var);
                return;
            }
            ua2 ua2Var = new ua2();
            ua2Var.t(createFromReLaunch);
            ua2Var.t(fe2Var);
            rp2.U().u(ua2Var);
        }
    }

    public static List<String> g(n32 n32Var) {
        InterceptResult invokeL;
        k32 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, n32Var)) == null) {
            if (n32Var == null || n32Var.k() < xt1.g || (j = n32Var.j(0)) == null || !(j instanceof m32)) {
                return null;
            }
            return ((m32) j).u3();
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
                String x1 = bp2.x1(h);
                String x12 = bp2.x1(str);
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

    public static void k(es1 es1Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, es1Var, str) != null) || es1Var == null) {
            return;
        }
        es1Var.d(str, new ew1(1001, "No Package"));
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, unitedSchemeEntity, str)) == null) {
            return n(unitedSchemeEntity, str, "url");
        }
        return (String) invokeLL.objValue;
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, e43Var, str, str2, list, str3}) == null) && e43Var != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(e43Var, str2, str, list), 0).toString(), str3);
        }
    }

    public static void m(es1 es1Var, e43 e43Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{es1Var, e43Var, str, str2, list, str3}) == null) && es1Var != null && e43Var != null && !TextUtils.isEmpty(str3)) {
            es1Var.d(str3, new ew1(0, b(e43Var, str2, str, list)));
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
