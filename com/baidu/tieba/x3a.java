package com.baidu.tieba;

import android.app.Activity;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface x3a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, t3a t3aVar);

    h6a b(Activity activity);

    g6a c(Activity activity);

    i6a d(Activity activity);

    IYYPayWayView e(Activity activity, IYYPayWayView.b bVar, t3a t3aVar);

    IYYPayResultView f(Activity activity, IYYPayResultView.c cVar, t3a t3aVar);
}
