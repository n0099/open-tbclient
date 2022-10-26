package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tm1 implements jp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tm1() {
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

    @Override // com.baidu.tieba.jp1
    public void a(Context context, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, fi3Var) != null) || fi3Var == null) {
            return;
        }
        fi3Var.a(null);
    }

    @Override // com.baidu.tieba.jp1
    public void b(boolean z, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, fi3Var) != null) || fi3Var == null) {
            return;
        }
        fi3Var.a(null);
    }

    @Override // com.baidu.tieba.jp1
    public void c(Context context, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, fi3Var) != null) || fi3Var == null) {
            return;
        }
        fi3Var.a(null);
    }

    @Override // com.baidu.tieba.jp1
    public void d(fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, fi3Var) != null) || fi3Var == null) {
            return;
        }
        fi3Var.a(null);
    }
}
