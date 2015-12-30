package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class be implements BdListView.e {
    final /* synthetic */ ax cPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ax axVar) {
        this.cPw = axVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bg bgVar;
        z = this.cPw.cPs;
        if (!z) {
            this.cPw.cPr = false;
            ax axVar = this.cPw;
            bgVar = this.cPw.cPn;
            axVar.pageNum = bgVar.getData().getPage().rM() + 1;
            this.cPw.cPs = true;
            this.cPw.aoX();
        }
    }
}
