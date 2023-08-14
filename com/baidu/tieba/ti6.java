package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class ti6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StatisticItem a;

    public ti6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = StatisticItem.make(str);
    }

    public static ti6 a(HybridStatisticKey hybridStatisticKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hybridStatisticKey)) == null) {
            return new ti6(hybridStatisticKey.getValue());
        }
        return (ti6) invokeL.objValue;
    }

    public static String b(StatisticItem statisticItem) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, statisticItem)) == null) {
            StringBuilder sb = new StringBuilder();
            if (statisticItem == null) {
                return "";
            }
            sb.append("RD_STAT_LOG: ");
            sb.append("key=");
            sb.append(statisticItem.getKey());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            List<Object> params = statisticItem.getParams();
            if (params != null && (size = params.size()) > 0) {
                for (int i = 0; i < size; i++) {
                    sb.append(params.get(i));
                    if (i % 2 == 0) {
                        sb.append("=");
                    } else if (i != size - 1) {
                        sb.append(",");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ti6 c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.a.param(str, str2);
            return this;
        }
        return (ti6) invokeLL.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (gk6.a()) {
                dl6.a("newHybrid", b(this.a));
            }
            this.a.eventStat();
        }
    }
}
