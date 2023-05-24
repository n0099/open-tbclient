package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.vgb;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
/* loaded from: classes6.dex */
public interface odb {
    void a(Activity activity, efb efbVar, ifb ifbVar, Dialog dialog, ogb ogbVar, AppCustomExpand appCustomExpand, vgb.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);
}
