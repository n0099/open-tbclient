package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class p6a implements IYYPayResultView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public IYYPayResultView b;
    public AbsViewEventHandler c;
    public Dialog d;
    public t5a e;
    public IPayCallback<CurrencyChargeMessage> f;
    public IYYPayResultView.c g;

    public p6a(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler, Dialog dialog, t5a t5aVar, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, iYYPayResultView, absViewEventHandler, dialog, t5aVar, iPayCallback, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayResultViewCallback", "create PayResultViewCallback payCallback:" + iPayCallback);
        this.a = activity;
        this.b = iYYPayResultView;
        this.c = absViewEventHandler;
        this.d = dialog;
        this.e = t5aVar;
        this.f = iPayCallback;
        this.g = cVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public void a(l7a l7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l7aVar) == null) {
            IYYPayResultView.c cVar = this.g;
            if (cVar != null && cVar.j != null) {
                b8a.a(this.d, PayDialogType.PAY_AMOUNT_DIALOG);
                IYYPayWayView.b bVar = this.g.j;
                bVar.c = l7aVar;
                bVar.k = "2";
                this.e.b(this.a, bVar, this.f);
                return;
            }
            RLog.error("PayResultViewCallback", "toPayWayDialog error payResultViewParams:" + this.g, new Object[0]);
            b8a.b(this.d, PayDialogType.PAY_RESULT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayResultViewCallback", "onBtnConfirm");
            b8a.b(this.d, PayDialogType.PAY_RESULT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e.p(this.a, this.b, this.c);
        }
        return invokeV.booleanValue;
    }
}
