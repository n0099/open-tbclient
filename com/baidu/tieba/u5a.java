package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.t8a;
import com.baidu.tieba.u8a;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface u5a {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, s5a s5aVar);

    r8a b(Activity activity);

    q8a c(Activity activity);

    s8a d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, s5a s5aVar);

    t8a f(Activity activity, t8a.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, w5a w5aVar);

    u8a h(Activity activity, PayUIKitConfig payUIKitConfig, u8a.b bVar, w5a w5aVar);
}
