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
import com.baidu.tieba.f72;
import com.baidu.tieba.j02;
import com.baidu.tieba.p43;
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
public class n43 extends x23 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes5.dex */
    public class a implements p43.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ a13 b;
        public final /* synthetic */ nm2 c;
        public final /* synthetic */ ar2 d;
        public final /* synthetic */ j02 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ n43 j;

        public a(n43 n43Var, String str, a13 a13Var, nm2 nm2Var, ar2 ar2Var, j02 j02Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n43Var, str, a13Var, nm2Var, ar2Var, j02Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = n43Var;
            this.a = str;
            this.b = a13Var;
            this.c = nm2Var;
            this.d = ar2Var;
            this.e = j02Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.p43.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                gu2.d(this.a);
                ay1.i("navigateTo", "check pages success");
                t73.F(true, this.b.Y().T());
                this.c.o();
                f72.e f = f72.f(this.c.getActivity(), k72.c(this.d.a));
                j43.l(this.f, this.g, this.b, f.a.a(), this.d.a, j43.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.p43.e
        public void b(int i, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                ay1.c("navigateTo", "check pages failed");
                t73.F(false, this.b.Y().T());
                this.c.o();
                if (x23.b) {
                    Context context = this.i;
                    s03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a6) + i).G();
                }
                j43.j(this.f, this.g, this.h);
                o73.j(this.d, tc3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ar2 c;
        public final /* synthetic */ j02 d;
        public final /* synthetic */ n43 e;

        public b(n43 n43Var, f72.e eVar, String str, ar2 ar2Var, j02 j02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n43Var, eVar, str, ar2Var, j02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n43Var;
            this.a = eVar;
            this.b = str;
            this.c = ar2Var;
            this.d = j02Var;
        }

        @Override // com.baidu.tieba.f72.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (x23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                gu2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (x23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947952444, "Lcom/baidu/tieba/n43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947952444, "Lcom/baidu/tieba/n43;");
                return;
            }
        }
        d = hk2.g0().r();
        if (x23.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n43(x13 x13Var) {
        super(x13Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x13Var};
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

    @Override // com.baidu.tieba.x23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, a13Var)) == null) {
            if (x23.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            gu2.b(uuid);
            String o = j43.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                ay1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            nm2 U = nm2.U();
            j02 V = U.V();
            if (V == null) {
                ay1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            ar2 d2 = ar2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            o73.g(d2);
            if (!ue3.b(U.s(), d2, false)) {
                ay1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                o73.i(d2);
                return false;
            }
            String n = j43.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && a13.M() != null) {
                a13.M().L0(n, d2.d);
            }
            String n2 = j43.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = fu2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (x23.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = ae3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ay1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                o73.i(d2);
                return false;
            } else if (n33.b().a(d2)) {
                n33.b().i("navigateTo", d2);
                ay1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                p43.g(a13Var, d2, "", new a(this, uuid, a13Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(gn1 gn1Var, ar2 ar2Var, j02 j02Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gn1Var, ar2Var, j02Var, str) == null) || (activity = nm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        j43.e(gn1Var, ar2Var, str);
        gu2.c(0, str);
        if (j02Var.k() < d) {
            i02.S3(ue3.n());
            j02.b i = j02Var.i("navigateTo");
            i.n(j02.g, j02.i);
            i.k("normal", ar2Var).b();
            kd3.c(j02Var, this.c);
            fu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            gu2.a(str, ar2Var);
            return;
        }
        uq1.A(j02Var, ar2Var, str, true);
    }

    public final void p(f72.e eVar, ar2 ar2Var, j02 j02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, ar2Var, j02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = fu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (x23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            f72.q(eVar, new b(this, eVar, str, ar2Var, j02Var));
            if (x23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
