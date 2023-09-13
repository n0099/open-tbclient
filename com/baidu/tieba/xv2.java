package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.tieba.du2;
import com.baidu.tieba.ew2;
import com.baidu.tieba.fw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xv2 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public class a implements wi4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ hb3 h;
        public final /* synthetic */ xv2 i;

        public a(xv2 xv2Var, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv2Var, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xv2Var;
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
            this.d = str3;
            this.e = context;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = hb3Var;
        }

        @Override // com.baidu.tieba.wi4
        public void a(@Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, map) != null) || map == null) {
                return;
            }
            String str = map.get(this.a);
            if (TextUtils.isEmpty(str)) {
                str = this.a;
            }
            this.i.o(this.b, this.c, this.d, this.e, this.f, str, this.g, this.h);
        }

        @Override // com.baidu.tieba.wi4
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (ed3.b) {
                    Log.e("LaunchAction", "getOpenBundleId", exc);
                }
                this.f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements du2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw2.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ String f;

        @Override // com.baidu.tieba.du2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public b(xv2 xv2Var, fw2.a aVar, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv2Var, aVar, str, str2, callbackHandler, unitedSchemeEntity, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = str;
            this.c = str2;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
            this.f = str3;
        }

        @Override // com.baidu.tieba.du2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                an3 an3Var = new an3();
                an3Var.k(7L);
                an3Var.i(9L);
                an3Var.f("debug download pkg fail");
                en3.a().f(an3Var);
                bw2.e(ou2.c(), an3Var, 0, this.c);
                ii3 ii3Var = new ii3();
                ii3Var.p(an3Var);
                ii3Var.r(this.a);
                ai3.R(ii3Var);
                this.e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.baidu.tieba.du2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((fw2.a) this.a.A0(true)).a1("1.6.0");
                SwanLauncher.j().n(this.a, null);
                xv2.n(this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;

        public c(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, str};
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
            this.b = unitedSchemeEntity;
            this.c = str;
        }

        @Override // com.baidu.tieba.xv2.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            xv2.m(this.a, this.b, this.c, 1001);
        }

        @Override // com.baidu.tieba.xv2.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            xv2.m(this.a, this.b, this.c, 0);
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends n73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e c;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n73, com.baidu.tieba.o73, com.baidu.tieba.m73
        public void onEvent(@NonNull k73 k73Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k73Var) == null) {
                if (k73Var.a() != null && k73Var.a().getInt(DnsModel.MSG_OK) == 0) {
                    e eVar = this.c;
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                e eVar2 = this.c;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xv2(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/launch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void m(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, unitedSchemeEntity, str, i) == null) {
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i));
            } else {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i).toString(), str);
            }
        }
    }

    public static void n(String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, str, str2, callbackHandler, unitedSchemeEntity, str3) == null) {
            if (!TextUtils.isEmpty(str3)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
                c cVar = new c(callbackHandler, unitedSchemeEntity, str3);
                if (ProcessUtils.isMainProcess()) {
                    yv2.j(str2, cVar);
                } else {
                    p(str2, cVar);
                }
            }
        }
    }

    public static void p(String str, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, str, eVar) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("desAppId", str);
        gb3.K().y().X(bundle, yv2.class, new d(eVar));
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            h82.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            if (unitedSchemeEntity.getUri() == null) {
                str = "";
            } else {
                str = unitedSchemeEntity.getUri().toString();
            }
            h82.i("LaunchAction", "launch scheme = " + str);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str2 = params.get("params");
            String str3 = params.get("from");
            if (TextUtils.isEmpty(str2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                an3 an3Var = new an3();
                an3Var.k(1L);
                an3Var.i(1L);
                an3Var.f("paramsValue is empty");
                en3.a().f(an3Var);
                bw2.e(context, an3Var, 0, "");
                ii3 ii3Var = new ii3();
                ii3Var.p(an3Var);
                ii3Var.t(str3);
                ii3Var.l("scheme", str);
                ai3.R(ii3Var);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("navi");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    an3 an3Var2 = new an3();
                    an3Var2.k(1L);
                    an3Var2.i(1L);
                    an3Var2.f("appId is empty");
                    en3.a().f(an3Var2);
                    bw2.e(context, an3Var2, 0, "");
                    ii3 ii3Var2 = new ii3();
                    ii3Var2.p(an3Var2);
                    ii3Var2.t(str3);
                    ii3Var2.l("scheme", str);
                    ai3.R(ii3Var2);
                    return false;
                } else if (wn4.e().g(!bp3.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    ri4.e(arrayList, gb3.K().q().O(), new a(this, optString, jSONObject, str3, str, context, unitedSchemeEntity, callbackHandler, hb3Var));
                    return true;
                } else {
                    return o(jSONObject, str3, str, context, unitedSchemeEntity, optString, callbackHandler, hb3Var);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                an3 an3Var3 = new an3();
                an3Var3.k(1L);
                an3Var3.i(1L);
                an3Var3.f("parse paramsValue with JSONException:" + e2.getMessage());
                en3.a().f(an3Var3);
                bw2.e(context, an3Var3, 0, "");
                ii3 ii3Var3 = new ii3();
                ii3Var3.p(an3Var3);
                ii3Var3.t(str3);
                ii3Var3.l("scheme", str);
                ai3.R(ii3Var3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, hb3Var})) == null) {
            String h = SwanLauncher.h();
            gb3.K().q().W().J0(h);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString3 = jSONObject.optString("downloadurl");
            String optString4 = jSONObject.optString("clkid");
            String optString5 = jSONObject.optString("notinhis");
            String optString6 = jSONObject.optString("cb");
            String optString7 = jSONObject.optString("navi");
            fw2.a aVar = (fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) new fw2.a().v0(str3)).R0(optString)).I0(str)).K0(str2)).y0(optString4)).P0(optString5)).J0(h);
            if (hb3Var != null && !TextUtils.isEmpty(optString7)) {
                aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString2);
                aVar.r0("navi", optString7);
                ew2.a Y = hb3Var.Y();
                if (Y == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String H = Y.H();
                if (j32.e(Y) && !j32.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.r0("srcAppId", H);
                aVar.r0("srcAppKey", Y.I());
                aVar.q0("srcPkgType", Y.getType());
                aVar.r0("srcAppPage", bp3.n().e());
            }
            if (ed3.b && !TextUtils.isEmpty(optString3)) {
                du2.d dVar = new du2.d();
                dVar.a = optString3;
                du2.K(dVar, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.A0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                an3 an3Var = new an3();
                an3Var.k(1L);
                an3Var.i(1L);
                an3Var.f("release but downloadUrl is not empty");
                en3.a().f(an3Var);
                bw2.e(context, an3Var, 0, str3);
                ii3 ii3Var = new ii3();
                ii3Var.t(str);
                ii3Var.m(str3);
                ii3Var.r(aVar);
                ii3Var.l("scheme", str2);
                ai3.R(ii3Var);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
