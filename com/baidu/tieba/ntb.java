package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.awb;
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
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes7.dex */
public class ntb implements IYYPayResultView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public AbsViewEventHandler b;
    public Dialog c;
    public rsb d;
    public IPayCallback<CurrencyChargeMessage> e;
    public IYYPayResultView.c f;

    public ntb(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler, Dialog dialog, rsb rsbVar, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayResultView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, iYYPayResultView, absViewEventHandler, dialog, rsbVar, iPayCallback, cVar};
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
        this.b = absViewEventHandler;
        this.c = dialog;
        this.d = rsbVar;
        this.e = iPayCallback;
        this.f = cVar;
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public void a(jub jubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jubVar) == null) {
            IYYPayResultView.c cVar = this.f;
            if (cVar != null && cVar.j != null) {
                cvb.a(this.c, PayDialogType.PAY_AMOUNT_DIALOG);
                awb.b bVar = this.f.j;
                bVar.c = jubVar;
                bVar.j = "2";
                this.d.d(this.a, bVar, this.e);
                return;
            }
            RLog.error("PayResultViewCallback", "toPayWayDialog error payResultViewParams:" + this.f, new Object[0]);
            cvb.b(this.c, PayDialogType.PAY_RESULT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayResultViewCallback", "onBtnConfirm");
            cvb.b(this.c, PayDialogType.PAY_RESULT_DIALOG);
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d.c(this.a, this.b);
        }
        return invokeV.booleanValue;
    }
}
