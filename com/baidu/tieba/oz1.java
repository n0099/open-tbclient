package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.lg3;
import com.baidu.tieba.pg3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oz1 extends lz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements zp3<jg3<lg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ oz1 g;

        public a(oz1 oz1Var, gb3 gb3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, gb3Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = oz1Var;
            this.a = gb3Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(jg3<lg3.e> jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jg3Var) == null) {
                if (eg3.h(jg3Var)) {
                    if (oz1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    oz1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    zh3.S("check_fail", 1, "api");
                }
                int b = jg3Var.b();
                String f = eg3.f(b);
                oz1 oz1Var = this.g;
                oz1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new g32(b, eg3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements zp3<jg3<pg3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ gb3 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, gb3 gb3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, gb3Var, str2};
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
            this.g = gb3Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(jg3<pg3.d> jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jg3Var) == null) {
                g82.k("LoginApi", "#handleLogin errCode=" + jg3Var.b() + " error=" + jg3Var.a());
                if (!jg3Var.c()) {
                    if (!this.a && this.b) {
                        zh3.S("fail", 1, this.c.optString("invokeFrom"));
                        g82.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = jg3Var.b();
                    g82.o("LoginApi", b + " " + this.d.toString());
                    String f = eg3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    ou2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    oz1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    g82.k("LoginApi", str);
                    zh3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    zh3.S("success", 1, this.c.optString("invokeFrom"));
                    g82.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (oz1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    g82.k("LoginApi", "Success: login success from component-invoking.");
                    zh3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                zh3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(jg3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    ou2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    oz1.J(this.g, 43, 1001, "empty code");
                    zh3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    oz1.E(optString, this.g, this.e, this.f, jg3Var, this.h);
                } else {
                    oz1.F(this.g, this.e, this.f, jg3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements zp3<sg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ gb3 e;
        public final /* synthetic */ jg3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, gb3 gb3Var, jg3 jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, gb3Var, jg3Var};
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
            this.e = gb3Var;
            this.f = jg3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(sg3 sg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sg3Var) == null) {
                if (sg3Var == null || !sg3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    g82.k("LoginApi", str);
                    zh3.U(this.d, "fail", str);
                    return;
                }
                oz1.F(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                g82.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948049443, "Lcom/baidu/tieba/oz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948049443, "Lcom/baidu/tieba/oz1;");
                return;
            }
        }
        f = qr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oz1(@NonNull hz1 hz1Var) {
        super(hz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(gb3 gb3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gb3Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = gb3Var.N().e(activity);
            if (!e) {
                zh3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            gb3Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, gb3Var, str2), str2);
        }
    }

    public static void E(String str, gb3 gb3Var, CallbackHandler callbackHandler, String str2, jg3<pg3.d> jg3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, gb3Var, callbackHandler, str2, jg3Var, str3}) == null) {
            SwanAppActivity w = gb3Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                g82.k("LoginApi", "Error: activity is null from plugin-invoking.");
                zh3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = e73.f(str);
            sg3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, gb3Var, jg3Var));
        }
    }

    public static void F(gb3 gb3Var, CallbackHandler callbackHandler, String str, jg3<pg3.d> jg3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, gb3Var, callbackHandler, str, jg3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", jg3Var.a.a);
                g82.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                m93.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, jg3Var.b()).toString());
                zh3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                ou2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(gb3Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                g82.k("LoginApi", str3);
                zh3.U(str2, "fail", str3);
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

    public static void J(gb3 gb3Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{gb3Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || gb3Var == null || (k = gb3Var.k()) != 0) {
            return;
        }
        zm3 zm3Var = new zm3();
        zm3Var.k(5L);
        zm3Var.i(i);
        hi3 hi3Var = new hi3();
        hi3Var.p(zm3Var);
        hi3Var.r(gb3Var.Y());
        hi3Var.q(zh3.n(k));
        hi3Var.m(gb3.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CloudStabilityUBCUtils.KEY_ERROR_CODE, i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        hi3Var.e(jSONObject);
        zh3.R(hi3Var);
    }

    public g32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            zh3.T("getLoginCode", "create");
            CallbackHandler f2 = a().f();
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                ou2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new g32(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                zh3.T("getLoginCode", "fail");
                return new g32(10004, "user not logged in");
            } else {
                JSONObject r = jz1.r(str);
                if (r == null) {
                    ou2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    zh3.T("getLoginCode", "fail");
                    return new g32(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ou2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    zh3.T("getLoginCode", "fail");
                    return new g32(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    zh3.T("getLoginCode", "fail");
                    return new g32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!fb3.K().q().N().e(context)) {
                    zh3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, f2, optString, false, "getLoginCode");
                return g32.f();
            }
        }
        return (g32) invokeL.objValue;
    }

    public g32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                g82.c("LoginApi", "swan app is null");
                return new g32(202, "swan app is null");
            }
            JSONObject d2 = u43.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    u43.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    g82.c("LoginApi", "json put data fail");
                    return new g32(1001);
                }
            }
            return new g32(0, d2);
        }
        return (g32) invokeV.objValue;
    }

    public g32 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            gb3 b0 = gb3.b0();
            CallbackHandler f2 = a().f();
            if (b0 == null) {
                ou2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                g82.k("LoginApi", "Error: swan app is null");
                return new g32(1001, "swan app is null");
            }
            JSONObject r = jz1.r(str);
            if (r == null) {
                ou2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new g32(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            zh3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ou2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new g32(201, "cb is empty");
            } else if (!r.optBoolean("force", true) && !b0.N().e(getContext())) {
                f2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                ou2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new g32(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new g32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!fb3.K().q().N().e(context)) {
                    zh3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, f2, optString, true, str3);
                    return new g32(0);
                }
                if (!eg3.i(r)) {
                    D(b0, activity, r, f2, optString, true, str3);
                } else {
                    fb3.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, f2, optString, str3));
                }
                return g32.f();
            }
        }
        return (g32) invokeL.objValue;
    }
}
