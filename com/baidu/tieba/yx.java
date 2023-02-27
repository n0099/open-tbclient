package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yx {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public static int b = 3;
    public static int c = 6;
    public static int d = 7;
    public static int e = 1;
    public static int f = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448323182, "Lcom/baidu/tieba/yx;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448323182, "Lcom/baidu/tieba/yx;");
        }
    }

    public static void a(int i, String str, int i2, int i3, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIRTUAL_IMAGE_SHOW);
            statisticItem.param("obj_type", i);
            statisticItem.param("tid", str);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("obj_source", i3);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, str3);
            if (i3 == e) {
                statisticItem.param("obj_name", str2);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
