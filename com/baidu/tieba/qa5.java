package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65536, null, i, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem("c14987");
            statisticItem.param("obj_source", i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, str);
            statisticItem.param("obj_id", str2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i, str) == null) {
            StatisticItem statisticItem = new StatisticItem("c14986");
            statisticItem.param("obj_source", i);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, str);
            TiebaStatic.log(statisticItem);
        }
    }
}
