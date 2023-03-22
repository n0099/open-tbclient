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
import com.baidu.tieba.c72;
import com.baidu.tieba.ib3;
import com.baidu.tieba.yd2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mb3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ib3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gt2 b;
        public final /* synthetic */ c72 c;
        public final /* synthetic */ tx2 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ mb3 i;

        /* renamed from: com.baidu.tieba.mb3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0333a implements yd2.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yd2.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0333a(a aVar, yd2.e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = eVar;
                this.b = jSONObject;
            }

            @Override // com.baidu.tieba.yd2.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    z03.e(this.a, this.c.a);
                    zt1 zt1Var = this.a.a;
                    a aVar = this.c;
                    cb3.e(zt1Var, aVar.d, aVar.a);
                    z03.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(mb3 mb3Var, String str, gt2 gt2Var, c72 c72Var, tx2 tx2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb3Var, str, gt2Var, c72Var, tx2Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = mb3Var;
            this.a = str;
            this.b = gt2Var;
            this.c = c72Var;
            this.d = tx2Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.baidu.tieba.ib3.e
        public void a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                z03.d(this.a);
                this.b.o();
                b72 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.z3(this.d.d))) {
                    JSONObject c = cb3.c(l.z3(this.d.d));
                    z03.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                yd2.e f = yd2.f(this.b.getActivity(), de2.c(this.d.d));
                JSONObject c2 = cb3.c(str);
                HybridUbcFlow q = y03.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f.b) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                q.D("preload", str2);
                yd2.q(f, new C0333a(this, f, c2));
            }
        }

        @Override // com.baidu.tieba.ib3.e
        public void b(int i, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                this.b.o();
                if (q93.b) {
                    Context context = this.g;
                    l73.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01aa) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    cb3.j(this.f, this.e, this.h);
                }
                he3.j(this.d, mj3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c72 a;
        public final /* synthetic */ tx2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ mb3 d;

        public b(mb3 mb3Var, c72 c72Var, tx2 tx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb3Var, c72Var, tx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mb3Var;
            this.a = c72Var;
            this.b = tx2Var;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.m(this.a, this.b, this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb3(q83 q83Var) {
        super(q83Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (q93.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            z03.b(uuid);
            String o = cb3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                t42.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = tk3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            gt2 U = gt2.U();
            c72 V = U.V();
            if (V == null) {
                t42.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            tx2 d = tx2.d(o, U.z());
            d.e = "4";
            d.f = uuid;
            he3.g(d);
            if (!nl3.c(U.s(), d)) {
                t42.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                he3.i(d);
                return false;
            }
            String n = cb3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = y03.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            ib3.g(t73Var, d, "", new a(this, uuid, U, V, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            t42.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c72 c72Var, tx2 tx2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c72Var, tx2Var, str) == null) {
            b72.V3(nl3.n());
            c72.b i = c72Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(tx2Var).b();
            y03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            z03.a(str, tx2Var);
        }
    }

    public final void n(c72 c72Var, tx2 tx2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, c72Var, tx2Var, str) == null) {
            if (nl3.O()) {
                m(c72Var, tx2Var, str);
            } else {
                nl3.a0(new b(this, c72Var, tx2Var, str));
            }
        }
    }
}
