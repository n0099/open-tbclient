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
import com.baidu.tieba.ce2;
import com.baidu.tieba.mb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class ob3 extends u93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements mb3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kt2 b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ x73 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ g72 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ ob3 j;

        public a(ob3 ob3Var, String str, kt2 kt2Var, xx2 xx2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var, String str2, g72 g72Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob3Var, str, kt2Var, xx2Var, unitedSchemeEntity, callbackHandler, x73Var, str2, g72Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = ob3Var;
            this.a = str;
            this.b = kt2Var;
            this.c = xx2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = x73Var;
            this.g = str2;
            this.h = g72Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.mb3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d13.d(this.a);
                x42.i("redirect", "check pages success");
                this.b.o();
                ce2.e f = ce2.f(this.b.getActivity(), he2.c(this.c.a));
                gb3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.mb3.e
        public void b(int i, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qj3Var) == null) {
                x42.c("redirect", "check pages failed");
                this.b.o();
                if (u93.b) {
                    Context context = this.i;
                    p73.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                gb3.j(this.d, this.e, this.g);
                le3.j(this.c, qj3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ce2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx2 c;
        public final /* synthetic */ g72 d;

        public b(ob3 ob3Var, ce2.e eVar, String str, xx2 xx2Var, g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob3Var, eVar, str, xx2Var, g72Var};
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
            this.c = xx2Var;
            this.d = g72Var;
        }

        @Override // com.baidu.tieba.ce2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (u93.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                d13.e(this.a, this.b);
                gb3.e(this.a.a, this.c, this.b);
                rx1.A(this.d, this.c, this.b, false);
                if (u93.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ob3(u83 u83Var) {
        super(u83Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u83Var};
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

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, x73Var)) == null) {
            if (u93.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            d13.b(uuid);
            String o = gb3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                x42.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            kt2 U = kt2.U();
            g72 V = U.V();
            if (V == null) {
                x42.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            xx2 d = xx2.d(o, U.z());
            d.e = "2";
            d.f = uuid;
            le3.g(d);
            if (!rl3.b(U.s(), d, false)) {
                x42.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                le3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && x73.M() != null) {
                x73.M().L0(str, d.d);
            }
            String n = gb3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = c13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (u93.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = xk3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                x42.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                le3.i(d);
                return false;
            } else if (ka3.b().a(d)) {
                ka3.b().i("redirectTo", d);
                x42.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                mb3.g(x73Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, x73Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(ce2.e eVar, xx2 xx2Var, g72 g72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, xx2Var, g72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = c13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (u93.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            ce2.q(eVar, new b(this, eVar, str, xx2Var, g72Var));
            if (u93.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
