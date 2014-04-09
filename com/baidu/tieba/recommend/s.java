package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements View.OnClickListener {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DailyRecommendActivity dailyRecommendActivity;
        dailyRecommendActivity = this.a.a;
        dailyRecommendActivity.a();
    }
}
