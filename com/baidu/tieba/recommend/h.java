package com.baidu.tieba.recommend;

import com.baidu.tieba.x;
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
    public void a(boolean z, String str, com.baidu.tieba.data.l lVar, int i, boolean z2) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        rVar = this.a.b;
        rVar.a(true, "");
        if (z) {
            rVar3 = this.a.b;
            rVar3.a(lVar, z2);
            if (i == 0) {
                rVar4 = this.a.b;
                rVar4.d();
            }
        } else {
            rVar2 = this.a.b;
            rVar2.a((com.baidu.tieba.data.l) null, z2);
            if (i != 1) {
                if ("70000".equals(str)) {
                    this.a.showToast(x.no_more_data);
                } else {
                    this.a.showToast(x.neterror);
                }
            }
        }
        if (i == 1) {
            this.a.a(true, (String) null);
        }
    }
}
