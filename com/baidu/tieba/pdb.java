package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ugb;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes7.dex */
public interface pdb {
    void f(Activity activity, Dialog dialog, ngb ngbVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, ngb ngbVar, ugb.b bVar, dfb dfbVar, hfb hfbVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, hfb hfbVar, Dialog dialog, ngb ngbVar);
}
