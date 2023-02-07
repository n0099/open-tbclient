package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class r9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public r9a() {
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

    public static void a(r9a r9aVar, l9a l9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, r9aVar, l9aVar) == null) {
            int length = r9aVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                r9aVar.c[i2] = i;
                o9a.n(r9aVar.a, r9aVar.b, i, l9aVar);
                i += 1080;
            }
        }
    }

    public static void b(r9a r9aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, r9aVar, i, i2) == null) {
            r9aVar.a = i;
            r9aVar.b = new int[i2 * 1080];
            r9aVar.c = new int[i2];
        }
    }
}
