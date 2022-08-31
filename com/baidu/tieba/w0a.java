package com.baidu.tieba;

import android.app.Activity;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface w0a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, s0a s0aVar);

    g3a b(Activity activity);

    f3a c(Activity activity);

    h3a d(Activity activity);

    IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, s0a s0aVar);

    IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, s0a s0aVar);
}
