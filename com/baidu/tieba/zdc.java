package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ehc;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes9.dex */
public interface zdc {
    void f(Activity activity, Dialog dialog, xgc xgcVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, xgc xgcVar, ehc.b bVar, nfc nfcVar, rfc rfcVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, rfc rfcVar, Dialog dialog, xgc xgcVar);
}
