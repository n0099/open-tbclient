package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class bv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f22862a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f22863b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22864c;

    public bv(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        this.f22864c = feedbackInputActivity;
        this.f22862a = view;
        this.f22863b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((ClipboardManager) this.f22864c.getSystemService("clipboard")).setText(((TextView) this.f22862a).getText().toString());
        this.f22863b.dismiss();
    }
}
