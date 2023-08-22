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
import com.baidu.tieba.ig3;
import com.baidu.tieba.mg3;
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
/* loaded from: classes7.dex */
public class lz1 extends iz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ lz1 g;

        public a(lz1 lz1Var, db3 db3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz1Var, db3Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = lz1Var;
            this.a = db3Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    if (lz1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    lz1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    wh3.S("check_fail", 1, "api");
                }
                int b = gg3Var.b();
                String f = bg3.f(b);
                lz1 lz1Var = this.g;
                lz1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new d32(b, bg3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements wp3<gg3<mg3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ db3 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, db3 db3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, db3Var, str2};
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
            this.g = db3Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<mg3.d> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                d82.k("LoginApi", "#handleLogin errCode=" + gg3Var.b() + " error=" + gg3Var.a());
                if (!gg3Var.c()) {
                    if (!this.a && this.b) {
                        wh3.S("fail", 1, this.c.optString("invokeFrom"));
                        d82.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = gg3Var.b();
                    d82.o("LoginApi", b + " " + this.d.toString());
                    String f = bg3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    lu2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    lz1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    d82.k("LoginApi", str);
                    wh3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    wh3.S("success", 1, this.c.optString("invokeFrom"));
                    d82.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (lz1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    d82.k("LoginApi", "Success: login success from component-invoking.");
                    wh3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                wh3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(gg3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    lu2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    lz1.J(this.g, 43, 1001, "empty code");
                    wh3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    lz1.E(optString, this.g, this.e, this.f, gg3Var, this.h);
                } else {
                    lz1.F(this.g, this.e, this.f, gg3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements wp3<pg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ db3 e;
        public final /* synthetic */ gg3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, db3 db3Var, gg3 gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, db3Var, gg3Var};
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
            this.e = db3Var;
            this.f = gg3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(pg3 pg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                if (pg3Var == null || !pg3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    d82.k("LoginApi", str);
                    wh3.U(this.d, "fail", str);
                    return;
                }
                lz1.F(this.e, this.a, this.b, this.f, this.d);
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
                d82.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947960070, "Lcom/baidu/tieba/lz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947960070, "Lcom/baidu/tieba/lz1;");
                return;
            }
        }
        f = nr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lz1(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(db3 db3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{db3Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = db3Var.N().e(activity);
            if (!e) {
                wh3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            db3Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, db3Var, str2), str2);
        }
    }

    public static void E(String str, db3 db3Var, CallbackHandler callbackHandler, String str2, gg3<mg3.d> gg3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, db3Var, callbackHandler, str2, gg3Var, str3}) == null) {
            SwanAppActivity w = db3Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                d82.k("LoginApi", "Error: activity is null from plugin-invoking.");
                wh3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = b73.f(str);
            pg3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, db3Var, gg3Var));
        }
    }

    public static void F(db3 db3Var, CallbackHandler callbackHandler, String str, gg3<mg3.d> gg3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, db3Var, callbackHandler, str, gg3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", gg3Var.a.a);
                d82.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                j93.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, gg3Var.b()).toString());
                wh3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                lu2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(db3Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                d82.k("LoginApi", str3);
                wh3.U(str2, "fail", str3);
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

    public static void J(db3 db3Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{db3Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || db3Var == null || (k = db3Var.k()) != 0) {
            return;
        }
        wm3 wm3Var = new wm3();
        wm3Var.k(5L);
        wm3Var.i(i);
        ei3 ei3Var = new ei3();
        ei3Var.p(wm3Var);
        ei3Var.r(db3Var.Y());
        ei3Var.q(wh3.n(k));
        ei3Var.m(db3.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        ei3Var.e(jSONObject);
        wh3.R(ei3Var);
    }

    public d32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            wh3.T("getLoginCode", "create");
            CallbackHandler e = a().e();
            db3 b0 = db3.b0();
            if (b0 == null) {
                lu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new d32(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                wh3.T("getLoginCode", "fail");
                return new d32(10004, "user not logged in");
            } else {
                JSONObject r = gz1.r(str);
                if (r == null) {
                    lu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    wh3.T("getLoginCode", "fail");
                    return new d32(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    lu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    wh3.T("getLoginCode", "fail");
                    return new d32(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    wh3.T("getLoginCode", "fail");
                    return new d32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!cb3.K().q().N().e(context)) {
                    wh3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, e, optString, false, "getLoginCode");
                return d32.f();
            }
        }
        return (d32) invokeL.objValue;
    }

    public d32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                d82.c("LoginApi", "swan app is null");
                return new d32(202, "swan app is null");
            }
            JSONObject d2 = r43.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    r43.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    d82.c("LoginApi", "json put data fail");
                    return new d32(1001);
                }
            }
            return new d32(0, d2);
        }
        return (d32) invokeV.objValue;
    }

    public d32 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            db3 b0 = db3.b0();
            CallbackHandler e = a().e();
            if (b0 == null) {
                lu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                d82.k("LoginApi", "Error: swan app is null");
                return new d32(1001, "swan app is null");
            }
            JSONObject r = gz1.r(str);
            if (r == null) {
                lu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new d32(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            wh3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                lu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new d32(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                lu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new d32(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new d32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!cb3.K().q().N().e(context)) {
                    wh3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, e, optString, true, str3);
                    return new d32(0);
                }
                if (!bg3.i(r)) {
                    D(b0, activity, r, e, optString, true, str3);
                } else {
                    cb3.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, e, optString, str3));
                }
                return d32.f();
            }
        }
        return (d32) invokeL.objValue;
    }
}
