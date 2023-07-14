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
import com.baidu.tieba.ru2;
import com.baidu.tieba.sw2;
import com.baidu.tieba.tw2;
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
/* loaded from: classes6.dex */
public class lw2 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public class a implements kj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ vb3 h;
        public final /* synthetic */ lw2 i;

        public a(lw2 lw2Var, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw2Var, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, vb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = lw2Var;
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
            this.d = str3;
            this.e = context;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = vb3Var;
        }

        @Override // com.baidu.tieba.kj4
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

        @Override // com.baidu.tieba.kj4
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (sd3.b) {
                    Log.e("LaunchAction", "getOpenBundleId", exc);
                }
                this.f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ru2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw2.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ String f;

        @Override // com.baidu.tieba.ru2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public b(lw2 lw2Var, tw2.a aVar, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw2Var, aVar, str, str2, callbackHandler, unitedSchemeEntity, str3};
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

        @Override // com.baidu.tieba.ru2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                on3 on3Var = new on3();
                on3Var.k(7L);
                on3Var.i(9L);
                on3Var.f("debug download pkg fail");
                sn3.a().f(on3Var);
                pw2.e(cv2.c(), on3Var, 0, this.c);
                wi3 wi3Var = new wi3();
                wi3Var.p(on3Var);
                wi3Var.r(this.a);
                oi3.R(wi3Var);
                this.e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.baidu.tieba.ru2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((tw2.a) this.a.A0(true)).a1("1.6.0");
                SwanLauncher.j().n(this.a, null);
                lw2.n(this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // com.baidu.tieba.lw2.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            lw2.m(this.a, this.b, this.c, 1001);
        }

        @Override // com.baidu.tieba.lw2.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            lw2.m(this.a, this.b, this.c, 0);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends b83 {
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
        @Override // com.baidu.tieba.b83, com.baidu.tieba.c83, com.baidu.tieba.a83
        public void onEvent(@NonNull y73 y73Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y73Var) == null) {
                if (y73Var.a() != null && y73Var.a().getInt(DnsModel.MSG_OK) == 0) {
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
    public lw2(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/launch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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
                    mw2.j(str2, cVar);
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
        ub3.K().y().X(bundle, mw2.class, new d(eVar));
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            v82.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            if (unitedSchemeEntity.getUri() == null) {
                str = "";
            } else {
                str = unitedSchemeEntity.getUri().toString();
            }
            v82.i("LaunchAction", "launch scheme = " + str);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str2 = params.get("params");
            String str3 = params.get("from");
            if (TextUtils.isEmpty(str2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                on3 on3Var = new on3();
                on3Var.k(1L);
                on3Var.i(1L);
                on3Var.f("paramsValue is empty");
                sn3.a().f(on3Var);
                pw2.e(context, on3Var, 0, "");
                wi3 wi3Var = new wi3();
                wi3Var.p(on3Var);
                wi3Var.t(str3);
                wi3Var.l("scheme", str);
                oi3.R(wi3Var);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("navi");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    on3 on3Var2 = new on3();
                    on3Var2.k(1L);
                    on3Var2.i(1L);
                    on3Var2.f("appId is empty");
                    sn3.a().f(on3Var2);
                    pw2.e(context, on3Var2, 0, "");
                    wi3 wi3Var2 = new wi3();
                    wi3Var2.p(on3Var2);
                    wi3Var2.t(str3);
                    wi3Var2.l("scheme", str);
                    oi3.R(wi3Var2);
                    return false;
                } else if (ko4.e().g(!pp3.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    fj4.e(arrayList, ub3.K().q().O(), new a(this, optString, jSONObject, str3, str, context, unitedSchemeEntity, callbackHandler, vb3Var));
                    return true;
                } else {
                    return o(jSONObject, str3, str, context, unitedSchemeEntity, optString, callbackHandler, vb3Var);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                on3 on3Var3 = new on3();
                on3Var3.k(1L);
                on3Var3.i(1L);
                on3Var3.f("parse paramsValue with JSONException:" + e2.getMessage());
                sn3.a().f(on3Var3);
                pw2.e(context, on3Var3, 0, "");
                wi3 wi3Var3 = new wi3();
                wi3Var3.p(on3Var3);
                wi3Var3.t(str3);
                wi3Var3.l("scheme", str);
                oi3.R(wi3Var3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, vb3Var})) == null) {
            String h = SwanLauncher.h();
            ub3.K().q().W().J0(h);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString3 = jSONObject.optString("downloadurl");
            String optString4 = jSONObject.optString("clkid");
            String optString5 = jSONObject.optString("notinhis");
            String optString6 = jSONObject.optString("cb");
            String optString7 = jSONObject.optString("navi");
            tw2.a aVar = (tw2.a) ((tw2.a) ((tw2.a) ((tw2.a) ((tw2.a) ((tw2.a) ((tw2.a) new tw2.a().v0(str3)).R0(optString)).I0(str)).K0(str2)).y0(optString4)).P0(optString5)).J0(h);
            if (vb3Var != null && !TextUtils.isEmpty(optString7)) {
                aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString2);
                aVar.r0("navi", optString7);
                sw2.a Y = vb3Var.Y();
                if (Y == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String H = Y.H();
                if (x32.e(Y) && !x32.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.r0("srcAppId", H);
                aVar.r0("srcAppKey", Y.I());
                aVar.q0("srcPkgType", Y.getType());
                aVar.r0("srcAppPage", pp3.n().e());
            }
            if (sd3.b && !TextUtils.isEmpty(optString3)) {
                ru2.d dVar = new ru2.d();
                dVar.a = optString3;
                ru2.K(dVar, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.A0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                on3 on3Var = new on3();
                on3Var.k(1L);
                on3Var.i(1L);
                on3Var.f("release but downloadUrl is not empty");
                sn3.a().f(on3Var);
                pw2.e(context, on3Var, 0, str3);
                wi3 wi3Var = new wi3();
                wi3Var.t(str);
                wi3Var.m(str3);
                wi3Var.r(aVar);
                wi3Var.l("scheme", str2);
                oi3.R(wi3Var);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
