package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.hkc;
import com.baidu.tieba.jkc;
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
public class yhc implements hkc.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public ahc c;
    public wic d;
    public sic e;
    public Dialog f;
    public ckc g;
    public AppCustomExpand h;
    public jkc.b i;
    public IPayCallback<CurrencyChargeMessage> j;

    public yhc(Activity activity, Dialog dialog, ahc ahcVar, sic sicVar, wic wicVar, Dialog dialog2, ckc ckcVar, AppCustomExpand appCustomExpand, jkc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dialog, ahcVar, sicVar, wicVar, dialog2, ckcVar, appCustomExpand, bVar, iPayCallback};
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
        this.c = ahcVar;
        this.d = wicVar;
        this.e = sicVar;
        this.f = dialog2;
        this.g = ckcVar;
        this.h = appCustomExpand;
        this.i = bVar;
        this.j = iPayCallback;
    }

    @Override // com.baidu.tieba.hkc.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RLog.info("PaySignViewCallback", "onBtnConfirm");
            this.c.k(this.a, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            ljc.a(this.b, PayDialogType.PAY_SIGN_DIALOG);
        }
    }
}
