package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class qja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public qja() {
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

    public static void a(qja qjaVar, kja kjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qjaVar, kjaVar) == null) {
            int length = qjaVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                qjaVar.c[i2] = i;
                nja.n(qjaVar.a, qjaVar.b, i, kjaVar);
                i += 1080;
            }
        }
    }

    public static void b(qja qjaVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, qjaVar, i, i2) == null) {
            qjaVar.a = i;
            qjaVar.b = new int[i2 * 1080];
            qjaVar.c = new int[i2];
        }
    }
}
