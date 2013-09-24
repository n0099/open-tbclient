package com.baidu.tieba.recommend;

import com.baidu.tieba.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendActivity f1756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DailyRecommendActivity dailyRecommendActivity) {
        this.f1756a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        z zVar;
        try {
            zVar = this.f1756a.c;
            zVar.f();
        } catch (Exception e) {
            str = this.f1756a.b;
            av.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
