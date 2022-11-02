package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes5.dex */
public class p5a implements b8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e5a a;
    public AbsViewEventHandler b;
    public PayUIKitConfig c;
    public Activity d;
    public List<PayWayInfo> e;
    public IYYPayAmountView.ViewParams f;
    public IPayCallback<CurrencyChargeMessage> g;
    public String h;

    public p5a(e5a e5aVar, AbsViewEventHandler absViewEventHandler, PayUIKitConfig payUIKitConfig, Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, String str, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e5aVar, absViewEventHandler, payUIKitConfig, activity, list, viewParams, str, iPayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("AmountInputDialogListener", "create AmountInputDialogListener");
        this.a = e5aVar;
        this.b = absViewEventHandler;
        this.c = payUIKitConfig;
        this.d = activity;
        this.e = list;
        this.f = viewParams;
        this.g = iPayCallback;
        this.h = str;
    }

    @Override // com.baidu.tieba.b8a
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountInputDialogListener", "InputDialog notifyCancelType clickArea:" + cancelType);
            this.a.c(cancelType, this.b);
        }
    }

    @Override // com.baidu.tieba.b8a
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            n6a a = x6a.a((int) (i * 100.0d), this.c);
            RLog.info("AmountInputDialogListener", "showInputDialog: mPayAmountCustom:%s", a);
            this.a.n(this.d, a, this.e, this.h, this.f, this.g);
        }
    }
}
