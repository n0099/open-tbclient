package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class t5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public t5b() {
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

    public static void a(t5b t5bVar, n5b n5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, t5bVar, n5bVar) == null) {
            int length = t5bVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                t5bVar.c[i2] = i;
                q5b.n(t5bVar.a, t5bVar.b, i, n5bVar);
                i += 1080;
            }
        }
    }

    public static void b(t5b t5bVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, t5bVar, i, i2) == null) {
            t5bVar.a = i;
            t5bVar.b = new int[i2 * 1080];
            t5bVar.c = new int[i2];
        }
    }
}
