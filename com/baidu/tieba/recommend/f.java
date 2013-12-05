package com.baidu.tieba.recommend;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyRecommendActivity f2411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(DailyRecommendActivity dailyRecommendActivity) {
        this.f2411a = dailyRecommendActivity;
    }

    @Override // com.baidu.tieba.recommend.x
    public void a() {
    }

    @Override // com.baidu.tieba.recommend.x
    public void a(boolean z, String str, com.baidu.tieba.data.o oVar, int i) {
        y yVar;
        y yVar2;
        y yVar3;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        y yVar4;
        yVar = this.f2411a.c;
        yVar.a(true, "");
        if (z) {
            yVar3 = this.f2411a.c;
            yVar3.a(oVar);
            handler = this.f2411a.e;
            runnable = this.f2411a.f;
            handler.removeCallbacks(runnable);
            handler2 = this.f2411a.e;
            runnable2 = this.f2411a.f;
            handler2.postDelayed(runnable2, 0L);
            if (i == 0) {
                yVar4 = this.f2411a.c;
                yVar4.g();
            }
        } else {
            yVar2 = this.f2411a.c;
            yVar2.a((com.baidu.tieba.data.o) null);
            if (i != 1) {
                if (str.equals("70000")) {
                    this.f2411a.showToast("已经无新数据了");
                } else {
                    this.f2411a.showToast("获取数据失败");
                }
            }
        }
        if (i == 1) {
            this.f2411a.a(true, (String) null);
        }
    }
}
