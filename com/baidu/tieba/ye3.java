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
import com.baidu.tieba.mh2;
import com.baidu.tieba.we3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes8.dex */
public class ye3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements we3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uw2 b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ hb3 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ qa2 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ ye3 j;

        public a(ye3 ye3Var, String str, uw2 uw2Var, h13 h13Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var, String str2, qa2 qa2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye3Var, str, uw2Var, h13Var, unitedSchemeEntity, callbackHandler, hb3Var, str2, qa2Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = ye3Var;
            this.a = str;
            this.b = uw2Var;
            this.c = h13Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = hb3Var;
            this.g = str2;
            this.h = qa2Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.we3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n43.d(this.a);
                h82.i("redirect", "check pages success");
                this.b.o();
                mh2.e f = mh2.f(this.b.getActivity(), rh2.c(this.c.a));
                qe3.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.we3.e
        public void b(int i, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                h82.c("redirect", "check pages failed");
                this.b.o();
                if (ed3.b) {
                    Context context = this.i;
                    za3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d5) + i).G();
                }
                qe3.j(this.d, this.e, this.g);
                vh3.j(this.c, an3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ qa2 d;

        public b(ye3 ye3Var, mh2.e eVar, String str, h13 h13Var, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye3Var, eVar, str, h13Var, qa2Var};
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
            this.c = h13Var;
            this.d = qa2Var;
        }

        @Override // com.baidu.tieba.mh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ed3.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                n43.e(this.a, this.b);
                qe3.e(this.a.a, this.c, this.b);
                b12.A(this.d, this.c, this.b, false);
                if (ed3.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ye3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            n43.b(uuid);
            String o = qe3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                h82.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            uw2 T2 = uw2.T();
            qa2 U = T2.U();
            if (U == null) {
                h82.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            h13 d = h13.d(o, T2.z());
            d.e = "2";
            d.f = uuid;
            vh3.g(d);
            if (!bp3.b(T2.s(), d, false)) {
                h82.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                vh3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && hb3.M() != null) {
                hb3.M().L0(str, d.d);
            }
            String n = qe3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = m43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (ed3.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = ho3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                vh3.i(d);
                return false;
            } else if (ud3.b().a(d)) {
                ud3.b().i("redirectTo", d);
                h82.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                we3.g(hb3Var, d, "", new a(this, uuid, T2, d, unitedSchemeEntity, callbackHandler, hb3Var, optString, U, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(mh2.e eVar, h13 h13Var, qa2 qa2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, h13Var, qa2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = m43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (ed3.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            mh2.q(eVar, new b(this, eVar, str, h13Var, qa2Var));
            if (ed3.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
