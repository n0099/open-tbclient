package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class ss0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<ow0> a;

    public ss0() {
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

    public void b(@NonNull ow0 ow0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ow0Var) == null) || this.a.contains(ow0Var)) {
            return;
        }
        jz0.b(this.a, ow0Var);
    }

    public void c(@NonNull ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ht0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ow0 ow0Var = (ow0) jz0.d(this.a, i);
                if (ow0Var != null) {
                    if (i == 0) {
                        ow0Var.d(ht0Var);
                    } else {
                        ow0Var.d(ht0.a(ht0Var));
                    }
                }
            }
        }
    }

    public void d(@NonNull ow0 ow0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ow0Var) == null) {
            jz0.j(this.a, ow0Var);
        }
    }
}
