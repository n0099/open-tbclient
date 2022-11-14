package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class u6a implements IYYPayWayView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public IYYPayWayView c;
    public IYYPayWayView.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public s5a f;
    public boolean g;

    public u6a(Activity activity, boolean z, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, s5a s5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, iYYPayWayView, bVar, iPayCallback, s5aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayViewCallback", "create PayWayViewCallback");
        this.a = activity;
        this.b = dialog;
        this.c = iYYPayWayView;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = s5aVar;
        this.g = z;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void a(n7a n7aVar, k7a k7aVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, n7aVar, k7aVar, appCustomExpand) == null) {
            n7a n7aVar2 = new n7a(PayType.ALI_PAY_SIGN, n7aVar.b, n7aVar.c, n7aVar.d, n7aVar.e, n7aVar.f);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + n7aVar2.a + ", payAmount=" + k7aVar);
            this.f.m(this.a, k7aVar, n7aVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void b(n7a n7aVar, k7a k7aVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n7aVar, k7aVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + n7aVar.a + ", payAmount=" + k7aVar);
            this.f.f(this.a, n7aVar, k7aVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void c(m7a m7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m7aVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + m7aVar);
            a8a.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            s5a s5aVar = this.f;
            Activity activity = this.a;
            t8a.b bVar = m7aVar.b;
            s5aVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = b8a.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.j(b);
            a8a.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
