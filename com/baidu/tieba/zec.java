package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fhc;
import com.baidu.tieba.ghc;
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
/* loaded from: classes9.dex */
public class zec implements ghc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public ghc c;
    public ghc.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public xdc f;
    public boolean g;

    public zec(Activity activity, boolean z, Dialog dialog, ghc ghcVar, ghc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, xdc xdcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, ghcVar, bVar, iPayCallback, xdcVar};
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
        this.c = ghcVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = xdcVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.ghc.a
    public void a(tfc tfcVar, pfc pfcVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, tfcVar, pfcVar, appCustomExpand) == null) {
            tfc tfcVar2 = new tfc(PayType.ALI_PAY_SIGN, tfcVar.b, tfcVar.c, tfcVar.d, tfcVar.e, tfcVar.f, tfcVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + tfcVar2.a + ", payAmount=" + pfcVar + ", alwaysConfirm=" + tfcVar.g);
            this.f.p(this.a, pfcVar, tfcVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ghc.a
    public void b(tfc tfcVar, pfc pfcVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tfcVar, pfcVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + tfcVar.a + ", payAmount=" + pfcVar);
            this.f.k(this.a, tfcVar, pfcVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ghc.a
    public void c(sfc sfcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sfcVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + sfcVar);
            igc.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            xdc xdcVar = this.f;
            Activity activity = this.a;
            fhc.b bVar = sfcVar.b;
            xdcVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.ghc.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = jgc.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            igc.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.ghc.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
