package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class zz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public zz9() {
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

    public static void a(zz9 zz9Var, tz9 tz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, zz9Var, tz9Var) == null) {
            int length = zz9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                zz9Var.c[i2] = i;
                wz9.n(zz9Var.a, zz9Var.b, i, tz9Var);
                i += 1080;
            }
        }
    }

    public static void b(zz9 zz9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, zz9Var, i, i2) == null) {
            zz9Var.a = i;
            zz9Var.b = new int[i2 * 1080];
            zz9Var.c = new int[i2];
        }
    }
}
