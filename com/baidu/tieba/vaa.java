package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class vaa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public vaa() {
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

    public static void a(vaa vaaVar, paa paaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vaaVar, paaVar) == null) {
            int length = vaaVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                vaaVar.c[i2] = i;
                saa.n(vaaVar.a, vaaVar.b, i, paaVar);
                i += 1080;
            }
        }
    }

    public static void b(vaa vaaVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, vaaVar, i, i2) == null) {
            vaaVar.a = i;
            vaaVar.b = new int[i2 * 1080];
            vaaVar.c = new int[i2];
        }
    }
}
