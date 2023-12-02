package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public abstract class xr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<sv0> a;

    public xr0() {
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

    public void b(@NonNull sv0 sv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sv0Var) == null) && !this.a.contains(sv0Var)) {
            ny0.b(this.a, sv0Var);
        }
    }

    public void d(@NonNull sv0 sv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sv0Var) == null) {
            ny0.j(this.a, sv0Var);
        }
    }

    public void c(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ms0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                sv0 sv0Var = (sv0) ny0.d(this.a, i);
                if (sv0Var != null) {
                    if (i == 0) {
                        sv0Var.d(ms0Var);
                    } else {
                        sv0Var.d(ms0.a(ms0Var));
                    }
                }
            }
        }
    }
}
