package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class lyb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public lyb() {
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

    public static void a(lyb lybVar, fyb fybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, lybVar, fybVar) == null) {
            int length = lybVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                lybVar.c[i2] = i;
                iyb.n(lybVar.a, lybVar.b, i, fybVar);
                i += 1080;
            }
        }
    }

    public static void b(lyb lybVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, lybVar, i, i2) == null) {
            lybVar.a = i;
            lybVar.b = new int[i2 * 1080];
            lybVar.c = new int[i2];
        }
    }
}
