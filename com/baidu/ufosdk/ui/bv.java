package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class bv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f22677a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f22678b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22679c;

    public bv(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        this.f22679c = feedbackInputActivity;
        this.f22677a = view;
        this.f22678b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((ClipboardManager) this.f22679c.getSystemService("clipboard")).setText(((TextView) this.f22677a).getText().toString());
        this.f22678b.dismiss();
    }
}
