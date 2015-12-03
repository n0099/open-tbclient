package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class b implements BdListView.e {
    final /* synthetic */ BubbleListActivity dFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BubbleListActivity bubbleListActivity) {
        this.dFL = bubbleListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        e eVar;
        e eVar2;
        eVar = this.dFL.dFI;
        if (eVar != null) {
            eVar2 = this.dFL.dFI;
            eVar2.aFr();
        }
    }
}
