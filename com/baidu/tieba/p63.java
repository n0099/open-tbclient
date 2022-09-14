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
import com.baidu.tieba.d92;
import com.baidu.tieba.n63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class p63 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements n63.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lo2 b;
        public final /* synthetic */ ys2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ y23 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ h22 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ p63 j;

        public a(p63 p63Var, String str, lo2 lo2Var, ys2 ys2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, y23 y23Var, String str2, h22 h22Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p63Var, str, lo2Var, ys2Var, unitedSchemeEntity, callbackHandler, y23Var, str2, h22Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = p63Var;
            this.a = str;
            this.b = lo2Var;
            this.c = ys2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = y23Var;
            this.g = str2;
            this.h = h22Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.n63.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ew2.d(this.a);
                yz1.i("redirect", "check pages success");
                this.b.o();
                d92.e f = d92.f(this.b.getActivity(), i92.c(this.c.a));
                h63.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.n63.e
        public void b(int i, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, re3Var) == null) {
                yz1.c("redirect", "check pages failed");
                this.b.o();
                if (v43.b) {
                    Context context = this.i;
                    q23.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                h63.j(this.d, this.e, this.g);
                m93.j(this.c, re3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;
        public final /* synthetic */ h22 d;

        public b(p63 p63Var, d92.e eVar, String str, ys2 ys2Var, h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p63Var, eVar, str, ys2Var, h22Var};
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
            this.c = ys2Var;
            this.d = h22Var;
        }

        @Override // com.baidu.tieba.d92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (v43.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                ew2.e(this.a, this.b);
                h63.e(this.a.a, this.c, this.b);
                ss1.A(this.d, this.c, this.b, false);
                if (v43.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p63(v33 v33Var) {
        super(v33Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v33Var};
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

    @Override // com.baidu.tieba.v43
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, y23Var)) == null) {
            if (v43.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            ew2.b(uuid);
            String o = h63.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                yz1.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            lo2 U = lo2.U();
            h22 V = U.V();
            if (V == null) {
                yz1.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            ys2 d = ys2.d(o, U.z());
            d.e = "2";
            d.f = uuid;
            m93.g(d);
            if (!sg3.b(U.s(), d, false)) {
                yz1.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                m93.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && y23.M() != null) {
                y23.M().L0(str, d.d);
            }
            String n = h63.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = dw2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (v43.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = yf3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                yz1.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                m93.i(d);
                return false;
            } else if (l53.b().a(d)) {
                l53.b().i("redirectTo", d);
                yz1.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                n63.g(y23Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, y23Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(d92.e eVar, ys2 ys2Var, h22 h22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, ys2Var, h22Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = dw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (v43.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            d92.q(eVar, new b(this, eVar, str, ys2Var, h22Var));
            if (v43.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
