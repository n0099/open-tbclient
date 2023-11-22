package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ebd;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes9.dex */
public interface z7d {
    void f(Activity activity, Dialog dialog, xad xadVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, xad xadVar, ebd.b bVar, n9d n9dVar, r9d r9dVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, r9d r9dVar, Dialog dialog, xad xadVar);
}
