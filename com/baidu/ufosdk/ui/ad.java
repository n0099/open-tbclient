package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
public final class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22698a;

    public ad(FeedbackEditActivity feedbackEditActivity) {
        this.f22698a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f22698a.v;
        if (z) {
            return;
        }
        list = this.f22698a.q;
        if (list.size() >= 3) {
            FeedbackEditActivity.a(this.f22698a, 3);
        }
    }
}
