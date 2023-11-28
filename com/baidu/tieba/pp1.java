package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pp1 implements fs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pp1() {
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

    @Override // com.baidu.tieba.fs1
    public void a(Context context, al3<Boolean> al3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, al3Var) != null) || al3Var == null) {
            return;
        }
        al3Var.a(null);
    }

    @Override // com.baidu.tieba.fs1
    public void b(boolean z, al3<String> al3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, al3Var) != null) || al3Var == null) {
            return;
        }
        al3Var.a(null);
    }

    @Override // com.baidu.tieba.fs1
    public void c(Context context, al3<String> al3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, al3Var) != null) || al3Var == null) {
            return;
        }
        al3Var.a(null);
    }

    @Override // com.baidu.tieba.fs1
    public void d(al3<Integer> al3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, al3Var) != null) || al3Var == null) {
            return;
        }
        al3Var.a(null);
    }
}
