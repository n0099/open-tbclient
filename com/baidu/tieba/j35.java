package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j35 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947832381, "Lcom/baidu/tieba/j35;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947832381, "Lcom/baidu/tieba/j35;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (ej.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return 3;
            }
            return ux4.k().l("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().c()) {
                int a2 = a();
                if (a2 != 2) {
                    if (a2 == 3) {
                        return R.drawable.obfuscated_res_0x7f080833;
                    }
                    if (a2 != 4) {
                        if (a2 != 6) {
                            if (a2 != 8) {
                                return R.drawable.obfuscated_res_0x7f080833;
                            }
                            return R.drawable.obfuscated_res_0x7f080830;
                        }
                        return R.drawable.obfuscated_res_0x7f080834;
                    }
                    return R.drawable.obfuscated_res_0x7f080831;
                }
                return R.drawable.obfuscated_res_0x7f08082f;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            long j = a;
            if (j >= 0) {
                return j;
            }
            if (!ej.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                a = ux4.k().m("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            }
            return a;
        }
        return invokeV.longValue;
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) && i > 0 && !ej.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            ux4.k().w("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i);
            ux4.k().D("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount());
            a = 0L;
        }
    }

    public static void e(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65541, null, j) == null) && !ej.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            ux4.k().x("key_shared_to_tb_friend_prefix_" + TbadkCoreApplication.getCurrentAccount(), j);
            a = j;
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            a = -1L;
        }
    }
}
