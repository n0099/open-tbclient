package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.txb;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes6.dex */
public interface mub {
    void a(Activity activity, cwb cwbVar, gwb gwbVar, Dialog dialog, mxb mxbVar, AppCustomExpand appCustomExpand, txb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
