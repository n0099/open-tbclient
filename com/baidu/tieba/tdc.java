package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.agc;
import com.baidu.tieba.zfc;
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
/* loaded from: classes8.dex */
public class tdc implements agc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public agc c;
    public agc.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public rcc f;
    public boolean g;

    public tdc(Activity activity, boolean z, Dialog dialog, agc agcVar, agc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, rcc rccVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, agcVar, bVar, iPayCallback, rccVar};
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
        this.c = agcVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = rccVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.agc.a
    public void a(nec necVar, jec jecVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, necVar, jecVar, appCustomExpand) == null) {
            nec necVar2 = new nec(PayType.ALI_PAY_SIGN, necVar.b, necVar.c, necVar.d, necVar.e, necVar.f, necVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + necVar2.a + ", payAmount=" + jecVar + ", alwaysConfirm=" + necVar.g);
            this.f.p(this.a, jecVar, necVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.agc.a
    public void b(nec necVar, jec jecVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, necVar, jecVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + necVar.a + ", payAmount=" + jecVar);
            this.f.k(this.a, necVar, jecVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.agc.a
    public void c(mec mecVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mecVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + mecVar);
            cfc.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            rcc rccVar = this.f;
            Activity activity = this.a;
            zfc.b bVar = mecVar.b;
            rccVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.agc.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = dfc.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            cfc.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.agc.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
