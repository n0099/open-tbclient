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
import com.baidu.tieba.ib3;
import com.baidu.tieba.yd2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class jb3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ib3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gt2 b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ t73 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ c72 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ jb3 j;

        public a(jb3 jb3Var, String str, gt2 gt2Var, tx2 tx2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var, String str2, c72 c72Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, str, gt2Var, tx2Var, unitedSchemeEntity, callbackHandler, t73Var, str2, c72Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = jb3Var;
            this.a = str;
            this.b = gt2Var;
            this.c = tx2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = t73Var;
            this.g = str2;
            this.h = c72Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.ib3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                z03.d(this.a);
                t42.i("relaunch", "check pages success");
                this.b.o();
                yd2.e f = yd2.f(this.b.getActivity(), de2.c(this.c.a));
                cb3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.ib3.e
        public void b(int i, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                t42.c("relaunch", "check pages failed");
                this.b.o();
                if (q93.b) {
                    Context context = this.i;
                    l73.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01aa) + i).G();
                }
                cb3.j(this.d, this.e, this.g);
                he3.j(this.c, mj3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements yd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ c72 d;

        public b(jb3 jb3Var, yd2.e eVar, String str, tx2 tx2Var, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jb3Var, eVar, str, tx2Var, c72Var};
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
            this.c = tx2Var;
            this.d = c72Var;
        }

        @Override // com.baidu.tieba.yd2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (q93.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                z03.e(this.a, this.b);
                cb3.e(this.a.a, this.c, this.b);
                jb3.o(this.d, this.c, this.b);
                if (q93.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb3(q83 q83Var) {
        super(q83Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    public static void o(c72 c72Var, tx2 tx2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, c72Var, tx2Var, str) == null) {
            ox1.y(c72Var, tx2Var, str);
        }
    }

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (q93.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            z03.b(uuid);
            String o = cb3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                t42.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            gt2 U = gt2.U();
            c72 V = U.V();
            if (V == null) {
                t42.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            tx2 d = tx2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            he3.g(d);
            if (!nl3.b(U.s(), d, true)) {
                t42.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                he3.i(d);
                return false;
            }
            String n = cb3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && t73.M() != null) {
                t73.M().L0(n, d.d);
            }
            String n2 = cb3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = y03.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = tk3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                t42.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                he3.i(d);
                return false;
            } else if (ga3.b().a(d)) {
                ga3.b().i("reLaunch", d);
                t42.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                ib3.g(t73Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, t73Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(yd2.e eVar, tx2 tx2Var, c72 c72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, tx2Var, c72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = y03.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (q93.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            yd2.q(eVar, new b(this, eVar, str, tx2Var, c72Var));
            if (q93.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
