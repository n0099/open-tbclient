package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.s8a;
import com.baidu.tieba.t8a;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface t5a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, r5a r5aVar);

    q8a b(Activity activity);

    p8a c(Activity activity);

    r8a d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, r5a r5aVar);

    s8a f(Activity activity, s8a.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, v5a v5aVar);

    t8a h(Activity activity, PayUIKitConfig payUIKitConfig, t8a.b bVar, v5a v5aVar);
}
