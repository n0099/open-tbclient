package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tgb;
import com.baidu.tieba.ugb;
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
public class neb implements ugb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public ugb c;
    public ugb.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public ldb f;
    public boolean g;

    public neb(Activity activity, boolean z, Dialog dialog, ugb ugbVar, ugb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, ldb ldbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, ugbVar, bVar, iPayCallback, ldbVar};
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
        this.c = ugbVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = ldbVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.ugb.a
    public void a(hfb hfbVar, dfb dfbVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, hfbVar, dfbVar, appCustomExpand) == null) {
            hfb hfbVar2 = new hfb(PayType.ALI_PAY_SIGN, hfbVar.b, hfbVar.c, hfbVar.d, hfbVar.e, hfbVar.f, hfbVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + hfbVar2.a + ", payAmount=" + dfbVar + ", alwaysConfirm=" + hfbVar.g);
            this.f.p(this.a, dfbVar, hfbVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ugb.a
    public void b(hfb hfbVar, dfb dfbVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hfbVar, dfbVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + hfbVar.a + ", payAmount=" + dfbVar);
            this.f.k(this.a, hfbVar, dfbVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ugb.a
    public void c(gfb gfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gfbVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + gfbVar);
            wfb.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            ldb ldbVar = this.f;
            Activity activity = this.a;
            tgb.b bVar = gfbVar.b;
            ldbVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.ugb.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = xfb.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            wfb.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.ugb.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
