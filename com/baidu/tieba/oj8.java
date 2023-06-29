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
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull String str, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, j);
            statisticItem.param("fid", j2);
            statisticItem.param("room_id", j3);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void h(@NonNull String str, int i, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_id", i);
            statisticItem.param("obj_locate", j);
            statisticItem.param("obj_type", !z ? 1 : 0);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void j(@NonNull String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", str2);
            statisticItem.param("obj_source", j);
            statisticItem.param("obj_type", !z ? 1 : 0);
            TiebaStatic.log(statisticItem);
        }
    }

    public static String b(AbilityItem abilityItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, abilityItem)) == null) {
            if (abilityItem != null && abilityItem.getStyleConf() != null) {
                return abilityItem.getStyleConf().getContent();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void c(@NonNull String str, String str2, long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", str2);
            statisticItem.param("fid", j);
            statisticItem.param("room_id", j2);
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(@NonNull String str, int i, long j, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", i);
            statisticItem.param("fid", j);
            statisticItem.param("room_id", j2);
            statisticItem.param("uid", str2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e(@NonNull String str, String str2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", str2);
            statisticItem.param("fid", j);
            statisticItem.param("room_id", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f(@NonNull String str, int i, @Nullable AbilityItem abilityItem, String str2, String str3, long j, long j2, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), abilityItem, str2, str3, Long.valueOf(j), Long.valueOf(j2), str4, str5}) == null) {
            TiebaStatic.log(new StatisticItem(str).param("obj_type", i).param("obj_id", str2).param("obj_name", str3).param("fid", j).param("obj_param1", j2).param(TiebaStatic.Params.OBJ_PARAM2, str4).param(TiebaStatic.Params.OBJ_PARAM3, str5));
        }
    }

    public static void g(@NonNull String str, int i, @Nullable AbilityItem abilityItem, @Nullable BaseMsg baseMsg, String str2, String str3, long j, long j2) {
        String str4;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, Integer.valueOf(i), abilityItem, baseMsg, str2, str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String str5 = "";
            if (abilityItem == null || abilityItem.getStyleConf() == null) {
                str4 = "";
            } else {
                str4 = abilityItem.getStyleConf().getContent();
            }
            StatisticItem param = new StatisticItem(str).param("obj_type", i).param("obj_name", str4);
            if (abilityItem != null) {
                str5 = abilityItem.getType();
            }
            StatisticItem param2 = param.param("obj_source", str5).param("fid", j2);
            long j4 = 0;
            if (baseMsg != null) {
                j3 = baseMsg.getCommonMsgField().getRoomId();
            } else {
                j3 = 0;
            }
            StatisticItem param3 = param2.param("room_id", j3);
            if (baseMsg != null) {
                j4 = baseMsg.getCommonMsgField().getMsgId();
            }
            TiebaStatic.log(param3.param("obj_id", j4).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", str2).param(TiebaStatic.Params.OBJ_PARAM2, str3).param(TiebaStatic.Params.OBJ_PARAM3, j));
        }
    }

    public static void i(@NonNull String str, String str2, long j, String str3, String str4, long j2, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, Long.valueOf(j), str3, str4, Long.valueOf(j2), str5}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", str2);
            statisticItem.param("obj_locate", j);
            statisticItem.param("obj_id", str3);
            statisticItem.param("obj_name", str4);
            statisticItem.param("fid", j2);
            statisticItem.param("obj_param1", str5);
            TiebaStatic.log(statisticItem);
        }
    }
}
