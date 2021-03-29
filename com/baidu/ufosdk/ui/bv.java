package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class bv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f23100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f23101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23102c;

    public bv(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        this.f23102c = feedbackInputActivity;
        this.f23100a = view;
        this.f23101b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((ClipboardManager) this.f23102c.getSystemService("clipboard")).setText(((TextView) this.f23100a).getText().toString());
        this.f23101b.dismiss();
    }
}
