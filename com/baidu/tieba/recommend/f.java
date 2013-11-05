package com.baidu.tieba.recommend;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendActivity f2276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DailyRecommendActivity dailyRecommendActivity) {
        this.f2276a = dailyRecommendActivity;
    }

    @Override // com.baidu.tieba.recommend.y
    public void a() {
    }

    @Override // com.baidu.tieba.recommend.y
    public void a(boolean z, String str, com.baidu.tieba.data.o oVar, int i) {
        z zVar;
        z zVar2;
        z zVar3;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        z zVar4;
        zVar = this.f2276a.c;
        zVar.a(true, "");
        if (z) {
            zVar3 = this.f2276a.c;
            zVar3.a(oVar);
            handler = this.f2276a.e;
            runnable = this.f2276a.f;
            handler.removeCallbacks(runnable);
            handler2 = this.f2276a.e;
            runnable2 = this.f2276a.f;
            handler2.postDelayed(runnable2, 0L);
            if (i == 0) {
                zVar4 = this.f2276a.c;
                zVar4.g();
            }
        } else {
            zVar2 = this.f2276a.c;
            zVar2.a((com.baidu.tieba.data.o) null);
            if (i != 1) {
                if (str.equals("70000")) {
                    this.f2276a.a("已经无新数据了");
                } else {
                    this.f2276a.a("获取数据失败");
                }
            }
        }
        if (i == 1) {
            this.f2276a.a(true, (String) null);
        }
    }
}
