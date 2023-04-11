package com.baidu.tieba;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes5.dex */
public interface o7b extends e7b {
    void a(PayFlowType payFlowType);

    void b(Activity activity, IYYPayWayView.b bVar, x8b x8bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void c(Activity activity);

    void d(String str, PayFlowType payFlowType);

    boolean e();

    void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void g(Activity activity, IYYPayAmountView.ViewParams viewParams);

    boolean i(PayFlowType payFlowType);

    void j(String str, PayFlowType payFlowType);

    void refreshWindow(WindowParams windowParams);

    void release();
}
