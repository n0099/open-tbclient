package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.cbd;
import com.baidu.tieba.dbd;
import com.baidu.tieba.ebd;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes8.dex */
public interface w7d {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, t7d t7dVar);

    abd b(Activity activity);

    zad c(Activity activity);

    bbd d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, t7d t7dVar);

    cbd f(Activity activity, cbd.b bVar, PayUIKitConfig payUIKitConfig);

    ebd g(Activity activity, ebd.b bVar, y7d y7dVar);

    dbd h(Activity activity, PayUIKitConfig payUIKitConfig, dbd.b bVar, y7d y7dVar);
}
