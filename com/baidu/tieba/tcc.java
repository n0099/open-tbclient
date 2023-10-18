package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.agc;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes8.dex */
public interface tcc {
    void a(Activity activity, jec jecVar, nec necVar, Dialog dialog, tfc tfcVar, AppCustomExpand appCustomExpand, agc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
