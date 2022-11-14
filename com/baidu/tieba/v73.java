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
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ka2;
import com.baidu.tieba.u73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class v73 extends c63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements u73.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sp2 b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ f43 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ o32 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ v73 j;

        public a(v73 v73Var, String str, sp2 sp2Var, fu2 fu2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, f43 f43Var, String str2, o32 o32Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v73Var, str, sp2Var, fu2Var, unitedSchemeEntity, callbackHandler, f43Var, str2, o32Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = v73Var;
            this.a = str;
            this.b = sp2Var;
            this.c = fu2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = f43Var;
            this.g = str2;
            this.h = o32Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.u73.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                lx2.d(this.a);
                f12.i("relaunch", "check pages success");
                this.b.o();
                ka2.e f = ka2.f(this.b.getActivity(), pa2.c(this.c.a));
                o73.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.u73.e
        public void b(int i, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, yf3Var) == null) {
                f12.c("relaunch", "check pages failed");
                this.b.o();
                if (c63.b) {
                    Context context = this.i;
                    x33.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                o73.j(this.d, this.e, this.g);
                ta3.j(this.c, yf3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ka2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ o32 d;

        public b(v73 v73Var, ka2.e eVar, String str, fu2 fu2Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v73Var, eVar, str, fu2Var, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = str;
            this.c = fu2Var;
            this.d = o32Var;
        }

        @Override // com.baidu.tieba.ka2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c63.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                lx2.e(this.a, this.b);
                o73.e(this.a.a, this.c, this.b);
                v73.o(this.d, this.c, this.b);
                if (c63.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v73(c53 c53Var) {
        super(c53Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c53Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void o(o32 o32Var, fu2 fu2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, o32Var, fu2Var, str) == null) {
            au1.y(o32Var, fu2Var, str);
        }
    }

    @Override // com.baidu.tieba.c63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, f43Var)) == null) {
            if (c63.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            lx2.b(uuid);
            String o = o73.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                f12.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            sp2 U = sp2.U();
            o32 V = U.V();
            if (V == null) {
                f12.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            fu2 d = fu2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            ta3.g(d);
            if (!zh3.b(U.s(), d, true)) {
                f12.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ta3.i(d);
                return false;
            }
            String n = o73.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && f43.M() != null) {
                f43.M().L0(n, d.d);
            }
            String n2 = o73.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = kx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = fh3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                f12.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ta3.i(d);
                return false;
            } else if (s63.b().a(d)) {
                s63.b().i("reLaunch", d);
                f12.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                u73.g(f43Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, f43Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(ka2.e eVar, fu2 fu2Var, o32 o32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, fu2Var, o32Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = kx2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (c63.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ka2.q(eVar, new b(this, eVar, str, fu2Var, o32Var));
            if (c63.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
