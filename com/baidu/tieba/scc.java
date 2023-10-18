package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.agc;
import com.baidu.tieba.yfc;
import com.baidu.tieba.zfc;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes8.dex */
public interface scc {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, pcc pccVar);

    wfc b(Activity activity);

    vfc c(Activity activity);

    xfc d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, pcc pccVar);

    yfc f(Activity activity, yfc.b bVar, PayUIKitConfig payUIKitConfig);

    agc g(Activity activity, agc.b bVar, ucc uccVar);

    zfc h(Activity activity, PayUIKitConfig payUIKitConfig, zfc.b bVar, ucc uccVar);
}
