package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class bv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f3789a;
    final /* synthetic */ PopupWindow b;
    final /* synthetic */ FeedbackInputActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        this.c = feedbackInputActivity;
        this.f3789a = view;
        this.b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((ClipboardManager) this.c.getSystemService("clipboard")).setText(((TextView) this.f3789a).getText().toString());
        this.b.dismiss();
    }
}
