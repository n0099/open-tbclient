package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class jw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<f01> a;

    public jw0() {
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

    public void b(@NonNull f01 f01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, f01Var) == null) && !this.a.contains(f01Var)) {
            b31.b(this.a, f01Var);
        }
    }

    public void d(@NonNull f01 f01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f01Var) == null) {
            b31.j(this.a, f01Var);
        }
    }

    public void c(@NonNull yw0 yw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yw0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                f01 f01Var = (f01) b31.d(this.a, i);
                if (f01Var != null) {
                    if (i == 0) {
                        f01Var.d(yw0Var);
                    } else {
                        f01Var.d(yw0.a(yw0Var));
                    }
                }
            }
        }
    }
}
