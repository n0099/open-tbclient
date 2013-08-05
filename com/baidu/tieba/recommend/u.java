package com.baidu.tieba.recommend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendFragment f1679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(DailyRecommendFragment dailyRecommendFragment) {
        this.f1679a = dailyRecommendFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        ab abVar;
        try {
            abVar = this.f1679a.c;
            abVar.f();
        } catch (Exception e) {
            str = this.f1679a.b;
            com.baidu.tieba.util.aj.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
