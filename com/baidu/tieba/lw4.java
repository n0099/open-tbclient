package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class lw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final lw4 a;
    @JvmField
    public static final ry4 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947957280, "Lcom/baidu/tieba/lw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947957280, "Lcom/baidu/tieba/lw4;");
                return;
            }
        }
        a = new lw4();
        ry4 a2 = jw4.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getKvCache()");
        b = a2;
    }

    public lw4() {
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

    public final String a(String dialogName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dialogName)) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            return ((Object) ry4.p("KEY_FREQUENCE_DIALOG_STRATEGY_COUNTER")) + '_' + dialogName;
        }
        return (String) invokeL.objValue;
    }

    public final void b(String dialogName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogName) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            b.x(a(dialogName), 0);
        }
    }

    public final void c(String dialogName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogName) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            String a2 = a(dialogName);
            ry4 ry4Var = b;
            ry4Var.x(a2, ry4Var.m(a2, 0) + 1);
        }
    }
}
