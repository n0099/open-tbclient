package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ghc;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes9.dex */
public interface zdc {
    void a(Activity activity, pfc pfcVar, tfc tfcVar, Dialog dialog, zgc zgcVar, AppCustomExpand appCustomExpand, ghc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
