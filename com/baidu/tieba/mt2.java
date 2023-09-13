package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mt2 {
    public static /* synthetic */ Interceptable $ic;
    public static final qt2 a;
    public static volatile qt2 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements aq3<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(HybridUbcFlow hybridUbcFlow) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
                if (!TextUtils.equals(hybridUbcFlow.m().optString("type"), "3") && !hybridUbcFlow.p("na_first_meaningful_paint")) {
                    z = false;
                } else {
                    z = true;
                }
                mt2.b().b(z, hybridUbcFlow);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947984126, "Lcom/baidu/tieba/mt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947984126, "Lcom/baidu/tieba/mt2;");
                return;
            }
        }
        rt2 rt2Var = new rt2();
        a = rt2Var;
        b = rt2Var;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            b().c();
        }
    }

    @NonNull
    public static qt2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (qt2) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            f(a);
        }
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65539, null, i) == null) && i != 3) {
            b().c();
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            if (TextUtils.equals(str, "3")) {
                f(new pt2(str));
            } else {
                f(new ot2(str));
            }
        }
    }

    public static void f(@NonNull qt2 qt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, qt2Var) == null) {
            b = qt2Var;
        }
    }
}
