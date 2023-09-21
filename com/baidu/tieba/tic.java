package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.amc;
import com.baidu.tieba.bmc;
import com.baidu.tieba.zlc;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes8.dex */
public interface tic {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, qic qicVar);

    xlc b(Activity activity);

    wlc c(Activity activity);

    ylc d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, qic qicVar);

    zlc f(Activity activity, zlc.b bVar, PayUIKitConfig payUIKitConfig);

    bmc g(Activity activity, bmc.b bVar, vic vicVar);

    amc h(Activity activity, PayUIKitConfig payUIKitConfig, amc.b bVar, vic vicVar);
}
