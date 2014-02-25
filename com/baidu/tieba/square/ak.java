package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.recommend.DailyRecommendActivity;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String a = am.a("post_recommend", "all");
        context = this.a.b;
        DailyRecommendActivity.a(context, a);
    }
}
