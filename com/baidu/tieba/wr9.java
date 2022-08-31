package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class wr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public wr9() {
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

    public static void a(wr9 wr9Var, qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, wr9Var, qr9Var) == null) {
            int length = wr9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                wr9Var.c[i2] = i;
                tr9.n(wr9Var.a, wr9Var.b, i, qr9Var);
                i += 1080;
            }
        }
    }

    public static void b(wr9 wr9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, wr9Var, i, i2) == null) {
            wr9Var.a = i;
            wr9Var.b = new int[i2 * 1080];
            wr9Var.c = new int[i2];
        }
    }
}
