package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class s5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public s5b() {
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

    public static void a(s5b s5bVar, m5b m5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, s5bVar, m5bVar) == null) {
            int length = s5bVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                s5bVar.c[i2] = i;
                p5b.n(s5bVar.a, s5bVar.b, i, m5bVar);
                i += 1080;
            }
        }
    }

    public static void b(s5b s5bVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, s5bVar, i, i2) == null) {
            s5bVar.a = i;
            s5bVar.b = new int[i2 * 1080];
            s5bVar.c = new int[i2];
        }
    }
}
