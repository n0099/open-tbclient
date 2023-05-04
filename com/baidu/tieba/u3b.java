package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class u3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public u3b() {
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

    public static void a(u3b u3bVar, o3b o3bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, u3bVar, o3bVar) == null) {
            int length = u3bVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                u3bVar.c[i2] = i;
                r3b.n(u3bVar.a, u3bVar.b, i, o3bVar);
                i += 1080;
            }
        }
    }

    public static void b(u3b u3bVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, u3bVar, i, i2) == null) {
            u3bVar.a = i;
            u3bVar.b = new int[i2 * 1080];
            u3bVar.c = new int[i2];
        }
    }
}
