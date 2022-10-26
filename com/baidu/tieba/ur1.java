package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.v83;
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
public class ur1 extends rr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m33 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ur1 g;

        public a(ur1 ur1Var, m33 m33Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur1Var, m33Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ur1Var;
            this.a = m33Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (k83.h(p83Var)) {
                    if (ur1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    ur1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    fa3.S("check_fail", 1, "api");
                }
                int b = p83Var.b();
                String f = k83.f(b);
                ur1 ur1Var = this.g;
                ur1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new mv1(b, k83.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ m33 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, m33 m33Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, m33Var, str2};
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
            this.g = m33Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                m02.k("LoginApi", "#handleLogin errCode=" + p83Var.b() + " error=" + p83Var.a());
                if (!p83Var.c()) {
                    if (!this.a && this.b) {
                        fa3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        m02.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = p83Var.b();
                    m02.o("LoginApi", b + " " + this.d.toString());
                    String f = k83.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    um2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    ur1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    m02.k("LoginApi", str);
                    fa3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    fa3.S("success", 1, this.c.optString("invokeFrom"));
                    m02.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (ur1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    m02.k("LoginApi", "Success: login success from component-invoking.");
                    fa3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                fa3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(((v83.d) p83Var.a).a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    um2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    ur1.J(this.g, 43, 1001, "empty code");
                    fa3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    ur1.E(optString, this.g, this.e, this.f, p83Var, this.h);
                } else {
                    ur1.F(this.g, this.e, this.f, p83Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ m33 e;
        public final /* synthetic */ p83 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, m33 m33Var, p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, m33Var, p83Var};
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
            this.e = m33Var;
            this.f = p83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(y83 y83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y83Var) == null) {
                if (y83Var == null || !y83Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    m02.k("LoginApi", str);
                    fa3.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                ur1.F(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final long b;

        public d(JSONObject jSONObject) {
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
                m02.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948220501, "Lcom/baidu/tieba/ur1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948220501, "Lcom/baidu/tieba/ur1;");
                return;
            }
        }
        f = wj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(m33 m33Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{m33Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = m33Var.N().e(activity);
            if (!e) {
                fa3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            m33Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, m33Var, str2), str2);
        }
    }

    public static void E(String str, m33 m33Var, CallbackHandler callbackHandler, String str2, p83 p83Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, m33Var, callbackHandler, str2, p83Var, str3}) == null) {
            SwanAppActivity w = m33Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                m02.k("LoginApi", "Error: activity is null from plugin-invoking.");
                fa3.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = kz2.f(str);
            y83.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, m33Var, p83Var));
        }
    }

    public static void F(m33 m33Var, CallbackHandler callbackHandler, String str, p83 p83Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, m33Var, callbackHandler, str, p83Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", ((v83.d) p83Var.a).a);
                m02.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                s13.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, p83Var.b()).toString());
                fa3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                um2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(m33Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                m02.k("LoginApi", str3);
                fa3.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
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

    public static void J(m33 m33Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{m33Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || m33Var == null || (k = m33Var.k()) != 0) {
            return;
        }
        ff3 ff3Var = new ff3();
        ff3Var.k(5L);
        ff3Var.i(i);
        na3 na3Var = new na3();
        na3Var.p(ff3Var);
        na3Var.r(m33Var.Y());
        na3Var.q(fa3.n(k));
        na3Var.m(m33.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        na3Var.e(jSONObject);
        fa3.R(na3Var);
    }

    public mv1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            fa3.T("getLoginCode", "create");
            CallbackHandler g = a().g();
            m33 b0 = m33.b0();
            if (b0 == null) {
                um2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new mv1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                fa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new mv1(10004, "user not logged in");
            } else {
                JSONObject r = pr1.r(str);
                if (r == null) {
                    um2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    fa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new mv1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    um2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    fa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new mv1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    fa3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new mv1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!l33.K().q().N().e(context)) {
                    fa3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, g, optString, false, "getLoginCode");
                return mv1.f();
            }
        }
        return (mv1) invokeL.objValue;
    }

    public mv1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            m33 b0 = m33.b0();
            if (b0 == null) {
                m02.c("LoginApi", "swan app is null");
                return new mv1(202, "swan app is null");
            }
            JSONObject d2 = ax2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    ax2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    m02.c("LoginApi", "json put data fail");
                    return new mv1(1001);
                }
            }
            return new mv1(0, d2);
        }
        return (mv1) invokeV.objValue;
    }

    public mv1 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            m33 b0 = m33.b0();
            CallbackHandler g = a().g();
            if (b0 == null) {
                um2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                m02.k("LoginApi", "Error: swan app is null");
                return new mv1(1001, "swan app is null");
            }
            JSONObject r = pr1.r(str);
            if (r == null) {
                um2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new mv1(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals(NativeConstants.COMPONENT)) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            fa3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                um2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new mv1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                g.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                um2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new mv1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new mv1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!l33.K().q().N().e(context)) {
                    fa3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, g, optString, true, str3);
                    return new mv1(0);
                }
                if (!k83.i(r)) {
                    D(b0, activity, r, g, optString, true, str3);
                } else {
                    l33.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, g, optString, str3));
                }
                return mv1.f();
            }
        }
        return (mv1) invokeL.objValue;
    }
}
