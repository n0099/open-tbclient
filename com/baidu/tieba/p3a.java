package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
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
import tv.athena.revenue.payui.view.impl.YYPayWayView;
/* loaded from: classes5.dex */
public class p3a implements q2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public w3a c;
    public PayUIKitConfig d;

    public p3a(int i, int i2, w3a w3aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), w3aVar, payUIKitConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayViewImpl", "create PayViewImpl mAppId:" + i + " mUserChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = w3aVar;
        this.d = payUIKitConfig;
    }

    @Override // com.baidu.tieba.q2a
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, m2a m2aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, m2aVar)) == null) ? new YYPayAmountView(activity, this.a, this.b, this.d, viewParams, this.c, m2aVar) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.q2a
    public a5a b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.b, this.d) : (a5a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q2a
    public z4a c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayCampaignView(activity, this.a, this.b, this.d) : (z4a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q2a
    public b5a d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.b, this.d) : (b5a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q2a
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, m2a m2aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, m2aVar)) == null) ? new YYPayWayView(activity, this.a, this.b, bVar, this.c, this.d, m2aVar) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.q2a
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, m2a m2aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, m2aVar)) == null) ? new YYPayResultView(activity, this.d, this.c, this.a, this.b, cVar, m2aVar) : (IYYPayResultView) invokeLLL.objValue;
    }
}
