package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zn3 implements wn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ao3 a;
    public boolean b;

    public zn3(@NonNull Context context) {
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

    @Override // com.baidu.tieba.wn3
    public void a() {
        ao3 ao3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b && (ao3Var = this.a) != null && ao3Var.c()) {
            this.b = false;
            ao3 ao3Var2 = this.a;
            ao3Var2.d(ao3Var2.a(), "", -1);
        }
    }

    @Override // com.baidu.tieba.wn3
    public void b(int i) {
        ao3 ao3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.b || (ao3Var = this.a) == null || !ao3Var.c()) {
            return;
        }
        ao3 ao3Var2 = this.a;
        if (ao3Var2.d(ao3Var2.a(), "", 0) != 0) {
            return;
        }
        this.b = true;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = ao3.b(context);
        }
    }
}
