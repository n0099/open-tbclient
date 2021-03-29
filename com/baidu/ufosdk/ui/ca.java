package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes5.dex */
public final class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23109a;

    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.f23109a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        int i;
        FeedbackInputActivity feedbackInputActivity = this.f23109a;
        if (feedbackInputActivity.D) {
            return;
        }
        if (feedbackInputActivity.p.getVisibility() == 0) {
            linearLayout = this.f23109a.p;
            i = 8;
        } else {
            if (this.f23109a.p.getChildCount() <= 0) {
                this.f23109a.a(true);
            }
            linearLayout = this.f23109a.p;
            i = 0;
        }
        linearLayout.setVisibility(i);
        this.f23109a.C.setVisibility(i);
    }
}
