package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vv3 implements sv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wv3 a;
    public boolean b;

    public vv3(@NonNull Context context) {
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

    @Override // com.baidu.tieba.sv3
    public void b(int i) {
        wv3 wv3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && !this.b && (wv3Var = this.a) != null && wv3Var.c()) {
            wv3 wv3Var2 = this.a;
            if (wv3Var2.d(wv3Var2.a(), "", 0) != 0) {
                return;
            }
            this.b = true;
        }
    }

    @Override // com.baidu.tieba.sv3
    public void a() {
        wv3 wv3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b && (wv3Var = this.a) != null && wv3Var.c()) {
            this.b = false;
            wv3 wv3Var2 = this.a;
            wv3Var2.d(wv3Var2.a(), "", -1);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = wv3.b(context);
        }
    }
}
