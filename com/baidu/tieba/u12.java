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
import com.baidu.tieba.ah3;
import com.baidu.tieba.sw2;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yz1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u12 extends s12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends xz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ u12 e;

        /* renamed from: com.baidu.tieba.u12$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0495a implements oq3<yg3<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xz1.b a;

            public C0495a(a aVar, xz1.b bVar) {
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
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(yg3<JSONObject> yg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                    if (yg3Var.c() && yg3Var.a != null) {
                        this.a.a(new v32(0, yg3Var.a));
                        vb3 q = ub3.K().q();
                        q.e0().B(h.a(q), yg3Var.a.toString());
                        v82.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new v32(10001, "getSwanId failed: internal_error"));
                    v82.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u12 u12Var, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, str, jSONObject};
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
            this.e = u12Var;
            this.d = jSONObject;
        }

        @Override // com.baidu.tieba.xz1
        @NonNull
        public v32 d(@NonNull JSONObject jSONObject, @NonNull xz1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (t53.e() && this.e.C(this.d)) {
                    bVar.a(new v32(0, this.d));
                    return new v32(0);
                }
                v82.i("SettingApi", "getSwanId start");
                if (!SwanAppNetworkUtils.i(this.e.getContext())) {
                    v82.c("SettingApi", "network_error");
                    return new v32(10002, "network_error");
                }
                dh3 e = ub3.K().x().a().b().e(this.e.getContext());
                e.o(new C0495a(this, bVar));
                e.call();
                return new v32(0);
            }
            return (v32) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.xz1
        @NonNull
        public v32 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                return new v32(0, this.d);
            }
            return (v32) invokeL.objValue;
        }

        @Override // com.baidu.tieba.xz1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!t53.e()) {
                    return false;
                }
                return this.e.C(this.d);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements yz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u12 a;

        public b(u12 u12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u12Var;
        }

        @Override // com.baidu.tieba.yz1.a
        public v32 a(vb3 vb3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, vb3Var, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                u12.L(this.a.a().e(), str);
                return v32.f();
            }
            return (v32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements oq3<Map<String, vg3>> {
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(Map<String, vg3> map) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, vg3> entry : map.entrySet()) {
                        String d = vg3.d(entry.getKey());
                        vg3 value = entry.getValue();
                        if (!TextUtils.isEmpty(d) && value != null && value.b() && !value.d && TextUtils.equals("2", value.e)) {
                            if (kp3.f("3.320.0")) {
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
                    if (kp3.f("3.320.0")) {
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

    /* loaded from: classes8.dex */
    public class d implements oq3<hh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ u12 c;

        public d(u12 u12Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u12Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(hh3 hh3Var) {
            v32 v32Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) {
                v82.b("OpenData", "onOpenDataCallback:: ", hh3Var);
                if (hh3Var.E()) {
                    v32Var = new v32(0, hh3Var.g);
                    oi3.T(this.a, "success");
                } else {
                    int a = (int) hh3Var.j.a();
                    String f = tg3.f(a);
                    v32 v32Var2 = new v32(a, f);
                    dv2.j().c(this.c.a().e(), v32Var2.a());
                    oi3.U(this.a, "fail", f);
                    v32Var = v32Var2;
                }
                this.c.d(this.b, v32Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ u12 e;

        public e(u12 u12Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.e.E(this.a, this.b, this.c, this.d);
                    return;
                }
                v82.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.e.d(this.b, new v32(402));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements hs1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ u12 f;

        public f(u12 u12Var, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = u12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = activity;
            this.e = str4;
        }

        @Override // com.baidu.tieba.hs1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    oi3.S("fail", 3, this.a);
                    oi3.U(this.b, "fail", "login failed");
                    this.f.d(this.c, new v32(10004, "user not logged in"));
                    return;
                }
                oi3.S("success", 3, this.a);
                this.f.K(false, this.c, this.d, this.e, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements hs1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ u12 g;

        public g(u12 u12Var, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = u12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = activity;
            this.f = str4;
        }

        @Override // com.baidu.tieba.hs1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    oi3.S("fail", 3, this.a);
                    oi3.U(this.b, "fail", "result code = " + i);
                    this.g.d(this.c, new v32(10004, "user not logged in"));
                    return;
                }
                oi3.S("success", 3, this.a);
                this.g.K(this.d, this.c, this.e, this.f, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(vb3 vb3Var) {
            InterceptResult invokeL;
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vb3Var)) == null) {
                if (vb3Var == null) {
                    O = ub3.K().q().O();
                } else {
                    O = vb3Var.O();
                }
                return "aiapp_" + O + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u12(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean C(JSONObject jSONObject) {
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

    public v32 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            vb3 q = ub3.K().q();
            return m(str, new a(this, "getSwanId", vo3.d(q.e0().q(h.a(q), null))));
        }
        return (v32) invokeL.objValue;
    }

    public static JSONObject D(vb3 vb3Var, Context context) throws JSONException {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, vb3Var, context)) == null) {
            sw2.a W = vb3Var.W();
            String T2 = W.T();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", W.H());
            jSONObject.put("appname", W.K());
            if (!TextUtils.isEmpty(W.Q())) {
                jSONObject.put(GameAssistConstKt.KEY_ICONURL, W.Q());
            }
            if (!TextUtils.isEmpty(W.W())) {
                jSONObject.put("appLaunchScheme", W.W());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo f0 = W.f0();
            if (f0 != null) {
                String str2 = f0.description;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("appDesc", str2);
                }
                String str3 = f0.paNumber;
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("pa", str3);
                }
                jSONObject.put("isOpenCustomerService", pp3.Q());
            }
            String i = cv2.h0().i(context);
            jSONObject.put("cuid", i);
            jSONObject.put("mtjCuid", i);
            jSONObject.put("clkid", W.L());
            jSONObject.put("scene", T2);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, W.H());
            jSONObject.put("appKey", W.I());
            jSONObject.put("pkgType", W.getType());
            jSONObject.put("bundleId", W.H());
            Bundle P = W.P();
            if (P != null) {
                String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
                }
                String string2 = P.getString("srcAppId");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("srcAppId", string2);
                }
                String string3 = P.getString("srcAppPage");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("srcAppPage", string3);
                }
                String string4 = P.getString("srcAppKey");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("srcAppKey", string4);
                }
                jSONObject.put("srcPkgType", P.getInt("srcPkgType"));
                if (TextUtils.isEmpty(T2)) {
                    T2 = "NA";
                }
                String string5 = P.getString("ubc");
                if (!TextUtils.isEmpty(string5)) {
                    jSONObject.put("rootSource", yr4.a(new JSONObject(string5), "pre_source", T2));
                }
                SwanAppActivity activity = ix2.T().getActivity();
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

    public static void L(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) {
            t33.h(new c(callbackHandler, str));
        }
    }

    public v32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (v32) invokeL.objValue;
    }

    public final void E(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            vb3 q = ub3.K().q();
            SwanAppActivity w = q.w();
            is1 N = q.N();
            if (N.e(w)) {
                K(false, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            oi3.T(str4, "getUserInfoLogin");
            N.f(w, null, new f(this, str3, str4, str2, w, str));
        }
    }

    public v32 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                v82.b("SettingApi", "illegal swanApp");
                return new v32(1001, "illegal swanApp");
            }
            JSONObject d2 = j53.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(b0, getContext());
                    j53.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    v82.c("SettingApi", Log.getStackTraceString(e2));
                    return new v32(1001);
                }
            }
            return new v32(0, d2);
        }
        return (v32) invokeV.objValue;
    }

    public v32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().d().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new v32(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new v32(0, jSONObject);
            } catch (JSONException unused) {
                return new v32(1001);
            }
        }
        return (v32) invokeV.objValue;
    }

    public v32 J(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            gt1 j = dv2.j();
            vb3 q = ub3.K().q();
            CallbackHandler e2 = a().e();
            if (q == null) {
                j.c(e2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new v32(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(q.O())) {
                j.c(e2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new v32(1001, "empty clientId");
            } else {
                JSONObject r = yz1.r(str);
                if (r == null) {
                    j.c(e2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new v32(201, "empty joParams");
                }
                String f2 = t73.f(r.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f2);
                boolean j2 = tg3.j(r);
                if (!j2 && !z) {
                    str2 = "getUserInfoApi";
                } else {
                    str2 = "getUserInfoButton";
                }
                String str3 = str2;
                oi3.T(str3, "create");
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(e2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    oi3.U(str3, "fail", "empty cb");
                    return new v32(201, "empty cb");
                }
                SwanAppActivity w = q.w();
                if (w == null) {
                    j.c(e2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    oi3.U(str3, "fail", "the context is not an activity");
                    return new v32(1001, "the context is not an activity");
                }
                String optString2 = r.optString("invokeFrom");
                if (!q.N().e(w)) {
                    oi3.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    M(f2, optString, optString2, str3);
                } else {
                    N(f2, j2, optString, optString2, str3);
                }
                return new v32(0);
            }
        }
        return (v32) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            oi3.T(str4, "requestOpenData");
            oi3.T(str4, "checkScope");
            hh3.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            oi3.T(str4, "checkScope");
            ub3.K().q().e0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            vb3 q = ub3.K().q();
            SwanAppActivity w = q.w();
            is1 N = q.N();
            if (N.e(w)) {
                K(z, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            oi3.T(str4, "getUserInfoLogin");
            N.f(w, null, new g(this, str3, str4, str2, z, w, str));
        }
    }
}
