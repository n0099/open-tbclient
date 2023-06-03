package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class vjb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public vjb() {
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

    public static void a(vjb vjbVar, pjb pjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vjbVar, pjbVar) == null) {
            int length = vjbVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                vjbVar.c[i2] = i;
                sjb.n(vjbVar.a, vjbVar.b, i, pjbVar);
                i += 1080;
            }
        }
    }

    public static void b(vjb vjbVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, vjbVar, i, i2) == null) {
            vjbVar.a = i;
            vjbVar.b = new int[i2 * 1080];
            vjbVar.c = new int[i2];
        }
    }
}
