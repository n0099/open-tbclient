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
import com.baidu.tieba.di2;
import com.baidu.tieba.hb2;
import com.baidu.tieba.nf3;
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
public class lf3 extends vd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes6.dex */
    public class a implements nf3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yb3 b;
        public final /* synthetic */ lx2 c;
        public final /* synthetic */ y13 d;
        public final /* synthetic */ hb2 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ lf3 j;

        public a(lf3 lf3Var, String str, yb3 yb3Var, lx2 lx2Var, y13 y13Var, hb2 hb2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf3Var, str, yb3Var, lx2Var, y13Var, hb2Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = lf3Var;
            this.a = str;
            this.b = yb3Var;
            this.c = lx2Var;
            this.d = y13Var;
            this.e = hb2Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.nf3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                e53.d(this.a);
                y82.i("navigateTo", "check pages success");
                ri3.F(true, this.b.Y().T());
                this.c.o();
                di2.e f = di2.f(this.c.getActivity(), ii2.c(this.d.a));
                hf3.l(this.f, this.g, this.b, f.a.a(), this.d.a, hf3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.nf3.e
        public void b(int i, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rn3Var) == null) {
                y82.c("navigateTo", "check pages failed");
                ri3.F(false, this.b.Y().T());
                this.c.o();
                if (vd3.b) {
                    Context context = this.i;
                    qb3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d2) + i).G();
                }
                hf3.j(this.f, this.g, this.h);
                mi3.j(this.d, rn3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements di2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y13 c;
        public final /* synthetic */ hb2 d;
        public final /* synthetic */ lf3 e;

        public b(lf3 lf3Var, di2.e eVar, String str, y13 y13Var, hb2 hb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf3Var, eVar, str, y13Var, hb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = lf3Var;
            this.a = eVar;
            this.b = str;
            this.c = y13Var;
            this.d = hb2Var;
        }

        @Override // com.baidu.tieba.di2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (vd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                e53.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (vd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947940912, "Lcom/baidu/tieba/lf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947940912, "Lcom/baidu/tieba/lf3;");
                return;
            }
        }
        d = fv2.g0().q();
        if (vd3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lf3(vc3 vc3Var) {
        super(vc3Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vc3Var};
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

    @Override // com.baidu.tieba.vd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, yb3Var)) == null) {
            if (vd3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            e53.b(uuid);
            String o = hf3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                y82.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            lx2 T2 = lx2.T();
            hb2 U = T2.U();
            if (U == null) {
                y82.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            y13 d2 = y13.d(o, T2.z());
            d2.e = "0";
            d2.f = uuid;
            mi3.g(d2);
            if (!sp3.b(T2.s(), d2, false)) {
                y82.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                mi3.i(d2);
                return false;
            }
            String n = hf3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && yb3.M() != null) {
                yb3.M().L0(n, d2.d);
            }
            String n2 = hf3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = d53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (vd3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = yo3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                y82.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                mi3.i(d2);
                return false;
            } else if (le3.b().a(d2)) {
                le3.b().i("navigateTo", d2);
                y82.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                nf3.g(yb3Var, d2, "", new a(this, uuid, yb3Var, T2, d2, U, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(ey1 ey1Var, y13 y13Var, hb2 hb2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ey1Var, y13Var, hb2Var, str) == null) && (activity = lx2.T().getActivity()) != null && !activity.isFinishing()) {
            hf3.e(ey1Var, y13Var, str);
            e53.c(0, str);
            if (hb2Var.k() < d) {
                gb2.U3(sp3.n());
                hb2.b i = hb2Var.i("navigateTo");
                i.n(hb2.g, hb2.i);
                i.k("normal", y13Var).b();
                io3.c(hb2Var, this.c);
                d53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                e53.a(str, y13Var);
                return;
            }
            s12.A(hb2Var, y13Var, str, true);
        }
    }

    public final void p(di2.e eVar, y13 y13Var, hb2 hb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, y13Var, hb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = d53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (vd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            di2.q(eVar, new b(this, eVar, str, y13Var, hb2Var));
            if (vd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
