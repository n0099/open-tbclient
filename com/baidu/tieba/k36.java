package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k36() {
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

    public static void b(oc5 oc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, oc5Var) != null) || oc5Var == null) {
            return;
        }
        if (oc5Var.b != 0) {
            o95.p().J("app_entrance_nologin", oc5Var.b + "");
        }
        if (oc5Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            o95.p().J("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), oc5Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                w = o95.p().w("app_entrance_nologin", "");
            } else {
                o95 p = o95.p();
                w = p.w("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = ug.e(w, 0);
            if (e != 1 && e == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
