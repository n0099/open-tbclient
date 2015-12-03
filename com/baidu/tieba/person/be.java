package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class be implements BdListView.e {
    final /* synthetic */ ax cLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ax axVar) {
        this.cLg = axVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bg bgVar;
        z = this.cLg.cLc;
        if (!z) {
            this.cLg.cLb = false;
            ax axVar = this.cLg;
            bgVar = this.cLg.cKX;
            axVar.pageNum = bgVar.getData().getPage().sd() + 1;
            this.cLg.cLc = true;
            this.cLg.anM();
        }
    }
}
