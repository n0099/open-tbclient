package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dbd;
import com.baidu.tieba.ebd;
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
public class x8d implements ebd.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public ebd c;
    public ebd.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public v7d f;
    public boolean g;

    public x8d(Activity activity, boolean z, Dialog dialog, ebd ebdVar, ebd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, v7d v7dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, ebdVar, bVar, iPayCallback, v7dVar};
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
        this.c = ebdVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = v7dVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.ebd.a
    public void a(r9d r9dVar, n9d n9dVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, r9dVar, n9dVar, appCustomExpand) == null) {
            r9d r9dVar2 = new r9d(PayType.ALI_PAY_SIGN, r9dVar.b, r9dVar.c, r9dVar.d, r9dVar.e, r9dVar.f, r9dVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + r9dVar2.a + ", payAmount=" + n9dVar + ", alwaysConfirm=" + r9dVar.g);
            this.f.p(this.a, n9dVar, r9dVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ebd.a
    public void b(r9d r9dVar, n9d n9dVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r9dVar, n9dVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + r9dVar.a + ", payAmount=" + n9dVar);
            this.f.k(this.a, r9dVar, n9dVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.ebd.a
    public void c(q9d q9dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q9dVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + q9dVar);
            gad.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            v7d v7dVar = this.f;
            Activity activity = this.a;
            dbd.b bVar = q9dVar.b;
            v7dVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.ebd.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = had.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            gad.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.ebd.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
