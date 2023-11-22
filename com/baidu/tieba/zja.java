package com.baidu.tieba;

import android.util.ArrayMap;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes9.dex */
public class zja {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Long> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948363256, "Lcom/baidu/tieba/zja;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948363256, "Lcom/baidu/tieba/zja;");
                return;
            }
        }
        a = new ArrayMap();
    }

    public static void a(String str, boolean z) {
        Long remove;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, str, z) != null) || (remove = a.remove(str)) == null) {
            return;
        }
        StatisticItem addParam = new StatisticItem("shoubai_http_net_test").addParam("obj_name", str).addParam("obj_type", BdNetTypeUtil.getNetType()).addParam("obj_source", "true false");
        TiebaStatic.log(addParam.addParam("obj_param1", z + "").addParam(TiebaStatic.Params.OBJ_PARAM2, SpeedStatsManager.getInstance().getDurationWithoutAD(remove.longValue(), System.currentTimeMillis())));
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
