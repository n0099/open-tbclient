package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.awb;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes7.dex */
public interface tsb {
    void a(Activity activity, jub jubVar, nub nubVar, Dialog dialog, tvb tvbVar, AppCustomExpand appCustomExpand, awb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
