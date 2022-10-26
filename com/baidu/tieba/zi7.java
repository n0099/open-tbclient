package com.baidu.tieba;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class zi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, str, map) != null) || ej.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                statisticItem.param(str2, (String) map.get(str2));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public static void b(Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, map) != null) || map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str = (String) map.remove("key");
        for (String str2 : map.keySet()) {
            hashMap.put(str2, map.get(str2));
        }
        a(str, hashMap);
    }
}
