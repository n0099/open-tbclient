package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lo5() {
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

    public static void b(q15 q15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, q15Var) != null) || q15Var == null) {
            return;
        }
        if (q15Var.b != 0) {
            py4.k().y("app_entrance_nologin", q15Var.b + "");
        }
        if (q15Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            py4.k().y("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), q15Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                q = py4.k().q("app_entrance_nologin", "");
            } else {
                py4 k = py4.k();
                q = k.q("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = xg.e(q, 0);
            if (e != 1 && e == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
