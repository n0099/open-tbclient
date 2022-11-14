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
/* loaded from: classes4.dex */
public final class jw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final jw4 a;
    @JvmField
    public static final py4 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897698, "Lcom/baidu/tieba/jw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897698, "Lcom/baidu/tieba/jw4;");
                return;
            }
        }
        a = new jw4();
        py4 a2 = hw4.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getKvCache()");
        b = a2;
    }

    public jw4() {
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
            return ((Object) py4.o("KEY_FREQUENCE_DIALOG_STRATEGY_COUNTER")) + '_' + dialogName;
        }
        return (String) invokeL.objValue;
    }

    public final void b(String dialogName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogName) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            b.w(a(dialogName), 0);
        }
    }

    public final void c(String dialogName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogName) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            String a2 = a(dialogName);
            py4 py4Var = b;
            py4Var.w(a2, py4Var.l(a2, 0) + 1);
        }
    }
}
