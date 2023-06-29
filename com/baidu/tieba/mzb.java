package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.n2c;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes6.dex */
public interface mzb extends bzb {
    void a(Activity activity);

    void b(boolean z);

    void c(PayFlowType payFlowType, boolean z);

    void d(String str, PayFlowType payFlowType);

    boolean e();

    void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void g(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void h(Activity activity, n2c.b bVar, v0c v0cVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void i(Activity activity, IYYPayAmountView.ViewParams viewParams);

    boolean k(PayFlowType payFlowType);

    void l(String str, PayFlowType payFlowType);

    void m(Activity activity);

    void refreshWindow(WindowParams windowParams);
}
