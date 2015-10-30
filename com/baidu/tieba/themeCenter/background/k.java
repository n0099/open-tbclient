package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* loaded from: classes.dex */
class k implements o.a {
    final /* synthetic */ BackgroundListActivity dfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BackgroundListActivity backgroundListActivity) {
        this.dfB = backgroundListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.o.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        rVar = this.dfB.dfz;
        rVar.azu();
        BackgroundListActivity backgroundListActivity = this.dfB;
        rVar2 = this.dfB.dfz;
        backgroundListActivity.hideLoadingView(rVar2.getRootView());
        if (i == 0) {
            rVar3 = this.dfB.dfz;
            rVar3.a(kVar, list);
            return;
        }
        this.dfB.showToast(str);
        rVar4 = this.dfB.dfz;
        rVar4.Kn();
    }
}
