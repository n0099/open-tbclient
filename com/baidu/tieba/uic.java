package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.bmc;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes8.dex */
public interface uic {
    void a(Activity activity, kkc kkcVar, okc okcVar, Dialog dialog, ulc ulcVar, AppCustomExpand appCustomExpand, bmc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
