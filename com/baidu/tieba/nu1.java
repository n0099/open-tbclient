package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nu1 implements dx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nu1() {
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

    @Override // com.baidu.tieba.dx1
    public void a(Context context, zp3<Boolean> zp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, zp3Var) != null) || zp3Var == null) {
            return;
        }
        zp3Var.a(null);
    }

    @Override // com.baidu.tieba.dx1
    public void b(boolean z, zp3<String> zp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, zp3Var) != null) || zp3Var == null) {
            return;
        }
        zp3Var.a(null);
    }

    @Override // com.baidu.tieba.dx1
    public void c(Context context, zp3<String> zp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, zp3Var) != null) || zp3Var == null) {
            return;
        }
        zp3Var.a(null);
    }

    @Override // com.baidu.tieba.dx1
    public void d(zp3<Integer> zp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, zp3Var) != null) || zp3Var == null) {
            return;
        }
        zp3Var.a(null);
    }
}
