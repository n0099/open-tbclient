package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes6.dex */
public class w4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static m4a a(int i, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeIL;
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, payUIKitConfig)) == null) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.cid = 0;
            productInfo.productId = "";
            productInfo.srcCurrencySymbol = "";
            productInfo.srcAmount = i / 100.0d;
            if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null && middleRevenueConfig.getCurrencyType() == 4) {
                productInfo.destAmount = i;
                return new m4a(productInfo, 4);
            }
            productInfo.destAmount = i;
            return new m4a(productInfo);
        }
        return (m4a) invokeIL.objValue;
    }

    public static IAppPayService b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) {
            IRevenue revenue = RevenueManager.instance().getRevenue(i, i2);
            if (revenue == null) {
                RLog.error("CommonUtils", "getAppPayService null iRevenue", new Object[0]);
                return null;
            }
            return revenue.getAppPayService();
        }
        return (IAppPayService) invokeII.objValue;
    }

    public static IMiddlePayService c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            IMiddleRevenue middleRevenue = RevenueManager.instance().getMiddleRevenue(i, i2);
            if (middleRevenue == null) {
                RLog.error("CommonUtils", "getMiddlePayService null iRevenue", new Object[0]);
                return null;
            }
            return middleRevenue.getMiddlePayService();
        }
        return (IMiddlePayService) invokeII.objValue;
    }
}
