package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.d92;
import com.baidu.tieba.h22;
import com.baidu.tieba.n63;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes4.dex */
public class l63 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes4.dex */
    public class a implements n63.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ y23 b;
        public final /* synthetic */ lo2 c;
        public final /* synthetic */ ys2 d;
        public final /* synthetic */ h22 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ l63 j;

        public a(l63 l63Var, String str, y23 y23Var, lo2 lo2Var, ys2 ys2Var, h22 h22Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l63Var, str, y23Var, lo2Var, ys2Var, h22Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = l63Var;
            this.a = str;
            this.b = y23Var;
            this.c = lo2Var;
            this.d = ys2Var;
            this.e = h22Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.n63.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ew2.d(this.a);
                yz1.i("navigateTo", "check pages success");
                r93.F(true, this.b.Y().T());
                this.c.o();
                d92.e f = d92.f(this.c.getActivity(), i92.c(this.d.a));
                h63.l(this.f, this.g, this.b, f.a.a(), this.d.a, h63.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.n63.e
        public void b(int i, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, re3Var) == null) {
                yz1.c("navigateTo", "check pages failed");
                r93.F(false, this.b.Y().T());
                this.c.o();
                if (v43.b) {
                    Context context = this.i;
                    q23.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                h63.j(this.f, this.g, this.h);
                m93.j(this.d, re3Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;
        public final /* synthetic */ h22 d;
        public final /* synthetic */ l63 e;

        public b(l63 l63Var, d92.e eVar, String str, ys2 ys2Var, h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l63Var, eVar, str, ys2Var, h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l63Var;
            this.a = eVar;
            this.b = str;
            this.c = ys2Var;
            this.d = h22Var;
        }

        @Override // com.baidu.tieba.d92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (v43.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                ew2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (v43.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894784, "Lcom/baidu/tieba/l63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894784, "Lcom/baidu/tieba/l63;");
                return;
            }
        }
        d = fm2.g0().q();
        if (v43.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l63(v33 v33Var) {
        super(v33Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v33Var};
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

    @Override // com.baidu.tieba.v43
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, y23Var)) == null) {
            if (v43.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            ew2.b(uuid);
            String o = h63.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                yz1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            lo2 U = lo2.U();
            h22 V = U.V();
            if (V == null) {
                yz1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            ys2 d2 = ys2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            m93.g(d2);
            if (!sg3.b(U.s(), d2, false)) {
                yz1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                m93.i(d2);
                return false;
            }
            String n = h63.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && y23.M() != null) {
                y23.M().L0(n, d2.d);
            }
            String n2 = h63.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = dw2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (v43.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = yf3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                yz1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                m93.i(d2);
                return false;
            } else if (l53.b().a(d2)) {
                l53.b().i("navigateTo", d2);
                yz1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                n63.g(y23Var, d2, "", new a(this, uuid, y23Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(ep1 ep1Var, ys2 ys2Var, h22 h22Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ep1Var, ys2Var, h22Var, str) == null) || (activity = lo2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        h63.e(ep1Var, ys2Var, str);
        ew2.c(0, str);
        if (h22Var.k() < d) {
            g22.S3(sg3.n());
            h22.b i = h22Var.i("navigateTo");
            i.n(h22.g, h22.i);
            i.k("normal", ys2Var).b();
            if3.c(h22Var, this.c);
            dw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ew2.a(str, ys2Var);
            return;
        }
        ss1.A(h22Var, ys2Var, str, true);
    }

    public final void p(d92.e eVar, ys2 ys2Var, h22 h22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, ys2Var, h22Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = dw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (v43.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            d92.q(eVar, new b(this, eVar, str, ys2Var, h22Var));
            if (v43.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
