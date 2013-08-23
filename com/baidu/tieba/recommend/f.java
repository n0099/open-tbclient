package com.baidu.tieba.recommend;

import com.baidu.tieba.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendActivity f1681a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DailyRecommendActivity dailyRecommendActivity) {
        this.f1681a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        z zVar;
        try {
            zVar = this.f1681a.c;
            zVar.f();
        } catch (Exception e) {
            str = this.f1681a.b;
            aq.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
