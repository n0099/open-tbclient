package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class rlc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public rlc() {
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

    public static void a(rlc rlcVar, llc llcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, rlcVar, llcVar) == null) {
            int length = rlcVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                rlcVar.c[i2] = i;
                olc.n(rlcVar.a, rlcVar.b, i, llcVar);
                i += 1080;
            }
        }
    }

    public static void b(rlc rlcVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, rlcVar, i, i2) == null) {
            rlcVar.a = i;
            rlcVar.b = new int[i2 * 1080];
            rlcVar.c = new int[i2];
        }
    }
}
