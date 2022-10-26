package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFinishInfo;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes6.dex */
public interface v3a {
    void a(Activity activity, IYYPayWayView.b bVar, IPayCallback iPayCallback);

    void b(int i, String str, PayCallBackBean payCallBackBean);

    void c(CancelType cancelType, AbsViewEventHandler absViewEventHandler);

    void d(Activity activity, h5a h5aVar, e5a e5aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback iPayCallback);

    void e(Activity activity, IPayCallback iPayCallback, IYYPayAmountView.ViewParams viewParams);

    void g(PayFinishInfo payFinishInfo);

    void h(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType);

    void i(Activity activity, List list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback);

    void j();

    boolean k(Activity activity, IYYPayResultView iYYPayResultView, AbsViewEventHandler absViewEventHandler);

    boolean m(Activity activity, IYYPayWayView iYYPayWayView, AbsViewEventHandler absViewEventHandler);

    void n(Activity activity, e5a e5aVar, List list, String str, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback);

    void o(Activity activity);

    PayDialogType p();

    void refreshWindow(WindowParams windowParams);

    void release();
}
