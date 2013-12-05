package com.baidu.tieba.recommend;

import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendActivity f2409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DailyRecommendActivity dailyRecommendActivity) {
        this.f2409a = dailyRecommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        y yVar;
        try {
            yVar = this.f2409a.c;
            yVar.h();
        } catch (Exception e) {
            str = this.f2409a.b;
            bd.b(str, "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
