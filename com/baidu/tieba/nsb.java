package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.tvb;
import com.baidu.tieba.uvb;
import com.baidu.tieba.vvb;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes7.dex */
public interface nsb {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, ksb ksbVar);

    rvb b(Activity activity);

    qvb c(Activity activity);

    svb d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, ksb ksbVar);

    tvb f(Activity activity, tvb.b bVar, PayUIKitConfig payUIKitConfig);

    vvb g(Activity activity, vvb.b bVar, psb psbVar);

    uvb h(Activity activity, PayUIKitConfig payUIKitConfig, uvb.b bVar, psb psbVar);
}
