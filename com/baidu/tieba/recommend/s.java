package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r bII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.bII = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DailyRecommendActivity dailyRecommendActivity;
        dailyRecommendActivity = this.bII.bID;
        dailyRecommendActivity.abL();
    }
}
