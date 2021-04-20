package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public final class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22794a;

    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.f22794a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        int i;
        FeedbackInputActivity feedbackInputActivity = this.f22794a;
        if (feedbackInputActivity.D) {
            return;
        }
        if (feedbackInputActivity.p.getVisibility() == 0) {
            linearLayout = this.f22794a.p;
            i = 8;
        } else {
            if (this.f22794a.p.getChildCount() <= 0) {
                this.f22794a.a(true);
            }
            linearLayout = this.f22794a.p;
            i = 0;
        }
        linearLayout.setVisibility(i);
        this.f22794a.C.setVisibility(i);
    }
}
