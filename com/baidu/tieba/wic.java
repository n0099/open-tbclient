package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.bmc;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes8.dex */
public interface wic {
    void f(Activity activity, Dialog dialog, ulc ulcVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, ulc ulcVar, bmc.b bVar, kkc kkcVar, okc okcVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, okc okcVar, Dialog dialog, ulc ulcVar);
}
