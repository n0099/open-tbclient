package com.baidu.tieba;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.GROUP_CHAT_ICON_CLICK);
            statisticItem.param("uid", j);
            statisticItem.param("obj_locate", j2);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.GROUP_CHAT_ICON_EXPLORE);
            statisticItem.param("uid", j);
            statisticItem.param("obj_locate", j2);
            statisticItem.param("obj_type", str);
            TiebaStatic.log(statisticItem);
        }
    }
}
