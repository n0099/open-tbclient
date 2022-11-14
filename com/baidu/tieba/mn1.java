package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mn1 implements cq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mn1() {
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

    @Override // com.baidu.tieba.cq1
    public void a(Context context, yi3<Boolean> yi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, yi3Var) != null) || yi3Var == null) {
            return;
        }
        yi3Var.a(null);
    }

    @Override // com.baidu.tieba.cq1
    public void b(boolean z, yi3<String> yi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, yi3Var) != null) || yi3Var == null) {
            return;
        }
        yi3Var.a(null);
    }

    @Override // com.baidu.tieba.cq1
    public void c(Context context, yi3<String> yi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, yi3Var) != null) || yi3Var == null) {
            return;
        }
        yi3Var.a(null);
    }

    @Override // com.baidu.tieba.cq1
    public void d(yi3<Integer> yi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, yi3Var) != null) || yi3Var == null) {
            return;
        }
        yi3Var.a(null);
    }
}
