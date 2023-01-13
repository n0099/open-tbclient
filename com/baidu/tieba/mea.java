package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.lha;
import com.baidu.tieba.mha;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes5.dex */
public interface mea {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, kea keaVar);

    jha b(Activity activity);

    iha c(Activity activity);

    kha d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, kea keaVar);

    lha f(Activity activity, lha.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, oea oeaVar);

    mha h(Activity activity, PayUIKitConfig payUIKitConfig, mha.b bVar, oea oeaVar);
}
