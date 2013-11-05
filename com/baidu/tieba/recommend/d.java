package com.baidu.tieba.recommend;

import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendActivity f2274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DailyRecommendActivity dailyRecommendActivity) {
        this.f2274a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        z zVar;
        try {
            zVar = this.f2274a.c;
            zVar.h();
        } catch (Exception e) {
            str = this.f2274a.b;
            be.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
