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
import com.baidu.tieba.mh2;
import com.baidu.tieba.qa2;
import com.baidu.tieba.we3;
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
public class ue3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes8.dex */
    public class a implements we3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hb3 b;
        public final /* synthetic */ uw2 c;
        public final /* synthetic */ h13 d;
        public final /* synthetic */ qa2 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ ue3 j;

        public a(ue3 ue3Var, String str, hb3 hb3Var, uw2 uw2Var, h13 h13Var, qa2 qa2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str, hb3Var, uw2Var, h13Var, qa2Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = ue3Var;
            this.a = str;
            this.b = hb3Var;
            this.c = uw2Var;
            this.d = h13Var;
            this.e = qa2Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.we3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n43.d(this.a);
                h82.i("navigateTo", "check pages success");
                ai3.F(true, this.b.Y().T());
                this.c.o();
                mh2.e f = mh2.f(this.c.getActivity(), rh2.c(this.d.a));
                qe3.l(this.f, this.g, this.b, f.a.a(), this.d.a, qe3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.we3.e
        public void b(int i, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                h82.c("navigateTo", "check pages failed");
                ai3.F(false, this.b.Y().T());
                this.c.o();
                if (ed3.b) {
                    Context context = this.i;
                    za3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d5) + i).G();
                }
                qe3.j(this.f, this.g, this.h);
                vh3.j(this.d, an3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ qa2 d;
        public final /* synthetic */ ue3 e;

        public b(ue3 ue3Var, mh2.e eVar, String str, h13 h13Var, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, eVar, str, h13Var, qa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ue3Var;
            this.a = eVar;
            this.b = str;
            this.c = h13Var;
            this.d = qa2Var;
        }

        @Override // com.baidu.tieba.mh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ed3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                n43.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (ed3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948208070, "Lcom/baidu/tieba/ue3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948208070, "Lcom/baidu/tieba/ue3;");
                return;
            }
        }
        d = ou2.g0().q();
        if (ed3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            n43.b(uuid);
            String o = qe3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                h82.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            uw2 T2 = uw2.T();
            qa2 U = T2.U();
            if (U == null) {
                h82.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            h13 d2 = h13.d(o, T2.z());
            d2.e = "0";
            d2.f = uuid;
            vh3.g(d2);
            if (!bp3.b(T2.s(), d2, false)) {
                h82.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                vh3.i(d2);
                return false;
            }
            String n = qe3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && hb3.M() != null) {
                hb3.M().L0(n, d2.d);
            }
            String n2 = qe3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = m43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (ed3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = ho3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                vh3.i(d2);
                return false;
            } else if (ud3.b().a(d2)) {
                ud3.b().i("navigateTo", d2);
                h82.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                we3.g(hb3Var, d2, "", new a(this, uuid, hb3Var, T2, d2, U, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(nx1 nx1Var, h13 h13Var, qa2 qa2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nx1Var, h13Var, qa2Var, str) == null) && (activity = uw2.T().getActivity()) != null && !activity.isFinishing()) {
            qe3.e(nx1Var, h13Var, str);
            n43.c(0, str);
            if (qa2Var.k() < d) {
                pa2.U3(bp3.n());
                qa2.b i = qa2Var.i("navigateTo");
                i.n(qa2.g, qa2.i);
                i.k("normal", h13Var).b();
                rn3.c(qa2Var, this.c);
                m43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                n43.a(str, h13Var);
                return;
            }
            b12.A(qa2Var, h13Var, str, true);
        }
    }

    public final void p(mh2.e eVar, h13 h13Var, qa2 qa2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, h13Var, qa2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = m43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (ed3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            mh2.q(eVar, new b(this, eVar, str, h13Var, qa2Var));
            if (ed3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
