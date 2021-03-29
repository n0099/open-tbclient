package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes5.dex */
public final class df implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f23171a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23172b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f23173c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f23174d;

    public df(FeedbackListActivity feedbackListActivity, Context context, String str, String str2) {
        this.f23174d = feedbackListActivity;
        this.f23171a = context;
        this.f23172b = str;
        this.f23173c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        view2 = this.f23174d.w;
        view2.setVisibility(0);
        new Thread(new dg(this)).start();
        popupWindow = this.f23174d.z;
        if (popupWindow.isShowing()) {
            popupWindow2 = this.f23174d.z;
            popupWindow2.dismiss();
        }
    }
}
