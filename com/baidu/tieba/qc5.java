package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), str2, str3, str4}) == null) {
            b(str, -1, str2, str3, str4, 0);
        }
    }

    public static void b(String str, int i, String str2, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), str2, str3, str4, Integer.valueOf(i2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", str2);
            statisticItem.param("thread_type", i2);
            if (i > 0) {
                statisticItem.param("obj_locate", i);
            }
            if (!StringUtils.isNull(str3)) {
                statisticItem.param("tid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param("fid", str4);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
