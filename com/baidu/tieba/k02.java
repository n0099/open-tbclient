package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.hh3;
import com.baidu.tieba.lh3;
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
/* loaded from: classes6.dex */
public class k02 extends h02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ k02 g;

        public a(k02 k02Var, cc3 cc3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k02Var, cc3Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = k02Var;
            this.a = cc3Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (ah3.h(fh3Var)) {
                    if (k02.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    k02.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    vi3.S("check_fail", 1, "api");
                }
                int b = fh3Var.b();
                String f = ah3.f(b);
                k02 k02Var = this.g;
                k02Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new c42(b, ah3.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements vq3<fh3<lh3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ cc3 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, cc3 cc3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, cc3Var, str2};
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
            this.g = cc3Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<lh3.d> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                c92.k("LoginApi", "#handleLogin errCode=" + fh3Var.b() + " error=" + fh3Var.a());
                if (!fh3Var.c()) {
                    if (!this.a && this.b) {
                        vi3.S("fail", 1, this.c.optString("invokeFrom"));
                        c92.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = fh3Var.b();
                    c92.o("LoginApi", b + " " + this.d.toString());
                    String f = ah3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    kv2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    k02.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    c92.k("LoginApi", str);
                    vi3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    vi3.S("success", 1, this.c.optString("invokeFrom"));
                    c92.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (k02.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    c92.k("LoginApi", "Success: login success from component-invoking.");
                    vi3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                vi3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(fh3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    kv2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    k02.J(this.g, 43, 1001, "empty code");
                    vi3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    k02.E(optString, this.g, this.e, this.f, fh3Var, this.h);
                } else {
                    k02.F(this.g, this.e, this.f, fh3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements vq3<oh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cc3 e;
        public final /* synthetic */ fh3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, cc3 cc3Var, fh3 fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, cc3Var, fh3Var};
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
            this.e = cc3Var;
            this.f = fh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(oh3 oh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oh3Var) == null) {
                if (oh3Var == null || !oh3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    c92.k("LoginApi", str);
                    vi3.U(this.d, "fail", str);
                    return;
                }
                k02.F(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            this.a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.b = optLong;
            if (optLong < 0) {
                c92.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947859196, "Lcom/baidu/tieba/k02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947859196, "Lcom/baidu/tieba/k02;");
                return;
            }
        }
        f = ms1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k02(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(cc3 cc3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{cc3Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = cc3Var.N().e(activity);
            if (!e) {
                vi3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            cc3Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, cc3Var, str2), str2);
        }
    }

    public static void E(String str, cc3 cc3Var, CallbackHandler callbackHandler, String str2, fh3<lh3.d> fh3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, cc3Var, callbackHandler, str2, fh3Var, str3}) == null) {
            SwanAppActivity w = cc3Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                c92.k("LoginApi", "Error: activity is null from plugin-invoking.");
                vi3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = a83.f(str);
            oh3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, cc3Var, fh3Var));
        }
    }

    public static void F(cc3 cc3Var, CallbackHandler callbackHandler, String str, fh3<lh3.d> fh3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, cc3Var, callbackHandler, str, fh3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", fh3Var.a.a);
                c92.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                ia3.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, fh3Var.b()).toString());
                vi3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                kv2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(cc3Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                c92.k("LoginApi", str3);
                vi3.U(str2, "fail", str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            return "component".equals(jSONObject.optString("invokeFrom"));
        }
        return invokeL.booleanValue;
    }

    public static void J(cc3 cc3Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{cc3Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || cc3Var == null || (k = cc3Var.k()) != 0) {
            return;
        }
        vn3 vn3Var = new vn3();
        vn3Var.k(5L);
        vn3Var.i(i);
        dj3 dj3Var = new dj3();
        dj3Var.p(vn3Var);
        dj3Var.r(cc3Var.Y());
        dj3Var.q(vi3.n(k));
        dj3Var.m(cc3.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        dj3Var.e(jSONObject);
        vi3.R(dj3Var);
    }

    public c42 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            vi3.T("getLoginCode", "create");
            CallbackHandler e = a().e();
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                kv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new c42(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                vi3.T("getLoginCode", "fail");
                return new c42(10004, "user not logged in");
            } else {
                JSONObject r = f02.r(str);
                if (r == null) {
                    kv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    vi3.T("getLoginCode", "fail");
                    return new c42(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    kv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    vi3.T("getLoginCode", "fail");
                    return new c42(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    vi3.T("getLoginCode", "fail");
                    return new c42(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!bc3.K().q().N().e(context)) {
                    vi3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, e, optString, false, "getLoginCode");
                return c42.f();
            }
        }
        return (c42) invokeL.objValue;
    }

    public c42 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                c92.c("LoginApi", "swan app is null");
                return new c42(202, "swan app is null");
            }
            JSONObject d2 = q53.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    q53.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    c92.c("LoginApi", "json put data fail");
                    return new c42(1001);
                }
            }
            return new c42(0, d2);
        }
        return (c42) invokeV.objValue;
    }

    public c42 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            cc3 b0 = cc3.b0();
            CallbackHandler e = a().e();
            if (b0 == null) {
                kv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                c92.k("LoginApi", "Error: swan app is null");
                return new c42(1001, "swan app is null");
            }
            JSONObject r = f02.r(str);
            if (r == null) {
                kv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new c42(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            vi3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                kv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new c42(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                kv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new c42(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new c42(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!bc3.K().q().N().e(context)) {
                    vi3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, e, optString, true, str3);
                    return new c42(0);
                }
                if (!ah3.i(r)) {
                    D(b0, activity, r, e, optString, true, str3);
                } else {
                    bc3.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, e, optString, str3));
                }
                return c42.f();
            }
        }
        return (c42) invokeL.objValue;
    }
}
