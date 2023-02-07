package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.ula;
import com.baidu.tieba.vla;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes6.dex */
public interface via {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, tia tiaVar);

    sla b(Activity activity);

    rla c(Activity activity);

    tla d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, tia tiaVar);

    ula f(Activity activity, ula.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, xia xiaVar);

    vla h(Activity activity, PayUIKitConfig payUIKitConfig, vla.b bVar, xia xiaVar);
}
