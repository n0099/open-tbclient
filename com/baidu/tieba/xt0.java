package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class xt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<tx0> a;

    public xt0() {
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

    public void b(@NonNull tx0 tx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, tx0Var) == null) && !this.a.contains(tx0Var)) {
            o01.b(this.a, tx0Var);
        }
    }

    public void d(@NonNull tx0 tx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tx0Var) == null) {
            o01.j(this.a, tx0Var);
        }
    }

    public void c(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mu0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                tx0 tx0Var = (tx0) o01.d(this.a, i);
                if (tx0Var != null) {
                    if (i == 0) {
                        tx0Var.d(mu0Var);
                    } else {
                        tx0Var.d(mu0.a(mu0Var));
                    }
                }
            }
        }
    }
}
