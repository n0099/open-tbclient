package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.utils.CommonUtils;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes6.dex */
public class j1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static w0c a(int i, PayUIKitConfig payUIKitConfig) {
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
                return new w0c(productInfo, 4);
            }
            productInfo.destAmount = i;
            return new w0c(productInfo);
        }
        return (w0c) invokeIL.objValue;
    }

    public static IAppPayService b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) {
            IRevenue revenue = RevenueManager.instance().getRevenue(i, i2);
            if (revenue == null) {
                RLog.error(CommonUtils.TAG, "getAppPayService null iRevenue", new Object[0]);
                return null;
            }
            return revenue.getAppPayService();
        }
        return (IAppPayService) invokeII.objValue;
    }
}
