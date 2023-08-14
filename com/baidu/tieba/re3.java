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
import com.baidu.tieba.dh2;
import com.baidu.tieba.ha2;
import com.baidu.tieba.ne3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class re3 extends vc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ne3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lw2 b;
        public final /* synthetic */ ha2 c;
        public final /* synthetic */ y03 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ re3 i;

        /* renamed from: com.baidu.tieba.re3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0466a implements dh2.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dh2.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0466a(a aVar, dh2.e eVar, JSONObject jSONObject) {
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

            @Override // com.baidu.tieba.dh2.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e43.e(this.a, this.c.a);
                    ex1 ex1Var = this.a.a;
                    a aVar = this.c;
                    he3.e(ex1Var, aVar.d, aVar.a);
                    e43.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(re3 re3Var, String str, lw2 lw2Var, ha2 ha2Var, y03 y03Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re3Var, str, lw2Var, ha2Var, y03Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = re3Var;
            this.a = str;
            this.b = lw2Var;
            this.c = ha2Var;
            this.d = y03Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.baidu.tieba.ne3.e
        public void a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                e43.d(this.a);
                this.b.o();
                ga2 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.y3(this.d.d))) {
                    JSONObject c = he3.c(l.y3(this.d.d));
                    e43.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                dh2.e f = dh2.f(this.b.getActivity(), ih2.c(this.d.d));
                JSONObject c2 = he3.c(str);
                HybridUbcFlow q = d43.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f.b) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                q.D("preload", str2);
                dh2.q(f, new C0466a(this, f, c2));
            }
        }

        @Override // com.baidu.tieba.ne3.e
        public void b(int i, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rm3Var) == null) {
                this.b.o();
                if (vc3.b) {
                    Context context = this.g;
                    qa3.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01d4) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    he3.j(this.f, this.e, this.h);
                }
                mh3.j(this.d, rm3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha2 a;
        public final /* synthetic */ y03 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ re3 d;

        public b(re3 re3Var, ha2 ha2Var, y03 y03Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re3Var, ha2Var, y03Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = re3Var;
            this.a = ha2Var;
            this.b = y03Var;
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
    public re3(vb3 vb3Var) {
        super(vb3Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vb3Var};
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

    @Override // com.baidu.tieba.vc3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, ya3Var)) == null) {
            if (vc3.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            e43.b(uuid);
            String o = he3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                y72.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = yn3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            lw2 T2 = lw2.T();
            ha2 U = T2.U();
            if (U == null) {
                y72.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            y03 d = y03.d(o, T2.z());
            d.e = "4";
            d.f = uuid;
            mh3.g(d);
            if (!so3.c(T2.s(), d)) {
                y72.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                mh3.i(d);
                return false;
            }
            String n = he3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = d43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            T2.a();
            ne3.g(ya3Var, d, "", new a(this, uuid, T2, U, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            y72.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(ha2 ha2Var, y03 y03Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha2Var, y03Var, str) == null) {
            ga2.U3(so3.n());
            ha2.b i = ha2Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(y03Var).b();
            d43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            e43.a(str, y03Var);
        }
    }

    public final void n(ha2 ha2Var, y03 y03Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, ha2Var, y03Var, str) == null) {
            if (so3.O()) {
                m(ha2Var, y03Var, str);
            } else {
                so3.a0(new b(this, ha2Var, y03Var, str));
            }
        }
    }
}
