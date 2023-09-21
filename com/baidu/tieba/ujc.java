package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.amc;
import com.baidu.tieba.bmc;
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
public class ujc implements bmc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public bmc c;
    public bmc.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public sic f;
    public boolean g;

    public ujc(Activity activity, boolean z, Dialog dialog, bmc bmcVar, bmc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, sic sicVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, bmcVar, bVar, iPayCallback, sicVar};
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
        this.c = bmcVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = sicVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.bmc.a
    public void a(okc okcVar, kkc kkcVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, okcVar, kkcVar, appCustomExpand) == null) {
            okc okcVar2 = new okc(PayType.ALI_PAY_SIGN, okcVar.b, okcVar.c, okcVar.d, okcVar.e, okcVar.f, okcVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + okcVar2.a + ", payAmount=" + kkcVar + ", alwaysConfirm=" + okcVar.g);
            this.f.p(this.a, kkcVar, okcVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.bmc.a
    public void b(okc okcVar, kkc kkcVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, okcVar, kkcVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + okcVar.a + ", payAmount=" + kkcVar);
            this.f.k(this.a, okcVar, kkcVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.bmc.a
    public void c(nkc nkcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nkcVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + nkcVar);
            dlc.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            sic sicVar = this.f;
            Activity activity = this.a;
            amc.b bVar = nkcVar.b;
            sicVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.bmc.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = elc.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            dlc.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.bmc.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
