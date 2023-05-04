package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.b73;
import com.baidu.tieba.cd3;
import com.baidu.tieba.fe3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class vc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, d> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context e = vc3.e();
                Toast.makeText(e, "aiapps-oauth :: " + this.a, 0).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc3 a;

        public b(xc3 xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                if (i != -2) {
                    if (i == -1) {
                        vc3.k("onPosBtn", Boolean.FALSE);
                        qe3.q("click", this.a.b, true);
                        vc3.d(this.a.b, true);
                    }
                } else {
                    vc3.k("onNegBtn", Boolean.FALSE);
                    qe3.q("click", this.a.b, false);
                    vc3.d(this.a.b, false);
                }
                fr2.n().a("na_authorize_end");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc3 a;

        public c(xc3 xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc3Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                vc3.k("onCancel", Boolean.FALSE);
                qe3.q("click", this.a.b, false);
                vc3.d(this.a.b, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<sc3> a;

        public d(String str) {
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
            this.a = new HashSet();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948235939, "Lcom/baidu/tieba/vc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948235939, "Lcom/baidu/tieba/vc3;");
                return;
            }
        }
        a = ho1.a;
        b = new HashMap();
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            b.clear();
        }
    }

    public static void k(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, bool) == null) {
            x42.k("aiapps-oauth", str);
            if (a && bool.booleanValue()) {
                rl3.a0(new a(str));
            }
        }
    }

    public static synchronized void t(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            synchronized (vc3.class) {
                s(10004, str, str2);
            }
        }
    }

    public static RequestBody b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    key = "";
                }
                if (TextUtils.isEmpty(value)) {
                    value = "";
                }
                if (a) {
                    k("query :: " + key + " = " + value, Boolean.FALSE);
                }
                builder.add(key, value);
            }
            return builder.build();
        }
        return (RequestBody) invokeL.objValue;
    }

    public static JSONObject c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            String C = er2.o().C();
            if (jSONObject != null && !TextUtils.isEmpty(C)) {
                return jSONObject.optJSONObject(C);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean h(ad3<cd3.e> ad3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ad3Var)) == null) {
            if (ad3Var != null && ad3Var.c() && ad3Var.a.b) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), "api");
        }
        return invokeL.booleanValue;
    }

    public static boolean j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), NativeConstants.COMPONENT);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void l(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, runnable) == null) {
            rl3.a0(runnable);
        }
    }

    public static void d(String str, boolean z) {
        d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z) == null) {
            synchronized (b) {
                remove = b.remove(str);
            }
            if (remove != null && !remove.a.isEmpty()) {
                for (sc3 sc3Var : remove.a) {
                    if (sc3Var != null) {
                        sc3Var.onResult(z);
                    }
                }
            }
        }
    }

    public static String f(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            switch (i) {
                case 10001:
                    str = "internal error";
                    break;
                case 10002:
                    str = SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR;
                    break;
                case 10003:
                    str = "user deny";
                    break;
                case 10004:
                    str = "user not logged in";
                    break;
                case 10005:
                    str = "system deny";
                    break;
                case 10006:
                    str = "no data";
                    break;
                default:
                    str = "Permission denied";
                    break;
            }
            if (a) {
                Log.w("OAuthUtils", i + " " + str);
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String g() {
        InterceptResult invokeV;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                PackageInfo packageInfo = e().getPackageManager().getPackageInfo(e().getPackageName(), 64);
                if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                    return "";
                }
                return do4.d(signatureArr[0].toByteArray(), false);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static synchronized void m(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, jSONObject) == null) {
            synchronized (vc3.class) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("code")) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject.put("data", jSONObject2);
                    } catch (JSONException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void n(jd3 jd3Var, CallbackHandler callbackHandler, String str) {
        qj3 qj3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, null, jd3Var, callbackHandler, str) == null) && jd3Var != null && (qj3Var = jd3Var.j) != null) {
            int i = -1;
            try {
                i = (int) qj3Var.a();
            } catch (ClassCastException e) {
                if (a) {
                    Log.e("OAuthUtils", e.toString());
                }
            }
            if (i < 0) {
                return;
            }
            o(i, callbackHandler, str);
        }
    }

    public static void o(int i, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(65551, null, i, callbackHandler, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String f = f(i);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, f).toString());
        x42.o("OAuthUtils", "authorize failed : " + f);
    }

    public static void p(ad3<cd3.e> ad3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, ad3Var, callbackHandler, unitedSchemeEntity) == null) {
            if (ad3Var != null && ad3Var.a() != null) {
                int b2 = ad3Var.b();
                String f = f(b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f));
                x42.o("OAuthUtils", "authorize failed : " + f);
                return;
            }
            x42.c("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void q(ad3<cd3.e> ad3Var, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, ad3Var, callbackHandler, str) == null) {
            if (ad3Var != null && ad3Var.a() != null) {
                o(ad3Var.b(), callbackHandler, str);
            } else {
                x42.c("OAuthUtils", "authorize failed : result is invalid");
            }
        }
    }

    public static void s(int i, @NonNull String str, @NonNull String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65555, null, i, str, str2) == null) {
            try {
                String g0 = x73.g0();
                if (TextUtils.isEmpty(g0)) {
                    g0 = "NotSwanAppProcess";
                }
                String str4 = str + "===";
                if (str2.length() > 1024) {
                    str3 = (str4 + str2.substring(0, 1024)) + StringHelper.STRING_MORE;
                } else {
                    str3 = str4 + str2;
                }
                fe3.b bVar = new fe3.b(i);
                bVar.h(g0);
                bVar.i(str3);
                bVar.m();
                x42.k("OAuthUtils", "error reported: " + i + " ,content: " + str3);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void u(Context context, x73 x73Var, xc3 xc3Var, JSONObject jSONObject, sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65557, null, context, x73Var, xc3Var, jSONObject, sc3Var) == null) {
            if (xc3Var != null && !TextUtils.isEmpty(xc3Var.b)) {
                synchronized (b) {
                    d dVar = b.get(xc3Var.b);
                    if (dVar != null) {
                        dVar.a.add(sc3Var);
                        return;
                    }
                    d dVar2 = new d(xc3Var.b);
                    dVar2.a.add(sc3Var);
                    b.put(xc3Var.b, dVar2);
                    b bVar = new b(xc3Var);
                    c cVar = new c(xc3Var);
                    qe3.q("show", xc3Var.b, false);
                    fr2.n().a("na_authorize_start");
                    v(context, x73Var, xc3Var, jSONObject, bVar, cVar);
                    return;
                }
            }
            sc3Var.onResult(false);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void v(Context context, x73 x73Var, xc3 xc3Var, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, x73Var, xc3Var, jSONObject, onClickListener, onCancelListener}) == null) {
            b73.a a2 = er2.i0().a(context, x73Var, xc3Var, jSONObject, onClickListener);
            if (a2 == null) {
                if (!a) {
                    return;
                }
                throw new RuntimeException("auth dialog builder is null");
            }
            b73 c2 = a2.c();
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003a3);
            }
            if (x73Var == null) {
                w = null;
            } else {
                w = x73Var.w();
            }
            if (w != null && !w.isFinishing()) {
                c2.show();
            }
        }
    }
}
