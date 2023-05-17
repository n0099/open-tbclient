package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class wu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<sy0> a;

    public wu0() {
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

    public void b(@NonNull sy0 sy0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sy0Var) == null) && !this.a.contains(sy0Var)) {
            o11.b(this.a, sy0Var);
        }
    }

    public void d(@NonNull sy0 sy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sy0Var) == null) {
            o11.j(this.a, sy0Var);
        }
    }

    public void c(@NonNull lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lv0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                sy0 sy0Var = (sy0) o11.d(this.a, i);
                if (sy0Var != null) {
                    if (i == 0) {
                        sy0Var.d(lv0Var);
                    } else {
                        sy0Var.d(lv0.a(lv0Var));
                    }
                }
            }
        }
    }
}
