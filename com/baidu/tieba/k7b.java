package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes5.dex */
public interface k7b {
    void h(int i, String str, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, y8b y8bVar, b9b b9bVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void i(Activity activity, b9b b9bVar, Dialog dialog, IYYPayWayView iYYPayWayView);

    void r(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, PurchaseStatus purchaseStatus);
}
