package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes8.dex */
public interface ygc {

    /* loaded from: classes8.dex */
    public interface a {
        void a(CancelType cancelType);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(CancelType cancelType);

        void b();
    }

    GiftBagsInfo a();

    boolean b(Activity activity, b bVar, ahc ahcVar, AbsViewEventHandler absViewEventHandler);

    void c(ViewGroup viewGroup, Activity activity);

    void d(GiftBagsInfo giftBagsInfo);

    boolean e(Activity activity, a aVar, ahc ahcVar, AbsViewEventHandler absViewEventHandler);

    void f(GiftBagsInfo giftBagsInfo);
}
