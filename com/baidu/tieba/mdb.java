package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.sgb;
import com.baidu.tieba.tgb;
import com.baidu.tieba.ugb;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes6.dex */
public interface mdb {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, jdb jdbVar);

    qgb b(Activity activity);

    pgb c(Activity activity);

    rgb d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, jdb jdbVar);

    sgb f(Activity activity, sgb.b bVar, PayUIKitConfig payUIKitConfig);

    ugb g(Activity activity, ugb.b bVar, odb odbVar);

    tgb h(Activity activity, PayUIKitConfig payUIKitConfig, tgb.b bVar, odb odbVar);
}
