package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.hgd;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.PaySplitOrderViewSource;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes9.dex */
public interface ycd {
    void a(Activity activity, qed qedVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void b(boolean z);

    boolean c(Activity activity, AbsViewEventHandler absViewEventHandler);

    void d(Activity activity, hgd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void e(int i, String str, PayCallBackBean payCallBackBean);

    void g(CancelType cancelType, AbsViewEventHandler absViewEventHandler);

    bdd h();

    void j(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams);

    void k(Activity activity, ued uedVar, qed qedVar, Dialog dialog, agd agdVar, AppCustomExpand appCustomExpand, hgd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void l(PayFinishInfo payFinishInfo);

    void m(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType);

    void n(Activity activity, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void p(Activity activity, qed qedVar, ued uedVar, Dialog dialog, agd agdVar, AppCustomExpand appCustomExpand, hgd.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void q(Activity activity, String str);

    void r(bgd bgdVar, Dialog dialog);

    void refreshWindow(WindowParams windowParams);

    boolean s(Activity activity, hgd hgdVar, AbsViewEventHandler absViewEventHandler);

    void t(Activity activity, qed qedVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void u(Activity activity);

    PayDialogType v();
}
