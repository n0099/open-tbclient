package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
final class h implements Runnable {
    final /* synthetic */ DailyRecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(DailyRecommendActivity dailyRecommendActivity) {
        this.a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        ab abVar;
        try {
            abVar = this.a.c;
            abVar.g();
        } catch (Exception e) {
            str = this.a.b;
            com.baidu.adp.lib.util.f.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
