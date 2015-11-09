package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* loaded from: classes.dex */
class k implements o.a {
    final /* synthetic */ BackgroundListActivity dhh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BackgroundListActivity backgroundListActivity) {
        this.dhh = backgroundListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.o.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        rVar = this.dhh.dhf;
        rVar.aAk();
        BackgroundListActivity backgroundListActivity = this.dhh;
        rVar2 = this.dhh.dhf;
        backgroundListActivity.hideLoadingView(rVar2.getRootView());
        if (i == 0) {
            rVar3 = this.dhh.dhf;
            rVar3.a(kVar, list);
            return;
        }
        this.dhh.showToast(str);
        rVar4 = this.dhh.dhf;
        rVar4.KD();
    }
}
