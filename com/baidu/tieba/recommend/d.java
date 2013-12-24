package com.baidu.tieba.recommend;

import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DailyRecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DailyRecommendActivity dailyRecommendActivity) {
        this.a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        y yVar;
        try {
            yVar = this.a.c;
            yVar.h();
        } catch (Exception e) {
            str = this.a.b;
            be.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
