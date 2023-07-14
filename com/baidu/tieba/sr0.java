package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class sr0 {
    public static /* synthetic */ Interceptable $ic;
    public static final sr0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948160888, "Lcom/baidu/tieba/sr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948160888, "Lcom/baidu/tieba/sr0;");
                return;
            }
        }
        a = new sr0();
    }

    public sr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean a(tr0 tr0Var, Context context, Intent intent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, tr0Var, context, intent)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            int b = oa1.b(context.getApplicationContext(), null);
            if (b == 0) {
                return false;
            }
            if ((2 == b || 1 == b || 4 == b) && intent != null) {
                intent.putExtra("downgrade_to_native", "1");
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
