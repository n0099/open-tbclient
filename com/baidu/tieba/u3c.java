package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class u3c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public u3c() {
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

    public static void a(u3c u3cVar, o3c o3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, u3cVar, o3cVar) == null) {
            int length = u3cVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                u3cVar.c[i2] = i;
                r3c.n(u3cVar.a, u3cVar.b, i, o3cVar);
                i += 1080;
            }
        }
    }

    public static void b(u3c u3cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, u3cVar, i, i2) == null) {
            u3cVar.a = i;
            u3cVar.b = new int[i2 * 1080];
            u3cVar.c = new int[i2];
        }
    }
}
