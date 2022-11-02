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
import com.baidu.tieba.ja2;
import com.baidu.tieba.n32;
import com.baidu.tieba.t73;
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
public class r73 extends b63 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes5.dex */
    public class a implements t73.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e43 b;
        public final /* synthetic */ rp2 c;
        public final /* synthetic */ eu2 d;
        public final /* synthetic */ n32 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ r73 j;

        public a(r73 r73Var, String str, e43 e43Var, rp2 rp2Var, eu2 eu2Var, n32 n32Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r73Var, str, e43Var, rp2Var, eu2Var, n32Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = r73Var;
            this.a = str;
            this.b = e43Var;
            this.c = rp2Var;
            this.d = eu2Var;
            this.e = n32Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.t73.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                kx2.d(this.a);
                e12.i("navigateTo", "check pages success");
                xa3.F(true, this.b.Y().T());
                this.c.o();
                ja2.e f = ja2.f(this.c.getActivity(), oa2.c(this.d.a));
                n73.l(this.f, this.g, this.b, f.a.a(), this.d.a, n73.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.t73.e
        public void b(int i, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, xf3Var) == null) {
                e12.c("navigateTo", "check pages failed");
                xa3.F(false, this.b.Y().T());
                this.c.o();
                if (b63.b) {
                    Context context = this.i;
                    w33.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                n73.j(this.f, this.g, this.h);
                sa3.j(this.d, xf3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ja2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ eu2 c;
        public final /* synthetic */ n32 d;
        public final /* synthetic */ r73 e;

        public b(r73 r73Var, ja2.e eVar, String str, eu2 eu2Var, n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r73Var, eVar, str, eu2Var, n32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r73Var;
            this.a = eVar;
            this.b = str;
            this.c = eu2Var;
            this.d = n32Var;
        }

        @Override // com.baidu.tieba.ja2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b63.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                kx2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (b63.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948074491, "Lcom/baidu/tieba/r73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948074491, "Lcom/baidu/tieba/r73;");
                return;
            }
        }
        d = ln2.g0().q();
        if (b63.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r73(b53 b53Var) {
        super(b53Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
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

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            if (b63.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            kx2.b(uuid);
            String o = n73.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                e12.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            rp2 U = rp2.U();
            n32 V = U.V();
            if (V == null) {
                e12.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eu2 d2 = eu2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            sa3.g(d2);
            if (!yh3.b(U.s(), d2, false)) {
                e12.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                sa3.i(d2);
                return false;
            }
            String n = n73.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && e43.M() != null) {
                e43.M().L0(n, d2.d);
            }
            String n2 = n73.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = jx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (b63.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = eh3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                e12.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                sa3.i(d2);
                return false;
            } else if (r63.b().a(d2)) {
                r63.b().i("navigateTo", d2);
                e12.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                t73.g(e43Var, d2, "", new a(this, uuid, e43Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(kq1 kq1Var, eu2 eu2Var, n32 n32Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kq1Var, eu2Var, n32Var, str) == null) && (activity = rp2.U().getActivity()) != null && !activity.isFinishing()) {
            n73.e(kq1Var, eu2Var, str);
            kx2.c(0, str);
            if (n32Var.k() < d) {
                m32.S3(yh3.n());
                n32.b i = n32Var.i("navigateTo");
                i.n(n32.g, n32.i);
                i.k("normal", eu2Var).b();
                og3.c(n32Var, this.c);
                jx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                kx2.a(str, eu2Var);
                return;
            }
            yt1.A(n32Var, eu2Var, str, true);
        }
    }

    public final void p(ja2.e eVar, eu2 eu2Var, n32 n32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, eu2Var, n32Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = jx2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (b63.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ja2.q(eVar, new b(this, eVar, str, eu2Var, n32Var));
            if (b63.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
