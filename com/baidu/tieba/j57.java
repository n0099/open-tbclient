package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int l = qy4.k().l("key_card_interest_close_click_num_" + currentAccount, 0);
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_CLICK).param("uid", currentAccount);
            if (l != 0) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            TiebaStatic.log(param.param("obj_param1", i2).param("obj_locate", i));
        }
    }

    public static void b() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int l = qy4.k().l("key_card_interest_close_click_num_" + currentAccount, 0);
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_SHOW).param("uid", currentAccount);
            if (l != 0) {
                i = 2;
            } else {
                i = 1;
            }
            TiebaStatic.log(param.param("obj_param1", i));
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!UbsABTestHelper.isRecommendCardInterestABTestA() || !h()) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            i25 homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
            if (homepageInterestConfig == null) {
                return false;
            }
            if (d(homepageInterestConfig)) {
                return true;
            }
            if (qy4.k().l("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
                if (c(homepageInterestConfig, currentAccount)) {
                    return true;
                }
            } else if (g(homepageInterestConfig)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            i25 homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
            if (homepageInterestConfig == null) {
                return false;
            }
            if (qy4.k().l("key_card_interest_close_click_num_" + currentAccount, 0) >= homepageInterestConfig.b()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            qy4.k().x("key_card_interest_close_click_time_" + currentAccount, System.currentTimeMillis());
            String str = "key_card_interest_close_click_num_" + currentAccount;
            qy4.k().w(str, qy4.k().l(str, 0) + 1);
        }
    }

    public static boolean c(i25 i25Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, i25Var, str)) == null) {
            long m = qy4.k().m("key_card_interest_close_click_time_" + str, 0L);
            if (m != 0) {
                int currentTimeMillis = (int) (((((System.currentTimeMillis() - m) / 1000) / 60) / 60) / 24);
                if (i25Var.a() != -1 && currentTimeMillis >= i25Var.a()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            if (!h()) {
                return false;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            i25 homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
            if (homepageInterestConfig == null || i2 <= 0) {
                return false;
            }
            if (d(homepageInterestConfig)) {
                return true;
            }
            if (qy4.k().l("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
                if (c(homepageInterestConfig, currentAccount) && i == 0) {
                    return true;
                }
            } else if (g(homepageInterestConfig) && i == 0) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static boolean d(i25 i25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, i25Var)) == null) {
            if (i25Var.c() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(i25 i25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, i25Var)) == null) {
            if (i25Var.d() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
