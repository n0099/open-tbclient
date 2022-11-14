package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class pw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public pw9() {
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

    public static void a(pw9 pw9Var, jw9 jw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, pw9Var, jw9Var) == null) {
            int length = pw9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                pw9Var.c[i2] = i;
                mw9.n(pw9Var.a, pw9Var.b, i, jw9Var);
                i += 1080;
            }
        }
    }

    public static void b(pw9 pw9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, pw9Var, i, i2) == null) {
            pw9Var.a = i;
            pw9Var.b = new int[i2 * 1080];
            pw9Var.c = new int[i2];
        }
    }
}
