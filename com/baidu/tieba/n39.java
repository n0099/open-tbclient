package com.baidu.tieba;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, str, str2, str3, str4, str5) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("fid", str2);
            statisticItem.addParam("tid", str3);
            statisticItem.addParam("uid", str4);
            statisticItem.addParam("obj_source", str5);
            TiebaStatic.log(statisticItem);
        }
    }
}
