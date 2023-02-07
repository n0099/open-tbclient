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
import com.baidu.tieba.bf2;
import com.baidu.tieba.f82;
import com.baidu.tieba.lc3;
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
public class jc3 extends ta3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes5.dex */
    public class a implements lc3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ w83 b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ wy2 d;
        public final /* synthetic */ f82 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ jc3 j;

        public a(jc3 jc3Var, String str, w83 w83Var, ju2 ju2Var, wy2 wy2Var, f82 f82Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc3Var, str, w83Var, ju2Var, wy2Var, f82Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = jc3Var;
            this.a = str;
            this.b = w83Var;
            this.c = ju2Var;
            this.d = wy2Var;
            this.e = f82Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.lc3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c23.d(this.a);
                w52.i("navigateTo", "check pages success");
                pf3.F(true, this.b.Y().T());
                this.c.o();
                bf2.e f = bf2.f(this.c.getActivity(), gf2.c(this.d.a));
                fc3.l(this.f, this.g, this.b, f.a.a(), this.d.a, fc3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.lc3.e
        public void b(int i, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, pk3Var) == null) {
                w52.c("navigateTo", "check pages failed");
                pf3.F(false, this.b.Y().T());
                this.c.o();
                if (ta3.b) {
                    Context context = this.i;
                    o83.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01aa) + i).G();
                }
                fc3.j(this.f, this.g, this.h);
                kf3.j(this.d, pk3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wy2 c;
        public final /* synthetic */ f82 d;
        public final /* synthetic */ jc3 e;

        public b(jc3 jc3Var, bf2.e eVar, String str, wy2 wy2Var, f82 f82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc3Var, eVar, str, wy2Var, f82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jc3Var;
            this.a = eVar;
            this.b = str;
            this.c = wy2Var;
            this.d = f82Var;
        }

        @Override // com.baidu.tieba.bf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ta3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                c23.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (ta3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947878447, "Lcom/baidu/tieba/jc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947878447, "Lcom/baidu/tieba/jc3;");
                return;
            }
        }
        d = ds2.g0().q();
        if (ta3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc3(t93 t93Var) {
        super(t93Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t93Var};
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

    @Override // com.baidu.tieba.ta3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, w83Var)) == null) {
            if (ta3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            c23.b(uuid);
            String o = fc3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                w52.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ju2 U = ju2.U();
            f82 V = U.V();
            if (V == null) {
                w52.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            wy2 d2 = wy2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            kf3.g(d2);
            if (!qm3.b(U.s(), d2, false)) {
                w52.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                kf3.i(d2);
                return false;
            }
            String n = fc3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && w83.M() != null) {
                w83.M().L0(n, d2.d);
            }
            String n2 = fc3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = b23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (ta3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = wl3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                w52.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                kf3.i(d2);
                return false;
            } else if (jb3.b().a(d2)) {
                jb3.b().i("navigateTo", d2);
                w52.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                lc3.g(w83Var, d2, "", new a(this, uuid, w83Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(cv1 cv1Var, wy2 wy2Var, f82 f82Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cv1Var, wy2Var, f82Var, str) == null) && (activity = ju2.U().getActivity()) != null && !activity.isFinishing()) {
            fc3.e(cv1Var, wy2Var, str);
            c23.c(0, str);
            if (f82Var.k() < d) {
                e82.S3(qm3.n());
                f82.b i = f82Var.i("navigateTo");
                i.n(f82.g, f82.i);
                i.k("normal", wy2Var).b();
                gl3.c(f82Var, this.c);
                b23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                c23.a(str, wy2Var);
                return;
            }
            qy1.A(f82Var, wy2Var, str, true);
        }
    }

    public final void p(bf2.e eVar, wy2 wy2Var, f82 f82Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, wy2Var, f82Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = b23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (ta3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            bf2.q(eVar, new b(this, eVar, str, wy2Var, f82Var));
            if (ta3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
