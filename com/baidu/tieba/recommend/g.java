package com.baidu.tieba.recommend;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements y {
    final /* synthetic */ DailyRecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(DailyRecommendActivity dailyRecommendActivity) {
        this.a = dailyRecommendActivity;
    }

    @Override // com.baidu.tieba.recommend.y
    public void a() {
    }

    @Override // com.baidu.tieba.recommend.y
    public void a(boolean z, String str, com.baidu.tieba.data.p pVar, int i) {
        z zVar;
        z zVar2;
        z zVar3;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        z zVar4;
        zVar = this.a.c;
        zVar.a(true, "");
        if (z) {
            zVar3 = this.a.c;
            zVar3.a(pVar);
            handler = this.a.e;
            runnable = this.a.f;
            handler.removeCallbacks(runnable);
            handler2 = this.a.e;
            runnable2 = this.a.f;
            handler2.postDelayed(runnable2, 0L);
            if (i == 0) {
                zVar4 = this.a.c;
                zVar4.g();
            }
        } else {
            zVar2 = this.a.c;
            zVar2.a((com.baidu.tieba.data.p) null);
            if (i != 1) {
                if (str.equals("70000")) {
                    this.a.showToast("已经无新数据了");
                } else {
                    this.a.showToast("获取数据失败");
                }
            }
        }
        if (i == 1) {
            this.a.a(true, (String) null);
        }
    }
}
