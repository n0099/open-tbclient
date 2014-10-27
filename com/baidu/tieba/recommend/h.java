package com.baidu.tieba.recommend;

import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements q {
    final /* synthetic */ DailyRecommendActivity bHW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(DailyRecommendActivity dailyRecommendActivity) {
        this.bHW = dailyRecommendActivity;
    }

    @Override // com.baidu.tieba.recommend.q
    public void abJ() {
    }

    @Override // com.baidu.tieba.recommend.q
    public void a(boolean z, String str, com.baidu.tieba.data.l lVar, int i, boolean z2) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        rVar = this.bHW.bHS;
        rVar.d(true, "");
        if (z) {
            rVar3 = this.bHW.bHS;
            rVar3.a(lVar, z2);
            if (i == 0) {
                rVar4 = this.bHW.bHS;
                rVar4.abL();
            }
        } else {
            rVar2 = this.bHW.bHS;
            rVar2.a(null, z2);
            if (i != 1) {
                if ("70000".equals(str)) {
                    this.bHW.showToast(y.no_more_data);
                } else {
                    this.bHW.showToast(y.neterror);
                }
            }
        }
        if (i == 1) {
            this.bHW.g(true, null);
        }
    }
}
