package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FeedbackEditActivity feedbackEditActivity) {
        this.f3745a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f3745a.v;
        if (z) {
            return;
        }
        list = this.f3745a.q;
        if (list.size() > 0) {
            FeedbackEditActivity.a(this.f3745a, 1);
        }
    }
}
