package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ts1 implements jv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ts1() {
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

    @Override // com.baidu.tieba.jv1
    public void a(Context context, fo3<Boolean> fo3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, fo3Var) != null) || fo3Var == null) {
            return;
        }
        fo3Var.a(null);
    }

    @Override // com.baidu.tieba.jv1
    public void b(boolean z, fo3<String> fo3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, fo3Var) != null) || fo3Var == null) {
            return;
        }
        fo3Var.a(null);
    }

    @Override // com.baidu.tieba.jv1
    public void c(Context context, fo3<String> fo3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, fo3Var) != null) || fo3Var == null) {
            return;
        }
        fo3Var.a(null);
    }

    @Override // com.baidu.tieba.jv1
    public void d(fo3<Integer> fo3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, fo3Var) != null) || fo3Var == null) {
            return;
        }
        fo3Var.a(null);
    }
}
