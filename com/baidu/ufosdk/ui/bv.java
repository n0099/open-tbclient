package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class bv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f23503a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f23504b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23505c;

    public bv(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        this.f23505c = feedbackInputActivity;
        this.f23503a = view;
        this.f23504b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((ClipboardManager) this.f23505c.getSystemService("clipboard")).setText(((TextView) this.f23503a).getText().toString());
        this.f23504b.dismiss();
    }
}
