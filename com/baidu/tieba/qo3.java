package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qo3 implements po3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ro3 a;
    public boolean b;

    public qo3(@NonNull Context context) {
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

    @Override // com.baidu.tieba.po3
    public void a() {
        ro3 ro3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b && (ro3Var = this.a) != null && ro3Var.b()) {
            this.b = false;
            this.a.c(6, "", new int[0]);
            this.a.c(3, "", new int[0]);
            this.a.c(12, "", new int[0]);
            this.a.c(9, "", new int[0]);
        }
    }

    @Override // com.baidu.tieba.po3
    public void b(int i) {
        ro3 ro3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && !this.b && (ro3Var = this.a) != null && ro3Var.b() && this.a.c(12, "", new int[0]) == 0) {
            this.b = true;
            this.a.c(5, "", new int[0]);
            this.a.c(2, "", new int[0]);
            this.a.c(11, "", new int[0]);
            this.a.c(8, "", new int[0]);
            this.a.c(39, "", new int[0]);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = ro3.a(context);
        }
    }
}
