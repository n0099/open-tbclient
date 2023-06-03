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
import com.baidu.tieba.di2;
import com.baidu.tieba.nf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class pf3 extends vd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements nf3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lx2 b;
        public final /* synthetic */ y13 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ yb3 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ hb2 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ pf3 j;

        public a(pf3 pf3Var, String str, lx2 lx2Var, y13 y13Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, yb3 yb3Var, String str2, hb2 hb2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf3Var, str, lx2Var, y13Var, unitedSchemeEntity, callbackHandler, yb3Var, str2, hb2Var, context};
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
            this.b = lx2Var;
            this.c = y13Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = yb3Var;
            this.g = str2;
            this.h = hb2Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.nf3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                e53.d(this.a);
                y82.i("redirect", "check pages success");
                this.b.o();
                di2.e f = di2.f(this.b.getActivity(), ii2.c(this.c.a));
                hf3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.nf3.e
        public void b(int i, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rn3Var) == null) {
                y82.c("redirect", "check pages failed");
                this.b.o();
                if (vd3.b) {
                    Context context = this.i;
                    qb3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d2) + i).G();
                }
                hf3.j(this.d, this.e, this.g);
                mi3.j(this.c, rn3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements di2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ y13 c;
        public final /* synthetic */ hb2 d;

        public b(pf3 pf3Var, di2.e eVar, String str, y13 y13Var, hb2 hb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf3Var, eVar, str, y13Var, hb2Var};
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
            this.c = y13Var;
            this.d = hb2Var;
        }

        @Override // com.baidu.tieba.di2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (vd3.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                e53.e(this.a, this.b);
                hf3.e(this.a.a, this.c, this.b);
                s12.A(this.d, this.c, this.b, false);
                if (vd3.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf3(vc3 vc3Var) {
        super(vc3Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vc3Var};
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

    @Override // com.baidu.tieba.vd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, yb3Var)) == null) {
            if (vd3.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            e53.b(uuid);
            String o = hf3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                y82.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            lx2 T2 = lx2.T();
            hb2 U = T2.U();
            if (U == null) {
                y82.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            y13 d = y13.d(o, T2.z());
            d.e = "2";
            d.f = uuid;
            mi3.g(d);
            if (!sp3.b(T2.s(), d, false)) {
                y82.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                mi3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && yb3.M() != null) {
                yb3.M().L0(str, d.d);
            }
            String n = hf3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = d53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (vd3.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = yo3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                y82.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                mi3.i(d);
                return false;
            } else if (le3.b().a(d)) {
                le3.b().i("redirectTo", d);
                y82.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                nf3.g(yb3Var, d, "", new a(this, uuid, T2, d, unitedSchemeEntity, callbackHandler, yb3Var, optString, U, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(di2.e eVar, y13 y13Var, hb2 hb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, y13Var, hb2Var, str) == null) {
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
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            di2.q(eVar, new b(this, eVar, str, y13Var, hb2Var));
            if (vd3.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
