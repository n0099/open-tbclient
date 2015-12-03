package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class c implements q.a {
    final /* synthetic */ BubbleListActivity dFL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BubbleListActivity bubbleListActivity) {
        this.dFL = bubbleListActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        e eVar;
        e eVar2;
        eVar = this.dFL.dFI;
        if (eVar != null) {
            eVar2 = this.dFL.dFI;
            eVar2.LoadData();
        }
    }
}
