package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.ehc;
import com.baidu.tieba.fhc;
import com.baidu.tieba.ghc;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes8.dex */
public interface ydc {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, vdc vdcVar);

    chc b(Activity activity);

    bhc c(Activity activity);

    dhc d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, vdc vdcVar);

    ehc f(Activity activity, ehc.b bVar, PayUIKitConfig payUIKitConfig);

    ghc g(Activity activity, ghc.b bVar, aec aecVar);

    fhc h(Activity activity, PayUIKitConfig payUIKitConfig, fhc.b bVar, aec aecVar);
}
