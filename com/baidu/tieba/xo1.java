package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xo1 implements nr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xo1() {
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

    @Override // com.baidu.tieba.nr1
    public void a(Context context, ik3<Boolean> ik3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, ik3Var) != null) || ik3Var == null) {
            return;
        }
        ik3Var.a(null);
    }

    @Override // com.baidu.tieba.nr1
    public void b(boolean z, ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, ik3Var) != null) || ik3Var == null) {
            return;
        }
        ik3Var.a(null);
    }

    @Override // com.baidu.tieba.nr1
    public void c(Context context, ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, ik3Var) != null) || ik3Var == null) {
            return;
        }
        ik3Var.a(null);
    }

    @Override // com.baidu.tieba.nr1
    public void d(ik3<Integer> ik3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ik3Var) != null) || ik3Var == null) {
            return;
        }
        ik3Var.a(null);
    }
}
