package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.tgb;
import com.baidu.tieba.ugb;
import com.baidu.tieba.vgb;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes6.dex */
public interface ndb {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, kdb kdbVar);

    rgb b(Activity activity);

    qgb c(Activity activity);

    sgb d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, kdb kdbVar);

    tgb f(Activity activity, tgb.b bVar, PayUIKitConfig payUIKitConfig);

    vgb g(Activity activity, vgb.b bVar, pdb pdbVar);

    ugb h(Activity activity, PayUIKitConfig payUIKitConfig, ugb.b bVar, pdb pdbVar);
}
