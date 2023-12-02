package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.pc2;
import com.baidu.tieba.t52;
import com.baidu.tieba.z93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes9.dex */
public class x93 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes9.dex */
    public class a implements z93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k63 b;
        public final /* synthetic */ xr2 c;
        public final /* synthetic */ kw2 d;
        public final /* synthetic */ t52 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ x93 j;

        public a(x93 x93Var, String str, k63 k63Var, xr2 xr2Var, kw2 kw2Var, t52 t52Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, str, k63Var, xr2Var, kw2Var, t52Var, unitedSchemeEntity, callbackHandler, str2, context};
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
            this.b = k63Var;
            this.c = xr2Var;
            this.d = kw2Var;
            this.e = t52Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.z93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                qz2.d(this.a);
                k32.i("navigateTo", "check pages success");
                dd3.F(true, this.b.Z().U());
                this.c.p();
                pc2.e f = pc2.f(this.c.getActivity(), uc2.c(this.d.a));
                t93.l(this.f, this.g, this.b, f.a.a(), this.d.a, t93.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.z93.e
        public void b(int i, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                k32.c("navigateTo", "check pages failed");
                dd3.F(false, this.b.Z().U());
                this.c.p();
                if (h83.b) {
                    Context context = this.i;
                    c63.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01df) + i).G();
                }
                t93.j(this.f, this.g, this.h);
                yc3.j(this.d, di3Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements pc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ t52 d;
        public final /* synthetic */ x93 e;

        public b(x93 x93Var, pc2.e eVar, String str, kw2 kw2Var, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x93Var, eVar, str, kw2Var, t52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x93Var;
            this.a = eVar;
            this.b = str;
            this.c = kw2Var;
            this.d = t52Var;
        }

        @Override // com.baidu.tieba.pc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (h83.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                qz2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (h83.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948255159, "Lcom/baidu/tieba/x93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948255159, "Lcom/baidu/tieba/x93;");
                return;
            }
        }
        d = rp2.g0().q();
        if (h83.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x93(h73 h73Var) {
        super(h73Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (h83.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            qz2.b(uuid);
            String o = t93.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                k32.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            xr2 V = xr2.V();
            t52 W = V.W();
            if (W == null) {
                k32.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            kw2 d2 = kw2.d(o, V.A());
            d2.e = "0";
            d2.f = uuid;
            yc3.g(d2);
            if (!ek3.b(V.t(), d2, false)) {
                k32.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                yc3.i(d2);
                return false;
            }
            String n = t93.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && k63.M() != null) {
                k63.M().M0(n, d2.d);
            }
            String n2 = t93.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = pz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (h83.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = kj3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                k32.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                yc3.i(d2);
                return false;
            } else if (x83.b().a(d2)) {
                x83.b().i("navigateTo", d2);
                k32.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                z93.g(k63Var, d2, "", new a(this, uuid, k63Var, V, d2, W, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(rs1 rs1Var, kw2 kw2Var, t52 t52Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs1Var, kw2Var, t52Var, str) == null) && (activity = xr2.V().getActivity()) != null && !activity.isFinishing()) {
            t93.e(rs1Var, kw2Var, str);
            qz2.c(0, str);
            if (t52Var.k() < d) {
                s52.Z3(ek3.n());
                t52.b i = t52Var.i("navigateTo");
                i.n(t52.g, t52.i);
                i.k("normal", kw2Var).b();
                ui3.c(t52Var, this.c);
                pz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                qz2.a(str, kw2Var);
                return;
            }
            fw1.B(t52Var, kw2Var, str, true);
        }
    }

    public final void p(pc2.e eVar, kw2 kw2Var, t52 t52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, kw2Var, t52Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = pz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (h83.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            pc2.q(eVar, new b(this, eVar, str, kw2Var, t52Var));
            if (h83.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
