package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f2267a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.f2267a = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DailyRecommendActivity dailyRecommendActivity;
        dailyRecommendActivity = this.f2267a.f2294a;
        dailyRecommendActivity.c();
    }
}
