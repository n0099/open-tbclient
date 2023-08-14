package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.oac;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes6.dex */
public interface j7c {
    void f(Activity activity, Dialog dialog, hac hacVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, hac hacVar, oac.b bVar, x8c x8cVar, b9c b9cVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, b9c b9cVar, Dialog dialog, hac hacVar);
}
