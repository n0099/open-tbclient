package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public final class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22789a;

    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.f22789a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        int i2;
        FeedbackInputActivity feedbackInputActivity = this.f22789a;
        if (feedbackInputActivity.D) {
            return;
        }
        if (feedbackInputActivity.p.getVisibility() == 0) {
            linearLayout = this.f22789a.p;
            i2 = 8;
        } else {
            if (this.f22789a.p.getChildCount() <= 0) {
                this.f22789a.a(true);
            }
            linearLayout = this.f22789a.p;
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        this.f22789a.C.setVisibility(i2);
    }
}
