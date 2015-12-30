package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class c implements r.a {
    final /* synthetic */ BubbleListActivity dNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BubbleListActivity bubbleListActivity) {
        this.dNn = bubbleListActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        e eVar;
        e eVar2;
        eVar = this.dNn.dNk;
        if (eVar != null) {
            eVar2 = this.dNn.dNk;
            eVar2.LoadData();
        }
    }
}
