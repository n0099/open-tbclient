package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pab;
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
public class q8b implements IYYPayWayView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public IYYPayWayView c;
    public IYYPayWayView.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public o7b f;
    public boolean g;

    public q8b(Activity activity, boolean z, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, o7b o7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, iYYPayWayView, bVar, iPayCallback, o7bVar};
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
        this.f = o7bVar;
        this.g = z;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void a(j9b j9bVar, g9b g9bVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, j9bVar, g9bVar, appCustomExpand) == null) {
            j9b j9bVar2 = new j9b(PayType.ALI_PAY_SIGN, j9bVar.b, j9bVar.c, j9bVar.d, j9bVar.e, j9bVar.f);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + j9bVar2.a + ", payAmount=" + g9bVar);
            this.f.m(this.a, g9bVar, j9bVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void b(j9b j9bVar, g9b g9bVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j9bVar, g9bVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + j9bVar.a + ", payAmount=" + g9bVar);
            this.f.f(this.a, j9bVar, g9bVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void c(i9b i9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i9bVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + i9bVar);
            w9b.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            o7b o7bVar = this.f;
            Activity activity = this.a;
            pab.b bVar = i9bVar.b;
            o7bVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = x9b.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.j(b);
            w9b.b(this.b, PayDialogType.PAY_WAY_DIALOG);
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
