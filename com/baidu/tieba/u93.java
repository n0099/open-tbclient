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
import com.baidu.tieba.mc2;
import com.baidu.tieba.q52;
import com.baidu.tieba.w93;
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
public class u93 extends e83 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes8.dex */
    public class a implements w93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h63 b;
        public final /* synthetic */ ur2 c;
        public final /* synthetic */ hw2 d;
        public final /* synthetic */ q52 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ u93 j;

        public a(u93 u93Var, String str, h63 h63Var, ur2 ur2Var, hw2 hw2Var, q52 q52Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u93Var, str, h63Var, ur2Var, hw2Var, q52Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = u93Var;
            this.a = str;
            this.b = h63Var;
            this.c = ur2Var;
            this.d = hw2Var;
            this.e = q52Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.w93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                nz2.d(this.a);
                h32.i("navigateTo", "check pages success");
                ad3.F(true, this.b.Z().U());
                this.c.p();
                mc2.e f = mc2.f(this.c.getActivity(), rc2.c(this.d.a));
                q93.l(this.f, this.g, this.b, f.a.a(), this.d.a, q93.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.w93.e
        public void b(int i, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ai3Var) == null) {
                h32.c("navigateTo", "check pages failed");
                ad3.F(false, this.b.Z().U());
                this.c.p();
                if (e83.b) {
                    Context context = this.i;
                    z53.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01df) + i).G();
                }
                q93.j(this.f, this.g, this.h);
                vc3.j(this.d, ai3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ q52 d;
        public final /* synthetic */ u93 e;

        public b(u93 u93Var, mc2.e eVar, String str, hw2 hw2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u93Var, eVar, str, hw2Var, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u93Var;
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
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                nz2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (e83.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165786, "Lcom/baidu/tieba/u93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165786, "Lcom/baidu/tieba/u93;");
                return;
            }
        }
        d = op2.g0().q();
        if (e83.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u93(e73 e73Var) {
        super(e73Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e73Var};
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

    @Override // com.baidu.tieba.e83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h63Var)) == null) {
            if (e83.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            nz2.b(uuid);
            String o = q93.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                h32.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ur2 V = ur2.V();
            q52 W = V.W();
            if (W == null) {
                h32.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hw2 d2 = hw2.d(o, V.A());
            d2.e = "0";
            d2.f = uuid;
            vc3.g(d2);
            if (!bk3.b(V.t(), d2, false)) {
                h32.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                vc3.i(d2);
                return false;
            }
            String n = q93.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && h63.M() != null) {
                h63.M().M0(n, d2.d);
            }
            String n2 = q93.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = mz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (e83.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = hj3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h32.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                vc3.i(d2);
                return false;
            } else if (u83.b().a(d2)) {
                u83.b().i("navigateTo", d2);
                h32.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                w93.g(h63Var, d2, "", new a(this, uuid, h63Var, V, d2, W, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(os1 os1Var, hw2 hw2Var, q52 q52Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, os1Var, hw2Var, q52Var, str) == null) && (activity = ur2.V().getActivity()) != null && !activity.isFinishing()) {
            q93.e(os1Var, hw2Var, str);
            nz2.c(0, str);
            if (q52Var.k() < d) {
                p52.Z3(bk3.n());
                q52.b i = q52Var.i("navigateTo");
                i.n(q52.g, q52.i);
                i.k("normal", hw2Var).b();
                ri3.c(q52Var, this.c);
                mz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                nz2.a(str, hw2Var);
                return;
            }
            cw1.B(q52Var, hw2Var, str, true);
        }
    }

    public final void p(mc2.e eVar, hw2 hw2Var, q52 q52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, hw2Var, q52Var, str) == null) {
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
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            mc2.q(eVar, new b(this, eVar, str, hw2Var, q52Var));
            if (e83.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
