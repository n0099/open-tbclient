package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ibc;
import com.baidu.tieba.kbc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes8.dex */
public class z8c implements ibc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public b8c c;
    public x9c d;
    public t9c e;
    public Dialog f;
    public dbc g;
    public AppCustomExpand h;
    public kbc.b i;
    public IPayCallback<CurrencyChargeMessage> j;

    public z8c(Activity activity, Dialog dialog, b8c b8cVar, t9c t9cVar, x9c x9cVar, Dialog dialog2, dbc dbcVar, AppCustomExpand appCustomExpand, kbc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dialog, b8cVar, t9cVar, x9cVar, dialog2, dbcVar, appCustomExpand, bVar, iPayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PaySignViewCallback", "create PayResultViewCallback");
        this.a = activity;
        this.b = dialog;
        this.c = b8cVar;
        this.d = x9cVar;
        this.e = t9cVar;
        this.f = dialog2;
        this.g = dbcVar;
        this.h = appCustomExpand;
        this.i = bVar;
        this.j = iPayCallback;
    }

    @Override // com.baidu.tieba.ibc.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RLog.info("PaySignViewCallback", "onBtnConfirm");
            this.c.k(this.a, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            mac.a(this.b, PayDialogType.PAY_SIGN_DIALOG);
        }
    }
}
