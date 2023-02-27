package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull String str, int i, long j, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", i);
            statisticItem.param("fid", j);
            statisticItem.param("room_id", j2);
            statisticItem.param("uid", str2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(@NonNull String str, String str2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", str2);
            statisticItem.param("fid", j);
            statisticItem.param("room_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(@NonNull String str, int i, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_id", i);
            statisticItem.param("obj_locate", j);
            statisticItem.param("obj_type", !z ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(@NonNull String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", str2);
            statisticItem.param("obj_source", j);
            statisticItem.param("obj_type", !z ? 1 : 0);
            TiebaStatic.log(statisticItem);
        }
    }
}
