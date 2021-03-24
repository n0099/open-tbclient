package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class bv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f23099a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f23100b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23101c;

    public bv(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        this.f23101c = feedbackInputActivity;
        this.f23099a = view;
        this.f23100b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((ClipboardManager) this.f23101c.getSystemService("clipboard")).setText(((TextView) this.f23099a).getText().toString());
        this.f23100b.dismiss();
    }
}
