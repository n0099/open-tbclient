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
import com.baidu.tieba.hi2;
import com.baidu.tieba.lb2;
import com.baidu.tieba.rf3;
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
public class pf3 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes7.dex */
    public class a implements rf3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cc3 b;
        public final /* synthetic */ px2 c;
        public final /* synthetic */ c23 d;
        public final /* synthetic */ lb2 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ pf3 j;

        public a(pf3 pf3Var, String str, cc3 cc3Var, px2 px2Var, c23 c23Var, lb2 lb2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf3Var, str, cc3Var, px2Var, c23Var, lb2Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = pf3Var;
            this.a = str;
            this.b = cc3Var;
            this.c = px2Var;
            this.d = c23Var;
            this.e = lb2Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.rf3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                i53.d(this.a);
                c92.i("navigateTo", "check pages success");
                vi3.F(true, this.b.Y().T());
                this.c.o();
                hi2.e f = hi2.f(this.c.getActivity(), mi2.c(this.d.a));
                lf3.l(this.f, this.g, this.b, f.a.a(), this.d.a, lf3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.rf3.e
        public void b(int i, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                c92.c("navigateTo", "check pages failed");
                vi3.F(false, this.b.Y().T());
                this.c.o();
                if (zd3.b) {
                    Context context = this.i;
                    ub3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d4) + i).G();
                }
                lf3.j(this.f, this.g, this.h);
                qi3.j(this.d, vn3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements hi2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c23 c;
        public final /* synthetic */ lb2 d;
        public final /* synthetic */ pf3 e;

        public b(pf3 pf3Var, hi2.e eVar, String str, c23 c23Var, lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf3Var, eVar, str, c23Var, lb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = pf3Var;
            this.a = eVar;
            this.b = str;
            this.c = c23Var;
            this.d = lb2Var;
        }

        @Override // com.baidu.tieba.hi2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (zd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                i53.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (zd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948060076, "Lcom/baidu/tieba/pf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948060076, "Lcom/baidu/tieba/pf3;");
                return;
            }
        }
        d = jv2.g0().q();
        if (zd3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf3(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var};
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

    @Override // com.baidu.tieba.zd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            if (zd3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            i53.b(uuid);
            String o = lf3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c92.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            px2 T2 = px2.T();
            lb2 U = T2.U();
            if (U == null) {
                c92.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c23 d2 = c23.d(o, T2.z());
            d2.e = "0";
            d2.f = uuid;
            qi3.g(d2);
            if (!wp3.b(T2.s(), d2, false)) {
                c92.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                qi3.i(d2);
                return false;
            }
            String n = lf3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && cc3.M() != null) {
                cc3.M().L0(n, d2.d);
            }
            String n2 = lf3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = h53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (zd3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = cp3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c92.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                qi3.i(d2);
                return false;
            } else if (pe3.b().a(d2)) {
                pe3.b().i("navigateTo", d2);
                c92.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                rf3.g(cc3Var, d2, "", new a(this, uuid, cc3Var, T2, d2, U, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(iy1 iy1Var, c23 c23Var, lb2 lb2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iy1Var, c23Var, lb2Var, str) == null) && (activity = px2.T().getActivity()) != null && !activity.isFinishing()) {
            lf3.e(iy1Var, c23Var, str);
            i53.c(0, str);
            if (lb2Var.k() < d) {
                kb2.U3(wp3.n());
                lb2.b i = lb2Var.i("navigateTo");
                i.n(lb2.g, lb2.i);
                i.k("normal", c23Var).b();
                mo3.c(lb2Var, this.c);
                h53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                i53.a(str, c23Var);
                return;
            }
            w12.A(lb2Var, c23Var, str, true);
        }
    }

    public final void p(hi2.e eVar, c23 c23Var, lb2 lb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, c23Var, lb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = h53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (zd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            hi2.q(eVar, new b(this, eVar, str, c23Var, lb2Var));
            if (zd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
