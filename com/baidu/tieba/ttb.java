package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.awb;
import com.baidu.tieba.zvb;
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
/* loaded from: classes7.dex */
public class ttb implements awb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public awb c;
    public awb.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public rsb f;
    public boolean g;

    public ttb(Activity activity, boolean z, Dialog dialog, awb awbVar, awb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, rsb rsbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, awbVar, bVar, iPayCallback, rsbVar};
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
        this.c = awbVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = rsbVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.awb.a
    public void a(nub nubVar, jub jubVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, nubVar, jubVar, appCustomExpand) == null) {
            nub nubVar2 = new nub(PayType.ALI_PAY_SIGN, nubVar.b, nubVar.c, nubVar.d, nubVar.e, nubVar.f, nubVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + nubVar2.a + ", payAmount=" + jubVar + ", alwaysConfirm=" + nubVar.g);
            this.f.p(this.a, jubVar, nubVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.awb.a
    public void b(nub nubVar, jub jubVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nubVar, jubVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + nubVar.a + ", payAmount=" + jubVar);
            this.f.k(this.a, nubVar, jubVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.awb.a
    public void c(mub mubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mubVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + mubVar);
            cvb.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            rsb rsbVar = this.f;
            Activity activity = this.a;
            zvb.b bVar = mubVar.b;
            rsbVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.awb.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = dvb.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            cvb.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.awb.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
