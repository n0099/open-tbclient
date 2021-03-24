package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes5.dex */
public final class df implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f23170a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23171b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f23172c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f23173d;

    public df(FeedbackListActivity feedbackListActivity, Context context, String str, String str2) {
        this.f23173d = feedbackListActivity;
        this.f23170a = context;
        this.f23171b = str;
        this.f23172c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        view2 = this.f23173d.w;
        view2.setVisibility(0);
        new Thread(new dg(this)).start();
        popupWindow = this.f23173d.z;
        if (popupWindow.isShowing()) {
            popupWindow2 = this.f23173d.z;
            popupWindow2.dismiss();
        }
    }
}
