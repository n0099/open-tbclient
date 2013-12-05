package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f2429a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f2429a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DailyRecommendActivity dailyRecommendActivity;
        dailyRecommendActivity = this.f2429a.f2428a;
        dailyRecommendActivity.b();
    }
}
