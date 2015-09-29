package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* loaded from: classes.dex */
class k implements o.a {
    final /* synthetic */ BackgroundListActivity dfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BackgroundListActivity backgroundListActivity) {
        this.dfb = backgroundListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.o.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        rVar = this.dfb.deZ;
        rVar.azo();
        BackgroundListActivity backgroundListActivity = this.dfb;
        rVar2 = this.dfb.deZ;
        backgroundListActivity.hideLoadingView(rVar2.getRootView());
        if (i == 0) {
            rVar3 = this.dfb.deZ;
            rVar3.a(kVar, list);
            return;
        }
        this.dfb.showToast(str);
        rVar4 = this.dfb.deZ;
        rVar4.Kr();
    }
}
