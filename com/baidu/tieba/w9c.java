package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitMinAmountInfo;
import java.util.List;
/* loaded from: classes8.dex */
public class w9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(List<SplitMinAmountInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            RLog.info("PaySplitOrderUtils", "getSplitMinAmount splitMinAmountInfoList:" + list);
            for (SplitMinAmountInfo splitMinAmountInfo : list) {
                if (splitMinAmountInfo.splitType == 1) {
                    return splitMinAmountInfo.minAmount;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            PaysSettingInfo d = y8c.d();
            if (d == null) {
                RLog.error("PaySplitOrderUtils", "maybeShowSplitOrderDialog error settingInfo null", new Object[0]);
                return false;
            }
            return c(d.splitMinAmountInfoList, i);
        }
        return invokeI.booleanValue;
    }

    public static boolean c(List<SplitMinAmountInfo> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i)) == null) {
            if (list != null && !list.isEmpty()) {
                int a = a(list);
                if (a <= 0) {
                    RLog.info("PaySplitOrderUtils", "maybeShowSplitOrderDialog false splitMinAmount:" + a);
                    return false;
                }
                RLog.info("PaySplitOrderUtils", "maybeShowSplitOrderDialog inputAmount:" + i + " splitMinAmount:" + a);
                if (i < a) {
                    return false;
                }
                return true;
            }
            RLog.warn("PaySplitOrderUtils", "maybeShowSplitOrderDialog error splitMinAmountInfoList null");
            return false;
        }
        return invokeLI.booleanValue;
    }
}
