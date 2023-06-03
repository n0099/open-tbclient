package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.vvb;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes7.dex */
public interface qsb {
    void f(Activity activity, Dialog dialog, ovb ovbVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, ovb ovbVar, vvb.b bVar, eub eubVar, iub iubVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, iub iubVar, Dialog dialog, ovb ovbVar);
}
