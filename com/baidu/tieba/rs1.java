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
import com.baidu.tieba.o93;
import com.baidu.tieba.s93;
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
public class rs1 extends os1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ms1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements cj3<m93<o93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j43 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ rs1 g;

        public a(rs1 rs1Var, j43 j43Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs1Var, j43Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = rs1Var;
            this.a = j43Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<o93.e> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                if (h93.h(m93Var)) {
                    if (rs1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    rs1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    cb3.S("check_fail", 1, "api");
                }
                int b = m93Var.b();
                String f = h93.f(b);
                rs1 rs1Var = this.g;
                rs1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new jw1(b, h93.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements cj3<m93<s93.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ j43 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, j43 j43Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, j43Var, str2};
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
            this.g = j43Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<s93.d> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                j12.k("LoginApi", "#handleLogin errCode=" + m93Var.b() + " error=" + m93Var.a());
                if (!m93Var.c()) {
                    if (!this.a && this.b) {
                        cb3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        j12.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = m93Var.b();
                    j12.o("LoginApi", b + " " + this.d.toString());
                    String f = h93.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    rn2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    rs1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    j12.k("LoginApi", str);
                    cb3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    cb3.S("success", 1, this.c.optString("invokeFrom"));
                    j12.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (rs1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    j12.k("LoginApi", "Success: login success from component-invoking.");
                    cb3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                cb3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(m93Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    rn2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    rs1.J(this.g, 43, 1001, "empty code");
                    cb3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    rs1.E(optString, this.g, this.e, this.f, m93Var, this.h);
                } else {
                    rs1.F(this.g, this.e, this.f, m93Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements cj3<v93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ j43 e;
        public final /* synthetic */ m93 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, j43 j43Var, m93 m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, j43Var, m93Var};
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
            this.e = j43Var;
            this.f = m93Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(v93 v93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v93Var) == null) {
                if (v93Var == null || !v93Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    j12.k("LoginApi", str);
                    cb3.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                rs1.F(this.e, this.a, this.b, this.f, this.d);
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
            this.a = jSONObject.has(com.alipay.sdk.data.a.O);
            long optLong = jSONObject.optLong(com.alipay.sdk.data.a.O, 0L);
            this.b = optLong;
            if (optLong < 0) {
                j12.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948132089, "Lcom/baidu/tieba/rs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948132089, "Lcom/baidu/tieba/rs1;");
                return;
            }
        }
        f = tk1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rs1(@NonNull ks1 ks1Var) {
        super(ks1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ks1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(j43 j43Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{j43Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = j43Var.N().e(activity);
            if (!e) {
                cb3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            j43Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, j43Var, str2), str2);
        }
    }

    public static void E(String str, j43 j43Var, CallbackHandler callbackHandler, String str2, m93<s93.d> m93Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, j43Var, callbackHandler, str2, m93Var, str3}) == null) {
            SwanAppActivity w = j43Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                j12.k("LoginApi", "Error: activity is null from plugin-invoking.");
                cb3.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = h03.f(str);
            v93.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, j43Var, m93Var));
        }
    }

    public static void F(j43 j43Var, CallbackHandler callbackHandler, String str, m93<s93.d> m93Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, j43Var, callbackHandler, str, m93Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", m93Var.a.a);
                j12.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                p23.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, m93Var.b()).toString());
                cb3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                rn2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(j43Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                j12.k("LoginApi", str3);
                cb3.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
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

    public static void J(j43 j43Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{j43Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || j43Var == null || (k = j43Var.k()) != 0) {
            return;
        }
        cg3 cg3Var = new cg3();
        cg3Var.k(5L);
        cg3Var.i(i);
        kb3 kb3Var = new kb3();
        kb3Var.p(cg3Var);
        kb3Var.r(j43Var.Y());
        kb3Var.q(cb3.n(k));
        kb3Var.m(j43.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        kb3Var.e(jSONObject);
        cb3.R(kb3Var);
    }

    public jw1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            cb3.T("getLoginCode", "create");
            CallbackHandler g = a().g();
            j43 b0 = j43.b0();
            if (b0 == null) {
                rn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new jw1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                cb3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new jw1(10004, "user not logged in");
            } else {
                JSONObject r = ms1.r(str);
                if (r == null) {
                    rn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    cb3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new jw1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    rn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    cb3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new jw1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    cb3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new jw1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!i43.K().q().N().e(context)) {
                    cb3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, g, optString, false, "getLoginCode");
                return jw1.f();
            }
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            j43 b0 = j43.b0();
            if (b0 == null) {
                j12.c("LoginApi", "swan app is null");
                return new jw1(202, "swan app is null");
            }
            JSONObject d2 = xx2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    xx2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    j12.c("LoginApi", "json put data fail");
                    return new jw1(1001);
                }
            }
            return new jw1(0, d2);
        }
        return (jw1) invokeV.objValue;
    }

    public jw1 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            j43 b0 = j43.b0();
            CallbackHandler g = a().g();
            if (b0 == null) {
                rn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                j12.k("LoginApi", "Error: swan app is null");
                return new jw1(1001, "swan app is null");
            }
            JSONObject r = ms1.r(str);
            if (r == null) {
                rn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new jw1(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals(NativeConstants.COMPONENT)) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            cb3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                rn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new jw1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                g.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                rn2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new jw1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new jw1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!i43.K().q().N().e(context)) {
                    cb3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, g, optString, true, str3);
                    return new jw1(0);
                }
                if (!h93.i(r)) {
                    D(b0, activity, r, g, optString, true, str3);
                } else {
                    i43.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, g, optString, str3));
                }
                return jw1.f();
            }
        }
        return (jw1) invokeL.objValue;
    }
}
