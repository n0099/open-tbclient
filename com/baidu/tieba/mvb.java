package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sxb;
import com.baidu.tieba.txb;
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
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public class mvb implements txb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public txb c;
    public txb.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public kub f;
    public boolean g;

    public mvb(Activity activity, boolean z, Dialog dialog, txb txbVar, txb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, kub kubVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, txbVar, bVar, iPayCallback, kubVar};
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
        this.c = txbVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = kubVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.txb.a
    public void a(gwb gwbVar, cwb cwbVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, gwbVar, cwbVar, appCustomExpand) == null) {
            gwb gwbVar2 = new gwb(PayType.ALI_PAY_SIGN, gwbVar.b, gwbVar.c, gwbVar.d, gwbVar.e, gwbVar.f, gwbVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + gwbVar2.a + ", payAmount=" + cwbVar + ", alwaysConfirm=" + gwbVar.g);
            this.f.p(this.a, cwbVar, gwbVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.txb.a
    public void b(gwb gwbVar, cwb cwbVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gwbVar, cwbVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + gwbVar.a + ", payAmount=" + cwbVar);
            this.f.k(this.a, gwbVar, cwbVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.txb.a
    public void c(fwb fwbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fwbVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + fwbVar);
            vwb.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            kub kubVar = this.f;
            Activity activity = this.a;
            sxb.b bVar = fwbVar.b;
            kubVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.txb.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = wwb.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            vwb.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.txb.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
