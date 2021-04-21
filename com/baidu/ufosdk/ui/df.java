package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes5.dex */
public final class df implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f22864a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22865b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f22866c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22867d;

    public df(FeedbackListActivity feedbackListActivity, Context context, String str, String str2) {
        this.f22867d = feedbackListActivity;
        this.f22864a = context;
        this.f22865b = str;
        this.f22866c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        view2 = this.f22867d.w;
        view2.setVisibility(0);
        new Thread(new dg(this)).start();
        popupWindow = this.f22867d.z;
        if (popupWindow.isShowing()) {
            popupWindow2 = this.f22867d.z;
            popupWindow2.dismiss();
        }
    }
}
