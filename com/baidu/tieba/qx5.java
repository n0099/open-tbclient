package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qx5() {
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

    public static void b(g85 g85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, g85Var) != null) || g85Var == null) {
            return;
        }
        if (g85Var.b != 0) {
            f55.m().B("app_entrance_nologin", g85Var.b + "");
        }
        if (g85Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            f55.m().B("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), g85Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                s = f55.m().s("app_entrance_nologin", "");
            } else {
                f55 m = f55.m();
                s = m.s("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = gg.e(s, 0);
            if (e != 1 && e == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
