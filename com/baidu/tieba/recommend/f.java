package com.baidu.tieba.recommend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ DailyRecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DailyRecommendActivity dailyRecommendActivity) {
        this.a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        z zVar;
        try {
            zVar = this.a.c;
            zVar.h();
        } catch (Exception e) {
            str = this.a.b;
            com.baidu.adp.lib.util.f.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
