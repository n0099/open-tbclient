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
/* loaded from: classes7.dex */
public class zz2 implements om3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements xz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UbcFlowEvent a;
        public final /* synthetic */ UbcFlowEvent b;
        public final /* synthetic */ zz2 c;

        public a(zz2 zz2Var, UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var, ubcFlowEvent, ubcFlowEvent2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zz2Var;
            this.a = ubcFlowEvent;
            this.b = ubcFlowEvent2;
        }

        @Override // com.baidu.tieba.xz2
        public boolean a(a03 a03Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a03Var)) == null) {
                if (a03Var == null) {
                    return false;
                }
                return this.c.c(a03Var, this.a, this.b);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948377175, "Lcom/baidu/tieba/zz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948377175, "Lcom/baidu/tieba/zz2;");
                return;
            }
        }
        a = fo1.a;
    }

    public zz2() {
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
        yz2.f().g();
        if (a) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    public final boolean c(@NonNull a03 a03Var, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a03Var, ubcFlowEvent, ubcFlowEvent2)) == null) {
            long b = a03Var.b();
            if (b >= ubcFlowEvent.g() && b <= ubcFlowEvent2.g()) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om3
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
                yz2.f().h(new a(this, g, g2));
                yz2.f().a(hybridUbcFlow);
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
            yz2.f().c();
        }
    }
}
