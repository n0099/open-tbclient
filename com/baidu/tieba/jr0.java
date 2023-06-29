package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ta1 a;
    public dc1 b;

    public jr0(ir0 ir0Var, Context context) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ir0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (ir0Var != null) {
            num = Integer.valueOf(ir0Var.b());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            this.a = new ta1(context);
        } else if (num != null && num.intValue() == 0) {
            this.b = new dc1(context);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dc1 dc1Var = this.b;
            if (dc1Var != null) {
                dc1Var.i();
            }
            ta1 ta1Var = this.a;
            if (ta1Var != null) {
                ta1Var.h();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dc1 dc1Var = this.b;
            if (dc1Var != null) {
                dc1Var.l();
            }
            ta1 ta1Var = this.a;
            if (ta1Var != null) {
                ta1Var.k();
            }
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            dc1 dc1Var = this.b;
            if (dc1Var != null) {
                dc1Var.o(z);
            }
            ta1 ta1Var = this.a;
            if (ta1Var != null) {
                ta1Var.n(z);
            }
        }
    }
}
