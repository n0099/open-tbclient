package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.tieba.po2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q03 implements dl3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements dl3<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(q03 q03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) != null) || q03.b(hybridUbcFlow)) {
                return;
            }
            long f = hybridUbcFlow.f("na_first_meaningful_paint", "naStart");
            if (f <= 0) {
                f = hybridUbcFlow.f("na_first_paint", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("slave_first_rendered", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("fe_page_show", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("na_page_show", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("na_receive_intent", "naStart");
            }
            if (f <= 0) {
                f = System.currentTimeMillis();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("property_launch_cost", f);
            a33 e = a33.e();
            c33 c33Var = new c33(20, bundle);
            c33Var.f(true);
            e.h(c33Var);
            xz2.h().end(f);
            n03.e().f();
        }
    }

    public q03() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean b(HybridUbcFlow hybridUbcFlow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hybridUbcFlow)) == null) {
            if (hybridUbcFlow.p("performanceEnd") && !hybridUbcFlow.p("na_first_meaningful_paint")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dl3
    /* renamed from: c */
    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            hybridUbcFlow.J("670");
            hybridUbcFlow.D("preload_scene", "1");
            hybridUbcFlow.E("from", "swan");
            hybridUbcFlow.H("component_reporter", new lz2());
            hybridUbcFlow.H("component_reporter", new oy2());
            hybridUbcFlow.H("component_reporter", new iz2());
            hybridUbcFlow.H("component_reporter", new nz2());
            hybridUbcFlow.H("callback_on_submit", new po2.a());
            hybridUbcFlow.H("fmp_callback", new t03("fmp_callback"));
            hybridUbcFlow.H("fmp_callback", new h13());
            hybridUbcFlow.H("callback_on_submit", new t03("callback_on_submit"));
            hybridUbcFlow.H("callback_on_submit", new ii3());
            hybridUbcFlow.H("callback_on_submit", new a(this));
        }
    }
}
