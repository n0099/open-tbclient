package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class kyb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public kyb() {
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

    public static void a(kyb kybVar, eyb eybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, kybVar, eybVar) == null) {
            int length = kybVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                kybVar.c[i2] = i;
                hyb.n(kybVar.a, kybVar.b, i, eybVar);
                i += 1080;
            }
        }
    }

    public static void b(kyb kybVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, kybVar, i, i2) == null) {
            kybVar.a = i;
            kybVar.b = new int[i2 * 1080];
            kybVar.c = new int[i2];
        }
    }
}
