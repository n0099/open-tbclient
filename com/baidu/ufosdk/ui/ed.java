package com.baidu.ufosdk.ui;

import android.widget.Button;
/* loaded from: classes7.dex */
final class ed implements ey {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3757a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(FeedbackReportActivity feedbackReportActivity) {
        this.f3757a = feedbackReportActivity;
    }

    @Override // com.baidu.ufosdk.ui.ey
    public final void a(String str) {
        Button button;
        this.f3757a.F = str;
        button = this.f3757a.m;
        button.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
    }
}
