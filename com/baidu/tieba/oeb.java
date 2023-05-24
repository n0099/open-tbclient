package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ugb;
import com.baidu.tieba.vgb;
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
public class oeb implements vgb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public vgb c;
    public vgb.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public mdb f;
    public boolean g;

    public oeb(Activity activity, boolean z, Dialog dialog, vgb vgbVar, vgb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, mdb mdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, vgbVar, bVar, iPayCallback, mdbVar};
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
        this.c = vgbVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = mdbVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.vgb.a
    public void a(ifb ifbVar, efb efbVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ifbVar, efbVar, appCustomExpand) == null) {
            ifb ifbVar2 = new ifb(PayType.ALI_PAY_SIGN, ifbVar.b, ifbVar.c, ifbVar.d, ifbVar.e, ifbVar.f, ifbVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + ifbVar2.a + ", payAmount=" + efbVar + ", alwaysConfirm=" + ifbVar.g);
            this.f.p(this.a, efbVar, ifbVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.vgb.a
    public void b(ifb ifbVar, efb efbVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ifbVar, efbVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + ifbVar.a + ", payAmount=" + efbVar);
            this.f.k(this.a, ifbVar, efbVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.vgb.a
    public void c(hfb hfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hfbVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + hfbVar);
            xfb.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            mdb mdbVar = this.f;
            Activity activity = this.a;
            ugb.b bVar = hfbVar.b;
            mdbVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.vgb.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = yfb.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            xfb.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.vgb.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
