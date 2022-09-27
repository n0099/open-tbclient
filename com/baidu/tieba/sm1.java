package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sm1 implements ip1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sm1() {
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

    @Override // com.baidu.tieba.ip1
    public void a(Context context, ei3<Boolean> ei3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, ei3Var) == null) || ei3Var == null) {
            return;
        }
        ei3Var.a(null);
    }

    @Override // com.baidu.tieba.ip1
    public void b(boolean z, ei3<String> ei3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, ei3Var) == null) || ei3Var == null) {
            return;
        }
        ei3Var.a(null);
    }

    @Override // com.baidu.tieba.ip1
    public void c(Context context, ei3<String> ei3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, ei3Var) == null) || ei3Var == null) {
            return;
        }
        ei3Var.a(null);
    }

    @Override // com.baidu.tieba.ip1
    public void d(ei3<Integer> ei3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ei3Var) == null) || ei3Var == null) {
            return;
        }
        ei3Var.a(null);
    }
}
