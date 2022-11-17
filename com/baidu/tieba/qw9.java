package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class qw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public qw9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(qw9 qw9Var, kw9 kw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qw9Var, kw9Var) == null) {
            int length = qw9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                qw9Var.c[i2] = i;
                nw9.n(qw9Var.a, qw9Var.b, i, kw9Var);
                i += 1080;
            }
        }
    }

    public static void b(qw9 qw9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, qw9Var, i, i2) == null) {
            qw9Var.a = i;
            qw9Var.b = new int[i2 * 1080];
            qw9Var.c = new int[i2];
        }
    }
}
