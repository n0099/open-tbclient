package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.vgb;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes7.dex */
public interface qdb {
    void f(Activity activity, Dialog dialog, ogb ogbVar, PurchaseStatus purchaseStatus);

    void i(int i, String str, Activity activity, Dialog dialog, ogb ogbVar, vgb.b bVar, efb efbVar, ifb ifbVar, PayCallBackBean payCallBackBean, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void o(Activity activity, ifb ifbVar, Dialog dialog, ogb ogbVar);
}
