package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ln1 implements bq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ln1() {
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

    @Override // com.baidu.tieba.bq1
    public void a(Context context, xi3<Boolean> xi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, xi3Var) != null) || xi3Var == null) {
            return;
        }
        xi3Var.a(null);
    }

    @Override // com.baidu.tieba.bq1
    public void b(boolean z, xi3<String> xi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, xi3Var) != null) || xi3Var == null) {
            return;
        }
        xi3Var.a(null);
    }

    @Override // com.baidu.tieba.bq1
    public void c(Context context, xi3<String> xi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, xi3Var) != null) || xi3Var == null) {
            return;
        }
        xi3Var.a(null);
    }

    @Override // com.baidu.tieba.bq1
    public void d(xi3<Integer> xi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, xi3Var) != null) || xi3Var == null) {
            return;
        }
        xi3Var.a(null);
    }
}
