package com.baidu.tieba.themeCenter.background;

import com.baidu.tieba.themeCenter.background.d;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ BackgroundGroupActivity dEl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BackgroundGroupActivity backgroundGroupActivity) {
        this.dEl = backgroundGroupActivity;
    }

    @Override // com.baidu.tieba.themeCenter.background.d.a
    public void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list) {
        g gVar;
        g gVar2;
        g gVar3;
        d dVar;
        g gVar4;
        BackgroundGroupActivity backgroundGroupActivity = this.dEl;
        gVar = this.dEl.dEi;
        backgroundGroupActivity.hideLoadingView(gVar.getRootView());
        gVar2 = this.dEl.dEi;
        gVar2.aFq();
        if (i == 0) {
            gVar3 = this.dEl.dEi;
            dVar = this.dEl.dEh;
            gVar3.a(kVar, list, dVar.azO());
            return;
        }
        this.dEl.showToast(str);
        gVar4 = this.dEl.dEi;
        gVar4.LY();
    }
}
