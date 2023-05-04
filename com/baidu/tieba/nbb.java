package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.meb;
import com.baidu.tieba.neb;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
/* loaded from: classes5.dex */
public interface nbb {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, lbb lbbVar);

    keb b(Activity activity);

    jeb c(Activity activity);

    leb d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, lbb lbbVar);

    meb f(Activity activity, meb.b bVar, PayUIKitConfig payUIKitConfig);

    IYYPayWayView g(Activity activity, IYYPayWayView.b bVar, pbb pbbVar);

    neb h(Activity activity, PayUIKitConfig payUIKitConfig, neb.b bVar, pbb pbbVar);
}
