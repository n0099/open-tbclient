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
import com.baidu.tieba.ih2;
import com.baidu.tieba.ma2;
import com.baidu.tieba.se3;
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
public class qe3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes7.dex */
    public class a implements se3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ db3 b;
        public final /* synthetic */ qw2 c;
        public final /* synthetic */ d13 d;
        public final /* synthetic */ ma2 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ qe3 j;

        public a(qe3 qe3Var, String str, db3 db3Var, qw2 qw2Var, d13 d13Var, ma2 ma2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qe3Var, str, db3Var, qw2Var, d13Var, ma2Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = qe3Var;
            this.a = str;
            this.b = db3Var;
            this.c = qw2Var;
            this.d = d13Var;
            this.e = ma2Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.se3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                j43.d(this.a);
                d82.i("navigateTo", "check pages success");
                wh3.F(true, this.b.Y().T());
                this.c.o();
                ih2.e f = ih2.f(this.c.getActivity(), nh2.c(this.d.a));
                me3.l(this.f, this.g, this.b, f.a.a(), this.d.a, me3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.se3.e
        public void b(int i, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                d82.c("navigateTo", "check pages failed");
                wh3.F(false, this.b.Y().T());
                this.c.o();
                if (ad3.b) {
                    Context context = this.i;
                    va3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d5) + i).G();
                }
                me3.j(this.f, this.g, this.h);
                rh3.j(this.d, wm3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ih2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ d13 c;
        public final /* synthetic */ ma2 d;
        public final /* synthetic */ qe3 e;

        public b(qe3 qe3Var, ih2.e eVar, String str, d13 d13Var, ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qe3Var, eVar, str, d13Var, ma2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qe3Var;
            this.a = eVar;
            this.b = str;
            this.c = d13Var;
            this.d = ma2Var;
        }

        @Override // com.baidu.tieba.ih2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ad3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                j43.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (ad3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948088906, "Lcom/baidu/tieba/qe3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948088906, "Lcom/baidu/tieba/qe3;");
                return;
            }
        }
        d = ku2.g0().q();
        if (ad3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qe3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (ad3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            j43.b(uuid);
            String o = me3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d82.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            qw2 T2 = qw2.T();
            ma2 U = T2.U();
            if (U == null) {
                d82.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d13 d2 = d13.d(o, T2.z());
            d2.e = "0";
            d2.f = uuid;
            rh3.g(d2);
            if (!xo3.b(T2.s(), d2, false)) {
                d82.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                rh3.i(d2);
                return false;
            }
            String n = me3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && db3.M() != null) {
                db3.M().L0(n, d2.d);
            }
            String n2 = me3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = i43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (ad3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = do3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d82.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                rh3.i(d2);
                return false;
            } else if (qd3.b().a(d2)) {
                qd3.b().i("navigateTo", d2);
                d82.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                se3.g(db3Var, d2, "", new a(this, uuid, db3Var, T2, d2, U, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(jx1 jx1Var, d13 d13Var, ma2 ma2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jx1Var, d13Var, ma2Var, str) == null) && (activity = qw2.T().getActivity()) != null && !activity.isFinishing()) {
            me3.e(jx1Var, d13Var, str);
            j43.c(0, str);
            if (ma2Var.k() < d) {
                la2.U3(xo3.n());
                ma2.b i = ma2Var.i("navigateTo");
                i.n(ma2.g, ma2.i);
                i.k("normal", d13Var).b();
                nn3.c(ma2Var, this.c);
                i43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                j43.a(str, d13Var);
                return;
            }
            x02.A(ma2Var, d13Var, str, true);
        }
    }

    public final void p(ih2.e eVar, d13 d13Var, ma2 ma2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, d13Var, ma2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = i43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (ad3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ih2.q(eVar, new b(this, eVar, str, d13Var, ma2Var));
            if (ad3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
