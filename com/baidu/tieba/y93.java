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
import com.baidu.tieba.mc2;
import com.baidu.tieba.w93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes9.dex */
public class y93 extends e83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements w93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ur2 b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ h63 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ q52 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ y93 j;

        public a(y93 y93Var, String str, ur2 ur2Var, hw2 hw2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h63 h63Var, String str2, q52 q52Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y93Var, str, ur2Var, hw2Var, unitedSchemeEntity, callbackHandler, h63Var, str2, q52Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = y93Var;
            this.a = str;
            this.b = ur2Var;
            this.c = hw2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = h63Var;
            this.g = str2;
            this.h = q52Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.w93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                nz2.d(this.a);
                h32.i("redirect", "check pages success");
                this.b.p();
                mc2.e f = mc2.f(this.b.getActivity(), rc2.c(this.c.a));
                q93.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.w93.e
        public void b(int i, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ai3Var) == null) {
                h32.c("redirect", "check pages failed");
                this.b.p();
                if (e83.b) {
                    Context context = this.i;
                    z53.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01df) + i).G();
                }
                q93.j(this.d, this.e, this.g);
                vc3.j(this.c, ai3Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements mc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ q52 d;

        public b(y93 y93Var, mc2.e eVar, String str, hw2 hw2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y93Var, eVar, str, hw2Var, q52Var};
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
            this.c = hw2Var;
            this.d = q52Var;
        }

        @Override // com.baidu.tieba.mc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e83.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                nz2.e(this.a, this.b);
                q93.e(this.a.a, this.c, this.b);
                cw1.B(this.d, this.c, this.b, false);
                if (e83.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y93(e73 e73Var) {
        super(e73Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e73Var};
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

    @Override // com.baidu.tieba.e83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h63Var)) == null) {
            if (e83.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            nz2.b(uuid);
            String o = q93.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                h32.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ur2 V = ur2.V();
            q52 W = V.W();
            if (W == null) {
                h32.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hw2 d = hw2.d(o, V.A());
            d.e = "2";
            d.f = uuid;
            vc3.g(d);
            if (!bk3.b(V.t(), d, false)) {
                h32.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                vc3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && h63.M() != null) {
                h63.M().M0(str, d.d);
            }
            String n = q93.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = mz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (e83.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = hj3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h32.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                vc3.i(d);
                return false;
            } else if (u83.b().a(d)) {
                u83.b().i("redirectTo", d);
                h32.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                w93.g(h63Var, d, "", new a(this, uuid, V, d, unitedSchemeEntity, callbackHandler, h63Var, optString, W, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(mc2.e eVar, hw2 hw2Var, q52 q52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, hw2Var, q52Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = mz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (e83.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            mc2.q(eVar, new b(this, eVar, str, hw2Var, q52Var));
            if (e83.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
