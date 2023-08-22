package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ku1 implements ax1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ku1() {
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

    @Override // com.baidu.tieba.ax1
    public void a(Context context, wp3<Boolean> wp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, wp3Var) != null) || wp3Var == null) {
            return;
        }
        wp3Var.a(null);
    }

    @Override // com.baidu.tieba.ax1
    public void b(boolean z, wp3<String> wp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, wp3Var) != null) || wp3Var == null) {
            return;
        }
        wp3Var.a(null);
    }

    @Override // com.baidu.tieba.ax1
    public void c(Context context, wp3<String> wp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, wp3Var) != null) || wp3Var == null) {
            return;
        }
        wp3Var.a(null);
    }

    @Override // com.baidu.tieba.ax1
    public void d(wp3<Integer> wp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, wp3Var) != null) || wp3Var == null) {
            return;
        }
        wp3Var.a(null);
    }
}
