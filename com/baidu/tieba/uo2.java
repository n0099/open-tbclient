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
import com.baidu.tieba.an2;
import com.baidu.tieba.bp2;
import com.baidu.tieba.cp2;
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
public class uo2 extends b63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public class a implements tb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ e43 h;
        public final /* synthetic */ uo2 i;

        public a(uo2 uo2Var, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo2Var, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, e43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = uo2Var;
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
            this.d = str3;
            this.e = context;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = e43Var;
        }

        @Override // com.baidu.tieba.tb4
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

        @Override // com.baidu.tieba.tb4
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (b63.b) {
                    Log.e("LaunchAction", "getOpenBundleId", exc);
                }
                this.f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements an2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cp2.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ String f;

        @Override // com.baidu.tieba.an2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public b(uo2 uo2Var, cp2.a aVar, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo2Var, aVar, str, str2, callbackHandler, unitedSchemeEntity, str3};
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

        @Override // com.baidu.tieba.an2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(7L);
                xf3Var.i(9L);
                xf3Var.f("debug download pkg fail");
                bg3.a().f(xf3Var);
                yo2.e(ln2.c(), xf3Var, 0, this.c);
                fb3 fb3Var = new fb3();
                fb3Var.p(xf3Var);
                fb3Var.r(this.a);
                xa3.R(fb3Var);
                this.e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.baidu.tieba.an2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((cp2.a) this.a.A0(true)).a1("1.6.0");
                SwanLauncher.j().n(this.a, null);
                uo2.n(this.b, this.c, this.d, this.e, this.f);
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

        @Override // com.baidu.tieba.uo2.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            uo2.m(this.a, this.b, this.c, 1001);
        }

        @Override // com.baidu.tieba.uo2.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            uo2.m(this.a, this.b, this.c, 0);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends k03 {
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
        @Override // com.baidu.tieba.k03, com.baidu.tieba.l03, com.baidu.tieba.j03
        public void onEvent(@NonNull h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h03Var) == null) {
                if (h03Var.a() != null && h03Var.a().getInt(DnsModel.MSG_OK) == 0) {
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
    public uo2(b53 b53Var) {
        super(b53Var, "/swanAPI/launch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
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
                    vo2.j(str2, cVar);
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
        d43.K().y().X(bundle, vo2.class, new d(eVar));
    }

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            e12.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            if (unitedSchemeEntity.getUri() == null) {
                str = "";
            } else {
                str = unitedSchemeEntity.getUri().toString();
            }
            e12.i("LaunchAction", "launch scheme = " + str);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str2 = params.get("params");
            String str3 = params.get("from");
            if (TextUtils.isEmpty(str2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                xf3 xf3Var = new xf3();
                xf3Var.k(1L);
                xf3Var.i(1L);
                xf3Var.f("paramsValue is empty");
                bg3.a().f(xf3Var);
                yo2.e(context, xf3Var, 0, "");
                fb3 fb3Var = new fb3();
                fb3Var.p(xf3Var);
                fb3Var.t(str3);
                fb3Var.l("scheme", str);
                xa3.R(fb3Var);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("navi");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    xf3 xf3Var2 = new xf3();
                    xf3Var2.k(1L);
                    xf3Var2.i(1L);
                    xf3Var2.f("appId is empty");
                    bg3.a().f(xf3Var2);
                    yo2.e(context, xf3Var2, 0, "");
                    fb3 fb3Var2 = new fb3();
                    fb3Var2.p(xf3Var2);
                    fb3Var2.t(str3);
                    fb3Var2.l("scheme", str);
                    xa3.R(fb3Var2);
                    return false;
                } else if (tg4.e().g(!yh3.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    ob4.e(arrayList, d43.K().q().O(), new a(this, optString, jSONObject, str3, str, context, unitedSchemeEntity, callbackHandler, e43Var));
                    return true;
                } else {
                    return o(jSONObject, str3, str, context, unitedSchemeEntity, optString, callbackHandler, e43Var);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                xf3 xf3Var3 = new xf3();
                xf3Var3.k(1L);
                xf3Var3.i(1L);
                xf3Var3.f("parse paramsValue with JSONException:" + e2.getMessage());
                bg3.a().f(xf3Var3);
                yo2.e(context, xf3Var3, 0, "");
                fb3 fb3Var3 = new fb3();
                fb3Var3.p(xf3Var3);
                fb3Var3.t(str3);
                fb3Var3.l("scheme", str);
                xa3.R(fb3Var3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, e43Var})) == null) {
            String h = SwanLauncher.h();
            d43.K().q().W().J0(h);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString3 = jSONObject.optString("downloadurl");
            String optString4 = jSONObject.optString("clkid");
            String optString5 = jSONObject.optString("notinhis");
            String optString6 = jSONObject.optString("cb");
            String optString7 = jSONObject.optString("navi");
            cp2.a aVar = (cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) new cp2.a().v0(str3)).R0(optString)).I0(str)).K0(str2)).y0(optString4)).P0(optString5)).J0(h);
            if (e43Var != null && !TextUtils.isEmpty(optString7)) {
                aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString2);
                aVar.r0("navi", optString7);
                bp2.a Y = e43Var.Y();
                if (Y == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String H = Y.H();
                if (gw1.e(Y) && !gw1.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.r0("srcAppId", H);
                aVar.r0("srcAppKey", Y.I());
                aVar.q0("srcPkgType", Y.getType());
                aVar.r0("srcAppPage", yh3.n().e());
            }
            if (b63.b && !TextUtils.isEmpty(optString3)) {
                an2.d dVar = new an2.d();
                dVar.a = optString3;
                an2.K(dVar, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.A0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                xf3 xf3Var = new xf3();
                xf3Var.k(1L);
                xf3Var.i(1L);
                xf3Var.f("release but downloadUrl is not empty");
                bg3.a().f(xf3Var);
                yo2.e(context, xf3Var, 0, str3);
                fb3 fb3Var = new fb3();
                fb3Var.t(str);
                fb3Var.m(str3);
                fb3Var.r(aVar);
                fb3Var.l("scheme", str2);
                xa3.R(fb3Var);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
