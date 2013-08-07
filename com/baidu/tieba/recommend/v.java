package com.baidu.tieba.recommend;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendFragment f1678a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(DailyRecommendFragment dailyRecommendFragment) {
        this.f1678a = dailyRecommendFragment;
    }

    @Override // com.baidu.tieba.recommend.y
    public void a() {
    }

    @Override // com.baidu.tieba.recommend.y
    public void a(boolean z, String str, com.baidu.tieba.data.n nVar, int i) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ab abVar4;
        abVar = this.f1678a.c;
        abVar.a(true, "");
        if (z) {
            abVar3 = this.f1678a.c;
            abVar3.a(nVar);
            handler = this.f1678a.e;
            runnable = this.f1678a.f;
            handler.removeCallbacks(runnable);
            handler2 = this.f1678a.e;
            runnable2 = this.f1678a.f;
            handler2.postDelayed(runnable2, 0L);
            if (i == 0) {
                abVar4 = this.f1678a.c;
                abVar4.e();
            }
        } else {
            abVar2 = this.f1678a.c;
            abVar2.a((com.baidu.tieba.data.n) null);
            if (i != 1) {
                if (str.equals("70000")) {
                    this.f1678a.a("已经无新数据了");
                } else {
                    this.f1678a.a("获取数据失败");
                }
            }
        }
        if (i == 1) {
            this.f1678a.a(true, (String) null);
        }
    }
}
