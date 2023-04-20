package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class yza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public yza() {
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

    public static void a(yza yzaVar, sza szaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, yzaVar, szaVar) == null) {
            int length = yzaVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                yzaVar.c[i2] = i;
                vza.n(yzaVar.a, yzaVar.b, i, szaVar);
                i += 1080;
            }
        }
    }

    public static void b(yza yzaVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, yzaVar, i, i2) == null) {
            yzaVar.a = i;
            yzaVar.b = new int[i2 * 1080];
            yzaVar.c = new int[i2];
        }
    }
}
