package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uvb;
import com.baidu.tieba.vvb;
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
public class otb implements vvb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public vvb c;
    public vvb.b d;
    public IPayCallback<CurrencyChargeMessage> e;
    public msb f;
    public boolean g;

    public otb(Activity activity, boolean z, Dialog dialog, vvb vvbVar, vvb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback, msb msbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), dialog, vvbVar, bVar, iPayCallback, msbVar};
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
        this.c = vvbVar;
        this.d = bVar;
        this.e = iPayCallback;
        this.f = msbVar;
        this.g = z;
    }

    @Override // com.baidu.tieba.vvb.a
    public void a(iub iubVar, eub eubVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, iubVar, eubVar, appCustomExpand) == null) {
            iub iubVar2 = new iub(PayType.ALI_PAY_SIGN, iubVar.b, iubVar.c, iubVar.d, iubVar.e, iubVar.f, iubVar.g);
            RLog.info("PayWayViewCallback", "onStartSignPay payType=" + iubVar2.a + ", payAmount=" + eubVar + ", alwaysConfirm=" + iubVar.g);
            this.f.p(this.a, eubVar, iubVar2, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.vvb.a
    public void b(iub iubVar, eub eubVar, AppCustomExpand appCustomExpand) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iubVar, eubVar, appCustomExpand) == null) {
            RLog.info("PayWayViewCallback", "onStartPay payType=" + iubVar.a + ", payAmount=" + eubVar);
            this.f.k(this.a, iubVar, eubVar, this.b, this.c, appCustomExpand, this.d, this.e);
        }
    }

    @Override // com.baidu.tieba.vvb.a
    public void c(hub hubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hubVar) == null) {
            RLog.info("PayWayViewCallback", "showSplitOrderView info:" + hubVar);
            xub.a(this.b, PayDialogType.PAY_WAY_DIALOG);
            msb msbVar = this.f;
            Activity activity = this.a;
            uvb.b bVar = hubVar.b;
            msbVar.a(activity, bVar.a, bVar.d, bVar.e, PaySplitOrderViewSource.SOURCE_FROM_PAY_WAY_DIALOG, bVar.f, this.e);
        }
    }

    @Override // com.baidu.tieba.vvb.a
    public void onRefreshViewFail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            PayFinishInfo b = yub.b(PayDialogType.PAY_WAY_DIALOG, i, str, this.g);
            RLog.info("PayWayViewCallback", "showPayWayDialog onRefreshViewFail message:" + b);
            this.f.l(b);
            xub.b(this.b, PayDialogType.PAY_WAY_DIALOG);
        }
    }

    @Override // com.baidu.tieba.vvb.a
    public void toHelpCenterPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.u(this.a);
        }
    }
}
