package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class x9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public x9c() {
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

    public static void a(x9c x9cVar, r9c r9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, x9cVar, r9cVar) == null) {
            int length = x9cVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                x9cVar.c[i2] = i;
                u9c.n(x9cVar.a, x9cVar.b, i, r9cVar);
                i += 1080;
            }
        }
    }

    public static void b(x9c x9cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, x9cVar, i, i2) == null) {
            x9cVar.a = i;
            x9cVar.b = new int[i2 * 1080];
            x9cVar.c = new int[i2];
        }
    }
}
