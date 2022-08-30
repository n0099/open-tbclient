package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class yr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public yr9() {
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

    public static void a(yr9 yr9Var, sr9 sr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, yr9Var, sr9Var) == null) {
            int length = yr9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                yr9Var.c[i2] = i;
                vr9.n(yr9Var.a, yr9Var.b, i, sr9Var);
                i += 1080;
            }
        }
    }

    public static void b(yr9 yr9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, yr9Var, i, i2) == null) {
            yr9Var.a = i;
            yr9Var.b = new int[i2 * 1080];
            yr9Var.c = new int[i2];
        }
    }
}
