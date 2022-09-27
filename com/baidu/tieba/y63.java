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
import com.baidu.tieba.a73;
import com.baidu.tieba.q92;
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class y63 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes6.dex */
    public class a implements a73.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ l33 b;
        public final /* synthetic */ yo2 c;
        public final /* synthetic */ lt2 d;
        public final /* synthetic */ u22 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ y63 j;

        public a(y63 y63Var, String str, l33 l33Var, yo2 yo2Var, lt2 lt2Var, u22 u22Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y63Var, str, l33Var, yo2Var, lt2Var, u22Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = y63Var;
            this.a = str;
            this.b = l33Var;
            this.c = yo2Var;
            this.d = lt2Var;
            this.e = u22Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.a73.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                rw2.d(this.a);
                l02.i("navigateTo", "check pages success");
                ea3.F(true, this.b.Y().T());
                this.c.o();
                q92.e f = q92.f(this.c.getActivity(), v92.c(this.d.a));
                u63.l(this.f, this.g, this.b, f.a.a(), this.d.a, u63.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.a73.e
        public void b(int i, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ef3Var) == null) {
                l02.c("navigateTo", "check pages failed");
                ea3.F(false, this.b.Y().T());
                this.c.o();
                if (i53.b) {
                    Context context = this.i;
                    d33.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                u63.j(this.f, this.g, this.h);
                z93.j(this.d, ef3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements q92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lt2 c;
        public final /* synthetic */ u22 d;
        public final /* synthetic */ y63 e;

        public b(y63 y63Var, q92.e eVar, String str, lt2 lt2Var, u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y63Var, eVar, str, lt2Var, u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y63Var;
            this.a = eVar;
            this.b = str;
            this.c = lt2Var;
            this.d = u22Var;
        }

        @Override // com.baidu.tieba.q92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (i53.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                rw2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (i53.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948282067, "Lcom/baidu/tieba/y63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948282067, "Lcom/baidu/tieba/y63;");
                return;
            }
        }
        d = sm2.g0().q();
        if (i53.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y63(i43 i43Var) {
        super(i43Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
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

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (i53.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            rw2.b(uuid);
            String o = u63.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                l02.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            yo2 U = yo2.U();
            u22 V = U.V();
            if (V == null) {
                l02.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            lt2 d2 = lt2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            z93.g(d2);
            if (!fh3.b(U.s(), d2, false)) {
                l02.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                z93.i(d2);
                return false;
            }
            String n = u63.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && l33.M() != null) {
                l33.M().L0(n, d2.d);
            }
            String n2 = u63.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = qw2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (i53.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = lg3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                l02.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                z93.i(d2);
                return false;
            } else if (y53.b().a(d2)) {
                y53.b().i("navigateTo", d2);
                l02.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                a73.g(l33Var, d2, "", new a(this, uuid, l33Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(rp1 rp1Var, lt2 lt2Var, u22 u22Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rp1Var, lt2Var, u22Var, str) == null) || (activity = yo2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        u63.e(rp1Var, lt2Var, str);
        rw2.c(0, str);
        if (u22Var.k() < d) {
            t22.S3(fh3.n());
            u22.b i = u22Var.i("navigateTo");
            i.n(u22.g, u22.i);
            i.k("normal", lt2Var).b();
            vf3.c(u22Var, this.c);
            qw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            rw2.a(str, lt2Var);
            return;
        }
        ft1.A(u22Var, lt2Var, str, true);
    }

    public final void p(q92.e eVar, lt2 lt2Var, u22 u22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, lt2Var, u22Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = qw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (i53.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            q92.q(eVar, new b(this, eVar, str, lt2Var, u22Var));
            if (i53.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
