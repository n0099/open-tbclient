package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qw3 implements nw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rw3 a;
    public boolean b;

    public qw3(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        c(context);
    }

    @Override // com.baidu.tieba.nw3
    public void b(int i) {
        rw3 rw3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && !this.b && (rw3Var = this.a) != null && rw3Var.c()) {
            rw3 rw3Var2 = this.a;
            if (rw3Var2.d(rw3Var2.a(), "", 0) != 0) {
                return;
            }
            this.b = true;
        }
    }

    @Override // com.baidu.tieba.nw3
    public void a() {
        rw3 rw3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b && (rw3Var = this.a) != null && rw3Var.c()) {
            this.b = false;
            rw3 rw3Var2 = this.a;
            rw3Var2.d(rw3Var2.a(), "", -1);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = rw3.b(context);
        }
    }
}
