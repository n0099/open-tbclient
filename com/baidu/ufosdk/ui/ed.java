package com.baidu.ufosdk.ui;

import android.widget.Button;
/* loaded from: classes8.dex */
final class ed implements ey {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(FeedbackReportActivity feedbackReportActivity) {
        this.f5836a = feedbackReportActivity;
    }

    @Override // com.baidu.ufosdk.ui.ey
    public final void a(String str) {
        Button button;
        this.f5836a.F = str;
        button = this.f5836a.m;
        button.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
    }
}
