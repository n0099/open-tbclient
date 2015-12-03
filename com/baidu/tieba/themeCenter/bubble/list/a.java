package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.e;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* loaded from: classes.dex */
class a implements e.a {
    final /* synthetic */ BubbleListActivity dFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleListActivity bubbleListActivity) {
        this.dFL = bubbleListActivity;
    }

    @Override // com.baidu.tieba.themeCenter.bubble.list.e.a
    public void a(int i, String str, k kVar, List<DressItemData> list) {
        h hVar;
        h hVar2;
        h hVar3;
        e eVar;
        h hVar4;
        hVar = this.dFL.dFJ;
        hVar.aFu();
        BubbleListActivity bubbleListActivity = this.dFL;
        hVar2 = this.dFL.dFJ;
        bubbleListActivity.hideLoadingView(hVar2.getRootView());
        if (i == 0) {
            hVar3 = this.dFL.dFJ;
            eVar = this.dFL.dFI;
            hVar3.a(kVar, list, eVar.aFs());
            return;
        }
        this.dFL.showToast(str);
        hVar4 = this.dFL.dFJ;
        hVar4.LY();
    }
}
