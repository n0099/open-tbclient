package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sp1 implements is1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sp1() {
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

    @Override // com.baidu.tieba.is1
    public void a(Context context, dl3<Boolean> dl3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, dl3Var) != null) || dl3Var == null) {
            return;
        }
        dl3Var.a(null);
    }

    @Override // com.baidu.tieba.is1
    public void b(boolean z, dl3<String> dl3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, dl3Var) != null) || dl3Var == null) {
            return;
        }
        dl3Var.a(null);
    }

    @Override // com.baidu.tieba.is1
    public void c(Context context, dl3<String> dl3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, dl3Var) != null) || dl3Var == null) {
            return;
        }
        dl3Var.a(null);
    }

    @Override // com.baidu.tieba.is1
    public void d(dl3<Integer> dl3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, dl3Var) != null) || dl3Var == null) {
            return;
        }
        dl3Var.a(null);
    }
}
