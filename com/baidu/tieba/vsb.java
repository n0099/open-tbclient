package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.awb;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes8.dex */
public interface vsb {
    void f(Activity activity, Dialog dialog, tvb tvbVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, tvb tvbVar, awb.b bVar, jub jubVar, nub nubVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, nub nubVar, Dialog dialog, tvb tvbVar);
}
