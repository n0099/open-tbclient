package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ai2;
import com.baidu.tieba.kf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class lf3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements kf3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ix2 b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ vb3 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ eb2 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ lf3 j;

        public a(lf3 lf3Var, String str, ix2 ix2Var, v13 v13Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, String str2, eb2 eb2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf3Var, str, ix2Var, v13Var, unitedSchemeEntity, callbackHandler, vb3Var, str2, eb2Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = lf3Var;
            this.a = str;
            this.b = ix2Var;
            this.c = v13Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = vb3Var;
            this.g = str2;
            this.h = eb2Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.kf3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b53.d(this.a);
                v82.i("relaunch", "check pages success");
                this.b.o();
                ai2.e f = ai2.f(this.b.getActivity(), fi2.c(this.c.a));
                ef3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.kf3.e
        public void b(int i, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, on3Var) == null) {
                v82.c("relaunch", "check pages failed");
                this.b.o();
                if (sd3.b) {
                    Context context = this.i;
                    nb3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d4) + i).G();
                }
                ef3.j(this.d, this.e, this.g);
                ji3.j(this.c, on3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ai2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ eb2 d;

        public b(lf3 lf3Var, ai2.e eVar, String str, v13 v13Var, eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf3Var, eVar, str, v13Var, eb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = str;
            this.c = v13Var;
            this.d = eb2Var;
        }

        @Override // com.baidu.tieba.ai2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (sd3.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                b53.e(this.a, this.b);
                ef3.e(this.a.a, this.c, this.b);
                lf3.o(this.d, this.c, this.b);
                if (sd3.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lf3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/reLaunch");
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

    public static void o(eb2 eb2Var, v13 v13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, eb2Var, v13Var, str) == null) {
            q12.y(eb2Var, v13Var, str);
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            b53.b(uuid);
            String o = ef3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                v82.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ix2 T2 = ix2.T();
            eb2 U = T2.U();
            if (U == null) {
                v82.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            v13 d = v13.d(o, T2.z());
            d.e = "3";
            d.f = uuid;
            ji3.g(d);
            if (!pp3.b(T2.s(), d, true)) {
                v82.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ji3.i(d);
                return false;
            }
            String n = ef3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && vb3.M() != null) {
                vb3.M().L0(n, d.d);
            }
            String n2 = ef3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = a53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = vo3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v82.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ji3.i(d);
                return false;
            } else if (ie3.b().a(d)) {
                ie3.b().i("reLaunch", d);
                v82.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                kf3.g(vb3Var, d, "", new a(this, uuid, T2, d, unitedSchemeEntity, callbackHandler, vb3Var, optString, U, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(ai2.e eVar, v13 v13Var, eb2 eb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, v13Var, eb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (sd3.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ai2.q(eVar, new b(this, eVar, str, v13Var, eb2Var));
            if (sd3.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
