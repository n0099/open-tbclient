package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class ur0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<pv0> a;

    public ur0() {
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

    public void b(@NonNull pv0 pv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pv0Var) == null) && !this.a.contains(pv0Var)) {
            ky0.b(this.a, pv0Var);
        }
    }

    public void d(@NonNull pv0 pv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pv0Var) == null) {
            ky0.j(this.a, pv0Var);
        }
    }

    public void c(@NonNull js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, js0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                pv0 pv0Var = (pv0) ky0.d(this.a, i);
                if (pv0Var != null) {
                    if (i == 0) {
                        pv0Var.d(js0Var);
                    } else {
                        pv0Var.d(js0.a(js0Var));
                    }
                }
            }
        }
    }
}
