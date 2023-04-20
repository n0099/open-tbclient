package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.oab;
import com.baidu.tieba.pab;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes5.dex */
public interface p7b {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, n7b n7bVar);

    mab b(Activity activity);

    lab c(Activity activity);

    nab d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, n7b n7bVar);

    oab f(Activity activity, oab.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, r7b r7bVar);

    pab h(Activity activity, PayUIKitConfig payUIKitConfig, pab.b bVar, r7b r7bVar);
}
