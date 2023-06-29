package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p36() {
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

    public static void b(rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, rc5Var) != null) || rc5Var == null) {
            return;
        }
        if (rc5Var.b != 0) {
            r95.p().J("app_entrance_nologin", rc5Var.b + "");
        }
        if (rc5Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            r95.p().J("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), rc5Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                w = r95.p().w("app_entrance_nologin", "");
            } else {
                r95 p = r95.p();
                w = p.w("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = vg.e(w, 0);
            if (e != 1 && e == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
