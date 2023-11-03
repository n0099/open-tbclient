package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class vgc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public vgc() {
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

    public static void a(vgc vgcVar, pgc pgcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vgcVar, pgcVar) == null) {
            int length = vgcVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                vgcVar.c[i2] = i;
                sgc.n(vgcVar.a, vgcVar.b, i, pgcVar);
                i += 1080;
            }
        }
    }

    public static void b(vgc vgcVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, vgcVar, i, i2) == null) {
            vgcVar.a = i;
            vgcVar.b = new int[i2 * 1080];
            vgcVar.c = new int[i2];
        }
    }
}
