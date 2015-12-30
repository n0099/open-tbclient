package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* loaded from: classes.dex */
class k implements o.a {
    final /* synthetic */ BackgroundListActivity dMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BackgroundListActivity backgroundListActivity) {
        this.dMn = backgroundListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.o.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        r rVar;
        r rVar2;
        r rVar3;
        o oVar;
        r rVar4;
        rVar = this.dMn.dMl;
        rVar.aHJ();
        BackgroundListActivity backgroundListActivity = this.dMn;
        rVar2 = this.dMn.dMl;
        backgroundListActivity.hideLoadingView(rVar2.getRootView());
        if (i == 0) {
            rVar3 = this.dMn.dMl;
            oVar = this.dMn.dMk;
            rVar3.a(kVar, list, oVar.aHH());
            return;
        }
        this.dMn.showToast(str);
        rVar4 = this.dMn.dMl;
        rVar4.Mr();
    }
}
