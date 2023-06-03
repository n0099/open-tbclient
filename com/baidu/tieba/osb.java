package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.vvb;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes7.dex */
public interface osb {
    void a(Activity activity, eub eubVar, iub iubVar, Dialog dialog, ovb ovbVar, AppCustomExpand appCustomExpand, vvb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
