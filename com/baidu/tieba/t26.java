package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t26() {
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

    public static void b(ec5 ec5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, ec5Var) != null) || ec5Var == null) {
            return;
        }
        if (ec5Var.b != 0) {
            SharedPrefHelper.getInstance().putString("app_entrance_nologin", ec5Var.b + "");
        }
        if (ec5Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            SharedPrefHelper.getInstance().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), ec5Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                string = SharedPrefHelper.getInstance().getString("app_entrance_nologin", "");
            } else {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                string = sharedPrefHelper.getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int i = JavaTypesHelper.toInt(string, 0);
            if (i != 1 && i == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
