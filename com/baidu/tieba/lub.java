package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.rxb;
import com.baidu.tieba.sxb;
import com.baidu.tieba.txb;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes6.dex */
public interface lub {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, iub iubVar);

    pxb b(Activity activity);

    oxb c(Activity activity);

    qxb d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, iub iubVar);

    rxb f(Activity activity, rxb.b bVar, PayUIKitConfig payUIKitConfig);

    txb g(Activity activity, txb.b bVar, nub nubVar);

    sxb h(Activity activity, PayUIKitConfig payUIKitConfig, sxb.b bVar, nub nubVar);
}
