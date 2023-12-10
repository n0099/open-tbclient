package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ggd;
import com.baidu.tieba.igd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes9.dex */
public class xdd implements ggd.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public Dialog b;
    public zcd c;
    public ved d;
    public red e;
    public Dialog f;
    public bgd g;
    public AppCustomExpand h;
    public igd.b i;
    public IPayCallback<CurrencyChargeMessage> j;

    public xdd(Activity activity, Dialog dialog, zcd zcdVar, red redVar, ved vedVar, Dialog dialog2, bgd bgdVar, AppCustomExpand appCustomExpand, igd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dialog, zcdVar, redVar, vedVar, dialog2, bgdVar, appCustomExpand, bVar, iPayCallback};
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
        this.c = zcdVar;
        this.d = vedVar;
        this.e = redVar;
        this.f = dialog2;
        this.g = bgdVar;
        this.h = appCustomExpand;
        this.i = bVar;
        this.j = iPayCallback;
    }

    @Override // com.baidu.tieba.ggd.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RLog.info("PaySignViewCallback", "onBtnConfirm");
            this.c.k(this.a, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            kfd.a(this.b, PayDialogType.PAY_SIGN_DIALOG);
        }
    }
}
