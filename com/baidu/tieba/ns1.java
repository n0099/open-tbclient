package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ns1 implements dv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ns1() {
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

    @Override // com.baidu.tieba.dv1
    public void a(Context context, zn3<Boolean> zn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, zn3Var) != null) || zn3Var == null) {
            return;
        }
        zn3Var.a(null);
    }

    @Override // com.baidu.tieba.dv1
    public void b(boolean z, zn3<String> zn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, zn3Var) != null) || zn3Var == null) {
            return;
        }
        zn3Var.a(null);
    }

    @Override // com.baidu.tieba.dv1
    public void c(Context context, zn3<String> zn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, zn3Var) != null) || zn3Var == null) {
            return;
        }
        zn3Var.a(null);
    }

    @Override // com.baidu.tieba.dv1
    public void d(zn3<Integer> zn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, zn3Var) != null) || zn3Var == null) {
            return;
        }
        zn3Var.a(null);
    }
}
