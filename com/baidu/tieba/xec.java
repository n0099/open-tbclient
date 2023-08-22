package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dhc;
import com.baidu.tieba.ehc;
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
public class xec implements ehc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public ehc c;
    public ehc.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public vdc f;
    public boolean g;

    public xec(Activity activity, boolean z, Dialog dialog, ehc ehcVar, ehc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, vdc vdcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, ehcVar, bVar, iPayCallback, vdcVar};
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
        this.c = ehcVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = vdcVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.ehc.a
    public void a(rfc rfcVar, nfc nfcVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, rfcVar, nfcVar, appCustomExpand) == null) {
            rfc rfcVar2 = new rfc(PayType.ALI_PAY_SIGN, rfcVar.b, rfcVar.c, rfcVar.d, rfcVar.e, rfcVar.f, rfcVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + rfcVar2.a + ", payAmount=" + nfcVar + ", alwaysConfirm=" + rfcVar.g);
            this.f.p(this.a, nfcVar, rfcVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ehc.a
    public void b(rfc rfcVar, nfc nfcVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rfcVar, nfcVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + rfcVar.a + ", payAmount=" + nfcVar);
            this.f.k(this.a, rfcVar, nfcVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ehc.a
    public void c(qfc qfcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qfcVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + qfcVar);
            ggc.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            vdc vdcVar = this.f;
            Activity activity = this.a;
            dhc.b bVar = qfcVar.b;
            vdcVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.ehc.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = hgc.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            ggc.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.ehc.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
