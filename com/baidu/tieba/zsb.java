package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.awb;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes8.dex */
public interface zsb extends osb {
    void a(Activity activity);

    void b(boolean z);

    void c(PayFlowType payFlowType, boolean z);

    void d(String str, PayFlowType payFlowType);

    boolean e();

    void f(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void g(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void h(Activity activity, awb.b bVar, iub iubVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void i(Activity activity, IYYPayAmountView.ViewParams viewParams);

    boolean k(PayFlowType payFlowType);

    void l(String str, PayFlowType payFlowType);

    void m(Activity activity);

    void refreshWindow(WindowParams windowParams);
}
