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
/* loaded from: classes6.dex */
public class x1a implements y0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public e2a c;
    public PayUIKitConfig d;

    public x1a(int i, int i2, e2a e2aVar, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), e2aVar, payUIKitConfig};
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
        this.c = e2aVar;
        this.d = payUIKitConfig;
    }

    @Override // com.baidu.tieba.y0a
    public IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, u0a u0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, viewParams, u0aVar)) == null) ? new YYPayAmountView(activity, this.a, this.b, this.d, viewParams, this.c, u0aVar) : (IYYPayAmountView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.y0a
    public i3a b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? new YYPayConfirmView(activity, this.a, this.b, this.d) : (i3a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y0a
    public h3a c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? new YYPayCampaignView(activity, this.a, this.b, this.d) : (h3a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y0a
    public j3a d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) ? new YYPayGiftView(activity, this.a, this.b, this.d) : (j3a) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y0a
    public IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, u0a u0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, activity, bVar, u0aVar)) == null) ? new YYPayWayView(activity, this.a, this.b, bVar, this.c, this.d, u0aVar) : (IYYPayWayView) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.y0a
    public IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, u0a u0aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, cVar, u0aVar)) == null) ? new YYPayResultView(activity, this.d, this.c, this.a, this.b, cVar, u0aVar) : (IYYPayResultView) invokeLLL.objValue;
    }
}
