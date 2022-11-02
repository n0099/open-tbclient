package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class iw2 implements xi3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements gw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UbcFlowEvent a;
        public final /* synthetic */ UbcFlowEvent b;
        public final /* synthetic */ iw2 c;

        public a(iw2 iw2Var, UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, ubcFlowEvent, ubcFlowEvent2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iw2Var;
            this.a = ubcFlowEvent;
            this.b = ubcFlowEvent2;
        }

        @Override // com.baidu.tieba.gw2
        public boolean a(jw2 jw2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jw2Var)) == null) {
                if (jw2Var == null) {
                    return false;
                }
                return this.c.c(jw2Var, this.a, this.b);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867845, "Lcom/baidu/tieba/iw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867845, "Lcom/baidu/tieba/iw2;");
                return;
            }
        }
        a = ok1.a;
    }

    public iw2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        hw2.f().g();
        if (a) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    public final boolean c(@NonNull jw2 jw2Var, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jw2Var, ubcFlowEvent, ubcFlowEvent2)) == null) {
            long b = jw2Var.b();
            if (b >= ubcFlowEvent.g() && b <= ubcFlowEvent2.g()) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xi3
    /* renamed from: d */
    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow) == null) {
            if (a) {
                Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
            }
            if (hybridUbcFlow == null) {
                return;
            }
            UbcFlowEvent g = hybridUbcFlow.g("naStart");
            UbcFlowEvent g2 = hybridUbcFlow.g("na_first_meaningful_paint");
            if (g != null && g2 != null) {
                hw2.f().h(new a(this, g, g2));
                hw2.f().a(hybridUbcFlow);
                if (a) {
                    Log.d("MaUpdateReporter", "na_start ts - " + g.g());
                    Log.d("MaUpdateReporter", "fmp_end ts - " + g2.g());
                    return;
                }
                return;
            }
            if (a) {
                if (g == null) {
                    Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                } else {
                    Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                }
            }
            hw2.f().c();
        }
    }
}
