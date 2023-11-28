package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.task.UpgradeInfo;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.mb3;
import com.baidu.tieba.qb3;
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
/* loaded from: classes8.dex */
public class qu1 extends nu1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lu1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements al3<kb3<mb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h63 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ qu1 g;

        public a(qu1 qu1Var, h63 h63Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu1Var, h63Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = qu1Var;
            this.a = h63Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(kb3<mb3.e> kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) {
                if (fb3.h(kb3Var)) {
                    if (qu1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    qu1.E(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    ad3.S("check_fail", 1, "api");
                }
                int b = kb3Var.b();
                String f = fb3.f(b);
                qu1 qu1Var = this.g;
                qu1Var.q("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new iy1(b, fb3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements al3<kb3<qb3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ h63 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, h63 h63Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, h63Var, str2};
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
            this.g = h63Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(kb3<qb3.d> kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) {
                h32.k("LoginApi", "#handleLogin errCode=" + kb3Var.b() + " error=" + kb3Var.a());
                if (!kb3Var.c()) {
                    if (!this.a && this.b) {
                        ad3.S("fail", 1, this.c.optString("invokeFrom"));
                        h32.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = kb3Var.b();
                    h32.o("LoginApi", b + " " + this.d.toString());
                    String f = fb3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    pp2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    qu1.K(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    h32.k("LoginApi", str);
                    ad3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    ad3.S("success", 1, this.c.optString("invokeFrom"));
                    h32.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (qu1.H(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    h32.k("LoginApi", "Success: login success from component-invoking.");
                    ad3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                ad3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(kb3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    pp2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    qu1.K(this.g, 43, 1001, "empty code");
                    ad3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    qu1.F(optString, this.g, this.e, this.f, kb3Var, this.h);
                } else {
                    qu1.G(this.g, this.e, this.f, kb3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements al3<tb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ h63 e;
        public final /* synthetic */ kb3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, h63 h63Var, kb3 kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, h63Var, kb3Var};
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
            this.e = h63Var;
            this.f = kb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(tb3 tb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tb3Var) == null) {
                if (tb3Var == null || !tb3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    h32.k("LoginApi", str);
                    ad3.U(this.d, "fail", str);
                    return;
                }
                qu1.G(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                h32.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104220, "Lcom/baidu/tieba/qu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104220, "Lcom/baidu/tieba/qu1;");
                return;
            }
        }
        f = sm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu1(@NonNull ju1 ju1Var) {
        super(ju1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ju1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean H(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            return "component".equals(jSONObject.optString("invokeFrom"));
        }
        return invokeL.booleanValue;
    }

    public static void E(h63 h63Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{h63Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = h63Var.N().e(activity);
            if (!e) {
                ad3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            h63Var.f0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, h63Var, str2), str2);
        }
    }

    public static void F(String str, h63 h63Var, CallbackHandler callbackHandler, String str2, kb3<qb3.d> kb3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, h63Var, callbackHandler, str2, kb3Var, str3}) == null) {
            SwanAppActivity w = h63Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                h32.k("LoginApi", "Error: activity is null from plugin-invoking.");
                ad3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = f23.f(str);
            tb3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, h63Var, kb3Var));
        }
    }

    public static void G(h63 h63Var, CallbackHandler callbackHandler, String str, kb3<qb3.d> kb3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, h63Var, callbackHandler, str, kb3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", kb3Var.a.a);
                h32.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                n43.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, kb3Var.b()).toString());
                ad3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                pp2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                K(h63Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                h32.k("LoginApi", str3);
                ad3.U(str2, "fail", str3);
            }
        }
    }

    public static void K(h63 h63Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{h63Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || h63Var == null || (k = h63Var.k()) != 0) {
            return;
        }
        ai3 ai3Var = new ai3();
        ai3Var.k(5L);
        ai3Var.i(i);
        id3 id3Var = new id3();
        id3Var.p(ai3Var);
        id3Var.r(h63Var.Z());
        id3Var.q(ad3.n(k));
        id3Var.m(h63.h0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CloudStabilityUBCUtils.KEY_ERROR_CODE, i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        id3Var.e(jSONObject);
        ad3.R(id3Var);
    }

    public iy1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            ad3.T("getLoginCode", "create");
            CallbackHandler f2 = a().f();
            h63 c0 = h63.c0();
            if (c0 == null) {
                pp2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new iy1(1001, "swan app is null");
            } else if (!c0.N().e(i())) {
                ad3.T("getLoginCode", "fail");
                return new iy1(10004, "user not logged in");
            } else {
                JSONObject s = lu1.s(str);
                if (s == null) {
                    pp2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    K(c0, 1, 201, "empty joParams");
                    ad3.T("getLoginCode", "fail");
                    return new iy1(201, "empty joParams");
                }
                String optString = s.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    pp2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    K(c0, 1, 201, "cb is empty");
                    ad3.T("getLoginCode", "fail");
                    return new iy1(201, "cb is empty");
                }
                Context i = i();
                if (!(i instanceof Activity) && (i = c0.w()) == null) {
                    ad3.T("getLoginCode", "fail");
                    return new iy1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) i;
                if (!g63.K().q().N().e(i)) {
                    ad3.T("getLoginCode", "passLogin");
                }
                E(c0, activity, s, f2, optString, false, "getLoginCode");
                return iy1.f();
            }
        }
        return (iy1) invokeL.objValue;
    }

    public iy1 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#isLoginSync", false);
            h63 c0 = h63.c0();
            if (c0 == null) {
                h32.c("LoginApi", "swan app is null");
                return new iy1(202, "swan app is null");
            }
            JSONObject d2 = vz2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", c0.N().e(i()));
                    vz2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    h32.c("LoginApi", "json put data fail");
                    return new iy1(1001);
                }
            }
            return new iy1(0, d2);
        }
        return (iy1) invokeV.objValue;
    }

    public iy1 J(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#login params=" + str, false);
            h63 c0 = h63.c0();
            CallbackHandler f2 = a().f();
            if (c0 == null) {
                pp2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                h32.k("LoginApi", "Error: swan app is null");
                return new iy1(1001, "swan app is null");
            }
            JSONObject s = lu1.s(str);
            if (s == null) {
                pp2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                K(c0, 1, 201, "empty joParams");
                q("Error: empty joParams", null, true);
                return new iy1(201, "empty joParams");
            }
            if (s.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            ad3.T(str3, "create");
            String optString = s.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                pp2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                K(c0, 1, 201, "cb is empty");
                q("Error: cb is empty", null, true);
                return new iy1(201, "cb is empty");
            } else if (!s.optBoolean(UpgradeInfo.KEY_INT_FORCE_UPGRADE, true) && !c0.N().e(i())) {
                f2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                pp2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                K(c0, 43, 10004, "user not logged in");
                r("Success: force login is false, will not force execute login.", false);
                return new iy1(0);
            } else {
                Context i = i();
                if (!(i instanceof Activity) && (i = c0.w()) == null) {
                    q("Error: context is not an activity", null, false);
                    return new iy1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) i;
                if (!g63.K().q().N().e(i)) {
                    ad3.T(str3, "passLogin");
                }
                String optString2 = s.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    q("handleLogin by plugin: " + optString2, null, false);
                    E(c0, activity, s, f2, optString, true, str3);
                    return new iy1(0);
                }
                if (!fb3.i(s)) {
                    E(c0, activity, s, f2, optString, true, str3);
                } else {
                    g63.K().q().f0().g(i(), "scope_login_api", new a(this, c0, activity, s, f2, optString, str3));
                }
                return iy1.f();
            }
        }
        return (iy1) invokeL.objValue;
    }
}
