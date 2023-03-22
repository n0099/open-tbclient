package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.p0b;
import com.baidu.tieba.q0b;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface qxa {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, oxa oxaVar);

    n0b b(Activity activity);

    m0b c(Activity activity);

    o0b d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, oxa oxaVar);

    p0b f(Activity activity, p0b.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, sxa sxaVar);

    q0b h(Activity activity, PayUIKitConfig payUIKitConfig, q0b.b bVar, sxa sxaVar);
}
