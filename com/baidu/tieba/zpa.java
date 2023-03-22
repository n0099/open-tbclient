package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class zpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public zpa() {
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

    public static void a(zpa zpaVar, tpa tpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, zpaVar, tpaVar) == null) {
            int length = zpaVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                zpaVar.c[i2] = i;
                wpa.n(zpaVar.a, zpaVar.b, i, tpaVar);
                i += 1080;
            }
        }
    }

    public static void b(zpa zpaVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, zpaVar, i, i2) == null) {
            zpaVar.a = i;
            zpaVar.b = new int[i2 * 1080];
            zpaVar.c = new int[i2];
        }
    }
}
