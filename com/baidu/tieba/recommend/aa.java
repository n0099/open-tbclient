package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements View.OnClickListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DailyRecommendActivity dailyRecommendActivity;
        dailyRecommendActivity = this.a.a;
        dailyRecommendActivity.a();
    }
}
