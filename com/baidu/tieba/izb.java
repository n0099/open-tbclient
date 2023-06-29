package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.n2c;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes6.dex */
public interface izb {
    void f(Activity activity, Dialog dialog, g2c g2cVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, g2c g2cVar, n2c.b bVar, w0c w0cVar, a1c a1cVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, a1c a1cVar, Dialog dialog, g2c g2cVar);
}
