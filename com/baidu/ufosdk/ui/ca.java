package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public final class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22871a;

    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.f22871a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        int i2;
        FeedbackInputActivity feedbackInputActivity = this.f22871a;
        if (feedbackInputActivity.D) {
            return;
        }
        if (feedbackInputActivity.p.getVisibility() == 0) {
            linearLayout = this.f22871a.p;
            i2 = 8;
        } else {
            if (this.f22871a.p.getChildCount() <= 0) {
                this.f22871a.a(true);
            }
            linearLayout = this.f22871a.p;
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        this.f22871a.C.setVisibility(i2);
    }
}
