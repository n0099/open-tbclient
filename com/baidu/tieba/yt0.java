package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class yt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<ux0> a;

    public yt0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public void b(@NonNull ux0 ux0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ux0Var) == null) && !this.a.contains(ux0Var)) {
            p01.b(this.a, ux0Var);
        }
    }

    public void d(@NonNull ux0 ux0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ux0Var) == null) {
            p01.j(this.a, ux0Var);
        }
    }

    public void c(@NonNull nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nu0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ux0 ux0Var = (ux0) p01.d(this.a, i);
                if (ux0Var != null) {
                    if (i == 0) {
                        ux0Var.d(nu0Var);
                    } else {
                        ux0Var.d(nu0.a(nu0Var));
                    }
                }
            }
        }
    }
}
