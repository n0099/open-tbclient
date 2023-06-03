package com.baidu.tieba;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ka9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem("c14349");
            statisticItem.param("tid", str);
            statisticItem.param("uid", str2);
            statisticItem.param("post_id", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(String str, String str2, String str3, String str4, long j, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, str4, Long.valueOf(j), str5}) == null) {
            StatisticItem statisticItem = new StatisticItem("c14348");
            statisticItem.param("tid", str2);
            statisticItem.param("uid", str3);
            statisticItem.param("post_id", str4);
            statisticItem.param("pid", str4);
            statisticItem.param("fname", str5);
            statisticItem.param("fid", j);
            statisticItem.param("obj_locate", str);
            TiebaStatic.log(statisticItem);
        }
    }
}
