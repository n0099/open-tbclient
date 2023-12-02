package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class qlc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public qlc() {
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

    public static void a(qlc qlcVar, klc klcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qlcVar, klcVar) == null) {
            int length = qlcVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                qlcVar.c[i2] = i;
                nlc.n(qlcVar.a, qlcVar.b, i, klcVar);
                i += 1080;
            }
        }
    }

    public static void b(qlc qlcVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, qlcVar, i, i2) == null) {
            qlcVar.a = i;
            qlcVar.b = new int[i2 * 1080];
            qlcVar.c = new int[i2];
        }
    }
}
