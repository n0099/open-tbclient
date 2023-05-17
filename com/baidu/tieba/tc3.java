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
import com.baidu.tieba.lf2;
import com.baidu.tieba.p82;
import com.baidu.tieba.vc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class tc3 extends db3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes7.dex */
    public class a implements vc3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ g93 b;
        public final /* synthetic */ tu2 c;
        public final /* synthetic */ gz2 d;
        public final /* synthetic */ p82 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ tc3 j;

        public a(tc3 tc3Var, String str, g93 g93Var, tu2 tu2Var, gz2 gz2Var, p82 p82Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc3Var, str, g93Var, tu2Var, gz2Var, p82Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = tc3Var;
            this.a = str;
            this.b = g93Var;
            this.c = tu2Var;
            this.d = gz2Var;
            this.e = p82Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.vc3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                m23.d(this.a);
                g62.i("navigateTo", "check pages success");
                zf3.F(true, this.b.Y().T());
                this.c.o();
                lf2.e f = lf2.f(this.c.getActivity(), qf2.c(this.d.a));
                pc3.l(this.f, this.g, this.b, f.a.a(), this.d.a, pc3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.vc3.e
        public void b(int i, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zk3Var) == null) {
                g62.c("navigateTo", "check pages failed");
                zf3.F(false, this.b.Y().T());
                this.c.o();
                if (db3.b) {
                    Context context = this.i;
                    y83.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d2) + i).G();
                }
                pc3.j(this.f, this.g, this.h);
                uf3.j(this.d, zk3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements lf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gz2 c;
        public final /* synthetic */ p82 d;
        public final /* synthetic */ tc3 e;

        public b(tc3 tc3Var, lf2.e eVar, String str, gz2 gz2Var, p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc3Var, eVar, str, gz2Var, p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tc3Var;
            this.a = eVar;
            this.b = str;
            this.c = gz2Var;
            this.d = p82Var;
        }

        @Override // com.baidu.tieba.lf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (db3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                m23.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (db3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948176357, "Lcom/baidu/tieba/tc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948176357, "Lcom/baidu/tieba/tc3;");
                return;
            }
        }
        d = ns2.g0().q();
        if (db3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tc3(da3 da3Var) {
        super(da3Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {da3Var};
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

    @Override // com.baidu.tieba.db3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g93Var)) == null) {
            if (db3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            m23.b(uuid);
            String o = pc3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                g62.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            tu2 U = tu2.U();
            p82 V = U.V();
            if (V == null) {
                g62.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            gz2 d2 = gz2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            uf3.g(d2);
            if (!an3.b(U.s(), d2, false)) {
                g62.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                uf3.i(d2);
                return false;
            }
            String n = pc3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && g93.M() != null) {
                g93.M().L0(n, d2.d);
            }
            String n2 = pc3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = l23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (db3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = gm3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g62.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                uf3.i(d2);
                return false;
            } else if (tb3.b().a(d2)) {
                tb3.b().i("navigateTo", d2);
                g62.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                vc3.g(g93Var, d2, "", new a(this, uuid, g93Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(mv1 mv1Var, gz2 gz2Var, p82 p82Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mv1Var, gz2Var, p82Var, str) == null) && (activity = tu2.U().getActivity()) != null && !activity.isFinishing()) {
            pc3.e(mv1Var, gz2Var, str);
            m23.c(0, str);
            if (p82Var.k() < d) {
                o82.V3(an3.n());
                p82.b i = p82Var.i("navigateTo");
                i.n(p82.g, p82.i);
                i.k("normal", gz2Var).b();
                ql3.c(p82Var, this.c);
                l23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                m23.a(str, gz2Var);
                return;
            }
            az1.A(p82Var, gz2Var, str, true);
        }
    }

    public final void p(lf2.e eVar, gz2 gz2Var, p82 p82Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, gz2Var, p82Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = l23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (db3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            lf2.q(eVar, new b(this, eVar, str, gz2Var, p82Var));
            if (db3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
