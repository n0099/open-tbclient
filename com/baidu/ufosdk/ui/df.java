package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes5.dex */
public final class df implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f22856a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22857b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f22858c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22859d;

    public df(FeedbackListActivity feedbackListActivity, Context context, String str, String str2) {
        this.f22859d = feedbackListActivity;
        this.f22856a = context;
        this.f22857b = str;
        this.f22858c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        view2 = this.f22859d.w;
        view2.setVisibility(0);
        new Thread(new dg(this)).start();
        popupWindow = this.f22859d.z;
        if (popupWindow.isShowing()) {
            popupWindow2 = this.f22859d.z;
            popupWindow2.dismiss();
        }
    }
}
