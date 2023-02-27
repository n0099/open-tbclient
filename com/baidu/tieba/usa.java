package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.tva;
import com.baidu.tieba.uva;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface usa {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, ssa ssaVar);

    rva b(Activity activity);

    qva c(Activity activity);

    sva d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, ssa ssaVar);

    tva f(Activity activity, tva.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, wsa wsaVar);

    uva h(Activity activity, PayUIKitConfig payUIKitConfig, uva.b bVar, wsa wsaVar);
}
