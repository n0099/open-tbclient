package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.chc;
import com.baidu.tieba.dhc;
import com.baidu.tieba.ehc;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes8.dex */
public interface wdc {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, tdc tdcVar);

    ahc b(Activity activity);

    zgc c(Activity activity);

    bhc d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, tdc tdcVar);

    chc f(Activity activity, chc.b bVar, PayUIKitConfig payUIKitConfig);

    ehc g(Activity activity, ehc.b bVar, ydc ydcVar);

    dhc h(Activity activity, PayUIKitConfig payUIKitConfig, dhc.b bVar, ydc ydcVar);
}
