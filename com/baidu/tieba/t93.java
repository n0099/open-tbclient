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
import com.baidu.tieba.lc2;
import com.baidu.tieba.p52;
import com.baidu.tieba.v93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes8.dex */
public class t93 extends d83 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes8.dex */
    public class a implements v93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ g63 b;
        public final /* synthetic */ tr2 c;
        public final /* synthetic */ gw2 d;
        public final /* synthetic */ p52 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ t93 j;

        public a(t93 t93Var, String str, g63 g63Var, tr2 tr2Var, gw2 gw2Var, p52 p52Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t93Var, str, g63Var, tr2Var, gw2Var, p52Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = t93Var;
            this.a = str;
            this.b = g63Var;
            this.c = tr2Var;
            this.d = gw2Var;
            this.e = p52Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.v93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                mz2.d(this.a);
                g32.i("navigateTo", "check pages success");
                zc3.F(true, this.b.Z().U());
                this.c.p();
                lc2.e f = lc2.f(this.c.getActivity(), qc2.c(this.d.a));
                p93.l(this.f, this.g, this.b, f.a.a(), this.d.a, p93.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.v93.e
        public void b(int i, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zh3Var) == null) {
                g32.c("navigateTo", "check pages failed");
                zc3.F(false, this.b.Z().U());
                this.c.p();
                if (d83.b) {
                    Context context = this.i;
                    y53.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d7) + i).G();
                }
                p93.j(this.f, this.g, this.h);
                uc3.j(this.d, zh3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements lc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gw2 c;
        public final /* synthetic */ p52 d;
        public final /* synthetic */ t93 e;

        public b(t93 t93Var, lc2.e eVar, String str, gw2 gw2Var, p52 p52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t93Var, eVar, str, gw2Var, p52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t93Var;
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
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                mz2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (d83.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948135995, "Lcom/baidu/tieba/t93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948135995, "Lcom/baidu/tieba/t93;");
                return;
            }
        }
        d = np2.g0().q();
        if (d83.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t93(d73 d73Var) {
        super(d73Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d73Var};
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

    @Override // com.baidu.tieba.d83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g63Var)) == null) {
            if (d83.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            mz2.b(uuid);
            String o = p93.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                g32.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            tr2 V = tr2.V();
            p52 W = V.W();
            if (W == null) {
                g32.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            gw2 d2 = gw2.d(o, V.A());
            d2.e = "0";
            d2.f = uuid;
            uc3.g(d2);
            if (!ak3.b(V.t(), d2, false)) {
                g32.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                uc3.i(d2);
                return false;
            }
            String n = p93.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && g63.M() != null) {
                g63.M().M0(n, d2.d);
            }
            String n2 = p93.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = lz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (d83.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = gj3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g32.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                uc3.i(d2);
                return false;
            } else if (t83.b().a(d2)) {
                t83.b().i("navigateTo", d2);
                g32.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                v93.g(g63Var, d2, "", new a(this, uuid, g63Var, V, d2, W, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(ns1 ns1Var, gw2 gw2Var, p52 p52Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ns1Var, gw2Var, p52Var, str) == null) && (activity = tr2.V().getActivity()) != null && !activity.isFinishing()) {
            p93.e(ns1Var, gw2Var, str);
            mz2.c(0, str);
            if (p52Var.k() < d) {
                o52.Z3(ak3.n());
                p52.b i = p52Var.i("navigateTo");
                i.n(p52.g, p52.i);
                i.k("normal", gw2Var).b();
                qi3.c(p52Var, this.c);
                lz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                mz2.a(str, gw2Var);
                return;
            }
            bw1.B(p52Var, gw2Var, str, true);
        }
    }

    public final void p(lc2.e eVar, gw2 gw2Var, p52 p52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gw2Var, p52Var, str) == null) {
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
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            lc2.q(eVar, new b(this, eVar, str, gw2Var, p52Var));
            if (d83.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
