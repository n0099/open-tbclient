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
import com.baidu.tieba.ja2;
import com.baidu.tieba.t73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class v73 extends b63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements t73.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ rp2 b;
        public final /* synthetic */ eu2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ e43 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ n32 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ v73 j;

        public a(v73 v73Var, String str, rp2 rp2Var, eu2 eu2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var, String str2, n32 n32Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v73Var, str, rp2Var, eu2Var, unitedSchemeEntity, callbackHandler, e43Var, str2, n32Var, context};
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
            this.b = rp2Var;
            this.c = eu2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = e43Var;
            this.g = str2;
            this.h = n32Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.t73.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                kx2.d(this.a);
                e12.i("redirect", "check pages success");
                this.b.o();
                ja2.e f = ja2.f(this.b.getActivity(), oa2.c(this.c.a));
                n73.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.t73.e
        public void b(int i, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, xf3Var) == null) {
                e12.c("redirect", "check pages failed");
                this.b.o();
                if (b63.b) {
                    Context context = this.i;
                    w33.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                n73.j(this.d, this.e, this.g);
                sa3.j(this.c, xf3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ja2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ja2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ eu2 c;
        public final /* synthetic */ n32 d;

        public b(v73 v73Var, ja2.e eVar, String str, eu2 eu2Var, n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v73Var, eVar, str, eu2Var, n32Var};
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
            this.c = eu2Var;
            this.d = n32Var;
        }

        @Override // com.baidu.tieba.ja2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b63.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                kx2.e(this.a, this.b);
                n73.e(this.a.a, this.c, this.b);
                yt1.A(this.d, this.c, this.b, false);
                if (b63.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v73(b53 b53Var) {
        super(b53Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
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

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            if (b63.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            kx2.b(uuid);
            String o = n73.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                e12.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            rp2 U = rp2.U();
            n32 V = U.V();
            if (V == null) {
                e12.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eu2 d = eu2.d(o, U.z());
            d.e = "2";
            d.f = uuid;
            sa3.g(d);
            if (!yh3.b(U.s(), d, false)) {
                e12.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                sa3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && e43.M() != null) {
                e43.M().L0(str, d.d);
            }
            String n = n73.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = jx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (b63.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = eh3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                e12.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                sa3.i(d);
                return false;
            } else if (r63.b().a(d)) {
                r63.b().i("redirectTo", d);
                e12.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                t73.g(e43Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, e43Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(ja2.e eVar, eu2 eu2Var, n32 n32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, eu2Var, n32Var, str) == null) {
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
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            ja2.q(eVar, new b(this, eVar, str, eu2Var, n32Var));
            if (b63.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
