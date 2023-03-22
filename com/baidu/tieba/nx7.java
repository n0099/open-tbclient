package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nx7 {
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

    public static void c(@NonNull String str, int i, @Nullable AbilityItem abilityItem, @Nullable BaseMsg baseMsg) {
        String str2;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, null, str, i, abilityItem, baseMsg) == null) {
            String str3 = "";
            if (abilityItem == null || abilityItem.getStyleConf() == null) {
                str2 = "";
            } else {
                str2 = abilityItem.getStyleConf().getContent();
            }
            StatisticItem param = new StatisticItem(str).param("obj_type", i).param("obj_name", str2);
            if (abilityItem != null) {
                str3 = abilityItem.getType();
            }
            StatisticItem param2 = param.param("obj_source", str3);
            long j3 = 0;
            if (baseMsg != null) {
                j = baseMsg.getCommonMsgField().getForumId();
            } else {
                j = 0;
            }
            StatisticItem param3 = param2.param("fid", j);
            if (baseMsg != null) {
                j2 = baseMsg.getCommonMsgField().getRoomId();
            } else {
                j2 = 0;
            }
            StatisticItem param4 = param3.param("room_id", j2);
            if (baseMsg != null) {
                j3 = baseMsg.getCommonMsgField().getMsgId();
            }
            TiebaStatic.log(param4.param("obj_id", j3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public static void d(@NonNull String str, int i, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_id", i);
            statisticItem.param("obj_locate", j);
            statisticItem.param("obj_type", !z ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f(@NonNull String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", str2);
            statisticItem.param("obj_source", j);
            statisticItem.param("obj_type", !z ? 1 : 0);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e(@NonNull String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", str2);
            statisticItem.param("obj_locate", j);
            TiebaStatic.log(statisticItem);
        }
    }
}
