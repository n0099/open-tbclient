package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.dbd;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes8.dex */
public interface w7d {
    void a(Activity activity, m9d m9dVar, q9d q9dVar, Dialog dialog, wad wadVar, AppCustomExpand appCustomExpand, dbd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
