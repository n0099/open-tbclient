package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.txb;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes7.dex */
public interface oub {
    void f(Activity activity, Dialog dialog, mxb mxbVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, mxb mxbVar, txb.b bVar, cwb cwbVar, gwb gwbVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, gwb gwbVar, Dialog dialog, mxb mxbVar);
}
