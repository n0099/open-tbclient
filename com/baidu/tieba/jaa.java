package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cca;
import com.baidu.tieba.dca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.impl.YYPayAmountView;
import tv.athena.revenue.payui.view.impl.YYPayCampaignView;
import tv.athena.revenue.payui.view.impl.YYPayConfirmView;
import tv.athena.revenue.payui.view.impl.YYPayGiftView;
import tv.athena.revenue.payui.view.impl.YYPayResultView;
import tv.athena.revenue.payui.view.impl.YYPaySignView;
import tv.athena.revenue.payui.view.impl.YYPaySplitOrderView;
import tv.athena.revenue.payui.view.impl.YYPayWayView;
/* loaded from: classes5.dex */
public class jaa implements d9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public PayUIKitConfig c;

    public jaa(int i, int i2, PayUIKitConfig payUIKitConfig) {
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

    @Override // com.baidu.tieba.d9a
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, b9a b9aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, b9aVar)) == null) {
            return new YYPayAmountView(activity, this.a, this.b, this.c, viewParams, b9aVar);
        }
        return (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d9a
    public IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, b9a b9aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, cVar, b9aVar)) == null) {
            return new YYPayResultView(activity, this.c, this.a, this.b, cVar, b9aVar);
        }
        return (IYYPayResultView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d9a
    public cca f(Activity activity, cca.b bVar, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, bVar, payUIKitConfig)) == null) {
            return new YYPaySignView(activity, bVar, payUIKitConfig, this.a, this.b);
        }
        return (cca) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d9a
    public IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, f9a f9aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, activity, bVar, f9aVar)) == null) {
            return new YYPayWayView(activity, this.a, this.b, bVar, this.c, f9aVar);
        }
        return (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d9a
    public aca b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            return new YYPayConfirmView(activity, this.a, this.b, this.c);
        }
        return (aca) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d9a
    public zba c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return new YYPayCampaignView(activity, this.a, this.b, this.c);
        }
        return (zba) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d9a
    public bca d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            return new YYPayGiftView(activity, this.a, this.b, this.c);
        }
        return (bca) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d9a
    public dca h(Activity activity, PayUIKitConfig payUIKitConfig, dca.b bVar, f9a f9aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, payUIKitConfig, bVar, f9aVar)) == null) {
            return new YYPaySplitOrderView(activity, payUIKitConfig, this.a, this.b, bVar, f9aVar);
        }
        return (dca) invokeLLLL.objValue;
    }
}
