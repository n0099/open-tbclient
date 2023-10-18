package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.agc;
import com.baidu.tieba.yfc;
import com.baidu.tieba.zfc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.impl.YYPayAmountView;
import tv.athena.revenue.payui.view.impl.YYPayCampaignView;
import tv.athena.revenue.payui.view.impl.YYPayConfirmView;
import tv.athena.revenue.payui.view.impl.YYPayGiftView;
import tv.athena.revenue.payui.view.impl.YYPayResultView;
import tv.athena.revenue.payui.view.impl.YYPaySignView;
import tv.athena.revenue.payui.view.impl.YYPaySplitOrderView;
import tv.athena.revenue.payui.view.impl.YYPayWayView;
/* loaded from: classes9.dex */
public class ydc implements scc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public PayUIKitConfig c;

    public ydc(int i, int i2, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayFlowViewImpl", "create PayViewImpl mAppId:" + i + " mUserChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = payUIKitConfig;
    }

    @Override // com.baidu.tieba.scc
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, pcc pccVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, pccVar)) == null) {
            return new YYPayAmountView(activity, this.a, this.b, this.c, viewParams, pccVar);
        }
        return (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.scc
    public IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, pcc pccVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, cVar, pccVar)) == null) {
            return new YYPayResultView(activity, this.c, this.a, this.b, cVar, pccVar);
        }
        return (IYYPayResultView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.scc
    public yfc f(Activity activity, yfc.b bVar, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, bVar, payUIKitConfig)) == null) {
            return new YYPaySignView(activity, bVar, payUIKitConfig, this.a, this.b);
        }
        return (yfc) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.scc
    public agc g(Activity activity, agc.b bVar, ucc uccVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, activity, bVar, uccVar)) == null) {
            return new YYPayWayView(activity, this.a, this.b, bVar, this.c, uccVar);
        }
        return (agc) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.scc
    public wfc b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            return new YYPayConfirmView(activity, this.a, this.b, this.c);
        }
        return (wfc) invokeL.objValue;
    }

    @Override // com.baidu.tieba.scc
    public vfc c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return new YYPayCampaignView(activity, this.a, this.b, this.c);
        }
        return (vfc) invokeL.objValue;
    }

    @Override // com.baidu.tieba.scc
    public xfc d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            return new YYPayGiftView(activity, this.a, this.b, this.c);
        }
        return (xfc) invokeL.objValue;
    }

    @Override // com.baidu.tieba.scc
    public zfc h(Activity activity, PayUIKitConfig payUIKitConfig, zfc.b bVar, ucc uccVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, payUIKitConfig, bVar, uccVar)) == null) {
            return new YYPaySplitOrderView(activity, payUIKitConfig, this.a, this.b, bVar, uccVar);
        }
        return (zfc) invokeLLLL.objValue;
    }
}
