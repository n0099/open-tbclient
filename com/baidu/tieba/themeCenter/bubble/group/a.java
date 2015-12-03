package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.tieba.themeCenter.bubble.group.d;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ BubbleGroupActivity dFz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleGroupActivity bubbleGroupActivity) {
        this.dFz = bubbleGroupActivity;
    }

    @Override // com.baidu.tieba.themeCenter.bubble.group.d.a
    public void a(int i, String str, k kVar, List<c> list) {
        g gVar;
        g gVar2;
        g gVar3;
        d dVar;
        g gVar4;
        BubbleGroupActivity bubbleGroupActivity = this.dFz;
        gVar = this.dFz.dFw;
        bubbleGroupActivity.hideLoadingView(gVar.getRootView());
        gVar2 = this.dFz.dFw;
        gVar2.aFq();
        if (i == 0) {
            gVar3 = this.dFz.dFw;
            dVar = this.dFz.dFv;
            gVar3.a(kVar, list, dVar.azO());
            return;
        }
        this.dFz.showToast(str);
        gVar4 = this.dFz.dFw;
        gVar4.LY();
    }
}
