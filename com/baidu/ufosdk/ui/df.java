package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class df implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3829a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ FeedbackListActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(FeedbackListActivity feedbackListActivity, Context context, String str, String str2) {
        this.d = feedbackListActivity;
        this.f3829a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        view2 = this.d.w;
        view2.setVisibility(0);
        new Thread(new dg(this)).start();
        popupWindow = this.d.z;
        if (popupWindow.isShowing()) {
            popupWindow2 = this.d.z;
            popupWindow2.dismiss();
        }
    }
}
