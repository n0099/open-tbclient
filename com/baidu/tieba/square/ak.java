package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.recommend.DailyRecommendActivity;
/* loaded from: classes.dex */
class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2380a;
    final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, Context context) {
        this.b = ajVar;
        this.f2380a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DailyRecommendActivity.a(this.f2380a, SquareActivity.a("post_recommend", "all"));
    }
}
