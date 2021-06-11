package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* loaded from: classes5.dex */
public final class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22728a;

    public ab(FeedbackEditActivity feedbackEditActivity) {
        this.f22728a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f22728a.v;
        if (z) {
            return;
        }
        list = this.f22728a.q;
        if (list.size() > 0) {
            FeedbackEditActivity.a(this.f22728a, 1);
        }
    }
}
