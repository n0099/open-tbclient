package com.baidu.tieba.recommend;

import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendActivity f2292a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DailyRecommendActivity dailyRecommendActivity) {
        this.f2292a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        z zVar;
        try {
            zVar = this.f2292a.c;
            zVar.h();
        } catch (Exception e) {
            str = this.f2292a.b;
            bg.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
