package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
final class f implements Runnable {
    final /* synthetic */ DailyRecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DailyRecommendActivity dailyRecommendActivity) {
        this.a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        z zVar;
        try {
            zVar = this.a.c;
            zVar.g();
        } catch (Exception e) {
            str = this.a.b;
            com.baidu.adp.lib.util.e.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
