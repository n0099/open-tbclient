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
import com.baidu.tieba.ce2;
import com.baidu.tieba.g72;
import com.baidu.tieba.mb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class kb3 extends u93 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes5.dex */
    public class a implements mb3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ x73 b;
        public final /* synthetic */ kt2 c;
        public final /* synthetic */ xx2 d;
        public final /* synthetic */ g72 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ kb3 j;

        public a(kb3 kb3Var, String str, x73 x73Var, kt2 kt2Var, xx2 xx2Var, g72 g72Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, str, x73Var, kt2Var, xx2Var, g72Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = kb3Var;
            this.a = str;
            this.b = x73Var;
            this.c = kt2Var;
            this.d = xx2Var;
            this.e = g72Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.mb3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d13.d(this.a);
                x42.i("navigateTo", "check pages success");
                qe3.F(true, this.b.Y().T());
                this.c.o();
                ce2.e f = ce2.f(this.c.getActivity(), he2.c(this.d.a));
                gb3.l(this.f, this.g, this.b, f.a.a(), this.d.a, gb3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.mb3.e
        public void b(int i, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qj3Var) == null) {
                x42.c("navigateTo", "check pages failed");
                qe3.F(false, this.b.Y().T());
                this.c.o();
                if (u93.b) {
                    Context context = this.i;
                    p73.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                gb3.j(this.f, this.g, this.h);
                le3.j(this.d, qj3Var);
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
        public final /* synthetic */ kb3 e;

        public b(kb3 kb3Var, ce2.e eVar, String str, xx2 xx2Var, g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb3Var, eVar, str, xx2Var, g72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kb3Var;
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
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                d13.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (u93.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947907277, "Lcom/baidu/tieba/kb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947907277, "Lcom/baidu/tieba/kb3;");
                return;
            }
        }
        d = er2.g0().q();
        if (u93.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb3(u83 u83Var) {
        super(u83Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u83Var};
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

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, x73Var)) == null) {
            if (u93.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            d13.b(uuid);
            String o = gb3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                x42.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            kt2 U = kt2.U();
            g72 V = U.V();
            if (V == null) {
                x42.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            xx2 d2 = xx2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            le3.g(d2);
            if (!rl3.b(U.s(), d2, false)) {
                x42.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                le3.i(d2);
                return false;
            }
            String n = gb3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && x73.M() != null) {
                x73.M().L0(n, d2.d);
            }
            String n2 = gb3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = c13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (u93.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = xk3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                x42.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                le3.i(d2);
                return false;
            } else if (ka3.b().a(d2)) {
                ka3.b().i("navigateTo", d2);
                x42.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                mb3.g(x73Var, d2, "", new a(this, uuid, x73Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(du1 du1Var, xx2 xx2Var, g72 g72Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du1Var, xx2Var, g72Var, str) == null) && (activity = kt2.U().getActivity()) != null && !activity.isFinishing()) {
            gb3.e(du1Var, xx2Var, str);
            d13.c(0, str);
            if (g72Var.k() < d) {
                f72.V3(rl3.n());
                g72.b i = g72Var.i("navigateTo");
                i.n(g72.g, g72.i);
                i.k("normal", xx2Var).b();
                hk3.c(g72Var, this.c);
                c13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                d13.a(str, xx2Var);
                return;
            }
            rx1.A(g72Var, xx2Var, str, true);
        }
    }

    public final void p(ce2.e eVar, xx2 xx2Var, g72 g72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, xx2Var, g72Var, str) == null) {
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
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ce2.q(eVar, new b(this, eVar, str, xx2Var, g72Var));
            if (u93.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
