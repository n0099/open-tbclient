package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.hr2;
import com.baidu.tieba.nu1;
import com.baidu.tieba.ou1;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class kw1 extends iw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends nu1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ kw1 e;

        /* renamed from: com.baidu.tieba.kw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0383a implements dl3<nb3<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nu1.b a;

            public C0383a(a aVar, nu1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(nb3<JSONObject> nb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                    if (nb3Var.c() && nb3Var.a != null) {
                        this.a.a(new ly1(0, nb3Var.a));
                        k63 q = j63.K().q();
                        q.f0().B(h.a(q), nb3Var.a.toString());
                        k32.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new ly1(10001, "getSwanId failed: internal_error"));
                    k32.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kw1 kw1Var, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw1Var, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kw1Var;
            this.d = jSONObject;
        }

        @Override // com.baidu.tieba.nu1
        @NonNull
        public ly1 d(@NonNull JSONObject jSONObject, @NonNull nu1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (i03.e() && this.e.D(this.d)) {
                    bVar.a(new ly1(0, this.d));
                    return new ly1(0);
                }
                k32.i("SettingApi", "getSwanId start");
                if (!SwanAppNetworkUtils.i(this.e.i())) {
                    k32.c("SettingApi", "network_error");
                    return new ly1(10002, "network_error");
                }
                sb3 e = j63.K().x().a().b().e(this.e.i());
                e.p(new C0383a(this, bVar));
                e.a();
                return new ly1(0);
            }
            return (ly1) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.nu1
        @NonNull
        public ly1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                return new ly1(0, this.d);
            }
            return (ly1) invokeL.objValue;
        }

        @Override // com.baidu.tieba.nu1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!i03.e()) {
                    return false;
                }
                return this.e.D(this.d);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ou1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw1 a;

        public b(kw1 kw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kw1Var;
        }

        @Override // com.baidu.tieba.ou1.a
        public ly1 a(k63 k63Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, k63Var, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                kw1.M(this.a.a().f(), str);
                return ly1.f();
            }
            return (ly1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements dl3<Map<String, kb3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public c(CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(Map<String, kb3> map) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, kb3> entry : map.entrySet()) {
                        String d = kb3.d(entry.getKey());
                        kb3 value = entry.getValue();
                        if (!TextUtils.isEmpty(d) && value != null && value.b() && !value.d && TextUtils.equals("2", value.e)) {
                            if (zj3.f("3.320.0")) {
                                if (value.a()) {
                                    str = "1";
                                } else {
                                    str = "0";
                                }
                                jSONObject.put(d, str);
                            } else {
                                jSONObject.put(d, value.a());
                            }
                        }
                    }
                    if (zj3.f("3.320.0")) {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("authSetting", jSONObject);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException unused) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements dl3<wb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw1 c;

        public d(kw1 kw1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kw1Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(wb3 wb3Var) {
            ly1 ly1Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wb3Var) == null) {
                k32.b("OpenData", "onOpenDataCallback:: ", wb3Var);
                if (wb3Var.E()) {
                    ly1Var = new ly1(0, wb3Var.g);
                    dd3.T(this.a, "success");
                } else {
                    int a = (int) wb3Var.j.a();
                    String f = ib3.f(a);
                    ly1 ly1Var2 = new ly1(a, f);
                    sp2.j().c(this.c.a().f(), ly1Var2.a());
                    dd3.U(this.a, "fail", f);
                    ly1Var = ly1Var2;
                }
                this.c.d(this.b, ly1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ kw1 e;

        public e(kw1 kw1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kw1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (ib3.h(nb3Var)) {
                    this.e.F(this.a, this.b, this.c, this.d);
                    return;
                }
                k32.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.e.d(this.b, new ly1(402));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements xm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ kw1 f;

        public f(kw1 kw1Var, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw1Var, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = kw1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = activity;
            this.e = str4;
        }

        @Override // com.baidu.tieba.xm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    dd3.S("fail", 3, this.a);
                    dd3.U(this.b, "fail", "login failed");
                    this.f.d(this.c, new ly1(10004, "user not logged in"));
                    return;
                }
                dd3.S("success", 3, this.a);
                this.f.L(false, this.c, this.d, this.e, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements xm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ kw1 g;

        public g(kw1 kw1Var, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw1Var, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = kw1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = activity;
            this.f = str4;
        }

        @Override // com.baidu.tieba.xm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    dd3.S("fail", 3, this.a);
                    dd3.U(this.b, "fail", "result code = " + i);
                    this.g.d(this.c, new ly1(10004, "user not logged in"));
                    return;
                }
                dd3.S("success", 3, this.a);
                this.g.L(this.d, this.c, this.e, this.f, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(k63 k63Var) {
            InterceptResult invokeL;
            String P;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, k63Var)) == null) {
                if (k63Var == null) {
                    P = j63.K().q().P();
                } else {
                    P = k63Var.P();
                }
                return "aiapp_" + P + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kw1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean D(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return false;
            }
            String optString = optJSONObject.optString("swanid");
            if (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ly1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#getSwanId", false);
            k63 q = j63.K().q();
            return n(str, new a(this, "getSwanId", kj3.d(q.f0().q(h.a(q), null))));
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#getSetting", false);
            return m(str, true, new b(this));
        }
        return (ly1) invokeL.objValue;
    }

    public static JSONObject E(k63 k63Var, Context context) throws JSONException {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k63Var, context)) == null) {
            hr2.a X = k63Var.X();
            String U = X.U();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", X.I());
            jSONObject.put("appname", X.L());
            if (!TextUtils.isEmpty(X.R())) {
                jSONObject.put(GameAssistConstKt.KEY_ICONURL, X.R());
            }
            if (!TextUtils.isEmpty(X.X())) {
                jSONObject.put("appLaunchScheme", X.X());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo g0 = X.g0();
            if (g0 != null) {
                String str2 = g0.description;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("appDesc", str2);
                }
                String str3 = g0.paNumber;
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("pa", str3);
                }
                jSONObject.put("isOpenCustomerService", ek3.Q());
            }
            String i = rp2.h0().i(context);
            jSONObject.put("cuid", i);
            jSONObject.put("mtjCuid", i);
            jSONObject.put("clkid", X.M());
            jSONObject.put("scene", U);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, X.I());
            jSONObject.put("appKey", X.J());
            jSONObject.put("pkgType", X.w1());
            jSONObject.put("bundleId", X.I());
            Bundle Q = X.Q();
            if (Q != null) {
                String string = Q.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
                }
                String string2 = Q.getString("srcAppId");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("srcAppId", string2);
                }
                String string3 = Q.getString("srcAppPage");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("srcAppPage", string3);
                }
                String string4 = Q.getString("srcAppKey");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("srcAppKey", string4);
                }
                jSONObject.put("srcPkgType", Q.getInt("srcPkgType"));
                if (TextUtils.isEmpty(U)) {
                    U = "NA";
                }
                String string5 = Q.getString("ubc");
                if (!TextUtils.isEmpty(string5)) {
                    jSONObject.put("rootSource", mm4.a(new JSONObject(string5), "pre_source", U));
                }
                SwanAppActivity activity = xr2.V().getActivity();
                String str4 = "sys";
                if (activity == null) {
                    str = "sys";
                } else {
                    str = activity.W();
                }
                if (!TextUtils.isEmpty(str)) {
                    str4 = str;
                }
                jSONObject.put("showBy", str4);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void M(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, callbackHandler, str) == null) {
            iy2.h(new c(callbackHandler, str));
        }
    }

    public final void F(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            k63 q = j63.K().q();
            SwanAppActivity w = q.w();
            ym1 N = q.N();
            if (N.e(w)) {
                L(false, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            dd3.T(str4, "getUserInfoLogin");
            N.f(w, null, new f(this, str3, str4, str2, w, str));
        }
    }

    public ly1 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r("#getAppInfoSync", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                k32.b("SettingApi", "illegal swanApp");
                return new ly1(1001, "illegal swanApp");
            }
            JSONObject d2 = yz2.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = E(c0, i());
                    yz2.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    k32.c("SettingApi", Log.getStackTraceString(e2));
                    return new ly1(1001);
                }
            }
            return new ly1(0, d2);
        }
        return (ly1) invokeV.objValue;
    }

    public ly1 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            r("#getSlaveIdSync", false);
            String containerId = a().e().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new ly1(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new ly1(0, jSONObject);
            } catch (JSONException unused) {
                return new ly1(1001);
            }
        }
        return (ly1) invokeV.objValue;
    }

    public ly1 K(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#getUserInfo", false);
            wn1 j = sp2.j();
            k63 q = j63.K().q();
            CallbackHandler f2 = a().f();
            if (q == null) {
                j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new ly1(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(q.P())) {
                j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new ly1(1001, "empty clientId");
            } else {
                JSONObject s = ou1.s(str);
                if (s == null) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new ly1(201, "empty joParams");
                }
                String f3 = i23.f(s.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f3);
                boolean j2 = ib3.j(s);
                if (!j2 && !z) {
                    str2 = "getUserInfoApi";
                } else {
                    str2 = "getUserInfoButton";
                }
                String str3 = str2;
                dd3.T(str3, "create");
                String optString = s.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    dd3.U(str3, "fail", "empty cb");
                    return new ly1(201, "empty cb");
                }
                SwanAppActivity w = q.w();
                if (w == null) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    dd3.U(str3, "fail", "the context is not an activity");
                    return new ly1(1001, "the context is not an activity");
                }
                String optString2 = s.optString("invokeFrom");
                if (!q.N().e(w)) {
                    dd3.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    N(f3, optString, optString2, str3);
                } else {
                    O(f3, j2, optString, optString2, str3);
                }
                return new ly1(0);
            }
        }
        return (ly1) invokeL.objValue;
    }

    public final void L(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            dd3.T(str4, "requestOpenData");
            dd3.T(str4, "checkScope");
            wb3.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void N(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            dd3.T(str4, "checkScope");
            j63.K().q().f0().g(i(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void O(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            k63 q = j63.K().q();
            SwanAppActivity w = q.w();
            ym1 N = q.N();
            if (N.e(w)) {
                L(z, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            dd3.T(str4, "getUserInfoLogin");
            N.f(w, null, new g(this, str3, str4, str2, z, w, str));
        }
    }
}
