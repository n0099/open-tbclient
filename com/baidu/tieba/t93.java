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
import com.baidu.tieba.t52;
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
/* loaded from: classes8.dex */
public final class t93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
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
            t52 W;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (W = xr2.V().W()) != null) {
                t52.b i = W.i(this.a);
                i.f();
                i.b();
                k32.k("ActionUtils", "popAllFragment: finish");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948135995, "Lcom/baidu/tieba/t93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948135995, "Lcom/baidu/tieba/t93;");
                return;
            }
        }
        a = vm1.a;
    }

    public static String h() {
        InterceptResult invokeV;
        rs1 v3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            s52 J = xr2.V().J();
            if (J == null || (v3 = J.v3()) == null) {
                return null;
            }
            return v3.l();
        }
        return (String) invokeV.objValue;
    }

    public static bd2 a(rs1<?> rs1Var, kw2 kw2Var, String str) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, rs1Var, kw2Var, str)) == null) {
            z63 f = xr2.V().f(kw2Var.d);
            bd2 bd2Var = new bd2();
            bd2Var.i = rs1Var.I();
            bd2Var.a = kw2Var.c;
            if (k63.M() != null) {
                bd2Var.c = k63.M().e0(kw2Var.d);
            }
            bd2Var.k = yc2.c(k63.M(), kw2Var.a);
            bd2Var.b = kw2.b(kw2Var);
            bd2Var.d = f.g;
            bd2Var.e = String.valueOf(h32.a());
            if (k63.M() != null) {
                String Y = k63.M().Y(kw2Var.d);
                if (!TextUtils.isEmpty(Y)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + Y);
                    }
                    bd2Var.f = Y;
                }
            }
            if (!a && !xr2.V().O()) {
                z = false;
            } else {
                z = true;
            }
            bd2Var.g = z;
            bd2Var.h = str;
            if (j23.H()) {
                bd2Var.j = n32.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            mg3.b(bd2Var.a, bd2Var.b);
            return bd2Var;
        }
        return (bd2) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull k63 k63Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, k63Var, str, str2, list)) == null) {
            String f = ck3.f(str);
            String o = ck3.o(str);
            String b = ca3.b(f);
            String d0 = k63Var.d0(f);
            String e0 = k63Var.e0(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject.put("root", d0);
                jSONObject.put("pageType", e0);
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
            k32.k("ActionUtils", "popAllFragment: routeType=" + str);
            ek3.e0(new a(str));
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

    /* JADX WARN: Type inference failed for: r7v2, types: [com.baidu.tieba.ss1] */
    public static void e(rs1<?> rs1Var, kw2 kw2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, rs1Var, kw2Var, str) == null) {
            oz2.a("route", "createAndLoadPage start.");
            String a2 = ek3.a(kw2Var.c, kw2Var.a, kw2Var.b);
            bd2 a3 = a(rs1Var, kw2Var, str);
            pz2.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            rj3.d();
            rs1Var.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, kw2Var.e());
            rs1Var.P(a3.b);
            xr2.V().n(rs1Var.a(), bd2.a(a3));
            if (cd2.b()) {
                cd2 cd2Var = new cd2();
                cd2Var.a = rs1Var.a();
                xr2.V().v(cd2.a(cd2Var));
            }
            uc3.F(rs1Var.a(), a3.b);
            pc2.o(a2, rs1Var);
            oz2.a("route", "createAndLoadPage end.");
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
            lg2 lg2Var = new lg2(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                xr2.V().v(lg2Var);
                return;
            }
            ad2 ad2Var = new ad2();
            ad2Var.t(createFromReLaunch);
            ad2Var.t(lg2Var);
            xr2.V().v(ad2Var);
        }
    }

    public static List<String> g(t52 t52Var) {
        InterceptResult invokeL;
        q52 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, t52Var)) == null) {
            if (t52Var == null || t52Var.k() < ew1.g || (j = t52Var.j(0)) == null || !(j instanceof s52)) {
                return null;
            }
            return ((s52) j).B3();
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
                String z1 = hr2.z1(h);
                String z12 = hr2.z1(str);
                if (TextUtils.equals(z1, z12) || TextUtils.equals(Uri.decode(z1), z12) || TextUtils.equals(z1, Uri.decode(z12))) {
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

    public static void k(lu1 lu1Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, lu1Var, str) != null) || lu1Var == null) {
            return;
        }
        lu1Var.d(str, new ly1(1001, "No Package"));
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, unitedSchemeEntity, str)) == null) {
            return n(unitedSchemeEntity, str, "url");
        }
        return (String) invokeLL.objValue;
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, k63Var, str, str2, list, str3}) == null) && k63Var != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(k63Var, str2, str, list), 0).toString(), str3);
        }
    }

    public static void m(lu1 lu1Var, k63 k63Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{lu1Var, k63Var, str, str2, list, str3}) == null) && lu1Var != null && k63Var != null && !TextUtils.isEmpty(str3)) {
            lu1Var.d(str3, new ly1(0, b(k63Var, str2, str, list)));
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
