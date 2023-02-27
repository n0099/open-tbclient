package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class or5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948041879, "Lcom/baidu/tieba/or5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948041879, "Lcom/baidu/tieba/or5;");
        }
    }

    public static void a(int i, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65537, null, i, i2) == null) {
            int i3 = 1;
            if (ProfileVirtualImageInfo.getInstance().isDisplayVirtual() && ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 1) {
                z = true;
            } else {
                z = false;
            }
            StatisticItem statisticItem = new StatisticItem("c10605");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!z) {
                i3 = 2;
            }
            statisticItem.param("obj_id", i3);
            if (z) {
                statisticItem.param("obj_locate", i);
            } else {
                statisticItem.param("obj_param1", i2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !a) {
            int i = 1;
            a = true;
            StatisticItem statisticItem = new StatisticItem("c14994");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!ProfileVirtualImageInfo.getInstance().isDisplayVirtual() || (TextUtils.isEmpty(ProfileVirtualImageInfo.getInstance().getVirtualImageUrl()) && TextUtils.isEmpty(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl()))) {
                i = 2;
            }
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14998");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_source", 2);
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14998");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_source", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            StatisticItem statisticItem = new StatisticItem("c14998");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_source", 2);
            statisticItem.param("obj_locate", 1);
            TiebaStatic.log(statisticItem);
        }
    }
}
