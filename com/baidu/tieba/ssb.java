package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tieba.awb;
import com.baidu.tieba.yvb;
import com.baidu.tieba.zvb;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
/* loaded from: classes7.dex */
public interface ssb {
    IYYPayAmountView a(Activity activity, IYYPayAmountView.ViewParams viewParams, psb psbVar);

    wvb b(Activity activity);

    vvb c(Activity activity);

    xvb d(Activity activity);

    IYYPayResultView e(Activity activity, IYYPayResultView.c cVar, psb psbVar);

    yvb f(Activity activity, yvb.b bVar, PayUIKitConfig payUIKitConfig);

    awb g(Activity activity, awb.b bVar, usb usbVar);

    zvb h(Activity activity, PayUIKitConfig payUIKitConfig, zvb.b bVar, usb usbVar);
}
