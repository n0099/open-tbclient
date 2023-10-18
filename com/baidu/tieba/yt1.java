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
import com.baidu.tieba.ua3;
import com.baidu.tieba.ya3;
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
/* loaded from: classes9.dex */
public class yt1 extends vt1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p53 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ yt1 g;

        public a(yt1 yt1Var, p53 p53Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt1Var, p53Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = yt1Var;
            this.a = p53Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (na3.h(sa3Var)) {
                    if (yt1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    yt1.E(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    ic3.S("check_fail", 1, "api");
                }
                int b = sa3Var.b();
                String f = na3.f(b);
                yt1 yt1Var = this.g;
                yt1Var.q("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new qx1(b, na3.f(b)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements ik3<sa3<ya3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ p53 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, p53 p53Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, p53Var, str2};
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
            this.g = p53Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ya3.d> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                p22.k("LoginApi", "#handleLogin errCode=" + sa3Var.b() + " error=" + sa3Var.a());
                if (!sa3Var.c()) {
                    if (!this.a && this.b) {
                        ic3.S("fail", 1, this.c.optString("invokeFrom"));
                        p22.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = sa3Var.b();
                    p22.o("LoginApi", b + " " + this.d.toString());
                    String f = na3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    xo2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    yt1.K(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    p22.k("LoginApi", str);
                    ic3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    ic3.S("success", 1, this.c.optString("invokeFrom"));
                    p22.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (yt1.H(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    p22.k("LoginApi", "Success: login success from component-invoking.");
                    ic3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                ic3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(sa3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    xo2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    yt1.K(this.g, 43, 1001, "empty code");
                    ic3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    yt1.F(optString, this.g, this.e, this.f, sa3Var, this.h);
                } else {
                    yt1.G(this.g, this.e, this.f, sa3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements ik3<bb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ p53 e;
        public final /* synthetic */ sa3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, p53 p53Var, sa3 sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, p53Var, sa3Var};
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
            this.e = p53Var;
            this.f = sa3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(bb3 bb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bb3Var) == null) {
                if (bb3Var == null || !bb3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    p22.k("LoginApi", str);
                    ic3.U(this.d, "fail", str);
                    return;
                }
                yt1.G(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
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
                p22.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948341587, "Lcom/baidu/tieba/yt1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948341587, "Lcom/baidu/tieba/yt1;");
                return;
            }
        }
        f = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yt1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
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

    public static void E(p53 p53Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{p53Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = p53Var.N().e(activity);
            if (!e) {
                ic3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            p53Var.f0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, p53Var, str2), str2);
        }
    }

    public static void F(String str, p53 p53Var, CallbackHandler callbackHandler, String str2, sa3<ya3.d> sa3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, p53Var, callbackHandler, str2, sa3Var, str3}) == null) {
            SwanAppActivity w = p53Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                p22.k("LoginApi", "Error: activity is null from plugin-invoking.");
                ic3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = n13.f(str);
            bb3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, p53Var, sa3Var));
        }
    }

    public static void G(p53 p53Var, CallbackHandler callbackHandler, String str, sa3<ya3.d> sa3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, p53Var, callbackHandler, str, sa3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", sa3Var.a.a);
                p22.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                v33.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, sa3Var.b()).toString());
                ic3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                xo2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                K(p53Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                p22.k("LoginApi", str3);
                ic3.U(str2, "fail", str3);
            }
        }
    }

    public static void K(p53 p53Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{p53Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || p53Var == null || (k = p53Var.k()) != 0) {
            return;
        }
        ih3 ih3Var = new ih3();
        ih3Var.k(5L);
        ih3Var.i(i);
        qc3 qc3Var = new qc3();
        qc3Var.p(ih3Var);
        qc3Var.r(p53Var.Z());
        qc3Var.q(ic3.n(k));
        qc3Var.m(p53.h0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CloudStabilityUBCUtils.KEY_ERROR_CODE, i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        qc3Var.e(jSONObject);
        ic3.R(qc3Var);
    }

    public qx1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            ic3.T("getLoginCode", "create");
            CallbackHandler f2 = a().f();
            p53 c0 = p53.c0();
            if (c0 == null) {
                xo2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new qx1(1001, "swan app is null");
            } else if (!c0.N().e(i())) {
                ic3.T("getLoginCode", "fail");
                return new qx1(10004, "user not logged in");
            } else {
                JSONObject s = tt1.s(str);
                if (s == null) {
                    xo2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    K(c0, 1, 201, "empty joParams");
                    ic3.T("getLoginCode", "fail");
                    return new qx1(201, "empty joParams");
                }
                String optString = s.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    xo2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    K(c0, 1, 201, "cb is empty");
                    ic3.T("getLoginCode", "fail");
                    return new qx1(201, "cb is empty");
                }
                Context i = i();
                if (!(i instanceof Activity) && (i = c0.w()) == null) {
                    ic3.T("getLoginCode", "fail");
                    return new qx1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) i;
                if (!o53.K().q().N().e(i)) {
                    ic3.T("getLoginCode", "passLogin");
                }
                E(c0, activity, s, f2, optString, false, "getLoginCode");
                return qx1.f();
            }
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#isLoginSync", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                p22.c("LoginApi", "swan app is null");
                return new qx1(202, "swan app is null");
            }
            JSONObject d2 = dz2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", c0.N().e(i()));
                    dz2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    p22.c("LoginApi", "json put data fail");
                    return new qx1(1001);
                }
            }
            return new qx1(0, d2);
        }
        return (qx1) invokeV.objValue;
    }

    public qx1 J(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#login params=" + str, false);
            p53 c0 = p53.c0();
            CallbackHandler f2 = a().f();
            if (c0 == null) {
                xo2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                p22.k("LoginApi", "Error: swan app is null");
                return new qx1(1001, "swan app is null");
            }
            JSONObject s = tt1.s(str);
            if (s == null) {
                xo2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                K(c0, 1, 201, "empty joParams");
                q("Error: empty joParams", null, true);
                return new qx1(201, "empty joParams");
            }
            if (s.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            ic3.T(str3, "create");
            String optString = s.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                xo2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                K(c0, 1, 201, "cb is empty");
                q("Error: cb is empty", null, true);
                return new qx1(201, "cb is empty");
            } else if (!s.optBoolean(UpgradeInfo.KEY_INT_FORCE_UPGRADE, true) && !c0.N().e(i())) {
                f2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                xo2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                K(c0, 43, 10004, "user not logged in");
                r("Success: force login is false, will not force execute login.", false);
                return new qx1(0);
            } else {
                Context i = i();
                if (!(i instanceof Activity) && (i = c0.w()) == null) {
                    q("Error: context is not an activity", null, false);
                    return new qx1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) i;
                if (!o53.K().q().N().e(i)) {
                    ic3.T(str3, "passLogin");
                }
                String optString2 = s.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    q("handleLogin by plugin: " + optString2, null, false);
                    E(c0, activity, s, f2, optString, true, str3);
                    return new qx1(0);
                }
                if (!na3.i(s)) {
                    E(c0, activity, s, f2, optString, true, str3);
                } else {
                    o53.K().q().f0().g(i(), "scope_login_api", new a(this, c0, activity, s, f2, optString, str3));
                }
                return qx1.f();
            }
        }
        return (qx1) invokeL.objValue;
    }
}
