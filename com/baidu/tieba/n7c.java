package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.oac;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes7.dex */
public interface n7c extends c7c {
    void a(Activity activity);

    void b(boolean z);

    void c(PayFlowType payFlowType, boolean z);

    void d(String str, PayFlowType payFlowType);

    boolean e();

    void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void g(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void h(Activity activity, oac.b bVar, w8c w8cVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void i(Activity activity, IYYPayAmountView.ViewParams viewParams);

    boolean k(PayFlowType payFlowType);

    void l(String str, PayFlowType payFlowType);

    void m(Activity activity);

    void refreshWindow(WindowParams windowParams);
}
