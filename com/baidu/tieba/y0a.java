package com.baidu.tieba;

import android.app.Activity;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface y0a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, u0a u0aVar);

    i3a b(Activity activity);

    h3a c(Activity activity);

    j3a d(Activity activity);

    IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, u0a u0aVar);

    IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, u0a u0aVar);
}
