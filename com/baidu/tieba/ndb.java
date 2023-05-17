package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ugb;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes6.dex */
public interface ndb {
    void a(Activity activity, dfb dfbVar, hfb hfbVar, Dialog dialog, ngb ngbVar, AppCustomExpand appCustomExpand, ugb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
