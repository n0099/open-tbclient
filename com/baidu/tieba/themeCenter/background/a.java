package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ BackgroundGroupActivity dLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BackgroundGroupActivity backgroundGroupActivity) {
        this.dLP = backgroundGroupActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.d.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list) {
        g gVar;
        g gVar2;
        g gVar3;
        d dVar;
        g gVar4;
        BackgroundGroupActivity backgroundGroupActivity = this.dLP;
        gVar = this.dLP.dLM;
        backgroundGroupActivity.hideLoadingView(gVar.getRootView());
        gVar2 = this.dLP.dLM;
        gVar2.aHF();
        if (i == 0) {
            gVar3 = this.dLP.dLM;
            dVar = this.dLP.dLL;
            gVar3.a(kVar, list, dVar.aBV());
            return;
        }
        this.dLP.showToast(str);
        gVar4 = this.dLP.dLM;
        gVar4.Mr();
    }
}
