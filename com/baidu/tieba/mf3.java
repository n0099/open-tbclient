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
import com.baidu.tieba.ei2;
import com.baidu.tieba.ib2;
import com.baidu.tieba.of3;
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
public class mf3 extends wd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes6.dex */
    public class a implements of3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zb3 b;
        public final /* synthetic */ mx2 c;
        public final /* synthetic */ z13 d;
        public final /* synthetic */ ib2 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ mf3 j;

        public a(mf3 mf3Var, String str, zb3 zb3Var, mx2 mx2Var, z13 z13Var, ib2 ib2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf3Var, str, zb3Var, mx2Var, z13Var, ib2Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = mf3Var;
            this.a = str;
            this.b = zb3Var;
            this.c = mx2Var;
            this.d = z13Var;
            this.e = ib2Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.of3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                f53.d(this.a);
                z82.i("navigateTo", "check pages success");
                si3.F(true, this.b.Y().T());
                this.c.o();
                ei2.e f = ei2.f(this.c.getActivity(), ji2.c(this.d.a));
                if3.l(this.f, this.g, this.b, f.a.a(), this.d.a, if3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.of3.e
        public void b(int i, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sn3Var) == null) {
                z82.c("navigateTo", "check pages failed");
                si3.F(false, this.b.Y().T());
                this.c.o();
                if (wd3.b) {
                    Context context = this.i;
                    rb3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d2) + i).G();
                }
                if3.j(this.f, this.g, this.h);
                ni3.j(this.d, sn3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ei2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ z13 c;
        public final /* synthetic */ ib2 d;
        public final /* synthetic */ mf3 e;

        public b(mf3 mf3Var, ei2.e eVar, String str, z13 z13Var, ib2 ib2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf3Var, eVar, str, z13Var, ib2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mf3Var;
            this.a = eVar;
            this.b = str;
            this.c = z13Var;
            this.d = ib2Var;
        }

        @Override // com.baidu.tieba.ei2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (wd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                f53.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (wd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947970703, "Lcom/baidu/tieba/mf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947970703, "Lcom/baidu/tieba/mf3;");
                return;
            }
        }
        d = gv2.g0().q();
        if (wd3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mf3(wc3 wc3Var) {
        super(wc3Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc3Var};
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

    @Override // com.baidu.tieba.wd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, zb3Var)) == null) {
            if (wd3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            f53.b(uuid);
            String o = if3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                z82.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            mx2 T2 = mx2.T();
            ib2 U = T2.U();
            if (U == null) {
                z82.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            z13 d2 = z13.d(o, T2.z());
            d2.e = "0";
            d2.f = uuid;
            ni3.g(d2);
            if (!tp3.b(T2.s(), d2, false)) {
                z82.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ni3.i(d2);
                return false;
            }
            String n = if3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && zb3.M() != null) {
                zb3.M().L0(n, d2.d);
            }
            String n2 = if3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = e53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (wd3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = zo3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                z82.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ni3.i(d2);
                return false;
            } else if (me3.b().a(d2)) {
                me3.b().i("navigateTo", d2);
                z82.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                of3.g(zb3Var, d2, "", new a(this, uuid, zb3Var, T2, d2, U, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(fy1 fy1Var, z13 z13Var, ib2 ib2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy1Var, z13Var, ib2Var, str) == null) && (activity = mx2.T().getActivity()) != null && !activity.isFinishing()) {
            if3.e(fy1Var, z13Var, str);
            f53.c(0, str);
            if (ib2Var.k() < d) {
                hb2.U3(tp3.n());
                ib2.b i = ib2Var.i("navigateTo");
                i.n(ib2.g, ib2.i);
                i.k("normal", z13Var).b();
                jo3.c(ib2Var, this.c);
                e53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                f53.a(str, z13Var);
                return;
            }
            t12.A(ib2Var, z13Var, str, true);
        }
    }

    public final void p(ei2.e eVar, z13 z13Var, ib2 ib2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, z13Var, ib2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = e53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (wd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ei2.q(eVar, new b(this, eVar, str, z13Var, ib2Var));
            if (wd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
