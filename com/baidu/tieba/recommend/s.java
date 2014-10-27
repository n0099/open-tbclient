package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r bIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.bIu = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DailyRecommendActivity dailyRecommendActivity;
        dailyRecommendActivity = this.bIu.bIp;
        dailyRecommendActivity.abI();
    }
}
