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
import com.baidu.tieba.lc2;
import com.baidu.tieba.v93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes9.dex */
public class x93 extends d83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements v93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tr2 b;
        public final /* synthetic */ gw2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ g63 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ p52 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ x93 j;

        public a(x93 x93Var, String str, tr2 tr2Var, gw2 gw2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g63 g63Var, String str2, p52 p52Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, str, tr2Var, gw2Var, unitedSchemeEntity, callbackHandler, g63Var, str2, p52Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = x93Var;
            this.a = str;
            this.b = tr2Var;
            this.c = gw2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = g63Var;
            this.g = str2;
            this.h = p52Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.v93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                mz2.d(this.a);
                g32.i("redirect", "check pages success");
                this.b.p();
                lc2.e f = lc2.f(this.b.getActivity(), qc2.c(this.c.a));
                p93.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.v93.e
        public void b(int i, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zh3Var) == null) {
                g32.c("redirect", "check pages failed");
                this.b.p();
                if (d83.b) {
                    Context context = this.i;
                    y53.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d7) + i).G();
                }
                p93.j(this.d, this.e, this.g);
                uc3.j(this.c, zh3Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements lc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gw2 c;
        public final /* synthetic */ p52 d;

        public b(x93 x93Var, lc2.e eVar, String str, gw2 gw2Var, p52 p52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, eVar, str, gw2Var, p52Var};
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
            this.c = gw2Var;
            this.d = p52Var;
        }

        @Override // com.baidu.tieba.lc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d83.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                mz2.e(this.a, this.b);
                p93.e(this.a.a, this.c, this.b);
                bw1.B(this.d, this.c, this.b, false);
                if (d83.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x93(d73 d73Var) {
        super(d73Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d73Var};
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

    @Override // com.baidu.tieba.d83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g63Var)) == null) {
            if (d83.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            mz2.b(uuid);
            String o = p93.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                g32.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            tr2 V = tr2.V();
            p52 W = V.W();
            if (W == null) {
                g32.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            gw2 d = gw2.d(o, V.A());
            d.e = "2";
            d.f = uuid;
            uc3.g(d);
            if (!ak3.b(V.t(), d, false)) {
                g32.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                uc3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && g63.M() != null) {
                g63.M().M0(str, d.d);
            }
            String n = p93.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = lz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (d83.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = gj3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g32.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                uc3.i(d);
                return false;
            } else if (t83.b().a(d)) {
                t83.b().i("redirectTo", d);
                g32.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                v93.g(g63Var, d, "", new a(this, uuid, V, d, unitedSchemeEntity, callbackHandler, g63Var, optString, W, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(lc2.e eVar, gw2 gw2Var, p52 p52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, gw2Var, p52Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = lz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (d83.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            lc2.q(eVar, new b(this, eVar, str, gw2Var, p52Var));
            if (d83.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
