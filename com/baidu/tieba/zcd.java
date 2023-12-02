package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.fgd;
import com.baidu.tieba.ggd;
import com.baidu.tieba.hgd;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes9.dex */
public interface zcd {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, wcd wcdVar);

    dgd b(Activity activity);

    cgd c(Activity activity);

    egd d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, wcd wcdVar);

    fgd f(Activity activity, fgd.b bVar, PayUIKitConfig payUIKitConfig);

    hgd g(Activity activity, hgd.b bVar, bdd bddVar);

    ggd h(Activity activity, PayUIKitConfig payUIKitConfig, ggd.b bVar, bdd bddVar);
}
