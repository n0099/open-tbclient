package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.dbd;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes9.dex */
public interface y7d {
    void f(Activity activity, Dialog dialog, wad wadVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, wad wadVar, dbd.b bVar, m9d m9dVar, q9d q9dVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, q9d q9dVar, Dialog dialog, wad wadVar);
}
