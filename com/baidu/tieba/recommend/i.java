package com.baidu.tieba.recommend;

import android.os.Handler;
/* loaded from: classes.dex */
final class i implements aa {
    final /* synthetic */ DailyRecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(DailyRecommendActivity dailyRecommendActivity) {
        this.a = dailyRecommendActivity;
    }

    @Override // com.baidu.tieba.recommend.aa
    public final void a(boolean z, String str, com.baidu.tieba.data.k kVar, int i) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        ab abVar4;
        abVar = this.a.c;
        abVar.a(true, "");
        if (z) {
            abVar3 = this.a.c;
            abVar3.a(kVar);
            handler = this.a.e;
            runnable = this.a.f;
            handler.removeCallbacks(runnable);
            handler2 = this.a.e;
            runnable2 = this.a.f;
            handler2.postDelayed(runnable2, 0L);
            if (i == 0) {
                abVar4 = this.a.c;
                abVar4.f();
            }
        } else {
            abVar2 = this.a.c;
            abVar2.a((com.baidu.tieba.data.k) null);
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
