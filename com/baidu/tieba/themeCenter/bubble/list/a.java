package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.e;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* loaded from: classes.dex */
class a implements e.a {
    final /* synthetic */ BubbleListActivity dNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleListActivity bubbleListActivity) {
        this.dNn = bubbleListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.bubble.list.e.a
    public void a(int i, String str, k kVar, List<DressItemData> list) {
        h hVar;
        h hVar2;
        h hVar3;
        e eVar;
        h hVar4;
        hVar = this.dNn.dNl;
        hVar.aHJ();
        BubbleListActivity bubbleListActivity = this.dNn;
        hVar2 = this.dNn.dNl;
        bubbleListActivity.hideLoadingView(hVar2.getRootView());
        if (i == 0) {
            hVar3 = this.dNn.dNl;
            eVar = this.dNn.dNk;
            hVar3.a(kVar, list, eVar.aHH());
            return;
        }
        this.dNn.showToast(str);
        hVar4 = this.dNn.dNl;
        hVar4.Mr();
    }
}
