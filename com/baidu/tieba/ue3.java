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
import com.baidu.tieba.ih2;
import com.baidu.tieba.se3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes8.dex */
public class ue3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements se3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qw2 b;
        public final /* synthetic */ d13 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ db3 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ma2 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ ue3 j;

        public a(ue3 ue3Var, String str, qw2 qw2Var, d13 d13Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, String str2, ma2 ma2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str, qw2Var, d13Var, unitedSchemeEntity, callbackHandler, db3Var, str2, ma2Var, context};
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
            this.b = qw2Var;
            this.c = d13Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = db3Var;
            this.g = str2;
            this.h = ma2Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.se3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                j43.d(this.a);
                d82.i("redirect", "check pages success");
                this.b.o();
                ih2.e f = ih2.f(this.b.getActivity(), nh2.c(this.c.a));
                me3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.se3.e
        public void b(int i, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                d82.c("redirect", "check pages failed");
                this.b.o();
                if (ad3.b) {
                    Context context = this.i;
                    va3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d5) + i).G();
                }
                me3.j(this.d, this.e, this.g);
                rh3.j(this.c, wm3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ih2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ d13 c;
        public final /* synthetic */ ma2 d;

        public b(ue3 ue3Var, ih2.e eVar, String str, d13 d13Var, ma2 ma2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, eVar, str, d13Var, ma2Var};
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
            this.c = d13Var;
            this.d = ma2Var;
        }

        @Override // com.baidu.tieba.ih2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ad3.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                j43.e(this.a, this.b);
                me3.e(this.a.a, this.c, this.b);
                x02.A(this.d, this.c, this.b, false);
                if (ad3.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (ad3.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            j43.b(uuid);
            String o = me3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                d82.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            qw2 T2 = qw2.T();
            ma2 U = T2.U();
            if (U == null) {
                d82.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d13 d = d13.d(o, T2.z());
            d.e = "2";
            d.f = uuid;
            rh3.g(d);
            if (!xo3.b(T2.s(), d, false)) {
                d82.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                rh3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && db3.M() != null) {
                db3.M().L0(str, d.d);
            }
            String n = me3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = i43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (ad3.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = do3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d82.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                rh3.i(d);
                return false;
            } else if (qd3.b().a(d)) {
                qd3.b().i("redirectTo", d);
                d82.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                se3.g(db3Var, d, "", new a(this, uuid, T2, d, unitedSchemeEntity, callbackHandler, db3Var, optString, U, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(ih2.e eVar, d13 d13Var, ma2 ma2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, d13Var, ma2Var, str) == null) {
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
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            ih2.q(eVar, new b(this, eVar, str, d13Var, ma2Var));
            if (ad3.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
