package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class um5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public um5() {
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

    public static void b(q05 q05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, q05Var) == null) || q05Var == null) {
            return;
        }
        if (q05Var.b != 0) {
            ox4.k().y("app_entrance_nologin", q05Var.b + "");
        }
        if (q05Var.a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        ox4.k().y("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), q05Var.a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                q = ox4.k().q("app_entrance_nologin", "");
            } else {
                ox4 k = ox4.k();
                q = k.q("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = dh.e(q, 0);
            return (e != 1 && e == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}
