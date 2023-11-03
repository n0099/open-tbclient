package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.bbd;
import com.baidu.tieba.cbd;
import com.baidu.tieba.dbd;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes8.dex */
public interface v7d {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, s7d s7dVar);

    zad b(Activity activity);

    yad c(Activity activity);

    abd d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, s7d s7dVar);

    bbd f(Activity activity, bbd.b bVar, PayUIKitConfig payUIKitConfig);

    dbd g(Activity activity, dbd.b bVar, x7d x7dVar);

    cbd h(Activity activity, PayUIKitConfig payUIKitConfig, cbd.b bVar, x7d x7dVar);
}
