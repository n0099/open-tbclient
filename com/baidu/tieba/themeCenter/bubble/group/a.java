package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.tieba.themeCenter.bubble.group.d;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* loaded from: classes.dex */
class a implements d.a {
    final /* synthetic */ BubbleGroupActivity dNb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleGroupActivity bubbleGroupActivity) {
        this.dNb = bubbleGroupActivity;
    }

    @Override // com.baidu.tieba.themeCenter.bubble.group.d.a
    public void a(int i, String str, k kVar, List<c> list) {
        g gVar;
        g gVar2;
        g gVar3;
        d dVar;
        g gVar4;
        BubbleGroupActivity bubbleGroupActivity = this.dNb;
        gVar = this.dNb.dMY;
        bubbleGroupActivity.hideLoadingView(gVar.getRootView());
        gVar2 = this.dNb.dMY;
        gVar2.aHF();
        if (i == 0) {
            gVar3 = this.dNb.dMY;
            dVar = this.dNb.dMX;
            gVar3.a(kVar, list, dVar.aBV());
            return;
        }
        this.dNb.showToast(str);
        gVar4 = this.dNb.dMY;
        gVar4.Mr();
    }
}
