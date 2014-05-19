package com.baidu.tieba.recommend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements q {
    final /* synthetic */ DailyRecommendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(DailyRecommendActivity dailyRecommendActivity) {
        this.a = dailyRecommendActivity;
    }

    @Override // com.baidu.tieba.recommend.q
    public void a() {
    }

    @Override // com.baidu.tieba.recommend.q
    public void a(boolean z, String str, com.baidu.tieba.data.k kVar, int i) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        rVar = this.a.b;
        rVar.a(true, "");
        if (z) {
            rVar3 = this.a.b;
            rVar3.a(kVar);
            if (i == 0) {
                rVar4 = this.a.b;
                rVar4.d();
            }
        } else {
            rVar2 = this.a.b;
            rVar2.a((com.baidu.tieba.data.k) null);
            if (i != 1) {
                if (str.equals("70000")) {
                    this.a.showToast("已经无新数据了");
                } else {
                    this.a.showToast("获取数据失败");
                }
            }
        }
        if (i == 1) {
            this.a.a(true, (String) null);
        }
    }
}
