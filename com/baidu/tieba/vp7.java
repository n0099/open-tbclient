package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65536, null, i, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c14870");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_source", i);
            statisticItem.addParam("fid", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(int i, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)}) == null) {
            StatisticItem statisticItem = new StatisticItem("c14873");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_source", i);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("obj_locate", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, null, i, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem("c14871");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_source", i);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("obj_locate", str2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, null, i, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem("c14872");
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_source", i);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("obj_locate", str2);
            TiebaStatic.log(statisticItem);
        }
    }
}
