package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ebd;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes9.dex */
public interface x7d {
    void a(Activity activity, n9d n9dVar, r9d r9dVar, Dialog dialog, xad xadVar, AppCustomExpand appCustomExpand, ebd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
