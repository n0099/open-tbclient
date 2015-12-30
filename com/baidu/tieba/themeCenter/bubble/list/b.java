package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class b implements BdListView.e {
    final /* synthetic */ BubbleListActivity dNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BubbleListActivity bubbleListActivity) {
        this.dNn = bubbleListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        e eVar;
        e eVar2;
        eVar = this.dNn.dNk;
        if (eVar != null) {
            eVar2 = this.dNn.dNk;
            eVar2.aHG();
        }
    }
}
