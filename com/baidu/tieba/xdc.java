package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ehc;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes8.dex */
public interface xdc {
    void a(Activity activity, nfc nfcVar, rfc rfcVar, Dialog dialog, xgc xgcVar, AppCustomExpand appCustomExpand, ehc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
