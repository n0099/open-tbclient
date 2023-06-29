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
import com.baidu.tieba.hi2;
import com.baidu.tieba.lb2;
import com.baidu.tieba.rf3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vf3 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements rf3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ px2 b;
        public final /* synthetic */ lb2 c;
        public final /* synthetic */ c23 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ vf3 i;

        /* renamed from: com.baidu.tieba.vf3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0493a implements hi2.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hi2.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0493a(a aVar, hi2.e eVar, JSONObject jSONObject) {
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

            @Override // com.baidu.tieba.hi2.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    i53.e(this.a, this.c.a);
                    iy1 iy1Var = this.a.a;
                    a aVar = this.c;
                    lf3.e(iy1Var, aVar.d, aVar.a);
                    i53.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(vf3 vf3Var, String str, px2 px2Var, lb2 lb2Var, c23 c23Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, str, px2Var, lb2Var, c23Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = vf3Var;
            this.a = str;
            this.b = px2Var;
            this.c = lb2Var;
            this.d = c23Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.baidu.tieba.rf3.e
        public void a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                i53.d(this.a);
                this.b.o();
                kb2 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.y3(this.d.d))) {
                    JSONObject c = lf3.c(l.y3(this.d.d));
                    i53.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                hi2.e f = hi2.f(this.b.getActivity(), mi2.c(this.d.d));
                JSONObject c2 = lf3.c(str);
                HybridUbcFlow q = h53.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f.b) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                q.D("preload", str2);
                hi2.q(f, new C0493a(this, f, c2));
            }
        }

        @Override // com.baidu.tieba.rf3.e
        public void b(int i, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                this.b.o();
                if (zd3.b) {
                    Context context = this.g;
                    ub3.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01d4) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    lf3.j(this.f, this.e, this.h);
                }
                qi3.j(this.d, vn3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb2 a;
        public final /* synthetic */ c23 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ vf3 d;

        public b(vf3 vf3Var, lb2 lb2Var, c23 c23Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, lb2Var, c23Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vf3Var;
            this.a = lb2Var;
            this.b = c23Var;
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
    public vf3(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var};
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

    @Override // com.baidu.tieba.zd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            if (zd3.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            i53.b(uuid);
            String o = lf3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c92.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = cp3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            px2 T2 = px2.T();
            lb2 U = T2.U();
            if (U == null) {
                c92.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c23 d = c23.d(o, T2.z());
            d.e = "4";
            d.f = uuid;
            qi3.g(d);
            if (!wp3.c(T2.s(), d)) {
                c92.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                qi3.i(d);
                return false;
            }
            String n = lf3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = h53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            T2.a();
            rf3.g(cc3Var, d, "", new a(this, uuid, T2, U, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            c92.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(lb2 lb2Var, c23 c23Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lb2Var, c23Var, str) == null) {
            kb2.U3(wp3.n());
            lb2.b i = lb2Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(c23Var).b();
            h53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            i53.a(str, c23Var);
        }
    }

    public final void n(lb2 lb2Var, c23 c23Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, lb2Var, c23Var, str) == null) {
            if (wp3.O()) {
                m(lb2Var, c23Var, str);
            } else {
                wp3.a0(new b(this, lb2Var, c23Var, str));
            }
        }
    }
}
