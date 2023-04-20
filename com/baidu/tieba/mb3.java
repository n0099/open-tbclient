package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ae2;
import com.baidu.tieba.kb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class mb3 extends s93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements kb3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ it2 b;
        public final /* synthetic */ vx2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ v73 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ e72 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ mb3 j;

        public a(mb3 mb3Var, String str, it2 it2Var, vx2 vx2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, v73 v73Var, String str2, e72 e72Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb3Var, str, it2Var, vx2Var, unitedSchemeEntity, callbackHandler, v73Var, str2, e72Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = mb3Var;
            this.a = str;
            this.b = it2Var;
            this.c = vx2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = v73Var;
            this.g = str2;
            this.h = e72Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.kb3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b13.d(this.a);
                v42.i("redirect", "check pages success");
                this.b.o();
                ae2.e f = ae2.f(this.b.getActivity(), fe2.c(this.c.a));
                eb3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.kb3.e
        public void b(int i, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, oj3Var) == null) {
                v42.c("redirect", "check pages failed");
                this.b.o();
                if (s93.b) {
                    Context context = this.i;
                    n73.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01aa) + i).G();
                }
                eb3.j(this.d, this.e, this.g);
                je3.j(this.c, oj3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ae2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vx2 c;
        public final /* synthetic */ e72 d;

        public b(mb3 mb3Var, ae2.e eVar, String str, vx2 vx2Var, e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb3Var, eVar, str, vx2Var, e72Var};
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
            this.c = vx2Var;
            this.d = e72Var;
        }

        @Override // com.baidu.tieba.ae2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (s93.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                b13.e(this.a, this.b);
                eb3.e(this.a.a, this.c, this.b);
                px1.A(this.d, this.c, this.b, false);
                if (s93.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb3(s83 s83Var) {
        super(s83Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s83Var};
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

    @Override // com.baidu.tieba.s93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, v73Var)) == null) {
            if (s93.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            b13.b(uuid);
            String o = eb3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                v42.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            it2 U = it2.U();
            e72 V = U.V();
            if (V == null) {
                v42.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            vx2 d = vx2.d(o, U.z());
            d.e = "2";
            d.f = uuid;
            je3.g(d);
            if (!pl3.b(U.s(), d, false)) {
                v42.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                je3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && v73.M() != null) {
                v73.M().L0(str, d.d);
            }
            String n = eb3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = a13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (s93.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = vk3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v42.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                je3.i(d);
                return false;
            } else if (ia3.b().a(d)) {
                ia3.b().i("redirectTo", d);
                v42.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                kb3.g(v73Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, v73Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(ae2.e eVar, vx2 vx2Var, e72 e72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, vx2Var, e72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (s93.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            ae2.q(eVar, new b(this, eVar, str, vx2Var, e72Var));
            if (s93.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
