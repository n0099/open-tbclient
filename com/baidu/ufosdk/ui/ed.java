package com.baidu.ufosdk.ui;

import android.widget.Button;
/* loaded from: classes5.dex */
public final class ed implements ey {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22785a;

    public ed(FeedbackReportActivity feedbackReportActivity) {
        this.f22785a = feedbackReportActivity;
    }

    @Override // com.baidu.ufosdk.ui.ey
    public final void a(String str) {
        Button button;
        this.f22785a.F = str;
        button = this.f22785a.m;
        int i2 = com.baidu.ufosdk.b.v;
        int i3 = com.baidu.ufosdk.b.y;
        int i4 = com.baidu.ufosdk.b.v;
        button.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
    }
}
