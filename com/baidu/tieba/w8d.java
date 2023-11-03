package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cbd;
import com.baidu.tieba.dbd;
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
public class w8d implements dbd.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public dbd c;
    public dbd.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public u7d f;
    public boolean g;

    public w8d(Activity activity, boolean z, Dialog dialog, dbd dbdVar, dbd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, u7d u7dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, dbdVar, bVar, iPayCallback, u7dVar};
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
        this.c = dbdVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = u7dVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.dbd.a
    public void a(q9d q9dVar, m9d m9dVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, q9dVar, m9dVar, appCustomExpand) == null) {
            q9d q9dVar2 = new q9d(PayType.ALI_PAY_SIGN, q9dVar.b, q9dVar.c, q9dVar.d, q9dVar.e, q9dVar.f, q9dVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + q9dVar2.a + ", payAmount=" + m9dVar + ", alwaysConfirm=" + q9dVar.g);
            this.f.p(this.a, m9dVar, q9dVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.dbd.a
    public void b(q9d q9dVar, m9d m9dVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q9dVar, m9dVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + q9dVar.a + ", payAmount=" + m9dVar);
            this.f.k(this.a, q9dVar, m9dVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.dbd.a
    public void c(p9d p9dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p9dVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + p9dVar);
            fad.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            u7d u7dVar = this.f;
            Activity activity = this.a;
            cbd.b bVar = p9dVar.b;
            u7dVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.dbd.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = gad.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            fad.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.dbd.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
