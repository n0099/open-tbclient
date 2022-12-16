package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.j93;
import com.baidu.tieba.n93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ms1 extends js1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e43 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ms1 g;

        public a(ms1 ms1Var, e43 e43Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms1Var, e43Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ms1Var;
            this.a = e43Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (c93.h(h93Var)) {
                    if (ms1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    ms1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    xa3.S("check_fail", 1, "api");
                }
                int b = h93Var.b();
                String f = c93.f(b);
                ms1 ms1Var = this.g;
                ms1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new ew1(b, c93.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements xi3<h93<n93.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ e43 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, e43 e43Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, e43Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = z2;
            this.c = jSONObject;
            this.d = dVar;
            this.e = callbackHandler;
            this.f = str;
            this.g = e43Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<n93.d> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                e12.k("LoginApi", "#handleLogin errCode=" + h93Var.b() + " error=" + h93Var.a());
                if (!h93Var.c()) {
                    if (!this.a && this.b) {
                        xa3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        e12.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = h93Var.b();
                    e12.o("LoginApi", b + " " + this.d.toString());
                    String f = c93.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    mn2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    ms1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    e12.k("LoginApi", str);
                    xa3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    xa3.S("success", 1, this.c.optString("invokeFrom"));
                    e12.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (ms1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    e12.k("LoginApi", "Success: login success from component-invoking.");
                    xa3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                xa3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(h93Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    mn2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    ms1.J(this.g, 43, 1001, "empty code");
                    xa3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    ms1.E(optString, this.g, this.e, this.f, h93Var, this.h);
                } else {
                    ms1.F(this.g, this.e, this.f, h93Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements xi3<q93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ e43 e;
        public final /* synthetic */ h93 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, e43 e43Var, h93 h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, e43Var, h93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = e43Var;
            this.f = h93Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(q93 q93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q93Var) == null) {
                if (q93Var == null || !q93Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    e12.k("LoginApi", str);
                    xa3.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                ms1.F(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final long b;

        public d(@NonNull JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject.has(com.alipay.sdk.data.a.O);
            long optLong = jSONObject.optLong(com.alipay.sdk.data.a.O, 0L);
            this.b = optLong;
            if (optLong < 0) {
                e12.o("LoginApi", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.a + ", timeoutMills=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983134, "Lcom/baidu/tieba/ms1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983134, "Lcom/baidu/tieba/ms1;");
                return;
            }
        }
        f = ok1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ms1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(e43 e43Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{e43Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = e43Var.N().e(activity);
            if (!e) {
                xa3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            e43Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, e43Var, str2), str2);
        }
    }

    public static void E(String str, e43 e43Var, CallbackHandler callbackHandler, String str2, h93<n93.d> h93Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, e43Var, callbackHandler, str2, h93Var, str3}) == null) {
            SwanAppActivity w = e43Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                e12.k("LoginApi", "Error: activity is null from plugin-invoking.");
                xa3.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = c03.f(str);
            q93.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, e43Var, h93Var));
        }
    }

    public static void F(e43 e43Var, CallbackHandler callbackHandler, String str, h93<n93.d> h93Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, e43Var, callbackHandler, str, h93Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", h93Var.a.a);
                e12.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                k23.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, h93Var.b()).toString());
                xa3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                mn2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(e43Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                e12.k("LoginApi", str3);
                xa3.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            return NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom"));
        }
        return invokeL.booleanValue;
    }

    public static void J(e43 e43Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{e43Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || e43Var == null || (k = e43Var.k()) != 0) {
            return;
        }
        xf3 xf3Var = new xf3();
        xf3Var.k(5L);
        xf3Var.i(i);
        fb3 fb3Var = new fb3();
        fb3Var.p(xf3Var);
        fb3Var.r(e43Var.Y());
        fb3Var.q(xa3.n(k));
        fb3Var.m(e43.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        fb3Var.e(jSONObject);
        xa3.R(fb3Var);
    }

    public ew1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            xa3.T("getLoginCode", "create");
            CallbackHandler g = a().g();
            e43 b0 = e43.b0();
            if (b0 == null) {
                mn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new ew1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                xa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new ew1(10004, "user not logged in");
            } else {
                JSONObject r = hs1.r(str);
                if (r == null) {
                    mn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    xa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new ew1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    mn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    xa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new ew1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    xa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new ew1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!d43.K().q().N().e(context)) {
                    xa3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, g, optString, false, "getLoginCode");
                return ew1.f();
            }
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                e12.c("LoginApi", "swan app is null");
                return new ew1(202, "swan app is null");
            }
            JSONObject d2 = sx2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    sx2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    e12.c("LoginApi", "json put data fail");
                    return new ew1(1001);
                }
            }
            return new ew1(0, d2);
        }
        return (ew1) invokeV.objValue;
    }

    public ew1 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            e43 b0 = e43.b0();
            CallbackHandler g = a().g();
            if (b0 == null) {
                mn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                e12.k("LoginApi", "Error: swan app is null");
                return new ew1(1001, "swan app is null");
            }
            JSONObject r = hs1.r(str);
            if (r == null) {
                mn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new ew1(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals(NativeConstants.COMPONENT)) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            xa3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                mn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new ew1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                g.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                mn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new ew1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new ew1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!d43.K().q().N().e(context)) {
                    xa3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, g, optString, true, str3);
                    return new ew1(0);
                }
                if (!c93.i(r)) {
                    D(b0, activity, r, g, optString, true, str3);
                } else {
                    d43.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, g, optString, str3));
                }
                return ew1.f();
            }
        }
        return (ew1) invokeL.objValue;
    }
}
