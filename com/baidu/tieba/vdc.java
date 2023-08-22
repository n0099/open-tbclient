package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.tieba.ehc;
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
/* loaded from: classes8.dex */
public interface vdc {
    void a(Activity activity, nfc nfcVar, List<PayWayInfo> list, String str, PaySplitOrderViewSource paySplitOrderViewSource, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void b(boolean z);

    boolean c(Activity activity, AbsViewEventHandler absViewEventHandler);

    void d(Activity activity, ehc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void e(int i, String str, PayCallBackBean payCallBackBean);

    void g(CancelType cancelType, AbsViewEventHandler absViewEventHandler);

    ydc h();

    void j(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams);

    void k(Activity activity, rfc rfcVar, nfc nfcVar, Dialog dialog, xgc xgcVar, AppCustomExpand appCustomExpand, ehc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void l(PayFinishInfo payFinishInfo);

    void m(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType);

    void n(Activity activity, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void p(Activity activity, nfc nfcVar, rfc rfcVar, Dialog dialog, xgc xgcVar, AppCustomExpand appCustomExpand, ehc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void q(Activity activity, String str);

    void r(ygc ygcVar, Dialog dialog);

    void refreshWindow(WindowParams windowParams);

    boolean s(Activity activity, ehc ehcVar, AbsViewEventHandler absViewEventHandler);

    void t(Activity activity, nfc nfcVar, List<PayWayInfo> list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback);

    void u(Activity activity);

    PayDialogType v();
}
