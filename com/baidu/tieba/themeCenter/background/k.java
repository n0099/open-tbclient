package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.o;
import java.util.List;
/* loaded from: classes.dex */
class k implements o.a {
    final /* synthetic */ BackgroundListActivity dEK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BackgroundListActivity backgroundListActivity) {
        this.dEK = backgroundListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.o.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        r rVar;
        r rVar2;
        r rVar3;
        o oVar;
        r rVar4;
        rVar = this.dEK.dEI;
        rVar.aFu();
        BackgroundListActivity backgroundListActivity = this.dEK;
        rVar2 = this.dEK.dEI;
        backgroundListActivity.hideLoadingView(rVar2.getRootView());
        if (i == 0) {
            rVar3 = this.dEK.dEI;
            oVar = this.dEK.dEH;
            rVar3.a(kVar, list, oVar.aFs());
            return;
        }
        this.dEK.showToast(str);
        rVar4 = this.dEK.dEI;
        rVar4.LY();
    }
}
