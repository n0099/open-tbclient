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
import com.baidu.tieba.ei2;
import com.baidu.tieba.of3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class pf3 extends wd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements of3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mx2 b;
        public final /* synthetic */ z13 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ zb3 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ib2 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ pf3 j;

        public a(pf3 pf3Var, String str, mx2 mx2Var, z13 z13Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var, String str2, ib2 ib2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf3Var, str, mx2Var, z13Var, unitedSchemeEntity, callbackHandler, zb3Var, str2, ib2Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = pf3Var;
            this.a = str;
            this.b = mx2Var;
            this.c = z13Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = zb3Var;
            this.g = str2;
            this.h = ib2Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.of3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                f53.d(this.a);
                z82.i("relaunch", "check pages success");
                this.b.o();
                ei2.e f = ei2.f(this.b.getActivity(), ji2.c(this.c.a));
                if3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.of3.e
        public void b(int i, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sn3Var) == null) {
                z82.c("relaunch", "check pages failed");
                this.b.o();
                if (wd3.b) {
                    Context context = this.i;
                    rb3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d2) + i).G();
                }
                if3.j(this.d, this.e, this.g);
                ni3.j(this.c, sn3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ei2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z13 c;
        public final /* synthetic */ ib2 d;

        public b(pf3 pf3Var, ei2.e eVar, String str, z13 z13Var, ib2 ib2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf3Var, eVar, str, z13Var, ib2Var};
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
            this.c = z13Var;
            this.d = ib2Var;
        }

        @Override // com.baidu.tieba.ei2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (wd3.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                f53.e(this.a, this.b);
                if3.e(this.a.a, this.c, this.b);
                pf3.o(this.d, this.c, this.b);
                if (wd3.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf3(wc3 wc3Var) {
        super(wc3Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc3Var};
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

    public static void o(ib2 ib2Var, z13 z13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, ib2Var, z13Var, str) == null) {
            u12.y(ib2Var, z13Var, str);
        }
    }

    @Override // com.baidu.tieba.wd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, zb3Var)) == null) {
            if (wd3.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            f53.b(uuid);
            String o = if3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                z82.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            mx2 T2 = mx2.T();
            ib2 U = T2.U();
            if (U == null) {
                z82.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            z13 d = z13.d(o, T2.z());
            d.e = "3";
            d.f = uuid;
            ni3.g(d);
            if (!tp3.b(T2.s(), d, true)) {
                z82.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ni3.i(d);
                return false;
            }
            String n = if3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && zb3.M() != null) {
                zb3.M().L0(n, d.d);
            }
            String n2 = if3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = e53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = zo3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                z82.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ni3.i(d);
                return false;
            } else if (me3.b().a(d)) {
                me3.b().i("reLaunch", d);
                z82.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                of3.g(zb3Var, d, "", new a(this, uuid, T2, d, unitedSchemeEntity, callbackHandler, zb3Var, optString, U, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(ei2.e eVar, z13 z13Var, ib2 ib2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, z13Var, ib2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = e53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (wd3.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ei2.q(eVar, new b(this, eVar, str, z13Var, ib2Var));
            if (wd3.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
