package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes7.dex */
public interface zja {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, xja xjaVar);

    wma b(Activity activity);

    vma c(Activity activity);

    xma d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, xja xjaVar);

    yma f(Activity activity, yma.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, bka bkaVar);

    zma h(Activity activity, PayUIKitConfig payUIKitConfig, zma.b bVar, bka bkaVar);
}
